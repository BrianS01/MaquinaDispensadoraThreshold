package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import vo.Casilla;
import vo.Producto;

public class AgregarProductoCasilla extends JFrame
{
	private Casilla[][] maquina;
	private JPanel contentPane;
	private MenuOperario menuOperario;
	private JLabel lblPrimerMensaje;
	private JLabel lblSegundoMensaje;
	private JLabel lblTercerMensaje;
	private JButton agregarProducto;
	private JButton quitarProducto;
	private JTable table;
	private JTextPane txtpnIdProducto;
	private JTextPane txtpnNombreproducto;
	private JTextPane txtpnPrecio;
	private JPanel pnlMaquina;
	private JLabel lblIdProducto;
	private JLabel lblNombreProducto;
	private JLabel lblprecio;
	private JLabel lblfila;
	private JLabel lblcolumna;
	private JTextField jIdProducto;
	private JTextField jNombre;
	private JTextField jPrecio;
	private JButton boton;
	private JButton regresar;
	private boolean estaMaquinaInicializada;
	private JTextField fila;
	private JTextField columna;

	public AgregarProductoCasilla(MenuOperario menuOperario)
	{
		this.menuOperario = menuOperario;
		pnlMaquina = new JPanel();
		maquina = menuOperario.getInicializarMaquina1().getMaquina();
		pnlMaquina.setBounds(500, 80, 500, 400);
		pnlMaquina.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setTitle("Gestor Máquina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1200, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Producto[] productos = verProductos();
		String[][] data = new String[productos.length][3];
		
		for (int j = 0; j < data.length; j++)
		{
			if (productos[j] != null)
			{
				data[j][0] = productos[j].getIdProducto() + "";
				data[j][1] = productos[j].getNombre() + "";
				data[j][2] = productos[j].getPrecio() + "";
			}
		}

		String[] columnNames = { "nombre", "apellido", "telefono" };
		table = new JTable(data, columnNames);
		table.setVisible(true);
		table.setBounds(40, 315, 393, 150); // Aqui voy
		contentPane.add(table);
		lblPrimerMensaje = new JLabel(
				"Para agregar un producto en la máquina" + " haga clic en la lista, luego haga clic en el espacio"
						+ " de la máquina y haga clic en el botón Agregar Producto.");
		lblPrimerMensaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrimerMensaje.setBounds(20, 0, 1060, 80);
		contentPane.add(lblPrimerMensaje);
		lblSegundoMensaje = new JLabel("Para quitar un producto del espacio de la"
				+ " máquina haga clic en la casilla de la máquina y posteriormente"
				+ " haga clic en la opción QuitarProducto.");
		lblSegundoMensaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSegundoMensaje.setBounds(20, 20, 1050, 80);
		contentPane.add(lblSegundoMensaje);
		lblTercerMensaje = new JLabel("Lista de productos");
		lblTercerMensaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTercerMensaje.setBounds(132, 230, 1050, 80);
		contentPane.add(lblTercerMensaje);
		txtpnIdProducto = new JTextPane();
		txtpnIdProducto.setText("Identificaci\u00F3n Producto");
		txtpnIdProducto.setBounds(40, 295, 142, 20);
		contentPane.add(txtpnIdProducto);
		txtpnNombreproducto = new JTextPane();
		txtpnNombreproducto.setText("  Nombre Producto");
		txtpnNombreproducto.setBounds(180, 295, 122, 20);
		contentPane.add(txtpnNombreproducto);
		txtpnPrecio = new JTextPane();
		txtpnPrecio.setText("               Precio");
		txtpnPrecio.setBounds(300, 295, 131, 20);
		contentPane.add(txtpnPrecio);
		agregarProducto = new JButton("Agregar");
		agregarProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		agregarProducto.setBounds(450, 640, 190, 23);
		contentPane.add(agregarProducto);
		quitarProducto = new JButton("Quitar");
		quitarProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		quitarProducto.setBounds(650, 640, 132, 23);
		contentPane.add(quitarProducto);
		lblIdProducto = new JLabel("IdProducto");
		lblIdProducto.setBounds(40, 480, 89, 14);
		contentPane.add(lblIdProducto);
		jIdProducto = new JTextField();
		jIdProducto.setBounds(115, 475, 97, 28);
		contentPane.add(jIdProducto);
		lblNombreProducto = new JLabel("Nombre Producto");
		lblNombreProducto.setBounds(40, 515, 107, 14);
		contentPane.add(lblNombreProducto);
		jNombre = new JTextField();
		jNombre.setBounds(143, 510, 97, 28);
		contentPane.add(jNombre);
		lblprecio = new JLabel("Precio");
		lblprecio.setBounds(40, 554, 107, 14);
		contentPane.add(lblprecio);
		jPrecio = new JTextField();
		jPrecio.setBounds(86, 550, 97, 28);
		contentPane.add(jPrecio);
		regresar = new JButton("Regresar");
		regresar.setBounds(340, 639, 97, 23);
		contentPane.add(regresar);
		fila = new JTextField();
		fila.setBounds(65, 590, 97, 28);
		contentPane.add(fila);
		columna = new JTextField();
		columna.setBounds(97, 625, 97, 28);
		contentPane.add(columna);
		lblfila = new JLabel("fila");
		lblfila.setBounds(40, 600, 107, 14);
		contentPane.add(lblfila);
		lblcolumna = new JLabel("columna");
		lblcolumna.setBounds(40, 633, 107, 14);
		contentPane.add(lblcolumna);
		eventos();
		mostrarMaquina();
	}

	public void eventos()
	{
		agregarProducto.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{

				modificarCasilla(Integer.parseInt(fila.getText()), Integer.parseInt(columna.getText()));
			}
		});

		quitarProducto.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				quitarProductoCasilla(Integer.parseInt(fila.getText()), Integer.parseInt(columna.getText()));
			}
		});

		table.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				int seleccion = table.rowAtPoint(e.getPoint());
				jIdProducto.setText(String.valueOf(table.getValueAt(seleccion, 0)));
				jNombre.setText(String.valueOf(table.getValueAt(seleccion, 1)));
				jPrecio.setText(String.valueOf(table.getValueAt(seleccion, 2)));
			}
		});

		regresar.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				menuOperario.setVisible(true);
				setVisible(false);
			}
		});
	}

	public void eventoModificarCasilla()
	{
		boton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
			}
		});
	}

	public void modificarCasilla(int fila, int columna)
	{
		if ((fila >= 1 && fila <= maquina.length) && (columna >= 1 && columna <= maquina[0].length))
		{
			Casilla casilla = maquina[fila - 1][columna - 1];
			JButton boton = maquina[fila - 1][columna - 1].getBoton();

			if (casilla.getIdProducto() != null
					&& !casilla.getIdProducto().equals(Integer.parseInt(jIdProducto.getText()))) {
				JOptionPane.showMessageDialog(null, "Ingreso un producto diferente al que esta en la casilla.");
			} else {int cantidad = casilla.getCantidadDeProducto(); casilla.setCantidadDeProducto(++cantidad);
				casilla.setIdProducto(Integer.parseInt(jIdProducto.getText()));
				boton.setText("(" + fila + "-" + columna + ")" + jNombre.getText() + " " + jPrecio.getText()
						+ " cant.(" + casilla.getCantidadDeProducto() + ")");
				mostrarMaquina();
				System.out.println("Casilla modificada");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Ingreso una fila o columna erradas");
		}
	}

	public void quitarProductoCasilla(int fila, int columna) {
		if ((fila >= 1 && fila <= maquina.length) && (columna >= 1 && columna <= maquina[0].length)) {
			Casilla casilla = maquina[fila - 1][columna - 1];
			JButton boton = maquina[fila - 1][columna - 1].getBoton();

			int cantidad = casilla.getCantidadDeProducto();
			if(cantidad>0) {
				casilla.setCantidadDeProducto(--cantidad);
			}
			String contenidoBoton = "(" + fila + "-" + columna + ")\n" + jNombre.getText() + " " + jPrecio.getText()
					+ " \n cant.(" + casilla.getCantidadDeProducto() + ")";
			if (cantidad == 0) {
				casilla.setIdProducto(null);
				contenidoBoton = "(" + fila + "-" + columna + ")" + " cant.(" + cantidad + ")";
			}

			boton.setText(contenidoBoton);

			mostrarMaquina();
			System.out.println("Casilla modificada");
		} else {
			JOptionPane.showMessageDialog(null, "Ingreso una fila o columna erradas");
		}
	}

	public void mostrarMaquina() {
		try {
			GridLayout gl = new GridLayout(0, maquina[0].length);
			pnlMaquina.setLayout(gl);
			pnlMaquina.removeAll();
			getContentPane().remove(pnlMaquina);

			for (int i = 0; i < maquina.length; i++) {
				for (int j = 0; j < maquina[0].length; j++) {
					boton = maquina[i][j].getBoton();
					if(boton.getText().length()==1) {
						boton.setText("(" + (i + 1) + "-" + (j + 1) + ")");
					}
				//	boton.setBounds((150 * i) + 500, (80 * j) + 85, 100, 25);
					boton.setBounds((120 * i) + 500, (80 * j) + 85, 120, 300);
					pnlMaquina.add(boton);
				}
			}
			getContentPane().add(pnlMaquina);
			getContentPane().revalidate();
			getContentPane().repaint();
			System.out.println("Termino la insercion");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Debe inicializar la maquina primero.");
			menuOperario.setVisible(true);
			setVisible(false);
			estaMaquinaInicializada = true;
		}
	}
	
	public void recorrerPanelMaquina() {
		//recorrer panel y cada boton del panel asignarle un evento
		//asignar metodo generico donde tome el idpRODUCTO
	}

	public Producto[] verProductos() {
		return menuOperario.controladorProductoCasilla.listarProductos();
	}

	public boolean isEstaMaquinaInicializada() {
		return estaMaquinaInicializada;
	}

}