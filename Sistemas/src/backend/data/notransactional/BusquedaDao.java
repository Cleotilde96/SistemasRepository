package backend.data.notransactional;

import java.sql.SQLException;
import java.util.List;

import backend.dto.Busqueda;

public interface BusquedaDao {
		
	public List<Busqueda> search(Busqueda dataSearch) throws SQLException;
	public List<Busqueda>detailDocument(Integer idCartaPorte)throws SQLException;
}
