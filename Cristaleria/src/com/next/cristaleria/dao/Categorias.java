package com.next.cristaleria.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.next.cristaleria.model.Categoria;

public class Categorias {

	public Categoria insert(Categoria cat) {
		String query = "insert into Categoria(nombreCategoria) values(?)";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setString(1, cat.getNombre());

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			Categoria catN;
			catN = cat;
			if (rs.next()) {
				catN.setId(rs.getLong(1));
			}

			rs.close();
			ps.close();
			Connection.getCon().close();
			return catN;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;

	}

	public boolean delete(Categoria cat) {
		String query = "delete from categoria where idCategoria = ? ";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setLong(1, cat.getId());

			ps.execute();
			ps.close();
			Connection.getCon().close();
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;

	}

	public boolean update(Categoria cat) {
		String query = "update Categoria set nombreCategoria = ? where idCategoria= ?";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setString(1, cat.getNombre());
			ps.setLong(2, cat.getId());

			ps.execute();
			ps.close();
			Connection.getCon().close();
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;

	}

	public ArrayList<Categoria> select(String where) {
		try {
			String query = "SELECT * FROM Categoria " + (where == null ? " " : "WHERE " + where);
			Statement st;

			st = Connection.getCon().createStatement();

			ResultSet rs = st.executeQuery(query);
			ArrayList<Categoria> res = new ArrayList<>();

			while (rs.next()) {
				Categoria cat = new Categoria();

				cat.setId(rs.getLong("idCategoria"));
				cat.setNombre(rs.getString("nombreCategoria"));

				res.add(cat);
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
