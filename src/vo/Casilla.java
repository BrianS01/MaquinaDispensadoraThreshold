package vo;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Casilla {
 
	private boolean disponibilidad;
	private int cantidadDeProducto;
	private JButton boton;
	private Integer idProducto;
	
	public Casilla(JButton boton) {
		this.boton = boton;
		this.boton.setText(cantidadDeProducto+"");
	}
	
	
	public JButton getBoton() {
		return boton;
	}

	public void setBoton(JButton boton) {
		this.boton = boton;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public int getCantidadDeProducto() {
		return cantidadDeProducto;
	}
	public void setCantidadDeProducto(int cantidadDeProducto) {
		this.cantidadDeProducto = cantidadDeProducto;
	}


	public Integer getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(Integer idPproducto) {
		this.idProducto = idPproducto;
	}
	
	
}
