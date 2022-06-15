<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consulta General Carta Porte</title>
<script>
	$(document)
			.ready(
					function() {
						$('#tbl')
								.dataTable(
										{

											"destroy" : true,
											"searching" : true,
											//"lengthChange": false,
											"ordering" : false,
											//"order" : [ [ 1, "asc" ] ],
											"aLengthMenu" : [ 10, 20, 30, 40,
													50, 100 ],

											"language" : {

												"sProcessing" : "Procesando...",

												"sLengthMenu" : "Mostrar _MENU_",

												"sZeroRecords" : "No se encontró  información de la Carta Porte",

												"sEmptyTable" : "Ninguna Carta Porte Existente",

												"sInfo" : "Mostrando  del _START_ al _END_ de un total de _TOTAL_ ",

												"sInfoEmpty" : "Mostrando  del 0 al 0 de un total de 0 ",

												"sInfoFiltered" : "(filtrado de un total de _MAX_ Carta Porte)",

												"sInfoPostFix" : "",

												"sSearch" : "Buscar Carta Porte:",

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
<body class="container">
<c:if test="${!empty msjError}">
<div class="alert alert-danger" role="alert" id="error">
${msjError}
</div>
	
</c:if>

<c:if test="${empty msjError}">


	<div >
		<table class="table table-striped table-bordered table-hover" >
			<thead>
				<tr>
					<th scope="col">Tipo</th>
					<th scope="col">Informe</th>
					<th scope="col">Factura</th>
					<th scope="col">Receptor</th>
					<th scope="col">Cliente</th>
					<th scope="col">Serie</th>
					<th scope="col">#Folio</th>
					<th scope="col">Fecha Emisión</th>
					<th scope="col">Estatus Proceso</th>
					<th scope="col">Estatus Impresión</th>
					<th scope="col" style="width: 50px;">Opciones</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${listCartaPorte}" var="datoslista">
				<tr>

					<td>${ datoslista.tipo }</td>		
					<c:if test="${datoslista.idInformesTalones <=0}">				
					<td>*****</td>
					</c:if>	
					<c:if test="${datoslista.idInformesTalones >0}">
					<td>${ datoslista.idInformesTalones}</td>
					</c:if>						
					<c:if test="${datoslista.numeroControl <=0}">
						<td>*****</td>
					</c:if>
					<c:if test="${datoslista.numeroControl >0}">
					<td>${ datoslista.numeroControl}</td>
					</c:if>
					<td>${datoslista.rfcReceptor}</td>
					<td>${datoslista.nombreCliente}</td>
					<td>${datoslista.serieCapturista}</td>
					<th scope="row">${datoslista.folio}</th>
					<td>${datoslista.fechaTimbrado}</td>
					<td>${datoslista.estatusProceso}</td>
					<td>${datoslista.estatusImpresion}</td>
					<td>
							
						<div class="btn-group-vertical">
						<div class="btn-toolbar mb-3" role="toolbar"
							aria-label="Toolbar with button groups">
							
							<c:if test="${datoslista.idEstatusProceso ==1  &&  empty datoslista.fechaTimbrado}">
							<div class="btn-group btn-group-sm" role="group" aria-label="...">								
								<button type="button" class="btn btn-secondary">Generar</button>
							</div>
							</c:if>
							<c:if test="${datoslista.idEstatusImpresion ==3}">
							<div class="btn-group btn-group-sm" role="group" aria-label="...">								
							<button type="button" class="btn btn-secondary" onclick="impresion(${datoslista.folio});">Imprimir</button>
							</div>
							</c:if>
							
							<c:if test="${datoslista.idEstatusProceso ==1  &&  datoslista.idEstatusImpresion==2 &&  !empty datoslista.fechaTimbrado}">
							<div class="btn-group btn-group-sm" role="group" aria-label="...">								
								
								<button type="button" class="btn btn-secondary" onclick="detalleDocumento(${datoslista.folio});">Detalle</button>
							</div>
							</c:if>
						</div>
						
						
           				</div>
					</td>

				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	</c:if>
</body>
</html>