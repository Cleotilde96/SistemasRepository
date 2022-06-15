<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inicio</title>

	
	<script type="text/javascript"
	src="/Sistemas/DataTables/DataTables/jquery.js"></script>
	
	<link rel="stylesheet"
	href="/Sistemas/bootstrap/css/bootstrap.min.css">

	
<script type="text/javascript" src="/Sistemas/js/metodos.js"></script>
<script type="text/javascript" src="/Sistemas/js/ArticulosClientes.js"></script>
<script type="text/javascript" src="/Sistemas/js/Reportes.js"></script>
<script type="text/javascript" src="/Sistemas/js/Busqueda.js"></script>
<script type="text/javascript" src="/Sistemas/js/Impresion.js"></script>
<script type="text/javascript" src="/Sistemas/js/calculadora.js"></script>
</head>
<!-- <body onload="cargaPantalla()"> -->
<body>
<br>
 <button type="button" class="btn btn-primary" disabled>
  <%= request.getSession().getAttribute("name") %>
</button>
 <nav class="navbar navbar-expand-lg navbar-light bg-light">

  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="javascript:Cargacontenido(1)">Inicio <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="javascript:Cargacontenido(2)">Carta Porte</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="javascript:Cargacontenido(3)">Reportes</a>
      </li>
     
     
    </ul>
    <ul class="navbar-nav">
       <li class="nav-item dropdown">
        
         <% 
         
         HttpSession sesion= request.getSession();
         String user;
         
         if(sesion.getAttribute("user")!=null){
                   user =  sesion.getAttribute("user").toString();
                     
                    out.print("<a class='nav-link dropdown-toggle' href='#' id='navbarDropdownMenuLink' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>" +user+ "</a><div class='dropdown-menu' aria-labelledby='navbarDropdownMenuLink'><a class='dropdown-item' href='login.jsp?cerrar=true'>Logout</a></div>"); 
                     
    
        }else{        	
        	out.print("<script>location.replace('login.jsp');</script>");	
        		
        }%>  
      </li>
      </ul>
 
 		    
  </div>
</nav>
 
<!-- <div align="center"> -->
<!-- <button type="button" class="btn btn-success" onclick="pruebas();">Ver Usuarios</button> -->
<!-- </div> -->
<br>
<div id="carga" class="container">

</div>

	<script src="/Sistemas/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>