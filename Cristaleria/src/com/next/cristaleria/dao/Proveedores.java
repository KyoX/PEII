package com.next.cristaleria.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.next.cristaleria.model.Proveedor;;



public class Proveedores {
	public Proveedor insert(Proveedor proveedor) {
		String query = "insert into Proveedor(nombreProveedor) values(?)";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setString(1, proveedor.getNombre());
		
			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			Proveedor proveedorN;
			proveedorN = proveedor;
			
			if (rs.next()) {
				proveedorN.setId(rs.getLong(1));
			}

			rs.close();
			ps.close();
			Connection.getCon().close();
			return proveedorN;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean delete(Proveedor proveedor) {
		String query = "delete from proveedor where idProveedor = ? ";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setLong(1, proveedor.getId());

			ps.execute();
			ps.close();
			Connection.getCon().close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean update(Proveedor proveedor) {
		String query = "update proveedor set nombreProveedor = ? where idProveedor= ?";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setString(1, proveedor.getNombre());
			ps.setLong(2, proveedor.getId());
			
			
			ps.execute();
			ps.close();
			Connection.getCon().close();
			return true;
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public ArrayList<Proveedor> select(String where) {
		try {
			String query = "SELECT * FROM Proveedor WHERE" + where != null ? "1" : where;
			Statement st;

			st = Connection.getCon().createStatement();

			ResultSet rs = st.executeQuery(query);
			ArrayList<Proveedor> res = new ArrayList<>();

			while (rs.next()) {
				Proveedor proveedor = new Proveedor();

				proveedor.setId(rs.getLong("idProveedor"));
				proveedor.setNombre(rs.getString("nombreProveedor"));
				

				res.add(proveedor);
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
