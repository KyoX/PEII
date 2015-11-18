package com.next.cristaleria.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.next.cristaleria.model.Ciclo;

public class Ciclos {
	public Ciclo insert(Ciclo ciclo) {
		String query = "insert into ciclo(anhioCiclo,periodo) values(?,?)";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setInt(1, ciclo.getAnho());
			ps.setInt(2, ciclo.getPerido());

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			Ciclo cicloN;
			cicloN = ciclo;
			if (rs.next()) {
				cicloN.setId(rs.getLong(1));
			}

			
			return cicloN;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean delete(Ciclo ciclo) {
		String query = "delete from ciclo where idCiclo = ? ";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setLong(1, ciclo.getId());

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean update(Ciclo ciclo) {
		String query = "update ciclo set anhioCiclo = ? set periodo = ? where idCiclo= ?";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setInt(1, ciclo.getAnho());
			ps.setInt(2, ciclo.getPerido());
			ps.setLong(3, ciclo.getId());

			
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;

	}

	public ArrayList<Ciclo> select(String where) {
		try {
			String query = "SELECT * FROM ciclo" + (where == null ? " " : " WHERE " + where);
			Statement st;

			st = Connection.getCon().createStatement();

			ResultSet rs = st.executeQuery(query);
			ArrayList<Ciclo> res = new ArrayList<>();

			while (rs.next()) {
				Ciclo ciclo = new Ciclo();

				ciclo.setId(rs.getLong("idCiclo"));
				ciclo.setAnho(rs.getInt("anhioCiclo"));
				ciclo.setPerido(rs.getInt("periodo"));

				res.add(ciclo);
			}
			return res;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

}
