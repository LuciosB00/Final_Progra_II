package Clases;

import Final_Programacion_II.MetodosGeneral;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Movimiento implements Serializable{
	private static final long serialVersionUID = 1L;
	public static ArrayList <Movimiento> listaMovimientos = new ArrayList <Movimiento> ();
	
	// Atributos
	private int codigo;
	private String detalle;
	private double montoDebe;
	private double montoHaber;
	private double saldo;
	private boolean activo;
	
	// Constructor
	public Movimiento (int codigo, double saldo, String detalle, double montoDebe, double montoHaber, boolean activo) {
		this.codigo = codigo;
		this.saldo = saldo;
		this.detalle = detalle;
		this.montoDebe = montoDebe;
		this.montoHaber = montoHaber;
		this.activo = activo;
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
	
	public boolean getActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	// Metodos
	public static void altaMovimiento () {
		Scanner teclado = new Scanner (System.in);
		
		int codigo; String detalle; double montoDebe, saldo, montoHaber;
		String codigoAux=null, saldoAux=null, montoDebeAux=null, montoHaberAux=null;
		
		codigo = MetodosGeneral.castearEntero("Ingrese el codigo del movimiento:", codigoAux);
		
		System.out.println("Ingrese detalle del movimiento:");
		detalle = teclado.nextLine();
		
		saldo = MetodosGeneral.castearDecimal("Ingrese el saldo del movimiento:", saldoAux);
		
		montoDebe = MetodosGeneral.castearDecimal("Ingrese el monto a deber:", montoDebeAux);
		
		montoHaber = MetodosGeneral.castearDecimal("Ingrese el mono de haber:", montoHaberAux);
		
		boolean activo = true;
		
		Movimiento nuevoMovimiento = new Movimiento (codigo, saldo, detalle, montoDebe, montoHaber, activo);
		listaMovimientos.add(nuevoMovimiento);
		
		teclado.close();
	}
	
	public void modificarMovimiento (Movimiento movimiento) {
		if(movimiento != null) {
			Scanner teclado = new Scanner(System.in);
			
			System.out.println("1 - Modificar codigo.");
			System.out.println("2 - Modificar detalle.");
			System.out.println("3 - Modificar saldo.");
			System.out.println("4 - Modificar monto debe.");
			System.out.println("5 - Modificar monto haber.");
			System.out.println("6 - Salir.");
			
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 && num > 9);
			
			switch(num) {
			case 1:
				String codigoAux = null;
				int codigo = MetodosGeneral.castearEntero("Ingrese el codigo del movimiento:", codigoAux);
				movimiento.setCodigo(codigo);
				break;
						
			case 2:
				System.out.println("Ingrese detalle del movimiento:");
				String detalle = teclado.nextLine();
				movimiento.setDetalle(detalle);
				break;
						
			case 3:
				String saldoAux = null;
				double saldo = MetodosGeneral.castearDecimal("Ingrese el saldo del movimiento:", saldoAux);
				movimiento.setSaldo(saldo);
				break;
						
			case 4:
				String montoDebeAux = null;
				double montoDebe = MetodosGeneral.castearDecimal("Ingrese el monto a deber:", montoDebeAux);
				movimiento.setMontoDebe(montoDebe);
				break;
					
			case 5:
				String montoHaberAux = null;
				double montoHaber = MetodosGeneral.castearDecimal("Ingrese el mono de haber:", montoHaberAux);
				movimiento.setMontoHaber(montoHaber);
				break;
						
			case 6:
				System.out.println("Saliendo...");
				break;
						
			default:
				break;
			}
			teclado.close();
		}else {
			System.out.println("No se encontraron los datos.");
		}
	}
	
	public void bajaMovimiento (Movimiento movimiento) {
		if(movimiento != null) {
			movimiento.setActivo(false);
		}else {
			System.out.println("No se encontraron los datos.");
		}
	}
	
	public void datosMovimiento (Movimiento movimiento) {
		if(movimiento != null) {
			System.out.println("Datos del movimiento:");
			System.out.println("Codigo: " + movimiento.getCodigo());
			System.out.println("Detalle: " + movimiento.getDetalle());
			System.out.println("Saldo: " + movimiento.getSaldo());
			System.out.println("Precio: " + movimiento.getMontoHaber());
			System.out.println("Marca: " + movimiento.getMontoHaber());
			System.out.println("Talle: " + MetodosGeneral.verificarBooleano(movimiento.getActivo()));
			System.out.println("Activo: " + MetodosGeneral.verificarBooleano(movimiento.getActivo()));
			System.out.println("------------------------------");
		}else {
			System.out.println("No se encontraron los datos.");
		}
	}
	
	public static void listarMovimientos () {
		if(Movimiento.listaMovimientos != null) {
			for (Movimiento elemento : listaMovimientos) {
				elemento.datosMovimiento(elemento);
			}
		}else {
			System.out.println("No se encontraron los datos.");
		}
	}
	
	public static Movimiento buscarMovimiento() {
		int codigo; String codigoAux=null;
		codigo = MetodosGeneral.castearEntero("Ingrese el codigo del producto a buscar: ", codigoAux);
		for(Movimiento elemento : listaMovimientos) {
			if(codigo == elemento.getCodigo()) {
				System.out.println("El movimiento SI fue encontrado.");
				return elemento;
			}
		}
		System.out.println("El movimiento NO fue encontrado.");
		return null;
	}
	
	public static ArrayList <Movimiento> crearMovimientos (Movimiento...movimientos){
		if(movimientos != null) {
			ArrayList <Movimiento> listarMovimientos = new ArrayList <Movimiento> ();
			for (Movimiento elemento : movimientos) {
				listarMovimientos.add(elemento);
			}
			return listarMovimientos;
		}else {
			System.out.println("No se encontraron los datos.");
		}
		return null;
	}
	
	public boolean validarMovimiento (Movimiento movimiento) {
		return this.montoDebe <= this.saldo;
	}
	
	public double calcularSaldo(Movimiento movimiento) {
		return movimiento.saldo += movimiento.montoHaber - movimiento.montoDebe;
	}
				
	public double calcularNeto(Movimiento movimiento) {
		return movimiento.montoHaber - movimiento.montoDebe;
	}
}
