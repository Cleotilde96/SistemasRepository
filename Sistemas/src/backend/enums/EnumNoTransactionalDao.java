
package backend.enums;

public enum EnumNoTransactionalDao {
	
	TALONESINFORME(" SELECT TL.IdTalones ,TL.NumeroControl,TL.IdInformesTalones,TL.IdPolizasSeguroCliente, TL.FechaProximaLlegada, TL.ValorDeclarado,TL.ValorFlete,TL.ValorSeguro,TL.ValorDescarga,TL.ValorTransbordador, TL.ValorEntrega,TL.ValorCarga,TL.ValorRecoleccion,TL.ImporteSubTotal,TL.ImporteIVA,TL.ImporteRetencion, TL.ImporteTotal,TL.ImporteNetoPagar FROM Talones TL  LEFT JOIN InformesTalones IFT ON  TL.IdInformesTalones = IFT.IdInformesTalones WHERE IFT.IdInformesTalones =? AND IFT.IdEstatusProceso=13  AND IFT.IdEstatusImpresion=4 AND TL.IdEstatusProceso=1   AND TL.IdEstatusImpresion=2 AND TL.TipoDocumento=1 ORDER BY TL.IdTalones ASC "),
	TALONESCLIENTES(" SELECT TC.IdClientes,IdDireccionesEntrega FROM Talones T LEFT JOIN Talones_Clientes TC ON T.IdTalones = TC.IdTalones WHERE T.IdEstatusProceso=1 AND TC.IdTalones=? AND TC.TipoNodoTC='D' ORDER BY TC.IdTalones_ClienteS  DESC "),
	CLIENTEHISTOTIAL(" SELECT  TipoMovto,CH.IdClientesHistorial,CH.IdClientes,CH.NombreCliente,CH.ApellidoPaterno,ch.ApellidoMaterno,CH.Colonia,CH.Cp FROM ClientesHistorial  CH LEFT JOIN Clientes  CL ON CH.IdClientes = CL.IdClientes WHERE CH.IdClientesHistorial =? AND CL.IdEstatusProceso=10 ORDER BY IdClientesHistorial DESC "),
	DIRECCIONENTREGAH(" SELECT TipoMovto,HD.IdHistorialDireccionesEntrega,HD.IdClientes,CL.NombreCliente,CL.ApellidoPaterno,CL.ApellidoMaterno,HD.Colonia,HD.Cp FROM HistorialDireccionesEntrega  HD LEFT JOIN Clientes  CL ON HD.IdClientes = CL.IdClientes WHERE CL.IdEstatusProceso=10  AND HD.IdDireccionesEntrega=? ORDER BY HD.IdHistorialDireccionesEntrega  DESC "),
	
	/*SACAR DIRECCIONES FISCALES Y DE ENTREGA PARA TODOS LOS CLIENTES /POR RANGO DE FECHAS*/
	CLIENTESALTA(" SELECT 40279 IdCP_Colonias,CH.IdEstatusProceso,CH.IdClientes,CH.IdClientesHistorial,-1 IdDireccionesEntrega,-1  IdTalones_Clientes,CH.IdEmpleados,CH.FechaMovto,CH.TipoMovto, CH.NombreCliente,CH.ApellidoPaterno,CH.ApellidoMaterno,CH.Cp,CH.Colonia FROM ClientesHistorial  CH LEFT JOIN Clientes  CL ON CH.IdClientes = CL.IdClientes WHERE CH.FechaMovto>='01-01-2020 00:00:00' AND  CH.FechaMovto <= '31-12-2021 00:00:00' AND CL.IdEstatusProceso=10  AND CH.TipoMovto='A' ORDER BY CH.IdClientesHistorial  ASC "),
	CLIENTESMOD(" SELECT TOP(1) 40279 IdCP_Colonias,CH.IdEstatusProceso,CH.IdClientes,CH.IdClientesHistorial,-1 IdDireccionesEntrega,-1  IdTalones_Clientes,CH.IdEmpleados,CH.FechaMovto,CH.TipoMovto, CH.NombreCliente,CH.ApellidoPaterno,CH.ApellidoMaterno,CH.Cp,CH.Colonia FROM ClientesHistorial  CH LEFT JOIN Clientes  CL ON CH.IdClientes = CL.IdClientes WHERE CH.FechaMovto>='01-01-2020 00:00:00' AND  CH.FechaMovto <= '31-12-2021 00:00:00' AND CL.IdEstatusProceso=10  AND CH.TipoMovto='M' AND CH.IdClientes =? ORDER BY CH.IdClientesHistorial  DESC "),	
	CLIENTEENTREGAA(" SELECT  40279 IdCP_Colonias,HD.IdEstatusProceso,HD.IdClientes,-1 IdClientesHistorial ,HD.IdDireccionesEntrega,-1  IdTalones_Clientes,HD.IdEmpleados,HD.FechaMovto,HD.TipoMovto, CL.NombreCliente,CL.ApellidoPaterno,CL.ApellidoMaterno,HD.Cp,HD.Colonia FROM HistorialDireccionesEntrega  HD LEFT JOIN Clientes  CL ON HD.IdClientes = CL.IdClientes WHERE HD.FechaMovto>='01-01-2020 00:00:00' AND  HD.FechaMovto <= '31-12-2021 00:00:00' AND CL.IdEstatusProceso=10  AND HD.TipoMovto='A'  ORDER BY HD.IdHistorialDireccionesEntrega  ASC "),
	CLIENTEENTREGAM(" SELECT TOP(1) 40279 IdCP_Colonias,HD.IdEstatusProceso,HD.IdClientes,-1 IdClientesHistorial ,HD.IdDireccionesEntrega,-1  IdTalones_Clientes,HD.IdEmpleados,HD.FechaMovto,HD.TipoMovto, CL.NombreCliente,CL.ApellidoPaterno,CL.ApellidoMaterno,HD.Cp,HD.Colonia FROM HistorialDireccionesEntrega  HD LEFT JOIN Clientes  CL ON HD.IdClientes = CL.IdClientes WHERE HD.FechaMovto>='01-01-2020 00:00:00' AND  HD.FechaMovto <= '31-12-2021 00:00:00' AND CL.IdEstatusProceso=10  AND HD.TipoMovto='M' AND HD.IdClientes=? ORDER BY HD.IdHistorialDireccionesEntrega  DESC "),
	
	COLONIACLIENTE(" SELECT CL.IdCP_Colonias,CL.IdEstatusProceso,CL.c_CodigoPostal,CL.c_Estado,CL.c_Municipio,CL.NombreMunicipio,CL.c_Localidad,CL.c_Colonia,CL.NombreColonia FROM CP_Colonias CL WHERE   CL.IdEstatusProceso=10 AND CL.c_CodigoPostal =? "),
	
	/*-------------------------*/
	
	/*direccion de entrega cadena cp_colDestino*/
	CPCOLDESTINO(" SELECT CPD.IdCP_Col_Destino,CPD.IdCP_Colonias,CPD.IdEstatusProceso,CPD.Id_Clientes,CPD.IdClientesHistorial,CPD.IdDireccionesEntrega,CPD.IdTalones_Clientes,CPD.IdEmpleado,CPD.FechaMovto,CPD.TipoMovto FROM CP_Col_Destino CPD WHERE CPD.Id_Clientes =? AND CPD.TipoMovto=? "),
	REGIDCOLDESTINO(" SELECT CPD.IdCP_Col_Destino,CPD.Id_Clientes,CPD.IdClientesHistorial,CPD.IdDireccionesEntrega FROM CP_Col_Destino CPD WHERE CPD.IdClientesHistorial=? AND CPD.IdDireccionesEntrega=? "),
	/*-------------------------------*/	
	/*SP PARA CARTA PORTE*/
	SPICCARTAPORTE("[perli].[spi_CCartaPorte] ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"),
	/*consultar el informe  TRATOCAMIONES*/
	INFORMESTALONES("SELECT IFT.IdInformesTalones,IFT.IdUnidades,IFT.Observaciones FROM InformesTalones IFT WHERE IFT.IdEstatusProceso=13 AND IFT.IdEstatusImpresion=4 AND IFT.IdInformesTalones=?"),
	CTRACTOCONFIGAUTOTRANS("SELECT IdC_Tracto_ConfigAutotrans,Id_Tractocamiones,IdEstatusProceso,IdUnidades,Modelo,Placas,ConfigVehicular FROM C_Tracto_ConfigAutotrans CTC WHERE CTC.IdEstatusProceso=10 AND CTC.IdUnidades =?"),
	CREMSUBTIPOREM("SELECT IdC_Rem_SubTipoRem,IdRemolques,IdEstatusProceso,Placas,SubTipoRem FROM C_Rem_SubTipoRem CRS WHERE CRS.IdEstatusProceso=10 AND  CRS.IdRemolques =?"),
	/*---------------------*/	
	/*CARTA PORTE ARTICULOS*/
	ARTICULOSTALONES("SELECT TA.IdArticulos,A.TipoArticulo,TA.CantidadArticulos,TA.Peso,TA.Contiene FROM Talones_Articulos  TA LEFT JOIN Articulos A ON TA.IdArticulos= A.IdArticulos WHERE (A.IdArticulos <> 65 OR A.IdArticulos <> 69) AND A.IdEstatusProceso =10  AND TA.IdTalones=?"),
	ARTICULOCLAVEUNIDADPESO("SELECT IdC_Articulos_ClaveUnidadPeso,IdEstatusProceso,IdArticulos,Id_c_ClaveUnidadPeso FROM C_Articulos_ClaveUnidadPeso WHERE IdArticulos=?"),
	CLAVEUNIDADPESO("SELECT Id_c_ClaveUnidadPeso,IdEstatusProceso,ClaveUnidad,Nombre FROM C_ClaveUnidadPeso WHERE  Id_c_ClaveUnidadPeso=?"),
	CLAVEPRODSERVCP("SELECT Id_c_ClaveProdServCP,IdEstatusProceso,ClaveProducto,Descripcion FROM C_ClaveProdServCP WHERE ClaveProducto=?"),	
	SPICCARTAPORTEARTICULOS("[perli].[spi_CCartaPorteArticulos] ?,?,?,?,?,?,?"),
	/*----------------------*/
	/*FORMA DE PAGO TALON*/
	FORMAPAGOTALON("SELECT FC.IdFormaPago_Claves,FC.c_FormaPago,FC.c_FormaPago+'/'+MP.MetodosPago AS FormaPago FROM [Clientes_MetodosPago_Historial] CMH  LEFT JOIN TalonesClientes_MetodosPago_Historial TMPH ON TMPH.IdClientes_MetodosPago_Historial=CMH.IdClientes_MetodosPago_Historial  LEFT JOIN FormasPago_Claves FC  ON FC.IdMetodosPago=CMH.IdMetodosPago  LEFT JOIN Bancos B ON B.IdBancos=CMH.IdBancos  LEFT JOIN MetodosPago MP ON MP.IdMetodosPago=CMH.IdMetodosPago  WHERE (IdTalones=?)"),
	/*USO DE CFDI*/
	USOCFDITALON("SELECT  CUC.Id_c_UsoCFDI,CUC.c_UsoCFDI,CUC.c_UsoCFDI+'/'+CUC.Descripcion AS Descripcion  FROM [Talones_c_UsoCFDI] TCUC LEFT JOIN c_UsoCFDI CUC ON CUC.Id_c_UsoCFDI=TCUC.Id_c_UsoCFDI WHERE IdTalones=?"),
		
	/*CIUDADES DISTANCIA*/
	LOCALIDADDESTINO("SELECT TOP(1)CPC.c_Localidad FROM CP_Col_Destino CPD LEFT JOIN CP_Colonias CPC ON CPD.IdCP_Colonias =CPC.IdCP_Colonias WHERE CPD.IdCP_Col_Destino=?"),
	CIUDADESDISTANCIAS("SELECT TOP(1)IdCiudades_Distancias,CAST(KmsRecorridos AS decimal(10,2))KmsRecorridos,DiasEntregas  FROM Ciudades_Distancias WHERE IdEstatusProceso=10 AND IdC_Localidad_O =? AND IdC_Localidad_D =?"),
	
	CONSULTACARTAPORTE("SELECT CP.IdCCartaPorte,CP.Folio,CP.IdTalones,TL.NumeroControl,CP.IdInformes,CP.ImporteSubTotal,  CP.ValorFlete,CP.ImporteIVA,CP.ImporteTotal,CP.ImporteRetencion,CP.ImporteNetoPagar,CP.Observaciones, CPE.IdEmpleados FROM CCartaPorte CP LEFT JOIN Talones TL ON CP.IdTalones = TL.IdTalones LEFT JOIN CCartaPorte_Empleados CPE ON CP.IdCCartaPorte = CPE.IdCCartaPorte WHERE CP.IdCCartaPorte=?   AND CPE.TipoMovto='A' "),
	
	/*cambio Estatus proceso carta porte*/
	SPUCARTAPORTESTATUSPROCESO("[perli].[spu_CCartaPorteEstatusProceso] ?,?,?"),
	
	
	/*sp insert registra CP_Col_Destino*/
	SPICPCOLDESTINO("[perli].[spi_CP_Col_Destino] ?,?"),
	//[perli].[spi_CP_Col_Destino] 1188040,-1
	SELECTCOLDESTINO("SELECT CPD.IdCP_Col_Destino,CPD.IdCP_Colonias,CPD.IdEstatusProceso,CPD.Id_Clientes,CPD.IdClientesHistorial,CPD.IdDireccionesEntrega,CPD.IdTalones_Clientes,CPD.IdEmpleado,CPD.FechaMovto,CPD.TipoMovto FROM CP_Col_Destino CPD WHERE CPD.IdCP_Col_Destino=?"),
	
	
	/*consulta datos carta porte / timbrar */
	//SELECTCARTAPORTEXML("SELECT CCP.IdCCartaPorte,CCP.KmsRecorridos,CONVERT(VARCHAR,  CCP.FechaHoraSalida,126) FechaHoraSalida ,CONVERT(VARCHAR, CCP.FechaProximaLlegada,126) FechaProximaLlegada, CPC.NombreColonia,CPC.c_Colonia,CPC.c_CodigoPostal,CPC.c_Municipio,CPC.c_Estado,CCP.NumTotalMercancia, ASG.NombreAseguradora,PSC.Poliza,CTC.ConfigVehicular,CTC.Placas,ctc.Modelo,CRS.SubTipoRem,CRS.Placas,EMP.Rfc RFC FROM CCartaPorte  CCP LEFT JOIN CP_Col_Destino CPD ON CCP.IdCP_Col_Destino = CPD.IdCP_Col_Destino LEFT JOIN CP_Colonias CPC ON CPD.IdCP_Colonias = CPC.IdCP_Colonias LEFT JOIN C_Tracto_ConfigAutotrans CTC ON CCP.IdC_Tracto_ConfigAutotrans = CTC.IdC_Tracto_ConfigAutotrans LEFT JOIN C_Rem_SubTipoRem CRS ON CCP.IdC_Rem_SubTipoRem = CRS.IdC_Rem_SubTipoRem LEFT JOIN PolizasSeguroClientes PSC ON CCP.IdPolizasSeguroCliente = PSC.IdPolizasSeguroCliente LEFT JOIN  Aseguradoras ASG ON PSC.IdAseguradoras = ASG.IdAseguradoras LEFT JOIN InformesTalones IFT ON CCP.IdInformes = IFT.IdInformesTalones LEFT JOIN Empleados_Informes EMI ON  IFT.IdInformesTalones  =EMI.IdInformesTalones LEFT JOIN Empleados  EMP ON EMI.IdEmpleados = EMP.IdEmpleados WHERE CCP.IdCCartaPorte=? AND EMI.TipoMovto='O'"),
	DATOSXMLTIMBRADOINFORMES("SELECT  CCP.IdCCartaPorte, CAST(CCP.KmsRecorridos AS decimal(10,2))KmsRecorridos, CONVERT(VARCHAR,  CCP.FechaHoraSalida,126) FechaHoraSalida, CAST(CCP.KmsRecorridos AS decimal(10,2))distanciaRecorrida, CONVERT(VARCHAR, CCP.FechaProximaLlegada,126) FechaProximaLlegada, CCP.NumTotalMercancia, CTC.ConfigVehicular, REPLACE(CTC.Placas,' ','')placaVM, CTC.Modelo, CRS.SubTipoRem, REPLACE(CRS.Placas,' ','')Placas, REPLACE(EMP.Rfc,' ', '')RFCOperador, REPLACE(CLT.Rfc,' ','')RFCDestinatario, CPC.NombreColonia, CPC.c_Localidad, CPC.c_CodigoPostal, CPC.c_Colonia, CPC.c_Municipio, CPC.c_Estado, ISNULL(ASG.NombreAseguradora,'')NombreAseguradora, ISNULL(PSC.Poliza,'')Poliza, ISNULL(LOP.LicenciaNumero,'')numLicencia FROM CCartaPorte  CCP  LEFT JOIN CP_Col_Destino CPD ON CCP.IdCP_Col_Destino = CPD.IdCP_Col_Destino  LEFT JOIN CP_Colonias CPC ON CPD.IdCP_Colonias = CPC.IdCP_Colonias  LEFT JOIN C_Tracto_ConfigAutotrans CTC ON CCP.IdC_Tracto_ConfigAutotrans = CTC.IdC_Tracto_ConfigAutotrans  LEFT JOIN C_Rem_SubTipoRem CRS ON CCP.IdC_Rem_SubTipoRem = CRS.IdC_Rem_SubTipoRem  LEFT JOIN PolizasSeguroClientes PSC ON CCP.IdPolizasSeguroCliente = PSC.IdPolizasSeguroCliente  LEFT JOIN  Aseguradoras ASG ON PSC.IdAseguradoras = ASG.IdAseguradoras  LEFT JOIN InformesTalones IFT ON CCP.IdInformes = IFT.IdInformesTalones  LEFT JOIN Empleados_Informes EMI ON  IFT.IdInformesTalones  =EMI.IdInformesTalones lEFT JOIN LicenciasOperadores LOP ON EMI.IdEmpleados = LOP.IdEmpleados LEFT JOIN Clientes CLT ON  CPD.Id_Clientes = CLT.IdClientes LEFT JOIN Empleados  EMP ON EMI.IdEmpleados = EMP.IdEmpleados  WHERE CCP.IdCCartaPorte=? AND EMI.TipoMovto='O' AND LOP.IdEstatusProceso=10"),
	DATOSXMLTIMBRADOTALON("SELECT  CCP.IdCCartaPorte, CAST(CCP.KmsRecorridos AS decimal(10,2))KmsRecorridos,  CONVERT(VARCHAR,  CCP.FechaHoraSalida,126) FechaHoraSalida,  CAST(CCP.KmsRecorridos AS decimal(10,2))distanciaRecorrida,   CONVERT(VARCHAR, CCP.FechaProximaLlegada,126) FechaProximaLlegada, CCP.NumTotalMercancia, CTC.ConfigVehicular,   REPLACE(CTC.Placas,' ','')placaVM, CTC.Modelo, CRS.SubTipoRem, REPLACE(CRS.Placas,' ','')Placas, REPLACE(EMP.Rfc,' ', '')RFCOperador,  REPLACE(CLT.Rfc,' ','')RFCDestinatario, CPC.NombreColonia, CPC.c_Localidad, CPC.c_CodigoPostal, CPC.c_Colonia, CPC.c_Municipio, CPC.c_Estado,  ISNULL(ASG.NombreAseguradora,'')NombreAseguradora, ISNULL(PSC.Poliza,'')Poliza, ISNULL(LOP.LicenciaNumero,'') numLicencia ,CCP.IdCCartaPorteRelacionado FROM CCartaPorte  CCP   LEFT JOIN CP_Col_Destino CPD ON CCP.IdCP_Col_Destino = CPD.IdCP_Col_Destino  LEFT JOIN CP_Colonias CPC ON CPD.IdCP_Colonias = CPC.IdCP_Colonias   LEFT JOIN C_Tracto_ConfigAutotrans CTC ON CCP.IdC_Tracto_ConfigAutotrans = CTC.IdC_Tracto_ConfigAutotrans    LEFT JOIN C_Rem_SubTipoRem CRS ON CCP.IdC_Rem_SubTipoRem = CRS.IdC_Rem_SubTipoRem    LEFT JOIN PolizasSeguroClientes PSC ON CCP.IdPolizasSeguroCliente = PSC.IdPolizasSeguroCliente    LEFT JOIN  Aseguradoras ASG ON PSC.IdAseguradoras = ASG.IdAseguradoras    LEFT JOIN CCartaPorte_Empleados EPC ON  CCP.IdCCartaPorte  =EPC.IdCCartaPorte  lEFT JOIN LicenciasOperadores LOP ON EPC.IdEmpleados = LOP.IdEmpleados   LEFT JOIN Clientes CLT ON  CPD.Id_Clientes = CLT.IdClientes   LEFT JOIN Empleados  EMP ON EPC.IdEmpleados = EMP.IdEmpleados   WHERE CCP.IdCCartaPorte=? AND EPC.TipoMovto='O' AND LOP.IdEstatusProceso=10"),	
	
	/*consulta existencia carta porte*/
	EXISTENCIA("SELECT COUNT(*)TOTAL FROM CCartaPorte WHERE IdTalones=?"),
	EXISTENCIAREALCION("SELECT COUNT(*)TOTAL,IdCCartaPorte FROM CCartaPorte  WHERE IdCCartaPorteRelacionado=? GROUP BY IdCCartaPorte"),
	
	
	//servicios
	SPSERVICIOSCARTAPORTE("[perli].[sp_Servicios_CartaPorte] ?,?,?,?");
	
	private final String query;

	public String getQuery() {
		return query;
	}

	private EnumNoTransactionalDao(String query) {
		this.query = query;
	}

	

	
	
}
