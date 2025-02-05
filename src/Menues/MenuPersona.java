package Menues;

import java.util.ArrayList;

import Final_Programacion_II.MetodosGeneral;
import Final_Programacion_II.Persona;

public class MenuPersona {
	
	//MENUS PERSONA
	public static void menuDatosPersona(ArrayList <Persona> lista) {
		System.out.println("Bienvenido al menú de datos de persona/s:");
		System.out.println("1 - Datos de una persona.");
		System.out.println("2 - Datos de todas las personas.");
		System.out.println("3 - Salir.");
		
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 && num > 3);
		
		switch(num) {
		case 1:
			Persona elemento = menuSelectPersona(lista);
			elemento.datosPersona(elemento);
			break;
						
		case 2:
			Persona.listarPersonas();
			break;
			
		case 3:
			System.out.println("Saliendo...");
			break;
						
		default:
			break;
		}
	}
			
	public static void menuIngresoPersona(ArrayList <Persona> lista) {
		System.out.println("Bienvenido al menú de ingreso de datos de persona/s:");
		System.out.println("1 - Ingresar una persona.");
		System.out.println("2 - Dar de baja a una persona.");
		System.out.println("3 - Buscar una persona por su DNI.");
		System.out.println("4 - Modificar algunos de los datos de una persona.");
		System.out.println("5 - Salir.");
	
		Persona elemento = null;
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 && num > 5);
					
		switch(num) {
		case 1:
			Persona.altaPersona();
			break;
						
		case 2:
			elemento = menuSelectPersona(lista);
			elemento.bajaPersona(elemento);
			break;
						
		case 3:
			elemento = Persona.buscarPersonaDni();
			break;
						
		case 4:
			elemento = menuSelectPersona(lista);
			elemento.modificarPersona(elemento);
			break;
			
		case 5:
			System.out.println("Saliendo...");
			break;
						
		default:
			break;
		}
	}
	
	public static void menuPesona(Persona persona) {
		System.out.println("Bienvenido al menú general de persona/s:");
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
			persona.datosPersona(persona);
			break;
			
		case 2:
			persona.modificarPersona(persona);
			break;
			
		case 3:
			persona.bajaPersona(persona);
			break;
			
		case 4:
			System.out.println("Saliendo...");
			break;
			
		default:
			break;
		}
	}
	
	public static Persona menuSelectPersona(ArrayList <Persona> lista) {
		if(lista != null) {
			int cont = 1, limit = lista.size();
			for(Persona elemento : lista) {
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
