package backend.service.implement;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import backend.dto.CartaPorte;
import backend.dto.Impresion;
import backend.service.ImpresionService;

public class ImpresionServiceImplement implements ImpresionService {

	@Override
	public boolean impresion(HttpSession ses, HttpServletRequest request, HttpServletResponse response) {
		
		Integer idcartaporte= Integer.parseInt(request.getParameter("idcartaporte"));
		Integer  opction = Integer.parseInt(request.getParameter("opction"));
		CartaPorte pdfcartaPorte=null;
		Impresion result;
	
		switch (opction) {
		case 1:
			JsonObject json = new JsonObject();
			PrintWriter out = null;
			Boolean success=false;
			String msjError="";
			
			TalonCartaPorteServiceImplement  talonCartaPorteServiceImplement= new TalonCartaPorteServiceImplement();
			pdfcartaPorte = talonCartaPorteServiceImplement.consultaCartaPorte(idcartaporte);

			 if(pdfcartaPorte !=null) {
	 
							result = talonCartaPorteServiceImplement.impresion(pdfcartaPorte);
							 if(result.getSuccess()){								
								 success=true;					 
							 }
							 else {
								 msjError ="Error al guardar los archivos PDF/XML"+"["+result.getMsjError()+"]";
							 }
							 
							 
							 	json.addProperty("success", success);
							 	json.addProperty("msjError", msjError);
								
								response.setCharacterEncoding("UTF-8");
								try {
									out = response.getWriter();
								} catch (IOException e) {
									e.printStackTrace();
								}
								
								out.println(json.toString());
								out.flush();
								out.close();
			}
			
			
			
			break;

		case 2:
			break;
		}
		
		
		return true;
	}

}
