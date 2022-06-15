package backend.data.notransactional;

import java.math.RoundingMode;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import config.CConnection;
import backend.dto.CartaPorte;
import backend.dto.DatosDestinatario;
import backend.dto.TalonesInforme;
import backend.dto.XmlCartaPorte;
import backend.enums.EnumNoTransactionalDao;

public class CartaPorteImplement implements CartaPorteDao {


	 private Connection conectionNoTransactional;
	 
	 public CartaPorteImplement(){}
	
	
	@Override
	public int insertCartaPorte(CartaPorte cartaporte) throws SQLException {
		Connection conn = null;
	     CallableStatement cstmt = null;
	     int idCCartaPorte = 0;	
	     try {
	     conn = this.conectionNoTransactional != null ? this.conectionNoTransactional : CConnection.getConnection();
	     cstmt = conn.prepareCall(EnumNoTransactionalDao.SPICCARTAPORTE.getQuery());
	     cstmt.setInt(1,cartaporte.getIdTalones());
	     cstmt.setInt(2,cartaporte.getIdEstatusProceso());
	     cstmt.setInt(3,cartaporte.getIdEstatusImpresion());
	     cstmt.setInt(4,cartaporte.getIdCPColDestino());
	     cstmt.setInt(5,cartaporte.getIdClientes());
	     cstmt.setInt(6,cartaporte.getIdClientesHistorial());
	     cstmt.setInt(7,cartaporte.getIdDireccionesEntrega());
	     cstmt.setInt(8,cartaporte.getIdInformes());
	     cstmt.setInt(9,cartaporte.getIdCiudadesDistancias());
	     cstmt.setInt(10,cartaporte.getIdCLocalidad_O());
	     cstmt.setInt(11,cartaporte.getIdPolizasSeguroCliente());
	     cstmt.setInt(12,cartaporte.getIdCTractoConfigAutotrans());
	     cstmt.setInt(13,cartaporte.getIdCRemSubTipoRem());
	     cstmt.setInt(14,cartaporte.getIdEmpleado());
	     cstmt.setInt(15,cartaporte.getIdCPColOperador());
	     cstmt.setInt(16,cartaporte.getIdCCartaPorteRelacionado());
	     //cstmt.setString(17,cartaporte.getFechaCartaPorte());
	     cstmt.setInt(17,cartaporte.getFolio());
	     cstmt.setString(18,cartaporte.getNombreCliente());
	     cstmt.setInt(19,cartaporte.getUsoCFDI());
	     cstmt.setInt(20,cartaporte.getFormaPago());
	     cstmt.setDouble(21,cartaporte.getKmsRecorridos());
	     cstmt.setString(22,cartaporte.getFechaProximaLlegada());
	    // cstmt.setString(24,cartaporte.getFechaHoraSalida());
	     cstmt.setInt(23,cartaporte.getNumTotalMercancia());
	     cstmt.setBigDecimal(24,cartaporte.getValorDeclarado());
	     cstmt.setBigDecimal(25,cartaporte.getValorFlete());
	     cstmt.setBigDecimal(26,cartaporte.getValorSeguro());
	     cstmt.setBigDecimal(27,cartaporte.getValorDescarga());
	     cstmt.setBigDecimal(28,cartaporte.getValorTransbordador());
	     cstmt.setBigDecimal(29,cartaporte.getValorEntrega());
	     cstmt.setBigDecimal(30,cartaporte.getValorCarga());
	     cstmt.setBigDecimal(31,cartaporte.getValorRecoleccion());
	     cstmt.setBigDecimal(32,cartaporte.getImporteSubTotal());
	     cstmt.setBigDecimal(33,cartaporte.getImporteIVA());
	     cstmt.setBigDecimal(34,cartaporte.getImporteRetencion());
	     cstmt.setBigDecimal(35,cartaporte.getImporteTotal());
	     cstmt.setBigDecimal(36,cartaporte.getImporteNetoPagar());
	     cstmt.setString(37,cartaporte.getCadenaCancelacion());
	     cstmt.setString(38,cartaporte.getObservaciones());
	     cstmt.setInt(39,cartaporte.getIdCPColRecolecciones());
	     cstmt.registerOutParameter(40, Types.INTEGER);
	     cstmt.execute();
	     idCCartaPorte=cstmt.getInt(40);
	     
	     
	    }
	    finally {
	    	 CConnection.close(cstmt);
	            if (this.conectionNoTransactional == null) {
	            	CConnection.close(conn);
	      }
	    }	
		return idCCartaPorte;
	}


	@Override
	public CartaPorte selectCartaPorte(CartaPorte idCartaPorte) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CartaPorte cartaporte= null;
        
        try {
            conn = this.conectionNoTransactional != null ? this.conectionNoTransactional : CConnection.getConnection();
            stmt = conn.prepareStatement(EnumNoTransactionalDao.CONSULTACARTAPORTE.getQuery());
            stmt.setInt(1, idCartaPorte.getIdCCartaPorte());
            rs = stmt.executeQuery();
            
            while (rs.next()) {
            	cartaporte = new CartaPorte();
            	cartaporte.setIdCCartaPorte(rs.getInt("IdCCartaPorte"));
            	cartaporte.setFolio(rs.getInt("Folio"));
            	cartaporte.setIdTalones(rs.getInt("IdTalones"));
            	cartaporte.setNumeroControl(rs.getInt("NumeroControl"));
            	cartaporte.setIdInformes(rs.getInt("IdInformes"));
            	cartaporte.setImporteSubTotal(rs.getBigDecimal("ImporteSubTotal").setScale(2, RoundingMode.HALF_UP));
            	cartaporte.setValorFlete(rs.getBigDecimal("ValorFlete").setScale(2, RoundingMode.HALF_UP));
            	cartaporte.setImporteIVA(rs.getBigDecimal("ImporteIVA").setScale(2, RoundingMode.HALF_UP));
            	cartaporte.setImporteTotal(rs.getBigDecimal("ImporteTotal").setScale(2, RoundingMode.HALF_UP));
            	cartaporte.setImporteRetencion(rs.getBigDecimal("ImporteRetencion").setScale(2, RoundingMode.HALF_UP));
            	cartaporte.setImporteNetoPagar(rs.getBigDecimal("ImporteNetoPagar").setScale(2, RoundingMode.HALF_UP));      
            	cartaporte.setObservaciones(rs.getString("Observaciones")); 
            	cartaporte.setIdEmpleado(rs.getInt("IdEmpleados"));
            	cartaporte.setSerie("L");
            }     
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conectionNoTransactional == null) {
            	CConnection.close(conn);
            }

        } 
		return cartaporte;
	}


	@Override
	public Boolean estatusProceso(CartaPorte CartaPorte) throws SQLException {
		Connection conn = null;
	     CallableStatement cstmt = null;
	     Integer row=0;	
	     Boolean update=false;
	     try {
	     conn = this.conectionNoTransactional != null ? this.conectionNoTransactional : CConnection.getConnection();
	     cstmt = conn.prepareCall(EnumNoTransactionalDao.SPUCARTAPORTESTATUSPROCESO.getQuery());
	     cstmt.setInt(1,CartaPorte.getIdCCartaPorte());
	     cstmt.setInt(2,CartaPorte.getIdEmpleado());
	     cstmt.registerOutParameter(3, Types.INTEGER);
	     cstmt.execute();
	     row=cstmt.getInt(3);
	     if(row ==2){
	    	 update=true;
	     }     
	    }
	    finally {
	    	 CConnection.close(cstmt);
	            if (this.conectionNoTransactional == null) {
	            	CConnection.close(conn);
	      }
	    }	
		return update;

	}


	@Override
	public XmlCartaPorte datosTimbrado(CartaPorte CartaPorte,Integer opction) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        XmlCartaPorte xmlCartaPorte= null;
        DatosDestinatario destinatario=null;
        try {
            conn = this.conectionNoTransactional != null ? this.conectionNoTransactional : CConnection.getConnection();
            if(opction.equals(1)){
            	stmt = conn.prepareStatement(EnumNoTransactionalDao.DATOSXMLTIMBRADOINFORMES.getQuery());
            }
            else if(opction.equals(2)){
            	stmt = conn.prepareStatement(EnumNoTransactionalDao.DATOSXMLTIMBRADOTALON.getQuery());
            }
            
          //  if(!CartaPorte.getIdCCartaPorte().equals(null)) {
            	stmt.setInt(1, CartaPorte.getIdCCartaPorte());
            //stmt.setInt(1,-1);
            rs = stmt.executeQuery();
            
    
            while (rs.next()) {
            	xmlCartaPorte = new XmlCartaPorte();
            	destinatario =new DatosDestinatario();      	
            	xmlCartaPorte.setIdCartaPorte(rs.getInt("IdCCartaPorte"));
            	xmlCartaPorte.setIdempleadoProceso(CartaPorte.getIdEmpleado());           	
            	xmlCartaPorte.setTotalDistRec(rs.getString("KmsRecorridos"));
            	xmlCartaPorte.setFechaHoraSalida(rs.getString("FechaHoraSalida"));
            	xmlCartaPorte.setDistanciaRecorrida(rs.getString("distanciaRecorrida"));
                xmlCartaPorte.setFechaHoraProgLlegada(rs.getString("FechaProximaLlegada"));
            	xmlCartaPorte.setNumTotalMercancias(rs.getInt("NumTotalMercancia"));
               	xmlCartaPorte.setConfigVehicular(rs.getString("ConfigVehicular"));
            	xmlCartaPorte.setPlacaVM(rs.getString("placaVM"));
            	xmlCartaPorte.setAnioModeloVM(rs.getString("Modelo"));
            	xmlCartaPorte.setSubTipoRem(rs.getString("SubTipoRem"));
            	xmlCartaPorte.setPlaca(rs.getString("Placas"));
            	xmlCartaPorte.setRfcOperador(rs.getString("RFCOperador"));                   	
            	destinatario.setRfcDestinatario(rs.getString("RFCDestinatario"));
            	destinatario.setCalleDest(rs.getString("NombreColonia"));
            	destinatario.setLocalidadDest(rs.getString("c_Localidad"));
            	destinatario.setCpDest(rs.getString("c_CodigoPostal"));
            	destinatario.setColoniaDest(rs.getString("c_Colonia"));
            	destinatario.setMunicipioDest(rs.getString("c_Municipio"));
            	destinatario.setEstadoDest(rs.getString("c_Estado"));                   	
            	xmlCartaPorte.setDatosDestinatario(destinatario);
            	xmlCartaPorte.setNombreAseg(rs.getString("NombreAseguradora"));
            	xmlCartaPorte.setNumPolizaSeg(rs.getString("Poliza"));
            	xmlCartaPorte.setNumLicencia(rs.getString("numLicencia"));
            	xmlCartaPorte.setIdCartaPorteRelacionado(rs.getInt("IdCCartaPorteRelacionado"));
            }
        //  } 
            
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conectionNoTransactional == null) {
            	CConnection.close(conn);
            	
            }
           
        } 
		return xmlCartaPorte;
	}


	@Override
	public Integer existencia(TalonesInforme idTalones) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer total=-1;
        
        try {
            conn = this.conectionNoTransactional != null ? this.conectionNoTransactional : CConnection.getConnection();
            stmt = conn.prepareStatement(EnumNoTransactionalDao.EXISTENCIA.getQuery());
            stmt.setInt(1, idTalones.getIdTalones());
            rs = stmt.executeQuery();
            
            while (rs.next()) {
            	total = rs.getInt("TOTAL");	    
            	
            }     
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conectionNoTransactional == null) {
            	CConnection.close(conn);
            }

        } 
		return total;
	}


	@Override
	public XmlCartaPorte exitenciaRelacion(Integer idCartaPorte) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        XmlCartaPorte CartaPorteRelacion=null;
        
        try {
            conn = this.conectionNoTransactional != null ? this.conectionNoTransactional : CConnection.getConnection();
            stmt = conn.prepareStatement(EnumNoTransactionalDao.EXISTENCIAREALCION.getQuery());
            stmt.setInt(1, idCartaPorte);
            rs = stmt.executeQuery();
            
            while (rs.next()) {            		
            	CartaPorteRelacion=new XmlCartaPorte();
            	CartaPorteRelacion.setTotalRegistros(rs.getInt("TOTAL"));
            	CartaPorteRelacion.setIdCartaPorte(rs.getInt("IdCCartaPorte"));        	
            }     
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conectionNoTransactional == null) {
            	CConnection.close(conn);
            }

        } 
		return CartaPorteRelacion;
	}
	
	
}
