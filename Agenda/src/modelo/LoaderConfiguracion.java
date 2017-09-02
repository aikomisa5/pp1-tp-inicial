package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import dto.ConfiguracionDTO;
import persistencia.conexion.mysql.Conexion;
import persistencia.configuracion.Configuracion;

public class LoaderConfiguracion {
	private static LoaderConfiguracion instancia;
	
	private LoaderConfiguracion() {
		super();
	}
	
	public static LoaderConfiguracion getInstance() {
		if (instancia == null)
			instancia = new LoaderConfiguracion();
		return instancia;
	}

	public boolean cargarConfiguracion() {
		try {
			Configuracion.cargarConfiguracion();
			return true;
		} catch (FileNotFoundException e) {
			return false;
		}
	}

	public boolean crearConfiguracionPorDefecto() {
		try {
			Configuracion.crearArchivoConfiguracionDefault();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	public boolean probarConexion() {
		boolean ret = false;
		try {
			Conexion.probarConexion();
			ret = true;
		} catch (Exception e) {
			return false;
		}
		return ret;
	}
	
	public void setConfiguracion(ConfiguracionDTO configuracion) {
		Configuracion.setConfiguracion(configuracion);
	}
	
	public boolean guardarConfiguracion() {
		try {
			Configuracion.guardarConfiguracion();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	public ConfiguracionDTO getConfiguracion() {
		return Configuracion.getConfiguracion();
	}

}
