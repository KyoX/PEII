package com.next.cristaleria.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.next.cristaleria.model.MaterialXPrestamo;
import com.next.cristaleria.model.Prestamo;

public class MaterialXPrestamoDao {
	

	public MaterialXPrestamo insert(MaterialXPrestamo materialXPrestamo) {
		String query ="INSERT INTO material_x_prestamo (idMaterial, idPrestamo, comentario) VALUES (?,?,?)";
		
		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setLong(1, materialXPrestamo.getMaterial().getId());
			ps.setLong(2, materialXPrestamo.getPrestamo().getId());
			ps.setString(3, materialXPrestamo.getComentario());
			
			ps.execute();

			return materialXPrestamo;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}

