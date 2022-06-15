<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultados</title>
</head>
<body>
<c:if test="${!empty msjError}">
<div class="alert alert-warning" role="alert" id="error">
${msjError}
</div>
	
</c:if>

<c:if test="${empty msjError}">
	<table class="table table-hover">
		<thead>
			<tr>
				<th scope="col">Estatus</th>
				<th scope="col">Clave Producto</th>
				<th scope="col">Descripción</th>
				<th scope="col">Material Peligroso</th>
				<th scope="col">Opciones</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${lista}" var="datoslista">
			<tr>
				<th>${datoslista.idEstatusProceso}</th>
				<td scope="row">${datoslista.claveProducto}</td>
				<td>${datoslista.descripcion}</td>
				<td>${datoslista.materialPeligroso}</td>
				<td>
					<button type="button" class="btn btn-info"
						onclick="editClavesProducto(${datoslista.idCClaveProdServCP},'${datoslista.claveProducto}','${datoslista.descripcion}','${datoslista.materialPeligroso}');">Editar</button>
					<button type="button" class="btn btn-danger">Eliminar</button>
				</td>
			</tr>
		</c:forEach>

		</tbody>
	</table>
	</c:if>
</body>
</html>