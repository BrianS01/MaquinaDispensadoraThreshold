package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vo.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InsertarProducto extends JFrame
{
	private JPanel contentPane;
	private JTextField nombreProducto;
	private JLabel mensajes;
	private JTextField precio;
	private MenuOperario menuOperario;
	private JButton AgregarProducto;
	private JButton RegresarMenuOperario;
	private static int idProducto;


	public InsertarProducto(MenuOperario menuOperario)
	{
		this.menuOperario = menuOperario;
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNombreDelProducto = new JLabel("Nombre del producto");
		lblNombreDelProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreDelProducto.setBounds(111, 32, 198, 29);
		contentPane.add(lblNombreDelProducto);
		nombreProducto = new JTextField();
		
		nombreProducto.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
				int limit = 23;
				
				if (nombreProducto.getText().length() == limit)
				{
					e.consume();
				}
			}
		});
		
		nombreProducto.setBounds(70, 81, 228, 37);
		contentPane.add(nombreProducto);
		nombreProducto.setColumns(10);
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(162, 155, 50, 29);
		contentPane.add(lblPrecio);
		precio = new JTextField();
		precio.setBounds(70, 197, 228, 43);
		contentPane.add(precio);
		precio.setColumns(10);
		AgregarProducto = new JButton("Agregar Producto");
		AgregarProducto.setBounds(111, 281, 145, 37);
		contentPane.add(AgregarProducto);
		mensajes = new JLabel("Msg:");
		mensajes.setBounds(111, 320, 155, 37);
		contentPane.add(mensajes);
	    RegresarMenuOperario = new JButton("Regresar");		
		RegresarMenuOperario.setBounds(10, 349, 174, 23);
		contentPane.add(RegresarMenuOperario);
		eventos();
	}

	
	public void eventos()
	{
		AgregarProducto.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				try
				{
					String rta = "";
					idProducto++;
					rta = menuOperario.controladorProductoCasilla.insertarProducto(idProducto, nombreProducto.getText(),
					Integer.parseInt(precio.getText()));
					mensajes.setText(rta);
					precio.setText("");
					nombreProducto.setText("");
				}
				catch (NumberFormatException nfe)
				{
					JOptionPane.showMessageDialog(null, "El precio debe ser un valor numerico");
				}
			}
		});
		
		RegresarMenuOperario.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				cambiarInterfaz();
			}
		});
		
		precio.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
				int limit1 = 8;
				
				if (precio.getText().length() == limit1)
				{
					e.consume();
				}						
			}
			
			@Override
			public void keyReleased(KeyEvent e)
			{
				validarNumeros();
			}
		});
		
	}
	
	
	public void validarNumeros()
	{
		try
		{
			Integer.parseInt(precio.getText());
		}
		catch(NumberFormatException nfe)
		{
			precio.setText("");
			mensajes.setText("El precio debe ser numerico");									
		}
	}
	
	
	public void validarProducto(String nombreProducto, String precio)
	{
		if (nombreProducto.equals("") || precio.equals(""))
		{
			JOptionPane.showMessageDialog(null, "No deje los espacios en blanco");
		}
	}
	
	
	 public void cambiarInterfaz(){
		 menuOperario.setVisible(true);
		 this.dispose();
     }
}