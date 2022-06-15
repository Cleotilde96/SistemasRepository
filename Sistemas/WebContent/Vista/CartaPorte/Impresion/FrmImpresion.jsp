<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Impresión</title>
</head>
<body>

	<div class="alert alert-primary" role="alert">Datos necesarios
		para la plantilla Jasper</div>
		
<br>
	<div class="form-row">
		<div class="form-group col-md-12">
			<label for="exampleFormControlTextarea1">jr_Json</label>
			<textarea class="form-control" id="jr_Json" rows="1"></textarea>

		</div>
	</div>

	<br>
	<button type="button" class="btn btn-success btn-lg btn-block"
		onclick="cargarJsonData();">Json Data</button>
	<br>

	<form>
		<div class="form-row">
			<div class="form-group col-md-2">
				<label for="inputEmail4">jr_NumeroCartaPorte</label> <input
					type="text" class="form-control" id="jr_NumeroCartaPorte">
			</div>
			<div class="form-group col-md-2">
				<label for="inputPassword4">jr_FolioCartaPorte</label> <input
					type="text" class="form-control" id="jr_FolioCartaPorte">
			</div>
			<div class="form-group col-md-2">
				<label for="inputEmail4">jr_FolioInternoTalon</label> <input
					type="text" class="form-control" id="jr_FolioInternoTalon">
			</div>
			<div class="form-group col-md-2">
				<label for="inputPassword4">jr_NumeroControl</label> <input
					type="text" class="form-control" id="jr_NumeroControl">
			</div>
			<div class="form-group col-md-2">
				<label for="inputEmail4">jr_UUID</label> <input type="text"
					class="form-control" id="jr_UUID">
			</div>
			<div class="form-group col-md-2">
				<label for="inputPassword4">jr_FechaTimbrado</label> <input
					type="text" class="form-control" id="jr_FechaTimbrado">
			</div>

		</div>

		<div class="form-row">
			<div class="form-group col-md-2">
				<label for="inputEmail4">jr_FechaEmision</label> <input type="text"
					class="form-control" id="jr_FechaEmision">
			</div>
			<div class="form-group col-md-2">
				<label for="inputPassword4">jr_CertificadoDigital</label> <input
					type="text" class="form-control" id="jr_CertificadoDigital">
			</div>
			<div class="form-group col-md-2">
				<label for="inputEmail4">jr_CertificadoSAT</label> <input
					type="text" class="form-control" id="jr_CertificadoSAT">
			</div>
			<div class="form-group col-md-2">
				<label for="inputPassword4">jr_NombreClienteF</label> <input
					type="text" class="form-control" id="jr_NombreClienteF">
			</div>
			<div class="form-group col-md-2">
				<label for="inputEmail4">jr_RFC_Facturado</label> <input type="text"
					class="form-control" id="jr_RFC_Facturado">
			</div>
			<div class="form-group col-md-2">
				<label for="inputPassword4">jr_Direccion_Entrega</label> <input
					type="text" class="form-control" id="jr_Direccion_Entrega">
			</div>

		</div>

		<div class="form-row">
			<div class="form-group col-md-2">
				<label for="inputEmail4">jr_Observaciones</label> <input type="text"
					class="form-control" id="jr_Observaciones">
			</div>
			<div class="form-group col-md-2">
				<label for="inputPassword4">jr_MetodoDePago</label> <input
					type="text" class="form-control" id="jr_MetodoDePago">
			</div>
			<div class="form-group col-md-2">
				<label for="inputEmail4">jr_UsoCFDI</label> <input type="text"
					class="form-control" id="jr_UsoCFDI">
			</div>
			<div class="form-group col-md-2">
				<label for="inputPassword4">jr_FormaDePago</label> <input
					type="text" class="form-control" id="jr_FormaDePago">
			</div>
			<div class="form-group col-md-2">
				<label for="inputEmail4">jr_Aseguradora</label> <input type="text"
					class="form-control" id="jr_Aseguradora">
			</div>
			<div class="form-group col-md-2">
				<label for="inputPassword4">jr_Poliza</label> <input type="text"
					class="form-control" id="jr_Poliza">
			</div>

		</div>





		<div class="form-row">
			<div class="form-group col-md-2">
				<label for="inputEmail4">jr_KmRecorridos</label> <input type="text"
					class="form-control" id="jr_KmRecorridos">
			</div>
			<div class="form-group col-md-2">
				<label for="inputPassword4">jr_PlacasTractoCamion</label> <input
					type="text" class="form-control" id="jr_PlacasTractoCamion">
			</div>
			<div class="form-group col-md-2">
				<label for="inputEmail4">jr_PlacasRemolque</label> <input
					type="text" class="form-control" id="jr_PlacasRemolque">
			</div>
			<div class="form-group col-md-2">
				<label for="inputPassword4">jr_NombreOperador</label> <input
					type="text" class="form-control" id="jr_NombreOperador">
			</div>
			<div class="form-group col-md-2">
				<label for="inputEmail4">jr_RFC_Operador</label> <input type="text"
					class="form-control" id="jr_RFC_Operador">
			</div>
			<div class="form-group col-md-2">
				<label for="inputPassword4">jr_Licencia</label> <input type="text"
					class="form-control" id="jr_Licencia">
			</div>

		</div>


		<div class="form-row">
			<div class="form-group col-md-2">
				<label for="inputEmail4">jr_ClaveConfigVehicular</label> <input
					type="text" class="form-control" id="jr_ClaveConfigVehicular">
			</div>
			<div class="form-group col-md-2">
				<label for="inputPassword4">jr_TipoSubRemolque</label> <input
					type="text" class="form-control" id="jr_TipoSubRemolque">
			</div>
			<div class="form-group col-md-2">
				<label for="inputEmail4">jr_Subtotal</label> <input type="text"
					class="form-control" id="jr_Subtotal">
			</div>
			<div class="form-group col-md-2">
				<label for="inputPassword4">jr_Flete</label> <input type="text"
					class="form-control" id="jr_Flete">
			</div>
			<div class="form-group col-md-2">
				<label for="inputEmail4">jr_ImpuestoRet</label> <input type="text"
					class="form-control" id="jr_ImpuestoRet">
			</div>
			<div class="form-group col-md-2">
				<label for="inputPassword4">jr_TipoFactorRet</label> <input
					type="text" class="form-control" id="jr_TipoFactorRet">
			</div>

		</div>



		<div class="form-row">
			<div class="form-group col-md-2">
				<label for="inputEmail4">jr_TasaRet</label> <input type="text"
					class="form-control" id="jr_TasaRet">
			</div>
			<div class="form-group col-md-2">
				<label for="inputPassword4">jr_Iva</label> <input type="text"
					class="form-control" id="jr_Iva">
			</div>
			<div class="form-group col-md-2">
				<label for="inputEmail4">jr_Total</label> <input type="text"
					class="form-control" id="jr_Total">
			</div>
			<div class="form-group col-md-2">
				<label for="inputPassword4">jr_Retencion</label> <input type="text"
					class="form-control" id="jr_Retencion">
			</div>
			<div class="form-group col-md-2">
				<label for="inputEmail4">jr_NetoPagar</label> <input type="text"
					class="form-control" id="jr_NetoPagar">
			</div>
			<div class="form-group col-md-2">
				<label for="inputPassword4">jr_Serie</label> <input type="text"
					class="form-control" id="jr_Serie">
			</div>

		</div>

		<div class="form-group">
			<label for="exampleFormControlTextarea1">jr_CadenaOriginal</label>
			<textarea class="form-control" id="jr_CadenaOriginal" rows="1"></textarea>
		</div>


		<div class="form-group">
			<label for="exampleFormControlTextarea1">jr_SelloDigitalCFDI</label>
			<textarea class="form-control" id="jr_SelloDigitalCFDI" rows="1"></textarea>
		</div>


		<div class="form-group">
			<label for="exampleFormControlTextarea1">jr_SelloDigitalSAT</label>
			<textarea class="form-control" id="jr_SelloDigitalSAT" rows="1"></textarea>
		</div>

		<div class="form-group">
			<label for="inputAddress2">jr_RutaQR</label> <input type="text"
				class="form-control" id="jr_RutaQR">
		</div>


		<div class="form-group">
			<label for="exampleFormControlTextarea1">jr_DireccionOrigen</label>
			<textarea class="form-control" id="jr_DireccionOrigen" rows="1"></textarea>
		</div>

		<div class="form-group">
			<label for="exampleFormControlTextarea1">jr_LugarExpedicion</label>
			<textarea class="form-control" id="jr_LugarExpedicion" rows="1"></textarea>
		</div>

		<div class="form-group">
			<label for="exampleFormControlTextarea1">jr_DireccionOperador</label>
			<textarea class="form-control" id="jr_DireccionOperador" rows="1"></textarea>
		</div>

		<div class="form-group">
			<label for="inputAddress2">Ruta Almacenamiento</label> <input
				type="text" class="form-control" id="jr_rutaAlmacenamiento">
		</div>

		<div class="form-row">
		<div class="form-group col-md-6">
		<button type="button" class="btn btn-primary btn-lg btn-block"
			onclick="realizaImpresion();">Crear PDF</button>
			
		
		
		
		</div>
		
		<div class="form-group col-md-6">
		<button type="button" class="btn btn-info btn-lg btn-block"
			onclick="limpiarCampos();">Limpiar campos</button>
		
		</div>
			
		</div>
		
		
	
		

		
	</form>
</body>
</html>