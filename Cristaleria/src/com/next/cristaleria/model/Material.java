package com.next.cristaleria.model;

import java.util.Date;

public class Material {
	private long id;
	private String nombre;
	private Marca marca;
	private Ciclo ciclo;
	private Proveedor proveedor;
	private TipoMaterial tipoMaterial;
	private Date entrada;
	private Date desecho;
	private String detalleEntrada;
	private String detalleSalida;
	private String ubicacion;

	/**
	 * 
	 */
	public Material() {
		super();
	}

	/**
	 * @param id
	 * @param nombre
	 * @param marca
	 * @param ciclo
	 * @param proveedor
	 * @param tipoMaterial
	 * @param entrada
	 * @param desecho
	 * @param detalleEntrada
	 * @param detalleSalida
	 * @param ubicacion
	 */
	public Material(long id, String nombre, Marca marca, Ciclo ciclo, Proveedor proveedor, TipoMaterial tipoMaterial,
			Date entrada, Date desecho, String detalleEntrada, String detalleSalida, String ubicacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.ciclo = ciclo;
		this.proveedor = proveedor;
		this.tipoMaterial = tipoMaterial;
		this.entrada = entrada;
		this.desecho = desecho;
		this.detalleEntrada = detalleEntrada;
		this.detalleSalida = detalleSalida;
		this.ubicacion = ubicacion;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the marca
	 */
	public Marca getMarca() {
		return marca;
	}

	/**
	 * @param marca
	 *            the marca to set
	 */
	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	/**
	 * @return the ciclo
	 */
	public Ciclo getCiclo() {
		return ciclo;
	}

	/**
	 * @param ciclo
	 *            the ciclo to set
	 */
	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * @return the proveedor
	 */
	public Proveedor getProveedor() {
		return proveedor;
	}

	/**
	 * @param proveedor
	 *            the proveedor to set
	 */
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	/**
	 * @return the tipoMaterial
	 */
	public TipoMaterial getTipoMaterial() {
		return tipoMaterial;
	}

	/**
	 * @param tipoMaterial
	 *            the tipoMaterial to set
	 */
	public void setTipoMaterial(TipoMaterial tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}

	/**
	 * @return the entrada
	 */
	public Date getEntrada() {
		return entrada;
	}

	/**
	 * @param entrada
	 *            the entrada to set
	 */
	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	/**
	 * @return the desecho
	 */
	public Date getDesecho() {
		return desecho;
	}

	/**
	 * @param desecho
	 *            the desecho to set
	 */
	public void setDesecho(Date desecho) {
		this.desecho = desecho;
	}

	/**
	 * @return the detalleEntrada
	 */
	public String getDetalleEntrada() {
		return detalleEntrada;
	}

	/**
	 * @param detalleEntrada
	 *            the detalleEntrada to set
	 */
	public void setDetalleEntrada(String detalleEntrada) {
		this.detalleEntrada = detalleEntrada;
	}

	/**
	 * @return the detalleSalida
	 */
	public String getDetalleSalida() {
		return detalleSalida;
	}

	/**
	 * @param detalleSalida
	 *            the detalleSalida to set
	 */
	public void setDetalleSalida(String detalleSalida) {
		this.detalleSalida = detalleSalida;
	}

	/**
	 * @return the ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion
	 *            the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ciclo == null) ? 0 : ciclo.hashCode());
		result = prime * result + ((desecho == null) ? 0 : desecho.hashCode());
		result = prime * result + ((detalleEntrada == null) ? 0 : detalleEntrada.hashCode());
		result = prime * result + ((detalleSalida == null) ? 0 : detalleSalida.hashCode());
		result = prime * result + ((entrada == null) ? 0 : entrada.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((proveedor == null) ? 0 : proveedor.hashCode());
		result = prime * result + ((tipoMaterial == null) ? 0 : tipoMaterial.hashCode());
		result = prime * result + ((ubicacion == null) ? 0 : ubicacion.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (ciclo == null) {
			if (other.ciclo != null)
				return false;
		} else if (!ciclo.equals(other.ciclo))
			return false;
		if (desecho == null) {
			if (other.desecho != null)
				return false;
		} else if (!desecho.equals(other.desecho))
			return false;
		if (detalleEntrada == null) {
			if (other.detalleEntrada != null)
				return false;
		} else if (!detalleEntrada.equals(other.detalleEntrada))
			return false;
		if (detalleSalida == null) {
			if (other.detalleSalida != null)
				return false;
		} else if (!detalleSalida.equals(other.detalleSalida))
			return false;
		if (entrada == null) {
			if (other.entrada != null)
				return false;
		} else if (!entrada.equals(other.entrada))
			return false;
		if (id != other.id)
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (proveedor == null) {
			if (other.proveedor != null)
				return false;
		} else if (!proveedor.equals(other.proveedor))
			return false;
		if (tipoMaterial == null) {
			if (other.tipoMaterial != null)
				return false;
		} else if (!tipoMaterial.equals(other.tipoMaterial))
			return false;
		if (ubicacion == null) {
			if (other.ubicacion != null)
				return false;
		} else if (!ubicacion.equals(other.ubicacion))
			return false;
		return true;
	}

}
