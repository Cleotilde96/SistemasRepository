<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar</title>
</head>
<body>

	<div class="card">
		<div class="card-header">Edición</div>
		<div class="card-body">
			<form>
				<div class="form-group">
					<label for="formGroupExampleInput">Clave Producto</label> <input
						type="text" class="form-control" id="txtClave"
						value="${claveproducto}" disabled>
				</div>
				<div class="form-group">
					<label for="formGroupExampleInput2">Descripción</label> <input
						type="text" class="form-control" id="txtDescripcion"
						value="${descripcion}" maxlength="350">
				</div>
				<div class="form-group">
					<label for="formGroupExampleInput2">Material Peligroso</label> <select
						id="slMaterial" class="form-control">
						
						<c:if test="${material == 1}">
						<option value="1" selected>No</option>	
						<option value="2">Si</option>					
						</c:if>
						<c:if test="${material == 2}">
						<option value="2" selected>Si</option>
						<option value="1" >No</option>	
						</c:if>
						<c:if test="${empty material}">
						<option value="1" selected>No</option>	
						<option value="2">Si</option>
						</c:if>
						
					</select>
				</div>

			</form>
			<button type="button" class="btn btn-info" 
						onclick="actualizarClaveProducto(${idClave})">Guardar</button>
						
			<button type="button" class="btn btn-link" onclick="viewClavesProducto()" >Regresar</button>
		</div>
	</div>
	<br>

	<c:if test="${!empty msjError}">
		<div class="alert alert-warning" role="alert" id="error">
			${msjError}</div>

	</c:if>


</body>
</html>