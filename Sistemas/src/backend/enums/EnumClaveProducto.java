package backend.enums;

public enum EnumClaveProducto {
	
	SEARCHCLAVE("SELECT Id_c_ClaveProdServCP,IdEstatusProceso,ClaveProducto,Descripcion,MaterialPeligroso FROM C_ClaveProdServCP WHERE ClaveProducto=? AND IdEstatusProceso=10"),
	TOTALROWCLAVE("SELECT COUNT(*)Total FROM C_ClaveProdServCP WHERE ClaveProducto=?");
	
	private final String query;

	public String getQuery() {
		return query;
	}

	private EnumClaveProducto(String query) {
		this.query = query;
	}
}
