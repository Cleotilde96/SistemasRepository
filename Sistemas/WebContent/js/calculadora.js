function viewcalculadora(){
	
		$.ajax({
					dataType : "html",//Tipo de conversión
					type : "POST",//Método de envio		
					///Sistemas/WebContent/Vista/CartaPorte/Calculadora/Calculadora.jsp				
				    url:"/Sistemas/Vista/CartaPorte/Calculadora/calcular.jsp",
					data : {},
					beforeSend : function(data) {
					},
					success : function(requestData) { //Llamada exitosa											
						$("#carga").html(requestData);
					},
					error : function(requestData, strError, strTipoError) {
						alert("Error " + strTipoError + ': ' + strError); //En caso de error mostraremos un alert
					}
				});	
	
}

function calcularFlete(){
	var flete=$("#txtflete").val();
	var descuento=$("#txtdescuento").val();
	var seguro=$("#txtseguro").val();
	var carga=$("#txtcarga").val();
	var descarga=$("#txtdescarga").val();
	var peage=$("#txtpeage").val();
	var recupEvidencia=$("#txtrecupEvidencia").val();
	var recoleccion=$("#txtrecoleccion").val();
	
	if(flete=="" || flete==null){
		flete =0.00;
	} 	
	if(descuento=="" || descuento==null){
		
		descuento =0.00;
	} 
	if(seguro=="" || seguro==null){
		seguro =0.00;
	} 
	if(carga=="" || carga==null){
		carga=0.00;
	} 
	if(descarga=="" || descarga==null){
		descarga=0.00;
	} 
	if(peage=="" || peage ==null){
		peage=0.00;
	} 
	if(recupEvidencia=="" || recupEvidencia==null){
		recupEvidencia=0.00;
	} 
	if(recoleccion=="" || recoleccion ==null){
		
		recoleccion=0.00;
		
	}
	
	
	
	$.ajax({
					dataType : "html",//Tipo de conversión
					type : "POST",//Método de envio		
					///Sistemas/WebContent/Vista/CartaPorte/Calculadora/Calculadora.jsp	
					url: "/Sistemas/Controlador?obj=calcularFlete&page=Vista/CartaPorte/Calculadora/calcular.jsp",
							
				    //url:"/Sistemas/Vista/CartaPorte/Calculadora/calcular.jsp",
					data : 
					{
					flete:flete,
					descuento:descuento,
					seguro:seguro,
					carga:carga,
					descarga:descarga,
					peage:peage,
					recupEvidencia:recupEvidencia,
					recoleccion:recoleccion,											
					opction:1	
					},
					beforeSend : function(data) {
					},
					success : function(requestData) { //Llamada exitosa	
						console.log("requets:"+requestData)									
						var jsonData= JSON.parse(requestData);
						
						$("#txtFleteDescuento").val(jsonData.fleteConDescuento.toFixed(2));
						$("#txtSubtotal").val(jsonData.subtotal.toFixed(2));
						$("#txtSubtotalDesc").val(jsonData.subtotalDescuento.toFixed(2));
						$("#txtIva").val(jsonData.iva.toFixed(2));
						
						$("#txtTotal").val(jsonData.total.toFixed(2));
						$("#txtRetencion").val(jsonData.retencion.toFixed(2));
						$("#txtNeto").val(jsonData.neto.toFixed(2));
						$("#lblTrasladosFlete").html(jsonData.TrasladosFlete);

							
					},
					error : function(requestData, strError, strTipoError) {
						alert("Error " + strTipoError + ': ' + strError); //En caso de error mostraremos un alert
					}
				});	
	
	
}

function xmlConceptos(){
	
	var flete=$("#txtflete").val();
	var descuento=$("#txtdescuento").val();
	var seguro=$("#txtseguro").val();
	var carga=$("#txtcarga").val();
	var descarga=$("#txtdescarga").val();
	var peage=$("#txtpeage").val();
	var recupEvidencia=$("#txtrecupEvidencia").val();
	var recoleccion=$("#txtrecoleccion").val();
	
	var fleteDescuento=	$("#txtFleteDescuento").val();
	var subtotal=$("#txtSubtotal").val();
	var subtotalDesc=$("#txtSubtotalDesc").val();
	var iva=$("#txtIva").val();
	var total = $("#txtTotal").val();				
	var retencion =$("#txtRetencion").val();				
    var neto = $("#txtNeto").val();	
	
		if(flete=="" || flete==null){
		flete =0.00;
	} 	
	if(descuento=="" || descuento==null){
		
		descuento =0.00;
	} 
	if(seguro=="" || seguro==null){
		seguro =0.00;
	} 
	if(carga=="" || carga==null){
		carga=0.00;
	} 
	if(descarga=="" || descarga==null){
		descarga=0.00;
	} 
	if(peage=="" || peage ==null){
		peage=0.00;
	} 
	if(recupEvidencia=="" || recupEvidencia==null){
		recupEvidencia=0.00;
	} 
	if(recoleccion=="" || recoleccion ==null){
		
		recoleccion=0.00;
		
	}
	if(fleteDescuento =="" || fleteDescuento==null){
		fleteDescuento=0.00;
	}
	
	if(subtotal =="" || subtotal==null){
		subtotal=0.00;
	}
	if(subtotalDesc =="" || subtotalDesc==null){
		subtotalDesc=0.00;
	}
	
	if(iva=="" || iva==null){
		iva=0.00;
	}
	if(total=="" || total==null){
		total=0.00;
	}
	if(retencion=="" || retencion==null){
		retencion=0.00;
	}
	if(neto=="" || neto==null){
		neto=0.00;
	}
	
	$.ajax({
					dataType : "html",//Tipo de conversión
					type : "POST",//Método de envio	
					url: "/Sistemas/Controlador?obj=calcularFlete&page=Vista/CartaPorte/Calculadora/calcular.jsp",
					data : 
					{
					flete:flete,
					descuento:descuento,
					seguro:seguro,
					carga:carga,
					descarga:descarga,
					peage:peage,
					recupEvidencia:recupEvidencia,
					recoleccion:recoleccion,
					fleteDescuento,
					subtotal:subtotal,
					subtotalDesc:subtotalDesc,
					iva:iva,
					total:total,
					retencion:retencion,
					neto:neto,																
					opction:2	
					},
					beforeSend : function(data) {
					},
					success : function(requestData) { //Llamada exitosa	
						console.log("requets:"+requestData)									
						var jsonData= JSON.parse(requestData);
						
						alert(jsonData.xml);
							
					},
					error : function(requestData, strError, strTipoError) {
						alert("Error " + strTipoError + ': ' + strError); //En caso de error mostraremos un alert
					}
				});	
	
	
	
}
