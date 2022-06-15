package backend.service.implement;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import com.google.zxing.FormatException;
import backend.data.notransactional.TalonesCartaPorteImplement;

import backend.dto.Impresion;
import backend.enums.EnumImpresion;

import backend.data.notransactional.BusquedaImplement;
//import com.perliexpressweb.menu.facturacion.informesTalones.cartaporte.data.notransactional.TalonesCartaPorteImplement;
import backend.dto.Busqueda;
import backend.dto.CartaPorte;
//import com.perliexpressweb.menu.facturacion.informesTalones.cartaporte.enums.EnumImpresion;
import backend.service.BusquedaService;

public class BusquedaServiceImplement implements BusquedaService {

	@Override
	public boolean busqueda(HttpSession ses, HttpServletRequest request, HttpServletResponse response) {

		Integer valorBusqueda = -1;
		String fechaBusqueda = "";
		Integer valueSearch = -1;
		PrintWriter out = null;
		JsonObject json = new JsonObject();
		BusquedaImplement BusquedaImplement = new BusquedaImplement();
		Busqueda busqueda = new Busqueda();
		Integer idCartaPorte = -1;
		List<Busqueda> listDetalle = new ArrayList<Busqueda>();
		Integer opction = Integer.parseInt(request.getParameter("opction"));
		Integer tipoArchivo = -1;
		switch (opction) {
		case 1:

			try {

				valorBusqueda = Integer.parseInt(request.getParameter("valorBusqueda"));
				fechaBusqueda = request.getParameter("fechaBusqueda");
				valueSearch = Integer.parseInt(request.getParameter("valueSearch"));

				if (valueSearch > 0 && valueSearch != -1) {

					if (valorBusqueda > 0 && fechaBusqueda == "") {
						System.out.println("entra a buscar por numero");

						//if (valueSearch == 1) {
							busqueda.setFolio(valorBusqueda);
							busqueda.setTipo(valueSearch.toString());
							request.setAttribute("listCartaPorte", BusquedaImplement.search(busqueda));
						//}

					} else if (valorBusqueda < 0 && fechaBusqueda != "") {
						System.out.println("entra a buscar por fecha");
					}
				}
				request.setAttribute("msjError", "");

			} catch (NumberFormatException e) {

				try {
					out = response.getWriter();

					json.addProperty("msjError", " Solo se aceptan valores en formato de enteros");

					response.setCharacterEncoding("UTF-8");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				out.println(json.toString());
				out.flush();
				out.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case 2: // detalle de documento

			idCartaPorte = Integer.parseInt(request.getParameter("idCartaPorte"));

			try {

				listDetalle = BusquedaImplement.detailDocument(idCartaPorte);

				request.setAttribute("listDetalle", listDetalle);
				request.setAttribute("folio", idCartaPorte);
			} catch (SQLException e) {

				e.printStackTrace();
			}

			break;

		case 3:

			idCartaPorte = Integer.parseInt(request.getParameter("idCartaPorte"));
			tipoArchivo = Integer.parseInt(request.getParameter("tipoArchivo"));
			Impresion rutaPdf = null;
			String ruta = "";
			TalonesCartaPorteImplement rutaFile = new TalonesCartaPorteImplement();
			TalonCartaPorteServiceImplement talonCartaPorteServiceImplement = new TalonCartaPorteServiceImplement();
			CartaPorte pdfcartaPorte = null;
		
			
			if (tipoArchivo == 1) { // pdf

				pdfcartaPorte = talonCartaPorteServiceImplement.consultaCartaPorte(idCartaPorte);

				rutaPdf = new Impresion();
				rutaPdf.setIdCCartaPorte(idCartaPorte);
				rutaPdf.setRutaFile(EnumImpresion.RUTASTORAGEPDF.getPrint());// ruta de almacenamiento pdf
				rutaPdf.setNameCarpeta(EnumImpresion.CARPETACARTAPORTE.getPrint().concat(idCartaPorte.toString())); // nombre
																													// carpeta
																													// talon
				try {
					ruta = rutaFile.rutaFile(rutaPdf).getRutaStorage()
							.concat(EnumImpresion.NAMEFILECARTAPORTE.getPrint()).concat(idCartaPorte.toString())
							.concat("_" + pdfcartaPorte.getNumeroControl()).concat(EnumImpresion.FORMATPDF.getPrint());
				} catch (SQLException e) {

					e.printStackTrace();
				}
			} else if (tipoArchivo == 2) {// xml
					
				pdfcartaPorte = talonCartaPorteServiceImplement.consultaCartaPorte(idCartaPorte);

				rutaPdf = new Impresion();
				rutaPdf.setIdCCartaPorte(idCartaPorte);
				rutaPdf.setRutaFile(EnumImpresion.RUTASTORAGEXML.getPrint());// ruta de almacenamiento pdf
				rutaPdf.setNameCarpeta(EnumImpresion.CARPETACARTAPORTE.getPrint().concat(idCartaPorte.toString())); // nombre
																													// carpeta
																													// talon
				try {
					ruta = rutaFile.rutaFile(rutaPdf).getRutaStorage()
							.concat(EnumImpresion.NAMEFILETALONCARTAPORTEXML.getPrint())
							.concat(idCartaPorte.toString())
							.concat("_" + pdfcartaPorte.getNumeroControl()).concat(EnumImpresion.FORMATXML.getPrint());
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			
			try {
				out = response.getWriter();
				json.addProperty("rutaFile", ruta);
			} catch (IOException e) {
			
				e.printStackTrace();
			}
			response.setCharacterEncoding("UTF-8");
			out.println(json.toString());
			out.flush();
			out.close();

			
			

			break;

		default:
			break;
		}

		return true;
	}

}
