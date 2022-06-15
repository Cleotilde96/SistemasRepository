package backend.dto;
public class CiudadesDistancias {
	
	private Integer idCiudadesDistancias;
	private Integer idEstatusProceso;
	private String idCLocalidadO;
	private String  idCLocalidadD;
	private Float  kmsRecorridos;
	private Integer  diasEntrega;
	private Integer  idEmpleados;
	private Integer  tipoMovto;
	private String  fechaNovto;
	private String  motivoBaja;
	
	public CiudadesDistancias() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Integer getIdCiudadesDistancias() {
		return idCiudadesDistancias;
	}
	public void setIdCiudadesDistancias(Integer idCiudadesDistancias) {
		this.idCiudadesDistancias = idCiudadesDistancias;
	}
	public Integer getIdEstatusProceso() {
		return idEstatusProceso;
	}
	public void setIdEstatusProceso(Integer idEstatusProceso) {
		this.idEstatusProceso = idEstatusProceso;
	}
	public String getIdCLocalidadO() {
		return idCLocalidadO;
	}
	public void setIdCLocalidadO(String idCLocalidadO) {
		this.idCLocalidadO = idCLocalidadO;
	}
	public String getIdCLocalidadD() {
		return idCLocalidadD;
	}
	public void setIdCLocalidadD(String idCLocalidadD) {
		this.idCLocalidadD = idCLocalidadD;
	}
	public Float getKmsRecorridos() {
		return kmsRecorridos;
	}
	public void setKmsRecorridos(Float kmsRecorridos) {
		this.kmsRecorridos = kmsRecorridos;
	}
	public Integer getDiasEntrega() {
		return diasEntrega;
	}
	public void setDiasEntrega(Integer diasEntrega) {
		this.diasEntrega = diasEntrega;
	}
	public Integer getIdEmpleados() {
		return idEmpleados;
	}
	public void setIdEmpleados(Integer idEmpleados) {
		this.idEmpleados = idEmpleados;
	}
	public Integer getTipoMovto() {
		return tipoMovto;
	}
	public void setTipoMovto(Integer tipoMovto) {
		this.tipoMovto = tipoMovto;
	}
	public String getFechaNovto() {
		return fechaNovto;
	}
	public void setFechaNovto(String fechaNovto) {
		this.fechaNovto = fechaNovto;
	}
	public String getMotivoBaja() {
		return motivoBaja;
	}
	public void setMotivoBaja(String motivoBaja) {
		this.motivoBaja = motivoBaja;
	}

	public CiudadesDistancias(String idCLocalidadO, String idCLocalidadD) {
		this.idCLocalidadO = idCLocalidadO;
		this.idCLocalidadD = idCLocalidadD;
	}

	public String toString() {
		return "CiudadesDistancias [idCiudadesDistancias=" + idCiudadesDistancias + "]";
	}
	
	
	
	
	
	

}
