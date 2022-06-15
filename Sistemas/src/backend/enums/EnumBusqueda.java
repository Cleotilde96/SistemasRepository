package backend.enums;

public enum EnumBusqueda {
		
	BUSQUEDA("SELECT CC.IdTalones,CC.IdEstatusProceso,EP.EstatusProceso,CC.IdEstatusImpresion,EI.EstatusImpresion,   CC.IdInformes,TL.NumeroControl,CC.IdCCartaPorte, CH.Rfc, ISNULL(CH.NombreCliente,'')+' '+ISNULL(CH.ApellidoPaterno,'')+' '+ISNULL(CH.ApellidoMaterno,'')NombreCliente, REPLACE(ISNULL(TBL.sClaveCapturista,''),'null','') sClaveCapturista,REPLACE(ISNULL(TBL.dtFechaTimbrado,''),'null','')dtFechaTimbrado  FROM CCartaPorte CC   LEFT JOIN Talones TL ON CC.IdTalones = TL.IdTalones   LEFT JOIN InformesTalones IT ON CC.IdInformes = IT.IdInformesTalones LEFT JOIN BD_PerliCFDI.[dbo].[tblFacturacion] TBL  ON CC.IdCCartaPorte= TBL.nNumeroFactura  LEFT JOIN EstatusProceso EP ON CC.IdEstatusProceso = EP.IdEstatusProceso   LEFT JOIN EstatusImpresion EI ON CC.IdEstatusImpresion = EI.IdEstatusImpresion   LEFT JOIN Talones_Clientes TC ON CC.IdTalones=TC.IdTalones  LEFT JOIN ClientesHistorial CH ON TC.IdClientes = CH.IdClientesHistorial  WHERE TC.QuienPaga=-3 AND TBL.sClaveCapturista='L' "),
	PORIDCCP("AND CC.IdCCartaPorte=?"),
	PORNUMEROCONTROL("AND TL.NumeroControl=?"),
	PORIDTALON("AND TL.IdTalones=?"),
	INFORMETALONES("SELECT T.IdTalones, T.NumeroControl,   RTRIM(ISNULL(CHR.NombreCliente + ' ' + CHR.ApellidoPaterno + ' ' + CHR.ApellidoMaterno, '')) AS Remitente,  RTRIM(ISNULL(CHD.NombreCliente + ' ' + CHD.ApellidoPaterno + ' ' + CHD.ApellidoMaterno, '')) AS Destinatario, CP.IdEstatusProceso IdEstatusProcesoCP, CP.IdEstatusImpresion IdEstatusImpresionCP ,CP.IdCCartaPorte  FROM Talones T    LEFT JOIN Talones_Clientes TCR ON T.IdTalones = TCR.IdTalones    LEFT JOIN ClientesHistorial CHR ON TCR.IdClientes = CHR.IdClientesHistorial   LEFT JOIN Talones_Clientes TCD ON T.IdTalones = TCD.IdTalones    LEFT JOIN ClientesHistorial CHD ON TCD.IdClientes = CHD.IdClientesHistorial    LEFT JOIN HistorialDireccionesEntrega HDE ON TCD.IdDireccionesEntrega = HDE.IdHistorialDireccionesEntrega   LEFT JOIN CCartaPorte CP ON T.IdTalones=CP.IdTalones   WHERE (TCR.TipoNodoTC = 'R') AND (TCD.TipoNodoTC = 'D')  AND (T.Sucursal = 0 OR T.Sucursal = 3)   AND (T.IdInformesTalones =?) AND  T.TipoDocumento=1 AND CP.IdInformes>0  ORDER BY  NumeroControl ASC"),
	
	
	DETALLEDOCUMENTO("SELECT TBL.sUUID ,TBL.dtFechaTimbrado,TBL.dtFechaEmision,TBL.sCertificadoDigital,TBL.sCertificadoSAT FROM tblFacturacion TBL WHERE TBL.sClaveCapturista='L' AND TBL.nIdEstatusFactura=2  AND TBL.nNumeroFactura=?");
	
	private final String query;

	public String getQuery() {
		return query;
	}

	private EnumBusqueda(String query) {
		this.query = query;
	}
}
