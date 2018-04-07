package modelo;

import vo.Producto;

public class AdministradorProducto {

	private static AdministradorProducto administradorProducto;
	public Producto producto;
	private Producto[] misProductos;

	public AdministradorProducto() {
		misProductos = new Producto[30];
	}

	public String insertarProducto(int idProducto, String nombre, int precio) {
		producto = new Producto(idProducto, nombre, precio);
		String rta="No se logro insertar el producto";
		for (int i = 0; i < misProductos.length; i++) {
			if (misProductos[i] == null) {
				misProductos[i] = producto;
				rta = "Producto agregado exitosamente";
				break;
			}
		}
		return rta;
	}

	public static AdministradorProducto getInstance() {
		if (administradorProducto == null) {
			return new AdministradorProducto();
		}
		return administradorProducto;

	}

	public String eliminarProducto(String nombreProducto) {
		int indiceEliminar = -1;
		String mensaje="El producto "+nombreProducto+" no se encontro.";
		for (int i = 0; i < misProductos.length; i++) {
			if (misProductos[i].getNombre().equals(nombreProducto)) {
				indiceEliminar = i;
				break;
			}
		}
		if (indiceEliminar >= 0) {
			misProductos[indiceEliminar] = null;
			mensaje="Se elimino exitosamente el producto "+nombreProducto;
		}
		return mensaje;
	}
	
	

	// }
	/*
	 * public void eliminarProducto(int idProducto) { for (int i = 0; i <
	 * misProductos.length; i++) { if(misProductos[i].getIdProducto()==idProducto) {
	 * misProductos[idProducto]=null; 
	 * misProductos[i]=misProductos[i-1]; } } }
	 */

	public Producto[] listarProducto() {
		return misProductos;
	}

}
