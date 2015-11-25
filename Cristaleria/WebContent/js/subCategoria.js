$(function(){
	$("#categoria").change(function(){
		$.ajax({
		  dataType: "json",
		  url: "getSubCategoria.action",
		  data: {"idCategoria": $(this).val()},
		  success: function(res){
					  	if(res){
					  		var sSubCategoria =  $("#subCategoria");
					  		if (res.subCategoria.length == 0){
					  			sSubCategoria
					  				.find('option')
					  				.remove()
					  				.end()
					  				.append('<option value="9">Sin Sub Categorias</option>')
					  			    .val('null');
					  		}else{
					  			sSubCategoria
				  				.find('option')
				  				.remove();
					  			
					  			for(i = 0 ; i <res.subCategoria.length; i++ ){
					  				sSubCategoria.append('<option value="'+res.subCategoria[i].id+'">'+res.subCategoria[i].nombre+'</option>');
					  			}

					  		}
					  	}else{
					  		alert("No Hay SubCategorias disponibles");
					  	}
		  		   }
		});
	});
});