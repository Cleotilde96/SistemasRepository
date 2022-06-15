package backend.data.notransactional;

import java.sql.SQLException;
import backend.dto.LoginUsers;



public interface LoginUsersDao {
	public LoginUsers userAuthentication(String  user,String password)throws SQLException;
}
