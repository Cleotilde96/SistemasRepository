<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carta Porte</title>
</head>
<body>
	<div class="container">
		<div class="row g-2">
			<div class="col-6">
				<span class="badge badge-pill badge-success">Clientes</span>
				<div class="p-3 border bg-light">
					
					<div class="btn-group" role="group"
						aria-label="Basic mixed styles example">
						<button type="button" class="btn btn-warning" onclick="viewClavesProducto()">Agregar Clave Producto</button>
						<button type="button" class="btn btn-warning" onclick="addArticulosClientes()">Agregar Articulos</button>
						<button type="button" class="btn btn-warning" onclick="clientesArticulos()">Clientes Articulos</button>
					</div>


				</div>
			</div>
			<div class="col-6">
			<span class="badge badge-pill badge-success">Búsqueda</span>
				<div class="p-3 border bg-light">
				
					<div class="btn-group" role="group"
						aria-label="Basic mixed styles example">
						<button type="button" class="btn btn-warning" onclick="ViewBusqueda();">Realiza Búsqueda</button>
 						<button type="button" class="btn btn-warning" onclick="ejecutar();">ejecutar</button> 
					</div>
				
				
				</div>
			</div>
<!-- 			<div class="col-6"> -->
<!-- 			<span class="badge badge-pill badge-success">Calculadora</span> -->
<!-- 				<div class="p-3 border bg-light"> -->
				
<!-- 				<div class="btn-group" role="group" -->
<!-- 						aria-label="Basic mixed styles example"> -->
<!-- 						<button type="button" class="btn btn-warning" onclick="viewcalculadora();">Realizar calculo</button> -->
						
<!-- 					</div> -->
				
<!-- 				</div> -->
<!-- 			</div> -->
			<div class="col-6">
			<span class="badge badge-pill badge-success">Timbrado</span>
				<div class="p-3 border bg-light">
				
					<div class="btn-group" role="group"
						aria-label="Basic mixed styles example">
						<button type="button" class="btn btn-warning" onclick="ViewFrmTimbrado();">Realiza Petición</button>
 						
					</div>
				
				
				</div>
			</div>
		</div>
	</div>
</body>
</html>