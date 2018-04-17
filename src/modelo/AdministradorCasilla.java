package modelo;

import javax.swing.JButton;
import vo.Casilla;

public class AdministradorCasilla
{
	private static AdministradorCasilla administradorCasilla;
	private Casilla[][] casillas;
	public Casilla casilla;

	
	
	public AdministradorCasilla() {
		
	}
	
	public Casilla[][] crearMaquina(int filas,int columnas) {
		casillas=new Casilla[filas][columnas];
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < columnas ; j++) {
				casillas[i][j]= new Casilla(new JButton(("Fila:"+i+1+"  Columna:"+(j+1))));
				
			}
		}
		return casillas;
	}
	
    	

	
	public static AdministradorCasilla getInstance() {
		if(administradorCasilla==null) {
			return new AdministradorCasilla();
		}
		return administradorCasilla;
	}
}