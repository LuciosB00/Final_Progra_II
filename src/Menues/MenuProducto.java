package Menues;

import java.util.ArrayList;
import java.util.Vector;
import Final_Programacion_II.MetodosGeneral;
import Final_Programacion_II.Producto;

public class MenuProducto {
	
	//MENUS PRODUCTOS
	public static void menuDatosProducto(ArrayList <Producto> lista) {
		System.out.println("Bienvenido al menú de datos de producto/s:");
		System.out.println("1 - Datos de un producto.");
		System.out.println("2 - Datos de todos los producto.");
		System.out.println("3 - Salir.");
		
		Producto elemento = null;
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 && num > 3);
		
		switch(num) {
		case 1:
			elemento = menuSelectProducto(lista);
			elemento.datosProducto(elemento);
			break;
						
		case 2:
			Producto.listarProductos();
			break;
			
		case 3:
			System.out.println("Saliendo...");
			break;
						
		default:
			break;
		}
	}
			
	public static void menuIngresoProducto(ArrayList <Producto> lista) {
		System.out.println("Bienvenido al menú de ingreso de datos de producto/s:");
		System.out.println("1 - Ingresar un producto.");
		System.out.println("2 - Dar de baja a un producto.");
		System.out.println("3 - Buscar un producto por su codigo.");
		System.out.println("4 - Modificar algunos de los datos de un producto.");
		System.out.println("5 - Salir.");
	
		Producto elemento = null;
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 && num > 5);
					
		switch(num) {
		case 1:
			Producto.altaProducto();
			break;
						
		case 2:
			elemento = menuSelectProducto(lista);
			elemento.bajaProducto(elemento);
			break;
						
		case 3:
			elemento = Producto.buscarProductoCodigo();
			break;
						
		case 4:
			elemento = menuSelectProducto(lista);
			elemento.modificarProducto(elemento);
			break;
			
		case 5:
			System.out.println("Saliendo...");
			break;
						
		default:
			break;
		}
	}
	
	public static void menuEmpleado(Producto producto) {
		System.out.println("Bienvenido al menú general de producto/s:");
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
			producto.datosProducto(producto);
			break;
			
		case 2:
			producto.modificarProducto(producto);
			break;
			
		case 3:
			producto.bajaProducto(producto);
			break;
			
		case 4:
			System.out.println("Saliendo...");
			break;
			
		default:
			break;
		}
	}
	
	public static Producto menuSelectProducto(ArrayList <Producto> lista) {
		if(lista != null) {
			int cont = 1, limit = lista.size();
			for(Producto elemento : lista) {
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
	
	public static Vector <Producto> menuVectorProductos(ArrayList <Producto> lista){
		if(lista != null) {
			Vector <Producto> vector = new Vector <Producto> (10);
			Producto producto = null;
			
			int cant=0; String cantAux=null;
			do {
				cant = MetodosGeneral.castearEntero("Ingrese la cantidad de productos que desea ingresar(máx. 10): ", cantAux);
			}while(cant < 0 && cant > 10);
			
			for(int i=0; i<cant; i++) {
				producto = MenuProducto.menuSelectProducto(lista);
				vector.add(producto);
			}
			
			return vector;
		}else {
			System.out.println("No se han encontrado los datos.");
		}
		return null;
	}
}
