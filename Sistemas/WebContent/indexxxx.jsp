<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>inicio</title>
<script type="text/javascript" src="/Sistemas/js/metodos.js"></script>
<link rel="stylesheet" href="/Sistemas/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="/Sistemas/bootstrap/js/jquery.js"></script>

<script type="text/javascript" src="/Sistemas/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"  src="/Sistemas/DataTables/DataTables/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="/Sistemas/DataTables/DataTables/jquery.js"></script>	
<script type="text/javascript" src="/Sistemas/DataTables/datatables.js"></script>
<script type="text/javascript" >
$(document).ready(function(){
		var mytable = $("#tbl").DataTable({
			ajax: 'datos.json',
			columnDefs:[
			  {
				  targets:0,
				  checkboxes:{
					  seletRow: true
				  }
			  }
			],
			select:{
				style:'multi'
			},
			order:[[1,'asc']]
		})
		$("#myform").on('submit',function(e){	
		var form =this
		var  rowsel = mytable.colum(0).checkboxes.selected();
		$.each(rowsel,function(index,rowId){
			$(form).append(
				$('<input>').attr('type','hidden').attr('name','id[]').val(rowId)		
			)
		
		})
		$("#view-rows").text(rowsel.join(","))
		$("#view-form").text($(form).serialize())
		$('input[name="id\[\]"]',form).remove()
		e.preventDefault()
		})
})

</script>

	
</head>
<body>
<br>
<div align="center">
<button type="button" class="btn btn-success" onclick="cargaPantalla();">Ver Usuarios</button>
</div>
<br>
<div id="valor">cargar</div>
<div class="container" id="carga"> </div>
<!-- <input type="checkbox" name="check" value="1"> -->

<!-- <input type="checkbox" name="check" value="2"> -->

<!-- <input type="checkbox" name="check" value="3"> -->

<div class="container" style="margin:15px auto">
<form id="myform" method="post">
<p><b>check selecionados</b></p>
<pre id="view-rows"> </pre>
<pre id="view-form"> </pre>
<p><button  class="btn btn-danger" id="boton">ver</button></p>


</form>
</div>


</body>
</html>