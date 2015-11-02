package com.next.cristaleria.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/") // desde direccion.com/saludo.action									
@ResultPath(value = "/ejemplo")
@Action(value = "saludo", // nombre de action es decir saludo.action
results = @Result(name = "succes" // valor de respuesta de metodo excute
, location = "saludo.jsp" // si el valor de respuesta fue el anterior
							// se ejecuta /saludo.jsp donde se puede ver
							// todos los atributos que tengan get
) )
public class EjemploActionAnotaciones extends ActionSupport {

	private String mensaje;
	private String nombre;

	@Override
	public String execute() throws Exception {
		mensaje = "hola " + nombre;
		return SUCCESS;
	}

	public String getMensaje() {
		return mensaje;
	}

	// Puede ser resivido por post o por get
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
