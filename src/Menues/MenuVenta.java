package Menues;

import java.util.ArrayList;

import Final_Programacion_II.Cliente;
import Final_Programacion_II.MetodosGeneral;
import Final_Programacion_II.Producto;
import Final_Programacion_II.Venta;

public class MenuVenta {
	
	//MENUS VENTA
	public static void menuDatosVenta(ArrayList <Venta> lista) {
		System.out.println("Bienvenido al menú de datos de venta/s:");
		System.out.println("1 - Datos de un venta.");
		System.out.println("2 - Datos de todos los ventas.");
		System.out.println("3 - Salir.");
		
		Venta elemento = null;
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 && num > 3);
		
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
	}
			
	public static void menuIngresoVenta(ArrayList <Venta> lista) {
		System.out.println("Bienvenido al menú de ingreso de datos de venta/s:");
		System.out.println("1 - Ingresar un venta.");
		System.out.println("2 - Dar de baja a un venta.");
		System.out.println("3 - Buscar un venta por su codigo.");
		System.out.println("4 - Modificar algunos de los datos de un venta.");
		System.out.println("5 - Salir.");
	
		Venta elemento = null;
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 && num > 5);
					
		switch(num) {
		case 1:
			Venta.altaVenta(MenuCliente.menuSelectCliente(Cliente.listaClientes),
							MenuProducto.menuVectorProductos(Producto.listaProductos));
			break;
						
		case 2:
			elemento = menuSelectVenta(lista);
			elemento.bajaVenta(elemento);
			break;
						
		case 3:
			elemento = Venta.buscarVentaCodigo();
			break;
						
		case 4:
			elemento = menuSelectVenta(lista);
			elemento.modificarVenta(elemento);
			break;
			
		case 5:
			System.out.println("Saliendo...");
			break;
						
		default:
			break;
		}
	}
	
	public static void menuVenta(Venta venta) {
		System.out.println("Bienvenido al menú general de venta/s:");
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
			}while(num < 1 && num > limit+1);
			
			return lista.get(num-1);
		}else {
			System.out.println("No se encontraron datos.");
		}
		return null;
	}
}
