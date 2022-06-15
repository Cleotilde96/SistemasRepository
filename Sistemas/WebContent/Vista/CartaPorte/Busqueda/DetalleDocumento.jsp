<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle Documento</title>
</head>
<body>
	<h5>CARTA PORTE FOLIO: <c:out value="${folio}"></c:out> </h5>
	<c:forEach items="${listDetalle}" var="datoslista">
	<form>
	
		<div class="form-group row">
			<label for="colFormLabelSm"
				class="col-sm-2 col-form-label col-form-label-sm">Folio
				Fiscal:</label>
			<div class="col-sm-10">
				<input type="email" class="form-control form-control-sm"
					id="colFormLabelSm"  disabled="disabled" value="${datoslista.uUID}">

			</div>



		</div>
		<div class="form-group row">
			<label for="colFormLabelSm"
				class="col-sm-2 col-form-label col-form-label-sm">Fecha
				Certificación:</label>
			<div class="col-sm-4">
				<input type="email" class="form-control form-control-sm"
					id="colFormLabelSm"  disabled="disabled" value="${datoslista.fechaTimbrado}">

			</div>
			<label for="colFormLabelSm"
				class="col-sm-2 col-form-label col-form-label-sm">Fecha de
				Emisión:</label>
			<div class="col-sm-4">
				<input type="email" class="form-control form-control-sm"
					id="colFormLabelSm"  disabled="disabled" value="${datoslista.fechaEmision}">

			</div>


		</div>

		<div class="form-group row">
			<label for="colFormLabelSm"
				class="col-sm-2 col-form-label col-form-label-sm">No.
				Certificado Digital:</label>
			<div class="col-sm-4">
				<input type="email" class="form-control form-control-sm"
					id="colFormLabelSm"  disabled="disabled" value="${datoslista.certificadoDigital}">

			</div>
			<label for="colFormLabelSm"
				class="col-sm-2 col-form-label col-form-label-sm">No. Serie
				Certificado:</label>
			<div class="col-sm-4">
				<input type="email" class="form-control form-control-sm"
					id="colFormLabelSm" disabled="disabled" value="${datoslista.certificadoSAT}">

			</div>


		</div>

	</form>
	

	

	<div role="toolbar"
		aria-label="Toolbar with button groups"  align="center">
		<div role="group" aria-label="First group">
			<button type="button" class="btn btn-secondary" onclick="ViewArchivo(${folio},1)">Abrir PDF</button>
			<button type="button" class="btn btn-secondary" onclick="ViewArchivo(${folio},2)">Abrir XML</button>
			<button type="button" class="btn btn-secondary" onclick="impresion(${folio});">Imprimir</button>			
		</div>

	</div>
	
</c:forEach>	



</body>
</html>