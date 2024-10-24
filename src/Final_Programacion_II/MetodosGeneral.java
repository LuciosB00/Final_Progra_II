package Final_Programacion_II;

import java.time.LocalDate;
import java.util.Scanner;

public class MetodosGeneral {

	public static LocalDate crearFecha (String mensaje) {
		System.out.println(mensaje);
		String dia=null,mes=null,año=null;
		int diaAux=0,mesAux=0,añoAux=0;
		
		diaAux = castearEntero("Ingrese el dia: ", dia);
		mesAux = castearEntero("Ingrese el mes: ", mes);
		añoAux = castearEntero("Ingrese el año: ", año);
		
		LocalDate aux = LocalDate.of(añoAux, mesAux, diaAux);
		return aux;
	}
	
	public static boolean escogerBooleano (String mensaje) {
		String aux = null; int num;
		
		do {
			System.out.println(mensaje);
			System.out.println("1. Si");
			System.out.println("2. No");
			
			num = MetodosGeneral.castearEntero("Ingrese algo:", aux);
		}while(num >= 1 && num <= 2);
		
		if(num == 1) {
			return true;
		}
		
		return false;
	}
	
	public static int castearEntero (String mensaje, String dato) {
		int num = 0;
		boolean flag = true;
		Scanner entradaTeclado= new Scanner(System.in);
		
		do {
			System.out.print(mensaje);
			dato = entradaTeclado.nextLine();
			if(Excepciones.verificarEntero(dato)) {
				num = Integer.parseInt(dato);
				flag = true;
			} else {
				flag = false;
			}
		}while(flag == false);
		
		return num;
	}
	
	public static double castearDecimal (String mensaje, String dato) {
		double num = 0;
		boolean flag = true;
		Scanner entradaTeclado= new Scanner(System.in);
		
		do {
			System.out.print(mensaje);
			dato = entradaTeclado.nextLine();
			if(Excepciones.verificarEntero(dato)) {
				num = Double.parseDouble(dato);
				flag = true;
			} else {
				flag = false;
			}
		}while(flag == false);
		
		return num;
	}
	
	// Metodos Enumeradores
	public static Sexo escogerGenero () {
		Sexo generoSeleccionado;
		int seleccion;
		String seleccionAux = null;
		Scanner teclado = new Scanner (System.in);
		
		do {
			System.out.println("Generos disponibles:");
			for(Sexo genero: Sexo.values()) {
				System.out.println(genero.ordinal() + 1 + "." + genero);
			}
			seleccion = MetodosGeneral.castearEntero("Seleccione algún genero: ", seleccionAux);
		}while(seleccion < 1 || seleccion > 3);
		
		return generoSeleccionado = Sexo.values()[seleccion - 1];
	}
	
	public static Provincia escogerProvincia () {
		Provincia provinciaSeleccionada;
		int seleccion;
		String seleccionAux = null;
		Scanner teclado = new Scanner (System.in);
		
		do {
			System.out.println("Provincias disponibles:");
			for(Provincia prov: Provincia.values()) {
				System.out.println(prov.ordinal() + 1 + "." + prov.obtenerProvincia());
			}
			seleccion = MetodosGeneral.castearEntero("Seleccione alguna provincia: ", seleccionAux);
		}while(seleccion < 1 || seleccion > 23);
		
		return provinciaSeleccionada = Provincia.values()[seleccion - 1];
	}
	
	public static Categoria escogerCategoria () {
		Categoria categoriaSeleccionada;
		int seleccion;
		String seleccionAux = null;
		Scanner teclado = new Scanner (System.in);
		
		do {
			System.out.println("Provincias disponibles:");
			for(Categoria cate: Categoria.values()) {
				System.out.println(cate.ordinal() + 1 + "." + cate.obtenerCategoria());
			}
			seleccion = MetodosGeneral.castearEntero("Seleccione alguna categoria: ", seleccionAux);
		}while(seleccion < 1 || seleccion > 3);
		
		return categoriaSeleccionada = Categoria.values()[seleccion - 1];
	}
	
	public static FormaPago escogerFomaPago () {
		FormaPago pagoSeleccionada;
		int seleccion;
		String seleccionAux = null;
		Scanner teclado = new Scanner (System.in);
		
		do {
			System.out.println("Formas de pago disponibles:");
			for(FormaPago forma: FormaPago.values()) {
				System.out.println(forma.ordinal() + 1 + "." + forma.obetenerFormaPago());
			}
			seleccion = MetodosGeneral.castearEntero("Seleccione alguna forma de pago: ", seleccionAux);
		}while(seleccion < 1 || seleccion > 5);
		
		return pagoSeleccionada = FormaPago.values()[seleccion - 1];
	}
}