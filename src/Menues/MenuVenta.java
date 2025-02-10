package Menues;

import java.util.ArrayList;

import Clases.Cliente;
import Clases.Producto;
import Clases.Venta;
import Final_Programacion_II.MetodosGeneral;

public class MenuVenta {
	
	//MENUS VENTA
	public static void menuDatosVenta(ArrayList <Venta> lista) {
		if(lista != null) {
			System.out.println("Bienvenido al menú de datos de venta/s:");
			System.out.println("1 - Datos de un venta.");
			System.out.println("2 - Datos de todos los ventas.");
			System.out.println("3 - Salir.");
			
			Venta elemento = null;
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 || num > 3);
			
			switch(num) {
			case 1:
				elemento = menuSelectVenta(lista);
				elemento.datosVenta(elemento);
				break;
							
			case 2:
				Venta.listarVentas();
				break;
				
			case 3:
				System.out.println("Saliendo...");
				break;
							
			default:
				break;
			}
		}else {
			System.out.println("No se han encontrado los datos.");
		}
		Menus.menusDatos();
	}
			
	public static void menuIngresoVenta(ArrayList <Venta> lista) {
		System.out.println("Bienvenido al menú de ingreso de datos de venta/s:");
		System.out.println("1 - Ingresar una venta.");
		System.out.println("2 - Dar de baja a un venta.");
		System.out.println("3 - Buscar un venta por su codigo.");
		System.out.println("4 - Modificar algunos de los datos de un venta.");
		System.out.println("5 - Salir.");
	
		Venta elemento = null;
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 || num > 5);
					
		switch(num) {
		case 1:
			Venta.altaVenta(MenuCliente.menuSelectCliente(Cliente.listaClientes),
							MenuProducto.menuVectorProductos(Producto.listaProductos));
			break;
			
		case 2:
			if(lista != null) {
				elemento = menuSelectVenta(lista);
				elemento.bajaVenta(elemento);
			}else {
				System.out.println("No se han encontrado los datos.");
			}
			break;
						
		case 3:
			if(lista != null) {
				elemento = Venta.buscarVentaCodigo();
				MenuVenta.menuVenta(elemento, lista);
			}else {
				System.out.println("No se han encontrado los datos.");
			}
			break;
						
		case 4:
			if(lista != null) {
				elemento = menuSelectVenta(lista);
				elemento.modificarVenta(elemento);
			}else {
				System.out.println("No se han encontrado los datos.");
			}
			break;
			
		case 5:
			System.out.println("Saliendo...");
			break;
						
		default:
			break;
		}
		Menus.menusIngresar();
	}
	
	public static void menuVenta(Venta venta, ArrayList <Venta> lista) {
		if(venta != null && lista != null) {
			System.out.println("Bienvenido al menú general de venta/s:");
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
				venta.datosVenta(venta);
				break;
				
			case 2:
				venta.modificarVenta(venta);
				break;
				
			case 3:
				venta.bajaVenta(venta);
				break;
				
			case 4:
				System.out.println("Saliendo...");
				break;
				
			default:
				break;
			}
		}else {
			System.out.println("No se han encontrado los datos.");
		}
		MenuVenta.menuIngresoVenta(lista);
	}
	
	public static Venta menuSelectVenta(ArrayList <Venta> lista) {
		if(lista != null) {
			int cont = 1, limit = lista.size();
			for(Venta elemento : lista) {
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
