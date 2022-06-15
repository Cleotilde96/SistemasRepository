<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Peticion</title>
</head>
<body>
	
	<div id="dvbanner">
	</div>
	
  <div class="form-group">
    <label for="formGroupExampleInput">Serie</label>
    <input type="text" class="form-control" id="txtSerie">
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput2">Id</label>
    <input type="text" class="form-control" id="txtId">
  </div>
 <div class="form-group">
    <label for="formGroupExampleInput2">XML</label>
    <input type="text" class="form-control" id="txtXml">
  </div>	
  
  <button type="button" class="btn btn-success" onclick="ejecutar();">ejecutar</button>
</body>
</html>