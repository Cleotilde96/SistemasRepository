package backend.dto;

public class CArticulosClaveUnidadPeso {
	
	private Integer idCArticulosClaveUnidadPeso;
	private Integer idEstatusProceso;
	private Integer idArticulos;
	private Integer idCClaveUnidadPeso;
	
	public CArticulosClaveUnidadPeso() {
	}

	public CArticulosClaveUnidadPeso(Integer idCArticulosClaveUnidadPeso, Integer idEstatusProceso, Integer idArticulos,
			Integer idCClaveUnidadPeso) {
		this.idCArticulosClaveUnidadPeso = idCArticulosClaveUnidadPeso;
		this.idEstatusProceso = idEstatusProceso;
		this.idArticulos = idArticulos;
		this.idCClaveUnidadPeso = idCClaveUnidadPeso;
	}

	public Integer getIdCArticulosClaveUnidadPeso() {
		return idCArticulosClaveUnidadPeso;
	}

	public void setIdCArticulosClaveUnidadPeso(Integer idCArticulosClaveUnidadPeso) {
		this.idCArticulosClaveUnidadPeso = idCArticulosClaveUnidadPeso;
	}

	public Integer getIdEstatusProceso() {
		return idEstatusProceso;
	}

	public void setIdEstatusProceso(Integer idEstatusProceso) {
		this.idEstatusProceso = idEstatusProceso;
	}

	public Integer getIdArticulos() {
		return idArticulos;
	}

	public void setIdArticulos(Integer idArticulos) {
		this.idArticulos = idArticulos;
	}

	public Integer getIdCClaveUnidadPeso() {
		return idCClaveUnidadPeso;
	}

	public void setIdCClaveUnidadPeso(Integer idCClaveUnidadPeso) {
		this.idCClaveUnidadPeso = idCClaveUnidadPeso;
	}

	@Override
	public String toString() {
		return "CArticulosClaveUnidadPeso [idCArticulosClaveUnidadPeso=" + idCArticulosClaveUnidadPeso
				+ ", idEstatusProceso=" + idEstatusProceso + ", idArticulos=" + idArticulos + ", idCClaveUnidadPeso="
				+ idCClaveUnidadPeso + "]";
	}
	
	

}
