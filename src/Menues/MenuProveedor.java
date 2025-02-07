package Menues;

import java.util.ArrayList;

import Clases.CuentaCorriente;
import Clases.Proveedor;
import Final_Programacion_II.MetodosGeneral;

public class MenuProveedor {
	
	//MENUS PROVEEDOR
	public static void menuDatosProveedor(ArrayList <Proveedor> lista) {
		System.out.println("Bienvenido al menú de datos de cleinte/s:");
		System.out.println("1 - Datos de un cleinte.");
		System.out.println("2 - Datos de todos los cleintes.");
		System.out.println("3 - Salir.");
		
		Proveedor elemento = null;
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 && num > 3);
		
		switch(num) {
		case 1:
			elemento = menuSelectProveedor(lista);
			elemento.datosProveedor(elemento);
			break;
						
		case 2:
			Proveedor.listarProveedor();
			break;
			
		case 3:
			System.out.println("Saliendo...");
			break;
						
		default:
			break;
		}
	}
			
	public static void menuIngresoProveedor(ArrayList <Proveedor> lista) {
		System.out.println("Bienvenido al menú de ingreso de datos de cliente/s:");
		System.out.println("1 - Ingresar un cliente.");
		System.out.println("2 - Dar de baja a un cliente.");
		System.out.println("3 - Buscar un cliente por su DNI.");
		System.out.println("4 - Modificar algunos de los datos de un cliente.");
		System.out.println("5 - Salir.");
	
		Proveedor elemento = null;
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 && num > 5);
					
		switch(num) {
		case 1:
			Proveedor.altaProveedor(MenuCtaCte.menuSelectCtaCte(CuentaCorriente.listaCtaCtes));
			break;
						
		case 2:
			elemento = menuSelectProveedor(lista);
			elemento.bajaPersona(elemento);
			break;
						
		case 3:
			elemento = Proveedor.buscarProveedor();
			break;
						
		case 4:
			elemento = menuSelectProveedor(lista);
			elemento.modificarProveedor(elemento);
			break;
			
		case 5:
			System.out.println("Saliendo...");
			break;
						
		default:
			break;
		}
	}
	
	public static void menuProveedor(Proveedor proveedor) {
		System.out.println("Bienvenido al menú general de cliente/s:");
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
			proveedor.datosProveedor(proveedor);
			break;
			
		case 2:
			proveedor.modificarProveedor(proveedor);
			break;
			
		case 3:
			proveedor.bajaPersona(proveedor);
			break;
			
		case 4:
			System.out.println("Saliendo...");
			break;
			
		default:
			break;
		}
	}
	
	public static Proveedor menuSelectProveedor(ArrayList <Proveedor> lista) {
		if(lista != null) {
			int cont = 1, limit = lista.size();
			for(Proveedor elemento : lista) {
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
