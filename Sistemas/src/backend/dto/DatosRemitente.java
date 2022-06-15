package backend.dto;

public class DatosRemitente {

	String rfcRemitente;
	String nombreRemitente;
	String calleRemi;
	String localidadRemi;
	String coloniaRemi;
	String municipioRemi;
	String CodigoPostal;
	String estadoRemi;
	
	
	public DatosRemitente() {
		// TODO Auto-generated constructor stub
	}
	
		
	public String getCodigoPostal() {
		return CodigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		CodigoPostal = codigoPostal;
	}



	public String getRfcRemitente() {
		return rfcRemitente;
	}
	public void setRfcRemitente(String rfcRemitente) {
		this.rfcRemitente = rfcRemitente;
	}
	public String getNombreRemitente() {
		return nombreRemitente;
	}
	public void setNombreRemitente(String nombreRemitente) {
		this.nombreRemitente = nombreRemitente;
	}
	public String getCalleRemi() {
		return calleRemi;
	}
	public void setCalleRemi(String calleRemi) {
		this.calleRemi = calleRemi;
	}
	public String getLocalidadRemi() {
		return localidadRemi;
	}
	public void setLocalidadRemi(String localidadRemi) {
		this.localidadRemi = localidadRemi;
	}
	public String getColoniaRemi() {
		return coloniaRemi;
	}
	public void setColoniaRemi(String coloniaRemi) {
		this.coloniaRemi = coloniaRemi;
	}
	public String getMunicipioRemi() {
		return municipioRemi;
	}
	public void setMunicipioRemi(String municipioRemi) {
		this.municipioRemi = municipioRemi;
	}
	
	public String getEstadoRemi() {
		return estadoRemi;
	}
	public void setEstadoRemi(String estadoRemi) {
		this.estadoRemi = estadoRemi;
	}
	

	@Override
	public String toString() {
		return "DatosRemitente [rfcRemitente=" + rfcRemitente + ", nombreRemitente=" + nombreRemitente + ", calleRemi="
				+ calleRemi + ", localidadRemi=" + localidadRemi + ", coloniaRemi=" + coloniaRemi + ", municipioRemi="
				+ municipioRemi + ", estadoRemi=" + estadoRemi  + "]";
	}
	
	
}
