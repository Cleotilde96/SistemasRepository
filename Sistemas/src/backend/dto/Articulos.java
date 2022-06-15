package backend.dto;

public class Articulos {

	private Integer cantidad;
	private String claveUnidad;
	private String unidad;
	private String claveProducto;
	private String descripcion;
	private Float pesoEnKgs;

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getClaveUnidad() {
		return claveUnidad;
	}

	public void setClaveUnidad(String claveUnidad) {
		this.claveUnidad = claveUnidad;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getClaveProducto() {
		return claveProducto;
	}

	public void setClaveProducto(String claveProducto) {
		this.claveProducto = claveProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPesoEnKgs() {
		return pesoEnKgs;
	}

	public void setPesoEnKgs(Float pesoEnKgs) {
		this.pesoEnKgs = pesoEnKgs;
	}

	public Articulos() {
	}

}
