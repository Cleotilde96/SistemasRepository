package backend.dto;

import java.math.BigDecimal;

public class Montos {
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
	public Montos() {
	}
}
