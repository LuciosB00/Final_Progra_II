package Final_Programacion_II;

import java.util.ArrayList;
import java.util.Scanner;

public class Movimiento {
	public static ArrayList <Movimiento> listaMovimientos = new ArrayList <Movimiento> ();
	
	// Atributos
	private int codigo;
	private String detalle;
	private double montoDebe;
	private double montoHaber;
	private double saldo;
	
	// Constructor
	public Movimiento (int codigo, double saldo, String detalle, double montoDebe, double montoHaber) {
		this.codigo = codigo;
		this.saldo = saldo;
		this.detalle = detalle;
		this.montoDebe = montoDebe;
		this.montoHaber = montoHaber;
	}
	
	// Setters y Getters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public double getMontoDebe() {
		return montoDebe;
	}
	public void setMontoDebe(double montoDebe) {
		this.montoDebe = montoDebe;
	}

	public double getMontoHaber() {
		return montoHaber;
	}
	public void setMontoHaber(double montoHaber) {
		this.montoHaber = montoHaber;
	}

	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	// Metodos
	public static void agregarMovimiento () {
		Scanner teclado = new Scanner (System.in);
		
		int codigo; String detalle; double montoDebe, saldo, montoHaber;
		String codigoAux=null, saldoAux=null, montoDebeAux=null, montoHaberAux=null;
		
		codigo = MetodosGeneral.castearEntero("Ingrese el codigo del movimiento:", codigoAux);
		System.out.println("Ingrese detalle del movimiento:");
		detalle = teclado.nextLine();
		saldo = MetodosGeneral.castearDecimal("Ingrese el saldo del movimiento:", saldoAux);
		montoDebe = MetodosGeneral.castearDecimal("Ingrese el monto a deber:", montoDebeAux);
		montoHaber = MetodosGeneral.castearDecimal("Ingrese el mono de haber:", montoHaberAux);
		
		Movimiento nuevoMovimiento = new Movimiento (codigo, saldo, detalle, montoDebe, montoHaber);
		listaMovimientos.add(nuevoMovimiento);
	}
	
	public Movimiento altaMovimiento () {
		return null;
	}
	
	public void modificarMovimiento () {
		// MODIFICAR ALGÚN DATO DE ALGÚN MOVIMIENTO
	}
	
	public void bajaMovimiento () {
		
	}
}
