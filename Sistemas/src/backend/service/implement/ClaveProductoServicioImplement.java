package backend.service.implement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.ThreadContext;

import backend.service.ClaveProductoServicioService;
import backend.data.notransactional.ClaveProductoServImplement;
import backend.data.transactional.ClaveProductoImplement;
import backend.dto.CClaveProdServCP;

public class ClaveProductoServicioImplement implements ClaveProductoServicioService {

	@Override
	public boolean ClaveProductoServicio(HttpSession ses, HttpServletRequest request, HttpServletResponse response) {
		
		
		Integer opction =Integer.parseInt(request.getParameter("opction"));
		String clave="";
		String descripcion="";
		Integer material=0;
		String msjSuccess="";
		Integer idClave=0;
		ClaveProductoServImplement claveProducto=null;
		CClaveProdServCP claveproductoServ=null;
		ClaveProductoImplement claveProductoImplement=null;
		switch (opction) {
		case 1:
			List<CClaveProdServCP>listClaveProv;
			String msjError="";
			
			try {
				clave=request.getParameter("claveproducto");
			System.out.println("clave:"+clave);
			} catch (NumberFormatException e) {
				System.out.println("entra a error");
				msjError="Solo se aceptan valores a 8 digitos numericos.";
				request.setAttribute("msjError",msjError);
			}
			
			
			
			claveProducto=new ClaveProductoServImplement();
			try {
				
				listClaveProv = claveProducto.claveproducto(clave);
				
				if(listClaveProv.isEmpty()){
					msjError="La claveproducto no se encuentra registrado.";
					request.setAttribute("msjError",msjError);
				}
				else {
					request.setAttribute("lista",listClaveProv);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
      	break;
      	
		case 2:
			clave=request.getParameter("claveproducto");
			
			request.setAttribute("claveproducto",clave);
			break;
		case 3:
			clave=request.getParameter("claveproducto");
			descripcion=request.getParameter("descripcion");
			material = Integer.parseInt(request.getParameter("material"));
			claveProducto=new ClaveProductoServImplement();
			claveproductoServ = new CClaveProdServCP();
			claveProductoImplement=new ClaveProductoImplement();
			Integer row=0;
			Integer rowClave=0;
			try {
				row=claveProducto.existenciaClave(clave);
				if(row == 0){
					
					claveproductoServ.setIdEstatusProceso(10);
					claveproductoServ.setClaveProducto(clave);
					claveproductoServ.setDescripcion(descripcion);
					if(material ==2)
					  claveproductoServ.setMaterialPeligroso("No");
					else
					  claveproductoServ.setMaterialPeligroso(null);
					
					rowClave =claveProductoImplement.insertClaveProducto(claveproductoServ); 
					if(rowClave >0){
						msjSuccess ="Se agrego correctamente.";
						request.setAttribute("msjSuccess", msjSuccess);
					}
					else{
						msjError ="No se registro la clave.";
						request.setAttribute("msjError",msjError);
					}
					
				}
				else {
					msjError="Ya existe una clave producto registrado.";
					request.setAttribute("claveproducto", clave);
					request.setAttribute("descripcion", descripcion);
					request.setAttribute("material", material);
					request.setAttribute("msjError",msjError);
				}
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;
			
		case 4:
			idClave = Integer.parseInt(request.getParameter("id"));
			clave=request.getParameter("claveproducto");
			descripcion=request.getParameter("descripcion");
			material = Integer.parseInt(request.getParameter("material"));
			
			request.setAttribute("idClave", idClave);
			request.setAttribute("claveproducto", clave);
			request.setAttribute("descripcion", descripcion);
			request.setAttribute("material", material);
			
			break;
			
		case 5:
			idClave = Integer.parseInt(request.getParameter("id"));
			clave=request.getParameter("claveproducto");
			descripcion=request.getParameter("descripcion");
			material = Integer.parseInt(request.getParameter("material"));
			claveProducto=new ClaveProductoServImplement();
			claveproductoServ = new CClaveProdServCP();
			claveProductoImplement=new ClaveProductoImplement();
			PrintWriter out = null;
			
			try {
				
				//row=claveProducto.existenciaClave(clave);
				//if(row == 0){
					
					claveproductoServ.setIdCClaveProdServCP(idClave);;
					claveproductoServ.setClaveProducto(clave);
					claveproductoServ.setDescripcion(descripcion);
					if(material ==2)
					  claveproductoServ.setMaterialPeligroso("No");
					else
					  claveproductoServ.setMaterialPeligroso(null);
					
					rowClave =claveProductoImplement.updateClaveProducto(claveproductoServ); 
					if(rowClave >0){
						msjSuccess ="Se actualizo correctamente.";
						//request.setAttribute("msjSuccess", msjSuccess);
						//request.setAttribute("pagina", rowClave);
											
						try {
							out = response.getWriter();
							response.setCharacterEncoding("UTF-8");
							out.println("<div class='alert alert-success' role='alert' >"+msjSuccess+"<button type='button' class='btn btn-link' onclick='viewClavesProducto()' >Regresar</button>" +"</div>");
							out.flush();
							out.close();
						} catch (IOException e) {
							
							//e.printStackTrace();
							
						}
					}
					
					
				//}
//				else {
//					msjError="Ya existe una clave producto registrado.";
//					request.setAttribute("claveproducto", clave);
//					request.setAttribute("descripcion", descripcion);
//					request.setAttribute("material", material);
//					request.setAttribute("msjError",msjError);
//				}
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
				
				try {
					out = response.getWriter();
					
					out.println("<div class='alert alert-danger' role='alert' >"+"No se actualizaron los datos:"+e.getMessage()+"<button type='button' class='btn btn-link' onclick='viewClavesProducto()' >Regresar</button>" +"</div>");
					response.setCharacterEncoding("UTF-8");
					out.flush();
					out.close();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
			break;

		default:
			break;
		}
		
		
		return true;
	}

}
