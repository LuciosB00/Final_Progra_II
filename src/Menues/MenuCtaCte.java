package Menues;

import java.util.ArrayList;

import Final_Programacion_II.CuentaCorriente;
import Final_Programacion_II.MetodosGeneral;
import Final_Programacion_II.Movimiento;

public class MenuCtaCte {
	
	//MENU CTA CTE
	public static void menuDatosCtaCte(ArrayList <CuentaCorriente> lista) {
		System.out.println("Bienvenido al menú de datos de cuenta/s:");
		System.out.println("1 - Datos de una cuenta.");
		System.out.println("2 - Datos de todas las cuentas.");
		System.out.println("3 - Salir.");
		
		CuentaCorriente elemento = null;
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 && num > 3);
		
		switch(num) {
		case 1:
			elemento = menuSelectCtaCte(lista);
			elemento.datosCtaCte(elemento.getMovimientos());
			break;
						
		case 2:
			CuentaCorriente.listarCtaCtes();
			break;
			
		case 3:
			System.out.println("Saliendo...");
			break;
						
		default:
			break;
		}
	}
			
	public static void menuIngresoCtaCte(ArrayList <CuentaCorriente> lista) {
		System.out.println("Bienvenido al menú de ingreso de datos de cuenta/s:");
		System.out.println("1 - Ingresar una cuenta.");
		System.out.println("2 - Buscar una cuenta por su codigo.");
		System.out.println("3 - Modificar algunos de los datos de una cuenta.");
		System.out.println("4 - Salir.");
	
		CuentaCorriente elemento = null;
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 && num > 4);
					
		switch(num) {
		case 1:
			Movimiento.altaMovimiento();
			break;
						
		case 2:
			elemento = CuentaCorriente.buscarCtaCteCodigo();
			break;
						
		case 3:
			elemento = menuSelectCtaCte(lista);
			elemento.modificarCtaCte(elemento);
			break;
			
		case 4:
			System.out.println("Saliendo...");
			break;
						
		default:
			break;
		}
	}
	
	public static void menuCtaCte(CuentaCorriente ctacte) {
		System.out.println("Bienvenido al menú general de cuenta/s:");
		System.out.println("1 - Ver datos.");
		System.out.println("2 - Modificar algún dato.");
		System.out.println("3 - Salir.");
	
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 && num > 3);
					
		switch(num) {
		case 1:
			ctacte.datosCtaCte(ctacte.getMovimientos());
			break;
			
		case 2:
			ctacte.modificarCtaCte(ctacte);
			break;
			
		case 3:
			System.out.println("Saliendo...");
			break;
			
		default:
			break;
		}
	}
	
	public static CuentaCorriente menuSelectCtaCte(ArrayList <CuentaCorriente> lista) {
		if(lista != null) {
			int cont = 1, limit = lista.size();
			for(CuentaCorriente elemento : lista) {
				System.out.println(cont + " - " + elemento.getDetalle());
				cont++;
			}
			
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 && num > limit+1);
			
			return lista.get(num-1);
		}else {
			System.out.println("No se encontraron datos.");
		}
		return null;
	}
}
