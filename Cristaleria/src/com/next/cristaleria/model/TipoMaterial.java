package com.next.cristaleria.model;

public class TipoMaterial {
	private long id;
	private Categoria categoria;
	private SubCategoria subCategoria;

	/**
	 * 
	 */
	public TipoMaterial() {
		super();
	}

	/**
	 * @param id
	 * @param categoria
	 * @param subCategoria
	 */
	public TipoMaterial(long id, Categoria categoria, SubCategoria subCategoria) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.subCategoria = subCategoria;
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
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria
	 *            the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the subCategoria
	 */
	public SubCategoria getSubCategoria() {
		return subCategoria;
	}

	/**
	 * @param subCategoria
	 *            the subCategoria to set
	 */
	public void setSubCategoria(SubCategoria subCategoria) {
		this.subCategoria = subCategoria;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((subCategoria == null) ? 0 : subCategoria.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		TipoMaterial other = (TipoMaterial) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (id != other.id)
			return false;
		if (subCategoria == null) {
			if (other.subCategoria != null)
				return false;
		} else if (!subCategoria.equals(other.subCategoria))
			return false;
		return true;
	}
	
	

}
