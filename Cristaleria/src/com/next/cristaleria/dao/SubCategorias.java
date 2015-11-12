package com.next.cristaleria.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.next.cristaleria.model.Categoria;
import com.next.cristaleria.model.SubCategoria;

public class SubCategorias {
	
	public SubCategoria insert(SubCategoria sCat) {
		String query = "insert into SubCategoria(idCategoria,nombreSubCategoria) values(?,?)";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setLong(1, sCat.getPrincipal().getId());
			ps.setString(2, sCat.getNombre());

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			SubCategoria sCatN;
			sCatN = sCat;
			if (rs.next()) {
				sCatN.setId(rs.getLong(1));
			}

			rs.close();
			ps.close();
			Connection.getCon().close();
			return sCatN;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;

	}

	public boolean delete(SubCategoria sCat) {
		String query = "delete from Subcategoria where idSubCategoria = ? ";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setLong(1, sCat.getId());

			ps.execute();
			ps.close();
			Connection.getCon().close();
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;

	}

	public boolean update(SubCategoria sCat) {
		
		String query = "update SubCategoria set nombreSubCategoria = ?, idCategoria = ? where idSubCategoria= ?";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setString(1, sCat.getNombre());
			ps.setLong(2, sCat.getPrincipal().getId());
			ps.setLong(3, sCat.getId());

			ps.execute();
			ps.close();
			Connection.getCon().close();
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;

	}

	public ArrayList<SubCategoria> select(String where) {
		try {
			String query = "SELECT * FROM SubCategoria" + (where == null ? " " : "WHERE " + where);
			Statement st;

			st = Connection.getCon().createStatement();

			ResultSet rs = st.executeQuery(query);
			ArrayList<SubCategoria> res = new ArrayList<>();

			while (rs.next()) {
				SubCategoria sCat = new SubCategoria();

				sCat.setId(rs.getLong("idSubCategoria"));
				sCat.setNombre(rs.getString("nombreSubCategoria"));
				sCat.setPrincipal((new Categorias()).select("idCategoria = " + rs.getString("idCategoria")).get(0));

				res.add(sCat);
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
