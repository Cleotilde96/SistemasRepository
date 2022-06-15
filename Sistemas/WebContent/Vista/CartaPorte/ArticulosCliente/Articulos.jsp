<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Articulos Clientes</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>

</head>
<body>
<div class="alert alert-danger" role="alert">
  PERLIEXP
</div>
  
	<!-- Button trigger modal -->
	<button type="button" class="btn btn-primary" data-bs-toggle="modal"
		data-bs-target="#exampleModal">Cliente</button>

	<button type="button" class="btn btn-warning"
		onclick="clientesArticulos();">Tabla Clientes</button>

	<br>
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Cliente</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">

					<div class="input-group col-md-4">
						<div class="input-group-prepend">
							<span class="input-group-text" id="">ID Cliente</span>
						</div>
						<input type="text" class="form-control" id="txtIdClient" onkeyup="if(event.keyCode == 13) consultarClientes();"> 
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-text">Nombre</span> <input type="text"
							aria-label="First name" class="form-control" id="txtNombre"
							onkeyup="if(event.keyCode == 13) consultarClientes();"> <span
							class="input-group-text">Apellido 1</span> <input type="text"
							aria-label="Last name" class="form-control" id="txtApellido1"
							onkeyup="if(event.keyCode == 13) consultarClientes();"> <span
							class="input-group-text">Apellido 2</span> <input type="text"
							aria-label="Last name" class="form-control" id="txtApellido2"
							onkeyup="if(event.keyCode == 13) consultarClientes();">
					</div>



					<br>


					<div align="center">
						<button type="button" class="btn btn-primary"
							onclick="consultarClientes();">Buscar</button>
						<button type="button" class="btn btn-warning"
							onclick="limpiarCampos();">Limpiar campos</button>
					</div>


					<br>
					<div id="contenido">
						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">Nombre</th>
									<th scope="col">RFC</th>
									<th scope="col">CALLE</th>
									<th scope="col">LOCALIDAD</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row"></th>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</tbody>
						</table>
					</div>

				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>





	<br>

	<div class="row g-3 needs-validation" >

		<div class="form-group col-md-2">
			<label for="inputZip">#</label> <input type="text"
				class="form-control" id="txtnumcliente" disabled value="-1"
				style="color: blue;">
		</div>
		<div class="form-group col-md-6">
			<label for="inputCity">Nombre</label> <input type="text"
				class="form-control" id="txtNombreC" disabled style="color: blue;">
		</div>

		<div class="col-md-6">
			<label for="validationCustom04" class="form-label">Tipo
				Articulo:</label> <select class="form-select" id="slArticulos" required>
				<c:forEach var="datos" items="${listArticulos}">
					<option value="${datos.idClaveUnidadPeso}" style="color: blue;">${datos.descripUnidad}</option>
				</c:forEach>
			</select>

		</div>
		<div class="col-md-6">
			<label for="validationCustom04" class="form-label">Clave:</label>
			<div class="input-group md-6">
				<input type="text" class="form-control" placeholder="10111300"
					id="txtClaveProd" maxlength="8"
					onkeypress="return soloNumeros(event)"
					onkeyup="if(event.keyCode == 13) buscarClaveProducto();">
				<button class="btn btn-outline-secondary" type="button"
					id="button-addon2" onclick="buscarClaveProducto();">Buscar</button>
			</div>
		</div>
		<input type="hidden" id="hdIdClaveProv" value="-1">

		<div class="col-md-6">
			<label for="validationCustom03" class="form-label">Descripcion</label>
			<input type="text" class="form-control" id="txtDescripProd" disabled
				style="color: blue;">
		</div>

		<div class="col-md-2">
			<label for="validationCustom03" class="form-label">ID
				Empleado Alta</label> <input type="text" class="form-control"
				id="txtIdEmpleadoA" value="-1">
		</div>
		<div class="col-12">
			<button class="btn btn-primary" onclick="saveArticuloCliente();">Agregar</button>
			<button class="btn btn-danger" onclick="generaQuery();">Generar
				Query</button>
			<button class="btn btn-warning" onclick="limpiarQuery();">Limpiar
				Query</button>
		</div>


		<div class="col-12">

			<label for="exampleFormControlTextarea1">Query</label>
			<textarea class="form-control" id="txtQuery" rows="3"></textarea>
		</div>
	</div>


</body>
</html>