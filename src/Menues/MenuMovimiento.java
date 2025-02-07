package Menues;

import java.util.ArrayList;

import Clases.Movimiento;
import Final_Programacion_II.MetodosGeneral;

public class MenuMovimiento {
	
	//MENUS MOVIMIENTO
	public static void menuDatosMovimiento(ArrayList <Movimiento> lista) {
		System.out.println("Bienvenido al menú de datos de movimiento/s:");
		System.out.println("1 - Datos de un movimiento.");
		System.out.println("2 - Datos de todos los movimiento.");
		System.out.println("3 - Salir.");
		
		Movimiento elemento = null;
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 || num > 3);
		
		switch(num) {
		case 1:
			elemento = menuSelectMovimiento(lista);
			elemento.datosMovimiento(elemento);
			break;
						
		case 2:
			Movimiento.listarMovimientos();
			break;
			
		case 3:
			System.out.println("Saliendo...");
			break;
						
		default:
			break;
		}
	}
			
	public static void menuIngresoMovimiento(ArrayList <Movimiento> lista) {
		System.out.println("Bienvenido al menú de ingreso de datos de movimiento/s:");
		System.out.println("1 - Ingresar un movimiento.");
		System.out.println("2 - Dar de baja a un movimiento.");
		System.out.println("3 - Buscar un producto por su codigo.");
		System.out.println("4 - Modificar algunos de los datos de un movimiento.");
		System.out.println("5 - Salir.");
	
		Movimiento elemento = null;
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 || num > 5);
					
		switch(num) {
		case 1:
			Movimiento.altaMovimiento();
			break;
						
		case 2:
			elemento = menuSelectMovimiento(lista);
			elemento.bajaMovimiento(elemento);
			break;
						
		case 3:
			elemento = Movimiento.buscarMovimiento();
			break;
						
		case 4:
			elemento = menuSelectMovimiento(lista);
			elemento.modificarMovimiento(elemento);
			break;
			
		case 5:
			System.out.println("Saliendo...");
			break;
						
		default:
			break;
		}
	}
	
	public static void menuMovimiento(Movimiento movimiento) {
		System.out.println("Bienvenido al menú general de movimiento/s:");
		System.out.println("1 - Ver datos.");
		System.out.println("2 - Modificar algún dato.");
		System.out.println("3 - Dar de baja");
		System.out.println("4 - Salir.");
	
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 || num > 4);
					
		switch(num) {
		case 1:
			movimiento.datosMovimiento(movimiento);
			break;
			
		case 2:
			movimiento.modificarMovimiento(movimiento);
			break;
			
		case 3:
			movimiento.bajaMovimiento(movimiento);
			break;
			
		case 4:
			System.out.println("Saliendo...");
			break;
			
		default:
			break;
		}
	}
	
	public static Movimiento menuSelectMovimiento(ArrayList <Movimiento> lista) {
		if(lista != null) {
			int cont = 1, limit = lista.size();
			for(Movimiento elemento : lista) {
				System.out.println(cont + " - " + elemento.getDetalle());
				cont++;
			}
			
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 || num > limit+1);
			
			return lista.get(num-1);
		}else {
			System.out.println("No se encontraron datos.");
		}
		return null;
	}
}
