package com.next.cristaleria.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.next.cristaleria.model.Material;
import com.next.cristaleria.model.Prestamo;

public class Prestamos {
	
	/**
	 * Inserta en la base de datos un prestamo
	 * Debe estar completamente lleno y existir en la base de datos material, tipoPrestamo , ciclo
	 * para evitar comportamiento inadecuado
	 * @param perstamo
	 * @return El objeto insertado con el id que se le asigno
	 */
	public Prestamo insert(Prestamo prestamo) {
		String query = "insert into prestamo(idTipoPrestamo,prestadoA,fechaPrestamo,fechaDevuelto,razonPrestamo,idMaterial,idCiclo)"
				+ " values(?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setLong(1, prestamo.getTipoPrestamo().getId());
			ps.setString(2, prestamo.getPrestadoA());
			ps.setDate(3, (Date) prestamo.getPrestado());
			ps.setDate(4, (Date) prestamo.getDevuelto());
			ps.setString(5, prestamo.getRazon());
			ps.setLong(6, prestamo.getMaterial().getId());
			ps.setLong(7, prestamo.getCiclo().getId());
			
		
			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			Prestamo prestamoN;
			prestamoN = prestamo;
			
			if (rs.next()) {
				prestamoN.setId(rs.getLong(1));
			}

			rs.close();
			ps.close();
			Connection.getCon().close();
			return prestamoN;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean delete(Prestamo prestamo) {
		String query = "delete from prestamo where idPrestamo = ? ";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setLong(1, prestamo.getId());

			ps.execute();
			ps.close();
			Connection.getCon().close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean update(Prestamo prestamo) {
		String query = "update prestamo set idTipoPrestamo = ?,prestadoA = ?,fechaPrestamo = ?,fechaDevuelto = ?,razonPrestamo = ?,idMaterial = ?,idCiclo = ? where idPrestamo= ?";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setLong(1, prestamo.getTipoPrestamo().getId());
			ps.setString(2, prestamo.getPrestadoA());
			ps.setDate(3, (Date) prestamo.getPrestado());
			ps.setDate(4, (Date) prestamo.getDevuelto());
			ps.setString(5, prestamo.getRazon());
			ps.setLong(6, prestamo.getMaterial().getId());
			ps.setLong(7, prestamo.getCiclo().getId());
			ps.setLong(8, prestamo.getId());

			ps.execute();
			ps.close();
			Connection.getCon().close();
			return true;
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public ArrayList<Prestamo> select(String where) {
		try {
			String query = "SELECT * FROM prestamo WHERE" + where != null ? "1" : where;
			Statement st;

			st = Connection.getCon().createStatement();

			ResultSet rs = st.executeQuery(query);
			ArrayList<Prestamo> res = new ArrayList<>();

			while (rs.next()) {
				Prestamo prestamo = new Prestamo();

				prestamo.setId(rs.getLong("idPrestamo"));
				prestamo.setTipoPrestamo((new TiposPrestamos()).select("idTipoPrestamo = " + rs.getLong("idTipoPrestamo")).get(0));
				prestamo.setPrestadoA(rs.getString("prestadoA"));
				prestamo.setPrestado(rs.getDate("fechaPrestado"));
				prestamo.setDevuelto(rs.getDate("fechaDevuelto"));
				prestamo.setRazon(rs.getString("razonPrestamo"));
				prestamo.setMaterial((new Materiales()).select("idMaterial = " + rs.getLong("idMaterial")).get(0));
				prestamo.setCiclo((new Ciclos()).select("idCiclo = " + rs.getLong("idCiclo")).get(0));
				

				res.add(prestamo);
			}
			rs.close();
			st.close();
			if (!Connection.getCon().isClosed()) Connection.getCon().close();
			return res;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

}
