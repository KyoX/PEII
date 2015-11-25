<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="jquery-ui-1.11.4.custom/jquery-ui.css">
<link rel="stylesheet"
	href="jquery-ui-1.11.4.custom/jquery-ui.theme.css">
<link rel="stylesheet" href="bootstrap-3.3.5-dist/css/bootstrap.css">
<link rel="stylesheet"
	href="bootstrap-3.3.5-dist/css/bootstrap-theme.css">
<link rel="stylesheet" href="general.css">

<script src="jquery-2.1.4.min.js"></script>
<script src="jquery-ui-1.11.4.custom/jquery-ui.js"></script>
<script src="bootstrap-3.3.5-dist/js/bootstrap.js"></script>

<title>Inventario de materiales y cristaleria</title>


</head>
<body>
	<input type="text" name="user" id="user" value="User"
		style="display: none;" />
	<!--[if lt IE 10]>
            <p class="chromeframe">Estas usando un navegador <strong>desactualizado</strong>. Por favor <a href="http://browsehappy.com/">actualiza tu navegador</a></p>
    <![endif]-->
    
	<!--  Inicio Nav -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a href="#" class="navbar-brand dropdown-toggle"
				data-toggle="dropdown">Menu <b class="caret"></b></a>
			<ul class="dropdown-menu">
				<li><a href="entradaMateriales.jsp"> Nuevo Material</a></li>
				<li><a href="prestamoMateriales.jsp"> Prestamo Material</a></li>
				<li><a href="salidaMateriales.jsp"> Otras Salidas</a></li>
			</ul>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav nav-center">
				<li>Inventario de materiales y cristaleria</li>
			</ul>
			<div class="navbar-right">
				<a href="#" class="navbar-brand dropdown-toggle"
					data-toggle="dropdown">Usuario <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Fin Nav -->
	
	<div class="row">
		<div class="col-md-offset-2 col-md-8 well">
			<form id="prestamos" class="form-horizontal" method="post">
				<div class="form-group">
					<label for="tipoPrestamo" class="col-sm-2 control-label">Tipo
						prestamo:</label>
					<div class="col-sm-10">
						<select class="form-control">
							<option value="1">Docencia</option>
							<option value="2">Investigacion/Tesis</option>
							<option value="3">Servicios</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="nombre" class="col-sm-2 control-label">Nombre:</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="nombre"
							placeholder="Nombre">
					</div>
					<label for="carnet" class="col-sm-2 control-label">Carnet/DUI:</label>
					<div class="col-sm-2">
						<input type="text" class="form-control" id="carnet"
							placeholder="Carnet">
					</div>
				</div>
				<div class="form-group">
					<label for="nombre" class="col-sm-3 control-label">Tema de
						proyecto / tesis:</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="nombre"
							placeholder="Nombre">
					</div>
				</div>
				<div class="form-group">
					<label for="materia" class="col-sm-2 control-label">Materia:</label>
					<div class="col-sm-4">
						<select class="form-control">
							<option value="0">------- Seleccione una -------</option>
							<option value="1">Química inorgánica 1</option>
							<option value="2">Química inorgánica 2</option>
							<option value="3">Química orgánica</option>
							<option value="4">Productos orgánicos industriales</option>
							<option value="5">Análisis químico</option>
							<option value="6">Procesos de separación</option>
						</select>
					</div>
					<label for="fecha" class="col-sm-2 control-label">fecha:</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="fecha">
					</div>
				</div>
				<div class="form-group">
					<label for="equipo" class="col-sm-2 control-label">Equipo:</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="equipo"
							placeholder="Equipo">
					</div>
					<label for="comentario" class="col-sm-2 control-label">Comentaro:</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="comentario"
							placeholder="Comentario">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-6 control-label"></label>
					<div class="col-sm-6">
						<button type="button" class="btn btn-default mas_equipo"
							aria-label="Left Align" data-toggle="tooltip"
							data-placement="top" title="Agregar equipo">
							<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
						</button>
					</div>
				</div>
				<button type="submit" class="btn btn-default">
					<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
					Guardar
				</button>
			</form>
		</div>
	</div>
	
	<footer class ="navbar-fixed-bottom">
		<div class="col-sm-2">
			<img alt="Logo UCA" src="img/logo.png">
		</div>
		
	</footer>
	<script>
		$('.mas_equipo')
				.click(
						function() {
							console
									.log($(this)
											.parent()
											.parent()
											.before(
													'<div class="form-group">'
															+ '<label for="equipo" class="col-sm-2 control-label"></label>'
															+ ' <div class="col-sm-4">'
															+ '<input type="text" class="form-control" id="equipo1" placeholder="Equipo">'
															+ '</div>'
															+ '<label for="comentario1" class="col-sm-2 control-label"></label>'
															+ '<div class="col-sm-4">'
															+ '<input type="text" class="form-control" id="comentario1" placeholder="Comentario">'
															+ '</div>'
															+ '</div>'));
						});
		$(function() {
			$("#fecha").datepicker({
				dateFormat : 'dd-mm-yy',
				minDate : 1
			});
		});
	</script>
	<script type="text/javascript" src="js/prestamo.js"></script>
</body>
</html>




