package com.next.cristaleria.model;

public class Ciclo {
	private long id;
	private int anho;
	private int perido;

	/**
	 * 
	 */
	public Ciclo() {
		super();
	}

	/**
	 * @param id
	 * @param anho
	 * @param perido
	 */
	public Ciclo(long id, int anho, int perido) {
		super();
		this.id = id;
		this.anho = anho;
		this.perido = perido;
	}

	/**
	 * @return the anho
	 */
	public int getAnho() {
		return anho;
	}

	/**
	 * @param anho
	 *            the anho to set
	 */
	public void setAnho(int anho) {
		this.anho = anho;
	}

	/**
	 * @return the perido
	 */
	public int getPerido() {
		return perido;
	}

	/**
	 * @param perido
	 *            the perido to set
	 */
	public void setPerido(int perido) {
		this.perido = perido;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anho;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + perido;
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
		Ciclo other = (Ciclo) obj;
		if (anho != other.anho)
			return false;
		if (id != other.id)
			return false;
		if (perido != other.perido)
			return false;
		return true;
	}

}
