package backend.dto;

import java.math.BigDecimal;

public class TalonesInforme {
	private Integer idTalones;
	private Integer idEstatusProceso;
	private Integer idEstatusImpresion;
	private Integer idInformesTalones;
	
	private Integer NumeroControl;
	private Integer IdPolizasSeguroCliente;
	private String FechaProximaLlegada;
	private BigDecimal ValorDeclarado;
	private BigDecimal ValorFlete ;
	private BigDecimal ValorSeguro;
	private BigDecimal ValorDescarga;
	private BigDecimal ValorTransbordador;
	private BigDecimal ValorEntrega;
	private BigDecimal ValorCarga;
	private BigDecimal ValorRecoleccion;
	private BigDecimal ImporteSubTotal;
	private BigDecimal ImporteIVA;
	private BigDecimal ImporteRetencion;
	private BigDecimal ImporteTotal;
	private BigDecimal ImporteNetoPagar;
	
	private Integer idEmpleado;
	
	/*TL.IdTalones ,TL.NumeroControl,TL.IdInformesTalones,TL.IdPolizasSeguroCliente,
  	 TL.FechaProximaLlegada, TL.ValorDeclarado,TL.ValorFlete,TL.ValorSeguro,TL.ValorDescarga,TL.ValorTransbordador,
	 TL.ValorEntrega,TL.ValorCarga,TL.ValorRecoleccion,TL.ImporteSubTotal,TL.ImporteIVA,TL.ImporteRetencion,
	 TL.ImporteTotal,TL.ImporteNetoPagar */
	
	



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
		return NumeroControl;
	}

	public void setNumeroControl(Integer numeroControl) {
		NumeroControl = numeroControl;
	}

	public Integer getIdPolizasSeguroCliente() {
		return IdPolizasSeguroCliente;
	}

	public void setIdPolizasSeguroCliente(Integer idPolizasSeguroCliente) {
		IdPolizasSeguroCliente = idPolizasSeguroCliente;
	}

	public String getFechaProximaLlegada() {
		return FechaProximaLlegada;
	}

	public void setFechaProximaLlegada(String fechaProximaLlegada) {
		FechaProximaLlegada = fechaProximaLlegada;
	}

	public BigDecimal getValorDeclarado() {
		return ValorDeclarado;
	}

	public void setValorDeclarado(BigDecimal valorDeclarado) {
		ValorDeclarado = valorDeclarado;
	}

	public BigDecimal getValorFlete() {
		return ValorFlete;
	}

	public void setValorFlete(BigDecimal valorFlete) {
		ValorFlete = valorFlete;
	}

	public BigDecimal getValorSeguro() {
		return ValorSeguro;
	}

	public void setValorSeguro(BigDecimal valorSeguro) {
		ValorSeguro = valorSeguro;
	}

	public BigDecimal getValorDescarga() {
		return ValorDescarga;
	}

	public void setValorDescarga(BigDecimal valorDescarga) {
		ValorDescarga = valorDescarga;
	}

	public BigDecimal getValorTransbordador() {
		return ValorTransbordador;
	}

	public void setValorTransbordador(BigDecimal valorTransbordador) {
		ValorTransbordador = valorTransbordador;
	}

	public BigDecimal getValorEntrega() {
		return ValorEntrega;
	}

	public void setValorEntrega(BigDecimal valorEntrega) {
		ValorEntrega = valorEntrega;
	}

	public BigDecimal getValorCarga() {
		return ValorCarga;
	}

	public void setValorCarga(BigDecimal valorCarga) {
		ValorCarga = valorCarga;
	}

	public BigDecimal getValorRecoleccion() {
		return ValorRecoleccion;
	}

	public void setValorRecoleccion(BigDecimal valorRecoleccion) {
		ValorRecoleccion = valorRecoleccion;
	}

	public BigDecimal getImporteSubTotal() {
		return ImporteSubTotal;
	}

	public void setImporteSubTotal(BigDecimal importeSubTotal) {
		ImporteSubTotal = importeSubTotal;
	}

	public BigDecimal getImporteIVA() {
		return ImporteIVA;
	}

	public void setImporteIVA(BigDecimal importeIVA) {
		ImporteIVA = importeIVA;
	}

	public BigDecimal getImporteRetencion() {
		return ImporteRetencion;
	}

	public void setImporteRetencion(BigDecimal importeRetencion) {
		ImporteRetencion = importeRetencion;
	}

	public BigDecimal getImporteTotal() {
		return ImporteTotal;
	}

	public void setImporteTotal(BigDecimal importeTotal) {
		ImporteTotal = importeTotal;
	}

	public BigDecimal getImporteNetoPagar() {
		return ImporteNetoPagar;
	}

	public void setImporteNetoPagar(BigDecimal importeNetoPagar) {
		ImporteNetoPagar = importeNetoPagar;
	}
	
	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public TalonesInforme(){}

	public TalonesInforme(Integer idInformesTalones) {
		this.idInformesTalones = idInformesTalones;
	}

	public TalonesInforme(Integer idInformesTalones, Integer idEmpleado) {
		this.idInformesTalones = idInformesTalones;
		this.idEmpleado = idEmpleado;
	}
	
	
	
}
