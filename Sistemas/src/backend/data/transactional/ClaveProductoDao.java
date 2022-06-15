package backend.data.transactional;

import java.sql.SQLException;

import backend.dto.CClaveProdServCP;


public interface ClaveProductoDao {
	 public Integer insertClaveProducto(CClaveProdServCP claveproducto) throws SQLException;
	 public Integer updateClaveProducto(CClaveProdServCP claveproducto) throws SQLException;
}
