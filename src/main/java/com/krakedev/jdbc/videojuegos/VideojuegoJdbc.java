
package com.krakedev.jdbc.videojuegos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.krakedev.jdbc.Conexion;
import com.krakedev.videojuegos.entidades.Videojuego;

public class VideojuegoJdbc {

	private static final Logger log = LoggerFactory.getLogger(VideojuegoJdbc.class);

	// Metodo para insertar un videojuego
	public static Videojuego insertar(Videojuego videojuego) {

		Connection con = null;
		PreparedStatement ps = null;
		Videojuego video = null;

		try {
			con = Conexion.getConnection();

			String sql = """
					insert into videojuegos(codigo, nombre, plataforma, precio, disponible, genero)
					values(?, ?, ?, ?, ?, ?)
					""";

			ps = con.prepareStatement(sql);

			ps.setString(1, videojuego.getCodigo());
			ps.setString(2, videojuego.getNombre());
			ps.setString(3, videojuego.getPlataforma());
			ps.setDouble(4, videojuego.getPrecio());
			ps.setBoolean(5, videojuego.isDisponible());
			ps.setString(6, videojuego.getGenero());

			int filas = ps.executeUpdate();

			if (filas > 0) {
				video = videojuego;
			}

			log.info("Filas guardadas: " + filas);

		} catch (Exception e) {
			log.error("Error al insertar videojuego", e);
			throw new RuntimeException("Error al insertar videojuego: " + e.getMessage());

		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				log.error("Error al cerrar la conexion", e);
			}
		}

		return video;
	}

	// Metodo para listar videojuegos
	public static List<Videojuego> listar() {

		List<Videojuego> videojuegos = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = Conexion.getConnection();

			String sql = """
					select * from videojuegos
					""";

			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Videojuego v = new Videojuego(rs.getString("codigo"), rs.getString("nombre"),
						rs.getString("plataforma"), rs.getDouble("precio"), rs.getBoolean("disponible"),
						rs.getString("genero"));

				videojuegos.add(v);
			}

			log.info("Lista de videojuegos obtenida: " + videojuegos.size());

		} catch (Exception e) {
			log.error("Error al listar videojuegos", e);
			throw new RuntimeException("Error al listar videojuegos: " + e.getMessage());

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				log.error("Error al cerrar la conexion", e);
			}
		}

		return videojuegos;
	}

	// Buscar videojuego por codigo

	public static Videojuego buscar(String codigo) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Videojuego videojuego = null;

		try {
			con = Conexion.getConnection();

			String sql = "select * from videojuegos where codigo = ?";

			ps = con.prepareStatement(sql);
			ps.setString(1, codigo);
			rs = ps.executeQuery();

			if (rs.next()) {
				videojuego = new Videojuego(rs.getString("codigo"), rs.getString("nombre"), rs.getString("plataforma"),
						rs.getDouble("precio"), rs.getBoolean("disponible"), rs.getString("genero"));
			}

		} catch (Exception e) {
			log.error("Error al buscar videojuego por codigo", e);

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				log.error("Error al cerrar la conexion", e);
			}
		}

		return videojuego;
	}

	// Actualizar videojuego

	public static Videojuego actualizar(Videojuego videojuego) {
		Connection con = null;
		PreparedStatement ps = null;
		Videojuego video = null;

		try {
			con = Conexion.getConnection();

			String sql = """
					update videojuegos
					set nombre = ?, plataforma = ?, precio = ?, disponible = ?, genero = ?
					where codigo = ?
					""";

			ps = con.prepareStatement(sql);
			ps.setString(1, videojuego.getNombre());
			ps.setString(2, videojuego.getPlataforma());
			ps.setDouble(3, videojuego.getPrecio());
			ps.setBoolean(4, videojuego.isDisponible());
			ps.setString(5, videojuego.getGenero());
			ps.setString(6, videojuego.getCodigo());

			int filas = ps.executeUpdate();

			if (filas > 0) {
				video = videojuego;
			}

			log.info("Filas actualizadas: " + filas);

		} catch (Exception e) {
			log.error("Error al actualizar videojuego", e);
			throw new RuntimeException("Error al actualizar videojuego: " + e.getMessage());

		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				log.error("Error al cerrar la conexión: " + e.getMessage());
			}
		}

		return video;
	}

	// Metodo delete o borrar videojuego

	public static boolean eliminar(String codigo) {
		Connection con = null;
		PreparedStatement ps = null;
		boolean eliminado = false;

		try {
			con = Conexion.getConnection();

			String sql = "delete from videojuegos where codigo = ?";

			ps = con.prepareStatement(sql);
			ps.setString(1, codigo);

			int filas = ps.executeUpdate();

			if (filas > 0) {
				eliminado = true;
			}

			log.info("Filas eliminadas: " + filas);

		} catch (Exception e) {
			log.error("Error al eliminar videojuego", e);
			throw new RuntimeException("Error al eliminar videojuego: " + e.getMessage());

		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				log.error("Error al cerrar la conexión: " + e.getMessage());
			}
		}

		return eliminado;
	}

}
