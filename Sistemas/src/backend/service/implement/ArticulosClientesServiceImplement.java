package backend.service.implement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import backend.data.notransactional.ArticulosClienteImplement;
import backend.dto.ArticulosClientes;
import backend.service.ArticulosClientesService;

public class ArticulosClientesServiceImplement implements ArticulosClientesService {

	@Override
	public boolean articulosClientes(HttpSession ses, HttpServletRequest request, HttpServletResponse response) {
		
				Integer opction =Integer.parseInt(request.getParameter("opction"));	
				ArticulosClienteImplement articulos=null;
				ArticulosClientes productoServ=null;
				PrintWriter out = null;
				JsonObject json = null;
				String msjInfo = "";
				String msjError = "";
				String msjsuccess ="";
				Integer idClientes=-1;
				
				Integer idClaveProducto=-1;
				String claveProducto="";
				String descripcion="";
				Integer addEdit;
		
		switch (opction) {
		case 1: /*CONSULTA ARTICULOS DE CLIENTE REMITENTE/DESTINATARIO*/
			
		//	 idRemitente =Integer.parseInt(request.getParameter("idRemitente"));
			// idDestinatario = Integer.parseInt(request.getParameter("idDestinatario"));
			 addEdit  = Integer.parseInt(request.getParameter("addEdit"));
			
			articulos=new ArticulosClienteImplement();
			List<ArticulosClientes>articulosRemitente;
			List<ArticulosClientes>articulosDestinatario;
			List<ArticulosClientes>listArticulos =new ArrayList<ArticulosClientes>();
			
			
			request.setAttribute("listArticulos", listArticulos);
//	request.setAttribute("idRemitente", idRemitente);
			//request.setAttribute("idDestinatario", idDestinatario);
			request.setAttribute("addEdit", addEdit);
					
			break;
		 
		    case 2: //CONSULTA TIPO DE ARTICULOS CON CODIGO DE EMBALAJE
		    	articulos=new ArticulosClienteImplement();
			try {
				listArticulos = articulos.articulos();
				if(!listArticulos.isEmpty()) {
				request.setAttribute("listArticulos", listArticulos);
				}				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		    	
		   break;    	
		    case 3: /*consulta existencia de clave producto*/
		    	
		    	
			 claveProducto =request.getParameter("claveProducto");
			
		    	articulos=new ArticulosClienteImplement();
		    	productoServ=new ArticulosClientes();
		    	json = new JsonObject();
		    	 
			try {
				if(claveProducto.trim().length() == 8){
					
					productoServ = articulos.claveProducto(claveProducto);
					
					if(productoServ==null){
						
						msjInfo = "No existe registro existente de la clave producto.";						
					}else {
						idClaveProducto = productoServ.getIdClaveProdServCP();
						descripcion  =productoServ.getDescripProducto();
					}
				}
				else {
					msjInfo = "Ingresa la clave producto a 8 dígitos.";
				}
				
				
				try {
					
					json.addProperty("idClave",idClaveProducto);						
					json.addProperty("descripcion", descripcion);	
					json.addProperty("msjInfo",msjInfo);	
					response.setCharacterEncoding("UTF-8");
					out = response.getWriter();
					out.println(json.toString());
					out.flush();
					out.close();	
	
				} catch (IOException e) {
					e.printStackTrace();
					
				}
				
				
			}catch (SQLException e) {
			
				e.printStackTrace();
			}
		    	
		    	
		    	
		    break;
		    				
		    case 4: /*AGREGAR ARTICULOS A CLIENTES*/
		    	
		    	
		    	//idClientes= Integer.parseInt(request.getParameter("idClientes")==null?"-1":request.getParameter("idClientes"));
		    	idClientes = (request.getParameter("idClientes") == null) ? 0 : Integer.parseInt(request.getParameter("idClientes"));
		    	
		    	Integer idTipoArticulo= Integer.parseInt(request.getParameter("idTipoArticulo")==null?"-1":request.getParameter("idTipoArticulo"));
		    	Integer idClaveProductoS= Integer.parseInt(request.getParameter("idClaveProductoS")==null?"-1":request.getParameter("idClaveProductoS"));
		    	Integer idEmpleado= Integer.parseInt(request.getParameter("idEmpleado")==null?"-1":request.getParameter("idEmpleado"));    	
		    	ArticulosClientes codigosClientes= null;
		    	ArticulosClienteImplement articulosCliente=new ArticulosClienteImplement();
		    	Integer idCodigosClientes = 0;
		        Integer idClientesHCodigos =0;
		        ArticulosClientes asigCodigoClientes=null;
		        json = new JsonObject();
		    	
	    		try {
		    	if(idClientes!=-1 && idTipoArticulo!=-1 && idClaveProductoS!=-1 && idEmpleado!=-1){
		    		codigosClientes =new ArticulosClientes(idTipoArticulo,idClaveProductoS,idEmpleado);
		    	
		    			/*EJECUTA SP PARA AGREGAR COMBINACION DE ARTICULO [CLAVE ENBALAJE/NUMERO PRODUCTO SERV]*/
		    			idCodigosClientes =articulosCliente.spiCodigosClientes(codigosClientes);
		    			
		    			if(idCodigosClientes > 0){
		    					
		    				asigCodigoClientes = new ArticulosClientes();
		    				asigCodigoClientes.setIdClientes(idClientes);		    		    	
		    				asigCodigoClientes.setIdCodigosClientes(idCodigosClientes);
		    				
		    				/*EJECUTA SP PAR AGREGAR ARTICULO PRODUCTO AL CLIENTE*/
		    				idClientesHCodigos= articulosCliente.spiClientesHCodigos(asigCodigoClientes);
		    				
		    				if(idClientesHCodigos.equals(-1)){ /*SIN INSERCION ROLLBACK*/
		    					msjError = "Error al agregar el artículo al cliente.";
		    				}
		    				else if(idClientesHCodigos.equals(-2)){
		    				
		    					msjInfo = "El cliente ya tiene asignado el artículo/producto.";
		    					
		    				}
		    				else if(idClientesHCodigos >0){ /*SE ASIGNO AL CLIENTE[REMITENTE/DESTINATARIO]*/				
		    					
		    					msjsuccess ="Articulo agregado al cliente";
		    					
		    				}
		    					    						    				
		    			}else{	    				
		    				msjError="Error no se logró realizar la codificación para el cliente artículo/producto.";
		    				
		    			}	
		    		
		    	}
		    	else {
		    		msjError="No se logró optener algun dato necesario para agregar el artículo.";
		    		
		    	}
		    	} catch (SQLException e) {
					e.printStackTrace();
				
				}
		    	
	    		
    			try {
					json.addProperty("msjInfo",msjInfo);
					json.addProperty("msjError",msjError);
					json.addProperty("msjsuccess",msjsuccess);
					response.setCharacterEncoding("UTF-8");
					out = response.getWriter();
					out.println(json.toString());
					out.flush();
					out.close();
    				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			break;
			
		    case 5: //consultar todos los articulos asignados a los clientes
		    	
		    	articulos=new ArticulosClienteImplement();
				try {
					listArticulos = articulos.selectClientesArticulos();
					if(!listArticulos.isEmpty()) {
					request.setAttribute("listArticulos", listArticulos);
					}				
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			    	
		     
		   break;
		
		
		}
		
		
		return true;
	}

}
