package backend.data.transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.CConnection;

import backend.dto.CClaveProdServCP;

public class ClaveProductoImplement implements ClaveProductoDao {
	private Connection conection;
	

	public ClaveProductoImplement() {

    } 
	
	public ClaveProductoImplement(Connection conexion) {
	        this.conection = conexion;
	    
	 }
	
	@Override
	public Integer insertClaveProducto(CClaveProdServCP claveproducto) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
        	conn = this.conection != null ? this.conection : CConnection.getConnection();
        	
        	stmt = conn.prepareStatement("INSERT INTO C_ClaveProdServCP (IdEstatusProceso,ClaveProducto,Descripcion,MaterialPeligroso) VALUES(?,?,?,?)");
          	stmt.setInt(1, claveproducto.getIdEstatusProceso());
            stmt.setString(2, claveproducto.getClaveProducto());
            stmt.setString(3, claveproducto.getDescripcion());
            stmt.setString(4, claveproducto.getMaterialPeligroso());
            rows = stmt.executeUpdate();
        } finally {
        	CConnection.close(stmt);
            if (this.conection == null) {
            	CConnection.close(conn);
            }
        }

        return rows;
	}

	@Override
	public Integer updateClaveProducto(CClaveProdServCP claveproducto) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
        	conn = this.conection != null ? this.conection : CConnection.getConnection();
        	//ClaveProducto=?,
        	stmt = conn.prepareStatement("UPDATE  C_ClaveProdServCP SET Descripcion=?,MaterialPeligroso=? WHERE Id_c_ClaveProdServCP=?");          	
            //stmt.setString(1, claveproducto.getClaveProducto());
            stmt.setString(1, claveproducto.getDescripcion());
            stmt.setString(2, claveproducto.getMaterialPeligroso());
            stmt.setInt(3, claveproducto.getIdCClaveProdServCP());
            rows = stmt.executeUpdate();
        } finally {
        	CConnection.close(stmt);
            if (this.conection == null) {
            	CConnection.close(conn);
            }
        }

        return rows;
	}

}
