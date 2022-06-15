package backend.data.notransactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.CConnection;
import backend.dto.Busqueda;
import backend.enums.EnumBusqueda;
public class BusquedaImplement implements BusquedaDao{
	private Connection conection;
	
	@Override
	public List<Busqueda> search(Busqueda dataSearch) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Busqueda cartaPorte= null;
        List<Busqueda> listCartaPorte=new ArrayList<Busqueda>();
        String script="";
        try {
            conn = this.conection != null ? this.conection : CConnection.getConnection();
              if(dataSearch.getTipo().equals("1")){//idccp
            	  script= EnumBusqueda.BUSQUEDA.getQuery().concat(EnumBusqueda.PORIDCCP.getQuery());
              }
              else if(dataSearch.getTipo().equals("2")){//folio nota
            	  script= EnumBusqueda.BUSQUEDA.getQuery().concat(EnumBusqueda.PORNUMEROCONTROL.getQuery());  
              }
              else if(dataSearch.getTipo().equals("3")){//fecha
            	  
              }
              else if(dataSearch.getTipo().equals("4")){//idinforme
            	  
              }
            	 stmt = conn.prepareStatement(script);
            	 stmt.setInt(1, dataSearch.getFolio());
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
            	cartaPorte = new Busqueda();
            	
            	//CC.IdTalones,CC.IdEstatusProceso,CC.IdEstatusImpresion,
            	//CC.IdInformes,TL.NumeroControl,CC.IdCCartaPorte,CL.Rfc,CL.NombreCliente,TBL.sClaveCapturista,TBL.dtFechaTimbrado
            	if(rs.getInt("IdTalones")>0 && rs.getInt("IdInformes")<=0){
            		cartaPorte.setTipo("CARTA PORTE TALONES");
            	}
            	else if(rs.getInt("IdTalones")>0 && rs.getInt("IdInformes")>0){
            		cartaPorte.setTipo("CARTA PORTE INFORME");
            	}
            	else  if(rs.getInt("IdTalones")<= 0 && rs.getInt("IdInformes")<=0){
            		cartaPorte.setTipo("CARTA PORTE RECOLECCIONES");
            	}
            	cartaPorte.setIdTalones(rs.getInt("IdTalones"));
                cartaPorte.setIdEstatusProceso(rs.getInt("IdEstatusProceso"));
                cartaPorte.setIdEstatusImpresion(rs.getInt("IdEstatusImpresion"));
                cartaPorte.setIdInformesTalones(rs.getInt("IdInformes"));
                cartaPorte.setNumeroControl(rs.getInt("NumeroControl"));
                cartaPorte.setFolio(rs.getInt("IdCCartaPorte"));
                cartaPorte.setRfcReceptor(rs.getString("Rfc"));
                cartaPorte.setNombreCliente(rs.getString("NombreCliente"));
                cartaPorte.setSerieCapturista(rs.getString("sClaveCapturista"));                
                cartaPorte.setFechaTimbrado(rs.getString("dtFechaTimbrado"));
            	cartaPorte.setEstatusProceso(rs.getString("EstatusProceso"));
            	cartaPorte.setEstatusImpresion(rs.getString("EstatusImpresion"));
                listCartaPorte.add(cartaPorte);     
            }     
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conection == null) {
            	CConnection.close(conn);
            }

        } 
     
		return listCartaPorte;
	}

	@Override
	public List<Busqueda> detailDocument(Integer idCartaPorte) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Busqueda cartaPorte= null;
        List<Busqueda> listTimbrado=new ArrayList<Busqueda>();
     
        try {
            conn = this.conection != null ? this.conection : CConnection.getConnectionCFDI();
            stmt = conn.prepareStatement(EnumBusqueda.DETALLEDOCUMENTO.getQuery());
            	 stmt.setInt(1,idCartaPorte);
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
            	cartaPorte = new Busqueda();
            	cartaPorte.setuUID(rs.getString("sUUID"));            	                           
                cartaPorte.setFechaTimbrado(rs.getString("dtFechaTimbrado"));
                cartaPorte.setFechaEmision(rs.getString("dtFechaEmision"));
                cartaPorte.setCertificadoDigital(rs.getString("sCertificadoDigital"));
                cartaPorte.setCertificadoSAT(rs.getString("sCertificadoSAT"));
            	listTimbrado.add(cartaPorte);     
            }     
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conection == null) {
            	CConnection.close(conn);
            }

        } 
     
		return listTimbrado;
	}
	
	

}
