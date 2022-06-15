package backend.data.notransactional;

import java.sql.SQLException;
import java.util.List;

import backend.dto.CClaveProdServCP;

public interface ClaveProductoServDao {
	
	public List<CClaveProdServCP> claveproducto(String claveProdServCP) throws SQLException;
	public Integer existenciaClave(String claveProdServCP)throws SQLException;
}
