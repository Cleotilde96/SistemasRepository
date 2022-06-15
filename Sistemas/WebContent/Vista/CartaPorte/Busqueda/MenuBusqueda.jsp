<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
	<script type="text/javascript"  src="/PerliExpressWeb/js/jstabla/jquery.js"></script>
	<script type="text/javascript" src="/PerliExpressWeb/js/jAlert/jAlert-functions.min.js"></script>
	<script type="text/javascript" src="/PerliExpressWeb/js/jAlert/jAlert.js"></script>
	<script type="text/javascript" src="/PerliExpressWeb/js/jAlert/jAlert.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/PerliExpressWeb/js/jAlert/jAlert.css">
	<link rel="stylesheet" type="text/css" href="/PerliExpressWeb/css/csstabla/jquery.dataTables.css" media="screen" />
	<script type="text/javascript"  src="/PerliExpressWeb/js/jstabla/jquery.dataTables.js"></script>
<link rel="stylesheet" href="/PerliExpressWeb/bootstrap/css/bootstrap.min.css">
<script type="text/javascript"
	src="/PerliExpressWeb/menu/Facturacion/InformesTalones/CartaPorte/JS/Busqueda.js"></script>
<script type="text/javascript">
function searchCartaPorte(){
	
	
	$.ajax({
				dataType : "html",//Tipo de conversión
				type : "POST",//Método de envio
				url : "/PerliExpressWeb/menu/Facturacion/InformesTalones/CartaPorte/Busqueda/Busqueda.jsp",
				//data : "usuario=" + usuario + "&empleado="+empleado,
				beforeSend : function(data) {
				},
				success : function(requestData) { 										
				
						$.jAlert({ 
							'title': "Búsqueda Carta Porte",
							   'size': '50%',
							   'content': '<div id="search" style="overflow: auto;"></div>',
								'class': 'Reporte',
								'theme':'black',
								'backgroundColor':'white'
							 });
						
							$("#search").html(requestData);
							$("#txtBusqueda").focus();
				},
				error : function(requestData, strError, strTipoError) {
					alert("Error " + strTipoError + ': ' + strError); 
				}
			});	

}

</script>

</head>
<body onload="searchCartaPorte()">

</body>
<script type="text/javascript" src="/PerliExpressWeb/bootstrap/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/PerliExpressWeb/bootstrap/js/popper.min.js"></script>
<script type="text/javascript" src="/PerliExpressWeb/bootstrap/js/bootstrap.min.js"></script>
</html>