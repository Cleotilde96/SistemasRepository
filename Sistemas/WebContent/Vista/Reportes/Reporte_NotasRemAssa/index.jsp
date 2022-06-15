<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>inicio</title>
<script type="text/javascript" src="/Sistemas/js/metodos.js"></script>
<link rel="stylesheet"
	href="/Sistemas/bootstrap/css/bootstrap.min.css">
	<script type="text/javascript"
	src="/Sistemas/bootstrap/js/jquery.js"></script>

	
</head>
<body onload="fecha();">
NOTAS REMISION
<br>
<div class="form-group" align="center">
  <label for="example-date-input" class="col-2 col-form-label">FECHA:</label>
  <div class="col-10">
    <input  type="date"  id="fecha1">
  </div>
</div>
<div align="center">
<button type="button" class="btn btn-success" onclick="cargaReporte();">Ver Facturas</button>
</div>
</body>
</html>