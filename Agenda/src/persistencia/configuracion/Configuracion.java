package persistencia.configuracion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import dto.ConfiguracionDTO;

public class Configuracion {
	private static Properties p = new Properties();
	public static final String PARAM_FILE = "properties" + File.separator + "Agenda.properties";

	public static final String serverUrl = "server.url";
	public static final String serverPuerto = "server.puerto";
	public static final String bdNombre = "bd.nombre";
	public static final String userName = "user.name";
	public static final String userPass = "user.pass";

	public static void crearArchivoConfiguracionDefault() throws IOException {
		ConfiguracionDTO configuracion = new ConfiguracionDTO("localhost", "3306", "tpi_g2", "root", "root");
		setConfiguracion(configuracion);
		guardarConfiguracion();
	}

	public static void cargarConfiguracion() throws FileNotFoundException {
		try {
			FileInputStream fis = new FileInputStream(PARAM_FILE);
			p.load(fis);
		} catch (Exception e) {
			throw new FileNotFoundException();
		}

	}

	public static ConfiguracionDTO getConfiguracion() {
		return new ConfiguracionDTO(p.getProperty(serverUrl), p.getProperty(serverPuerto), p.getProperty(bdNombre), p.getProperty(userName), p.getProperty(userPass));
	}

	public static void setConfiguracion(ConfiguracionDTO configuracion) {
		Configuracion.p.setProperty(serverUrl, configuracion.getServerUrl());
		Configuracion.p.setProperty(serverPuerto, configuracion.getServerPuerto());
		Configuracion.p.setProperty(bdNombre, configuracion.getBdNombre());
		Configuracion.p.setProperty(userName, configuracion.getUserName());
		Configuracion.p.setProperty(userPass, configuracion.getUserPass());	
	}

	public static void guardarConfiguracion() throws IOException {
		try {
			p.store(new FileOutputStream(PARAM_FILE), "");
		} catch (IOException e) {
			throw e;
		}
	}

}