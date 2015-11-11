package com.next.cristaleria.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.next.cristaleria.model.Marca;
import com.next.cristaleria.model.Material;

public class Materiales {

	/**
	 * Para poder insertar un material debe existir en la base previamente el
	 * porvedor, marca, ciclo y tipoMatrial. Este metodo no valida la existencia
	 * de los elementos anteriores y podria tener un comportamiente indesiado de
	 * no verificar la existencia de porvedor, marca, ciclo y tipoMatrial
	 * 
	 * @param material
	 * @return Material insertado con id corespendiente
	 */
	public Material insert(Material material) {
		String query = "insert into material"
				+ "(nombreMaterial,idMarca,idCiclo,idProveedor,idTipoMaterial,fechaEntrada,fechaDesecho,estado,detalleEntrada,detalleSalida,ubicacion) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setString(1, material.getNombre());
			ps.setLong(2, material.getMarca().getId());
			ps.setLong(3, material.getCiclo().getId());
			ps.setLong(4, material.getProveedor().getId());
			ps.setLong(5, material.getTipoMaterial().getId());
			ps.setDate(6, (Date) material.getEntrada());
			ps.setDate(7, (Date) material.getDesecho());
			ps.setInt(8, material.getEstado());
			ps.setString(9, material.getDetalleEntrada());
			ps.setString(10, material.getDetalleSalida());
			ps.setString(11, material.getUbicacion());
			
			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			Material materialN;
			materialN = material;

			if (rs.next()) {
				materialN.setId(rs.getLong(1));
			}

			rs.close();
			ps.close();
			Connection.getCon().close();
			return materialN;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean delete(Material material) {
		String query = "delete from material where idMateria = ? ";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setLong(1, material.getId());

			ps.execute();
			ps.close();
			Connection.getCon().close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	
	/**
	 *  Todo los datos del material debe estar llenos en el objeto para evitar incocistencia en la base de
	 *  datos
	 * @param marca
	 * @return true si se actualiza 
	 */
	public boolean update(Material material) {
		String query = "update material set nombreMaterial = ? ,idMarca = ?,idCiclo = ?,idProveedor = ?,idTipoMaterial = ?,fechaEntrada = ?,fechaDesecho = ?,estado = ?,detalleEntrada = ?,detalleSalida = ?,ubicacion = ? where idMaterial= ?";

		try {
			PreparedStatement ps = Connection.getCon().prepareStatement(query);
			ps.setString(1, material.getNombre());
			ps.setLong(2, material.getMarca().getId());
			ps.setLong(3, material.getCiclo().getId());
			ps.setLong(4, material.getProveedor().getId());
			ps.setLong(5, material.getTipoMaterial().getId());
			ps.setDate(6, (Date) material.getEntrada());
			ps.setDate(7, (Date) material.getDesecho());
			ps.setInt(8, material.getEstado());
			ps.setString(9, material.getDetalleEntrada());
			ps.setString(10, material.getDetalleSalida());
			ps.setString(11, material.getUbicacion());
			ps.setLong(12, material.getId());

			ps.execute();
			ps.close();
			Connection.getCon().close();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	/**
	 * Obtiene toda la informacion de los materiales que cumplan la condicion
	 * @param where puede ser null para no filtrar o una condicion por ejemplo idMaterial = 1
	 * @return Lista de objetos Material, El objeto Material esta completamete lleno
	 */
	public ArrayList<Material> select(String where) {
		try {
			String query = "SELECT * FROM Material WHERE" + where != null ? "1" : where;
			Statement st;

			st = Connection.getCon().createStatement();

			ResultSet rs = st.executeQuery(query);
			ArrayList<Material> res = new ArrayList<>();

			while (rs.next()) {
				Material material = new Material();
				
				material.setId(rs.getLong("idMaterial"));
				material.setNombre(rs.getString("nombreMaterial"));
				material.setMarca(new Marcas().select("idMarca = " + rs.getLong("idMaterial")).get(0));
				material.setCiclo(new Ciclos().select("idCiclo = " + rs.getLong("idCiclo")).get(0));
				material.setProveedor((new Proveedores()).select("idPorveedor = " + rs.getLong("idProveedro")).get(0));
				material.setTipoMaterial((new TiposMateriales()).select("idTipoMaterial = " + rs.getLong("idTipoMaterial")).get(0));
				material.setEntrada(rs.getDate("fechaEntrada"));
				material.setDesecho(rs.getDate("fechaDesecho"));
				material.setEstado(rs.getInt("estado"));
				material.setDetalleEntrada(rs.getString("detalleEntrada"));
				material.setDetalleSalida(rs.getString("detalleSalida"));
				material.setUbicacion(rs.getString("ubicacion"));

				res.add(material);
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
