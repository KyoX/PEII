package com.next.cristaleria.action;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.next.cristaleria.dao.SubCategorias;
import com.next.cristaleria.model.SubCategoria;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@ParentPackage("json-default")
@Namespace("/")
@ResultPath(value =  "/")
@Action(value = "getSubCategoria", results = { @Result(name = "success", type="json")})
public class ListaSubCategoria extends ActionSupport {
	private ArrayList<SubCategoria> SubCategoria;
	private int idCategoria;
	
	@Override
	public String execute(){
		SubCategoria = (new SubCategorias()).select("idCategoria = " +idCategoria);
		return SUCCESS;
		
	}

	/**
	 * @return the subCategoria
	 */
	public ArrayList<SubCategoria> getSubCategoria() {
		return SubCategoria;
	}

	/**
	 * @param idCategoria the idCategoria to set
	 */
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	
	
}
