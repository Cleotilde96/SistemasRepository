package backend.dto;

import java.math.BigDecimal;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Impresion {
		
	private Integer folio;
	private String serie;
	private Integer idCCartaPorte;
	private Integer idTalones;
	private String uUID;
	private String fechaTimbrado;
	private String fechaEmision;
	private String certificadoDigital;
	private String certificadoSAT;
	private String nombreClienteF;
	private String facturadoRFC;
	private String direccionEntrega;
	private String observaciones;
	private String metodoPago;
	private String usoCFDI;
	private String formaPago;
	private String aseguradora;
	private String poliza;
	private Float  kmRecorridos;
	private String placasTractoCamion;
	private String placasRemolque;
	private String nombreOperador;
	private String operadorRFC;
	private String licencia;
	private String claveConfigVehicular;
	private String tipoSubRemolque;
	private BigDecimal subtotal;
	private String flete;
	private String impuestoRetencion;
	private String tipoFactorRetencion;
	private String tasaRetencion;
	private BigDecimal iva;
	private BigDecimal total;
	private String retencion;
	private BigDecimal netoPagar;
	private String cadenaOriginal;
	private String selloDigitalCFDI;
	private String selloDigitalSAT;
	private Boolean success;
	private String msjError;
	private String codigoQR;
	private String sXmlTimbrado;
	
	private String rutaStorage;
	private Integer option;
	private String rutaFile;
	private String anio;
	private String mes;
	private String dia;
	private String rutaPlantilla;
	private String nameCarpeta;
	private String rutaQR;
	private Integer numeroControl;
	
	private Integer idEmpleado;
	private Integer idCiudades;
	private String nombreEmpleado;
	private String direccionOrigen;
	private String lugarExpedicion;
	private String direccionOperador;
	
	private String observacionesCP;
	
	private JRBeanCollectionDataSource articulos;
	private JRBeanCollectionDataSource servicios;
	private String aseguraCarga;
	private String polizaCarga;
	
	public Integer getFolio() {
		return folio;
	}
	public void setFolio(Integer folio) {
		this.folio = folio;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public Integer getIdCCartaPorte() {
		return idCCartaPorte;
	}
	public void setIdCCartaPorte(Integer idCCartaPorte) {
		this.idCCartaPorte = idCCartaPorte;
	}
	public Integer getIdTalones() {
		return idTalones;
	}
	public void setIdTalones(Integer idTalones) {
		this.idTalones = idTalones;
	}
	public String getuUID() {
		return uUID;
	}
	public void setuUID(String uUID) {
		this.uUID = uUID;
	}
	public String getFechaTimbrado() {
		return fechaTimbrado;
	}
	public void setFechaTimbrado(String fechaTimbrado) {
		this.fechaTimbrado = fechaTimbrado;
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
	public String getNombreClienteF() {
		return nombreClienteF;
	}
	public void setNombreClienteF(String nombreClienteF) {
		this.nombreClienteF = nombreClienteF;
	}
	public String getFacturadoRFC() {
		return facturadoRFC;
	}
	public void setFacturadoRFC(String facturadoRFC) {
		this.facturadoRFC = facturadoRFC;
	}
	public String getDireccionEntrega() {
		return direccionEntrega;
	}
	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	public String getUsoCFDI() {
		return usoCFDI;
	}
	public void setUsoCFDI(String usoCFDI) {
		this.usoCFDI = usoCFDI;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	public String getAseguradora() {
		return aseguradora;
	}
	public void setAseguradora(String aseguradora) {
		this.aseguradora = aseguradora;
	}
	public String getPoliza() {
		return poliza;
	}
	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}
	public Float getKmRecorridos() {
		return kmRecorridos;
	}
	public void setKmRecorridos(Float kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}
	public String getPlacasTractoCamion() {
		return placasTractoCamion;
	}
	public void setPlacasTractoCamion(String placasTractoCamion) {
		this.placasTractoCamion = placasTractoCamion;
	}
	public String getPlacasRemolque() {
		return placasRemolque;
	}
	public void setPlacasRemolque(String placasRemolque) {
		this.placasRemolque = placasRemolque;
	}
	public String getNombreOperador() {
		return nombreOperador;
	}
	public void setNombreOperador(String nombreOperador) {
		this.nombreOperador = nombreOperador;
	}
	public String getOperadorRFC() {
		return operadorRFC;
	}
	public void setOperadorRFC(String operadorRFC) {
		this.operadorRFC = operadorRFC;
	}
	public String getLicencia() {
		return licencia;
	}
	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}
	public String getClaveConfigVehicular() {
		return claveConfigVehicular;
	}
	public void setClaveConfigVehicular(String claveConfigVehicular) {
		this.claveConfigVehicular = claveConfigVehicular;
	}
	public String getTipoSubRemolque() {
		return tipoSubRemolque;
	}
	public void setTipoSubRemolque(String tipoSubRemolque) {
		this.tipoSubRemolque = tipoSubRemolque;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	public String getFlete() {
		return flete;
	}
	public void setFlete(String flete) {
		this.flete = flete;
	}
	public String getImpuestoRetencion() {
		return impuestoRetencion;
	}
	public void setImpuestoRetencion(String impuestoRetencion) {
		this.impuestoRetencion = impuestoRetencion;
	}
	public String getTipoFactorRetencion() {
		return tipoFactorRetencion;
	}
	public void setTipoFactorRetencion(String tipoFactorRetencion) {
		this.tipoFactorRetencion = tipoFactorRetencion;
	}
	public String getTasaRetencion() {
		return tasaRetencion;
	}
	public void setTasaRetencion(String tasaRetencion) {
		this.tasaRetencion = tasaRetencion;
	}
	public BigDecimal getIva() {
		return iva;
	}
	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public String getRetencion() {
		return retencion;
	}
	public void setRetencion(String retencion) {
		this.retencion = retencion;
	}
	public BigDecimal getNetoPagar() {
		return netoPagar;
	}
	public void setNetoPagar(BigDecimal netoPagar) {
		this.netoPagar = netoPagar;
	}
	public String getCadenaOriginal() {
		return cadenaOriginal;
	}
	public void setCadenaOriginal(String cadenaOriginal) {
		this.cadenaOriginal = cadenaOriginal;
	}
	public String getSelloDigitalCFDI() {
		return selloDigitalCFDI;
	}
	public void setSelloDigitalCFDI(String selloDigitalCFDI) {
		this.selloDigitalCFDI = selloDigitalCFDI;
	}
	public String getSelloDigitalSAT() {
		return selloDigitalSAT;
	}
	public void setSelloDigitalSAT(String selloDigitalSAT) {
		this.selloDigitalSAT = selloDigitalSAT;
	}
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
	public String getMsjError() {
		return msjError;
	}
	public void setMsjError(String msjError) {
		this.msjError = msjError;
	}
	
	public String getCodigoQR() {
		return codigoQR;
	}
	public void setCodigoQR(String codigoQR) {
		this.codigoQR = codigoQR;
	}
	
	public String getsXmlTimbrado() {
		return sXmlTimbrado;
	}
	public void setsXmlTimbrado(String sXmlTimbrado) {
		this.sXmlTimbrado = sXmlTimbrado;
	}		
	public String getRutaStorage() {
		return rutaStorage;
	}
	public void setRutaStorage(String rutaStorage) {
		this.rutaStorage = rutaStorage;
	}
	public Integer getOption() {
		return option;
	}
	public void setOption(Integer option) {
		this.option = option;
	}
	public String getRutaFile() {
		return rutaFile;
	}
	public void setRutaFile(String rutaFile) {
		this.rutaFile = rutaFile;
	}

	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	
	public String getRutaPlantilla() {
		return rutaPlantilla;
	}
	public void setRutaPlantilla(String rutaPlantilla) {
		this.rutaPlantilla = rutaPlantilla;
	}
	
	public String getNameCarpeta() {
		return nameCarpeta;
	}
	public void setNameCarpeta(String nameCarpeta) {
		this.nameCarpeta = nameCarpeta;
	}
	
	public String getRutaQR() {
		return rutaQR;
	}
	public void setRutaQR(String rutaQR) {
		this.rutaQR = rutaQR;
	}	
	public Integer getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	public Integer getNumeroControl() {
		return numeroControl;
	}
	public void setNumeroControl(Integer numeroControl) {
		this.numeroControl = numeroControl;
	}
	public Integer getIdCiudades() {
		return idCiudades;
	}
	public void setIdCiudades(Integer idCiudades) {
		this.idCiudades = idCiudades;
	}
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}	
	public String getDireccionOrigen() {
		return direccionOrigen;
	}
	public void setDireccionOrigen(String direccionOrigen) {
		this.direccionOrigen = direccionOrigen;
	}
	public String getLugarExpedicion() {
		return lugarExpedicion;
	}
	public void setLugarExpedicion(String lugarExpedicion) {
		this.lugarExpedicion = lugarExpedicion;
	}
	public String getDireccionOperador() {
		return direccionOperador;
	}
	public void setDireccionOperador(String direccionOperador) {
		this.direccionOperador = direccionOperador;
	}
	
	public String getObservacionesCP() {
		return observacionesCP;
	}
	public void setObservacionesCP(String observacionesCP) {
		this.observacionesCP = observacionesCP;
	}
	
	public JRBeanCollectionDataSource getArticulos() {
		return articulos;
	}
	public void setArticulos(JRBeanCollectionDataSource articulos) {
		this.articulos = articulos;
	}
	public JRBeanCollectionDataSource getServicios() {
		return servicios;
	}
	public void setServicios(JRBeanCollectionDataSource servicios) {
		this.servicios = servicios;
	}
	public String getAseguraCarga() {
		return aseguraCarga;
	}
	public void setAseguraCarga(String aseguraCarga) {
		this.aseguraCarga = aseguraCarga;
	}
	public String getPolizaCarga() {
		return polizaCarga;
	}
	public void setPolizaCarga(String polizaCarga) {
		this.polizaCarga = polizaCarga;
	}
	public Impresion() {
	}
			


}
