package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.Agenda;
import modelo.Validador;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.TipoDeContactoDTO;

public class Controlador implements ActionListener {
	private Vista vista;
	private List<PersonaDTO> personasEnTabla;
	private List<LocalidadDTO> localidades;
	private List<TipoDeContactoDTO> tiposDeContacto;
	private VentanaPersona ventanaPersona;
	private Agenda agenda;

	public Controlador(Vista vista, Agenda agenda) {
		this.vista = vista;
		this.vista.getBtnAgregar().addActionListener(this);
		this.vista.getBtnBorrar().addActionListener(this);
		this.vista.getBtnEditar().addActionListener(this);
		this.vista.getBtnReporte().addActionListener(this);
		this.agenda = agenda;
		this.personasEnTabla = null;
		localidades = agenda.getLocalidades();
		tiposDeContacto = agenda.getTiposDeContacto();
	}

	public void inicializar() {
		this.updateTabla();
	}

	private void updateTabla() {
		this.vista.getModelPersonas().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelPersonas().setColumnCount(0);
		this.vista.getModelPersonas().setColumnIdentifiers(this.vista.getNombreColumnas());

		this.personasEnTabla = agenda.obtenerPersonas();
		personasEnTabla.forEach(this::añadirPersonaATabla);

		this.vista.show();
	}

	private void añadirPersonaATabla(PersonaDTO p) {
		Object[] fila = { p.getNombre(), p.getTelefono(), p.getDomicilio().getCalle(), p.getDomicilio().getAltura(),
				p.getDomicilio().getPiso(), p.getDomicilio().getDepartamento(),
				p.getDomicilio().getLocalidad().getNombre(), p.getMail(), p.getFechaCumpleaños(),
				p.getTipoDeContacto().getNombre() };
		vista.getModelPersonas().addRow(fila);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getBtnAgregar()) {
			abrirVentanaPersona(null);
		} else if (e.getSource() == vista.getBtnBorrar()) {

			int indexFilaSeleccionada = vista.getTablaPersonas().getSelectedRow();
			if (indexFilaSeleccionada != -1) {
				borrarPersonasSeleccionadas();
				updateTabla();
			} else
				JOptionPane.showMessageDialog(null, "Selecciona una persona para borrar primero", "Aviso",
						JOptionPane.ERROR_MESSAGE);

		} else if (e.getSource() == vista.getBtnReporte()) {
			ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
			reporte.mostrar();
		} else if (e.getSource() == vista.getBtnEditar()) {
			int indexFilaSeleccionada = vista.getTablaPersonas().getSelectedRow();
			if (indexFilaSeleccionada != -1)
				abrirVentanaPersona(personasEnTabla.get(indexFilaSeleccionada));
			else
				JOptionPane.showMessageDialog(null, "Selecciona una persona para editar primero", "Aviso",
						JOptionPane.ERROR_MESSAGE);
		} else if (e.getSource() == ventanaPersona.getBtnAgregarPersona()) {
			agregarPersona();
		}
	}

	private void agregarPersona() {
		if (camposSonValidos()) {
			ventanaPersona.cargarDatosEnDTO();
			PersonaDTO persona = ventanaPersona.getPersona();
			int idDomicilio = agenda.agregarDomicilio(persona.getDomicilio());
			if (idDomicilio != -1) {
				persona.getDomicilio().setIdDomicilio(idDomicilio);
				agenda.agregarPersona(persona);
				updateTabla();
				ventanaPersona.dispose();
			} else {
				JOptionPane.showMessageDialog(ventanaPersona,
						"No se pudo agregar el contacto. No se pudo guardar el domicilio", "Error de alta de contacto",
						JOptionPane.ERROR_MESSAGE);

			}
		} else {
			JOptionPane.showMessageDialog(ventanaPersona, "No se pudo agregar el contacto. Algún campo esta vacio",
					"Error de alta de contacto", JOptionPane.ERROR_MESSAGE);
		}
	}

	private boolean camposSonValidos() {
		boolean sonValidos = false;
		if (algunCampoEstaVacio())
			return false;
		else {
			String nombre = ventanaPersona.getTfNombre().getText();
			String telefono = ventanaPersona.getTfTelefono().getText();
			String calle = ventanaPersona.getTfCalle().getText();
			String altura = ventanaPersona.getTfAltura().getText();
			String piso = ventanaPersona.getTfPiso().getText();
			String depto = ventanaPersona.getTfDepto().getText();
			String email = ventanaPersona.getTfEmail().getText();

			sonValidos = Validador.esStringNoEmpezadoEnEspacios(nombre, 45)
					&& Validador.esStringNoEmpezadoEnEspacios(telefono, 20)
					&& Validador.esStringNoEmpezadoEnEspacios(calle, 45) && Validador.esIntValido(altura)
					&& Validador.esIntValido(piso) && Validador.esStringNoEmpezadoEnEspacios(depto, 15)
					&& Validador.esMailValido(email, 45);
		}

		return sonValidos;
	}

	private boolean algunCampoEstaVacio() {
		return ventanaPersona.getTfAltura().getText().isEmpty() || ventanaPersona.getTfCalle().getText().isEmpty()
				|| ventanaPersona.getTfDepto().getText().isEmpty() || ventanaPersona.getTfEmail().getText().isEmpty()
				|| ventanaPersona.getTfTelefono().getText().isEmpty()
				|| ventanaPersona.getTfNombre().getText().isEmpty() || ventanaPersona.getTfPiso().getText().isEmpty();
	}

	private void borrarPersonasSeleccionadas() {
		int[] filas_seleccionadas = this.vista.getTablaPersonas().getSelectedRows();
		for (int fila : filas_seleccionadas) {
			this.agenda.borrarPersona(this.personasEnTabla.get(fila));
		}
	}

	private void abrirVentanaPersona(PersonaDTO persona) {
		ventanaPersona = new VentanaPersona(this);

		ventanaPersona.setLocalidad(localidades);
		ventanaPersona.setTiposDeContacto(tiposDeContacto);
		ventanaPersona.cargarCombos();

		ventanaPersona.setPersona(persona);
		ventanaPersona.cargarPersonaEnFormulario();

		ventanaPersona.setVisible(true);
	}

}
