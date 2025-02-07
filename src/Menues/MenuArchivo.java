package Menues;

import java.io.File;
import java.util.Scanner;

import Archivos.Archivo;
import Final_Programacion_II.MetodosGeneral;

public class MenuArchivo {

	// MENU ARCHIVO GENERAL
	public static void menuArchivo() {
		System.out.println("Bienvenido al menú general de archivo/s:");
		System.out.println("1 - Crear la carpeta general.");
		System.out.println("2 - Eliminar la carpeta general.");
		System.out.println("3 - Crear una carpeta.");
		System.out.println("4 - Eliminar una carpeta.");
		System.out.println("5 - Crear un archivo.");
		System.out.println("6 - Eliminar un archivo.");
		System.out.println("7 - Eliminar todos los archivos.");
		System.out.println("8 - Salir.");
		
		Scanner teclado = new Scanner(System.in);
		String numAux=null, ruta=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 || num > 8);
		
		switch(num) {
		case 1:
			Archivo.crearCarpeta("Carpeta General");
			break;
			
		case 2:
			Archivo.eliminarArchivo("Carpeta General");
			break;
			
		case 3:
			System.out.println("Ingrese el nombre de la carpeta a crear: ");
			ruta = teclado.nextLine();
			Archivo.crearCarpeta("Carpeta General" + File.separator + ruta);
			break;
			
		case 4:
			System.out.println("Ingrese el nombre de la carpeta a eliminar: ");
			ruta = teclado.nextLine();
			Archivo.eliminarCarpeta("Carpeta General" + File.separator + ruta);
			break;
			
		case 5:
			System.out.println("Ingrese el nombre del archivo a crear(sin la terminación ¨.dat¨): ");
			ruta = teclado.nextLine() + ".dat";
			Archivo.crearArchivo("Carpeta General" + File.separator + ruta);
			break;
			
		case 6:
			System.out.println("Ingrese el nombre del archivo a eliminar(sin la terminación ¨.dat¨): ");
			ruta = teclado.nextLine() + ".dat";
			Archivo.eliminarArchivo("Carpeta General" + File.separator + ruta);
			break;
			
		case 7:
			Archivo.eliminarArchivos("Carpeta General");
			break;
			
		case 8:
			System.out.println("Saliendo...");
			break;
			
		default:
			break;
		}
		teclado.close();
	}
	
	// MENU ARCHIVO PERSONA
	public static void menuArchivoPersona() {
		
	}
	// MENU ARCHIVO EMPLEADO
	public static void menuArchivoEmpleado() {
		
	}
	// MENU ARCHIVO PRODUCTO
	public static void menuArchivoProducto() {
		
	}
	// MENU ARCHIVO MOVIMIENTO
	public static void menuArchivoMovimiento() {
		
	}
	// MENU ARCHIVO VENTA
	public static void menuArchivoVenta() {
		
	}
	// MENU ARCHIVO CLIENTE
	public static void menuArchivoCliente() {
		
	}
	// MENU ARCHIVO CTACTE
	public static void menuArchivoCtaCte() {
		
	}
	// MENU ARCHIVO PROVEEDOR
	public static void menuArchivoProveedor() {
		
	}
	// MENU ARCHIVO USUARIO
	public static void menuArchivoUsuario() {
		
	}
}
