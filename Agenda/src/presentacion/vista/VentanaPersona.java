
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

	// TODO crear m�todo para agregar esta lista de localidades a la bd.
	/*
	 * { "17 de Agosto", "25 de Mayo", "9 de Julio / La Ni�a", "Acassuso",
	 * "Aguas Verdes", "Alberti", "Arenas Verdes", "Arrecifes", "Avellaneda",
	 * "Ayacucho", "Azul", "Bah�a Blanca", "Bah�a San Blas", "Balcarce",
	 * "Balneario Marisol", "Balneario Orense", "Balneario Reta",
	 * "Balneario San Cayetano", "Baradero", "Bella Vista", "Benito Ju�rez",
	 * "Berazategui", "Berisso", "Boulogne", "Bragado", "Brandsen", "Campana",
	 * "Capilla del Se�or", "Capital Federal", "Capit�n Sarmiento", "Carapachay",
	 * "Carhue", "Carhu�", "Carlos Keen", "Carmen de Areco", "Carmen de Patagones",
	 * "Caseros", "Castelar", "Castelli", "Chacabuco", "Chascom�s", "Chivilcoy",
	 * "City Bell", "Ciudadela", "Claromec�", "Col�n", "Coronel Dorrego",
	 * "Coronel Pringles", "Coronel Su�rez", "Darregueira", "Dunamar", "Escobar",
	 * "Ezeiza", "Florencio Varela", "Florida", "Fort�n Mercedes", "Garin",
	 * "General Arenales", "General Belgrano", "General Madariaga",
	 * "General Villegas", "Gral. Daniel Cerri", "Gran Buenos Aires", "Guamin�",
	 * "Haedo", "Huanguelen", "Hurlingham", "Isla Mart�n Garc�a", "Ituzaingo",
	 * "Jun�n", "La Plata", "La Tablada", "Laferrere", "Lanus", "Laprida",
	 * "Las Flores", "Las Gaviotas", "Las Toninas", "Lima", "Lisandro Olmos",
	 * "Llavallol", "Lobos", "Lomas de Zamora", "Los Toldos - Gral. Viamonte",
	 * "Los Polvorines", "Lucila del Mar", "Luis Guill�n", "Luj�n", "Magdalena",
	 * "Maip�", "Mar Azul", "Mar Chiquita", "Mar de Aj�", "Mar de Cobo",
	 * "Mar del Plata", "Mar del Sud", "Mar del Tuy�", "Martinez",
	 * "M�danos / Laguna Chasic�", "Mercedes", "Merlo", "Miramar", "Monte Hermoso",
	 * "Moreno", "Mor�n", "Munro", "Navarro", "Necochea", "Nueva Atlantis",
	 * "Olavarr�a", "Olivos", "Open Door", "Ostende", "Pedro Luro", "Pehuaj�",
	 * "Pehuen C�", "Pergamino", "Pig��", "Pilar", "Pinamar",
	 * "Provincia de Buenos Aires", "Puan", "Punta Alta", "Punta Indio",
	 * "Punta Lara", "Quequ�n", "Quilmes", "Ramallo", "Ramos Mej�a", "Ranchos",
	 * "Rauch", "Rivadavia", "Rojas", "Roque P�rez", "Saenz Pe�a", "Saladillo",
	 * "Salto", "San Antonio de Areco", "San Bernardo", "San Cayetano",
	 * "San Clemente del Tuy�", "San Fernando", "San Isidro", "San Justo",
	 * "San Martin", "San Miguel del Monte", "San Nicol�s", "San Pedro",
	 * "San Vicente", "Santa Clara del Mar", "Santa Teresita", "Sarand�",
	 * "Sierra de la Ventana", "Sierra de los Padres", "Sierras de los Padres",
	 * "Tandil", "Tapalqu�", "Temperley", "Tigre", "Tornquist / Ruta Prov. 76",
	 * "Trenque Lauquen", "Tres Arroyos", "Turdera", "Valentin Alsina",
	 * "Vicente Lopez", "Victoria", "Villa Ballester", "Villa Gesell",
	 * "Villa Lynch", "Villa Serrana La Gruta", "Villa Ventana", "Villalonga",
	 * "Wilde", "Z�rate" };
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
		persona.setFechaCumplea�os(java.sql.Date.valueOf(ldate));
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
