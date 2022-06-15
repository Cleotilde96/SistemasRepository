
function reporteEfectivo(){
	 	       $.ajax({
					dataType : "html",//Tipo de conversión
					type : "POST",//Método de envio						
				    url:"/Sistemas/Controlador?obj=index&page=Vista/Reportes/Reporte_Efectivo/index.jsp",
					data : {},
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