package com.next.cristaleria.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
	private static  java.sql.Connection con;
	private static String server = "localhost", dataBase = "material_peii", usuario = "root", password = "";
	private static int puerto = 3306;

	/**
	 * @return the con
	 */
	public static java.sql.Connection getCon() {
		try {
			if (con == null || con.isClosed()) {

				try {

					Class.forName("com.mysql.jdbc.Driver");

					con = DriverManager.getConnection("jdbc:mysql://" + server + ":"+puerto+"/" + dataBase, usuario, password);

				} catch (ClassNotFoundException e) {
					System.err.println("No se encuetra la librebira " + "com.mysql.jdbc.Driver");
					e.printStackTrace();
				} catch (SQLException e) {
					System.err.println("No se puede conectar a la base datos revise credenciales");
					e.printStackTrace();
				}

			}
		} catch (SQLException e) {
			System.err.println("Al preguntar si la coneccion esta cerrada");
			e.printStackTrace();
		}
		return con;
	}

	
	/**
	 * @return the puerto
	 */
	public static int getPuerto() {
		return puerto;
	}


	/**
	 * @param puerto the puerto to set
	 */
	public static void setPuerto(int puerto) {
		Connection.puerto = puerto;
	}


	/**
	 * @return the server
	 */
	public static String getServer() {
		return server;
	}

	/**
	 * @param server
	 *            the server to set
	 */
	public static void setServer(String server) {
		Connection.server = server;
	}

	/**
	 * @return the dataBase
	 */
	public static String getDataBase() {
		return dataBase;
	}

	/**
	 * @param dataBase
	 *            the dataBase to set
	 */
	public static void setDataBase(String dataBase) {
		Connection.dataBase = dataBase;
	}

	/**
	 * @return the usuario
	 */
	public static String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public static void setUsuario(String usuario) {
		Connection.usuario = usuario;
	}

	/**
	 * @return the password
	 */
	public static String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public static void setPassword(String password) {
		Connection.password = password;
	}

}
