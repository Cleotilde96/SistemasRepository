package backend.dto;



public class CpColDestino {
	
	//IdCP_Col_Destino	IdCP_Colonias	IdEstatusProceso	
	//Id_Clientes	IdClientesHistorial	IdTalones_Clientes	IdDireccionesEntrega	IdEmpleado	FechaMovto	TipoMovto
	private Integer idCPColDestino;
	private Integer idCPColonias;
	private Integer idEstatusProceso;
	private Integer idClientes;
	private Integer idClientesHistorial;
	private Integer idDireccionesEntrega;
	private Integer idTalonesClientes;
	private Integer idEmpleado;
	private String  fechaMovto;
	private String  tipoMovto;
	public Integer getIdCPColDestino() {
		return idCPColDestino;
	}
	public void setIdCPColDestino(Integer idCPColDestino) {
		this.idCPColDestino = idCPColDestino;
	}
	public Integer getIdCPColonias() {
		return idCPColonias;
	}
	public void setIdCPColonias(Integer idCPColonias) {
		this.idCPColonias = idCPColonias;
	}
	public Integer getIdEstatusProceso() {
		return idEstatusProceso;
	}
	public void setIdEstatusProceso(Integer idEstatusProceso) {
		this.idEstatusProceso = idEstatusProceso;
	}
	public Integer getIdClientes() {
		return idClientes;
	}
	public void setIdClientes(Integer idClientes) {
		this.idClientes = idClientes;
	}
	public Integer getIdClientesHistorial() {
		return idClientesHistorial;
	}
	public void setIdClientesHistorial(Integer idClientesHistorial) {
		this.idClientesHistorial = idClientesHistorial;
	}
	public Integer getIdDireccionesEntrega() {
		return idDireccionesEntrega;
	}
	public void setIdDireccionesEntrega(Integer idDireccionesEntrega) {
		this.idDireccionesEntrega = idDireccionesEntrega;
	}
	public Integer getIdTalonesClientes() {
		return idTalonesClientes;
	}
	public void setIdTalonesClientes(Integer idTalonesClientes) {
		this.idTalonesClientes = idTalonesClientes;
	}
	public Integer getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getFechaMovto() {
		return fechaMovto;
	}
	public void setFechaMovto(String fechaMovto) {
		this.fechaMovto = fechaMovto;
	}
	public String getTipoMovto() {
		return tipoMovto;
	}
	public void setTipoMovto(String tipoMovto) {
		this.tipoMovto = tipoMovto;
	}
	public CpColDestino() {}
	public CpColDestino(Integer idCPColDestino) {
	
		this.idCPColDestino = idCPColDestino;
	}
	
	
	
    
	

}
