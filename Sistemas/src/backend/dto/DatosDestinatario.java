package backend.dto;

public class DatosDestinatario {

	String rfcDestinatario;
	String calleDest;
	String localidadDest;
	String cpDest;
	String coloniaDest;
	String municipioDest;
	String estadoDest;
	
	
	public DatosDestinatario() {
		// TODO Auto-generated constructor stub
	}
	
	public String getRfcDestinatario() {
		return rfcDestinatario;
	}
	public void setRfcDestinatario(String rfcDestinatario) {
		this.rfcDestinatario = rfcDestinatario;
	}
	
	public String getCalleDest() {
		return calleDest;
	}
	public void setCalleDest(String calleDest) {
		this.calleDest = calleDest;
	}
	public String getLocalidadDest() {
		return localidadDest;
	}
	public void setLocalidadDest(String localidadDest) {
		this.localidadDest = localidadDest;
	}
	
	public String getCpDest() {
		return cpDest;
	}
	public void setCpDest(String cpDest) {
		this.cpDest = cpDest;
	}
	public String getColoniaDest() {
		return coloniaDest;
	}
	public void setColoniaDest(String coloniaDest) {
		this.coloniaDest = coloniaDest;
	}
	public String getMunicipioDest() {
		return municipioDest;
	}
	public void setMunicipioDest(String municipioDest) {
		this.municipioDest = municipioDest;
	}
	
	public String getEstadoDest() {
		return estadoDest;
	}
	public void setEstadoDest(String estadoDest) {
		this.estadoDest = estadoDest;
	}
	

	@Override
	public String toString() {
		return "DatosDestinatario [rfcDestinatario=" + rfcDestinatario 
				+ ", calleDest=" + calleDest + ", localidadDest=" + localidadDest + ", cpDest="
				+ cpDest + ", coloniaDest=" + coloniaDest + ", municipioDest=" + municipioDest +  ", estadoDest=" + estadoDest 
				+ "]";
	}
	
	
}
