package backend.dto;

public class ArticulosClientes {

	private Integer idClaveUnidadPeso;
	private String claveUnidad;
	private String descripUnidad;
	private Integer idClaveProdServCP;
	private String claveProducto;
	private String descripProducto;
	private Integer idRemitente;
	private Integer idDestinatario;
	private String cliente;
	private Integer idEmpleado;
	private Integer idCodigosClientes;
	private Clientes clientesArticulos;
	private Integer idClientes;
	
	public Integer getIdClaveUnidadPeso() {
		return idClaveUnidadPeso;
	}

	public void setIdClaveUnidadPeso(Integer idClaveUnidadPeso) {
		this.idClaveUnidadPeso = idClaveUnidadPeso;
	}

	public String getClaveUnidad() {
		return claveUnidad;
	}

	public void setClaveUnidad(String claveUnidad) {
		this.claveUnidad = claveUnidad;
	}

	public String getDescripUnidad() {
		return descripUnidad;
	}

	public void setDescripUnidad(String descripUnidad) {
		this.descripUnidad = descripUnidad;
	}

	public Integer getIdClaveProdServCP() {
		return idClaveProdServCP;
	}

	public void setIdClaveProdServCP(Integer idClaveProdServCP) {
		this.idClaveProdServCP = idClaveProdServCP;
	}

	public String getClaveProducto() {
		return claveProducto;
	}

	public void setClaveProducto(String claveProducto) {
		this.claveProducto = claveProducto;
	}

	public String getDescripProducto() {
		return descripProducto;
	}

	public void setDescripProducto(String descripProducto) {
		this.descripProducto = descripProducto;
	}

	public Integer getIdRemitente() {
		return idRemitente;
	}

	public void setIdRemitente(Integer idRemitente) {
		this.idRemitente = idRemitente;
	}

	public Integer getIdDestinatario() {
		return idDestinatario;
	}

	public void setIdDestinatario(Integer idDestinatario) {
		this.idDestinatario = idDestinatario;
	}
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	
	public Integer getIdCodigosClientes() {
		return idCodigosClientes;
	}

	public void setIdCodigosClientes(Integer idCodigosClientes) {
		this.idCodigosClientes = idCodigosClientes;
	}
	
	
	

	public Clientes getClientesArticulos() {
		return clientesArticulos;
	}

	public void setClientesArticulos(Clientes clientesArticulos) {
		this.clientesArticulos = clientesArticulos;
	}
		
	public Integer getIdClientes() {
		return idClientes;
	}

	public void setIdClientes(Integer idClientes) {
		this.idClientes = idClientes;
	}

	public ArticulosClientes() {

	}
	
	public ArticulosClientes(Integer idClaveUnidadPeso, Integer idClaveProdServCP, Integer idEmpleado) {
		this.idClaveUnidadPeso = idClaveUnidadPeso;
		this.idClaveProdServCP = idClaveProdServCP;
		this.idEmpleado = idEmpleado;
	}
	
	
	
	
	

}
