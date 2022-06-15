function impresion(idcartaporte){
	
			$.ajax({
					dataType : "html",//Tipo de conversión
					type : "POST",//Método de envio						
				    url:"/Sistemas/Controlador?obj=imprimir&page=Vista/CartaPorte/Impresion/printOK.jsp",
					data : 
					{
					idcartaporte:idcartaporte,
					opction:1
					},
					beforeSend : function(data) {
					},
					success : function(requestData) { //Llamada exitosa											
						var jsonData= JSON.parse(requestData);
						
						if(jsonData == null){
							
							$("#dverror").html("<div class='alert alert-warning alert-dismissible fade show' role='alert'><strong>WARNING!!</strong>Algun dato NULL<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>");
							
						}else{
							
							if(jsonData.success ==true){
							$("#dvsuccess").html("<div class='alert alert-success' role='alert'>Impresion correcta<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>");
							}
							else{
								if(jsonData.msjError !="" && jsonData.msjError !=null){
									$("#dverror").html("<div class='alert alert-warning alert-dismissible fade show' role='alert'><strong>WARNING!!</strong>"+jsonData.msjError+ "<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>");
						
								}
							}
							
						}
						
						
						listado();
					},
					error : function(requestData, strError, strTipoError) {
						alert("Error " + strTipoError + ': ' + strError); //En caso de error mostraremos un alert
					}
				});	
	
	
}