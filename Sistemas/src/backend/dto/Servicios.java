package backend.dto;

import java.math.BigDecimal;

public class Servicios {

	private String clave_Servicio;
	private String cantidad;
	private String clave_Unidad;
	private String unidad;
	private String descripcion;
	private BigDecimal importe;
 
	public String getClave_Servicio() {
		return clave_Servicio;
	}

	public void setClave_Servicio(String clave_Servicio) {
		this.clave_Servicio = clave_Servicio;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getClave_Unidad() {
		return clave_Unidad;
	}

	public void setClave_Unidad(String clave_Unidad) {
		this.clave_Unidad = clave_Unidad;
	}
	public String getUnidad(){
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public Servicios() {

	}

}
