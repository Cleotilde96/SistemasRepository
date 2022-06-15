package backend.data.notransactional;

import java.sql.SQLException;

import backend.dto.CartaPorte;
import backend.dto.XmlCartaPorte;
import backend.dto.TalonesInforme;

public interface CartaPorteDao {
		
    public int insertCartaPorte(CartaPorte cartaporte)throws SQLException;
    public CartaPorte selectCartaPorte(CartaPorte idCartaPorte)throws SQLException;
    public Boolean estatusProceso(CartaPorte CartaPorte)throws SQLException;
    public XmlCartaPorte datosTimbrado(CartaPorte CartaPorte,Integer opction)throws SQLException;
    public Integer existencia(TalonesInforme idTalones)throws SQLException;
    public XmlCartaPorte exitenciaRelacion(Integer idCartaPorte)throws SQLException;
}
