package backend.data.notransactional;

import java.sql.SQLException;
import java.util.List;

import backend.dto.Articulos;
import backend.dto.Montos;
import backend.dto.Servicios;

import backend.dto.CartaPorte;
import backend.dto.Impresion;

public interface ImpresionDao {
		
	public Impresion impresion(Impresion print)throws SQLException;
	public Impresion facturadoCliente(CartaPorte idTalones)throws SQLException;
	public Impresion enviarDomicilio(CartaPorte idTalones)throws SQLException;
	public Impresion observaciones(CartaPorte idCartaPorte)throws SQLException;
	public Impresion metodoPago(CartaPorte idTalones)throws SQLException;
	public Impresion usoCFDI(CartaPorte idCartaPorte)throws SQLException;
	public Impresion formaDePago(CartaPorte idCartaPorte)throws SQLException;
	public Impresion aseguradoraPoliza(CartaPorte idTalones)throws SQLException;
	public Impresion Operador(CartaPorte idInformesTalones)throws SQLException;
	public Impresion tractoCamion(CartaPorte idCartaPorte)throws SQLException;
	public Impresion datosTimbrado(CartaPorte idCartaPorte)throws SQLException;
	public Impresion llenaDatos(CartaPorte cartaPorte,Integer opction)throws SQLException;
	public Impresion rutaArchivos(Impresion print)throws SQLException;
	public String nombreServer();
	public Boolean guardaXml(Impresion print);
	public Boolean realizaQR(Impresion print);
	public Boolean estatusImpresion(Impresion print)throws SQLException;
	public Impresion usuarioSucursal(Integer idEmpleado)throws SQLException;
	
	public List<Articulos> articulos(Integer idCartaPorte) throws SQLException;
	public Montos montos(Integer idCartaPorte)throws SQLException;
	public List<Servicios> servicios(Integer idCartaPorte)throws SQLException;
}
