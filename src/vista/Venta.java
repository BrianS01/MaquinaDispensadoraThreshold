package vista;

import controlador.ControladorProductoCasilla;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import vista.InicializarMaquina;
import vista.InicioOperario;
import vista.MenuOperario;
import vo.Casilla;
import vo.Producto;
import vista.InicializarMaquina;
import vista.InicioOperario;
import vista.MenuOperario;

public class Venta extends JFrame
{
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
	private JLabel mensaje2;
	private JLabel textoPrecio;
	private JLabel monedaDeCien;
	private JLabel monedaDe200;
	private JLabel monedaDe500;
	private JLabel textoCantidad;
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
	private JButton regresar;
	private static ControladorProductoCasilla controladorProductoCasilla;
	private int fila;
	private int columna;
	private boolean estaMaquinaInicializada;
	private Producto producto;
	private Casilla casilla;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Venta frame = new Venta(new MenuOperario());
					frame.setResizable(false);
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	
	public Venta(MenuOperario menuOperario)
	{
		this.menuOperario = menuOperario;
		cantidad = 0;
		maquina = menuOperario.getInicializarMaquina1().getMaquina();
		pnlMaquina = new JPanel();
		GridLayout gl;
		
		if (maquina != null)
		{
			gl = new GridLayout(0, maquina.length);
		}
		else
		{
			gl = new GridLayout(0, 1);
		}
		
		pnlMaquina.setLayout(gl);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1190, 725);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		soyAdmin = new JButton("Soy administrador");
		soyAdmin.setBounds(460, 20, 140, 23);
		contentPane.add(soyAdmin);
		cancelarTransaccion = new JButton("Cancelar transaccion");
		cancelarTransaccion.setBounds(460, 60, 165, 23);
		contentPane.add(cancelarTransaccion);
		mensaje2 = new JLabel("Bienvenido Comprador");
		mensaje2.setFont(new Font("Segoe UI Emoji", Font.ITALIC, 16));
		mensaje2.setBounds(180, 20, 164, 25);
		contentPane.add(mensaje2);
		nombreProducto = new JTextField();
		nombreProducto.setBounds(200, 78, 133, 23);
		contentPane.add(nombreProducto);
		nombreProducto.setColumns(10);
		textoProducto = new JLabel("Producto comprado:");
		textoProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textoProducto.setBounds(68, 78, 146, 19);
		contentPane.add(textoProducto);
		textoPrecio = new JLabel("Precio:");
		textoPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textoPrecio.setBounds(156, 140, 146, 19);
		contentPane.add(textoPrecio);
		precioProducto = new JTextField();
		precioProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		precioProducto.setBounds(200, 140, 133, 23);
		contentPane.add(precioProducto);
		mensaje1 = new JLabel("seleccione los billetes y/o monedas con los " + "cu�les va a pagar");
		mensaje1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mensaje1.setBounds(38, 268, 445, 19);
		contentPane.add(mensaje1);
		monedaDeCien = new JLabel("");
		monedaDeCien.setIcon(new ImageIcon(Venta.class.getResource("/imagenes/MonedaDe100.PNG")));
		monedaDeCien.setBounds(46, 320, 64, 58);
		contentPane.add(monedaDeCien);
		monedaDe200 = new JLabel("");
		monedaDe200.setIcon(new ImageIcon(Venta.class.getResource("/imagenes/MonedaDe200.PNG")));
		monedaDe200.setBounds(115, 322, 46, 53);
		contentPane.add(monedaDe200);
		monedaDe500 = new JLabel("");
		monedaDe500.setIcon(new ImageIcon(Venta.class.getResource("/imagenes/MonedaDe500.PNG")));
		monedaDe500.setBounds(186, 320, 54, 58);
		contentPane.add(monedaDe500);
		billeteDe1000 = new JLabel("");
		billeteDe1000.setIcon(new ImageIcon(Venta.class.getResource("/imagenes/billeteDe1000.PNG")));
		billeteDe1000.setBounds(266, 320, 114, 59);
		contentPane.add(billeteDe1000);
		billeteDe2000 = new JLabel("");
		billeteDe2000.setIcon(new ImageIcon(Venta.class.getResource("/imagenes/billeteDe2000.PNG")));
		billeteDe2000.setBounds(46, 390, 114, 58);
		contentPane.add(billeteDe2000);
		billeteDe5000 = new JLabel("");
		billeteDe5000.setIcon(new ImageIcon(Venta.class.getResource("/imagenes/billeteDe5000.PNG")));
		billeteDe5000.setBounds(178, 390, 106, 52);
		contentPane.add(billeteDe5000);
		billeteDe10000 = new JLabel("");
		billeteDe10000.setIcon(new ImageIcon(Venta.class.getResource("/imagenes/billeteDe10000.PNG")));
		billeteDe10000.setBounds(300, 390, 114, 59);
		contentPane.add(billeteDe10000);
		billeteDe20000 = new JLabel("");
		billeteDe20000.setIcon(new ImageIcon(Venta.class.getResource("/imagenes/billeteDe20000.PNG")));
		billeteDe20000.setBounds(46, 460, 114, 59);
		contentPane.add(billeteDe20000);
		billeteDe50000 = new JLabel("");
		billeteDe50000.setIcon(new ImageIcon(Venta.class.getResource("/imagenes/billeteDe50000.PNG")));
		billeteDe50000.setBounds(163, 458, 114, 59);
		contentPane.add(billeteDe50000);
		billeteDe100000 = new JLabel("");
		billeteDe100000.setIcon(new ImageIcon(Venta.class.getResource("/imagenes/billeteDeCienMil.PNG")));
		billeteDe100000.setBounds(295, 458, 139, 59);
		contentPane.add(billeteDe100000);
		realizarCompra = new JButton("Realizar Compra");
		realizarCompra.setBounds(130, 615, 165, 23);
		contentPane.add(realizarCompra);
		regresar = new JButton("Regresar");
		regresar.setBounds(305, 615, 165, 23);
		contentPane.add(regresar);
		txtCantidad = new JLabel("Cantidad ingresada: ");
		txtCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCantidad.setBounds(156, 529, 146, 19);
		contentPane.add(txtCantidad);
		cantidadIngresada = new JTextField();
		cantidadIngresada.setBounds(156, 570, 121, 30);
		contentPane.add(cantidadIngresada);
		eventos();
		mostrarMaquina();
	}

	
	public void eventos()
	{
		regresar.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				cambiarInterfaz1();
			}
		});

		soyAdmin.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				cambiarInterfaz();

			}
		});

		cancelarTransaccion.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				if(precioProducto.getText().length()==0 && nombreProducto.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Usted no puede cancelar una compra que no ha hecho");
				}
				else if(cantidadIngresada.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Compra cancelada, vuelva pronto");
					nombreProducto.setText("");
					precioProducto.setText("");
				}
				else if(cantidadIngresada.getText().length()>0)
				{
					JOptionPane.showMessageDialog(null, "Usted no puede cancelar la compra");
				}
			}
		});

		monedaDeCien.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				eventoSeleccionDinero();
				// mostrarMaquina() ;
			}
		});

		monedaDe200.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				eventoSeleccionDinero200();
				// mostrarMaquina() ;
			}
		});

		monedaDe500.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				eventoSeleccionDinero500();
				// mostrarMaquina() ;

			}
		});

		billeteDe1000.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				eventoSeleccionDinero1000();
			}
		});

		billeteDe2000.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				eventoSeleccionDinero2000();
			}
		});

		billeteDe5000.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				eventoSeleccionDinero5000();
			}
		});

		billeteDe10000.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0) {
				eventoSeleccionDinero10000();
				// mostrarMaquina() ;
			}
		});

		billeteDe20000.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				eventoSeleccionDinero20000();
			}
		});

		billeteDe50000.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				eventoSeleccionDinero50000();
			}
		});

		billeteDe100000.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				eventoSeleccionDinero100000();
			}
		});

		realizarCompra.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				int dineroIngresado = Integer.parseInt(cantidadIngresada.getText());
				int cantidadProducto = casilla.getCantidadDeProducto();
				int vueltas = producto.getPrecio()-dineroIngresado;
				
				if (cantidadProducto > 0)
				{
					if (dineroIngresado >= producto.getPrecio())
					{
						Casilla casilla = maquina[fila][columna];
						casilla.setCantidadDeProducto(--cantidadProducto);
						maquina[fila][columna] = casilla;
						JOptionPane.showMessageDialog(null, "Compra realizada con exito"
						+"Usted compro: "+producto.getNombre()+"Precio :"
								+producto.getPrecio()+"usted ingreso"+ dineroIngresado +
								"y su cambio es:"+vueltas);
						System.out.println(casilla.getCantidadDeProducto() + " DESPUES");
						mostrarMaquina();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "El dinero ingresado no es suficiente");
					}
				}
				else if(nombreProducto.getText().length()==0 && precioProducto.getText().length()==0 && cantidadIngresada.getText().length()==0)
				{
				   JOptionPane.showMessageDialog(null, "Usted no seleccionado ning�n producto");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No hay productos disponibles");
				}
			}
		});
	}

	
	public void seleccionarCasillaCompra(MouseEvent event)
	{
		try
		{
			String coordenadas = ((JButton) event.getSource()).getName();
			fila = Integer.parseInt(coordenadas.split("-")[0]);
			columna = Integer.parseInt(coordenadas.split("-")[1]);
			casilla = maquina[fila][columna];
			producto = buscarProducto(casilla.getIdProducto());
			precioProducto.setText("$" + producto.getPrecio());
			nombreProducto.setText(producto.getNombre());
			System.out.println(casilla.getCantidadDeProducto());
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "Producto no disponible");
		}
	}

	public Producto buscarProducto(int idProducto)
	{
		Producto[] productos = menuOperario.getVerListaDeProductos().verProductos();
		Producto prod = null;
		
		for (Producto pr : productos)
		{
			if (pr.getIdProducto() == idProducto)
			{
				prod = pr;
				break;
			}
		}
		return prod;
	}

	
	public void mostrarMaquina()
	{
		try
		{
			pnlMaquina.removeAll();
			getContentPane().remove(pnlMaquina);

			for (int i = 0; i < maquina.length; i++)
			{
				for (int j = 0; j < maquina[0].length; j++)
				{
					boton = maquina[i][j].getBoton();
					
					if (boton.getText().length() == 1)
					{
						boton.setText("(" + (i + 1) + "-" + (j + 1) + ")");
					}
					
					boton.setBounds((120 * i) + 500, (80 * j) + 85, 300, 50);
					
					boton.addMouseListener(new MouseAdapter()
					{
						@Override
						public void mouseClicked(MouseEvent event)
						{
							seleccionarCasillaCompra(event);
						}
					});

					pnlMaquina.add(boton);
					System.out.println("(" + (i + 1) + "-" + (j + 1) + ")");
				}
			}
			
			System.out.println(pnlMaquina.getPreferredSize() + " tamanio de panel");
			pnlMaquina.setBounds(500, 120, 620, 120);
			getContentPane().add(pnlMaquina);
			getContentPane().revalidate();
			getContentPane().repaint();
			System.out.println("Termino la insercion");
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "Debe inicializar la maquina primero.");
			menuOperario.setVisible(true);
			setVisible(false);
			estaMaquinaInicializada = true;
		}
	}

	
	public void cambiarInterfaz()
	{
		InicioOperario inicioOperario = new InicioOperario();
		inicioOperario.setVisible(true);
		this.dispose();
	}

	
	public void cambiarInterfaz1()
	{
		menuOperario.setVisible(true);
		this.dispose();
	}

	
	public void eventoSeleccionDinero()
	{
		String valor = "";
		cantidad = cantidad + 100;
		valor = Integer.toString(cantidad);
		cantidadIngresada.setText(valor);
	}

	
	public void eventoSeleccionDinero200()
	{
		String valor = "";
		cantidad = cantidad + 200;
		valor = Integer.toString(cantidad);
		cantidadIngresada.setText(valor);
	}

	
	public void eventoSeleccionDinero500()
	{
		String valor = "";
		cantidad = cantidad + 500;
		valor = Integer.toString(cantidad);
		cantidadIngresada.setText(valor);
	}

	
	public void eventoSeleccionDinero1000()
	{
		String valor = "";
		cantidad = cantidad + 1000;
		valor = Integer.toString(cantidad);
		cantidadIngresada.setText(valor);
	}

	
	public void eventoSeleccionDinero2000()
	{
		String valor = "";
		cantidad = cantidad + 2000;
		valor = Integer.toString(cantidad);
		cantidadIngresada.setText(valor);
	}

	
	public void eventoSeleccionDinero5000()
	{
		String valor = "";
		cantidad = cantidad + 5000;
		valor = Integer.toString(cantidad);
		cantidadIngresada.setText(valor);
	}

	
	public void eventoSeleccionDinero10000()
	{
		String valor = "";
		cantidad = cantidad + 10000;
		valor = Integer.toString(cantidad);
		cantidadIngresada.setText(valor);
	}

	
	public void eventoSeleccionDinero20000()
	{
		String valor = "";
		cantidad = cantidad + 20000;
		valor = Integer.toString(cantidad);
		cantidadIngresada.setText(valor);
	}

	
	public void eventoSeleccionDinero50000()
	{
		String valor = "";
		cantidad = cantidad + 50000;
		valor = Integer.toString(cantidad);
		cantidadIngresada.setText(valor);
	}

	
	public void eventoSeleccionDinero100000()
	{
		String valor = "";
		cantidad = cantidad + 100000;
		valor = Integer.toString(cantidad);
		cantidadIngresada.setText(valor);
	}

	
	public boolean isEstaMaquinaInicializada()
	{
		return estaMaquinaInicializada;
	}
}