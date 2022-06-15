
//$('#btnArticulos').click(articulosClientes); 


function addArticulosClientes(){
	 	       $.ajax({
					dataType : "html",//Tipo de conversión
					type : "POST",//Método de envio					
					//url : "/PerliExpressWeb/menu/Facturacion/Talones/AgregarTalon/Ruta/Articulos/ArticulosProductos.jsp",
					//url : "/PerliExpressWeb/servlet/controlador?obj=articulosclientes&page=menu/Facturacion/Talones/AgregarTalon/Ruta/Articulos/ArticulosProductos.jsp",	
				    url:"/Sistemas/Controlador?obj=articulosclientes&page=Vista/CartaPorte/ArticulosCliente/Articulos.jsp",
					//url : "/Sistemas/Vista/CartaPorte/ArticulosCliente/Articulos.jsp",
					
					data : {opction:2},
					beforeSend : function(data) {
					},
					success : function(requestData) { //Llamada exitosa											
						$("#carga").html(requestData);
					},
					error : function(requestData, strError, strTipoError) {
						alert("Error " + strTipoError + ': ' + strError); //En caso de error mostraremos un alert
					}
				});	
	
}

function buscarClaveProducto(){
	
		  var claveProducto=  $('#txtClaveProd').val();

		if(claveProducto ==null || claveProducto ==""){
			
			alert("Ingresa la clave producto a 8 dígitos");
		}
		else{
			
			$.ajax({
					dataType : "html",//Tipo de conversión
					type : "POST",//Método de envio					
					url:"/Sistemas/Controlador?obj=articulosclientes&page=Vista/CartaPorte/ArticulosCliente/Articulos.jsp",
					data : {claveProducto:claveProducto,opction:3},
					beforeSend : function(data) {
						document.getElementById("txtDescripProd").value="";
					},
					success : function(requestData) { 
						console.log("request:"+requestData);				
					 var datos= JSON.parse(requestData);
			
			     	 if(datos.msjInfo !="" && datos.msjInfo != null){
							alert(datos.msjInfo);
				   	 }
	                 else{
				       document.getElementById("hdIdClaveProv").value=datos.idClave;
				       document.getElementById("txtDescripProd").value=datos.descripcion;							
					 }
						
					},
					error : function(requestData, strError, strTipoError) {
						alert("Error " + strTipoError + ': ' + strError); //En caso de error mostraremos un alert
					}
				});	
							
			
		}

	
}


function  cerrarModal(){
	
	$('#exampleModal').modal('toggle');
	
}



function consultarClientes(){
	
	
	 var nombre=  $('#txtNombre').val();
	 var apellidoUno=$('#txtApellido1').val();
     var apellidoDos=$('#txtApellido2').val();
     var idClient=$('#txtIdClient').val();

		if( (nombre ==null || nombre =="") 
		  && (apellidoUno==null || apellidoUno=="")
          && (apellidoDos==null || apellidoDos=="")
          && (idClient ==null || idClient=="")){			
			alert("Ingresa almenos un  parametro de busqueda");
		}
		else{
			
			if(idClient ==null || idClient==""){
				idClient=-1;
			}
			
			$.ajax({
					dataType : "html",//Tipo de conversión
					type : "POST",//Método de envio			
					///Sistemas/WebContent/Vista/CartaPorte/Clientes/tablaClientes.jsp		
					url:"/Sistemas/Controlador?obj=buscaclientes&page=Vista/CartaPorte/Clientes/tablaClientes.jsp",
					data : {
						nombre:nombre,
						apellidoUno:apellidoUno,
						apellidoDos:apellidoDos,
						idClient:idClient,
					    opction:1
							},
					beforeSend : function(data) {
						
					},
					success : function(requestData) { 
					
						$("#contenido").html(requestData);
					},
					error : function(requestData, strError, strTipoError) {
						alert("Error " + strTipoError + ': ' + strError); //En caso de error mostraremos un alert
					}
				});	
							
			
		}
}


function limpiarCampos(){
	
	$('#txtNombre').val("");
	$('#txtApellido1').val("");
    $('#txtApellido2').val("");
	
}

function selectionCliente(numCliente,nombreCliente){		 
	     $('#exampleModal').modal('toggle');
         document.getElementById("txtnumcliente").value=numCliente;	
	     document.getElementById("txtNombreC").value=nombreCliente;	
}


function clientesArticulos(){
		
			$.ajax({
					dataType : "html",//Tipo de conversión
					type : "POST",//Método de envio			
			
					url:"/Sistemas/Controlador?obj=articulosclientes&page=Vista/CartaPorte/ArticulosCliente/TablaArticulosCliente.jsp",
					data : {
					    opction:5
						},
					success : function(requestData) { 
					
						$("#carga").html(requestData);
					},
					error : function(requestData, strError, strTipoError) {
						alert("Error " + strTipoError + ': ' + strError); //En caso de error mostraremos un alert
					}
				});		
	
	
}





function agregar(){
	
	
	var datos=JSON.stringify({
				    txtnumcliente:$('#txtnumcliente').val(),
					txtNombreC:$('#txtNombreC').val(),
					slArticulos:$('#slArticulos').val(),
					hdIdClaveProv:$('#hdIdClaveProv').val(),
					txtClaveProd:$('#txtClaveProd').val(),
					txtDescripProd:$('#txtDescripProd').val(),
					txtIdEmpleadoA:$('#txtIdEmpleadoA').val()
				
			});
			
			console.log("json: " + datos);
	
}



function saveArticuloCliente(){
	
	idClientes = $('#txtnumcliente').val();
	idTipoArticulo = $('#slArticulos').val();
	idClaveProductoS = $('#hdIdClaveProv').val();
	idEmpleado =  $('#txtIdEmpleadoA').val();
	
	if((idClientes=="" || idClientes==null) && (idTipoArticulo =="" || idTipoArticulo==null) && (idClaveProductoS=="" || idClaveProductoS==null) && (idEmpleado=="" || idEmpleado==null)){
		alert("No se logró optener algun dato necesario para agregar el artículo.");
	}
	else{
		  				
		$.ajax({
					dataType : "html",
					type : "POST",	
							///Sistemas/WebContent/Vista/CartaPorte/ArticulosCliente/Articulos.jsp
					url:"/Sistemas/Controlador?obj=articulosclientes&page=Vista/CartaPorte/ArticulosCliente/Articulos.jsp",								
					data : {					
						idClientes:idClientes,
						idTipoArticulo:idTipoArticulo,
						idClaveProductoS:idClaveProductoS,
						idEmpleado:idEmpleado,						
						opction:4						
						},
					beforeSend : function(data) {
						
					},
					success : function(requestData) { 	
					
					var datos= JSON.parse(requestData);
					
					if(datos.msjInfo !="" && datos.msjInfo != null){
						alert(datos.msjInfo);
				    }
					else if(datos.msjError !="" && datos.msjError !=null){
						
						alert(datos.msjError);
					}
					else{
											
					
						if(datos.msjsuccess !="" && datos.msjsuccess !=null){//Agregar
							alert(datos.msjsuccess);
						}
						
						
					}
		
					},
					error : function(requestData, strError, strTipoError) {
						alert("Error " + strTipoError + ': ' + strError);
					}
				});		
		
	}
	
}


function generaQuery(){
	
	idClientes = $('#txtnumcliente').val();
	idTipoArticulo = $('#slArticulos').val();
	idClaveProductoS = $('#hdIdClaveProv').val();
	idEmpleado =  $('#txtIdEmpleadoA').val();
	
	cadena ="";
	acumulaQuery="";
	
	//INSERT INTO C_CodigosClientes_CCartaPorte VALUES(1,22,10,1,GETDATE(),-1,NULL,NULL);
	if((idClientes=="" || idClientes==null) && (idTipoArticulo =="" || idTipoArticulo==null) && (idClaveProductoS=="" || idClaveProductoS==null) && (idEmpleado=="" || idEmpleado==null)){
		alert("No se logró optener algun dato necesario para generar el query");
	}else{
		
		cadena = "INSERT INTO C_CodigosClientes_CCartaPorte VALUES("+idTipoArticulo+","+idClaveProductoS+",10,"+idEmpleado+",GETDATE(),-1,NULL,NULL);";	
	
	cadena =$('#txtQuery').val()+ cadena +"\n";
	
		//$('#txtQuery').val("INSERT INTO C_CodigosClientes_CCartaPorte VALUES("+idTipoArticulo+","+idClaveProductoS+",10,"+idEmpleado+",GETDATE(),-1,NULL,NULL);");	
		$('#txtQuery').val(cadena);	
	}
		
}

function limpiarQuery(){
	$('#txtQuery').val("");
}


function viewClavesProducto(){

	$.ajax({
		dataType : "html",//Tipo de conversión
		type : "POST",//Método de envio
		url : "/Sistemas/Vista/CartaPorte/ClaveProducto/ViewClaveProducto.jsp",
		//data : "usuario=" + valorUser,
		beforeSend : function(data) {
		},
		success : function(requestData) { //Llamada exitosa	
			$("#carga").html(requestData);	
		},
		error : function(requestData, strError, strTipoError) {
			alert("Error " + strTipoError + ': ' + strError); //En caso de error mostraremos un alert
		}
	});	
	
	
}



function searchClavesProducto(){

	var claveproducto = $('#txtclaveproducto').val();
	
	if(claveproducto.length < 8)
	{
		alert("la clave debe contener 8  digitos numericos");
	}else{
	
	$.ajax({
		dataType : "html",//Tipo de conversión
		type : "POST",//Método de envio		
		url:"/Sistemas/Controlador?obj=ClaveProdServ&page=Vista/CartaPorte/ClaveProducto/Tabla.jsp",								
		data :{
			claveproducto:claveproducto,
			opction:1			
		},
		beforeSend : function(data) {
		},
		success : function(requestData) { //Llamada exitosa	
			$("#dvTablaClaves").html(requestData);	
		},
		error : function(requestData, strError, strTipoError) {
			alert("Error " + strTipoError + ': ' + strError); //En caso de error mostraremos un alert
		}
	});
	
	}	
		
}


function addClavesProducto(){

	var claveproducto = $('#txtclaveproducto').val();
	
	if(claveproducto.length < 8)
	{
		alert("la clave debe contener 8  digitos numericos");
	}
	else{


	$.ajax({
		dataType : "html",//Tipo de conversión
		type : "POST",//Método de envio
		url:"/Sistemas/Controlador?obj=ClaveProdServ&page=Vista/CartaPorte/ClaveProducto/Agregar.jsp",
		data : {
			claveproducto:claveproducto,
			opction:2	
		},
		beforeSend : function(data) {
		},
		success : function(requestData) { //Llamada exitosa	
			$("#carga").html(requestData);	
		},
		error : function(requestData, strError, strTipoError) {
			alert("Error " + strTipoError + ': ' + strError); //En caso de error mostraremos un alert
		}
	});	
  }		
}


function agregarClaveProducto(){
	
	var claveproducto = $('#txtClave').val();
	var descripcion = $('#txtDescripcion').val();
	var material = $('#slMaterial').val();
	
	if(claveproducto.length < 8)
	{
		alert("la clave debe contener 8  digitos numericos");
	}
	else{


	$.ajax({
		dataType : "html",//Tipo de conversión
		type : "POST",//Método de envio
		url:"/Sistemas/Controlador?obj=ClaveProdServ&page=Vista/CartaPorte/ClaveProducto/Agregar.jsp",
		data : {
			claveproducto:claveproducto,
			descripcion:descripcion,
			material :material,
			opction:3	
		},
		beforeSend : function(data) {
		},
		success : function(requestData) { //Llamada exitosa	
			$("#carga").html(requestData);	
		},
		error : function(requestData, strError, strTipoError) {
			alert("Error " + strTipoError + ': ' + strError); //En caso de error mostraremos un alert
		}
	});	
 }		
	
}




function editClavesProducto(id,clave,descripcion,material){


	if(material=="No"){
		material=1;
	}
	else if(material=="Si"){
		material =2;
	}
	

	$.ajax({
		dataType : "html",//Tipo de conversión
		type : "POST",//Método de envio
		url:"/Sistemas/Controlador?obj=ClaveProdServ&page=Vista/CartaPorte/ClaveProducto/Editar.jsp",
		data : 
		{
			id:id,
			claveproducto:clave,
			descripcion:descripcion,
			material:material,
			opction:4	
		},
		beforeSend : function(data) {
		},
		success : function(requestData) { //Llamada exitosa	
			$("#carga").html(requestData);	
		},
		error : function(requestData, strError, strTipoError) {
			alert("Error " + strTipoError + ': ' + strError); //En caso de error mostraremos un alert
		}
	});	
		
}


function actualizarClaveProducto(id){
	
	var claveproducto = $('#txtClave').val();
	var descripcion = $('#txtDescripcion').val();
	var material = $('#slMaterial').val();
	
	
	if(claveproducto.length < 8)
	{
		alert("la clave debe contener 8  digitos numericos");
	}
	else{

	$.ajax({
		dataType : "html",//Tipo de conversión
		type : "POST",//Método de envio
		url:"/Sistemas/Controlador?obj=ClaveProdServ&page=Vista/CartaPorte/ClaveProducto/Editar.jsp",
		data : 
		{
			id:id,
			claveproducto:claveproducto,
			descripcion:descripcion,
			material:material,
			opction:5	
		},
		beforeSend : function(data) {
		},
		success : function(requestData) { //Llamada exitosa	
			$("#carga").html(requestData);	
		},
		error : function(requestData, strError, strTipoError) {
			alert("Error " + strTipoError + ': ' + strError); //En caso de error mostraremos un alert
		}
	});	
	
	}
		
}





