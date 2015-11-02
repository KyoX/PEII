<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <!-- Se necesitan estas tag para hacer funcionar struts -->   
 <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ejemplo</title>
</head>
<body>
<!-- Esta accion esta en EjemploActionAnotaciones.java se establece el namespace para evitar errores -->
	<s:form action="saludo" namespace="/"> 
		<s:textfield label="Nombre" name="Nombre"/>
		<s:submit value="Enviar"/>
	</s:form>
</body>
</html>