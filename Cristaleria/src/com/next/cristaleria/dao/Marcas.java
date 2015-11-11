package com.next.cristaleria.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.next.cristaleria.model.Marca;

public class Marcas {
	public Marca insert(Marca marca) {
		String query = "insert into marca(nombreMarca) values(?)";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setString(1, marca.getNombre());
		
			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			Marca marcaN;
			marcaN = marca;
			
			if (rs.next()) {
				marcaN.setId(rs.getLong(1));
			}

			rs.close();
			ps.close();
			Connection.getCon().close();
			return marcaN;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean delete(Marca marca) {
		String query = "delete from marca where idMarca = ? ";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setLong(1, marca.getId());

			ps.execute();
			ps.close();
			Connection.getCon().close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean update(Marca marca) {
		String query = "update ciclo set nombreMarca = ? where idMarca= ?";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setString(1, marca.getNombre());
			ps.setLong(2, marca.getId());
			
			

			ps.execute();
			ps.close();
			Connection.getCon().close();
			return true;
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public ArrayList<Marca> select(String where) {
		try {
			String query = "SELECT * FROM marca WHERE" + where != null ? "1" : where;
			Statement st;

			st = Connection.getCon().createStatement();

			ResultSet rs = st.executeQuery(query);
			ArrayList<Marca> res = new ArrayList<>();

			while (rs.next()) {
				Marca marca = new Marca();

				marca.setId(rs.getLong("idMarca"));
				marca.setNombre(rs.getString("nombreMarca"));
				

				res.add(marca);
			}
			rs.close();
			st.close();
			Connection.getCon().close();
			return res;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

}
