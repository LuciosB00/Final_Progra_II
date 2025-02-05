package Menues;

import java.util.ArrayList;

import Final_Programacion_II.Empleado;
import Final_Programacion_II.MetodosGeneral;

public class MenuEmpleado {
	
	//MENUS EMPLEADO
	public static void menuDatosEmpleado(ArrayList <Empleado> lista) {
		System.out.println("Bienvenido al menú de datos de empleado/s:");
		System.out.println("1 - Datos de un empleado.");
		System.out.println("2 - Datos de todos los empleados.");
		System.out.println("3 - Salir.");
		
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 && num > 3);
		
		switch(num) {
		case 1:
			Empleado elemento = menuSelectEmpleado(lista);
			elemento.datosEmpleado(elemento);
			break;
						
		case 2:
			Empleado.listarEmpleados();
			break;
			
		case 3:
			System.out.println("Saliendo...");
			break;
						
		default:
			break;
		}
	}
			
	public static void menuIngresoEmpleado(ArrayList <Empleado> lista) {
		System.out.println("Bienvenido al menú de ingreso de datos de Empleado/s:");
		System.out.println("1 - Ingresar un empleado.");
		System.out.println("2 - Dar de baja a un empleado.");
		System.out.println("3 - Buscar un empleado por su legajo.");
		System.out.println("4 - Modificar algunos de los datos de un empelado.");
		System.out.println("5 - Salir.");
	
		Empleado elemento = null;
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 && num > 5);
					
		switch(num) {
		case 1:
			Empleado.altaEmpleado();
			break;
						
		case 2:
			elemento = menuSelectEmpleado(lista);
			elemento.bajaPersona(elemento);
			break;
						
		case 3:
			elemento = Empleado.buscarEmpleadoLegajo();
			break;
						
		case 4:
			elemento = menuSelectEmpleado(lista);
			elemento.modificarEmpleado(elemento);
			break;
			
		case 5:
			System.out.println("Saliendo...");
			break;
						
		default:
			break;
		}
	}
	
	public static void menuEmpleado(Empleado empleado) {
		System.out.println("Bienvenido al menú general de empleado/s:");
		System.out.println("1 - Ver datos.");
		System.out.println("2 - Modificar algún dato.");
		System.out.println("3 - Dar de baja");
		System.out.println("4 - Salir.");
	
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 && num > 4);
					
		switch(num) {
		case 1:
			empleado.datosEmpleado(empleado);
			break;
			
		case 2:
			empleado.modificarEmpleado(empleado);
			break;
			
		case 3:
			empleado.bajaPersona(empleado);
			break;
			
		case 4:
			System.out.println("Saliendo...");
			break;
			
		default:
			break;
		}
	}
	
	public static Empleado menuSelectEmpleado(ArrayList <Empleado> lista) {
		if(lista != null) {
			int cont = 1, limit = lista.size();
			for(Empleado elemento : lista) {
				System.out.println(cont + " - " + elemento.getNombre());
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
