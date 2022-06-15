package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.ThreadContext;
import Reportes.ReporteEfectivo;
import backend.service.implement.ArticulosClientesServiceImplement;
import backend.service.implement.BusquedaServiceImplement;
import backend.service.implement.CalculadoraServiceImplement;
import backend.service.implement.ClaveProductoServicioImplement;
import backend.service.implement.ClientesServiceImplement;
import backend.service.implement.ImpresionServiceImplement;
import PermisosWeb.Consultas.ConsutaUsuariosWeb;

/**
 * Servlet implementation class Controlador
 */
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ses = request.getSession(true);
		String pagina = "";
		boolean success = false;

		try {
			String obj = request.getParameter("obj");
			pagina = request.getParameter("page");
			
			System.err.println("obj1:"+obj +" pagina:"+pagina);
			
			if (!pagina.equals("")) {
				String[] ruta_menu = pagina.split("/");
				System.out.println("ruta_menu[1]:"+ruta_menu[1] +" ruta_menu[2]:"+ruta_menu[2]);
				
				if(ruta_menu[1].equals("Vista")){
					//if(ruta_menu[2].equals("Vista")){
						
						if (obj.equals("inicio")) {
							success=true;
						}
					
					//}
				}
				
				if (ruta_menu[1].equals("Administracion") && ruta_menu[2].equals("Registros")) {
					obj.equals("consultar");
				}

				if (ruta_menu[1].equals("PermisosWeb") && ruta_menu[2].equals("Consultas")
						&& obj.equals("consultaUsers")) {
					success = (new ConsutaUsuariosWeb()).consultaUsuarios(request, response, ses);
				}

				if (ruta_menu[1].equals("Reportes")){ 
					
					if(ruta_menu[2].equals("MenuControl")){
						if (obj.equals("Reportes")){
							success=true;
						}
					}	
					else if(ruta_menu[2].equals("Reporte_Efectivo")) {
					
						if(obj.equals("index")){
							success=true;
						}
						if (obj.equals("ReporteEfectivo")) {
						success = (new ReporteEfectivo()).reporteEfectivo(request, response, ses);
						}

				  }
			   }
				if (ruta_menu[1].equals("CartaPorte")){ 
					
					if(ruta_menu[2].equals("Busqueda")) {
						
						if (obj.equals("Buscar")) {
							success=true;
						}
						else if(obj.equals("searchCartaPorte")){
							BusquedaServiceImplement busquedaCartaPorte=new BusquedaServiceImplement();
							success= busquedaCartaPorte.busqueda(ses, request, response);
						}
						
				
					}
					if(ruta_menu[2].equals("Timbrado")){
						
						
					}
					
					
					if(ruta_menu[2].equals("MenuControl")) {
						
						
						
						if (obj.equals("cartaPorte")) {
							success=true;
						}
						
						
					}
					else if(ruta_menu[2].equals("ArticulosCliente")){
						if(obj.equals("articulosclientes")){
							
							ArticulosClientesServiceImplement articulos=new ArticulosClientesServiceImplement();
							success =articulos.articulosClientes(ses, request, response);
						
						}
						
						
						
					}
					else if(ruta_menu[2].equals("Clientes")){
						if(obj.equals("buscaclientes")){
							ClientesServiceImplement clientes= new ClientesServiceImplement();
							success = clientes.clientes(ses, request, response);
							
						}
						
					}
					else if(ruta_menu[2].equals("Impresion")){
						if(obj.equals("imprimir")){
							
							ImpresionServiceImplement impresion=new ImpresionServiceImplement();
							success = impresion.impresion(ses, request, response);
						}
						
					}
					else if(ruta_menu[2].equals("ClaveProducto")){
						
						if(obj.equals("ClaveProdServ")){
							ClaveProductoServicioImplement claveproducto=new ClaveProductoServicioImplement();
							success = claveproducto.ClaveProductoServicio(ses, request, response);
						}
						
					}
					else if(ruta_menu[2].equals("Calculadora")){
						if(obj.equals("calcularFlete")){
							System.out.println("entro al calcular flete");
							CalculadoraServiceImplement calcular= new CalculadoraServiceImplement();							
							success=calcular.calcularFlete(ses, request, response);
						}
					}
					
					
					
				}
				
				
			}
			
			if (success) {
				try {
					
					System.out.println("entra success");
					
					ThreadContext.clearMap();
					getServletContext().getRequestDispatcher("/" + pagina)
					.forward(request, response);	
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("entra mal 1");
					response.setCharacterEncoding("UTF-8");
				}
				
			}
			 else {

					System.out.println("entra mal 2");
					ThreadContext.clearMap();
					String jsp=(String)ses.getAttribute("jsp");
					String msjInfo=(String) ses.getAttribute("msjInfo");										
					ses.setAttribute("msjInfo", msjInfo);
					response.setCharacterEncoding("UTF-8");
					getServletContext().getRequestDispatcher(jsp).forward(request, response);
					ses.removeAttribute("jsp");	
				}
				
			
			
			
		} catch (Exception e) {

			System.out.println("entra mal 3");
			e.printStackTrace();
			ses.setAttribute("msj","Consulte a Sistemas.");
			getServletContext().getRequestDispatcher("/errorServlet.jsp")
					.forward(request, response);
		}
		
		
		
		
		
		//doGet(request, response);
	}

}
