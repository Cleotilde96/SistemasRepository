package backend.dto;

public class ArticulosTalones {
	
	private Integer idArticulos;
	private String tipoArticulo;
	private Integer cantidadArticulos;
	private String peso;
	private String contiene;
	private Double pesoKg;
	
	
	public Integer getIdArticulos() {
		return idArticulos;
	}
	public void setIdArticulos(Integer idArticulos) {
		this.idArticulos = idArticulos;
	}
	public String getTipoArticulo() {
		return tipoArticulo;
	}
	public void setTipoArticulo(String tipoArticulo) {
		this.tipoArticulo = tipoArticulo;
	}
	public Integer getCantidadArticulos() {
		return cantidadArticulos;
	}
	public void setCantidadArticulos(Integer cantidadArticulos) {
		this.cantidadArticulos = cantidadArticulos;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getContiene() {
		return contiene;
	}
	public void setContiene(String contiene) {
		this.contiene = contiene;
	}
	public Double getPesoKg() {
		return pesoKg;
	}
	public void setPesoKg(Double pesoKg) {
		this.pesoKg = pesoKg;
	}
	public ArticulosTalones() {}
	
	
	public String toString() {
		return "ArticulosTalones [idArticulos=" + idArticulos + ", tipoArticulo=" + tipoArticulo
				+ ", cantidadArticulos=" + cantidadArticulos + ", peso=" + peso + ", contiene=" + contiene + ", pesoKg="
				+ pesoKg + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
