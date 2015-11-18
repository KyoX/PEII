package com.next.cristaleria.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.next.cristaleria.model.TipoPrestamo;

public class TiposPrestamos {
	public TipoPrestamo insert(TipoPrestamo tipoPrestamo) {
		String query = "insert into TipoPrestamo(nombreTipo) values(?)";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setString(1, tipoPrestamo.getNombre());
		
			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			TipoPrestamo tipoPrestamoN;
			tipoPrestamoN = tipoPrestamo;
			
			if (rs.next()) {
				tipoPrestamoN.setId(rs.getLong(1));
			}

			
			return tipoPrestamoN;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean delete(TipoPrestamo tipoPrestamo) {
		String query = "delete from tipoPrestamo where idTipoPrestamo = ? ";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setLong(1, tipoPrestamo.getId());

			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean update(TipoPrestamo tipoPrestamo) {
		String query = "update TipoPrestamo set nombreTipo = ? where idTipoPrestamo= ?";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setString(1, tipoPrestamo.getNombre());
			ps.setLong(2, tipoPrestamo.getId());
			
			
			return true;
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public ArrayList<TipoPrestamo> select(String where) {
		try {
			String query = "SELECT * FROM marca" + (where == null ? " " : " WHERE " + where);
			Statement st;

			st = Connection.getCon().createStatement();

			ResultSet rs = st.executeQuery(query);
			ArrayList<TipoPrestamo> res = new ArrayList<>();

			while (rs.next()) {
				TipoPrestamo tipoPrestamo = new TipoPrestamo();

				tipoPrestamo.setId(rs.getLong("idTipoPrestamo"));
				tipoPrestamo.setNombre(rs.getString("nombreTipo"));
				

				res.add(tipoPrestamo);
			}
			return res;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

}
