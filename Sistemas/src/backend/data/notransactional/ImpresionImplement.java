package backend.data.notransactional;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import backend.dto.Articulos;
import backend.dto.Montos;
import backend.dto.Servicios;

import backend.dto.CartaPorte;
import backend.dto.Impresion;
import backend.enums.EnumImpresion;
import config.CConnection;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;




public class ImpresionImplement implements ImpresionDao{
	
	private Connection conectionNoTransactional;
	 
	@Override
	public Impresion impresion(Impresion print) throws SQLException {
		
		Connection conn = null;
		Impresion imprimirOK=new Impresion();
		
		 try {
		     conn = this.conectionNoTransactional != null ? this.conectionNoTransactional : CConnection.getConnection();
		     
		     if (conn != null) {
		    	 
		    	 JasperReport factu;
					factu = JasperCompileManager.compileReport(print.getRutaPlantilla());
					Map<String, Object> parameters = new HashMap<String, Object>();					
					parameters.put("jr_NumeroCartaPorte",""+print.getFolio());
					parameters.put("jr_FolioCartaPorte",""+print.getIdCCartaPorte());
					parameters.put("jr_FolioInternoTalon",""+print.getIdTalones());
					parameters.put("jr_NumeroControl",""+print.getNumeroControl());
					parameters.put("jr_UUID",print.getuUID());
					parameters.put("jr_FechaTimbrado",print.getFechaTimbrado());
					parameters.put("jr_FechaEmision",print.getFechaEmision());
					parameters.put("jr_CertificadoDigital",print.getCertificadoDigital());
					parameters.put("jr_CertificadoSAT",print.getCertificadoSAT());
					parameters.put("jr_NombreClienteF",print.getNombreClienteF());
					parameters.put("jr_RFC_Facturado",print.getFacturadoRFC());
					parameters.put("jr_Direccion_Entrega",print.getDireccionEntrega());
					//parameters.put("jr_IdCartaPorteArticulos",""+print.getIdCCartaPorte());
					parameters.put("jr_Observaciones",print.getObservaciones());
					parameters.put("jr_MetodoDePago",print.getMetodoPago());
					parameters.put("jr_UsoCFDI",print.getUsoCFDI());
					parameters.put("jr_FormaDePago",print.getFormaPago());
					
					//parameters.put("jr_Aseguradora",print.getAseguradora());
					//parameters.put("jr_Poliza",print.getPoliza());
					
					//DESCOMENTAR CUNADO ESTE POLIZAS CARGA Y CIVIL
					parameters.put("jr_AseguradoraPolizaCivil",print.getAseguradora()+" , "+print.getPoliza());
					parameters.put("jr_AseguradoraPolizaCarga", !print.getAseguraCarga().equals("") && !print.getPolizaCarga().equals("")?print.getAseguraCarga()+" , "+print.getPolizaCarga():print.getAseguraCarga());
				
					//parameters.put("jr_IdTalones",""+1184089);
					parameters.put("jr_KmRecorridos",print.getKmRecorridos());
					parameters.put("jr_PlacasTractoCamion",print.getPlacasTractoCamion());
					parameters.put("jr_PlacasRemolque",print.getPlacasRemolque());
					parameters.put("jr_NombreOperador",print.getNombreOperador());
					parameters.put("jr_RFC_Operador",print.getOperadorRFC());
					parameters.put("jr_Licencia",print.getLicencia());
					parameters.put("jr_ClaveConfigVehicular",print.getClaveConfigVehicular());
					parameters.put("jr_TipoSubRemolque",print.getTipoSubRemolque());
					parameters.put("jr_Subtotal",""+print.getSubtotal());			
					parameters.put("jr_Flete",""+print.getFlete());					
					parameters.put("jr_ImpuestoRet",print.getImpuestoRetencion());
					parameters.put("jr_TipoFactorRet",print.getTipoFactorRetencion());
					parameters.put("jr_TasaRet",print.getTasaRetencion());
					parameters.put("jr_Iva",""+print.getIva());
					parameters.put("jr_Total",""+print.getTotal());
					parameters.put("jr_Retencion",""+print.getRetencion());
					parameters.put("jr_NetoPagar",""+print.getNetoPagar());
					parameters.put("jr_CadenaOriginal",print.getCadenaOriginal());
					parameters.put("jr_SelloDigitalCFDI",print.getSelloDigitalCFDI());
					parameters.put("jr_SelloDigitalSAT",print.getSelloDigitalSAT());
					parameters.put("jr_RutaQR",print.getCodigoQR());
					parameters.put("jr_Serie",print.getSerie());
					
					parameters.put("jr_DireccionOrigen",print.getDireccionOrigen());
					parameters.put("jr_LugarExpedicion",print.getLugarExpedicion());
					parameters.put("jr_DireccionOperador",print.getDireccionOperador());
					parameters.put("jr_ObservacionCP",print.getObservacionesCP());
					
					
					parameters.put("jr_ListArticulos",print.getArticulos());
					parameters.put("jr_ListServicios",print.getServicios());
					
					JasperPrint jsPrint = JasperFillManager.fillReport(factu, parameters, conn);
				    JasperExportManager.exportReportToPdfFile(jsPrint,print.getRutaFile());
					imprimirOK.setSuccess(true);
		     }
	     
		  }catch (Exception e) {
			e.printStackTrace();
			imprimirOK.setSuccess(false);
			imprimirOK.setMsjError(e.getMessage());
		}
		finally {
	         if (this.conectionNoTransactional == null) {
	            CConnection.close(conn);
	       
	          }
	    }
		return imprimirOK;
	}

	@Override
	public Impresion facturadoCliente(CartaPorte idTalones) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Impresion impresion= null;
        try {
            conn = this.conectionNoTransactional != null ? this.conectionNoTransactional : CConnection.getConnection();
            stmt = conn.prepareStatement(EnumImpresion.FACTURADOACLIENTE.getPrint());
            stmt.setInt(1, idTalones.getIdTalones());
            rs = stmt.executeQuery();      
            while (rs.next()) {
            	impresion = new Impresion();
            	impresion.setNombreClienteF(rs.getString("NombreCliente"));
            	impresion.setFacturadoRFC(rs.getString("Rfc"));
            }     
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conectionNoTransactional == null) {
            	CConnection.close(conn);
            }

        }      
		return impresion;	
	}

	@Override
	public Impresion enviarDomicilio(CartaPorte idTalones) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Impresion impresion= null;
        try {
            conn = this.conectionNoTransactional != null ? this.conectionNoTransactional : CConnection.getConnection();
            stmt = conn.prepareStatement(EnumImpresion.ENVIARADIRECCION.getPrint());
            stmt.setInt(1, idTalones.getIdTalones());
            rs = stmt.executeQuery();      
            while (rs.next()) {
            	impresion = new Impresion();
            	impresion.setDireccionEntrega(rs.getString("LugarEntrega"));
            }     
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conectionNoTransactional == null) {
            	CConnection.close(conn);
            }

        }             
		return impresion;	
	}
	
	@Override
	public Impresion observaciones(CartaPorte idCartaPorte) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Impresion impresion= new Impresion();
        String observacion="";
        try {
            conn = this.conectionNoTransactional != null ? this.conectionNoTransactional : CConnection.getConnection();
            stmt = conn.prepareStatement(EnumImpresion.OBSERVACIONES.getPrint());
            stmt.setInt(1, idCartaPorte.getIdCCartaPorte());
            //stmt.setString(2, idCartaPorte.getTipoMovimiento());
            rs = stmt.executeQuery();      
            while (rs.next()) { 	
            	observacion =observacion + rs.getString("Empleado")+"/" ;
            } 
            impresion.setObservaciones(observacion);
           
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conectionNoTransactional == null) {
            	CConnection.close(conn);
            }

        }      
		return impresion;	
	}
	
	
	@Override
	public Impresion metodoPago(CartaPorte idTalones) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Impresion impresion= null;
        try {
            conn = this.conectionNoTransactional != null ? this.conectionNoTransactional : CConnection.getConnection();
            stmt = conn.prepareStatement(EnumImpresion.METODODEPAGO.getPrint());
            stmt.setInt(1, idTalones.getIdTalones());
            rs = stmt.executeQuery();      
            while (rs.next()) {
            	impresion = new Impresion();
            	impresion.setMetodoPago(rs.getString("MetodoPago"));
            }     
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conectionNoTransactional == null) {
            	CConnection.close(conn);
            }

        }      
		return impresion;	
	}

	@Override
	public Impresion usoCFDI(CartaPorte idCartaPorte) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Impresion impresion= null;
        try {
            conn = this.conectionNoTransactional != null ? this.conectionNoTransactional : CConnection.getConnection();
            stmt = conn.prepareStatement(EnumImpresion.USOCFDI.getPrint());
            stmt.setInt(1, idCartaPorte.getIdCCartaPorte());
            rs = stmt.executeQuery();      
            while (rs.next()) {
            	impresion = new Impresion();
            	impresion.setUsoCFDI(rs.getString("UsoCFDI"));
            }     
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conectionNoTransactional == null) {
            	CConnection.close(conn);
            }

        }      
		return impresion;	
	}

	@Override
	public Impresion formaDePago(CartaPorte idCartaPorte) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Impresion impresion= null;
        try {
            conn = this.conectionNoTransactional != null ? this.conectionNoTransactional : CConnection.getConnection();
            stmt = conn.prepareStatement(EnumImpresion.FORMADEPAGO.getPrint());
            stmt.setInt(1, idCartaPorte.getIdCCartaPorte());
            rs = stmt.executeQuery();      
            while (rs.next()) {
            	impresion = new Impresion();
            	impresion.setFormaPago(rs.getString("FormaPago"));
            }     
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conectionNoTransactional == null) {
            	CConnection.close(conn);
            }

        }      
		return impresion;	
	}

	@Override
	public Impresion aseguradoraPoliza(CartaPorte idTalones) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Impresion impresion= null;
        Integer idAseguradoras=0;
		Integer idPolizasSeguroCliente=0;
        try {
            conn = this.conectionNoTransactional != null ? this.conectionNoTransactional : CConnection.getConnection();
            stmt = conn.prepareStatement(EnumImpresion.ASEGURADORAPOLIZA.getPrint());
            stmt.setInt(1, idTalones.getIdTalones());
            rs = stmt.executeQuery();      
            while (rs.next()) {
            	impresion = new Impresion();
            	//impresion.setAseguradora(rs.getString("NombreAseguradora"));
            	//impresion.setPoliza(rs.getString("Poliza"));
            	
            	
            	impresion.setAseguradora(EnumImpresion.ASEGURARESPCIVIL.getPrint());
            	impresion.setPoliza(EnumImpresion.POLIZARESPCIVIL.getPrint());     
            	idAseguradoras = rs.getInt("IdAseguradoras");
            	idPolizasSeguroCliente= rs.getInt("IdPolizasSeguroCliente");
            	if(idAseguradoras ==1 &&  idPolizasSeguroCliente == 1){
            		
            		impresion.setAseguraCarga(EnumImpresion.LEYENDA.getPrint());
                	impresion.setPolizaCarga("");
            		
            	}
            	else {
                	impresion.setAseguraCarga(rs.getString("NombreAseguradora"));
                	impresion.setPolizaCarga(rs.getString("Poliza"));
            	}
            	
            	
            	
            }     
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conectionNoTransactional == null) {
            	CConnection.close(conn);
            }

        }      
		return impresion;	
	}

	@Override
	public Impresion Operador(CartaPorte idInformesTalones) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Impresion impresion= null;
        try {
            conn = this.conectionNoTransactional != null ? this.conectionNoTransactional : CConnection.getConnection();
            if(idInformesTalones.getIdInformes().equals(-1)){ //Es carta porte Talon no requiere informe  
            	
            	 stmt = conn.prepareStatement(EnumImpresion.OPERADORCARTAPORTE.getPrint());
                 stmt.setInt(1, idInformesTalones.getIdCCartaPorte());
            }
            else{//es por  informes tiene un numero de informe
            
            	 stmt = conn.prepareStatement(EnumImpresion.OPERADOR.getPrint());
                 stmt.setInt(1, idInformesTalones.getIdInformes());
            	
            }    
            rs = stmt.executeQuery();      
            while (rs.next()) {
            	impresion = new Impresion();
            	impresion.setNombreOperador(rs.getString("NombreOperador"));
            	impresion.setOperadorRFC(rs.getString("RFC"));
            	impresion.setLicencia(rs.getString("Licencia"));
            }     
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conectionNoTransactional == null) {
            	CConnection.close(conn);
            }

        }      
		return impresion;	
	}

	@Override
	public Impresion tractoCamion(CartaPorte idCartaPorte) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Impresion impresion= null;
        try {
            conn = this.conectionNoTransactional != null ? this.conectionNoTransactional : CConnection.getConnection();
            stmt = conn.prepareStatement(EnumImpresion.TRACTOCAMION.getPrint());
            stmt.setInt(1, idCartaPorte.getIdCCartaPorte());
            rs = stmt.executeQuery();      
            while (rs.next()) {
            	impresion = new Impresion();
            	impresion.setKmRecorridos(rs.getFloat("KmsRecorridos"));
            	impresion.setPlacasTractoCamion(rs.getString("PlacasTracto"));
            	impresion.setPlacasRemolque(rs.getString("PlacasRem"));
            	impresion.setClaveConfigVehicular(rs.getString("ConfigVehicular"));
            	impresion.setTipoSubRemolque(rs.getString("SubTipoRem"));
            }     
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conectionNoTransactional == null) {
            	CConnection.close(conn);
            }

        }      
		return impresion;	
	}

	@Override
	public Impresion datosTimbrado(CartaPorte idCartaPorte) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Impresion impresion= null;
        try {
            conn = this.conectionNoTransactional != null ? this.conectionNoTransactional : CConnection.getConnectionCFDI();
            stmt = conn.prepareStatement(EnumImpresion.DATOSTIMBRADO.getPrint());
            stmt.setInt(1, idCartaPorte.getIdCCartaPorte());
            rs = stmt.executeQuery();      
            while (rs.next()) {
            	impresion = new Impresion();
            	impresion.setFechaEmision(rs.getString("dtFechaEmision"));
            	impresion.setFechaTimbrado(rs.getString("dtFechaTimbrado"));
            	impresion.setuUID(rs.getString("sUUID"));
            	impresion.setsXmlTimbrado(rs.getString("sXmlTimbrado"));
            	impresion.setCertificadoDigital(rs.getString("sCertificadoDigital"));
            	impresion.setCertificadoSAT(rs.getString("sCertificadoSAT"));
            	impresion.setCadenaOriginal(rs.getString("sCadenaOriginal"));
            	impresion.setSelloDigitalCFDI(rs.getString("sSelloDigitalCFDI"));
            	impresion.setSelloDigitalSAT(rs.getString("sSelloDigitalSAT")); 	
            }   
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conectionNoTransactional == null) {
            	CConnection.close(conn);
            }

        }      
		return impresion;	
	}

	@Override
	public Impresion llenaDatos(CartaPorte cartaPorte,Integer opction)throws SQLException {
		
		
		Boolean success=false;
		Impresion dataPrint;
		Impresion impresion= null;
		Impresion xml=null;
		Integer sucursal;
		String letraSucursal="";
		Impresion response=null;
		 List<Articulos> listArticulos =new ArrayList<>();
		List<Servicios> listServicios=new ArrayList<>();
		JRBeanCollectionDataSource collectionArticulos=null;
		JRBeanCollectionDataSource collectionConceptos = null;
		
		//EL OPTION SOLO RECIBE ENTRE 1=INFORMES Y 2=TALON CARTA PORTE  
		
		
			if(!cartaPorte.equals(null)) {/*idCartaporte,idTalones*/
				dataPrint =new Impresion();
				
				
				impresion=usuarioSucursal(cartaPorte.getIdEmpleado());
				if(!impresion.equals(null)){
					
					/*113   MERIDA
					  49 CANCUN
					  826 CIUDAD DE MEXICO*/
					sucursal =impresion.getIdCiudades();
					
					if(sucursal.equals(113)){
						dataPrint.setDireccionOrigen(EnumImpresion.DIRECCIONOPERADORMERIDA.getPrint());
						dataPrint.setLugarExpedicion(EnumImpresion.LUGRAEXPMERIDA.getPrint());
						dataPrint.setDireccionOperador(EnumImpresion.DIRECCIONOPERADORMERIDA.getPrint());
						letraSucursal = EnumImpresion.LETRAMERIDA.getPrint();
					}
					else if(sucursal.equals(49)){
						dataPrint.setDireccionOrigen(EnumImpresion.DIRECCIONORIGENCANCUN.getPrint());
						dataPrint.setLugarExpedicion(EnumImpresion.LUGAREXPCANCUN.getPrint());
						dataPrint.setDireccionOperador(EnumImpresion.DIRECCIONOPERADORCANCUN.getPrint());
						letraSucursal = EnumImpresion.LETRACANCUN.getPrint();
					}
					else {
						
						dataPrint.setDireccionOrigen(EnumImpresion.DIRECCIONORIGENCDMX.getPrint());
						dataPrint.setLugarExpedicion(EnumImpresion.LUGAREXPCDMX.getPrint());
						dataPrint.setDireccionOperador(EnumImpresion.DIRECCIONOPERADORCDMX.getPrint());
					
					}
				
					
					
				}
		
				dataPrint.setFolio(cartaPorte.getFolio());
				dataPrint.setIdCCartaPorte(cartaPorte.getIdCCartaPorte());
				dataPrint.setIdTalones(cartaPorte.getIdTalones());
				dataPrint.setNumeroControl(cartaPorte.getNumeroControl());
				dataPrint.setSerie(cartaPorte.getSerie());		
				impresion =datosTimbrado(cartaPorte);
				if(impresion !=null) {			
//				dataPrint.setuUID("C79EE976-E1FB-4A6C-8BC4-0FCEAAFD1C60");
//				dataPrint.setsXmlTimbrado("<?xml version=\"1.0\" encoding=\"utf-8\"?>  <cfdi:Comprobante xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv33.xsd\" Version=\"3.3\" Serie=\"A\" Folio=\"1195765\" Fecha=\"2021-11-22T17:48:08\" Sello=\"MVdJQpkPxi4HHuxk77y1Gwp5vAPQcVmKv/gUw5IvuG1YIU3dWGAIFoww9TfozZdB8oUn+zpkWnS00ahexq7eOfQratNrh8hLwHv1Qp7cI3RmW+0KB7e2R00bRr5l4N32lYTXI2vWPrzFwoxfiXbxLgay2YgTyh5MA9gheocvGlztp9NyRTDnaY4exrwFYOH47mp8K1TL/Mzvs+BVnucXO45/2i78ZVgprBkIEelXpnJurCGWjMmKPD1aHLIjZQn34L4Pa8SCZu5d4YHIu30aG3r2C+LMiuYaEOyWBz0gLSVk47G0zjknzwBCo1sruWEcIIxxqVcuovnxENL/JqhiSQ==\" FormaPago=\"99\" NoCertificado=\"00001000000502828869\" Certificado=\"MIIF6zCCA9OgAwIBAgIUMDAwMDEwMDAwMDA1MDI4Mjg4NjkwDQYJKoZIhvcNAQELBQAwggGEMSAwHgYDVQQDDBdBVVRPUklEQUQgQ0VSVElGSUNBRE9SQTEuMCwGA1UECgwlU0VSVklDSU8gREUgQURNSU5JU1RSQUNJT04gVFJJQlVUQVJJQTEaMBgGA1UECwwRU0FULUlFUyBBdXRob3JpdHkxKjAoBgkqhkiG9w0BCQEWG2NvbnRhY3RvLnRlY25pY29Ac2F0LmdvYi5teDEmMCQGA1UECQwdQVYuIEhJREFMR08gNzcsIENPTC4gR1VFUlJFUk8xDjAMBgNVBBEMBTA2MzAwMQswCQYDVQQGEwJNWDEZMBcGA1UECAwQQ0lVREFEIERFIE1FWElDTzETMBEGA1UEBwwKQ1VBVUhURU1PQzEVMBMGA1UELRMMU0FUOTcwNzAxTk4zMVwwWgYJKoZIhvcNAQkCE01yZXNwb25zYWJsZTogQURNSU5JU1RSQUNJT04gQ0VOVFJBTCBERSBTRVJWSUNJT1MgVFJJQlVUQVJJT1MgQUwgQ09OVFJJQlVZRU5URTAeFw0yMDAxMjExNTM3MzdaFw0yNDAxMjExNTM3MzdaMIG5MR8wHQYDVQQDExZQRVJMSSBFWFBSRVNTIFNBIERFIENWMR8wHQYDVQQpExZQRVJMSSBFWFBSRVNTIFNBIERFIENWMR8wHQYDVQQKExZQRVJMSSBFWFBSRVNTIFNBIERFIENWMSUwIwYDVQQtExxQRVg5MTA1MTVGVjAgLyBQRUxQNDkxMDA1MzcwMR4wHAYDVQQFExUgLyBQRUxQNDkxMDA1SFBMUk1MMDMxDTALBgNVBAsTBENETVgwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCh62FHQcWL4Zu368WL4HaIFEuaFkSjJLxRTgj5bwgC3pgAobFN31AR2WIdjrYK2AX81vqhLtxptKZmDpW7e24m5mFzEXlMHHQOuNbl9tTuyC7Nkgh0RIjZCVYKQoS2WVQRgEok858jrSZ3Ke6MLDlFo3WKf0Y3SUznN7ln0MAliMR6a5WOEfxxAjZMaidizS2evuDnM1KQgW9Dd6DZG70NZWuZ4bguzIScSy3AJ0zCPOtY1glDjhFx1DtmohCLfUxgm35Labj5x9KgLahQs6LsqAmkfkixwHD7+YSsoBrQRFuuhNi4RDZiF4r1qQsRiOah+4HYpPThH1Hqt2czn4VjAgMBAAGjHTAbMAwGA1UdEwEB/wQCMAAwCwYDVR0PBAQDAgbAMA0GCSqGSIb3DQEBCwUAA4ICAQCWebtVANNB9jQRXXY1QwggTiLZtMpxnGTdOTEm/rp8dE7fUd3HH/K9F/cDFyRFgBkSg8QvhJKEhdo+xYXwhESPB5wWgDrH5A9NiS4Dx7mJW3JekwFoRUtCm3ULMsHrfOty/BnSvlAmyQhn8dilhBnA70Nvz2nw6mkbHsHl9/HdH1AYlYZVXrckcWr9nuQwSCx9rw+BNAS1CymFTvm91tv5O/iaerVY5mQ+yjhslDqLpc/sAI57y1waABxMwEG7+eF/94en6sGDIoABy+EVt+VPq4zmq2J91fFkhPb17QN01UuPNuPDcXH73VDs5ASnu18cfAUUMCZ9HY4Wmy7TVboTvB3BEcTCD/hyR0aizKiQX8WILRseXxOUo1a9BW/TzPIM8vfEudkBg1KdbbtI+kG4ltfCR9pYq3pLRy6Lu2bcFW0RtfstaGHwnOkmfPKe/5G2wcySbM//jUjDEC/W2gt8Hc91uHlRj5OXfZ1NL/y7DqhD15Ytw3milKinTJjyzVaH/7ZoTxcNQZTDde126rTzSUBUWiaIES4s2/Ul6nuW0XIpnWXd+EjgkTVxR2jNVSljUFbRiGQq7Mf2s2IrdysGhpHJXPcGIIZmjlo7Dvh5b00UwPA5g7lQJFdpV656AU+TMUWFrcYe+7dOHpenUzWqarb65yynVp/8hQQJmQioEg==\" CondicionesDePago=\"CONTADO\" SubTotal=\"1053.27\" Moneda=\"MXN\" Total=\"1202.19\" TipoDeComprobante=\"I\" MetodoPago=\"PPD\" LugarExpedicion=\"11290\" xmlns:cfdi=\"http://www.sat.gob.mx/cfd/3\">   <cfdi:Emisor Rfc=\"PEX910515FV0\" Nombre=\"PERLI EXPRESS SA DE CV\" RegimenFiscal=\"601\" />   <cfdi:Receptor Rfc=\"AED980422HD6\" Nombre=\"AUTO ELECTRICA DIESEL, S.A. DE C.V.\" UsoCFDI=\"G03\" />   <cfdi:Conceptos>    <cfdi:Concepto ClaveProdServ=\"78101800\" NoIdentificacion=\"FLETE\" Cantidad=\"1\" ClaveUnidad=\"E48\" Unidad=\"SERVICIO\" Descripcion=\"FLETE\" ValorUnitario=\"490.00\" Importe=\"490.00\">     <cfdi:Impuestos>      <cfdi:Traslados>       <cfdi:Traslado Base=\"490.00\" Impuesto=\"002\" TipoFactor=\"Tasa\" TasaOCuota=\"0.160000\" Importe=\"78.40\" />      </cfdi:Traslados>      <cfdi:Retenciones>       <cfdi:Retencion Base=\"490.00\" Impuesto=\"002\" TipoFactor=\"Tasa\" TasaOCuota=\"0.040000\" Importe=\"19.60\" />      </cfdi:Retenciones>     </cfdi:Impuestos>    </cfdi:Concepto>    <cfdi:Concepto ClaveProdServ=\"84131504\" NoIdentificacion=\"SEGURO\" Cantidad=\"1\" ClaveUnidad=\"E48\" Unidad=\"SERVICIO\" Descripcion=\"SEGURO\" ValorUnitario=\"312.27\" Importe=\"312.27\">     <cfdi:Impuestos>      <cfdi:Traslados>       <cfdi:Traslado Base=\"312.27\" Impuesto=\"002\" TipoFactor=\"Tasa\" TasaOCuota=\"0.160000\" Importe=\"49.96\" />      </cfdi:Traslados>     </cfdi:Impuestos>    </cfdi:Concepto>    <cfdi:Concepto ClaveProdServ=\"01010101\" NoIdentificacion=\"REC. EVIDENCIA\" Cantidad=\"1\" ClaveUnidad=\"E48\" Unidad=\"SERVICIO\" Descripcion=\"RECUPERACION DE EVIDENCIA\" ValorUnitario=\"251.00\" Importe=\"251.00\">     <cfdi:Impuestos>      <cfdi:Traslados>       <cfdi:Traslado Base=\"251.00\" Impuesto=\"002\" TipoFactor=\"Tasa\" TasaOCuota=\"0.160000\" Importe=\"40.16\" />      </cfdi:Traslados>     </cfdi:Impuestos>    </cfdi:Concepto>   </cfdi:Conceptos>   <cfdi:Impuestos TotalImpuestosRetenidos=\"19.60\" TotalImpuestosTrasladados=\"168.52\">    <cfdi:Retenciones>     <cfdi:Retencion Impuesto=\"002\" Importe=\"19.60\" />    </cfdi:Retenciones>    <cfdi:Traslados>     <cfdi:Traslado Impuesto=\"002\" TipoFactor=\"Tasa\" TasaOCuota=\"0.160000\" Importe=\"168.52\" />    </cfdi:Traslados>   </cfdi:Impuestos>   <cfdi:Complemento>    <tfd:TimbreFiscalDigital xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.sat.gob.mx/TimbreFiscalDigital http://www.sat.gob.mx/sitio_internet/cfd/TimbreFiscalDigital/TimbreFiscalDigitalv11.xsd\" Version=\"1.1\" RfcProvCertif=\"CCF1011111K9\" SelloSAT=\"BT7wioMGkkXAph4nQq5C7QJqPcSbsh8cOe7qMxwgmGX2yzbkqknn5OLKBAo+ZfG1V50xaelb9YPTuiOpfbnpK5ND2Z0O4aZgTMf9cLVy5j2WKwejQUrTcngfDhPwZHLCK/imaY42xjEvl2QjDNrjEFG18Ks2RidS5RKNLA9o4rXwILxSMWjSqGqzxBqtNdFu0G+K2rlU+t7izKKwbciQx3ye8u8ASYIcwNPAFIkoD3TfyLk5/TR2itjhxSfo/OFij1bWy1uBY2U0FcJFjuxFT0DxEvDR7rxpObYgzQe+/X+jFxGF95LE2RRMjb1aDwV15JY9bs+dAMNwu0I3REwuZg==\" NoCertificadoSAT=\"00001000000508341381\" FechaTimbrado=\"2021-11-22T17:53:23\" UUID=\"C79EE976-E1FB-4A6C-8BC4-0FCEAAFD1C60\" SelloCFD=\"MVdJQpkPxi4HHuxk77y1Gwp5vAPQcVmKv/gUw5IvuG1YIU3dWGAIFoww9TfozZdB8oUn+zpkWnS00ahexq7eOfQratNrh8hLwHv1Qp7cI3RmW+0KB7e2R00bRr5l4N32lYTXI2vWPrzFwoxfiXbxLgay2YgTyh5MA9gheocvGlztp9NyRTDnaY4exrwFYOH47mp8K1TL/Mzvs+BVnucXO45/2i78ZVgprBkIEelXpnJurCGWjMmKPD1aHLIjZQn34L4Pa8SCZu5d4YHIu30aG3r2C+LMiuYaEOyWBz0gLSVk47G0zjknzwBCo1sruWEcIIxxqVcuovnxENL/JqhiSQ==\" xmlns:tfd=\"http://www.sat.gob.mx/TimbreFiscalDigital\" />   </cfdi:Complemento>  </cfdi:Comprobante>");
//				dataPrint.setFechaTimbrado("2021-11-22T17:53:23");
//				dataPrint.setFechaEmision("2021-11-22T17:53:23");
//				dataPrint.setCertificadoDigital("00001000000502828869");
//				dataPrint.setCertificadoSAT("00001000000508341381");
//				dataPrint.setCadenaOriginal("||3.3|A|1195765|2021-11-22T17:48:08|99|00001000000502828869|CONTADO|1053.27|MXN|1202.19|I|PPD|11290|PEX910515FV0|PERLI EXPRESS SA DE CV|601|AED980422HD6|AUTO ELECTRICA DIESEL, S.A. DE C.V.|G03|78101800|FLETE|1|E48|SERVICIO|FLETE|490.00|490.00|490.00|002|Tasa|0.160000|78.40|490.00|002|Tasa|0.040000|19.60|84131504|SEGURO|1|E48|SERVICIO|SEGURO|312.27|312.27|312.27|002|Tasa|0.160000|49.96|01010101|REC. EVIDENCIA|1|E48|SERVICIO|RECUPERACION DE EVIDENCIA|251.00|251.00|251.00|002|Tasa|0.160000|40.16|002|19.60|19.60|002|Tasa|0.160000|168.52|168.52||");
//				dataPrint.setSelloDigitalCFDI("MVdJQpkPxi4HHuxk77y1Gwp5vAPQcVmKv/gUw5IvuG1YIU3dWGAIFoww9TfozZdB8oUn+zpkWnS00ahexq7eOfQratNrh8hLwHv1Qp7cI3RmW+0KB7e2R00bRr5l4N32lYTXI2vWPrzFwoxfiXbxLgay2YgTyh5MA9gheocvGlztp9NyRTDnaY4exrwFYOH47mp8K1TL/Mzvs+BVnucXO45/2i78ZVgprBkIEelXpnJurCGWjMmKPD1aHLIjZQn34L4Pa8SCZu5d4YHIu30aG3r2C+LMiuYaEOyWBz0gLSVk47G0zjknzwBCo1sruWEcIIxxqVcuovnxENL/JqhiSQ==");
//				dataPrint.setSelloDigitalSAT("BT7wioMGkkXAph4nQq5C7QJqPcSbsh8cOe7qMxwgmGX2yzbkqknn5OLKBAo+ZfG1V50xaelb9YPTuiOpfbnpK5ND2Z0O4aZgTMf9cLVy5j2WKwejQUrTcngfDhPwZHLCK/imaY42xjEvl2QjDNrjEFG18Ks2RidS5RKNLA9o4rXwILxSMWjSqGqzxBqtNdFu0G+K2rlU+t7izKKwbciQx3ye8u8ASYIcwNPAFIkoD3TfyLk5/TR2itjhxSfo/OFij1bWy1uBY2U0FcJFjuxFT0DxEvDR7rxpObYgzQe+/X+jFxGF95LE2RRMjb1aDwV15JY9bs+dAMNwu0I3REwuZg==");
//				
							
				    dataPrint.setuUID(impresion.getuUID());
					dataPrint.setsXmlTimbrado(impresion.getsXmlTimbrado());
					dataPrint.setFechaTimbrado(impresion.getFechaTimbrado());
					dataPrint.setFechaEmision(impresion.getFechaEmision());
					dataPrint.setCertificadoDigital(impresion.getCertificadoDigital());
					dataPrint.setCertificadoSAT(impresion.getCertificadoSAT());
					dataPrint.setCadenaOriginal(impresion.getCadenaOriginal());
					dataPrint.setSelloDigitalCFDI(impresion.getSelloDigitalCFDI());
					dataPrint.setSelloDigitalSAT(impresion.getSelloDigitalSAT());
				}
				
				/*CLIENTE QUIEN PAGA*/
				
				
				impresion = facturadoCliente(cartaPorte);
				if(!impresion.equals(null)){
					dataPrint.setNombreClienteF(impresion.getNombreClienteF());
					dataPrint.setFacturadoRFC(impresion.getFacturadoRFC());
				}
							
				impresion = enviarDomicilio(cartaPorte);
				if(!impresion.equals(null)){
					
					////AV. CHICHENITZA L.60 MZA. 30 SMZA. 23 77500 BENITO JUAREZ CANCUN / QUINTANA ROO (01998) 4154771
					//dataPrint.setDireccionEntrega("CARRETERA PALENQUE PAKALNA S/N LOMAS DE PAKAL 29960 PALENQUE / CHIAPAS (01916) 9931614651");
					dataPrint.setDireccionEntrega(impresion.getDireccionEntrega());
				}
				
				impresion =observaciones(cartaPorte);
				if(!impresion.equals(null)) {
					dataPrint.setObservaciones(impresion.getObservaciones());
				}
				impresion = metodoPago(cartaPorte);
				if(!impresion.equals(null)) {
					dataPrint.setMetodoPago(impresion.getMetodoPago());
				}
				impresion = usoCFDI(cartaPorte);
				if(!impresion.equals(null)) {
					dataPrint.setUsoCFDI(impresion.getUsoCFDI());
				}
				impresion = formaDePago(cartaPorte);
				if(!impresion.equals(null)) {
					dataPrint.setFormaPago(impresion.getFormaPago());
				}
				impresion = aseguradoraPoliza(cartaPorte);
				if(!impresion.equals(null)) {
      				dataPrint.setAseguradora(impresion.getAseguradora());
					dataPrint.setPoliza(impresion.getPoliza());
					dataPrint.setAseguraCarga(impresion.getAseguraCarga());
					dataPrint.setPolizaCarga(impresion.getPolizaCarga());
				}
		
				impresion= Operador(cartaPorte);
				/*si es por informe consulta en Empleados_Informes si no por asignado en  empleados carta porte */			
				if(!impresion.equals(null)){
					dataPrint.setNombreOperador(impresion.getNombreOperador());
					dataPrint.setOperadorRFC(impresion.getOperadorRFC());
					dataPrint.setLicencia(impresion.getLicencia());
				}
				
				impresion = tractoCamion(cartaPorte);
				if(!impresion.equals(null)){
					dataPrint.setKmRecorridos(impresion.getKmRecorridos());
					dataPrint.setPlacasTractoCamion(impresion.getPlacasTractoCamion());
					dataPrint.setPlacasRemolque(impresion.getPlacasRemolque());
					dataPrint.setClaveConfigVehicular(impresion.getClaveConfigVehicular());
					dataPrint.setTipoSubRemolque(impresion.getTipoSubRemolque());
				}
				
				dataPrint.setSubtotal(cartaPorte.getImporteSubTotal());
				
				if(cartaPorte.getImporteRetencion().signum() > 0) {
					//anterior
					dataPrint.setFlete(""+cartaPorte.getValorFlete());
					//dataPrint.setFlete(""+cartaPorte.getImporteSubTotal());
					dataPrint.setImpuestoRetencion("002");
					dataPrint.setTipoFactorRetencion("TASA");
					dataPrint.setTasaRetencion("0.0400");
					dataPrint.setRetencion(""+cartaPorte.getImporteRetencion());
				}
				else if(cartaPorte.getImporteRetencion().signum() == 0){
					dataPrint.setFlete("");
					dataPrint.setImpuestoRetencion("");
					dataPrint.setTipoFactorRetencion("");
					dataPrint.setTasaRetencion("");
					dataPrint.setRetencion("************");
				}
				dataPrint.setIva(cartaPorte.getImporteIVA());
				dataPrint.setTotal(cartaPorte.getImporteTotal());
				dataPrint.setNetoPagar(cartaPorte.getImporteNetoPagar());
				
				dataPrint.setObservacionesCP(cartaPorte.getObservaciones());
				
				
				impresion.setIdCCartaPorte(cartaPorte.getIdCCartaPorte());
				if(!nombreServer().equals("")){
					
					if(opction.equals(1)){ //informes
						
						dataPrint.setRutaPlantilla(nombreServer().concat(EnumImpresion.RUTAPLANTILLA.getPrint())); 
						  //+EnumImpresion.CARPETAINFORME.getPrint()+cartaPorte.getIdInformes()
						impresion.setRutaFile(nombreServer().concat(EnumImpresion.RUTASTORAGEPDF.getPrint()));//ruta de almacenamiento pdf
						impresion.setNameCarpeta(EnumImpresion.CARPETAINFORME.getPrint().concat(cartaPorte.getIdInformes().toString())); //nombre carpeta informe
						
						impresion= rutaArchivos(impresion); 
						if(!impresion.equals(null)) {
						dataPrint.setRutaFile(impresion.getRutaStorage().concat(EnumImpresion.NAMEFILETALONCARTAPORTE.getPrint()).concat(cartaPorte.getIdCCartaPorte().toString()).concat("_").concat(cartaPorte.getNumeroControl().toString()).concat(EnumImpresion.FORMATPDF.getPrint()));						
						}
						
					}else if(opction.equals(2)){ //carta porte talon
						
						dataPrint.setRutaPlantilla(nombreServer().concat(EnumImpresion.RUTAPLANTILLA.getPrint()));
						impresion.setRutaFile(nombreServer().concat(EnumImpresion.RUTASTORAGEPDF.getPrint()));//ruta de almacenamiento pdf
						//CartaPorte-35/CartaPorte_35_575656
						impresion.setNameCarpeta(EnumImpresion.CARPETACARTAPORTE.getPrint().concat(cartaPorte.getIdCCartaPorte().toString())); //nombre carpeta talon
						
						impresion= rutaArchivos(impresion); 
						if(!impresion.equals(null)) {
			
						dataPrint.setRutaFile(impresion.getRutaStorage()
								.concat(EnumImpresion.NAMEFILETALONCARTAPORTE.getPrint())
							    .concat(cartaPorte.getIdCCartaPorte().toString())
								.concat("_")
							    .concat(cartaPorte.getNumeroControl().toString())
								.concat(letraSucursal)
								.concat(EnumImpresion.FORMATPDF.getPrint()));
							
						}
						
					}
			
					
				}
				/*REALIZAR EL CODIGO QR*/
				if(!nombreServer().equals("")){
						
					
					impresion.setRutaQR(nombreServer()+EnumImpresion.RUTASTORAGEQR.getPrint()+EnumImpresion.NAMEIMAGEN.getPrint());
					impresion.setFacturadoRFC(dataPrint.getFacturadoRFC());
					impresion.setNetoPagar(dataPrint.getNetoPagar());
					impresion.setuUID(dataPrint.getuUID());
					if(realizaQR(impresion)){
						dataPrint.setCodigoQR(impresion.getRutaQR());
					}
					
					
				}
				
				
				//ARTICULOS
				
				listArticulos = articulos(cartaPorte.getIdCCartaPorte());
				
				System.out.println("tamaño de la lista articulos:"+listArticulos.size());
				if(!listArticulos.isEmpty()){
					
					collectionArticulos = new JRBeanCollectionDataSource(listArticulos);
					dataPrint.setArticulos(collectionArticulos);
				}
				
				
				//servicios
				
				listServicios =servicios(cartaPorte.getIdCCartaPorte());
				System.out.println("tamaño de la lista:"+listServicios.size());
				
				if(!listServicios.isEmpty()){
					
					collectionConceptos = new JRBeanCollectionDataSource(listServicios);
					dataPrint.setServicios(collectionConceptos);
				}

				response = impresion(dataPrint);
				if(response.getSuccess()){
					
					//cambiar estatus de impresion
					
					impresion.setIdCCartaPorte(cartaPorte.getIdCCartaPorte());
					impresion.setIdEmpleado(cartaPorte.getIdEmpleado());
					
					estatusImpresion(impresion);
					//exporte xml
					xml =new Impresion();
					xml.setIdCCartaPorte(cartaPorte.getIdCCartaPorte());
					if(!nombreServer().equals("")){
						
						
						
						if(opction.equals(1)){ //informes
							xml.setRutaFile(nombreServer().concat(EnumImpresion.RUTASTORAGEXML.getPrint()));//ruta de almacenamiento xml
							xml.setNameCarpeta(EnumImpresion.CARPETAINFORME.getPrint().concat(cartaPorte.getIdInformes().toString())); //nombre carpeta informe						
							xml= rutaArchivos(xml); 
							if(!xml.equals(null)) {
								xml.setRutaFile(xml.getRutaStorage()
									.concat(EnumImpresion.NAMEFILETALONCARTAPORTEXML.getPrint())
									.concat(cartaPorte.getIdCCartaPorte().toString())
									.concat("_")
									.concat(cartaPorte.getNumeroControl().toString())
									.concat(letraSucursal)
									.concat(EnumImpresion.FORMATXML.getPrint()));
								xml.setsXmlTimbrado(dataPrint.getsXmlTimbrado());	
								
								if(guardaXml(xml)){ //guardar el xml que se timbro 
									//success =true;
									response.setSuccess(true);
									
								}
								
							}
							
							
					   }
					   else if(opction.equals(2)){ //carta porte talon
					   
						   	xml.setRutaFile(nombreServer().concat(EnumImpresion.RUTASTORAGEXML.getPrint()));//ruta de almacenamiento xml
							xml.setNameCarpeta(EnumImpresion.CARPETACARTAPORTE.getPrint().concat(cartaPorte.getIdCCartaPorte().toString())); //nombre carpeta carta porte						
							xml= rutaArchivos(xml); 
							if(!xml.equals(null)) {
								xml.setRutaFile(xml.getRutaStorage()
										.concat(EnumImpresion.NAMEFILETALONCARTAPORTEXML.getPrint())
										.concat(cartaPorte.getIdCCartaPorte().toString())
										.concat("_")
										.concat(cartaPorte.getNumeroControl().toString())
										.concat(letraSucursal)
										.concat(EnumImpresion.FORMATXML.getPrint()));
								xml.setsXmlTimbrado(dataPrint.getsXmlTimbrado());	
								
								if(guardaXml(xml)){ //guardar el xml que se timbro 
									//success =true;
									response.setSuccess(true);
								}
								
							}
					   
					   
					   }
						
				
						
					}
					
					
					
					
				}
				
				
			}
					
		return response;
	}

	@Override
	public Impresion rutaArchivos(Impresion print) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Impresion impresion= null;
		File rutaArchivo = null;
		String rutaAlmacenamiento;
        
        try {
            conn = this.conectionNoTransactional != null ? this.conectionNoTransactional : CConnection.getConnection();
            stmt = conn.prepareStatement(EnumImpresion.FECHACARTAPORTE.getPrint());
            stmt.setInt(1, print.getIdCCartaPorte());
            rs = stmt.executeQuery();      
            if (rs.next()) {
            	impresion = new Impresion();
            	impresion.setMes(rs.getString("mes"));
            	impresion.setAnio(rs.getString("annio"));
            	impresion.setDia(rs.getString("dia"));
            	
            	
            	if(!impresion.getAnio().equals(null) && !impresion.getMes().equals(null) && !impresion.getDia().equals(null)){
            		
            		rutaAlmacenamiento = print.getRutaFile()
            				.concat(impresion.getAnio()
            				.concat("\\")
            				.concat(impresion.getMes())
            				.concat("\\"))
            				.concat(impresion.getDia())
            				.concat("\\")
            				.concat(print.getNameCarpeta())
            				.concat("\\");
            		rutaArchivo = new File(rutaAlmacenamiento);     		
            		if (rutaArchivo.exists()) {
    					
    					impresion.setRutaStorage(rutaAlmacenamiento);
    				} else {
    					if (rutaArchivo.mkdirs()) {
    						impresion.setRutaStorage(rutaAlmacenamiento);
    					} else {
    						
    						impresion.setRutaStorage("");
    					}
    				}
            	}
            }     
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conectionNoTransactional == null) {
            	CConnection.close(conn);
            }

        }      
		return impresion;	
	}

	@Override
	public String nombreServer() {
		String servidor="";
		try {
			//servidor="//c:/";			
			//servidor="\\\\"+InetAddress.getLocalHost().getHostName().toUpperCase();			
			servidor="\\\\PERLIEXP";	
	
			//servidor="\\\\PERLI-PC2";
			System.out.println("ruta server:"+servidor);
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return servidor;
	}

	@Override
	public Boolean guardaXml(Impresion print) {
		File xml;
		Boolean save=false;		
		try {
			xml = new File(print.getRutaFile());
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(xml), "UTF-8"));

			try {
				bw.write("" + print.getsXmlTimbrado());
				save=true;
			} catch (Exception e) {
				//System.err.println("Error al escribir el archivo XML");
			} finally {
				bw.close();
			}
		} catch (Exception e) {
			
			//System.err.println("Error al guardar el archivo XML");
		
		}	
		return save;
	}

	
	@Override
	public Boolean realizaQR(Impresion print) {
		//Dimensiones
        int ancho = 252;
        int alto = 252;
	
        int punto, enterosFaltan, decimalesFaltan;
        String enteros, decimales;
        String netoPagar;
        netoPagar = String.valueOf(print.getNetoPagar());        
        netoPagar= netoPagar.replace(",","");        
        punto = netoPagar.indexOf('.');        
        enteros = netoPagar.substring(0,punto);
        enterosFaltan = 10-enteros.length();
        decimales = netoPagar.substring(punto+1);
        decimalesFaltan = 6-decimales.length();
        
        netoPagar = "";
        
        for(int e=1;e<=enterosFaltan;e++)
        	netoPagar += "0";
 
        netoPagar += enteros + "." + decimales;
       
        for(int d=1;d<=decimalesFaltan;d++)
        	netoPagar += "0";
        	

	
        String datos = EnumImpresion.RFCPERLI.getPrint()+EnumImpresion.RFCCLIENTE.getPrint()+print.getFacturadoRFC()+
        		EnumImpresion.NETOPAGAR.getPrint()+netoPagar+EnumImpresion.UUID.getPrint()+print.getuUID();
      
        BitMatrix bm;
        Writer writer = new QRCodeWriter();
        Boolean realizoQR=false;
        try {

            bm = writer.encode(datos, BarcodeFormat.QR_CODE, ancho, alto);
            // Crear un buffer para escribir la imagen
            BufferedImage image = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);

            // Iterar sobre la matriz para dibujar los pixeles
            for (int y = 0; y < ancho; y++) {
                for (int x = 0; x < alto; x++) {
                    int grayValue = (bm.get(x, y) ? 0 : 1) & 0xff;
                    image.setRGB(x, y, (grayValue == 0 ? 0 : 0xFFFFFF));
                }
            }

            //Escribir la imagen al archivo
            FileOutputStream qrCode = new FileOutputStream(print.getRutaQR());
            ImageIO.write(image,EnumImpresion.FORMATIMAGEN.getPrint(), qrCode);

            //Se cierra el flujo de datos
            qrCode.close();
            
            realizoQR=true;
        } catch (Exception e) {
            e.printStackTrace(System.err);
           realizoQR=false;
        }	
		return realizoQR;
	}

	@Override
	public Boolean estatusImpresion(Impresion print)throws SQLException {
		 Connection conn = null;
	     CallableStatement cstmt = null;
	     Integer row=0;	
	     Boolean update=false;
	     try {
	     conn = this.conectionNoTransactional != null ? this.conectionNoTransactional : CConnection.getConnection();
	     cstmt = conn.prepareCall(EnumImpresion.SPUCCARTAPORTEIMPRESION.getPrint());
	     cstmt.setInt(1,print.getIdCCartaPorte());
	     cstmt.setInt(2,print.getIdEmpleado());
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
	public Impresion usuarioSucursal(Integer idEmpleado) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Impresion sucursal= null;
        try {
            conn = this.conectionNoTransactional != null ? this.conectionNoTransactional : CConnection.getConnection();          
            stmt = conn.prepareStatement(EnumImpresion.USUARIOSUCURSAL.getPrint());
            stmt.setInt(1,idEmpleado);
            rs = stmt.executeQuery();      
            while (rs.next()) {
           
            	sucursal = new Impresion();
            	sucursal.setIdCiudades(rs.getInt("IdCiudades"));
            	sucursal.setNombreEmpleado(rs.getString("NombreEmpleado"));
         
            }
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conectionNoTransactional == null) {
            	CConnection.close(conn);
            }

        }      
		return sucursal;
	}
	
	@Override
	public List<Articulos> articulos(Integer idCartaPorte) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Articulos> listArticulos =new ArrayList<>();
        Articulos articulo=null;
        try {
            conn = this.conectionNoTransactional != null ? this.conectionNoTransactional : CConnection.getConnection();          
            stmt = conn.prepareStatement(EnumImpresion.ARTICULOS.getPrint());
            stmt.setInt(1,idCartaPorte);
            rs = stmt.executeQuery();      
            while (rs.next()) {    	
            	articulo =new Articulos();
            	articulo.setCantidad(rs.getInt("Cantidad"));
            	articulo.setClaveUnidad(rs.getString("ClaveUnidad"));
            	articulo.setUnidad(rs.getString("Nombre"));
            	articulo.setClaveProducto(rs.getString("ClaveProducto"));
            	articulo.setDescripcion(rs.getString("Descripcion"));
            	articulo.setPesoEnKgs(rs.getFloat("PesoEnKgs"));
            	listArticulos.add(articulo);
            	
            }
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conectionNoTransactional == null) {
            	CConnection.close(conn);
            }

        }
		return listArticulos;
	}
	
	
	@Override
	public Montos montos(Integer idCartaPorte) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Montos montos=new Montos();
        try {
            conn = this.conectionNoTransactional != null ? this.conectionNoTransactional : CConnection.getConnection();          
            stmt = conn.prepareStatement(EnumImpresion.MONTOS.getPrint());
            stmt.setInt(1,idCartaPorte);
            rs = stmt.executeQuery();      
            while (rs.next()) {    	
            	montos.setValorDeclarado(rs.getBigDecimal("ValorDeclarado").setScale(2, RoundingMode.HALF_UP));
				montos.setValorFlete(rs.getBigDecimal("ValorFlete").setScale(2, RoundingMode.HALF_UP));
				montos.setValorSeguro(rs.getBigDecimal("ValorSeguro").setScale(2, RoundingMode.HALF_UP));
				montos.setValorDescarga(rs.getBigDecimal("ValorDescarga").setScale(2, RoundingMode.HALF_UP));
				montos.setValorTransbordador(rs.getBigDecimal("ValorTransbordador").setScale(2, RoundingMode.HALF_UP));
				montos.setValorEntrega(rs.getBigDecimal("ValorEntrega").setScale(2, RoundingMode.HALF_UP));
				montos.setValorCarga(rs.getBigDecimal("ValorCarga").setScale(2, RoundingMode.HALF_UP));
				montos.setValorRecoleccion(rs.getBigDecimal("ValorRecoleccion").setScale(2, RoundingMode.HALF_UP));
				montos.setImporteSubTotal(rs.getBigDecimal("ImporteSubTotal").setScale(2, RoundingMode.HALF_UP));
				montos.setImporteIVA(rs.getBigDecimal("ImporteIVA").setScale(2, RoundingMode.HALF_UP));
				montos.setImporteRetencion(rs.getBigDecimal("ImporteRetencion").setScale(2, RoundingMode.HALF_UP));
				montos.setImporteTotal(rs.getBigDecimal("ImporteTotal").setScale(2, RoundingMode.HALF_UP));
				montos.setImporteNetoPagar(rs.getBigDecimal("ImporteNetoPagar").setScale(2, RoundingMode.HALF_UP));				
            }
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conectionNoTransactional == null) {
            	CConnection.close(conn);
            }

        }      
		return montos;
	}

	@Override
	public List<Servicios> servicios(Integer idCartaPorte) throws SQLException {		
		List<Servicios> listServicios=new ArrayList<Servicios>();
		Montos montos=new Montos();
		Servicios servicio=null;
		montos = montos(idCartaPorte);
		if(montos !=null){
			
			if(montos.getValorFlete().doubleValue()>0){
				servicio=new Servicios();
				servicio.setClave_Servicio(EnumImpresion.CLAVEPRODSERV_802.getPrint());
				servicio.setCantidad(EnumImpresion.CANTIDAD_CONCEPTO.getPrint());
				servicio.setClave_Unidad(EnumImpresion.CLAVEUNIDAD.getPrint());
				servicio.setUnidad(EnumImpresion.UNIDAD.getPrint());
				servicio.setDescripcion(EnumImpresion.FLETE.getPrint());
				servicio.setImporte(montos.getValorFlete());
				listServicios.add(servicio);				
			}
			if(montos.getValorSeguro().doubleValue()>0) {
				servicio=new Servicios();
				servicio.setClave_Servicio(EnumImpresion.CLAVEPRODSERV_800.getPrint());
				servicio.setCantidad(EnumImpresion.CANTIDAD_CONCEPTO.getPrint());
				servicio.setClave_Unidad(EnumImpresion.CLAVEUNIDAD.getPrint());
				servicio.setUnidad(EnumImpresion.UNIDAD.getPrint());
				servicio.setDescripcion(EnumImpresion.SEGURO.getPrint());
				servicio.setImporte(montos.getValorSeguro());
				listServicios.add(servicio);
			}				
			if(montos.getValorCarga().doubleValue()>0) {
				servicio=new Servicios();
				servicio.setClave_Servicio(EnumImpresion.CLAVEPRODSERV_800.getPrint());
				servicio.setCantidad(EnumImpresion.CANTIDAD_CONCEPTO.getPrint());
				servicio.setClave_Unidad(EnumImpresion.CLAVEUNIDAD.getPrint());
				servicio.setUnidad(EnumImpresion.UNIDAD.getPrint());
				servicio.setDescripcion(EnumImpresion.CARGA.getPrint());
				servicio.setImporte(montos.getValorCarga());
				listServicios.add(servicio);
			}
			if (montos.getValorDescarga().doubleValue()>0) {
				servicio=new Servicios();
				servicio.setClave_Servicio(EnumImpresion.CLAVEPRODSERV_800.getPrint());
				servicio.setCantidad(EnumImpresion.CANTIDAD_CONCEPTO.getPrint());
				servicio.setClave_Unidad(EnumImpresion.CLAVEUNIDAD.getPrint());
				servicio.setUnidad(EnumImpresion.UNIDAD.getPrint());
				servicio.setDescripcion(EnumImpresion.DESCARGA.getPrint());
				servicio.setImporte(montos.getValorDescarga());
				listServicios.add(servicio);
			}
			if(montos.getValorEntrega().doubleValue()>0){
				servicio=new Servicios();
				servicio.setClave_Servicio(EnumImpresion.CLAVEPRODSERV_800.getPrint());
				servicio.setCantidad(EnumImpresion.CANTIDAD_CONCEPTO.getPrint());
				servicio.setClave_Unidad(EnumImpresion.CLAVEUNIDAD.getPrint());
				servicio.setUnidad(EnumImpresion.UNIDAD.getPrint());
				servicio.setDescripcion(EnumImpresion.REC_EVIDENCIA.getPrint());
				servicio.setImporte(montos.getValorEntrega());
				listServicios.add(servicio);				
			}
			if(montos.getValorTransbordador().doubleValue()>0){
				servicio=new Servicios();
				servicio.setClave_Servicio(EnumImpresion.CLAVEPRODSERV_800.getPrint());
				servicio.setCantidad(EnumImpresion.CANTIDAD_CONCEPTO.getPrint());
				servicio.setClave_Unidad(EnumImpresion.CLAVEUNIDAD.getPrint());
				servicio.setUnidad(EnumImpresion.UNIDAD.getPrint());
				servicio.setDescripcion(EnumImpresion.PEAJE.getPrint());
				servicio.setImporte(montos.getValorTransbordador());
				listServicios.add(servicio);
			}
			if(montos.getValorRecoleccion().doubleValue()>0){
				servicio=new Servicios();
				servicio.setClave_Servicio(EnumImpresion.CLAVEPRODSERV_800.getPrint());
				servicio.setCantidad(EnumImpresion.CANTIDAD_CONCEPTO.getPrint());
				servicio.setClave_Unidad(EnumImpresion.CLAVEUNIDAD.getPrint());
				servicio.setUnidad(EnumImpresion.UNIDAD.getPrint());
				servicio.setDescripcion(EnumImpresion.RECOLECCION.getPrint());
				servicio.setImporte(montos.getValorRecoleccion());
				listServicios.add(servicio);
			}
			
		}
		return listServicios;
	}

	

}
