package persistencia.conexion;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;

import dto.ConfiguracionDTO;
import persistencia.configuracion.Configuracion;

public class Conexion {
	public static Conexion instancia;
	private static Connection conexion;

	private Conexion() throws Exception {
		try {
			ConfiguracionDTO config = Configuracion.getConfiguracion();
			conexion = DriverManager.getConnection("jdbc:mysql://" + config.getServerUrl() + ":" + config.getServerPuerto() + "/" + config.getBdNombre(),
					config.getUserName(), config.getUserPass());
		} catch (Exception e) {
			throw new Exception("Conexión fallida");
		}
	}

	public static Conexion getConexion() throws Exception {
		if (instancia == null) {
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() {
		return conexion;
	}

	public void cerrarConexion() {
		instancia = null;
	}

	public static void probarConexion() throws Exception {
		try {
			ConfiguracionDTO config = Configuracion.getConfiguracion();
			conexion = DriverManager.getConnection("jdbc:mysql://" + config.getServerUrl() + ":" + config.getServerPuerto() + "/" + config.getBdNombre(),
					config.getUserName(), config.getUserPass());
		} catch (Exception e) {
			throw new Exception("Conexión fallida");
		}
	}
}
