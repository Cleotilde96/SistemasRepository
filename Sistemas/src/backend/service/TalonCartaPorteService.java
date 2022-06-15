package backend.service;



import backend.dto.Impresion;

import backend.dto.CartaPorte;

public interface TalonCartaPorteService {

	public CartaPorte consultaCartaPorte(Integer idCartaPorte);
	public Impresion impresion(CartaPorte cartaporte);
	
}
