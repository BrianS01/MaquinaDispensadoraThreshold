package controlador;

import modelo.ServicioProductoCasilla;
import vo.Casilla;
import vo.Producto;
import vista.AgregarProductoCasilla;
import vista.VerListaDeProducto;

public class ControladorProductoCasilla
{
	private ServicioProductoCasilla servicioProductoCasilla;
	private AgregarProductoCasilla agregarProductoCasilla;
	
	public ControladorProductoCasilla()
	{
		servicioProductoCasilla = ServicioProductoCasilla.getInstance();
	}
	
	public String insertarProducto(int idProducto, String nombreProducto, int precio)
	{
		return servicioProductoCasilla.insertarProducto(idProducto, nombreProducto, precio);
	}
   
	
	public Producto[] listarProductos()
	{
		return servicioProductoCasilla.listarProductos();
	}

	public String eliminarProducto(String nombreProducto)
	{
		return servicioProductoCasilla.eliminarProducto(nombreProducto);
	}

	public Casilla[][] crearMaquina(int filas, int columnas)
	{
		return servicioProductoCasilla.crearMaquina(filas, columnas);
	}

	public void mostrarMaquina()
	{
		agregarProductoCasilla.mostrarMaquina();
	}
}