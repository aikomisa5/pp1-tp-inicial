
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

public class VentanaPersona extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JButton btnAgregarPersona;
	private Controlador controlador;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	String [] Localidades = {"17 de Agosto","25 de Mayo","9 de Julio / La Niña","Acassuso",
			"Aguas Verdes","Alberti","Arenas Verdes","Arrecifes","Avellaneda","Ayacucho","Azul",
			"Bahía Blanca","Bahía San Blas","Balcarce","Balneario Marisol","Balneario Orense",
			"Balneario Reta","Balneario San Cayetano","Baradero","Bella Vista","Benito Juárez",
			"Berazategui","Berisso","Boulogne","Bragado","Brandsen","Campana","Capilla del Señor",
			"Capital Federal","Capitán Sarmiento","Carapachay","Carhue","Carhué","Carlos Keen",
			"Carmen de Areco","Carmen de Patagones","Caseros","Castelar","Castelli","Chacabuco",
			"Chascomús","Chivilcoy","City Bell","Ciudadela","Claromecó","Colón","Coronel Dorrego",
			"Coronel Pringles",	"Coronel Suárez","Darregueira","Dunamar","Escobar","Ezeiza",
			"Florencio Varela",	"Florida","Fortín Mercedes","Garin","General Arenales",
			"General Belgrano",	"General Madariaga","General Villegas",	"Gral. Daniel Cerri",
			"Gran Buenos Aires","Guaminí","Haedo","Huanguelen","Hurlingham","Isla Martín García",
			"Ituzaingo","Junín","La Plata","La Tablada","Laferrere","Lanus","Laprida","Las Flores",
			"Las Gaviotas","Las Toninas","Lima","Lisandro Olmos","Llavallol","Lobos","Lomas de Zamora",
			"Los Toldos - Gral. Viamonte","Los Polvorines","Lucila del Mar","Luis Guillón","Luján","Magdalena",
			"Maipú","Mar Azul",	"Mar Chiquita","Mar de Ajó","Mar de Cobo","Mar del Plata",
			"Mar del Sud","Mar del Tuyú","Martinez","Médanos / Laguna Chasicó","Mercedes",
			"Merlo","Miramar","Monte Hermoso","Moreno","Morón","Munro","Navarro","Necochea",
			"Nueva Atlantis","Olavarría","Olivos","Open Door","Ostende","Pedro Luro",
			"Pehuajó","Pehuen Có","Pergamino","Pigüé","Pilar","Pinamar","Provincia de Buenos Aires",
			"Puan","Punta Alta","Punta Indio","Punta Lara",	"Quequén","Quilmes","Ramallo","Ramos Mejía",
			"Ranchos","Rauch","Rivadavia","Rojas","Roque Pérez","Saenz Peña","Saladillo",
			"Salto","San Antonio de Areco",	"San Bernardo","San Cayetano","San Clemente del Tuyú",
			"San Fernando","San Isidro","San Justo","San Martin","San Miguel del Monte",
			"San Nicolás","San Pedro","San Vicente","Santa Clara del Mar","Santa Teresita",
			"Sarandí","Sierra de la Ventana","Sierra de los Padres","Sierras de los Padres",
			"Tandil","Tapalqué","Temperley", "Tigre","Tornquist / Ruta Prov. 76",
			"Trenque Lauquen",	"Tres Arroyos",	"Turdera","Valentin Alsina","Vicente Lopez",
			"Victoria","Villa Ballester","Villa Gesell","Villa Lynch","Villa Serrana La Gruta",
			"Villa Ventana","Villalonga","Wilde","Zárate"};
	
	String [] TipoDeContacto = {"Amigos","Trabajo","Familia","Universidad","Escuela","Club"};

	public VentanaPersona(Controlador controlador) 
	{
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
		
		txtNombre = new JTextField();
		txtNombre.setBounds(133, 8, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(133, 39, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.addActionListener(this.controlador);
		btnAgregarPersona.setBounds(208, 363, 89, 23);
		panel.add(btnAgregarPersona);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(133, 70, 164, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(133, 101, 164, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(133, 132, 164, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(133, 163, 164, 20);
		panel.add(textField_3);
		
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
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(133, 194, 164, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(133, 225, 164, 20);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(133, 254, 164, 20);
		panel.add(textField_6);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(10, 228, 113, 14);
		panel.add(lblEmail);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setBounds(10, 257, 113, 14);
		panel.add(lblFechaDeNacimiento);
		
		JLabel label_2 = new JLabel("Localidad");
		label_2.setBounds(10, 288, 113, 14);
		panel.add(label_2);
		
		JComboBox comboBoxLocalidades = new JComboBox(Localidades);
		comboBoxLocalidades.setBounds(133, 285, 164, 20);
		panel.add(comboBoxLocalidades);
		
		JLabel lblTipoDeContacto = new JLabel("Tipo de Contacto");
		lblTipoDeContacto.setBounds(10, 319, 113, 14);
		panel.add(lblTipoDeContacto);
		
		JComboBox comboBoxTipoContacto = new JComboBox(TipoDeContacto);
		comboBoxTipoContacto.setBounds(133, 316, 164, 20);
		panel.add(comboBoxTipoContacto);
		
		this.setVisible(true);
	}
	
	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

	public JTextField getTxtTelefono() 
	{
		return txtTelefono;
	}

	public JButton getBtnAgregarPersona() 
	{
		return btnAgregarPersona;
	}
}
