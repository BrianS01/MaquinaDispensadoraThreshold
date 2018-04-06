package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import vo.Casilla;
import vista.InicializarMaquina;
import vista.InicioOperario;
import vista.MenuOperario;

public class Venta extends JFrame {

	private Casilla[][] maquina;
	private JPanel pnlMaquina;
	private JButton boton;
	private MenuOperario menuOperario;
	private JPanel contentPane;
	private JButton soyAdmin;
	private JButton cancelarTransaccion;
	private JTextField nombreProducto;
	private JTextField precioProducto;
	private JLabel textoProducto;
	private JLabel mensaje1;
	private JLabel textoPrecio;
	private JLabel monedaDeCien;
	private JLabel monedaDe200;
	private JLabel monedaDe500;
	private JLabel billeteDe1000;
	private JLabel billeteDe2000;
	private JLabel billeteDe5000;
	private JLabel billeteDe10000;
	private JLabel billeteDe20000;
	private JLabel billeteDe50000;
	private JLabel billeteDe100000;
	private JLabel txtCantidad;
	private JTextField cantidadIngresada;
	private static int cantidad;
	private JButton realizarCompra;

	private boolean estaMaquinaInicializada;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Venta frame = new Venta(new MenuOperario());
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Venta(MenuOperario menuOperario) {
		this.menuOperario = menuOperario;

		pnlMaquina = new JPanel();
		maquina = menuOperario.getInicializarMaquina1().getMaquina();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1190, 725);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		soyAdmin = new JButton("Soy administrador");
		soyAdmin.setBounds(200, 20, 140, 23);
		contentPane.add(soyAdmin);

		cancelarTransaccion = new JButton("Cancelar transaccion");
		cancelarTransaccion.setBounds(200, 60, 165, 23);
		contentPane.add(cancelarTransaccion);

		nombreProducto = new JTextField();
		nombreProducto.setBounds(200, 198, 133, 23);
		contentPane.add(nombreProducto);
		nombreProducto.setColumns(10);

		textoProducto = new JLabel("Producto comprado:");
		textoProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textoProducto.setBounds(68, 198, 146, 19);
		contentPane.add(textoProducto);

		textoPrecio = new JLabel("Precio:");
		textoPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textoPrecio.setBounds(156, 245, 146, 19);
		contentPane.add(textoPrecio);

		precioProducto = new JTextField();
		precioProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		precioProducto.setBounds(200, 245, 133, 23);
		contentPane.add(precioProducto);

		mensaje1 = new JLabel("seleccione los billetes y/o monedas con los " + "cuáles va a pagar");
		mensaje1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mensaje1.setBounds(46, 295, 380, 19);
		contentPane.add(mensaje1);

		monedaDeCien = new JLabel("");
		monedaDeCien.setIcon(new ImageIcon(
				"C:\\Users\\cristian\\Documents\\GitHub\\MaquinaDispensadoraThreshold\\src\\imagenes\\MonedaDe100.PNG"));
		monedaDeCien.setBounds(46, 320, 64, 58);
		contentPane.add(monedaDeCien);

		monedaDe200 = new JLabel("");
		monedaDe200.setIcon(new ImageIcon(
				"C:\\Users\\cristian\\eclipse-workspace\\MaquinaDispensadora\\src\\imagenes\\MonedaDe200.PNG"));
		monedaDe200.setBounds(115, 320, 46, 53);
		contentPane.add(monedaDe200);

		monedaDe500 = new JLabel("");
		monedaDe500.setIcon(new ImageIcon(
				"C:\\Users\\cristian\\eclipse-workspace\\MaquinaDispensadora\\src\\imagenes\\MonedaDe500.PNG"));
		monedaDe500.setBounds(186, 320, 54, 58);
		contentPane.add(monedaDe500);

		billeteDe1000 = new JLabel("");
		billeteDe1000.setIcon(new ImageIcon(
				"C:\\Users\\cristian\\eclipse-workspace\\MaquinaDispensadora\\src\\imagenes\\BilleteDe1000.PNG"));
		billeteDe1000.setBounds(46, 390, 114, 59);
		contentPane.add(billeteDe1000);

		billeteDe2000 = new JLabel("");
		billeteDe2000.setIcon(new ImageIcon(
				"C:\\Users\\cristian\\eclipse-workspace\\MaquinaDispensadora\\src\\imagenes\\billeteDe2000.PNG"));
		billeteDe2000.setBounds(180, 390, 114, 58);
		contentPane.add(billeteDe2000);

		billeteDe5000 = new JLabel("");
		billeteDe5000.setIcon(new ImageIcon(
				"C:\\Users\\cristian\\eclipse-workspace\\MaquinaDispensadora\\src\\imagenes\\BilleteDe5000.PNG"));
		billeteDe5000.setBounds(330, 390, 106, 52);
		contentPane.add(billeteDe5000);

		billeteDe10000 = new JLabel("");
		billeteDe10000.setIcon(new ImageIcon(
				"C:\\Users\\cristian\\eclipse-workspace\\MaquinaDispensadora\\src\\imagenes\\BilleteDe10000.PNG"));
		billeteDe10000.setBounds(46, 467, 114, 59);
		contentPane.add(billeteDe10000);

		billeteDe20000 = new JLabel("");
		billeteDe20000.setIcon(new ImageIcon(
				"C:\\Users\\cristian\\eclipse-workspace\\MaquinaDispensadora\\src\\imagenes\\BilleteDe20000.PNG"));
		billeteDe20000.setBounds(110, 467, 114, 59);
		contentPane.add(billeteDe20000);
		
		txtCantidad = new JLabel("Cantidad ingresada: ");
		txtCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCantidad.setBounds(156, 529, 146, 19);
		contentPane.add(txtCantidad);

		cantidadIngresada = new JTextField();
		cantidadIngresada.setBounds(156, 570, 121, 30);
		contentPane.add(cantidadIngresada);

		realizarCompra = new JButton();
		realizarCompra.setBounds(280, 525, 165, 23);
		contentPane.add(realizarCompra);

		eventos();
		mostrarMaquina();

	}

	public void eventos() {

		soyAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cambiarInterfaz();
			}
		});

		cancelarTransaccion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});

		monedaDeCien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				eventoSeleccionDinero();
				mostrarMaquina() ;
			}
		});

		monedaDe200.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				eventoSeleccionDinero200();
				mostrarMaquina() ;
			}
		});

		monedaDe500.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				eventoSeleccionDinero500();
				mostrarMaquina() ;

			    
			}
		});

		billeteDe1000.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				eventoSeleccionDinero1000();
			}
		});

		billeteDe2000.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				eventoSeleccionDinero2000();
			}
		});

		billeteDe5000.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				eventoSeleccionDinero5000();
			}
		});

		billeteDe10000.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				eventoSeleccionDinero10000();
				 mostrarMaquina() ;
			}
		});
	}

	public void mostrarMaquina() {
		try {
			GridLayout gl = new GridLayout(0, maquina[0].length);
			pnlMaquina.setLayout(gl);
			pnlMaquina.removeAll();
			contentPane.remove(pnlMaquina);

			for (int i = 0; i < maquina.length; i++) {
				for (int j = 0; j < maquina[0].length; j++) {
					boton = maquina[i][j].getBoton();
				//	boton.setBounds((150 * i) + 500, (80 * j) + 85, 100, 25);
					boton.setBounds(200, 20, 140, 23);
					pnlMaquina.add(boton);
				}
			}
			contentPane.add(pnlMaquina);
			contentPane.revalidate();
			contentPane.repaint();
			System.out.println("Termino la insercion");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Debe inicializar la maquina primero.");
			setVisible(false);
			estaMaquinaInicializada = true;
		}
	}

	public void cambiarInterfaz() {
		InicioOperario inicioOperario = new InicioOperario();
		inicioOperario.setVisible(true);
	}

	public void eventoSeleccionDinero() {
		String valor = "";
		cantidad = cantidad + 100;
		valor = Integer.toString(cantidad);
		cantidadIngresada.setText(valor);
	}

	public void eventoSeleccionDinero200() {
		String valor = "";
		cantidad = cantidad + 200;
		valor = Integer.toString(cantidad);
		cantidadIngresada.setText(valor);
	}

	public void eventoSeleccionDinero500() {
		String valor = "";
		cantidad = cantidad + 500;
		valor = Integer.toString(cantidad);
		cantidadIngresada.setText(valor);
	}

	public void eventoSeleccionDinero1000() {
		String valor = "";
		cantidad = cantidad + 1000;
		valor = Integer.toString(cantidad);
		cantidadIngresada.setText(valor);
	}

	public void eventoSeleccionDinero2000() {
		String valor = "";
		cantidad = cantidad + 2000;
		valor = Integer.toString(cantidad);
		cantidadIngresada.setText(valor);
	}

	public void eventoSeleccionDinero5000() {
		String valor = "";
		cantidad = cantidad + 5000;
		valor = Integer.toString(cantidad);
		cantidadIngresada.setText(valor);
	}

	public void eventoSeleccionDinero10000() {
		String valor = "";
		cantidad = cantidad + 10000;
		valor = Integer.toString(cantidad);
		cantidadIngresada.setText(valor);
	}

	public void eventoSeleccionDinero20000() {
		String valor = "";
		cantidad = cantidad + 20000;
		valor = Integer.toString(cantidad);
		cantidadIngresada.setText(valor);
	}

	public void eventoSeleccionDinero50000() {
		String valor = "";
		cantidad = cantidad + 50000;
		valor = Integer.toString(cantidad);
		cantidadIngresada.setText(valor);
	}

	public void eventoSeleccionDinero100000() {
		String valor = "";
		cantidad = cantidad + 100000;
		valor = Integer.toString(cantidad);
		cantidadIngresada.setText(valor);
	}

	public boolean isEstaMaquinaInicializada() {
		return estaMaquinaInicializada;
	}

}
