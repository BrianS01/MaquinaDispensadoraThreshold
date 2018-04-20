package modelo;

import vo.Casilla;
import vo.Producto;

public class ServicioProductoCasilla
{
	private AdministradorProducto adminproducto;
	private static ServicioProductoCasilla servicioProductoCasilla ;	
	private AdministradorCasilla admincasilla;
	
	
	private ServicioProductoCasilla()
	{
		adminproducto = AdministradorProducto.getInstance();
		admincasilla = AdministradorCasilla.getInstance();
	}
	
	
	public static ServicioProductoCasilla getInstance()
	{
		if(servicioProductoCasilla==null)
		{
			return new ServicioProductoCasilla();
		}
		return servicioProductoCasilla;
	}

	
	public String insertarProducto(int idProducto, String nombreProducto, int precio)
	{
		return adminproducto.insertarProducto(idProducto, nombreProducto, precio);
	}
	
	
	public Producto[] listarProductos()
	{
		return adminproducto.listarProducto();
	}
	
	
	public String eliminarProducto(String nombreProducto)
	{
		return adminproducto.eliminarProducto(nombreProducto);
	}
	
	
	public Casilla[][] crearMaquina(int filas, int columnas)
	{
		return admincasilla.crearMaquina(filas, columnas);
	}
}