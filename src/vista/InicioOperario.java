package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ResourceBundle;

public class InicioOperario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField login;
	private JPasswordField contrasena;
	private JButton ingresar;
	private ResourceBundle rb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioOperario frame = new InicioOperario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InicioOperario() {
		rb = ResourceBundle.getBundle("recursos.operarios_claves");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIngreseSu = new JLabel("Ingrese su usuario");
		lblIngreseSu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIngreseSu.setBounds(144, 54, 134, 39);
		contentPane.add(lblIngreseSu);

		login = new JTextField();
		login.setFont(new Font("Tahoma", Font.PLAIN, 12));
		login.setBounds(105, 91, 228, 39);
		contentPane.add(login);
		login.setColumns(10);

		JLabel lblIngreseSuContrasea = new JLabel("Ingrese su contrase\u00F1a");
		lblIngreseSuContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIngreseSuContrasea.setBounds(140, 160, 150, 26);
		contentPane.add(lblIngreseSuContrasea);

		contrasena = new JPasswordField();
		contrasena.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contrasena.setBounds(105, 197, 216, 39);
		contentPane.add(contrasena);
		contrasena.setColumns(10);

		ingresar = new JButton("Ingresar");
		ingresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String nombreOperario = login.getText();
					String contrasenaIngresada= new String(contrasena.getPassword());
					
					String clave = rb.getString(nombreOperario);
					
					if (login.getText().equals("") || contrasenaIngresada.equals("")) {
						JOptionPane.showMessageDialog(null, "No deje los espacios en blanco");
					} else if (!contrasenaIngresada.equals(clave)) {
						JOptionPane.showMessageDialog(null, "La contraseña no es la que se le había asignado");

					} else if (contrasenaIngresada.equals(clave)) {
						MenuOperario menuoperario = new MenuOperario();
						menuoperario.setVisible(true);
						// this.dispose();
					}
					// Falta hacer que salga el mensaje y no salga de la página.
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "La contraseña o el login son incorretos");
				}
			}
		});
		ingresar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ingresar.setBounds(169, 282, 89, 23);
		contentPane.add(ingresar);
	}

	

}
