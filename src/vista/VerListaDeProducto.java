package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import vo.Producto;

public class VerListaDeProducto extends JFrame
{
	private static final long serialVersionUID = 1L;
	private MenuOperario menuOperario;
	

	public VerListaDeProducto(MenuOperario menuOperario)
	{
		this.menuOperario = menuOperario;
		setBounds(150, 100, 400, 690);
		this.setTitle("Lista de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Producto[] productos = verProductos();
		String[][] datos = new String[productos.length][3];
		
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
		DefaultTableModel dtm = new DefaultTableModel(datos, columnNames);
		JTable table = new JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	}

	
	public Producto[] verProductos()
	{
		return menuOperario.controladorProductoCasilla.listarProductos();
	}
}