package backend.dto;

public class FormaPago {
		
	private Integer  idFormaPagoClaves;
	private Integer cFormaPago;
	private String formaPago;
	
	public Integer getIdFormaPagoClaves() {
		return idFormaPagoClaves;
	}
	public void setIdFormaPagoClaves(Integer idFormaPagoClaves) {
		this.idFormaPagoClaves = idFormaPagoClaves;
	}
	public Integer getcFormaPago() {
		return cFormaPago;
	}
	public void setcFormaPago(Integer cFormaPago) {
		this.cFormaPago = cFormaPago;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	public FormaPago(Integer idFormaPagoClaves, Integer cFormaPago, String formaPago) {
		this.idFormaPagoClaves = idFormaPagoClaves;
		this.cFormaPago = cFormaPago;
		this.formaPago = formaPago;
	}
	public FormaPago() {
	}
	
	
	
}
