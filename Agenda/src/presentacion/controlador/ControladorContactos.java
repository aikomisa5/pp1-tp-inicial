package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dto.PersonaDTO;
import modelo.Agenda;
import modelo.Validador;
import presentacion.vista.FormularioContactos;

public class ControladorContactos implements ActionListener {
	private static ControladorContactos instancia;
	private static FormularioContactos formularioContactos;
	private static Agenda agenda;
	
	private ControladorContactos() {
		agenda=new Agenda();	
		formularioContactos = new FormularioContactos(this);
	}

	public static ControladorContactos getInstance() {
		if (instancia == null)
			instancia = new ControladorContactos();
		return instancia;
	}

	public void abrirVentana(PersonaDTO persona) {
		abrirformularioContactos(persona);		
	}
	
	private void abrirformularioContactos(PersonaDTO persona) {
		
		formularioContactos.setLocalidad(agenda.getLocalidades());
		formularioContactos.setTiposDeContacto(agenda.getTiposDeContacto());
		formularioContactos.cargarCombos();

		formularioContactos.setPersona(persona);
		formularioContactos.cargarPersonaEnFormulario();

		formularioContactos.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == formularioContactos.getBtnAgregarPersona()) {
			agregarPersona();
		}
		
	}
	
	private void agregarPersona() {
		if (camposSonValidos()) {
			formularioContactos.cargarDatosEnDTO();
			PersonaDTO persona = formularioContactos.getPersona();
			int idDomicilio = agenda.agregarDomicilio(persona.getDomicilio());
			if (idDomicilio != -1) {
				persona.getDomicilio().setIdDomicilio(idDomicilio);
				agenda.agregarPersona(persona);
				//updateTabla();
				formularioContactos.dispose();
			} else {
				JOptionPane.showMessageDialog(formularioContactos,
						"No se pudo agregar el contacto. No se pudo guardar el domicilio", "Error de alta de contacto",
						JOptionPane.ERROR_MESSAGE);

			}
		}
	}

	private boolean camposSonValidos() {
		boolean sonValidos = false;
		if (algunCampoEstaVacio()) {
			JOptionPane.showMessageDialog(formularioContactos, "No se pudo agregar el contacto. Algún campo esta vacio",
					"Error de alta de contacto", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			String nombre = formularioContactos.getTfNombre().getText();
			String telefono = formularioContactos.getTfTelefono().getText();
			String calle = formularioContactos.getTfCalle().getText();
			String altura = formularioContactos.getTfAltura().getText();
			String piso = formularioContactos.getTfPiso().getText();
			String depto = formularioContactos.getTfDepto().getText();
			String email = formularioContactos.getTfEmail().getText();

			sonValidos = Validador.esStringNoEmpezadoEnEspacios(nombre, 45)
					&& Validador.esStringNoEmpezadoEnEspacios(telefono, 20)
					&& Validador.esStringNoEmpezadoEnEspacios(calle, 45) && Validador.esIntValido(altura)
					&& Validador.esIntValido(piso) && Validador.esStringNoEmpezadoEnEspacios(depto, 15)
					&& Validador.esMailValido(email, 45);
		}

		return sonValidos;
	}
	
	private boolean algunCampoEstaVacio() {
		return formularioContactos.getTfAltura().getText().isEmpty() || formularioContactos.getTfCalle().getText().isEmpty()
				|| formularioContactos.getTfDepto().getText().isEmpty() || formularioContactos.getTfEmail().getText().isEmpty()
				|| formularioContactos.getTfTelefono().getText().isEmpty()
				|| formularioContactos.getTfNombre().getText().isEmpty() || formularioContactos.getTfPiso().getText().isEmpty();
	}

}
