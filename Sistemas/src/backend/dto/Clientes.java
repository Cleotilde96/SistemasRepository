package backend.dto;

public class Clientes {
	
	private Integer idCliente;
	private String nombre;
	private String apellidoUno;
	private String apellidoDos;
	private String rfc;
	private String direccion;
	private String localidad;
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoUno() {
		return apellidoUno;
	}
	public void setApellidoUno(String apellidoUno) {
		this.apellidoUno = apellidoUno;
	}
	public String getApellidoDos() {
		return apellidoDos;
	}
	public void setApellidoDos(String apellidoDos) {
		this.apellidoDos = apellidoDos;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public Clientes(){}
	public Clientes(String nombre, String apellidoUno, String apellidoDos) {
		this.nombre = nombre;
		this.apellidoUno = apellidoUno;
		this.apellidoDos = apellidoDos;
	}
	
	
	

}
