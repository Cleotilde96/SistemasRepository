function ViewBusqueda(){
	
	$.ajax({
					dataType : "html",//Tipo de conversión
					type : "POST",//Método de envio						
				    url:"/Sistemas/Controlador?obj=Buscar&page=Vista/CartaPorte/Busqueda/Busqueda.jsp",
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








function listado(){
	
	var view=false;
	var valorBusqueda=-1;
	var fechaBusqueda="";
	var valueSearch=-1;
		
	valueSearch=opctionseleccion();
	
	
	if(valueSearch == 1 || valueSearch == 2 || valueSearch== 4 ){
		
		valorBusqueda=$("#txtBusqueda").val();
		
		if(valorBusqueda ==null || valorBusqueda==""){
			alert("Ingresa el valor a buscar");
		}
		else{
			view=true;
			
		}	
		
		
	}
	else if(valueSearch==3){
		fechaBusqueda=$("#dtFecha").val();
		
		if(fechaBusqueda ==null || fechaBusqueda==""){
			alert("Ingresa la fecha a buscar");
		}
		else{
			view=true;
		}	
	}
	
	
	if(view){
		
	$.ajax({
				dataType : "html",//Tipo de conversión
				type : "POST",//Método de envio
				//url:"/Sistemas/Controlador?obj=Buscar&page=Vista/CartaPorte/Busqueda/Busqueda.jsp",
				url : "/Sistemas/Controlador?obj=searchCartaPorte&page=Vista/CartaPorte/Busqueda/Listado.jsp",
				data : {
					valorBusqueda:valorBusqueda,
					fechaBusqueda:fechaBusqueda,
					valueSearch:valueSearch,
					opction:1
				},
				beforeSend : function(data) {
				},
				success : function(requestData) { 		

					 try {
       					var jsonData= JSON.parse(requestData);
						
							if(jsonData.msjError != null && jsonData.msjError !=""){

							$("#dverror").html("<div class='alert alert-warning alert-dismissible fade show' role='alert'><strong>WARNING!!</strong>"+jsonData.msjError+ "<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>");
							
							}
							
							
   					 } catch(e) {
       							
							$("#dvsearch").html(requestData);
					
						
    				}
					
		
				},
				error : function(requestData, strError, strTipoError) {
					alert("Error " + strTipoError + ': ' + strError); 
				}
				
				
				
			});	
			
			
			
	
	}	
}


function opctionseleccion(){
	
//	var seleccion=$("slBusqueda").val();
	var seleccion = document.getElementById("slBusqueda").value;
	

//$("#dtFecha").hide();
//$("#dtFecha").show();
	if(seleccion ==1){
		
		$("#txtBusqueda").show();
		$("#dtFecha").hide();		
	}
	else if(seleccion==2){
	
		$("#txtBusqueda").show();
		$("#dtFecha").hide();	
	}
	else if(seleccion==3){
		
		$("#txtBusqueda").hide();
		$("#dtFecha").show();	
	}
	else if(seleccion==4){
	
		$("#txtBusqueda").show();
		$("#dtFecha").hide();			
	}
	
	return seleccion;
	
	
}


function detalleDocumento(idCartaPorte){
	
	
	 $
			.ajax({
				dataType : "html",//Tipo de conversión
				type : "POST",//Método de envio
				//url: "/PerliExpressWeb/menu/Facturacion/InformesTalones/CartaPorte/Busqueda/DetalleDocumento.jsp",			
				url: "/Sistemas/Controlador?obj=searchCartaPorte&page=Vista/CartaPorte/Busqueda/DetalleDocumento.jsp",
				data :{
					idCartaPorte:idCartaPorte,
					opction:2
					},
				beforeSend : function(data) {
				},
				success : function(requestData) { 			

						
							//'title': "Detalles del documento",
						
						
							$("#dvsearch").html(requestData);
					
						

				},
				error : function(requestData, strError, strTipoError) {
					alert("Error " + strTipoError + ': ' + strError); 
				}
			});
	
}


function ViewArchivo(idCartaPorte,tipoArchivo){
	
	$
			.ajax({
				dataType : "html",//Tipo de conversión
				type : "POST",//Método de envio
				//url: "/PerliExpressWeb/menu/Facturacion/InformesTalones/CartaPorte/Busqueda/PdfView.jsp",			
				url: "/Sistemas/Controlador?obj=searchCartaPorte&page=Vista/CartaPorte/Busqueda/DetalleDocumento.jsp",
				data :{
						idCartaPorte:idCartaPorte,
						tipoArchivo:tipoArchivo,
						opction:3	
					},
				beforeSend : function(data) {
				},
				success : function(requestData) { 			

						var jsonData= JSON.parse(requestData);
			
						if(!jsonData.rutaFile =="" || !jsonData.rutaFile==null){
	
						//var ip = location.host;
						var ip;
						ip="perliexp:8080";
					    if(ip=="perliexp:8080"){
					    	window.open("http://192.168.1.132:280/"+jsonData.rutaFile);	
			 	
					    }else if(ip=="perli-pc2:8080") 
					    {				    						    	
								window.open("http://192.168.1.56:80/"+jsonData.rutaFile);	
					    }
						else if(ip=="perliexpress.ddns.net:8080"){
							window.open("http://perliexpress.ddns.net:281/"+jsonData.rutaFile);
						}
						else if(ip="localhost:8086"){
								
								window.open("http://192.168.1.1:90/"+jsonData.rutaFile);	
						}
					    else{
					    	infoAlert("Error de impresión","No se logró visualizar documento ");
					    }
	
					}
					else{
						infoAlert("Error de impresión","No se logró visualizar documento ");
					}
						

				},
				error : function(requestData, strError, strTipoError) {
					alert("Error " + strTipoError + ': ' + strError); 
				}
			});
	
	
}




function ejecutar(){
	
	//var empleadoJson= { "empleadoRequest": [ { "nombre": "pruebasqwqw", "apellido1": "appp", "apellido2": "rejkerj" } ] };
	
	var jsonData={		
        "serie": $("#txtSerie").val(),
    "id":$("#txtId").val(),
    "xml":$("#txtXml").val()		
	 };
	
	$
			.ajax({
				dataType : "json",//Tipo de conversión
				type : "POST",//Método de envio
				//url: "/PerliExpressWeb/menu/Facturacion/InformesTalones/CartaPorte/Busqueda/PdfView.jsp",			
				//url: "http://localhost:8087/api/agregar",
				url:"http://192.168.1.1:8085/TimbradoCfdi/api/timbrar",
				//data :JSON.stringify(empleadoJson),
				data :JSON.stringify(jsonData),
				
				contentType: "application/json; charset=utf-8",
				beforeSend : function(data) {
					$("#dvbanner").html("Realizando petición........")
				},
				success : function(requestData) { 
					var jsonData= JSON.stringify(requestData);
					$("#dvbanner").html("");
			    		if(requestData.exito){
							alert(requestData.mensaje);
						}
						else{
							alert(requestData.mensaje);
						}
	
						//console.log("jsonData:"+requestData.idEmpleados);
							
                 },
				
				error : function(requestData, strError, strTipoError) {
					alert("Error " + strTipoError + ': ' + strError); 
				}
			});
	
}



function ViewFrmTimbrado(){
	
	$.ajax({
		dataType : "html",//Tipo de conversión
		type : "POST",//Método de envio		
		//C:\Eclipse\Sistemas\WebContent\Vista\CartaPorte\Timbrado\FrmPeticion.jsp
		url: "/Sistemas/Vista/CartaPorte/Timbrado/FrmPeticion.jsp",					
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










