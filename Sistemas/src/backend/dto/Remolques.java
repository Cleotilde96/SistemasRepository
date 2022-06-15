package backend.dto;

public class Remolques {
	
	
	private Integer idCRemSubTipoRem;
	private Integer idRemolques;
	private Integer idEstatusProceso;
	private String Placas;
	private String SubTipoRem;
	public Integer getIdCRemSubTipoRem() {
		return idCRemSubTipoRem;
	}
	public void setIdCRemSubTipoRem(Integer idCRemSubTipoRem) {
		this.idCRemSubTipoRem = idCRemSubTipoRem;
	}
	public Integer getIdRemolques() {
		return idRemolques;
	}
	public void setIdRemolques(Integer idRemolques) {
		this.idRemolques = idRemolques;
	}
	public Integer getIdEstatusProceso() {
		return idEstatusProceso;
	}
	public void setIdEstatusProceso(Integer idEstatusProceso) {
		this.idEstatusProceso = idEstatusProceso;
	}
	public String getPlacas() {
		return Placas;
	}
	public void setPlacas(String placas) {
		Placas = placas;
	}
	public String getSubTipoRem() {
		return SubTipoRem;
	}
	public void setSubTipoRem(String subTipoRem) {
		SubTipoRem = subTipoRem;
	}
	public Remolques(){}
	
	
	
}
