<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>inicio</title>

<link rel="stylesheet"
	href="/Sistemas/bootstrap/css/bootstrap.min.css">
	<script type="text/javascript"
	src="/Sistemas/bootstrap/js/jquery.js"></script>
</head>
<body>
<br>
<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
  
    <li class="breadcrumb-item"><a href="javascript:CargaMenu(1)">Reporte Efectivo Diario</a></li>
    <li class="breadcrumb-item"><a href="javascript:CargaMenu(2)">Nota Remision Assa</a></li>
    
  </ol>
</nav>

<div class="container-sm border" id="carga"> </div>

<button onclick="api()">boton</button>

</body>
</html>