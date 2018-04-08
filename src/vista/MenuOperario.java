package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorProductoCasilla;
import vista.Venta;

public class MenuOperario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private Venta venta1;
	private InicioOperario inicioOperario;
	public ControladorProductoCasilla controladorProductoCasilla;
	private InicializarMaquina inicializarMaquina1;
	private AgregarProductoCasilla agregarProductoCasilla;
	private VerListaDeProducto verListaDeProductos;
	private EliminarProducto eliminarProducto2 ;
	private JButton salir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuOperario frame = new MenuOperario();
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
	public MenuOperario() {
		inicializarMaquina1 = new InicializarMaquina(this);		
		controladorProductoCasilla = new ControladorProductoCasilla();
		verListaDeProductos = new VerListaDeProducto(this);
		eliminarProducto2 = new EliminarProducto(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBienvenidoAdministrador = new JLabel("Bienvenido Administrador");
		lblBienvenidoAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBienvenidoAdministrador.setBounds(161, 31, 175, 25);
		contentPane.add(lblBienvenidoAdministrador);

		JButton insertarProducto = new JButton("InsertarProducto");
		insertarProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cambiarInterfaz();

			}
		});
		insertarProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		insertarProducto.setBounds(40, 78, 147, 35);
		contentPane.add(insertarProducto);

		JButton eliminarProducto = new JButton("EliminarProducto");
		eliminarProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cambiarInterfaz2();
			}
		});

		eliminarProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eliminarProducto.setBounds(38, 138, 149, 35);
		contentPane.add(eliminarProducto);

		JButton verListaProductos = new JButton("Ver Lista Productos");
		verListaProductos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		verListaProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cambiarInterfaz1();
			}
		});
		verListaProductos.setBounds(39, 198, 148, 35);
		contentPane.add(verListaProductos);

		salir = new JButton("Salir");
		salir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cambiarInterfaz5();
			}
		});
		salir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		salir.setBounds(287, 476, 89, 35);
		contentPane.add(salir);

		JButton inicializarMaquina = new JButton("Inicializar Maquina");
		inicializarMaquina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cambiarInterfaz3();
			}
		});
		inicializarMaquina.setBounds(40, 262, 147, 35);
		contentPane.add(inicializarMaquina);

		JButton AgregarProductoA = new JButton("Maquina");
		AgregarProductoA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cambiarInterfaz4();

			}
		});
		AgregarProductoA.setBounds(40, 322, 231, 35);
		contentPane.add(AgregarProductoA);
	}

	public void cambiarInterfaz() {
		InsertarProducto insertarProducto = new InsertarProducto(this);
		insertarProducto.setVisible(true);
		this.dispose(); 
	}

	public void cambiarInterfaz1() {
		verListaDeProductos.setVisible(true);
		this.dispose();
	}

	public void cambiarInterfaz2() {
		eliminarProducto2.setVisible(true);
		this.dispose();
	}

	public void cambiarInterfaz3() {
		inicializarMaquina1.setVisible(true);
		this.dispose();
	}

	public void cambiarInterfaz4() {
		agregarProductoCasilla = new AgregarProductoCasilla(this);
		if (!agregarProductoCasilla.isEstaMaquinaInicializada()) {
			agregarProductoCasilla.setVisible(true);
			this.dispose();
		}
	}

	public void cambiarInterfaz5() {
		venta1 = new Venta(this);

		if (!venta1.isEstaMaquinaInicializada()) {
			setVisible(false);
			venta1.setVisible(true);
		}
	}

	public InicializarMaquina getInicializarMaquina1() {
		return inicializarMaquina1;
	}

	public VerListaDeProducto getVerListaDeProductos() {
		return verListaDeProductos;
	}

	public void setVerListaDeProductos(VerListaDeProducto verListaDeProductos) {
		this.verListaDeProductos = verListaDeProductos;
	}
	
	

}
