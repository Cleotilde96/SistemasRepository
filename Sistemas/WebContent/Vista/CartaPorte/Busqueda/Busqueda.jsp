<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Busqueda Carta Porte</title>
<script type="text/javascript">
$("#dtFecha").hide();
//$("#dtFecha").show();


</script>



</head>
<body>
<div class="alert alert-danger" role="alert">
  PERLIEXP
</div>

<span class="badge badge-primary">Buscar Carta Porte</span>
<br>
<div class="input-group">
  <select class="custom-select" id="slBusqueda" onchange="opctionseleccion();">
  <option selected value="1">Folio Carta Porte</option>
  <option value="2">Folio Nota</option>
  <option value="3" disabled="disabled">Fecha Carta Porte</option>
  <option value="4">Numero Informe</option> 
</select>
  <input type="text" class="form-control" maxlength="10" id="txtBusqueda" onkeypress="return soloNumeros(event)" onkeyup ="if(event.keyCode == 13) listado()">
  <input type="date" class="form-control" id="dtFecha">
  
  <button type="button" id="btnsearch" class="btn btn-dark btn-sm active" title="Buscar Carta Porte"  onclick="listado();">Buscar</button>
</div>
<br>
<div id="dvsuccess"></div>
<div id="dverror"></div>

<br>
<div id="dvsearch" class="container">

</div>




 
</body>
</html>