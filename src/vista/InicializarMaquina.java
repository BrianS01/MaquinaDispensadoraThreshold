package vista;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import vo.Casilla;


public class InicializarMaquina extends JFrame
{
	private JPanel contentPane;
	private JTextField valorFila;
	private JTextField valorColumna;
	private MenuOperario menuOperario;
	private JButton botonCrearMaquina;
	private Casilla[][]  maquina;
	private JLabel mensaje;
	private JPanel p;
	private JButton botonRegresar;

	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					InicializarMaquina frame = new InicializarMaquina(new MenuOperario());
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	
	public InicializarMaquina(MenuOperario menuOperario)
	{
		this.menuOperario = menuOperario;
		p = new JPanel();
		p.setBounds(500, 80, 500, 400);
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1140, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblSeleccione = new JLabel("Seleccione la cantidad de filas y columnas que va a tener la m\u00E1quina");
		lblSeleccione.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSeleccione.setBounds(25, 37, 405, 48);
		contentPane.add(lblSeleccione);
		JLabel lblFilas = new JLabel("filas");
		lblFilas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFilas.setBounds(49, 96, 46, 14);
		contentPane.add(lblFilas);
		JLabel lblColumnas = new JLabel("Columnas");
		lblColumnas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblColumnas.setBounds(35, 144, 73, 14);
		contentPane.add(lblColumnas);
		valorFila = new JTextField();
		valorFila.setFont(new Font("Tahoma", Font.PLAIN, 13));
		valorFila.setBounds(105, 91, 154, 28);
		contentPane.add(valorFila);
		valorFila.setColumns(10);
		valorColumna = new JTextField();
		valorColumna.setFont(new Font("Tahoma", Font.PLAIN, 13));
		valorColumna.setBounds(105, 139, 154, 28);
		contentPane.add(valorColumna);
		valorColumna.setColumns(10);
		botonCrearMaquina = new JButton("Crear maquina");
		botonCrearMaquina.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonCrearMaquina.setBounds(118, 206, 121, 20);
		contentPane.add(botonCrearMaquina);
		mensaje = new JLabel("Msg:");
		mensaje.setBounds(168, 170, 145, 37);
		contentPane.add(mensaje);
		botonRegresar = new JButton("Regresar");
		botonRegresar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonRegresar.setBounds(198, 180, 121, 23);
		contentPane.add(botonRegresar);
		eventos();
	}

	
	public void eventos()
	{
		crearArregloBotones();

		valorFila.addKeyListener(new KeyAdapter()
		{
			public void KeyReleased(KeyEvent e)
			{
				validarNumeros();
			}
		});

		valorColumna.addKeyListener(new KeyAdapter()
		{
			public void KeyReleased(KeyEvent e)
			{
				validarNumeros();
			}
		});

	}

	
	public void crearArregloBotones()
	{
		botonCrearMaquina.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				maquina = crearMaquina();
				GridLayout gl = new GridLayout(0, maquina[0].length);
				p.setLayout(gl);
				p.removeAll();
				getContentPane().remove(p);

				for (int i = 0; i < maquina.length; i++)
				{
					for (int j = 0; j < maquina[0].length; j++)
					{
						JButton boton = maquina[i][j].getBoton();
						boton.setName(i+"-"+j);
						boton.setBounds((150 * i) + 400, (80 * j) + 55, 100, 50);
						p.add(boton);
					}
				}
				getContentPane().add(p);
				getContentPane().revalidate();
				getContentPane().repaint();
				System.out.println("Termino la insercion");
			}
		});
		
		botonRegresar.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				setVisible(false);
				menuOperario.setVisible(true);
			}
		});
	}

	
	public Casilla[][] crearMaquina()
	{
		// valorFila.setText("3");
		return menuOperario.controladorProductoCasilla.crearMaquina(Integer.parseInt(valorFila.getText()),
				Integer.parseInt(valorColumna.getText()));

	}

	
	public void validarNumeros()
	{
		try
		{
			Integer.parseInt(valorFila.getText());
			Integer.parseInt(valorColumna.getText());
		}
		catch (NumberFormatException nfe)
		{
			valorFila.setText("");
			valorColumna.setText("");
			mensaje.setText("La fila y/o columna deben ser numericas");
		}
	}

	
	public Casilla[][] getMaquina()
	{
		return maquina;
	}
}