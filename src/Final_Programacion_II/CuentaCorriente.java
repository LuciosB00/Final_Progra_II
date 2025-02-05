package Final_Programacion_II;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

public class CuentaCorriente {
	public static ArrayList <CuentaCorriente> listaCtaCtes = new ArrayList <CuentaCorriente> ();
	
	// Atributos
	private String detalle;
	private int codigo;
	private ArrayList <Movimiento> movimientos = new ArrayList <Movimiento> ();
	
	// Constructor
	public CuentaCorriente (ArrayList <Movimiento> movimientos, String detalle, int codigo) {
		this.movimientos = movimientos;
		this.detalle = detalle;
	}
	
	//Setters y Getters
	public ArrayList <Movimiento> getMovimientos (){
		return movimientos;
	}
	public void setMovimientos (ArrayList <Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	//Metodos
	public static void altaCtaCte (ArrayList <Movimiento> movimientos) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese el detalle de la cuenta: ");
		String detalle = teclado.nextLine();
		
		int codigo; String codigoAux = null;
		codigo = MetodosGeneral.castearEntero("Ingrese el codigo de la cuenta: ", codigoAux);
		
		teclado.close();
		
		CuentaCorriente nuevaCtaCte = new CuentaCorriente(movimientos, detalle, codigo);
		listaCtaCtes.add(nuevaCtaCte);
	}
	
	public void agregarMovimiento (ArrayList <Movimiento> movimientos, Movimiento movimiento) {
		if(movimiento != null && movimientos != null) {
			movimientos.add(movimiento);
			this.setMovimientos(movimientos);
		}else {
			System.out.println("Los datos no se han encontrado.");
		}
	}
	
	public void actualizarSaldo (Movimiento movimiento) {
		if(movimiento != null) {
			double nuevoSaldo; String nuevoSaldoAux=null;
			System.out.println("Detalle del movimiento: " + movimiento.getDetalle());
			System.out.println("Su saldo actual es: " + movimiento.getSaldo());
			
			if(MetodosGeneral.escogerBooleano("¿Desea actualizar su saldo?:")) {
				nuevoSaldo = MetodosGeneral.castearDecimal("Ingrese el nuevo saldo:", nuevoSaldoAux);
				movimiento.setSaldo(nuevoSaldo);
				movimiento.setSaldo(movimiento.calcularSaldo(movimiento));
			}
		}else {
			System.out.println("Los datos no se han encontrado.");
		}
	}
	
	public void datosCtaCte (ArrayList <Movimiento> movimientos) {
		if(movimientos != null) {
			System.out.println("Detalles de la cuenta: " + this.detalle);
			for (Movimiento elemento : movimientos) {
				elemento.datosMovimiento(elemento);
			}
			System.out.println("------------------------------");
		}else {
			System.out.println("Los datos no se han encontrado.");
		}
	}
	
	public void modificarCtaCte(CuentaCorriente ctacte) {
		if(ctacte != null) {
			Scanner teclado = new Scanner(System.in);
			
			System.out.println("1 - Modificar codigo.");
			System.out.println("2 - Modificar detalle.");
			System.out.println("3 - Salir.");
			
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 && num > 3);
			
			switch(num) {
			case 1:
				String codigoAux = null;
				int codigo = MetodosGeneral.castearEntero("Ingrese el codigo del movimiento:", codigoAux);
				ctacte.setCodigo(codigo);
				break;
				
			case 2:
				System.out.println("Ingrese detalle de la cuenta:");
				String detalle = teclado.nextLine();
				ctacte.setDetalle(detalle);
				break;
				
			case 3:
				System.out.println("Saliendo...");
				break;
				
			default:
				break;
			}
			teclado.close();
		}
	}
	
	public static void listarCtaCtes() {
		if(CuentaCorriente.listaCtaCtes != null) {
			for(CuentaCorriente elemento : listaCtaCtes) {
				elemento.datosCtaCte(elemento.getMovimientos());
			}
		}else {
			System.out.println("Los datos no se han encontrado.");
		}
	}
	
	public static CuentaCorriente buscarCtaCteCodigo () {
		int codigo; String codigoAux=null;
		codigo = MetodosGeneral.castearEntero("Ingrese el codigo del producto a buscar: ", codigoAux);
		for(CuentaCorriente elemento : listaCtaCtes) {
			if(codigo == elemento.getCodigo()) {
				System.out.println("La venta SI fue encontrado.");
				return elemento;
			}
		}
		System.out.println("La venta NO fue encontrado.");
		return null;
	}
}
