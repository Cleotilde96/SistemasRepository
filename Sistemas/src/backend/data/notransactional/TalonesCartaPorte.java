package backend.data.notransactional;

import java.sql.SQLException;
import backend.dto.Impresion;



public interface TalonesCartaPorte {
		

	public Impresion rutaFile(Impresion print) throws SQLException;
	
}
