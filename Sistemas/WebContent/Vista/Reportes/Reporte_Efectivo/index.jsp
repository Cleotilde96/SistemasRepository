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
<body>
<br>
<div class="alert alert-danger" role="alert">
  PERLIEXP
</div>
  

<div align="center">

  <label for="example-date-input" >FECHA:</label>
 
    <input  type="date" value="2020-12-28" id="example-date-input">
<button type="button" class="btn btn-success" onclick="cargaReporte();">Ver Facturas</button>
</div>
<br>



<div id="dvdiario" ></div>


</body>
</html>