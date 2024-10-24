package Final_Programacion_II;

import java.util.ArrayList;

public class CuentaCorriente {
	public static ArrayList <CuentaCorriente> listaCtaCtes = new ArrayList <CuentaCorriente> ();
	
	// Atributos
	private ArrayList <Movimiento> movimientos = new ArrayList <Movimiento> ();
	
	//Metodos
	public void agregarMovimiento (Movimiento movimiento) {
		movimientos.add(movimiento);
	}
	
	public void actualizarSaldo (Movimiento movimientio) {
		
	}
	
	public double obetenerSaldo () {
		return 0.00; 
	}
}
