package com.next.cristaleria.model;

import java.util.Date;

public class Prestamo {
	private long id;
	private TipoPrestamo tipoPrestamo;
	private String prestadoA;
	private String documento;
	private Date prestado;
	private Date devuelto;
	private String razon;
	private long materia;
	private Ciclo ciclo;

	/**
	 * 
	 */
	public Prestamo() {
		super();
	}

	/**
	 * @param id
	 * @param prestamo
	 * @param prestadoA
	 * @param documento
	 * @param prestado
	 * @param devuelto
	 * @param razon
	 * @param materia
	 * @param ciclo
	 */
	public Prestamo(long id, TipoPrestamo prestamo, String prestadoA,String documento, Date prestado, Date devuelto, String razon,
			long materia, Ciclo ciclo) {
		super();
		this.id = id;
		this.tipoPrestamo = prestamo;
		this.prestadoA = prestadoA;
		this.prestado = prestado;
		this.devuelto = devuelto;
		this.razon = razon;
		this.materia = materia;
		this.ciclo = ciclo;
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
	 * @return the TipoPrestamo
	 */
	public TipoPrestamo getTipoPrestamo() {
		return tipoPrestamo;
	}

	/**
	 * @param prestamo
	 *            the tipoPrestamo to set
	 */
	public void setTipoPrestamo(TipoPrestamo tipoPrestamo) {
		this.tipoPrestamo = tipoPrestamo;
	}

	/**
	 * @return the prestadoA
	 */
	public String getPrestadoA() {
		return prestadoA;
	}

	/**
	 * @param prestadoA
	 *            the prestadoA to set
	 */
	public void setPrestadoA(String prestadoA) {
		this.prestadoA = prestadoA;
	}

	/**
	 * @return the prestado
	 */
	public Date getPrestado() {
		return prestado;
	}

	/**
	 * @param prestado
	 *            the prestado to set
	 */
	public void setPrestado(Date prestado) {
		this.prestado = prestado;
	}

	/**
	 * @return the devuelto
	 */
	public Date getDevuelto() {
		return devuelto;
	}

	/**
	 * @param devuelto
	 *            the devuelto to set
	 */
	public void setDevuelto(Date devuelto) {
		this.devuelto = devuelto;
	}

	/**
	 * @return the razon
	 */
	public String getRazon() {
		return razon;
	}

	/**
	 * @param razon
	 *            the razon to set
	 */
	public void setRazon(String razon) {
		this.razon = razon;
	}

	/**
	 * @return the material
	 */
	public long getMateria() {
		return materia;
	}

	/**
	 * @param material
	 *            the material to set
	 */
	public void setMateria(long materia) {
		this.materia = materia;
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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
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
		result = prime * result + ((devuelto == null) ? 0 : devuelto.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result +  (int) (materia ^ (id >>> 32));
		result = prime * result + ((prestado == null) ? 0 : prestado.hashCode());
		result = prime * result + ((prestadoA == null) ? 0 : prestadoA.hashCode());
		result = prime * result + ((tipoPrestamo == null) ? 0 : tipoPrestamo.hashCode());
		result = prime * result + ((razon == null) ? 0 : razon.hashCode());
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
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
		Prestamo other = (Prestamo) obj;
		if (ciclo == null) {
			if (other.ciclo != null)
				return false;
		} else if (!ciclo.equals(other.ciclo))
			return false;
		if (devuelto == null) {
			if (other.devuelto != null)
				return false;
		} else if (!devuelto.equals(other.devuelto))
			return false;
		if (id != other.id)
			return false;
		if (materia != other.materia)
			return false;
		if (prestado == null) {
			if (other.prestado != null)
				return false;
		} else if (!prestado.equals(other.prestado))
			return false;
		if (prestadoA == null) {
			if (other.prestadoA != null)
				return false;
		} else if (!prestadoA.equals(other.prestadoA))
			return false;
		if (tipoPrestamo == null) {
			if (other.tipoPrestamo != null)
				return false;
		} else if (!tipoPrestamo.equals(other.tipoPrestamo))
			return false;
		if (razon == null) {
			if (other.razon != null)
				return false;
		} else if (!razon.equals(other.razon))
			return false;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		return true;
	}

}
