package presentacion.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JButton;

public class VistaLocalidades extends JFrame {

	private JPanel panel;
	private JTable table;
	private String [] nombreColumnas= {"Localidad"};
	private DefaultTableModel modelLocalidades;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VistaLocalidades frame = new VistaLocalidades();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public VistaLocalidades() {
		initialize();
	}
	
	private void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 548, 455);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JScrollPane spLocalidades = new JScrollPane();
		spLocalidades.setBounds(49, 11, 446, 180);
		panel.add(spLocalidades);
		
		
		modelLocalidades = new DefaultTableModel(null, nombreColumnas);
		table = new JTable(modelLocalidades);
		table.setBounds(503, 312, -376, -257);
		
		spLocalidades.setViewportView(table);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(49, 244, 91, 23);
		panel.add(btnAgregar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(211, 244, 91, 23);
		panel.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(372, 244, 91, 23);
		panel.add(btnEliminar);
		
		//panel.add(table);
	}
}
