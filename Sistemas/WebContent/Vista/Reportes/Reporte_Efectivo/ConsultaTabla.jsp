<%@ page language="java" import="java.util.ArrayList"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
	ArrayList<?> pintarTabla = (ArrayList<?>) session.getAttribute("arrayFact");
	session.removeAttribute("arrayFact");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/Sistemas/bootstrap/css/bootstrap.min.css">
	<script type="text/javascript"
	src="/Sistemas/DataTables/DataTables/jquery.js"></script>
		<link rel="stylesheet" type="text/css" href="/Sistemas/DataTables/DataTables/css/jquery.dataTables.css" media="screen" />
	<script type="text/javascript"  src="/Sistemas/DataTables/DataTables/js/jquery.dataTables.js"></script>
	<script type="text/javascript" src="/Sistemas/js/metodos.js"></script>
	<script type="text/javascript">
	
		$('#tbl')
				.dataTable(
						{
							"order" : [ [ 3, "asc" ] ],

							"language" : {

								"bAutoWidth" : true,
								"sProcessing" : "Procesando...",

								"sLengthMenu" : "Mostrar _MENU_ registros",

								"sZeroRecords" : "No se encontraron resultados",

								"sEmptyTable" : "Ningún dato disponible en esta tabla",

								"sInfo" : "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",

								"sInfoEmpty" : "Mostrando registros del 0 al 0 de un total de 0 registros",

								"sInfoFiltered" : "(filtrado de un total de _MAX_ registros)",

								"sInfoPostFix" : "",

								"sSearch" : "Filtrar Resultados:",

								"sUrl" : "",

								"sInfoThousands" : ",",

								"sLoadingRecords" : "Cargando...",

								"oPaginate" : {

									"sFirst" : "Primero",

									"sLast" : "Último",

									"sNext" : "Siguiente",

									"sPrevious" : "Anterior",
									"decimal" : ",",
									"thousands" : "."

								},

								"oAria" : {

									"sSortAscending" : ": Activar para ordenar la columna de manera ascendente",

									"sSortDescending" : ": Activar para ordenar la columna de manera descendente"
								},
							}
						});
	
</script>

</head>
<body >

	<table class="table table-hover" id="tbl" >
		<thead>
			<tr>
				<th scope="col">Fecha talon</th>
				<th scope="col">No.de factura</th>
				<th scope="col" title="(nombre completo a quien se le facturo)">cliente </th>
				<th scope="col">Estatus crédito</th>
				<th scope="col">Flete</th>
				<th scope="col">Estatus crédito</th>
				<th scope="col">Seguro</th>
				<th scope="col">Descarga</th>
				<th scope="col">Transbordador</th>
				<th scope="col">Entrega</th>
				<th scope="col">Carga</th>
				<th scope="col">Recolección</th>
				<th scope="col">Subtotal</th>
				<th scope="col">Iva</th>
				<th scope="col">Ret.iva</th>
				<th scope="col">Total sistemas</th>

			</tr>
		</thead>
		

		<tbody>
		<%
			for (int x = 0; x < pintarTabla.size(); x++) {
				String d_reg[] = (String[]) pintarTabla.get(x);
		%>
			<tr>
				<td><%=d_reg[0]%></td>
				<td><%=d_reg[1]%></td>
				<td><%=d_reg[2]%></td>
				<td><%=d_reg[3]%></td>
				<td><%=d_reg[4]%></td>
				<td><%=d_reg[5]%></td>
				<td><%=d_reg[6]%></td>
				<td><%=d_reg[7]%></td>
				<td><%=d_reg[8]%></td>
				<td><%=d_reg[9]%></td>
				<td><%=d_reg[10]%></td>
				<td><%=d_reg[11]%></td>
				<td><%=d_reg[12]%></td>
				<td><%=d_reg[13]%></td>
				<td><%=d_reg[14]%></td>
				<td><%=d_reg[15]%></td>
			</tr>
		<%}%>
		</tbody>
	</table>
	<br>
	<div align="center">
	<button type="button" class="btn btn-success" disabled="disabled" title="sin función" onclick="descarga();">Descarga</button>
	</div>

</body>
</html>