package backend.service.implement;
import config.CConnection;
import backend.dto.CartaPorte;
import backend.dto.Impresion;
import backend.service.TalonCartaPorteService;

import java.sql.Connection;
import java.sql.SQLException;

import backend.data.notransactional.ImpresionImplement;

import backend.data.notransactional.CartaPorteImplement;

public class TalonCartaPorteServiceImplement implements TalonCartaPorteService {


	@Override
	public CartaPorte consultaCartaPorte(Integer idCartaPorte) {
		Connection conexion = null;
		CartaPorteImplement cartaPorteImplement;
		CartaPorte cartaPorte=null;
		try {
			conexion = CConnection.getConnection();
			if (conexion.getAutoCommit()) {
				conexion.setAutoCommit(false);
			}

			try {
				cartaPorteImplement = new CartaPorteImplement();
				cartaPorte =new CartaPorte();
				cartaPorte.setIdCCartaPorte(idCartaPorte);
				cartaPorte =cartaPorteImplement.selectCartaPorte(cartaPorte);		
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return cartaPorte;
	}

	@Override
	public Impresion impresion(CartaPorte cartaporte) {
		//Boolean imprimir=false; 
				Impresion result=null;
				
				ImpresionImplement impresionImplement =new ImpresionImplement();
				try {
					
					
					result = impresionImplement.llenaDatos(cartaporte,2);
					
									
				} catch (Exception e) {
					e.printStackTrace();
				}
				return result;
	}


	
	
}
