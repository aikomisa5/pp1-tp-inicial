package persistencia.conexion.mariadb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dto.ConfiguracionDTO;
import persistencia.configuracion.Configuracion;
import persistencia.configuracion.ScriptRunner;

public class Conexion {
	public static Conexion instancia;
	private static Connection conexion;

	private Conexion() throws Exception {
		try {
			ConfiguracionDTO config = Configuracion.getConfiguracion();
			conexion = DriverManager.getConnection("jdbc:mariadb://" + config.getServerUrl() + ":" + config.getServerPuerto() + "/" + config.getBdNombre(),
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
			conexion = DriverManager.getConnection("jdbc:mariadb://" + config.getServerUrl() + ":" + config.getServerPuerto() + "/" + config.getBdNombre(),
					config.getUserName(), config.getUserPass());
		} catch (Exception e) {
			throw new Exception("Conexión fallida");
		}
	}
	
	public static void correrScript(String path)  {
		ScriptRunner runner = new ScriptRunner(conexion, false, false);
		try {
			runner.runScript(new BufferedReader(new FileReader(path)));
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
	
}
