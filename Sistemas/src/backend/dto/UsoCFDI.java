package backend.dto;

public class UsoCFDI {
	
	private Integer idcUsoCFDI;
	private String cUsoCFDI;
	private String descripcion;
	
	public Integer getIdcUsoCFDI() {
		return idcUsoCFDI;
	}
	public void setIdcUsoCFDI(Integer idcUsoCFDI) {
		this.idcUsoCFDI = idcUsoCFDI;
	}
	public String getcUsoCFDI() {
		return cUsoCFDI;
	}
	public void setcUsoCFDI(String cUsoCFDI) {
		this.cUsoCFDI = cUsoCFDI;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public UsoCFDI(Integer idcUsoCFDI, String cUsoCFDI, String descripcion) {
		this.idcUsoCFDI = idcUsoCFDI;
		this.cUsoCFDI = cUsoCFDI;
		this.descripcion = descripcion;
	}
	public UsoCFDI() {}
	
	public String toString() {
		return "UsoCFDI [idcUsoCFDI=" + idcUsoCFDI + ", cUsoCFDI=" + cUsoCFDI + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
	
	
}
