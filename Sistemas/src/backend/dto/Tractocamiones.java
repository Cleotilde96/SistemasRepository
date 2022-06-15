package backend.dto;

public class Tractocamiones {
		
	private Integer idCTractoConfigAutotrans;
	private Integer idTractocamiones;
	private Integer idEstatusProceso;
	private Integer  IdUnidades;
	private String modelo;
	private String placas;
	private String configVehicular;
	public Integer getIdCTractoConfigAutotrans() {
		return idCTractoConfigAutotrans;
	}
	public void setIdCTractoConfigAutotrans(Integer idCTractoConfigAutotrans) {
		this.idCTractoConfigAutotrans = idCTractoConfigAutotrans;
	}
	public Integer getIdTractocamiones() {
		return idTractocamiones;
	}
	public void setIdTractocamiones(Integer idTractocamiones) {
		this.idTractocamiones = idTractocamiones;
	}
	public Integer getIdEstatusProceso() {
		return idEstatusProceso;
	}
	public void setIdEstatusProceso(Integer idEstatusProceso) {
		this.idEstatusProceso = idEstatusProceso;
	}
	public Integer getIdUnidades() {
		return IdUnidades;
	}
	public void setIdUnidades(Integer idUnidades) {
		IdUnidades = idUnidades;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlacas() {
		return placas;
	}
	public void setPlacas(String placas) {
		this.placas = placas;
	}
	public String getConfigVehicular() {
		return configVehicular;
	}
	public void setConfigVehicular(String configVehicular) {
		this.configVehicular = configVehicular;
	}
	public Tractocamiones() {}
	
	
	

}
