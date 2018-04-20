package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import vo.Producto;

public class EliminarProducto extends JFrame
{
	private static final long serialVersionUID = 1L;
	private MenuOperario menuOperario;
	private JLabel lblSeleccion;
	private JLabel lblMensajes;
	private JTextField nombreProducto;
	private JButton buscarProducto;
	private JButton eliminarProducto;
	private JButton regresarMenu;
	private String[][] datos;
	private JTable table;
	private DefaultTableModel dtm;
	
	public EliminarProducto(MenuOperario menuOperario)
	{
		this.menuOperario=menuOperario;
		setBounds(100, 10, 900, 690);
		this.setTitle("Eliminar Productos de la lista");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lblSeleccion = new JLabel("Escriba el nombre del producto que va a eliminar");
		lblSeleccion.setFont(new Font("TI-Nspire", Font.PLAIN, 14));
		lblSeleccion.setBounds(52, 527, 353, 37);				
		getContentPane().add(lblSeleccion);	
		nombreProducto=new JTextField();
		nombreProducto.setBounds(90, 560, 210, 23);
		getContentPane().add(nombreProducto);
		buscarProducto = new JButton("Buscar Producto");
		buscarProducto.setBounds(60, 590, 146, 37);
		getContentPane().add(buscarProducto);
		lblMensajes = new JLabel("Msg: ");
		lblMensajes.setBounds(320, 555, 146, 37);
		getContentPane().add(lblMensajes);
		eliminarProducto = new JButton("Eliminar Producto");				
		eliminarProducto.setBounds(230, 590, 146, 37);
		getContentPane().add(eliminarProducto);	
		regresarMenu = new JButton("Regresar");				
		regresarMenu.setBounds(680, 590, 146, 37);
		getContentPane().add(regresarMenu);	
		dtm = listarProductos();
		table = new JTable(dtm);	
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		eventoBuscarProducto();
		eventoRegresarAlMenu();
		eventoEliminarProducto();
	}
	
	public void eventoEliminarProducto()
	{
		eliminarProducto.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{							
				lblMensajes.setText( menuOperario.controladorProductoCasilla.eliminarProducto(nombreProducto.getText()));
				dtm = listarProductos();
				table.setModel(dtm);
			}
		});
	}
	
	public void eventoBuscarProducto()
	{
		buscarProducto.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				lblMensajes.setText( buscarProducto(nombreProducto.getText()));			
			}
		});
	}
	
	public void eventoRegresarAlMenu()
	{
		regresarMenu.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
			   regresarAlMenu();
			}
		});
	}
	
	public void regresarAlMenu()
	{
		menuOperario.setVisible(true);
	    this.dispose();
	}
	
	public Producto[] verProductos()
	{
		return menuOperario.controladorProductoCasilla.listarProductos();
	}

	public String buscarProducto(String nombreProducto)
	{
		String mensajeRta = "No se encontro el producto";
		for(Producto prd : verProductos())
		{
			if(prd!=null && nombreProducto.equalsIgnoreCase(prd.getNombre()))
			{
				mensajeRta = "Id: "+prd.getIdProducto()
				+" nombre: "+prd.getNombre()+" precio: "+prd.getPrecio();
				break;
			}
		}
		return mensajeRta;
	}
	
	public DefaultTableModel listarProductos()
	{
		Producto[] productos = verProductos();
		datos = new String[productos.length][3];
		for (int j = 0; j < datos.length; j++)
		{
			if(productos[j] !=null)
			{
				datos[j][0] = productos[j].getIdProducto() + "";
				datos[j][1] = productos[j].getNombre() + "";
				datos[j][2] = productos[j].getPrecio() + "";
			}
		}
		
		String[] columnNames = { "identificacion Producto", "Nombre Producto", "Precio", };
		dtm = new DefaultTableModel(datos, columnNames);
		return dtm;
	}
}