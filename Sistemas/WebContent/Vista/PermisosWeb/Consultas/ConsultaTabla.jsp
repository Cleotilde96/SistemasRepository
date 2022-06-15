<%@ page language="java" import="java.util.ArrayList"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
	ArrayList<?> pintarTabla = (ArrayList<?>) session.getAttribute("arrayUsers");
	session.removeAttribute("arrayUsers");
	
	
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

<link rel="stylesheet"
	href="/Sistemas/Librerias/dataTables.checkboxes.css">
<script type="text/javascript"  src="/Sistemas/Librerias/dataTables.checkboxes.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	   var table = $('#tbl').DataTable({
		   
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
		   },
	     
	      'columnDefs': [
	         {
	            'targets': 0,
	       
	        	'checkboxes': {
	               'selectRow': true
	            }

	         }
	      ],
	      'select': {
	         'style': 'multi'
	      },
	      'order': [[3, 'asc']]
	   });
	   
	// Handle form submission event 
	   $("#boton").click(function(e) {
	      var form = this;
	      
	      var rows_selected = table.column(0).checkboxes.selected();
	
	      
	      // Iterate over all selected checkboxes
	      $.each(rows_selected, function(index, rowId){
	    	  
	    	
	         $(form).append(
	             $('<input>')
	                .attr('type', 'hidden')
	                .attr('name', 'id[]')
	                .val(rowId)
	         );
	      
	         
	      });
	      
	     var iduser= rows_selected.join(",");
	      //$('#example-console-rows').text(rows_selected.join(","));
	     
	      Agregaruser(iduser);
	    
	      $('input[name="id\[\]"]', form).remove();
	      e.preventDefault();
	   });   
	   
	    
	   
	});





</script>



</head>
<body>
<div>
  <div class="input-group-prepend">
    <label class="input-group-text" for="inputGroupSelect01">Options</label>
  </div>
  <select class="custom" id="Menu" onchange="MenuPrincipal();">
    <option selected>Choose...</option>
    <option value="1">One</option>
    <option value="2">Two</option>
    <option value="3">Three</option>
  </select>
</div>
	<table class="table table-bordered" id="tbl">
		<thead>
			<tr>
				
				<th scope="col"></th>
				<th scope="col">#Empleado</th>
				<th scope="col">Nombre Empleado</th>
				<th scope="col">Usuario</th>
		
			</tr>
		</thead>
		

		<tbody style="cursor:pointer">
		<%
			for (int x = 0; x < pintarTabla.size(); x++) {
				String d_reg[] = (String[]) pintarTabla.get(x);
		%>
			
			<tr>
				<td><%=d_reg[0]%></td>
				<td><%=d_reg[1]%></td>
				<td><%=d_reg[2]%></td>
				<td><%=d_reg[3]%></td>
			

			</tr>
	
		<%}%>
		</tbody>
	</table>
	<br>
<div align="center">
<button type="button" class="btn btn-success" id="boton">Ver</button>
<p>Usuarios Seleccionados</p>
<pre id="example-console-rows"></pre>
</div>
</body>
</html>