package backend.dto;

public class LoginUsers {

	// IdUsuariosSistemaWeb IdEmpleados IdTipoAccesoSistema Bloqueo Nombre
	private Integer idUsuariosSistemaWeb;
	private Integer idEmpleados;
	private Integer idTipoAccesoSistema;
	private String bloqueo;
	private String nombre;

	public Integer getIdUsuariosSistemaWeb() {
		return idUsuariosSistemaWeb;
	}

	public void setIdUsuariosSistemaWeb(Integer idUsuariosSistemaWeb) {
		this.idUsuariosSistemaWeb = idUsuariosSistemaWeb;
	}

	public Integer getIdEmpleados() {
		return idEmpleados;
	}

	public void setIdEmpleados(Integer idEmpleados) {
		this.idEmpleados = idEmpleados;
	}

	public Integer getIdTipoAccesoSistema() {
		return idTipoAccesoSistema;
	}

	public void setIdTipoAccesoSistema(Integer idTipoAccesoSistema) {
		this.idTipoAccesoSistema = idTipoAccesoSistema;
	}

	public String getBloqueo() {
		return bloqueo;
	}

	public void setBloqueo(String bloqueo) {
		this.bloqueo = bloqueo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LoginUsers() {
	}

}
