package backend.data.notransactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import backend.dto.CClaveProdServCP;
import backend.enums.EnumClaveProducto;
import config.CConnection;

public class ClaveProductoServImplement implements ClaveProductoServDao {
	
	private Connection conection;
	
	@Override
	public List<CClaveProdServCP> claveproducto(String claveProdServCP) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CClaveProdServCP cClaveProdServCP= null;
        List<CClaveProdServCP>listClaveProv= new ArrayList<>();
        try {
            conn = this.conection != null ? this.conection : CConnection.getConnection();
            stmt = conn.prepareStatement(EnumClaveProducto.SEARCHCLAVE.getQuery());
            stmt.setString(1, claveProdServCP);
            rs = stmt.executeQuery();
            
            while (rs.next()) {   
            	//Id_c_ClaveProdServCP	IdEstatusProceso	ClaveProducto	Descripcion	MaterialPeligroso
            	
            	cClaveProdServCP = new CClaveProdServCP();	
            	cClaveProdServCP.setIdCClaveProdServCP(rs.getInt("Id_c_ClaveProdServCP"));
            	cClaveProdServCP.setIdEstatusProceso(rs.getInt("IdEstatusProceso"));
            	cClaveProdServCP.setClaveProducto(rs.getString("ClaveProducto"));
            	cClaveProdServCP.setDescripcion(rs.getString("Descripcion"));
            	if(rs.getString("MaterialPeligroso") ==null || rs.getString("MaterialPeligroso").equals("")){
            		cClaveProdServCP.setMaterialPeligroso("No");
            	}
            	else if(rs.getString("MaterialPeligroso").equals("No")){
            		cClaveProdServCP.setMaterialPeligroso("Si");
            	} 	
            	listClaveProv.add(cClaveProdServCP);
            	    
            }     
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conection == null) {
            	CConnection.close(conn);
            }

        }      
		return listClaveProv;
	}

	@Override
	public Integer existenciaClave(String claveProdServCP) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer totalRow=0;
        try {
            conn = this.conection != null ? this.conection : CConnection.getConnection();
            stmt = conn.prepareStatement(EnumClaveProducto.TOTALROWCLAVE.getQuery());
            stmt.setString(1, claveProdServCP);
            rs = stmt.executeQuery();            
            if (rs.next()) {               	            	
            	totalRow = rs.getInt("Total");            	    
            }     
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conection == null) {
            	CConnection.close(conn);
            }

        } 
		return totalRow;
	}

}
