package backend.data.notransactional;
import java.math.RoundingMode;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import config.CConnection;
import backend.dto.Impresion;
import backend.enums.EnumImpresion;

public class TalonesCartaPorteImplement implements TalonesCartaPorte {
	
	private Connection conection;

	@Override
	public Impresion rutaFile(Impresion print) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Impresion impresion= null;
		String rutaAlmacenamiento;
        
        try {
            conn = this.conection != null ? this.conection: CConnection.getConnection();
            stmt = conn.prepareStatement(EnumImpresion.FECHACARTAPORTE.getPrint());
            stmt.setInt(1, print.getIdCCartaPorte());
            rs = stmt.executeQuery();      
            if (rs.next()) {
            	impresion = new Impresion();
            	impresion.setMes(rs.getString("mes"));
            	impresion.setAnio(rs.getString("annio"));
            	impresion.setDia(rs.getString("dia"));
            	
            	
            	if(!impresion.getAnio().equals(null) && !impresion.getMes().equals(null) && !impresion.getDia().equals(null)){           		
            		rutaAlmacenamiento = print.getRutaFile()
            				.concat(impresion.getAnio())
            				.concat("\\")
            				.concat(impresion.getMes())
            				.concat("\\")
            				.concat(impresion.getDia())
            				.concat("\\")
            				.concat(print.getNameCarpeta())
            				.concat("\\");
            				
            		impresion.setRutaStorage(rutaAlmacenamiento);
            	}	
            }     
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conection == null) {
            	CConnection.close(conn);
            }

        }      
		return impresion;
	}

	
	
	
}
