package backend.enums;

public enum EnumArticulos {
	
	REMITENTE("REMITENTE"),
	DESTINATARIO("DESTINATARIO"),
	ARTICULOSCLIENTES("SELECT CCUP.Id_c_ClaveUnidadPeso,CCUP.ClaveUnidad,CCUP.Nombre,CCPS.Id_c_ClaveProdServCP, CCPS.ClaveProducto,CCPS.Descripcion  FROM ClientesH_CodigosCCartaPorte CLCP LEFT JOIN C_CodigosClientes_CCartaPorte CDCP ON CLCP.IdC_CodigosClientes_CCartaPorte = CDCP.IdC_CodigosClientes_CCartaPorte LEFT JOIN C_ClaveUnidadPeso CCUP ON CDCP.Id_c_ClaveUnidadPeso = CCUP.Id_c_ClaveUnidadPeso LEFT JOIN C_ClaveProdServCP CCPS  ON   CDCP.Id_c_ClaveProdServCP = CCPS.Id_c_ClaveProdServCP WHERE  CDCP.IdEstatusProceso=10 AND CCUP.IdEstatusProceso=10 AND CCPS.IdEstatusProceso=10  AND  CLCP.IdClientes=?"),
	//TIPOARTICULOS("SELECT CCUP.Id_c_ClaveUnidadPeso, CCUP.Nombre +' '+ ISNULL(CCUP.ClaveUnidad,'')tipoArticulo  FROM C_Articulos_ClaveUnidadPeso CCPU LEFT JOIN C_ClaveUnidadPeso CCUP ON CCPU.Id_c_ClaveUnidadPeso = CCUP.Id_c_ClaveUnidadPeso WHERE CCPU.IdEstatusProceso =10 AND CCUP.IdEstatusProceso=10"),
	//TIPOARTICULOS("SELECT CCUP.Id_c_ClaveUnidadPeso, ATC.TipoArticulo +' '+ ISNULL(CCUP.ClaveUnidad,'')tipoArticulo  FROM  Articulos ATC LEFT JOIN C_Articulos_ClaveUnidadPeso CCPU ON  ATC.IdArticulos = CCPU.IdArticulos LEFT JOIN C_ClaveUnidadPeso CCUP ON CCPU.Id_c_ClaveUnidadPeso = CCUP.Id_c_ClaveUnidadPeso  WHERE  CCPU.IdEstatusProceso =10 AND CCUP.IdEstatusProceso=10 AND ATC.IdEstatusProceso=10"),
	TIPOARTICULOS("SELECT CCUP.Id_c_ClaveUnidadPeso, ATC.TipoArticulo +' '+ ISNULL(CCUP.ClaveUnidad,'')tipoArticulo   FROM  Articulos ATC  LEFT JOIN C_Articulos_ClaveUnidadPeso CCPU ON  ATC.IdArticulos = CCPU.IdArticulos  LEFT JOIN C_ClaveUnidadPeso CCUP ON CCPU.Id_c_ClaveUnidadPeso = CCUP.Id_c_ClaveUnidadPeso   WHERE  CCPU.IdEstatusProceso =10 AND CCUP.IdEstatusProceso=10 AND (ATC.IdEstatusProceso=10 OR ATC.IdEstatusProceso=34)"),
	CLAVEPRODUCTO("SELECT  Id_c_ClaveProdServCP,Descripcion FROM C_ClaveProdServCP WHERE ClaveProducto=? AND IdEstatusProceso=10"),
	SPICODIGOSCLIENTES("[perli].[spi_CodigosClientes_CCartaPorte] ?,?,?,?"),
	SPICLIENTESHCODIGOS("[perli].[spi_ClientesH_CodigosCCartaPorte] ?,?,?"),
	ASIGCODIGOSCLIENTES("SELECT CCP.ClaveProducto,CCP.Descripcion  FROM ClientesH_CodigosCCartaPorte CHC LEFT JOIN C_CodigosClientes_CCartaPorte CCC ON CHC.IdC_CodigosClientes_CCartaPorte=CCC.IdC_CodigosClientes_CCartaPorte LEFT JOIN C_ClaveUnidadPeso CCU ON CCC.Id_c_ClaveUnidadPeso = CCU.Id_c_ClaveUnidadPeso LEFT JOIN C_ClaveProdServCP CCP ON CCC.Id_c_ClaveProdServCP = CCP.Id_c_ClaveProdServCP WHERE  CHC.IdClientesH_CodigosCCartaPorte=?"),
	CLIENTES("SELECT LTRIM(RTRIM(Cli.IdClientes))AS IdCliente ,LTRIM(RTRIM(Cli.NombreCliente + ' ' + Cli.ApellidoPaterno + ' ' + Cli.ApellidoMaterno)) 	AS Nombre, REPLACE(RTRIM(LTRIM(Cli.Rfc)),'','-')AS RFC,Cli.Calle+' '+Cli.Numero AS Direccion, C.NombreCiudad + '/' + 	E.ClaveEstado AS Localidad   FROM Clientes Cli  LEFT JOIN Ciudades C 	ON Cli.IdCiudades = C.IdCiudades  LEFT JOIN Estados E ON E.IdEstados = C.IdEstados  LEFT JOIN (SELECT TOP(1) IdClientes, IdEmpleados  FROM ClientesHistorial  WHERE (TipoMovto = 'A') ) Alta ON Cli.IdClientes = Alta.IdClientes  LEFT JOIN UsuariosSistema US  ON Alta.IdEmpleados =  US.IdEmpleados WHERE Cli.IdEstatusProceso = 10"),
	NOMBRECLIENTES(" AND Cli.NombreCliente like ? "),
	APELLIDOUNO(" AND Cli.ApellidoPaterno like ? "),
	APELLIDODOS(" AND Cli.ApellidoMaterno like ? "),
	IDCLIENTE(" AND Cli.IdClientes=? "),
	SELECTCLIENTESARTICULOS("SELECT CLC.IdClientes,ISNULL(CL.NombreCliente,'') +' '+ISNULL(CL.ApellidoPaterno,'')+' '+ISNULL(CL.ApellidoMaterno,'')NombreCliente, CVU.ClaveUnidad,CVU.Nombre,CCP.ClaveProducto,CCP.Descripcion FROM ClientesH_CodigosCCartaPorte CLC LEFT JOIN Clientes CL ON  CLC.IdClientes = CL.IdClientes LEFT JOIN C_CodigosClientes_CCartaPorte CCC  ON CLC.IdC_CodigosClientes_CCartaPorte = CCC.IdC_CodigosClientes_CCartaPorte LEFT JOIN C_ClaveUnidadPeso CVU ON CCC.Id_c_ClaveUnidadPeso = CVU.Id_c_ClaveUnidadPeso LEFT JOIN C_ClaveProdServCP CCP ON CCC.Id_c_ClaveProdServCP= CCP.Id_c_ClaveProdServCP WHERE 	CCC.IdEstatusProceso=10");
	
	
	
	
	
	private final String query;

	public String getQuery() {
		return query;
	}

	private EnumArticulos(String query) {
		this.query = query;
	}

}
