package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dto.ConfiguracionDTO;
import modelo.Agenda;
import modelo.LoaderConfiguracion;
import persistencia.configuracion.Configuracion;
import presentacion.vista.VistaConfiguracion;

public class ControladorConfiguracion implements ActionListener {

	private static ControladorConfiguracion instancia;
	private LoaderConfiguracion loaderConfiguracion;
	private VistaConfiguracion vistaConfiguracion;

	private ControladorConfiguracion() {
		loaderConfiguracion = LoaderConfiguracion.getInstance();
		vistaConfiguracion = VistaConfiguracion.getIntance();
		vistaConfiguracion.getBtnCancelar().addActionListener(this);
		vistaConfiguracion.getBtnGuardar().addActionListener(this);
		vistaConfiguracion.getBtnProbarConexion().addActionListener(this);
	}

	public static ControladorConfiguracion getInstance() {
		if (instancia == null)
			instancia = new ControladorConfiguracion();
		return instancia;
	}

	public void inicializar() {
		if (loaderConfiguracion.cargarConfiguracion()) {
			if (loaderConfiguracion.probarConexion() == false || loaderConfiguracion.primeraVez()) {
				JOptionPane.showMessageDialog(null, "Error, los datos de conexión no son válidos.");
				vistaConfiguracion.mostrarVentana();
			}
		} else if (loaderConfiguracion.crearConfiguracionPorDefecto()) {
			inicializar();
		} else {
			JOptionPane.showMessageDialog(null, "Error, No se pudo cargar la configuración por defecto");
			vistaConfiguracion.mostrarVentana();
		}

	}

	public void mostrarVentana() {
		vistaConfiguracion.setConfiguracion(loaderConfiguracion.getConfiguracion());
		vistaConfiguracion.mostrarVentana();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vistaConfiguracion.getBtnGuardar()) {
			loaderConfiguracion.setConfiguracion(vistaConfiguracion.getConfiguracion());
			if (loaderConfiguracion.probarConexion()) {
				if (!loaderConfiguracion.guardarConfiguracion()) {
					JOptionPane.showMessageDialog(null, "Error, No se pudo guardar la configuración.");
				}
				vistaConfiguracion.setVisible(false);
				Agenda.getInstance().notificarObservadores();
				
			} else {
				JOptionPane.showMessageDialog(null, "Error, Los datos de conexión no son válidos.");
				loaderConfiguracion.cargarConfiguracion();
				vistaConfiguracion.mostrarVentana();
			}
		} else if (e.getSource() == vistaConfiguracion.getBtnCancelar()) {
			if (!loaderConfiguracion.probarConexion()) {
				JOptionPane.showMessageDialog(null,
						"Error, Los datos de conexión no son válidos. El programa se cerrará.");
				System.exit(0);
			} else {
				vistaConfiguracion.setVisible(false);
				Agenda.getInstance().notificarObservadores();
			}
		}else {
			loaderConfiguracion.setConfiguracion(vistaConfiguracion.getConfiguracion());
			if(loaderConfiguracion.probarConexion()) {
				JOptionPane.showMessageDialog(null,
						"Prueba de conexión, Conexión exitosa.");
			}else {
				JOptionPane.showMessageDialog(null,
						"Prueba de conexión, Conexión fallida.");
			}
			loaderConfiguracion.cargarConfiguracion();
		}

	}

}
