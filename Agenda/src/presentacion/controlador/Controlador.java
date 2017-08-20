package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import dto.DomicilioDTO;
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
			borrarPersonasSeleccionadas();
			updateTabla();

		} else if (e.getSource() == vista.getBtnReporte()) {
			ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
			reporte.mostrar();
		} else if (e.getSource() == ventanaPersona.getBtnAgregarPersona()) {
			agregarPersona();
			updateTabla();
			ventanaPersona.dispose();
		} else if (e.getSource() == vista.getBtnEditar()) {
			int indexFilaSeleccionada = vista.getTablaPersonas().getSelectedRow();
			abrirVentanaPersona(personasEnTabla.get(indexFilaSeleccionada));			
		}
	}

	private void agregarPersona() {
		if(camposSonValidos()) {
			ventanaPersona.cargarDatosEnDTO();
			agenda.agregarPersona(ventanaPersona.getPersona());
		}		
	}

	private boolean camposSonValidos() {
		// TODO efectuar validación
		boolean sonValidos = true;		
		return sonValidos;
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
