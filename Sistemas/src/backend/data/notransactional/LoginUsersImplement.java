package backend.data.notransactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import backend.dto.LoginUsers;
import backend.enums.EnumLogin;
import config.CConnection;

public class LoginUsersImplement implements LoginUsersDao {
	private Connection conection;
	
	@Override
	public LoginUsers userAuthentication(String user, String password) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        LoginUsers users= null;       
        try {
            conn = this.conection != null ? this.conection : CConnection.getConnection();
            stmt = conn.prepareStatement(EnumLogin.USERAUTHENTICATION.getQuery());
            stmt.setString(1, user);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            
            while (rs.next()) {      
            	users = new LoginUsers();	
            	//IdUsuariosSistemaWeb	IdEmpleados	IdTipoAccesoSistema	Bloqueo	Nombre
            	users.setIdTipoAccesoSistema(rs.getInt("IdUsuariosSistemaWeb"));
            	users.setIdEmpleados(rs.getInt("IdEmpleados"));
            	users.setIdTipoAccesoSistema(rs.getInt("IdTipoAccesoSistema"));
            	users.setBloqueo(rs.getString("Bloqueo"));
            	users.setNombre(rs.getString("Nombre"));
            	            	    
            }     
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conection == null) {
            	CConnection.close(conn);
            }

        }      
		return users;
	}

}
