package backend.service.implement;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;


import backend.service.CalculadoraService;

public class CalculadoraServiceImplement implements CalculadoraService {

	@Override
	public boolean calcularFlete(HttpSession ses, HttpServletRequest request, HttpServletResponse response) {
		
		Integer opction = Integer.parseInt(request.getParameter("opction"));
		
		System.out.println("opction:"+opction);
		BigDecimal flete=BigDecimal.ZERO;
		BigDecimal descuento=BigDecimal.ZERO;		
		BigDecimal seguro=BigDecimal.ZERO;
		BigDecimal carga=BigDecimal.ZERO;
		BigDecimal descarga=BigDecimal.ZERO;
		BigDecimal peage=BigDecimal.ZERO;
		BigDecimal recupEvidencia=BigDecimal.ZERO;
		BigDecimal recoleccion=BigDecimal.ZERO;
		
		BigDecimal fleteDescuento=BigDecimal.ZERO;
		BigDecimal subtotalDescuento=BigDecimal.ZERO;
		
		
		BigDecimal subtotal=BigDecimal.ZERO;
		BigDecimal iva=BigDecimal.ZERO;
		BigDecimal total=BigDecimal.ZERO;
		BigDecimal retencion=BigDecimal.ZERO;
		BigDecimal neto=BigDecimal.ZERO;
		
		BigDecimal base=BigDecimal.ZERO;
		BigDecimal importeFlete=BigDecimal.ZERO;
		
		JsonObject json = new JsonObject();
		 PrintWriter out = null;
		
		switch (opction) {
			case 1:
			flete = BigDecimal.valueOf(Double.parseDouble(request.getParameter("flete"))).setScale(2, RoundingMode.HALF_UP);
			descuento = BigDecimal.valueOf(Double.parseDouble(request.getParameter("descuento"))).setScale(2, RoundingMode.HALF_UP);
			seguro = BigDecimal.valueOf(Double.parseDouble(request.getParameter("seguro"))).setScale(2, RoundingMode.HALF_UP);
			carga = BigDecimal.valueOf(Double.parseDouble(request.getParameter("carga"))).setScale(2, RoundingMode.HALF_UP);
			descarga = BigDecimal.valueOf(Double.parseDouble(request.getParameter("descarga"))).setScale(2, RoundingMode.HALF_UP);
			peage = BigDecimal.valueOf(Double.parseDouble(request.getParameter("peage"))).setScale(2, RoundingMode.HALF_UP);
			recupEvidencia = BigDecimal.valueOf(Double.parseDouble(request.getParameter("recupEvidencia"))).setScale(2, RoundingMode.HALF_UP);
			recoleccion = BigDecimal.valueOf(Double.parseDouble(request.getParameter("recoleccion"))).setScale(2, RoundingMode.HALF_UP);
			System.out.println("flete:"+flete);
			 if(descuento.doubleValue()>0){
				 System.out.println("entra a descuento:");
				 fleteDescuento = fleteDescuento.add(flete.subtract(descuento)).setScale(2, RoundingMode.HALF_UP);
				 subtotal = subtotal.add(flete).add(seguro).add(carga).add(descarga).add(peage).add(recupEvidencia).add(recoleccion).setScale(2, RoundingMode.HALF_UP);					
				 subtotalDescuento= subtotalDescuento.add(flete.subtract(descuento)).add(seguro).add(carga).add(descarga).add(peage).add(recupEvidencia).add(recoleccion).setScale(2, RoundingMode.HALF_UP);
				 
				 iva = subtotalDescuento.multiply(BigDecimal.valueOf(0.16)).setScale(2, RoundingMode.HALF_UP);
				 total = subtotalDescuento.add(iva).setScale(2, RoundingMode.HALF_UP);
				 retencion = fleteDescuento.multiply(BigDecimal.valueOf(0.04)).setScale(2, RoundingMode.HALF_UP);
				 neto = total.subtract(retencion).setScale(2, RoundingMode.HALF_UP);
				 
				 
			 }else {
				 importeFlete =importeFlete.add(flete.multiply(BigDecimal.valueOf(0.16)));
				 subtotal= subtotal.add(flete).add(seguro).add(carga).add(descarga).add(peage).add(recupEvidencia).add(recoleccion).setScale(2, RoundingMode.HALF_UP);
				 iva = subtotal.multiply(BigDecimal.valueOf(0.16)).setScale(2, RoundingMode.HALF_UP);
				 total = subtotal.add(iva).setScale(2, RoundingMode.HALF_UP);
				 retencion = flete.multiply(BigDecimal.valueOf(0.04)).setScale(2, RoundingMode.HALF_UP);
				 neto = total.subtract(retencion).setScale(2, RoundingMode.HALF_UP);			
			 }
			 

			 response.setCharacterEncoding("UTF-8");			 
		     json.addProperty("fleteConDescuento", fleteDescuento);
		     json.addProperty("subtotal", subtotal);
		     json.addProperty("subtotalDescuento", subtotalDescuento);
		     json.addProperty("iva", iva);
		     json.addProperty("total", total);
		     json.addProperty("retencion", retencion);
		     json.addProperty("neto", neto);
		     json.addProperty("TrasladosFlete",flete +" * 0.16"+" = "+importeFlete );
		     
		     
		     try {
				out = response.getWriter();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
				out.println(json.toString());
				out.flush();
				out.close();
			
			break;
			
			case 2:
				System.out.println("entrando");
				flete = BigDecimal.valueOf(Double.parseDouble(request.getParameter("flete"))).setScale(2, RoundingMode.HALF_UP);
				descuento = BigDecimal.valueOf(Double.parseDouble(request.getParameter("descuento"))).setScale(2, RoundingMode.HALF_UP);
				seguro = BigDecimal.valueOf(Double.parseDouble(request.getParameter("seguro"))).setScale(2, RoundingMode.HALF_UP);
				carga = BigDecimal.valueOf(Double.parseDouble(request.getParameter("carga"))).setScale(2, RoundingMode.HALF_UP);
				descarga = BigDecimal.valueOf(Double.parseDouble(request.getParameter("descarga"))).setScale(2, RoundingMode.HALF_UP);
				peage = BigDecimal.valueOf(Double.parseDouble(request.getParameter("peage"))).setScale(2, RoundingMode.HALF_UP);
				recupEvidencia = BigDecimal.valueOf(Double.parseDouble(request.getParameter("recupEvidencia"))).setScale(2, RoundingMode.HALF_UP);
				recoleccion = BigDecimal.valueOf(Double.parseDouble(request.getParameter("recoleccion"))).setScale(2, RoundingMode.HALF_UP);
				System.out.println("valor del flte:"+flete);
				String xml="";
				
				
				//CALCULO DE CONCEPTOS  SOBRE FLETE -TIPO CARTA PORTE INGRESO
				xml = "<cfdi:Conceptos>";
				if (flete.doubleValue() > 0) {	
					xml+="<cfdi:Concepto ClaveProdServ=\"78101802\" NoIdentificacion=\"FLETE\" Cantidad=\"1\" ClaveUnidad=\"E48\" Unidad=\"SERVICIO\" Descripcion=\"FLETE\" ValorUnitario=\""+flete +"\" Importe=\""+flete+"\""; 
					if(descuento.doubleValue()>0){
						xml +=" Descuento=\"" +descuento+"\">";
					}
					else {
						
						xml+=">";
					}
					
					xml +="<cfdi:Impuestos>";
					xml +="<cfdi:Traslados>";
					xml+="<cfdi:Traslado Base=\"";
					if (descuento.doubleValue()>0) {						
						xml += flete.subtract(descuento);
					    base =base.multiply(BigDecimal.valueOf(0.16).setScale(2, RoundingMode.HALF_UP));
					}
					else {
						xml += flete;
					}
					xml +="\" Impuesto=\"002\" TipoFactor=\"Tasa\" TasaOCuota=\"0.160000\"";
					xml += "Importe=\"";
					xml+="";
					
					xml+="</cfdi:Traslados>";
					
					
					
					xml+="</cfdi:Impuestos>";
					
					
					xml+="</cfdi:Concepto>";	
				}
				if (seguro.doubleValue() > 0) {
								}				
				if(carga.doubleValue() > 0) {					
								}
				if (descarga.doubleValue() > 0) {
								}
				if (recupEvidencia.doubleValue() > 0){
									}
				if (peage.doubleValue() > 0){					
							}
				if (recoleccion.doubleValue() > 0){
					
					
				}
				 response.setCharacterEncoding("UTF-8");
				 
			    
			     json.addProperty("xml", xml);
			     
			     
			     try {
					out = response.getWriter();
				} catch (IOException e) {
				
					e.printStackTrace();
				}
					out.println(json.toString());
					out.flush();
					out.close();
				
				
				
//				xml +=EnumXmlIngreso.XML_CFDI_CONCEPTOS_CIERRE.getXml();
//				
//				impuestos.setTotalRetenidos(impuestosRetenidos);
//				impuestos.setTotalTrasladados(impuestosTrasladados);
//				
//				totalImpuestosRetenidos.setImpuesto(EnumXmlIngreso.IMPUESTO.getXml());
//				totalImpuestosRetenidos.setImporte(impuestosRetenidos);
//				impuestos.setTotalImpuestosRetenidos(totalImpuestosRetenidos);
//				
//				totalImpuestosTrasladados.setImpuesto(EnumXmlIngreso.IMPUESTO.getXml());
//				totalImpuestosTrasladados.setTipoFactor(EnumXmlIngreso.TIPOFACTOR.getXml());
//				totalImpuestosTrasladados.setTasaOCuota(EnumXmlIngreso.TASAOCUOTA_016.getXml());
//				totalImpuestosTrasladados.setImporte(impuestosTrasladados);			
//				impuestos.setTotalImpuestosTrasladados(totalImpuestosTrasladados);
//				impuestosTotales.setImpuestos(impuestos);
//				//TOTALES
//				xml +=cadenaImpuestosTotales(impuestosTotales);
				
				
				
				
				
				
			break;
			
			case 3:
				
				System.out.println("entro a 3");
				break;
	
		}
		
		
		
		
		return true;
	}
	
	
	
	
	

}
