package Final_Programacion_II;

import java.time.LocalDate;
import java.util.Scanner;

public class MetodosGeneral {

	// LOCALDATE
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
	
	// BOOLEAN
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
	
	public static String verificarBooleano (boolean activo) {
		if(activo) {
			return "Si";
		} else {
			return "No";
		}
	}
	
	// CASTEO DE DATOS
	public static int castearEntero (String mensaje, String dato) {
		int num = 0; boolean flag = true;
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
		
		entradaTeclado.close();
		
		return num;
	}
	
	public static double castearDecimal (String mensaje, String dato) {
		double num = 0;	boolean flag = true;
		Scanner entradaTeclado = new Scanner(System.in);
		
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
		
		entradaTeclado.close();
		
		return num;
	}
	
}