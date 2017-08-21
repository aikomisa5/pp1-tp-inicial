
package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.JXDatePicker;

import dto.DomicilioDTO;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.TipoDeContactoDTO;
import presentacion.controlador.ControladorPrincipal;
import java.awt.Color;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JComboBox;

public class VentanaPersona extends JFrame {
	private PersonaDTO persona = null;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAgregarPersona;
	private ControladorPrincipal controlador;
	private JTextField tfNombre;
	private JTextField tfTelefono;
	private JTextField tfCalle;
	private JTextField tfAltura;
	private JTextField tfPiso;
	private JTextField tfDepto;
	private JTextField tfEmail;
	private JXDatePicker datePicker;
	private JComboBox<String> comboLocalidad;
	private JComboBox<String> comboTipoDeContacto;

	private List<LocalidadDTO> localidades = null;

	// TODO crear método para agregar esta lista de localidades a la bd.
	/*
	 * { "17 de Agosto", "25 de Mayo", "9 de Julio / La Niña", "Acassuso",
	 * "Aguas Verdes", "Alberti", "Arenas Verdes", "Arrecifes", "Avellaneda",
	 * "Ayacucho", "Azul", "Bahía Blanca", "Bahía San Blas", "Balcarce",
	 * "Balneario Marisol", "Balneario Orense", "Balneario Reta",
	 * "Balneario San Cayetano", "Baradero", "Bella Vista", "Benito Juárez",
	 * "Berazategui", "Berisso", "Boulogne", "Bragado", "Brandsen", "Campana",
	 * "Capilla del Señor", "Capital Federal", "Capitán Sarmiento", "Carapachay",
	 * "Carhue", "Carhué", "Carlos Keen", "Carmen de Areco", "Carmen de Patagones",
	 * "Caseros", "Castelar", "Castelli", "Chacabuco", "Chascomús", "Chivilcoy",
	 * "City Bell", "Ciudadela", "Claromecó", "Colón", "Coronel Dorrego",
	 * "Coronel Pringles", "Coronel Suárez", "Darregueira", "Dunamar", "Escobar",
	 * "Ezeiza", "Florencio Varela", "Florida", "Fortín Mercedes", "Garin",
	 * "General Arenales", "General Belgrano", "General Madariaga",
	 * "General Villegas", "Gral. Daniel Cerri", "Gran Buenos Aires", "Guaminí",
	 * "Haedo", "Huanguelen", "Hurlingham", "Isla Martín García", "Ituzaingo",
	 * "Junín", "La Plata", "La Tablada", "Laferrere", "Lanus", "Laprida",
	 * "Las Flores", "Las Gaviotas", "Las Toninas", "Lima", "Lisandro Olmos",
	 * "Llavallol", "Lobos", "Lomas de Zamora", "Los Toldos - Gral. Viamonte",
	 * "Los Polvorines", "Lucila del Mar", "Luis Guillón", "Luján", "Magdalena",
	 * "Maipú", "Mar Azul", "Mar Chiquita", "Mar de Ajó", "Mar de Cobo",
	 * "Mar del Plata", "Mar del Sud", "Mar del Tuyú", "Martinez",
	 * "Médanos / Laguna Chasicó", "Mercedes", "Merlo", "Miramar", "Monte Hermoso",
	 * "Moreno", "Morón", "Munro", "Navarro", "Necochea", "Nueva Atlantis",
	 * "Olavarría", "Olivos", "Open Door", "Ostende", "Pedro Luro", "Pehuajó",
	 * "Pehuen Có", "Pergamino", "Pigüé", "Pilar", "Pinamar",
	 * "Provincia de Buenos Aires", "Puan", "Punta Alta", "Punta Indio",
	 * "Punta Lara", "Quequén", "Quilmes", "Ramallo", "Ramos Mejía", "Ranchos",
	 * "Rauch", "Rivadavia", "Rojas", "Roque Pérez", "Saenz Peña", "Saladillo",
	 * "Salto", "San Antonio de Areco", "San Bernardo", "San Cayetano",
	 * "San Clemente del Tuyú", "San Fernando", "San Isidro", "San Justo",
	 * "San Martin", "San Miguel del Monte", "San Nicolás", "San Pedro",
	 * "San Vicente", "Santa Clara del Mar", "Santa Teresita", "Sarandí",
	 * "Sierra de la Ventana", "Sierra de los Padres", "Sierras de los Padres",
	 * "Tandil", "Tapalqué", "Temperley", "Tigre", "Tornquist / Ruta Prov. 76",
	 * "Trenque Lauquen", "Tres Arroyos", "Turdera", "Valentin Alsina",
	 * "Vicente Lopez", "Victoria", "Villa Ballester", "Villa Gesell",
	 * "Villa Lynch", "Villa Serrana La Gruta", "Villa Ventana", "Villalonga",
	 * "Wilde", "Zárate" };
	 */

	private List<TipoDeContactoDTO> tiposDeContacto = null;

	private String[] comboLocalidadItems;

	private String[] comboTipoDeContactoItems;

	private JPanel panel;

	public VentanaPersona(ControladorPrincipal controlador) {
		super();
		this.controlador = controlador;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 409, 462);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 307, 402);
		contentPane.add(panel);
		panel.setLayout(null);

		datePicker = new JXDatePicker();
		datePicker.setBounds(133, 257, 164, 22);
		datePicker.setVisible(true);
		panel.add(datePicker);

		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(20, 14, 113, 14);
		panel.add(lblNombreYApellido);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(20, 45, 113, 14);
		panel.add(lblTelfono);

		tfNombre = new JTextField();
		tfNombre.setBounds(133, 11, 164, 20);
		panel.add(tfNombre);
		tfNombre.setColumns(10);

		tfTelefono = new JTextField();
		tfTelefono.setBounds(133, 42, 164, 20);
		panel.add(tfTelefono);
		tfTelefono.setColumns(10);

		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.addActionListener(this.controlador);
		btnAgregarPersona.setBounds(34, 375, 89, 23);
		panel.add(btnAgregarPersona);

		tfCalle = new JTextField();
		tfCalle.setColumns(10);
		tfCalle.setBounds(133, 73, 164, 20);
		panel.add(tfCalle);

		tfAltura = new JTextField();
		tfAltura.setColumns(10);
		tfAltura.setBounds(133, 104, 164, 20);
		panel.add(tfAltura);

		tfPiso = new JTextField();
		tfPiso.setColumns(10);
		tfPiso.setBounds(133, 135, 164, 20);
		panel.add(tfPiso);

		tfDepto = new JTextField();
		tfDepto.setColumns(10);
		tfDepto.setBounds(133, 165, 164, 20);
		panel.add(tfDepto);

		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(20, 76, 113, 14);
		panel.add(lblCalle);

		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(20, 107, 113, 14);
		panel.add(lblAltura);

		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(20, 138, 113, 14);
		panel.add(lblPiso);

		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(20, 168, 113, 14);
		panel.add(lblDepartamento);

		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(20, 199, 113, 14);
		panel.add(lblLocalidad);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(133, 227, 164, 20);
		panel.add(tfEmail);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(20, 230, 113, 14);
		panel.add(lblEmail);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setBounds(20, 260, 113, 14);
		panel.add(lblFechaDeNacimiento);

		JLabel label_2 = new JLabel("Localidad");
		label_2.setBounds(20, 291, 113, 14);
		panel.add(label_2);

		JLabel lblTipoDeContacto = new JLabel("Tipo de Contacto");
		lblTipoDeContacto.setBounds(20, 323, 113, 14);
		panel.add(lblTipoDeContacto);

		this.setVisible(true);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JComboBox<String> getComboLocalidad() {
		return comboLocalidad;
	}

	public JComboBox<String> getComboTipoDeContacto() {
		return comboTipoDeContacto;
	}

	public JXDatePicker getDatePicker() {
		return datePicker;
	}

	public JTextField getTfNombre() {
		return tfNombre;
	}

	public JTextField getTfTelefono() {
		return tfTelefono;
	}

	public JTextField getTfCalle() {
		return tfCalle;
	}

	public JTextField getTfAltura() {
		return tfAltura;
	}

	public JTextField getTfPiso() {
		return tfPiso;
	}

	public JTextField getTfDepto() {
		return tfDepto;
	}

	public JTextField getTfEmail() {
		return tfEmail;
	}

	public JButton getBtnAgregarPersona() {
		return btnAgregarPersona;
	}

	public PersonaDTO getPersona() {
		return persona;
	}

	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}

	public void cargarPersonaEnFormulario() {
		// TODO Auto-generated method stub

	}

	public void cargarDatosEnDTO() {
		if (persona == null)
			persona = new PersonaDTO(0);

		LocalidadDTO localidadSeleccionada = getLocalidadSeleccionada();
		TipoDeContactoDTO tipoDeContactoSeleccionado = getTipoDeContactoSeleccionado();

		persona.setDomicilio(new DomicilioDTO(tfCalle.getText(), Integer.parseInt(tfAltura.getText()),
				Integer.parseInt(tfPiso.getText()), tfDepto.getText(), localidadSeleccionada));
		java.util.Date date = datePicker.getDate();
		LocalDate ldate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		persona.setFechaCumpleaños(java.sql.Date.valueOf(ldate));
		persona.setMail(tfEmail.getText());
		persona.setNombre(tfNombre.getText());
		persona.setTelefono(tfTelefono.getText());
		persona.setTipoDeContacto(tipoDeContactoSeleccionado);
	}

	private LocalidadDTO getLocalidadSeleccionada() {
		String stringLocalidadSeleccionada = comboLocalidad.getItemAt(comboLocalidad.getSelectedIndex());
		LocalidadDTO l = null;
		LocalidadDTO unaLocalidad = null;
		boolean encontro = false;
		for (Iterator<LocalidadDTO> it = localidades.iterator(); !encontro && it.hasNext();) {
			unaLocalidad = it.next();
			if (unaLocalidad.toString().equals(stringLocalidadSeleccionada)) {
				l = unaLocalidad;
				encontro = true;
			}
		}
		return l;
	}

	private TipoDeContactoDTO getTipoDeContactoSeleccionado() {
		String stringTipoDeContactoSeleccionado = comboTipoDeContacto.getItemAt(comboTipoDeContacto.getSelectedIndex());
		TipoDeContactoDTO t = null;
		TipoDeContactoDTO unTipoDeContacto = null;
		boolean encontro = false;
		for (Iterator<TipoDeContactoDTO> it = tiposDeContacto.iterator(); !encontro && it.hasNext();) {
			unTipoDeContacto = it.next();
			if (unTipoDeContacto.toString().equals(stringTipoDeContactoSeleccionado)) {
				t = unTipoDeContacto;
				encontro = true;
			}
		}
		return t;
	}

	public void setLocalidad(List<LocalidadDTO> localidades) {
		this.localidades = localidades;
	}

	public void setTiposDeContacto(List<TipoDeContactoDTO> tiposDeContacto) {
		this.tiposDeContacto = tiposDeContacto;
	}

	public void cargarCombos() {

		List<String> listaLocalidades = localidades.stream().map(l -> l.toString()).collect(Collectors.toList());
		comboLocalidadItems = new String[listaLocalidades.size()];
		comboLocalidadItems = listaLocalidades.toArray(comboLocalidadItems);

		comboLocalidad = new JComboBox<>(comboLocalidadItems);
		comboLocalidad.setBounds(133, 288, 164, 20);
		panel.add(comboLocalidad);

		List<String> listaTiposDeContacto = tiposDeContacto.stream().map(l -> l.toString())
				.collect(Collectors.toList());
		comboTipoDeContactoItems = new String[listaTiposDeContacto.size()];
		comboTipoDeContactoItems = listaTiposDeContacto.toArray(comboLocalidadItems);
		comboTipoDeContacto = new JComboBox<>(comboTipoDeContactoItems);
		comboTipoDeContacto.setBounds(133, 320, 164, 20);
		panel.add(comboTipoDeContacto);
	}

}
