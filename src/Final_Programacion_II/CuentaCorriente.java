package Final_Programacion_II;

import java.util.ArrayList;

public class CuentaCorriente {
	public static ArrayList <CuentaCorriente> listaCtaCtes = new ArrayList <CuentaCorriente> ();
	
	// Atributos
	private ArrayList <Movimiento> movimientos = new ArrayList <Movimiento> ();
	
	// Constructor
	public CuentaCorriente (ArrayList <Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	
	//Setters y Getters
	public ArrayList <Movimiento> getMovimientos (){
		return movimientos;
	}
	public void setMovimientos (ArrayList <Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	
	//Metodos
	public void agregarMovimiento (Movimiento movimiento) {
		movimientos.add(movimiento);
	}
	
	public void actualizarSaldo (Movimiento movimiento) {
		double nuevoSaldo; String nuevoSaldoAux=null;
		System.out.println("Detalle del movimiento: " + movimiento.getDetalle());
		System.out.println("Su saldo actual es: " + movimiento.getSaldo());
		
		if(MetodosGeneral.escogerBooleano("¿Desea actualizar su saldo?:")) {
			nuevoSaldo = MetodosGeneral.castearDecimal("Ingrese el nuevo saldo:", nuevoSaldoAux);
			movimiento.setSaldo(nuevoSaldo);
		}
	}
	
	public double obetenerSaldo () {
		return 0.00; 
	}
}
