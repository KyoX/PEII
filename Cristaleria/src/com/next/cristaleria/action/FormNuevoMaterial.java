package com.next.cristaleria.action;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.next.cristaleria.dao.Categorias;
import com.next.cristaleria.dao.Ciclos;
import com.next.cristaleria.dao.Marcas;
import com.next.cristaleria.dao.Materiales;
import com.next.cristaleria.dao.Proveedores;
import com.next.cristaleria.dao.TiposMateriales;
import com.next.cristaleria.model.Categoria;
import com.next.cristaleria.model.Ciclo;
import com.next.cristaleria.model.Marca;
import com.next.cristaleria.model.Material;
import com.next.cristaleria.model.Proveedor;
import com.next.cristaleria.model.TipoMaterial;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/")
@ResultPath(value = "/")
@Action(value = "*", results = @Result(name = "success", location = "entradaMateriales.jsp") )
//El * significa que si entra a cualquier cosa se dirigira a esta actio
//solamente si no se pide un action espesifico
public class FormNuevoMaterial extends ActionSupport {

	private ArrayList<Marca> marcas;
	private ArrayList<Proveedor> proveedores;
	private ArrayList<TipoMaterial> tiposMateriales;
	private ArrayList<Categoria> categorias;
	private ArrayList<Ciclo> ciclo;
	private HashMap<Integer, String> estados;
	private HashMap<Integer, String> tipoEntradas;
	private ArrayList<Material> materiales;
	
	@Override
	public String execute() throws Exception {

		marcas = (new Marcas()).select(null);
		proveedores = (new Proveedores()).select(null);
		tiposMateriales = (new TiposMateriales()).select(null);
		categorias = (new Categorias()).select(null);
		ciclo = (new Ciclos()).select(null);
		
		Field[] estado = Material.class.getFields();
		estados = new HashMap<Integer,String>();
		tipoEntradas = new HashMap<Integer,String>();
		
		materiales = (new Materiales()).select(null);
		
		for (Field f : estado) {
			if( f.getName().contains("ESTADO"))
				estados.put(f.getInt(null), f.getName().replace("ESTADO_", "").toLowerCase());
			if( f.getName().contains("ENTRADA"))
				tipoEntradas.put(f.getInt(null), f.getName().replace("ENTRADA_", "").toLowerCase());
			System.out.println(f.getName());
			System.out.println(f.getInt(null));
		}
		
		return SUCCESS;
	}

	/**
	 * @return the marcas
	 */
	public ArrayList<Marca> getMarcas() {
		return marcas;
	}

	/**
	 * @return the proveedores
	 */
	public ArrayList<Proveedor> getProveedores() {
		return proveedores;
	}

	/**
	 * @return the estados
	 */
	public HashMap<Integer, String> getEstados() {
		return estados;
	}

	/**
	 * @return the tipoEntradas
	 */
	public HashMap<Integer, String> getTipoEntradas() {
		return tipoEntradas;
	}

	/**
	 * @return the tiposMateriales
	 */
	public ArrayList<TipoMaterial> getTiposMateriales() {
		return tiposMateriales;
	}

	/**
	 * @return the categorias
	 */
	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}

	/**
	 * @return the ciclo
	 */
	public ArrayList<Ciclo> getCiclo() {
		return ciclo;
	}

	/**
	 * @return the materiales
	 */
	public ArrayList<Material> getMateriales() {
		return materiales;
	}
	
	

}
