package backend.service.implement;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import backend.data.notransactional.ArticulosClienteImplement;
import backend.dto.Clientes;
import backend.service.ClientesService;

public class ClientesServiceImplement implements ClientesService {

	@Override
	public boolean clientes(HttpSession ses, HttpServletRequest request, HttpServletResponse response){
	
		Integer opction =Integer.parseInt(request.getParameter("opction"));	
		String nombre;
		String apellidoUno;
		String apellidoDos;
		Integer idClient;
		ArticulosClienteImplement clientesImplement=null;
		Clientes objclientes=null;
		List<Clientes> listClientes=null;
		switch (opction) {
		case 1:
			nombre =request.getParameter("nombre");
			apellidoUno = request.getParameter("apellidoUno");
			apellidoDos = request.getParameter("apellidoDos");
			idClient = Integer.parseInt(request.getParameter("idClient"));
		
			clientesImplement =new ArticulosClienteImplement();
			
			if(nombre ==null){
				nombre="";
			}
			else if(apellidoUno ==null){
			   apellidoUno="";
			}
			else if(apellidoDos == null){
				apellidoDos="";
			}
				
			
			//objclientes = new Clientes(nombre.trim(),apellidoUno.trim(),apellidoDos.trim());
			objclientes = new Clientes();
			objclientes.setNombre(nombre.trim());
			objclientes.setApellidoUno(apellidoUno.trim());
			objclientes.setApellidoDos(apellidoDos.trim());
			objclientes.setIdCliente(idClient);
			
			try {
				listClientes = clientesImplement.buscarCliente(objclientes);
				if(!listClientes.isEmpty()){
					request.setAttribute("listCliente", listClientes);
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			break;

		}
		
		return true;
	}

}
