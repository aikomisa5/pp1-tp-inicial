
package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentacion.controlador.Controlador;
import java.awt.Color;
import javax.swing.JComboBox;

public class VentanaPersona extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfLocalidad;
	private JTextField tfFechaNac;
	private JButton btnAgregarPersona;
	private Controlador controlador;
	private JTextField tfNombre;
	private JTextField tfTelefono;
	private JTextField tfCalle;
	private JTextField tfAltura;
	private JTextField tfPiso;
	private JTextField tfDepto;
	private JTextField tfEmail;

	String[] Localidades = { "17 de Agosto", "25 de Mayo", "9 de Julio / La Niña", "Acassuso", "Aguas Verdes",
			"Alberti", "Arenas Verdes", "Arrecifes", "Avellaneda", "Ayacucho", "Azul", "Bahía Blanca", "Bahía San Blas",
			"Balcarce", "Balneario Marisol", "Balneario Orense", "Balneario Reta", "Balneario San Cayetano", "Baradero",
			"Bella Vista", "Benito Juárez", "Berazategui", "Berisso", "Boulogne", "Bragado", "Brandsen", "Campana",
			"Capilla del Señor", "Capital Federal", "Capitán Sarmiento", "Carapachay", "Carhue", "Carhué",
			"Carlos Keen", "Carmen de Areco", "Carmen de Patagones", "Caseros", "Castelar", "Castelli", "Chacabuco",
			"Chascomús", "Chivilcoy", "City Bell", "Ciudadela", "Claromecó", "Colón", "Coronel Dorrego",
			"Coronel Pringles", "Coronel Suárez", "Darregueira", "Dunamar", "Escobar", "Ezeiza", "Florencio Varela",
			"Florida", "Fortín Mercedes", "Garin", "General Arenales", "General Belgrano", "General Madariaga",
			"General Villegas", "Gral. Daniel Cerri", "Gran Buenos Aires", "Guaminí", "Haedo", "Huanguelen",
			"Hurlingham", "Isla Martín García", "Ituzaingo", "Junín", "La Plata", "La Tablada", "Laferrere", "Lanus",
			"Laprida", "Las Flores", "Las Gaviotas", "Las Toninas", "Lima", "Lisandro Olmos", "Llavallol", "Lobos",
			"Lomas de Zamora", "Los Toldos - Gral. Viamonte", "Los Polvorines", "Lucila del Mar", "Luis Guillón",
			"Luján", "Magdalena", "Maipú", "Mar Azul", "Mar Chiquita", "Mar de Ajó", "Mar de Cobo", "Mar del Plata",
			"Mar del Sud", "Mar del Tuyú", "Martinez", "Médanos / Laguna Chasicó", "Mercedes", "Merlo", "Miramar",
			"Monte Hermoso", "Moreno", "Morón", "Munro", "Navarro", "Necochea", "Nueva Atlantis", "Olavarría", "Olivos",
			"Open Door", "Ostende", "Pedro Luro", "Pehuajó", "Pehuen Có", "Pergamino", "Pigüé", "Pilar", "Pinamar",
			"Provincia de Buenos Aires", "Puan", "Punta Alta", "Punta Indio", "Punta Lara", "Quequén", "Quilmes",
			"Ramallo", "Ramos Mejía", "Ranchos", "Rauch", "Rivadavia", "Rojas", "Roque Pérez", "Saenz Peña",
			"Saladillo", "Salto", "San Antonio de Areco", "San Bernardo", "San Cayetano", "San Clemente del Tuyú",
			"San Fernando", "San Isidro", "San Justo", "San Martin", "San Miguel del Monte", "San Nicolás", "San Pedro",
			"San Vicente", "Santa Clara del Mar", "Santa Teresita", "Sarandí", "Sierra de la Ventana",
			"Sierra de los Padres", "Sierras de los Padres", "Tandil", "Tapalqué", "Temperley", "Tigre",
			"Tornquist / Ruta Prov. 76", "Trenque Lauquen", "Tres Arroyos", "Turdera", "Valentin Alsina",
			"Vicente Lopez", "Victoria", "Villa Ballester", "Villa Gesell", "Villa Lynch", "Villa Serrana La Gruta",
			"Villa Ventana", "Villalonga", "Wilde", "Zárate" };

	String[] TipoDeContacto = { "Amigos", "Trabajo", "Familia", "Universidad", "Escuela", "Club" };

	public VentanaPersona(Controlador controlador) {
		super();
		this.controlador = controlador;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 409, 462);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 307, 402);
		contentPane.add(panel);
		panel.setLayout(null);

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

		tfLocalidad = new JTextField();
		tfLocalidad.setColumns(10);
		tfLocalidad.setBounds(133, 196, 164, 20);
		panel.add(tfLocalidad);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(133, 227, 164, 20);
		panel.add(tfEmail);

		tfFechaNac = new JTextField();
		tfFechaNac.setColumns(10);
		tfFechaNac.setBounds(133, 257, 164, 20);
		panel.add(tfFechaNac);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(20, 230, 113, 14);
		panel.add(lblEmail);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setBounds(20, 260, 113, 14);
		panel.add(lblFechaDeNacimiento);

		JLabel label_2 = new JLabel("Localidad");
		label_2.setBounds(20, 291, 113, 14);
		panel.add(label_2);

		JComboBox comboLocalidad = new JComboBox(Localidades);
		comboLocalidad.setBounds(133, 288, 164, 20);
		panel.add(comboLocalidad);

		JLabel lblTipoDeContacto = new JLabel("Tipo de Contacto");
		lblTipoDeContacto.setBounds(20, 323, 113, 14);
		panel.add(lblTipoDeContacto);

		JComboBox comboTipoDeContacto = new JComboBox(TipoDeContacto);
		comboTipoDeContacto.setBounds(133, 320, 164, 20);
		panel.add(comboTipoDeContacto);

		this.setVisible(true);
	}

	public String[] getLocalidades() {
		return Localidades;
	}

	public void setLocalidades(String[] localidades) {
		Localidades = localidades;
	}

	public String[] getTipoDeContacto() {
		return TipoDeContacto;
	}

	public void setTipoDeContacto(String[] tipoDeContacto) {
		TipoDeContacto = tipoDeContacto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JTextField getTfLocalidad() {
		return tfLocalidad;
	}

	public JTextField getTfFechaNac() {
		return tfFechaNac;
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

}
