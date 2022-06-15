package backend.enums;

public enum EnumImpresion {
		
	RUTAPLANTILLATALON("\\CartaPorte\\Plantilla\\CartaPorte_Talon.jrxml"),/*informes y carta porte talon*/
	RUTAPLANTILLA("\\CartaPorte\\Plantilla\\CartaPorte.jrxml"), /*para modulo recolecion carta porte*/
	NAMEFILETALONCARTAPORTE("CartaPorte_"),
	FORMATPDF(".pdf"),
	FORMATXML(".xml"),
	NAMEFILECARTAPORTE("CartaPorte_"),
	RUTASTORAGEPDF("\\CartaPorte\\PDF\\"),
	RUTASTORAGEXML("\\CartaPorte\\XML\\"),
	NAMEFILETALONCARTAPORTEXML("Xml_CartaPorte_"),
	NAMEFILECARTAPORTEXML("CartaPorte_"),
	CARPETAINFORME("CartaPorte-Informe-"),
	CARPETACARTAPORTE("CartaPorte-"),
	RUTASTORAGEQR("\\CartaPorte\\CodigoQR\\"),
	
	
	FORMATIMAGEN("jpg"),
	NAMEIMAGEN("qrL.jpg"),
	RFCPERLI("?re=PEX910515FV0"),
	RFCCLIENTE("&rr="),
	NETOPAGAR("&tt="),
	UUID("&id="),
	LETRAMERIDA("_M"),
	LETRACANCUN("_C"),	
	DIRECCIONORIGENCDMX("Calle: Calzada México Tacuba #907, Colonia San Diego Ocoyoacac, Alcaldía Miguel Hidalgo, C.P. 11290, CDMX. http://www.perliexpress.com.mx/ Tels.: 55270418/55270631/55274808/55277797/55274802/55270729, Fax:53863806"),
	DIRECCIONORIGENCANCUN("Comalco 12 Mz.10 Smz.97 Zona Industrial entre Tonina y Chalchuapa, C.P.77530 Cancún Quintana Roo. http://www.perliexpress.com.mx/ Tels.: 9982068430"),
	DIRECCIONORIGENMERIDA("Calle: 96 No.645 x 77 y 79 Col.Sambulá, C.P.97259 Mérida,Yuc. http://www.perliexpress.com.mx/ Tels.:9841385 / 9841396"),
	LUGAREXPCDMX("Calle: Calzada México Tacuba #907, Colonia San Diego Ocoyoacac, Alcaldía Miguel Hidalgo, C.P. 11290, CDMX."),
	LUGAREXPCANCUN("Comalco 12 Mz.10 Smz.97 Zona Industrial entre Tonina y Chalchuapa, C.P.77530 Cancún Quintana Roo."),
	LUGRAEXPMERIDA("Calle: 96 No.645 x 77 y 79 Col.Sambulá, C.P.97259 Mérida,Yuc."),
	DIRECCIONOPERADORCDMX("Calle: Calzada México Tacuba #907, Colonia San Diego Ocoyoacac, Alcaldía Miguel Hidalgo, C.P. 11290, CDMX."),
	DIRECCIONOPERADORCANCUN("Comalco 12 Mz.10 Smz.97 Zona Industrial entre Tonina y Chalchuapa, C.P.77530 Cancún Quintana Roo."),
	DIRECCIONOPERADORMERIDA("Calle: 96 No.645 x 77 y 79 Col.Sambulá, C.P.97259 Mérida,Yuc."),

	//consultas para llenar la plantilla carta porte talon.
	FACTURADOACLIENTE("SELECT ISNULL(CL.NombreCliente,'')+' '+ISNULL(CL.ApellidoPaterno,'')+' '+ISNULL(CL.ApellidoMaterno,'')NombreCliente,CL.Rfc FROM  Talones T  LEFT JOIN  Talones_Clientes TC ON T.IdTalones = TC.IdTalones LEFT JOIN ClientesHistorial CH ON TC.IdClientes = CH.IdClientesHistorial LEFT JOIN Clientes CL ON CH.IdClientes = CL.IdClientes WHERE T.IdEstatusProceso=1 AND  TC.QuienPaga=-3 AND T.IdTalones=?"),
	ENVIARADIRECCION("SELECT CASE WHEN TC.IdDireccionesEntrega > 0 THEN ISNULL(RTRIM(RTRIM(HDE.Calle) + ' ' + HDE.Numero + ' ' + RTRIM(HDE.Referencia) + ' ' + RTRIM(HDE.Colonia) + ' ' + HDE.CP + ' ' + RTRIM(HDE.DelegacionMunicipio + ' ' + C.NombreCiudad + ' / ' + E.NombreEstado + ' '+ '(' + RTRIM(L.Lada) + ') '+HDE.Telefono) ), '')  ELSE ISNULL(RTRIM(RTRIM(CH.Calle) + ' ' + RTRIM(CH.Numero) + ' ' + RTRIM(CH.Referencia) + ' ' + RTRIM(CH.Colonia) + ' ' +  CH.CP + ' ' + RTRIM(CH.DelegacionMunicipio))  + ' ' + C.NombreCiudad + ' / ' + E.NombreEstado,'') +' ' + CASE WHEN LEN(RTRIM(RTRIM(CH.Telefono1) + '  ' +  RTRIM(CH.Telefono2) + '  ' + RTRIM(CH.Telefono3))) > 0 THEN RTRIM(CASE WHEN  LEN(RTRIM(L.Lada)) > 0 THEN '(' + RTRIM(L.Lada) + ') ' ELSE '' END +  RTRIM(CH.Telefono1) + '  ' + RTRIM(CH.Telefono2) + '  ' + RTRIM(CH.Telefono3)) ELSE  '' END END AS LugarEntrega			    FROM Talones_Clientes TC  LEFT JOIN ClientesHistorial CH ON TC.IdClientes = CH.IdClientesHistorial  LEFT JOIN Ciudades C ON CH.IdCiudades = C.IdCiudades  LEFT JOIN LadasCiudades L ON C.IdLadasCiudades = L.IdLadasCiudades  LEFT JOIN Estados E ON C.IdEstados = E.IdEstados  LEFT JOIN HistorialDireccionesEntrega HDE ON TC.IdDireccionesEntrega = HDE.IdHistorialDireccionesEntrega LEFT JOIN LadasCiudades LDE ON C.IdLadasCiudades = LDE.IdLadasCiudades  WHERE TC.IdTalones =? AND (TC.TipoNodoTC = 'D')"),
	OBSERVACIONES("SELECT ISNULL(SUBSTRING(EF.NombreEmpleado, 1, 1), '') + ISNULL(SUBSTRING(EF.ApellidoPaterno, 1, 1) , '') + ISNULL(SUBSTRING(EF.ApellidoMaterno, 1, 1), '') AS Empleado ,EF.NombreEmpleado +' '+EF.ApellidoPaterno+' '+EF.ApellidoMaterno,CPE.TipoMovto FROM CCartaPorte_Empleados CPE  LEFT JOIN  Empleados EF ON CPE.IdEmpleados = EF.IdEmpleados  WHERE (CPE.IdCCartaPorte =?) AND (CPE.TipoMovto IN('A','G','T','M'))"),
	METODODEPAGO("SELECT[c_MetodoPago] as MetodoPago FROM [PerliExpress].[dbo].[c_MetodoPago] CMP LEFT JOIN Talones_c_MetodoPago TCMP ON TCMP.Id_c_MetodoPago=CMP.Id_c_MetodoPago WHERE IdTalones=?"),
	USOCFDI("SELECT  CUC.Id_c_UsoCFDI,CUC.c_UsoCFDI,CUC.c_UsoCFDI+'/'+CUC.Descripcion AS UsoCFDI   FROM CCartaPorte CCP  LEFT JOIN c_UsoCFDI CUC ON CCP.UsoCFDI =CUC.Id_c_UsoCFDI  WHERE CCP.IdCCartaPorte=?"),
	FORMADEPAGO("SELECT FPC.c_FormaPago+'/'+MP.MetodosPago AS FormaPago FROM CCartaPorte  CCP LEFT JOIN FormasPago_Claves FPC ON CCP.FormaPago = FPC.IdFormaPago_Claves LEFT JOIN MetodosPago MP ON FPC.IdMetodosPago = MP.IdMetodosPago WHERE CCP.IdCCartaPorte =?"),
	//ASEGURADORAPOLIZA("SELECT ASG.NombreAseguradora,PSC.Poliza FROM Talones T LEFT JOIN  PolizasSeguroClientes PSC ON T.IdPolizasSeguroCliente = PSC.IdPolizasSeguroCliente LEFT JOIN  Aseguradoras ASG ON PSC.IdAseguradoras = ASG.IdAseguradoras WHERE T.IdTalones=?"),
	ASEGURADORAPOLIZA("SELECT ASG.IdAseguradoras,ASG.NombreAseguradora, PSC.IdPolizasSeguroCliente,PSC.Poliza  FROM CCartaPorte CP  LEFT JOIN  PolizasSeguroClientes PSC ON CP.IdPolizasSeguroCliente = PSC.IdPolizasSeguroCliente  LEFT JOIN  Aseguradoras ASG ON PSC.IdAseguradoras = ASG.IdAseguradoras WHERE CP.IdTalones=?"),

	OPERADOR("SELECT EMP.IdEmpleados, ISNULL(NombreEmpleado,'')+' '+ISNULL(ApellidoPaterno,'')+' '+ISNULL(ApellidoMaterno,'')NombreOperador ,Rfc RFC, 'TIPO '+RTRIM(LOP.Categoria)+'-'+RTRIM(LOP.LicenciaNumero) Licencia FROM Empleados  EMP LEFT JOIN Empleados_Informes EPI ON EMP.IdEmpleados = EPI.IdEmpleados LEFT JOIN LicenciasOperadores LOP ON EMP.IdEmpleados = LOP.IdEmpleados WHERE EPI.IdInformesTalones=? AND EPI.TipoMovto='O' AND LOP.IdEstatusProceso=10"),
	OPERADORCARTAPORTE("SELECT EMP.IdEmpleados, ISNULL(NombreEmpleado,'')+' '+ISNULL(ApellidoPaterno,'')+' '+ISNULL(ApellidoMaterno,'')NombreOperador ,Rfc RFC,  'TIPO '+RTRIM(LOP.Categoria)+'-'+RTRIM(LOP.LicenciaNumero) Licencia  FROM Empleados  EMP  LEFT JOIN CCartaPorte_Empleados EPC ON EMP.IdEmpleados = EPC.IdEmpleados LEFT JOIN LicenciasOperadores LOP ON EMP.IdEmpleados = LOP.IdEmpleados WHERE EPC.IdCCartaPorte=? AND EPC.TipoMovto='O' AND LOP.IdEstatusProceso=10"),
	TRACTOCAMION("SELECT CAST(CCP.KmsRecorridos AS DECIMAL(10,2))KmsRecorridos,CTC.Placas PlacasTracto,CRS.Placas PlacasRem,CTC.ConfigVehicular,CRS.SubTipoRem FROM CCartaPorte  CCP LEFT JOIN C_Tracto_ConfigAutotrans CTC ON CCP.IdC_Tracto_ConfigAutotrans = CTC.IdC_Tracto_ConfigAutotrans LEFT JOIN C_Rem_SubTipoRem CRS ON CCP.IdC_Rem_SubTipoRem = CRS.IdC_Rem_SubTipoRem WHERE CCP.IdCCartaPorte=?"),
	DATOSTIMBRADO("SELECT sClaveCapturista, dtFechaEmision, dtFechaTimbrado, sUUID, sXmlTimbrado, sCertificadoDigital,  sCertificadoSAT, sCadenaOriginal, sSelloDigitalCFDI, sSelloDigitalSAT  FROM tblFacturacion WHERE (nNumeroFactura = ?) AND (nIdEstatusFactura = 2) AND(sClaveCapturista='L')"),
	
	/*ruta de amacenamiento*/
	FECHACARTAPORTE("SELECT DATENAME(MONTH,FechaCartaPorte) AS mes,YEAR(FechaCartaPorte) as annio,DAY(FechaCartaPorte) dia FROM CCartaPorte WHERE IdCCartaPorte=?"),
	
	/*actulizar estatus impresion*/
	SPUCCARTAPORTEIMPRESION("[perli].[spu_CCartaPorteImpresion] ?,?,?"),
	USUARIOSUCURSAL("SELECT IdCiudades,NombreEmpleado FROM Empleados WHERE IdEmpleados=?"),
	
	
	CANTIDAD_CONCEPTO("1"),
	CLAVEUNIDAD("E48"),
	UNIDAD("SERVICIO"),
	FLETE("FLETE"),
	RETENCION("RETENCION"),
	REC_EVIDENCIA("REC. EVIDENCIA"),
	SEGURO("SEGURO"),
	CARGA("CARGA"),
	DESCARGA("DESCARGA"),
	PEAJE("PEAJE"),
	RECOLECCION("RECOLECCION"),
	CLAVEPRODSERV_802("78101802"),
	CLAVEPRODSERV_800("78101800"),
	ARTICULOS("SELECT CCA.Cantidad,CUP.ClaveUnidad,CUP.Nombre,CPS.ClaveProducto,CPS.Descripcion,CAST(CCA.PesoEnKgs AS decimal(10,2))PesoEnKgs FROM CCartaPorte_Articulos CCA LEFT JOIN C_Articulos_ClaveUnidadPeso CAC ON CCA.IdC_Articulos_ClaveUnidadPeso = CAC.IdC_Articulos_ClaveUnidadPeso LEFT JOIN C_ClaveUnidadPeso CUP ON CAC.Id_c_ClaveUnidadPeso= CUP.Id_c_ClaveUnidadPeso LEFT JOIN C_ClaveProdServCP CPS ON CCA.Id_c_ClaveProdServCP = CPS.Id_c_ClaveProdServCP WHERE CCA.IdCCartaPorte=?"),
	MONTOS("SELECT  CP.ValorDeclarado, CP.ValorFlete, CP.ValorSeguro, CP.ValorDescarga, CP.ValorTransbordador, CP.ValorEntrega, CP.ValorCarga, CP.ValorRecoleccion, CP.ImporteSubTotal, CP.ImporteIVA, CP.ImporteRetencion, CP.ImporteTotal, CP.ImporteNetoPagar FROM CCartaPorte CP  WHERE CP.IdCCartaPorte=?"),
	
	ASEGURARESPCIVIL("AXA SEGUROS, S.A. DE C.V."),
	POLIZARESPCIVIL("CSA786680000*"),
	LEYENDA("\"LA EMPRESA NO SE HACE RESPONSABLE  POR DAÑOS AL MATERIAL\"");
	
	private final String print;

	
	public String getPrint() {
		return print;
	}

	private EnumImpresion(String print) {
		this.print = print;
	}

}
