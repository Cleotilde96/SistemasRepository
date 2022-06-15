<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Articulos</title>
<link rel="stylesheet" type="text/css"
	href="/Sistemas/DataTables/DataTables/css/jquery.dataTables.css"
	media="screen" />
<script type="text/javascript"
	src="/Sistemas/DataTables/DataTables/js/jquery.dataTables.js"></script>


<script>
	$(document)
			.ready(
					function() {
						$('#tbl')
								.dataTable(
										{
											"destroy" : true,
											"searching" : true,
											"lengthChange" : false,
											"ordering" : false,
											//"order" : [ [ 1, "asc" ] ],
											"aLengthMenu" : [ 10 ],
											"language" : {

												"sProcessing" : "Procesando...",

												"sZeroRecords" : "No se encontrón registros",

												"sEmptyTable" : "No se encontraron registros",

												"sInfo" : "Mostrando registro del _START_ al _END_ de un total de _TOTAL_ registro",

												"sInfoEmpty" : "Mostrando registro del 0 al 0 de un total de 0 registro",

												"sInfoFiltered" : "(filtrado de un total de _MAX_ registro)",

												"sInfoPostFix" : "",

												"sSearch" : "Buscar:",

												"sUrl" : "",

												"sInfoThousands" : ",",

												"sLoadingRecords" : "Cargando...",

												"oPaginate" : {

													"sFirst" : "Primero",

													"sLast" : "Último",

													"sNext" : "Siguiente",

													"sPrevious" : "Anterior"

												},

												"oAria" : {

													"sSortAscending" : ": Activar para ordenar la columna de manera ascendente",

													"sSortDescending" : ": Activar para ordenar la columna de manera descendente"
												}

											}
										});

					});
</script>
</head>
<body>
	<br>
<div class="alert alert-danger" role="alert">
  PERLIEXP
</div>
  
	<button type="button" class="btn btn-success"
		onclick="addArticulosClientes();">Agregar Artículos</button>




	<button type="button" class="btn btn-info"
		onclick="clientesArticulos();">Recargar Tabla</button>
	<br>

	<table class="table table-hover" id="tbl">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">CLIENTE</th>
				<th scope="col">CLAVE UNIDAD</th>
				<th scope="col">DESCRIPCIÓN UNIDAD</th>
				<th scope="col">CLAVE PRODUCTO</th>
				<th scope="col">DESCRIPCIÓN PRODUCTO</th>
				<th scope="col">OPTIÓN</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listArticulos}" var="datoslista">
				<tr>
					<th scope="row">${datoslista.clientesArticulos.idCliente}</th>
					<td>${datoslista.clientesArticulos.nombre}</td>
					<td>${datoslista.claveUnidad}</td>
					<td>${datoslista.descripUnidad}</td>
					<td>${datoslista.claveProducto}</td>
					<td>${datoslista.descripProducto}</td>
					<td><button type="button" class="btn btn-danger">Eliminar</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>