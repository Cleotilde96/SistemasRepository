package backend.data.notransactional;

import java.sql.SQLException;
import java.util.List;

import backend.dto.ArticulosClientes;
import backend.dto.Clientes;

public interface ArticulosClienteDao {
		
	public List<ArticulosClientes> articulosClientes(Integer idClientes,Integer opction)throws SQLException;
	public List<ArticulosClientes>articulos()throws SQLException;
	public ArticulosClientes claveProducto(String claveProducto)throws SQLException;
	public Integer spiCodigosClientes(ArticulosClientes codigosClientes)throws SQLException;
	public Integer spiClientesHCodigos(ArticulosClientes codigosClientes)throws SQLException;
	public ArticulosClientes claveProductoCliente(Integer idClientesHCodigos)throws SQLException;
	public List<Clientes> buscarCliente(Clientes cliente)throws SQLException;
	public List<ArticulosClientes>selectClientesArticulos()throws SQLException;
	
}
