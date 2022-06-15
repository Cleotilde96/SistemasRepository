package  backend.dto;

public class CClaveProductServCP {
	
	private Integer idCClaveProductServCP;
	private Integer idEstatusProceso;
	private String claveProducto;
	private String descripcion;
	
	public CClaveProductServCP() {
		// TODO Auto-generated constructor stub
	}

	public CClaveProductServCP(Integer idCClaveProductServCP, Integer idEstatusProceso, String claveProducto,
			String descripcion) {
		this.idCClaveProductServCP = idCClaveProductServCP;
		this.idEstatusProceso = idEstatusProceso;
		this.claveProducto = claveProducto;
		this.descripcion = descripcion;
	}

	public Integer getIdCClaveProductServCP() {
		return idCClaveProductServCP;
	}

	public void setIdCClaveProductServCP(Integer idCClaveProductServCP) {
		this.idCClaveProductServCP = idCClaveProductServCP;
	}

	public Integer getIdEstatusProceso() {
		return idEstatusProceso;
	}

	public void setIdEstatusProceso(Integer idEstatusProceso) {
		this.idEstatusProceso = idEstatusProceso;
	}

	public String getClaveProducto() {
		return claveProducto;
	}

	public void setClaveProducto(String claveProducto) {
		this.claveProducto = claveProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "CClaveProductServCP [idCClaveProductServCP=" + idCClaveProductServCP + ", idEstatusProceso="
				+ idEstatusProceso + ", claveProducto=" + claveProducto + ", descripcion=" + descripcion + "]";
	}
	
	
	

}
