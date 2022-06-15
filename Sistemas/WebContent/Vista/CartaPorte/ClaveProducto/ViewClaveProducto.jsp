<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Catálogo de productos y servicios carta porte</title>
</head>
<body>
	<h3>Catálogo de productos y servicios carta porte</h3>
	<br>
	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<button class="btn btn-outline-secondary dropdown-toggle"
				type="button">Clave Producto</button>
		</div>
		<input type="text" class="form-control"
			aria-label="Text input with dropdown button" id="txtclaveproducto"
			title="Codigo a 8 digitos" maxlength="8" onkeyup="if(event.keyCode == 13) searchClavesProducto();">
			<button type="button" class="btn btn-primary" onclick="addClavesProducto()">Agregar</button>
	</div>

<div id="dvTablaClaves" class="container"></div>
	
</body>
</html>