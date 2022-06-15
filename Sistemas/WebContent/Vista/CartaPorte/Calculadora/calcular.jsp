<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calcular</title>
</head>
<body>



<div class="container">

	 <div class="row">
    <div class="col">
       <label for="formGroupExampleInput">Persona:</label>
    	  <select class="custom-select" id="inputGroupSelect01">
    <option selected value="1">Moral</option>
    <option value="2">Fisica</option>
    
  </select>  
      
      </div>
    
  
</div>

  <div class="row">
    <div class="col">
       <label for="formGroupExampleInput">Flete:</label>
       <input type="text" class="form-control form-control-sm" id="txtflete" onkeyup ="if(event.keyCode == 13) calcularFlete()">
       <label id="lblTrasladosFlete"></label>
    </div>
    <div class="col">
  	<label for="formGroupExampleInput">Descuento:</label>
       <input type="text" class="form-control form-control-sm" id="txtdescuento" onkeyup ="if(event.keyCode == 13) calcularFlete()">
       
       <label for="formGroupExampleInput">Flete-Descuento:</label>
       <input type="number" class="form-control form-control-sm" id="txtFleteDescuento" disabled="disabled">
       
    </div>
  </div>
  <div class="row">
    <div class="col">
       <label for="formGroupExampleInput">Seguro:</label>
       <input type="text" class="form-control form-control-sm" id="txtseguro" onkeyup ="if(event.keyCode == 13) calcularFlete()">
    </div>
    <div class="col">
    	   <label for="formGroupExampleInput">SUBTOTAL:</label>
       <input type="number" class="form-control form-control-sm" id="txtSubtotal" disabled="disabled">
    </div>
  </div>
  <div class="row">
    <div class="col">
       <label for="formGroupExampleInput">Carga:</label>
       <input type="text" class="form-control form-control-sm" id="txtcarga" onkeyup ="if(event.keyCode == 13) calcularFlete()">
    </div>
    <div class="col">
    <label for="formGroupExampleInput">SUBTOTAL-DESCUENTO:</label>
       <input type="number" class="form-control form-control-sm" id="txtSubtotalDesc" disabled="disabled">
    
    </div>
  </div>
   <div class="row">
    <div class="col">
       <label for="formGroupExampleInput">Descarga:</label>
       <input type="text" class="form-control form-control-sm" id="txtdescarga" onkeyup ="if(event.keyCode == 13) calcularFlete()">
    </div>
    <div class="col">
    <label for="formGroupExampleInput">16% IVA:</label>
       <input type="number" class="form-control form-control-sm" id="txtIva" disabled="disabled">
    </div>
  </div>
  <div class="row">
    <div class="col">
       <label for="formGroupExampleInput">Autopista, Libramiento, Transbordador:</label>
       <input type="text" class="form-control form-control-sm" id="txtpeage" onkeyup ="if(event.keyCode == 13) calcularFlete()">
    </div>
    <div class="col">
    <label for="formGroupExampleInput">Total:</label>
       <input type="number" class="form-control form-control-sm" id="txtTotal" disabled="disabled" >
    </div>
  </div>
    <div class="row">
    <div class="col">
       <label for="formGroupExampleInput">Recuperación de Evidencias:</label>
       <input type="text" class="form-control form-control-sm" id="txtrecupEvidencia" onkeyup ="if(event.keyCode == 13) calcularFlete()">
    </div>
    <div class="col">
     <label for="formGroupExampleInput"> 4% RET.:</label>
       <input type="number" class="form-control form-control-sm" id="txtRetencion" disabled="disabled">
    </div>
  </div>
  
  <div class="row">
    <div class="col">
       <label for="formGroupExampleInput">Recolección:</label>
       <input type="text" class="form-control form-control-sm" id="txtrecoleccion" onkeyup ="if(event.keyCode == 13) calcularFlete()">
    </div>
    <div class="col">
   
     <label for="formGroupExampleInput">NETO A PAGAR:</label>
       <input type="number" class="form-control form-control-sm" id="txtNeto" disabled="disabled">
    </div>
  </div>
  
</div>
<br>

<div align="center">
<button type="button" class="btn btn-success" onclick="xmlConceptos();">XML Conceptos</button>
</div>


</body>
</html>