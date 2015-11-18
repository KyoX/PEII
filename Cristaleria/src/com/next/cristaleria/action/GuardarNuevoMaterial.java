package com.next.cristaleria.action;

import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.next.cristaleria.dao.Materiales;
import com.next.cristaleria.dao.TiposMateriales;
import com.next.cristaleria.model.Ciclo;
import com.next.cristaleria.model.Marca;
import com.next.cristaleria.model.Material;
import com.next.cristaleria.model.Proveedor;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@ParentPackage("json-default")
@Namespace("/")
@ResultPath(value =  "/")
@Action(value = "guardarNuevoMaterial", results = { @Result(name = "success", type="json")})
public class GuardarNuevoMaterial extends ActionSupport {
	private String nombreMaterial, detalleTipoEntrada, ubicacion;
	private int idMarca , idProveedores, idEstado, idCategoria, idSubCategoria,idTipoEntrada, idCiclo;
	private boolean guardado;
	
	public String execute(){
		Material nuevo =  new Material();
		
		nuevo.setNombre(nombreMaterial);
		nuevo.setDetalleEntrada(detalleTipoEntrada);
		nuevo.setEntrada(new Date());
		nuevo.setUbicacion(ubicacion);
		nuevo.setMarca(new Marca());
		nuevo.getMarca().setId(idMarca);
		nuevo.setProveedor(new Proveedor());
		nuevo.getProveedor().setId(idProveedores);
		nuevo.setEstado(idEstado);
		nuevo.setTipoMaterial(
				(new TiposMateriales())
					.select("idSubCategoria = " + idSubCategoria +" and idCategoria = " + idCategoria)
					.get(0)
				);
		nuevo.setTipoEntrada(idTipoEntrada);
		nuevo.setCiclo(new Ciclo());
		nuevo.getCiclo().setId(idCiclo);
		
		guardado = false;
		
		nuevo = (new Materiales()).insert(nuevo);
		System.out.println(nuevo.getId());
		guardado = true;
		return SUCCESS;
		
	}
	
	
	/**
	 * @return the guardado
	 */
	public boolean isGuardado() {
		return guardado;
	}


	/**
	 * @param nombreMaterial the nombreMaterial to set
	 */
	public void setNombreMaterial(String nombreMaterial) {
		this.nombreMaterial = nombreMaterial;
	}
	/**
	 * @param detalleTipoEntrada the detalleTipoEntrada to set
	 */
	public void setDetalleTipoEntrada(String detalleTipoEntrada) {
		this.detalleTipoEntrada = detalleTipoEntrada;
	}
	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	/**
	 * @param idMarca the idMarca to set
	 */
	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	/**
	 * @param idProveedores the idProveedores to set
	 */
	public void setIdProveedores(int idProveedores) {
		this.idProveedores = idProveedores;
	}
	/**
	 * @param idEstado the idEstado to set
	 */
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	/**
	 * @param idCategoria the idCategoria to set
	 */
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	/**
	 * @param idSubCategoria the idSubCategoria to set
	 */
	public void setIdSubCategoria(int idSubCategoria) {
		this.idSubCategoria = idSubCategoria;
	}
	/**
	 * @param idTipoEntrada the idTipoEntrada to set
	 */
	public void setIdTipoEntrada(int idTipoEntrada) {
		this.idTipoEntrada = idTipoEntrada;
	}
	/**
	 * @param idCiclo the idCiclo to set
	 */
	public void setIdCiclo(int idCiclo) {
		this.idCiclo = idCiclo;
	}
	
	
	
}
