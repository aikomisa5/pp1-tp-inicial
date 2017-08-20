
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

	String[] Localidades = { "17 de Agosto", "25 de Mayo", "9 de Julio / La Ni�a", "Acassuso", "Aguas Verdes",
			"Alberti", "Arenas Verdes", "Arrecifes", "Avellaneda", "Ayacucho", "Azul", "Bah�a Blanca", "Bah�a San Blas",
			"Balcarce", "Balneario Marisol", "Balneario Orense", "Balneario Reta", "Balneario San Cayetano", "Baradero",
			"Bella Vista", "Benito Ju�rez", "Berazategui", "Berisso", "Boulogne", "Bragado", "Brandsen", "Campana",
			"Capilla del Se�or", "Capital Federal", "Capit�n Sarmiento", "Carapachay", "Carhue", "Carhu�",
			"Carlos Keen", "Carmen de Areco", "Carmen de Patagones", "Caseros", "Castelar", "Castelli", "Chacabuco",
			"Chascom�s", "Chivilcoy", "City Bell", "Ciudadela", "Claromec�", "Col�n", "Coronel Dorrego",
			"Coronel Pringles", "Coronel Su�rez", "Darregueira", "Dunamar", "Escobar", "Ezeiza", "Florencio Varela",
			"Florida", "Fort�n Mercedes", "Garin", "General Arenales", "General Belgrano", "General Madariaga",
			"General Villegas", "Gral. Daniel Cerri", "Gran Buenos Aires", "Guamin�", "Haedo", "Huanguelen",
			"Hurlingham", "Isla Mart�n Garc�a", "Ituzaingo", "Jun�n", "La Plata", "La Tablada", "Laferrere", "Lanus",
			"Laprida", "Las Flores", "Las Gaviotas", "Las Toninas", "Lima", "Lisandro Olmos", "Llavallol", "Lobos",
			"Lomas de Zamora", "Los Toldos - Gral. Viamonte", "Los Polvorines", "Lucila del Mar", "Luis Guill�n",
			"Luj�n", "Magdalena", "Maip�", "Mar Azul", "Mar Chiquita", "Mar de Aj�", "Mar de Cobo", "Mar del Plata",
			"Mar del Sud", "Mar del Tuy�", "Martinez", "M�danos / Laguna Chasic�", "Mercedes", "Merlo", "Miramar",
			"Monte Hermoso", "Moreno", "Mor�n", "Munro", "Navarro", "Necochea", "Nueva Atlantis", "Olavarr�a", "Olivos",
			"Open Door", "Ostende", "Pedro Luro", "Pehuaj�", "Pehuen C�", "Pergamino", "Pig��", "Pilar", "Pinamar",
			"Provincia de Buenos Aires", "Puan", "Punta Alta", "Punta Indio", "Punta Lara", "Quequ�n", "Quilmes",
			"Ramallo", "Ramos Mej�a", "Ranchos", "Rauch", "Rivadavia", "Rojas", "Roque P�rez", "Saenz Pe�a",
			"Saladillo", "Salto", "San Antonio de Areco", "San Bernardo", "San Cayetano", "San Clemente del Tuy�",
			"San Fernando", "San Isidro", "San Justo", "San Martin", "San Miguel del Monte", "San Nicol�s", "San Pedro",
			"San Vicente", "Santa Clara del Mar", "Santa Teresita", "Sarand�", "Sierra de la Ventana",
			"Sierra de los Padres", "Sierras de los Padres", "Tandil", "Tapalqu�", "Temperley", "Tigre",
			"Tornquist / Ruta Prov. 76", "Trenque Lauquen", "Tres Arroyos", "Turdera", "Valentin Alsina",
			"Vicente Lopez", "Victoria", "Villa Ballester", "Villa Gesell", "Villa Lynch", "Villa Serrana La Gruta",
			"Villa Ventana", "Villalonga", "Wilde", "Z�rate" };

	String[] TipoDeContacto = { "Amigos", "Trabajo", "Familia", "Universidad", "Escuela", "Club" };

	public VentanaPersona(Controlador controlador) {
		super();
		this.controlador = controlador;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 448, 462);
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
		lblNombreYApellido.setBounds(10, 11, 113, 14);
		panel.add(lblNombreYApellido);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(10, 42, 113, 14);
		panel.add(lblTelfono);

		tfNombre = new JTextField();
		tfNombre.setBounds(133, 8, 164, 20);
		panel.add(tfNombre);
		tfNombre.setColumns(10);

		tfTelefono = new JTextField();
		tfTelefono.setBounds(133, 49, 164, 20);
		panel.add(tfTelefono);
		tfTelefono.setColumns(10);

		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.addActionListener(this.controlador);
		btnAgregarPersona.setBounds(34, 375, 89, 23);
		panel.add(btnAgregarPersona);

		tfCalle = new JTextField();
		tfCalle.setColumns(10);
		tfCalle.setBounds(133, 95, 164, 20);
		panel.add(tfCalle);

		tfAltura = new JTextField();
		tfAltura.setColumns(10);
		tfAltura.setBounds(133, 140, 164, 20);
		panel.add(tfAltura);

		tfPiso = new JTextField();
		tfPiso.setColumns(10);
		tfPiso.setBounds(133, 185, 164, 20);
		panel.add(tfPiso);

		tfDepto = new JTextField();
		tfDepto.setColumns(10);
		tfDepto.setBounds(133, 227, 164, 20);
		panel.add(tfDepto);

		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 73, 113, 14);
		panel.add(lblCalle);

		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 104, 113, 14);
		panel.add(lblAltura);

		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(10, 135, 113, 14);
		panel.add(lblPiso);

		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(10, 166, 113, 14);
		panel.add(lblDepartamento);

		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 197, 113, 14);
		panel.add(lblLocalidad);

		tfLocalidad = new JTextField();
		tfLocalidad.setColumns(10);
		tfLocalidad.setBounds(133, 264, 164, 20);
		panel.add(tfLocalidad);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(133, 307, 164, 20);
		panel.add(tfEmail);

		tfFechaNac = new JTextField();
		tfFechaNac.setColumns(10);
		tfFechaNac.setBounds(133, 345, 164, 20);
		panel.add(tfFechaNac);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(10, 228, 113, 14);
		panel.add(lblEmail);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setBounds(10, 257, 113, 14);
		panel.add(lblFechaDeNacimiento);

		JLabel label_2 = new JLabel("Localidad");
		label_2.setBounds(10, 288, 113, 14);
		panel.add(label_2);

		JComboBox comboLocalidad = new JComboBox(Localidades);
		comboLocalidad.setBounds(133, 376, 164, 20);
		panel.add(comboLocalidad);

		JLabel lblTipoDeContacto = new JLabel("Tipo de Contacto");
		lblTipoDeContacto.setBounds(10, 319, 113, 14);
		panel.add(lblTipoDeContacto);

		JComboBox comboTipoDeContacto = new JComboBox(TipoDeContacto);
		comboTipoDeContacto.setBounds(133, 407, 164, 20);
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
