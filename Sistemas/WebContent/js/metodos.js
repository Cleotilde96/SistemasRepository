




function Agregaruser(valorUser){

	$.ajax({
		dataType : "html",//Tipo de conversión
		type : "POST",//Método de envio
		url : "/Sistemas/controlador?obj=agregarUser&page=Vista/PermisosWeb/Consultas/ConsultaTabla.jsp",
		data : "usuario=" + valorUser,
		beforeSend : function(data) {
		},
		success : function(requestData) { //Llamada exitosa	
			$("#agregados").html(requestData);	
		},
		error : function(requestData, strError, strTipoError) {
			alert("Error " + strTipoError + ': ' + strError); //En caso de error mostraremos un alert
		}
	});	
	
	
}


function MenuPrincipal(){
	var combo = document.getElementById("Menu").value;

	$
	.ajax({
		dataType : "html",//Tipo de conversión
		type : "POST",//Método de envio
		url : "/Sistemas/controlador?obj=ConsultaSubmenu&page=Vista/PermisosWeb/Consultas/ConsultaTabla.jsp",
		data : "menu=" + combo ,
		beforeSend : function(data) {
		},
		success : function(requestData) { //Llamada exitosa											
					$("#carga").html(requestData);	
		},
		error : function(requestData, strError, strTipoError) {
			alert("Error " + strTipoError + ': ' + strError); //En caso de error mostraremos un alert
		}
	});	

	alert("valor:"+ combo );
}



function hola1(){
	//Manda llamar a un servlet
	$
			.ajax({
				dataType : "html",//Tipo de conversión
				type : "POST",//Método de envio
				url : "/Sistemas/controlador?obj=consultaUsers&page=Vista/PermisosWeb/Consultas/ConsultaTabla.jsp",
				//url : "/Sistemas/Vista/Administracion/Registros/ConsultaTabla.jsp",
				
				//data : "usuario=" + usuario + "&empleado="+empleado,
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
function cargaPantalla(){
	
	//Manda llamar a un servlet
	$
			.ajax({
				dataType : "html",//Tipo de conversión
				type : "POST",//Método de envio
				url : "/Sistemas/controlador?obj=consultaUsers&page=Vista/PermisosWeb/Consultas/ConsultaTabla.jsp",
				//url : "/Sistemas/Vista/Administracion/Registros/ConsultaTabla.jsp",
				
				//data : "usuario=" + usuario + "&empleado="+empleado,
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

function pruebas(){
	
	//Manda llamar a un servlet
	$
			.ajax({
				dataType : "html",//Tipo de conversión
				type : "POST",//Método de envio
				url : "/Sistemas/controlador?obj=tbl&page=Vista/PermisosWeb/Consultas/ConsultaTabla.jsp",
				//url : "/Sistemas/Vista/Administracion/Registros/ConsultaTabla.jsp",
				
				//data : "usuario=" + usuario + "&empleado="+empleado,
				beforeSend : function(data) {
				},
				success : function(requestData) { //Llamada exitosa											
					$("#carga").html(requestData);
					//alert(requestData);
				},
				error : function(requestData, strError, strTipoError) {
					alert("Error " + strTipoError + ': ' + strError); //En caso de error mostraremos un alert
				}
			});	
}

function cargaReporte(){
	var fecha = document.getElementById("example-date-input").value;
	console.log("fecha:"+fecha);
	//Manda llamar a un servlet
	$
			.ajax({
				dataType : "html",//Tipo de conversión
				type : "POST",//Método de envio Reportes
				url : "/Sistemas/Controlador?obj=ReporteEfectivo&page=Vista/Reportes/Reporte_Efectivo/ConsultaTabla.jsp",
				data : "fecha=" + fecha,
				beforeSend : function(data) {
				},
				success : function(requestData) { //Llamada exitosa											
					$("#dvdiario").html("<div class='container-xxl>'" +requestData +"</div>");	
			
				},
				error : function(requestData, strError, strTipoError) {
					alert("Error " + strTipoError + ': ' + strError); //En caso de error mostraremos un alert
				}
			});	
	
		
}

function descargaExcel(){
	 window.open("/Sistemas/controlador?obj=decargaReporteD&page=Vista/Reportes/Reporte_Efectivo/DescargaXLS.jsp");
}



function idusers(valor){
	var valor=document.getElementById('check'+valor).value;
	if(valor.checked){
		alert("valor del check:"+ valor);
	}
	
function selecionar(tr,valor){
	console.log("valor:"+valor);
	$(function(){
		if($("#check"+valor).attr("checked") == "checked"){
			$("#check"+valor).removeAttr("checked");
			$(tr).css("background-color","#FFFFFF");
		}
		else{
			$("#check"+valor).attr("checked", "true");
		$("#check"+valor).prop("checked","true");
		$(tr).css("background-color","#BEDAE8")
		
		}
	})
}



	
}

function MenuPermiso(){

	//Manda llamar a un servlet
	$
			.ajax({
				dataType : "html",//Tipo de conversión
				type : "POST",//Método de envio Reportes
				//Vista\PermisosWeb\Permisos\Menu\MenuPrincipal.jsp
				url : "/Sistemas/controlador?obj=MenuPermiso&page=Vista/PermisosWeb/Permisos/Menu/MenuPrincipal.jsp",
			
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

function copiar(valor)
{
	//var l="N'["||Reporte Rep+","javascript:entrando_frame(''+"../menu/Contabilidad/ReporteRep/WindowLoad.jsp'',''Cargando.....'',3);","", "", "", "frmSet", "", "1", "", "", "", +"]"+",'";
	var nombrePermiso="",rutaJsp="";
	var tipoPermiso =document.getElementById("sltipoPermiso").value;
	
	if(valor ==1){
		nombrePermiso=document.getElementById("txtnombre").value;
		rutaJsp=document.getElementById("txtjsp").value;
		
	}
	else if(valor ==2){
		nombrePermiso=document.getElementById("txtnombre").value;
		rutaJsp=document.getElementById("txtjsp").value;

	}
	//var ligaCadena="N'[||"+nombrePermiso;
	//document.getElementById("liga").value=ligaCadena;
	
	
	//Manda llamar a un servlet
	$
			.ajax({
				dataType : "html",//Tipo de conversión
				type : "POST",//Método de envio Reportes
				//Vista\PermisosWeb\Permisos\Menu\MenuPrincipal.jsp
				url : "/Sistemas/controlador?obj=FormarPermiso&page=Vista/PermisosWeb/Permisos/Menu/MenuPrincipal.jsp",
				data: "nombrePermiso="+nombrePermiso +"&rutaJsp="+rutaJsp+"&tipoPermiso="+tipoPermiso,
				beforeSend : function(data) {
				},
				success : function(requestData) { //Llamada exitosa											
					$("#lblliga").html(requestData);	
					
				},
				error : function(requestData, strError, strTipoError) {
					alert("Error " + strTipoError + ': ' + strError); //En caso de error mostraremos un alert
				}
			});	
	
	
}



function Cargacontenido(opction){
	

	
			if(opction == 1){
				page="/Vista/Page.jsp";
				obj="inicio";
				
			}
			else if(opction ==2){
				
				page="Vista/CartaPorte/MenuControl/Menu.jsp";
				obj="cartaPorte";
			}
			else if(opction ==3){
				page="Vista/Reportes/MenuControl/Menu.jsp";
				obj="Reportes";
			}
			
			
			//Manda llamar a un servlet
	      $
			.ajax({
				dataType : "html",//Tipo de conversión
				type : "POST",//Método de envio Reportes
				//Vista\PermisosWeb\Permisos\Menu\MenuPrincipal.jsp
				//url : "/Sistemas/Modelo/Controlador?obj=cartaPorte&page=Vista/CartaPorte/MenuControl/Menu.jsp",
				url:"/Sistemas/Controlador?obj="+obj+"&page="+page,
				data: {},
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


function articulos(){

	$.ajax({
		dataType : "html",//Tipo de conversión
		type : "POST",//Método de envio
		url : "/Sistemas/Vista/CartaPorte/ArticulosCliente/TablaArticulos.jsp",
		//data : "usuario=" + valorUser,
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


function addArticulosCliente(){

	$.ajax({
		dataType : "html",//Tipo de conversión
		type : "POST",//Método de envio
		url : "/Sistemas/Vista/CartaPorte/ArticulosCliente/Articulos.jsp",
		//data : "usuario=" + valorUser,
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





function ReporteEDiario(){
	
	//Manda llamar a un servlet
	$
			.ajax({
				dataType : "html",//Tipo de conversión
				type : "POST",//Método de envio
				//Sistemas\WebContent\Vista\Reportes\Reporte_Efectivo\index.jsp
				url : "/Sistemas/Vista/Reportes/Reporte_Efectivo/index.jsp",
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

function ReporteNotasRemAssa(){
	
	//Manda llamar a un servlet
	$
			.ajax({
				dataType : "html",//Tipo de conversión
				type : "POST",//Método de envio
				url : "/Sistemas/Vista/Reportes/Reporte_NotasRemAssa/index.jsp",
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



function CargaMenu(numeroContenido){
	if(numeroContenido ==1){
		ReporteEDiario();
	}
	else if(numeroContenido ==2){
		ReporteNotasRemAssa();
	}
	else if(numeroContenido ==3){
		
	}

}

function fecha(){
	alert("sasasas");
	var fecha = new Date(); //Fecha actual
	  var mes = fecha.getMonth()+1; //obteniendo mes
	  var dia = fecha.getDate(); //obteniendo dia
	  var ano = fecha.getFullYear(); //obteniendo año
	  if(dia<10)
	    dia='0'+dia; //agrega cero si el menor de 10
	  if(mes<10)
	    mes='0'+mes //agrega cero si el menor de 10
	  document.getElementById('fecha1').value=ano+"-"+mes+"-"+dia;
}

function impresion1(){
	 	       $.ajax({
					dataType : "html",//Tipo de conversión
					type : "POST",//Método de envio					
					url : "/Sistemas/Vista/CartaPorte/Impresion/FrmImpresion.jsp",
						
				    //url:"/Sistemas/Controlador?obj=articulosclientes&page=Vista/CartaPorte/ArticulosCliente/Articulos.jsp",
					//url : "/Sistemas/Vista/CartaPorte/ArticulosCliente/Articulos.jsp",					
					data : {opction:2},
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


function realizaImpresion(){
	
	var datos=JSON.stringify({
				    jr_NumeroCartaPorte:$('#jr_NumeroCartaPorte').val(),
					jr_FolioCartaPorte:$('#jr_FolioCartaPorte').val(),
					jr_FolioInternoTalon:$('#jr_FolioInternoTalon').val(),
					jr_NumeroControl:$('#jr_NumeroControl').val(),
					jr_UUID:$('#jr_UUID').val(),
					jr_FechaTimbrado:$('#jr_FechaTimbrado').val(),
					jr_FechaEmision:$('#jr_FechaEmision').val(),
					jr_CertificadoDigital:$('#jr_CertificadoDigital').val(),
					jr_CertificadoSAT:$('#jr_CertificadoSAT').val(),
					jr_NombreClienteF:$('#jr_NombreClienteF').val(),
					jr_RFC_Facturado:$('#jr_RFC_Facturado').val(),
					jr_Direccion_Entrega:$('#jr_Direccion_Entrega').val(),				
					jr_Observaciones:$('#jr_Observaciones').val(),
					jr_MetodoDePago:$('#jr_MetodoDePago').val(),
					jr_UsoCFDI:$('#jr_UsoCFDI').val(),
					jr_FormaDePago:$('#jr_FormaDePago').val(),
					jr_Aseguradora:$('#jr_Aseguradora').val(),
					jr_Poliza:$('#jr_Poliza').val(),
					jr_KmRecorridos:$('#jr_KmRecorridos').val(),
					jr_PlacasTractoCamion:$('#jr_PlacasTractoCamion').val(),
					jr_PlacasRemolque:$('#jr_PlacasRemolque').val(),
					jr_NombreOperador:$('#jr_NombreOperador').val(),
					jr_RFC_Operador:$('#jr_RFC_Operador').val(),
					jr_Licencia:$('#jr_Licencia').val(),
					jr_ClaveConfigVehicular:$('#jr_ClaveConfigVehicular').val(),
					jr_TipoSubRemolque:$('#jr_TipoSubRemolque').val(),
					jr_Subtotal:$('#jr_Subtotal').val(),
					jr_Flete:$('#jr_Flete').val(),
					jr_ImpuestoRet:$('#jr_ImpuestoRet').val(),
					jr_TipoFactorRet:$('#jr_TipoFactorRet').val(),
					jr_TasaRet:$('#jr_TasaRet').val(),
					jr_Iva:$('#jr_Iva').val(),
					jr_Total:$('#jr_Total').val(),
					jr_Retencion:$('#jr_Retencion').val(),
					jr_NetoPagar:$('#jr_NetoPagar').val(),
					jr_CadenaOriginal:$('#jr_CadenaOriginal').val(),
					jr_SelloDigitalCFDI:$('#jr_SelloDigitalCFDI').val(),
					jr_SelloDigitalSAT:$('#jr_SelloDigitalSAT').val(),
					jr_RutaQR:$('#jr_RutaQR').val(),
					jr_Serie:$('#jr_Serie').val(),
					jr_DireccionOrigen:$('#jr_DireccionOrigen').val(),
					jr_LugarExpedicion:$('#jr_LugarExpedicion').val(),
					jr_DireccionOperador:$('#jr_DireccionOperador').val()		
	});
	 
	
	alert("datos:"+datos);
	
}

function cargarJsonData(){
	
	var json= $('#jr_Json').val()
	//alert("json:"+$('#jr_Json').val())
	
	var datos= JSON.parse(json);
					$('#jr_NumeroCartaPorte').val(datos.jr_NumeroCartaPorte);
					$('#jr_FolioCartaPorte').val(datos.jr_FolioCartaPorte);
					$('#jr_FolioInternoTalon').val(datos.jr_FolioInternoTalon);
					$('#jr_NumeroControl').val(datos.jr_NumeroControl);
					$('#jr_UUID').val(datos.jr_UUID);
					$('#jr_FechaTimbrado').val(datos.jr_FechaTimbrado);
					$('#jr_FechaEmision').val(datos.jr_FechaEmision);
					$('#jr_CertificadoDigital').val(datos.jr_CertificadoDigital);
					$('#jr_CertificadoSAT').val(datos.jr_CertificadoSAT);
					$('#jr_NombreClienteF').val(datos.jr_NombreClienteF);
					$('#jr_RFC_Facturado').val(datos.jr_RFC_Facturado);
					$('#jr_Direccion_Entrega').val(datos.jr_Direccion_Entrega);				
					$('#jr_Observaciones').val(datos.jr_Observaciones);
					$('#jr_MetodoDePago').val(datos.jr_MetodoDePago);
					$('#jr_UsoCFDI').val(datos.jr_UsoCFDI);
					$('#jr_FormaDePago').val(datos.jr_FormaDePago);
					$('#jr_Aseguradora').val(datos.jr_Aseguradora);
					$('#jr_Poliza').val(datos.jr_Poliza);
					$('#jr_KmRecorridos').val(datos.jr_KmRecorridos);
					$('#jr_PlacasTractoCamion').val(datos.jr_PlacasTractoCamion);
					$('#jr_PlacasRemolque').val(datos.jr_PlacasRemolque);
					$('#jr_NombreOperador').val(datos.jr_NombreOperador);
					$('#jr_RFC_Operador').val(datos.jr_RFC_Operador);
					$('#jr_Licencia').val(datos.jr_Licencia);
					$('#jr_ClaveConfigVehicular').val(datos.jr_ClaveConfigVehicular);
					$('#jr_TipoSubRemolque').val(datos.jr_TipoSubRemolque);
					$('#jr_Subtotal').val(datos.jr_Subtotal);
					$('#jr_Flete').val(datos.jr_Flete);
					$('#jr_ImpuestoRet').val(datos.jr_ImpuestoRet);
					$('#jr_TipoFactorRet').val(datos.jr_TipoFactorRet);
					$('#jr_TasaRet').val(datos.jr_TasaRet);
					$('#jr_Iva').val(datos.jr_Iva);
					$('#jr_Total').val(datos.jr_Total);
					$('#jr_Retencion').val(datos.jr_Retencion);
					$('#jr_NetoPagar').val(datos.jr_NetoPagar);
					$('#jr_CadenaOriginal').val(datos.jr_CadenaOriginal);
					$('#jr_SelloDigitalCFDI').val(datos.jr_SelloDigitalCFDI);
					$('#jr_SelloDigitalSAT').val(datos.jr_SelloDigitalSAT);
					$('#jr_RutaQR').val(datos.jr_RutaQR);
					$('#jr_Serie').val(datos.jr_Serie);
					$('#jr_DireccionOrigen').val(datos.jr_DireccionOrigen);
					$('#jr_LugarExpedicion').val(datos.jr_LugarExpedicion);
					$('#jr_DireccionOperador').val(datos.jr_DireccionOperador);
	
				
	
	
}


function limpiarCampos(){
	
	$('#jr_NumeroCartaPorte').val('');
}




