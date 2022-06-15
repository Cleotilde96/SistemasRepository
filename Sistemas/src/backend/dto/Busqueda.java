package backend.dto;

public class Busqueda {
	
	//CC.IdTalones,CC.IdEstatusProceso,CC.IdEstatusImpresion,
	//CC.IdInformes,TL.NumeroControl,CL.Rfc,CL.NombreCliente,TBL.sClaveCapturista,TBL.dtFechaTimbrado
	private Integer folio;
	private Integer idTalones;
	private Integer idEstatusProceso;
	private Integer idEstatusImpresion;
	private Integer idInformesTalones;
	private Integer numeroControl;
	private String rfcReceptor;
	private String nombreCliente;
	private String serieCapturista;
	private String fechaTimbrado;
	private String fechaRealizacion;
	private String tipo;
	private String estatusProceso;
	private String estatusImpresion;
	private String uUID;
	private String fechaEmision;
	private String certificadoDigital;
	private String certificadoSAT;
	
	
	public Integer getFolio() {
		return folio;
	}
	public void setFolio(Integer folio) {
		this.folio = folio;
	}
	public Integer getIdTalones() {
		return idTalones;
	}
	public void setIdTalones(Integer idTalones) {
		this.idTalones = idTalones;
	}
	public Integer getIdEstatusProceso() {
		return idEstatusProceso;
	}
	public void setIdEstatusProceso(Integer idEstatusProceso) {
		this.idEstatusProceso = idEstatusProceso;
	}
	public Integer getIdEstatusImpresion() {
		return idEstatusImpresion;
	}
	public void setIdEstatusImpresion(Integer idEstatusImpresion) {
		this.idEstatusImpresion = idEstatusImpresion;
	}
	public Integer getIdInformesTalones() {
		return idInformesTalones;
	}
	public void setIdInformesTalones(Integer idInformesTalones) {
		this.idInformesTalones = idInformesTalones;
	}
	public Integer getNumeroControl() {
		return numeroControl;
	}
	public void setNumeroControl(Integer numeroControl) {
		this.numeroControl = numeroControl;
	}
	public String getRfcReceptor() {
		return rfcReceptor;
	}
	public void setRfcReceptor(String rfcReceptor) {
		this.rfcReceptor = rfcReceptor;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getSerieCapturista() {
		return serieCapturista;
	}
	public void setSerieCapturista(String serieCapturista) {
		this.serieCapturista = serieCapturista;
	}
	public String getFechaTimbrado() {
		return fechaTimbrado;
	}
	public void setFechaTimbrado(String fechaTimbrado) {
		this.fechaTimbrado = fechaTimbrado;
	}
	public String getFechaRealizacion() {
		return fechaRealizacion;
	}
	public void setFechaRealizacion(String fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEstatusProceso() {
		return estatusProceso;
	}
	public void setEstatusProceso(String estatusProceso) {
		this.estatusProceso = estatusProceso;
	}
	public String getEstatusImpresion() {
		return estatusImpresion;
	}
	public void setEstatusImpresion(String estatusImpresion) {
		this.estatusImpresion = estatusImpresion;
	}
	public String getuUID() {
		return uUID;
	}
	public void setuUID(String uUID) {
		this.uUID = uUID;
	}
	public String getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public String getCertificadoDigital() {
		return certificadoDigital;
	}
	public void setCertificadoDigital(String certificadoDigital) {
		this.certificadoDigital = certificadoDigital;
	}
	public String getCertificadoSAT() {
		return certificadoSAT;
	}
	public void setCertificadoSAT(String certificadoSAT) {
		this.certificadoSAT = certificadoSAT;
	}
	public Busqueda(){}
	
	
	
	
	
	
}
