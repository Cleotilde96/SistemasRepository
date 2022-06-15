package backend.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface ArticulosClientesService {
	
	public boolean  articulosClientes(HttpSession ses,HttpServletRequest request,HttpServletResponse response);

}
