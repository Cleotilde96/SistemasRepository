package backend.enums;

public enum EnumLogin {
	
	USERAUTHENTICATION("SELECT US.IdUsuariosSistemaWeb,US.IdEmpleados,US.IdTipoAccesoSistema,US.Bloqueo, ISNULL(E.NombreEmpleado,'')+' '+ ISNULL(E.ApellidoPaterno,'')+' '+ISNULL(E.ApellidoMaterno,'') Nombre  FROM UsuariosSistemaWeb US  LEFT JOIN Empleados E ON US.IdEmpleados = E.IdEmpleados  WHERE (NombreUsuario = ?) AND (ContraseniaUsuario = ?)  AND (FechaDesactiva IS NULL )");
	
	private final String query;

	public String getQuery() {
		return query;
	}

	private EnumLogin(String query) {
		this.query = query;
	}

	
    

}
