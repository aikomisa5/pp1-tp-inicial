package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import dto.PersonaDTO;

public class Controlador implements ActionListener {
	private Vista vista;
	private List<PersonaDTO> personasEnTabla;
	private VentanaPersona ventanaPersona;
	private Agenda agenda;

	public Controlador(Vista vista, Agenda agenda) {
		this.vista = vista;
		this.vista.getBtnAgregar().addActionListener(this);
		this.vista.getBtnBorrar().addActionListener(this);
		this.vista.getBtnReporte().addActionListener(this);
		this.agenda = agenda;
		this.personasEnTabla = null;
	}

	public void inicializar() {
		this.llenarTabla();
	}

	private void llenarTabla() {
		this.vista.getModelPersonas().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelPersonas().setColumnCount(0);
		this.vista.getModelPersonas().setColumnIdentifiers(this.vista.getNombreColumnas());
		this.personasEnTabla = agenda.obtenerPersonas();
		personasEnTabla.forEach(p -> {
			Object[] fila = { p.getNombre(), p.getTelefono(), p.getDomicilio().getCalle(), p.getDomicilio().getAltura(),
					p.getDomicilio().getPiso(), p.getDomicilio().getDepartamento(),
					p.getDomicilio().getLocalidad().getNombre(), p.getMail(), p.getFechaCumpleaños(),
					p.getTipoDeContacto().getNombre() };
			vista.getModelPersonas().addRow(fila);
		});
		this.vista.show();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.vista.getBtnAgregar()) {
			this.ventanaPersona = new VentanaPersona(this);
			this.ventanaPersona.setVisible(true);
		} else if (e.getSource() == this.vista.getBtnBorrar()) {
			int[] filas_seleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			for (int fila : filas_seleccionadas) {
				this.agenda.borrarPersona(this.personasEnTabla.get(fila));
			}

			this.llenarTabla();

		} else if (e.getSource() == this.vista.getBtnReporte()) {
			ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
			reporte.mostrar();
		} else if (e.getSource() == this.ventanaPersona.getBtnAgregarPersona()) {
			this.llenarTabla();
			this.ventanaPersona.dispose();
		} else if (e.getSource() == this.vista.getBtnEditar()) {
			PersonaDTO nuevaPersona = new PersonaDTO(0, this.ventanaPersona.getTfNombre().getText(),
					ventanaPersona.getTfTelefono().getText());
			this.agenda.agregarPersona(nuevaPersona);
			this.llenarTabla();
			this.ventanaPersona.dispose();
		}
	}

}
