$(function(){
	$( "form" ).on( "submit", function( event ) {
		  event.preventDefault();
		  
		  var data = {};
		  data["nombreMaterial"] = $("#nombreMaterial").val();
		  data["idMarca"] = $("#marcaMaterial").val();
		  data["idProveedores"] = $("#proveedorProducto").val();
		  data["idEstado"] =  $("#status").val();
		  data["idCategoria"]  = $("#categoria").val();
		  data["idSubCategoria"] = $("#subCategoria").val();
		  data["idTipoEntrada"] = $("#tipoEntrada").val();
		  data["detalleTipoEntrada"] = $("#detalleTipoEntrada").val();
		  data["ubicacion"] = $("#ubicacion").val();
		  data["idCiclo"] =  $("#ciclo").val();
		  
		  console.log(data);
		  
		  $.ajax({
			  dataType: "json",
			  url: "guardarNuevoMaterial.action",
			  data: data,
			  success: function(r){
				 if(r.guardado == true){
					 
					 window.location = "";
				 }else{
					 alert("No se pudo guardar");
				 }
			  }
		  });
		  console.log("fin");
	});
});