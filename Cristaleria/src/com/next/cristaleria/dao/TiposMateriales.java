package com.next.cristaleria.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.next.cristaleria.model.Categoria;
import com.next.cristaleria.model.TipoMaterial;

public class TiposMateriales {
	public TipoMaterial insert(TipoMaterial tipoMaterial) {
		
		String query = "insert into tipomaterial(idSubCategoria,idCategoria) values(?,?)";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setLong(1, tipoMaterial.getSubCategoria().getId());
			ps.setLong(2, tipoMaterial.getCategoria().getId());
					
			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			TipoMaterial tipoMaterialN;
			tipoMaterialN = tipoMaterial;
			
			if (rs.next()) {
				tipoMaterialN.setId(rs.getLong(1));
			}

			rs.close();
			ps.close();
			Connection.getCon().close();
			return tipoMaterialN;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean delete(TipoMaterial tipoMaterial) {
		String query = "delete from tipoMaterial where idTipoMaterial = ? ";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setLong(1, tipoMaterial.getId());

			ps.execute();
			ps.close();
			Connection.getCon().close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean update(TipoMaterial tipoMaterial) {
		String query = "update tipoMaterial set idSubCategoria = ? , idCategoria  = ? where idTipoMaterial= ?";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setLong(1, tipoMaterial.getCategoria().getId());
			ps.setLong(2, tipoMaterial.getSubCategoria().getId());
			ps.setLong(3, tipoMaterial.getId());
			
			

			ps.execute();
			ps.close();
			Connection.getCon().close();
			return true;
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public ArrayList<TipoMaterial> select(String where) {
		try {
			String query = "SELECT * FROM TipoMaterial WHERE" + where != null ? "1" : where;
			Statement st;

			st = Connection.getCon().createStatement();

			ResultSet rs = st.executeQuery(query);
			ArrayList<TipoMaterial> res = new ArrayList<>();

			while (rs.next()) {
				TipoMaterial tipoMaterial = new TipoMaterial();

				tipoMaterial.setId(rs.getLong("idTipoMaterial"));
				tipoMaterial.setCategoria((new Categorias()).select("idCategoria = " +  rs.getLong("idCategoria")).get(0));
				tipoMaterial.setSubCategoria((new SubCategorias()).select("idSubCategoria = " +  rs.getLong("idSubCategoria")).get(0));
				res.add(tipoMaterial);
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
