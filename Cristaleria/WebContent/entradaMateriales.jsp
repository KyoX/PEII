<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>

<head>
<meta charset="UTF-8">

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

	<input type="text" name="user" id="user" value="user"
		style="display: none;" />
	<!--[if lt IE 10]>
            <p class="chromeframe">Estas usando un navegador <strong>desactualizado</strong>. Por favor <a href="http://browsehappy.com/">actualiza tu navegador</a></p>
        <![endif]-->
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
				<li><a href="entradaMateriales.html"> Nuevo Material</a></li>
				<li><a href="prestamo.html"> Prestamo Material</a></li>
				<li><a href="salidaMateriales.html"> Otras Salidas</a></li>
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

	<br>
	<br>
	<!--
	<div class="row">
		<div id="logo">
			<img src="img/UCA2015.png" alt="UCA logo" height="125px"
				width="100px">
			<h1>Universidad centroamericana Jose Simeon Cañas</h1>
			<h2>Departamento de Ingenieria de Procesos y Ciencias
				Ambientales</h2>
			<h5>LABORATORIO DE TECNOLOGIA DE PROCESOS</h5>
			<h5>Ficha de entrada de materiales</h5>
		</div>
	</div> 
	-->
	<div id="wrapper2" class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8 well">
			<form id="nuevoMaterial" class="form-horizontal" method="post">

				<div class="form-group">
					<label for="nombreMaterial" class="col-sm-3 control-label">Nombre
						material:</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="nombreMaterial"
							placeholder="Material" required="required">
					</div>
				</div>
				<div class="form-group">
					<label for="marcaProducto" class="col-sm-2 control-label">Marca:</label>
					<div class="col-sm-4">
						<select class="form-control" id="marcaMaterial">
							<s:iterator value="marcas">
								<option value='<s:property value="id"/>'><s:property
										value="nombre" /></option>
							</s:iterator>
						</select>
					</div>
					<label for="proveedorProducto" class="col-sm-2 control-label">Proveedor:</label>
					<div class="col-sm-4">
						<select class="form-control" id="proveedorProducto">
							<s:iterator value="proveedores">
								<option value='<s:property value = "id"/>'><s:property
										value="nombre" /></option>
							</s:iterator>
						</select>
					</div>

				</div>
				<div class="form-group">
					<label for="status" class="col-sm-2 control-label">Estado:</label>
					<div class="col-sm-2">
						<select class="form-control" id="status">
							<s:iterator value="estados">
								<option value='<s:property value = "key"/>'><s:property
										value="value" /></option>
							</s:iterator>
						</select>
					</div>
					<label for="categoria" class="col-sm-2 control-label">Categoria:</label>
					<div class="col-sm-2">
						<select class="form-control" id="categoria">
							<s:iterator value="categorias">
								<option value='<s:property value = "id"/>'><s:property
										value="nombre" /></option>
							</s:iterator>
						</select>
					</div>
					<label for="subCategoria" class="col-sm-2 control-label">Sub categoria:</label>
					<div class="col-sm-2">
						<select class="form-control" id="subCategoria">
							<s:iterator value="tiposMateriales">
								<option value='<s:property value = "id"/>'>
								
									<s:property
										value="nombre" /></option>
							</s:iterator>
						</select>
					</div>

				</div>
				<div class="form-group">
					<label for="tipoEntrada" class="col-sm-2 control-label">Tipo
						entrada:</label>
					<div class="col-sm-2">
						<select class="form-control" id="tipoEntrada">
							<s:iterator value="tipoEntradas">
								<option value='<s:property value = "key"/>'><s:property
										value="value" /></option>
							</s:iterator>
						</select>
					</div>
					<label for="detalleTipoEntrada" class="col-sm-4 control-label">Detalle
						entrada:</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="detalleTipoEntrada"
							placeholder="Detalle entrada" required="required">
					</div>

				</div>
				<div class="form-group">
					<label for="ubicacion" class="col-sm-2 control-label">Ubicacion:</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="ubicacion"
							placeholder="Ubicacion">
					</div>
					<label for="ciclo" class="col-sm-2 control-label">Ciclo:</label>
					<div class="col-sm-4">
						<div class="col-sm-12">
							<select class="form-control" id="ciclo">
								<s:iterator value="ciclo">
									<option value='<s:property value = "id"/>'><s:property
											value="perido" /> / <s:property value="anho"/></option>
								</s:iterator>
							</select>
						</div>
					</div>

				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-default">
						<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
						Guardar
					</button>
				</div>

			</form>
		</div>
		<div class="col-md-2"></div>
	</div>
	
	<div class="row">
		<table class="table table-condensed scroll" style = ''>
			<tr>
				<th> Material </th>
				<th> Marca </th>
				<th> Proveedor </th>
				<th> Estado </th>
				<th> Categoria </th>
				<th> SubCategoria </th>
				<th> Entrada Por </th>
				<th> Detalle entrada</th>
				<th> Fecha </th>
				<th> Ubicacion </th>
			</tr>
			<s:iterator value="materiales">
				<tr>
					<td>
						<s:property value = "nombre" />
					</td>
					<td>
						<s:property value = "marca.nombre" />
					</td> 
					<td>
						<s:property value = "proveedor.nombre" />
					</td> 
					<td>
						<s:if test = "estado ==  1" >
							Nuevo
						</s:if>
						<s:elseif test="estado == 2">
							Prestado
						</s:elseif>
						<s:elseif test="estado == 2">
							Desechado
						</s:elseif>
						<s:else>
							Desnocido
						</s:else>
					</td> 
					<td>
						<s:property value = "tipoMaterial.categoria.nombre" />
					</td>
					<td>
						<s:property value = "tipoMaterial.subCategoria.nombre" />
					</td>
					<td>
						<s:if test = " tipoEntrada ==  1" >
							Donación 
						</s:if>
						<s:elseif test="tipoEntrada == 2">
							Compra
						</s:elseif>
					</td>
					<td>
						<s:if test="detalleEntrada == null || detalleEntrada == \"\"">
							Sin Información
						</s:if>
						<s:property value ="detalleEntrada"/>
					</td>
					<td>
						<s:property value ="entrada"/>
					</td>
					<td>
						<s:if test="ubicacion == null || ubicacion == \"\" ">
							Sin Información
						</s:if>
						<s:property value ="ubicacion"/>
					</td>
				</tr>
			</s:iterator>
		</table>
	</div>

	<script type="text/javascript" src="js/subCategoria.js"></script>
	<script type="text/javascript" src="js/nuevoMaterial.js"></script>
</body>
</html>




