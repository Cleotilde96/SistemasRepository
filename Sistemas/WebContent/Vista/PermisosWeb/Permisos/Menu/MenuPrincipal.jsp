<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    String liga="";
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
</head>
<body>
<form class="row gy-2 gx-3 align-items-center">
  <div class="col-auto">
    <div class="form-outline">
        <label class="form-label" for="form11Example1">Nombre Permiso</label>
      <input type="text" id="txtnombre" class="form-control" onkeyup="copiar(1)"/>
  
    </div>
  </div>
   <div class="col-auto">
    <label for="exampleFormControlSelect1">Tipo Permiso</label>
    <select class="form-control" id="sltipoPermiso">
      <option value="1">Permiso Menu</option>
      <option value="2">Permiso Liga</option>
      <option value="3">Permiso Interno</option>
    </select>
  </div>
<div class="col-auto">
    <div class="form-outline">
        <label class="form-label" for="form11Example1">Ruta JSP</label>
      <input type="text" id="txtjsp" class="form-control"  onkeyup="copiar(2)"/>
  
    </div>
  </div>
    
      <div class="col">
      <div class="form-outline">
       <label class="form-label" for="form11Example1">Liga</label>
       <textarea rows="2" cols="20" class="form-control"  id="lblliga" disabled></textarea>
<!--         <label class="form-control" for="form6Example1" id="lblliga"></label> -->
       
      </div>
    </div>
    
    
</form>
<br>
 <div class="col">
    <button type="submit" class="btn btn-primary">Agregar</button>
  </div>
  <br>
</body>
</html>