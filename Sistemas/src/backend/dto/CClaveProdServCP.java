package backend.dto;

public class CClaveProdServCP {

	private Integer idCClaveProdServCP;
	private Integer idEstatusProceso;
	private String claveProducto;
	private String descripcion;
	private String materialPeligroso;

	public Integer getIdCClaveProdServCP() {
		return idCClaveProdServCP;
	}

	public void setIdCClaveProdServCP(Integer idCClaveProdServCP) {
		this.idCClaveProdServCP = idCClaveProdServCP;
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

	public String getMaterialPeligroso() {
		return materialPeligroso;
	}

	public void setMaterialPeligroso(String materialPeligroso) {
		this.materialPeligroso = materialPeligroso;
	}

	public CClaveProdServCP() {
	}

}
