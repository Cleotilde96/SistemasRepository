package  backend.dto;
public class CcartaPorteArticulos {
	
	private Integer idCartaPorteArticulos;
	private Integer idCartaPorte;
	private Integer idCArticulosClaveUnidadPeso;
	private Integer idCclaveProdServCP;
	private Integer idCclaveUnidadPeso;
	private Integer cantidad;
	private Double pesoKg;
	
	public CcartaPorteArticulos() {
		// TODO Auto-generated constructor stub
	}
	
	public CcartaPorteArticulos(Integer idCartaPorteArticulos, Integer idCartaPorte, Integer idCclaveProdServCP,
			Integer idCclaveUnidadPeso, Integer cantidad, Double pesoKg) {
		this.idCartaPorteArticulos = idCartaPorteArticulos;
		this.idCartaPorte = idCartaPorte;
		this.idCclaveProdServCP = idCclaveProdServCP;
		this.idCclaveUnidadPeso = idCclaveUnidadPeso;
		this.cantidad = cantidad;
		this.pesoKg = pesoKg;
	}

	public Integer getIdCartaPorteArticulos() {
		return idCartaPorteArticulos;
	}

	public void setIdCartaPorteArticulos(Integer idCartaPorteArticulos) {
		this.idCartaPorteArticulos = idCartaPorteArticulos;
	}

	public Integer getIdCartaPorte() {
		return idCartaPorte;
	}

	public void setIdCartaPorte(Integer idCartaPorte) {
		this.idCartaPorte = idCartaPorte;
	}
	
	

	public Integer getIdCclaveProdServCP() {
		return idCclaveProdServCP;
	}

	public void setIdCclaveProdServCP(Integer idCclaveProdServCP) {
		this.idCclaveProdServCP = idCclaveProdServCP;
	}

	public Integer getIdCclaveUnidadPeso() {
		return idCclaveUnidadPeso;
	}

	public void setIdCclaveUnidadPeso(Integer idCclaveUnidadPeso) {
		this.idCclaveUnidadPeso = idCclaveUnidadPeso;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPesoKg() {
		return pesoKg;
	}

	public void setPesoKg(Double pesoKg) {
		this.pesoKg = pesoKg;
	}

	public Integer getIdCArticulosClaveUnidadPeso() {
		return idCArticulosClaveUnidadPeso;
	}

	public void setIdCArticulosClaveUnidadPeso(Integer idCArticulosClaveUnidadPeso) {
		this.idCArticulosClaveUnidadPeso = idCArticulosClaveUnidadPeso;
	}
	
	
	
	

}
