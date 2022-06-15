package backend.dto;

import java.math.BigDecimal;

public class CartaPorte {
	
	private Integer idCCartaPorte;
	private Integer idTalones;
	private Integer idEstatusProceso; 
	private Integer idEstatusImpresion;
	private Integer idCPColDestino;
	private Integer idClientes;
	private Integer idClientesHistorial ;
	private Integer idDireccionesEntrega;
	private Integer idInformes;
	private Integer idCiudadesDistancias;
	private Integer idCLocalidad_O;
	private Integer idPolizasSeguroCliente;
	private Integer idCTractoConfigAutotrans;	  
	private Integer idCRemSubTipoRem;
	private Integer idEmpleado;
	private Integer idCPColOperador;
	private Integer idCCartaPorteRelacionado;
	private String  fechaCartaPorte;
	private Integer folio;
	private String nombreCliente;
	private Integer usoCFDI;
	private Integer formaPago;
	private Double kmsRecorridos;
	private String fechaProximaLlegada;
	private String fechaHoraSalida;
	private Integer numTotalMercancia;
	private BigDecimal valorDeclarado;
	private BigDecimal valorFlete;
	private BigDecimal valorSeguro;
	private BigDecimal valorDescarga;
	private BigDecimal valorTransbordador;
	private BigDecimal valorEntrega;
	private BigDecimal valorCarga;
	private BigDecimal valorRecoleccion;
	private BigDecimal importeSubTotal;
	private BigDecimal importeIVA;
	private BigDecimal importeRetencion;
	private BigDecimal importeTotal;
	private BigDecimal importeNetoPagar;
	private String cadenaCancelacion;
	private String  observaciones;
	private Integer idCPColRecolecciones;
	private Integer numeroControl;
	private String serie;
	

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
	public Integer getIdCPColDestino() {
		return idCPColDestino;
	}
	public void setIdCPColDestino(Integer idCPColDestino) {
		this.idCPColDestino = idCPColDestino;
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
	public Integer getIdInformes() {
		return idInformes;
	}
	public void setIdInformes(Integer idInformes) {
		this.idInformes = idInformes;
	}
	public Integer getIdCiudadesDistancias() {
		return idCiudadesDistancias;
	}
	public void setIdCiudadesDistancias(Integer idCiudadesDistancias) {
		this.idCiudadesDistancias = idCiudadesDistancias;
	}
	public Integer getIdCLocalidad_O() {
		return idCLocalidad_O;
	}
	public void setIdCLocalidad_O(Integer idCLocalidad_O) {
		this.idCLocalidad_O = idCLocalidad_O;
	}
	public Integer getIdPolizasSeguroCliente() {
		return idPolizasSeguroCliente;
	}
	public void setIdPolizasSeguroCliente(Integer idPolizasSeguroCliente) {
		this.idPolizasSeguroCliente = idPolizasSeguroCliente;
	}
	public Integer getIdCTractoConfigAutotrans() {
		return idCTractoConfigAutotrans;
	}
	public void setIdCTractoConfigAutotrans(Integer idCTractoConfigAutotrans) {
		this.idCTractoConfigAutotrans = idCTractoConfigAutotrans;
	}
	public Integer getIdCRemSubTipoRem() {
		return idCRemSubTipoRem;
	}
	public void setIdCRemSubTipoRem(Integer idCRemSubTipoRem) {
		this.idCRemSubTipoRem = idCRemSubTipoRem;
	}
	public Integer getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public Integer getIdCPColOperador() {
		return idCPColOperador;
	}
	public void setIdCPColOperador(Integer idCPColOperador) {
		this.idCPColOperador = idCPColOperador;
	}
	public Integer getIdCCartaPorteRelacionado() {
		return idCCartaPorteRelacionado;
	}
	public void setIdCCartaPorteRelacionado(Integer idCCartaPorteRelacionado) {
		this.idCCartaPorteRelacionado = idCCartaPorteRelacionado;
	}
	public String getFechaCartaPorte() {
		return fechaCartaPorte;
	}
	public void setFechaCartaPorte(String fechaCartaPorte) {
		this.fechaCartaPorte = fechaCartaPorte;
	}
	public Integer getFolio() {
		return folio;
	}
	public void setFolio(Integer folio) {
		this.folio = folio;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public Integer getUsoCFDI() {
		return usoCFDI;
	}
	public void setUsoCFDI(Integer usoCFDI) {
		this.usoCFDI = usoCFDI;
	}
	public Integer getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(Integer formaPago) {
		this.formaPago = formaPago;
	}
	public Double getKmsRecorridos() {
		return kmsRecorridos;
	}
	public void setKmsRecorridos(Double kmsRecorridos) {
		this.kmsRecorridos = kmsRecorridos;
	}
	public String getFechaProximaLlegada() {
		return fechaProximaLlegada;
	}
	public void setFechaProximaLlegada(String fechaProximaLlegada) {
		this.fechaProximaLlegada = fechaProximaLlegada;
	}
	public String getFechaHoraSalida() {
		return fechaHoraSalida;
	}
	public void setFechaHoraSalida(String fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}
	public Integer getNumTotalMercancia() {
		return numTotalMercancia;
	}
	public void setNumTotalMercancia(Integer numTotalMercancia) {
		this.numTotalMercancia = numTotalMercancia;
	}
	public BigDecimal getValorDeclarado() {
		return valorDeclarado;
	}
	public void setValorDeclarado(BigDecimal valorDeclarado) {
		this.valorDeclarado = valorDeclarado;
	}
	public BigDecimal getValorFlete() {
		return valorFlete;
	}
	public void setValorFlete(BigDecimal valorFlete) {
		this.valorFlete = valorFlete;
	}
	public BigDecimal getValorSeguro() {
		return valorSeguro;
	}
	public void setValorSeguro(BigDecimal valorSeguro) {
		this.valorSeguro = valorSeguro;
	}
	public BigDecimal getValorDescarga() {
		return valorDescarga;
	}
	public void setValorDescarga(BigDecimal valorDescarga) {
		this.valorDescarga = valorDescarga;
	}
	public BigDecimal getValorTransbordador() {
		return valorTransbordador;
	}
	public void setValorTransbordador(BigDecimal valorTransbordador) {
		this.valorTransbordador = valorTransbordador;
	}
	public BigDecimal getValorEntrega() {
		return valorEntrega;
	}
	public void setValorEntrega(BigDecimal valorEntrega) {
		this.valorEntrega = valorEntrega;
	}
	public BigDecimal getValorCarga() {
		return valorCarga;
	}
	public void setValorCarga(BigDecimal valorCarga) {
		this.valorCarga = valorCarga;
	}
	public BigDecimal getValorRecoleccion() {
		return valorRecoleccion;
	}
	public void setValorRecoleccion(BigDecimal valorRecoleccion) {
		this.valorRecoleccion = valorRecoleccion;
	}
	public BigDecimal getImporteSubTotal() {
		return importeSubTotal;
	}
	public void setImporteSubTotal(BigDecimal importeSubTotal) {
		this.importeSubTotal = importeSubTotal;
	}
	public BigDecimal getImporteIVA() {
		return importeIVA;
	}
	public void setImporteIVA(BigDecimal importeIVA) {
		this.importeIVA = importeIVA;
	}
	public BigDecimal getImporteRetencion() {
		return importeRetencion;
	}
	public void setImporteRetencion(BigDecimal importeRetencion) {
		this.importeRetencion = importeRetencion;
	}
	public BigDecimal getImporteTotal() {
		return importeTotal;
	}
	public void setImporteTotal(BigDecimal importeTotal) {
		this.importeTotal = importeTotal;
	}
	public BigDecimal getImporteNetoPagar() {
		return importeNetoPagar;
	}
	public void setImporteNetoPagar(BigDecimal importeNetoPagar) {
		this.importeNetoPagar = importeNetoPagar;
	}
	public String getCadenaCancelacion() {
		return cadenaCancelacion;
	}
	public void setCadenaCancelacion(String cadenaCancelacion) {
		this.cadenaCancelacion = cadenaCancelacion;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Integer getIdCPColRecolecciones() {
		return idCPColRecolecciones;
	}
	public void setIdCPColRecolecciones(Integer idCPColRecolecciones) {
		this.idCPColRecolecciones = idCPColRecolecciones;
	}
	
	public Integer getNumeroControl() {
		return numeroControl;
	}
	public void setNumeroControl(Integer numeroControl) {
		this.numeroControl = numeroControl;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public CartaPorte(){}
	@Override
	public String toString() {
		return "CartaPorte [idCCartaPorte=" + idCCartaPorte + ", idTalones=" + idTalones + ", idEstatusProceso="
				+ idEstatusProceso + ", idEstatusImpresion=" + idEstatusImpresion + ", idCPColDestino=" + idCPColDestino
				+ ", idClientes=" + idClientes + ", idClientesHistorial=" + idClientesHistorial
				+ ", idDireccionesEntrega=" + idDireccionesEntrega + ", idInformes=" + idInformes
				+ ", idCiudadesDistancias=" + idCiudadesDistancias + ", idCLocalidad_O=" + idCLocalidad_O
				+ ", idPolizasSeguroCliente=" + idPolizasSeguroCliente + ", idCTractoConfigAutotrans="
				+ idCTractoConfigAutotrans + ", idCRemSubTipoRem=" + idCRemSubTipoRem + ", idEmpleado=" + idEmpleado
				+ ", idCPColOperador=" + idCPColOperador + ", idCCartaPorteRelacionado=" + idCCartaPorteRelacionado
				+ ", fechaCartaPorte=" + fechaCartaPorte + ", folio=" + folio + ", nombreCliente=" + nombreCliente
				+ ", usoCFDI=" + usoCFDI + ", formaPago=" + formaPago + ", kmsRecorridos=" + kmsRecorridos
				+ ", fechaProximaLlegada=" + fechaProximaLlegada + ", fechaHoraSalida=" + fechaHoraSalida
				+ ", numTotalMercancia=" + numTotalMercancia + ", valorDeclarado=" + valorDeclarado + ", valorFlete="
				+ valorFlete + ", valorSeguro=" + valorSeguro + ", valorDescarga=" + valorDescarga
				+ ", valorTransbordador=" + valorTransbordador + ", valorEntrega=" + valorEntrega + ", valorCarga="
				+ valorCarga + ", valorRecoleccion=" + valorRecoleccion + ", importeSubTotal=" + importeSubTotal
				+ ", importeIVA=" + importeIVA + ", importeRetencion=" + importeRetencion + ", importeTotal="
				+ importeTotal + ", importeNetoPagar=" + importeNetoPagar + ", cadenaCancelacion=" + cadenaCancelacion
				+ ", observaciones=" + observaciones + ", idCPColRecolecciones=" + idCPColRecolecciones + "]";
	}
	
	
	 
	
	
	
}
