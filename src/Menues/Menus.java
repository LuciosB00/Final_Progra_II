package Menues;

import Clases.Cliente;
import Clases.CuentaCorriente;
import Clases.Empleado;
import Clases.Movimiento;
import Clases.Persona;
import Clases.Producto;
import Clases.Proveedor;
import Clases.Usuario;
import Clases.Venta;
import Final_Programacion_II.MetodosGeneral;
import Archivos.Archivo;

public class Menus {
	private static boolean eject = false;

	//MENU PRINCIPAL
	public static void menuPrincipal() {
		if(!eject) {
			Archivo.cargarDatos();
			eject = true;
		}
		
		System.out.println("Bienvenido al menú principal:");
		System.out.println("1 - Menú ver datos.");
		System.out.println("2 - Menú ingresar datos.");
		System.out.println("3 - Menú de archivos.");
		System.out.println("4 - Salir.");
			
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 || num > 4);
			
		switch(num) {
		case 1:
			Menus.menusDatos();
			break;
				
		case 2:
			Menus.menusIngresar();
			break;
				
		case 3:
			Menus.menusArchivos();
			break;
				
		case 4:
			Archivo.guardarDatos();
			
			System.out.println("Saliendo...");
			System.exit(0);
			break;
				
		default:
			break;
		}
	}
		
	//MENUS SECUNDARIOS
	public static void menusDatos() {
		System.out.println("Bienvenido al menú secundario para ver datos:");
		System.out.println("1 - Menú de personas.");
		System.out.println("2 - Menú de empleados.");
		System.out.println("3 - Menú de usuarios.");
		System.out.println("4 - Menú de productos.");
		System.out.println("5 - Menú de ventas.");
		System.out.println("6 - Menú de movimientos.");
		System.out.println("7 - Menú de cuentas corrientes.");
		System.out.println("8 - Menú de clientes.");
		System.out.println("9 - Menú de proveedores.");
		System.out.println("10 - Salir.");
			
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 || num > 10);
			
		switch(num) {
		case 1:
			MenuPersona.menuDatosPersona(Persona.listaPersonas);
			break;
				
		case 2:
			MenuEmpleado.menuDatosEmpleado(Empleado.listaEmpleados);
			break;
				
		case 3:
			MenuUsuario.menuDatosUsuario(Usuario.listaUsuarios);
			break;
				
		case 4:
			MenuProducto.menuDatosProducto(Producto.listaProductos);
			break;
				
		case 5:
			MenuVenta.menuDatosVenta(Venta.listaVentas);
			break;
				
		case 6:
			MenuMovimiento.menuDatosMovimiento(Movimiento.listaMovimientos);
			break;
				
		case 7:
			MenuCtaCte.menuDatosCtaCte(CuentaCorriente.listaCtaCtes);
			break;
				
		case 8:
			MenuCliente.menuDatosCliente(Cliente.listaClientes);
			break;
				
		case 9:
			MenuProveedor.menuDatosProveedor(Proveedor.listaProveedores);
			break;
				
		case 10:
			System.out.println("Saliendo...");
			break;
				
		default:
			break;
		}
		Menus.menuPrincipal();
	}
		
	public static void menusIngresar() {
		System.out.println("Bienvenido al menú secundario para ingresar datos:");
		System.out.println("1 - Menú de personas.");
		System.out.println("2 - Menú de empleados.");
		System.out.println("3 - Menú de usuarios.");
		System.out.println("4 - Menú de productos,.");
		System.out.println("5 - Menú de ventas.");
		System.out.println("6 - Menú de movimientos.");
		System.out.println("7 - Menú de cuentas corrientes.");
		System.out.println("8 - Menú de clientes.");
		System.out.println("9 - Menú de proveedores.");
		System.out.println("10 - Salir.");
			
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 || num > 10);
			
		switch(num) {
		case 1:
			MenuPersona.menuIngresoPersona(Persona.listaPersonas);
			break;
				
		case 2:
			MenuEmpleado.menuIngresoEmpleado(Empleado.listaEmpleados);
			break;
				
		case 3:
			MenuUsuario.menuIngresoUsuario(Usuario.listaUsuarios);
			break;
				
		case 4:
			MenuProducto.menuIngresoProducto(Producto.listaProductos);
			break;
				
		case 5:
			MenuVenta.menuIngresoVenta(Venta.listaVentas);
			break;
				
		case 6:
			MenuMovimiento.menuIngresoMovimiento(Movimiento.listaMovimientos);
			break;
				
		case 7:
			MenuCtaCte.menuIngresoCtaCte(CuentaCorriente.listaCtaCtes);
			break;
				
		case 8:
			MenuCliente.menuIngresoCliente(Cliente.listaClientes);
			break;
				
		case 9:
			MenuProveedor.menuIngresoProveedor(Proveedor.listaProveedores);
			break;
				
		case 10:
			System.out.println("Saliendo...");
			break;
				
		default:
			break;
		}
		Menus.menuPrincipal();
	}
		
	public static void menusArchivos() {
		System.out.println("Bienvenido al menú secundario para gestionar archivos:");
		System.out.println("1 - Menú general de archivos.");
		System.out.println("2 - Menú archivos de personas.");
		System.out.println("3 - Menú archivos de empleados.");
		System.out.println("4 - Menú archivos de usuarios.");
		System.out.println("5 - Menú archivos de productos,.");
		System.out.println("6 - Menú archivos de ventas.");
		System.out.println("7 - Menú archivos de movimientos.");
		System.out.println("8 - Menú archivos de cuentas corrientes.");
		System.out.println("9 - Menú archivos de clientes.");
		System.out.println("10 - Menú archivos de proveedores.");
		System.out.println("11 - Salir.");
			
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 || num > 11);
			
		switch(num) {
		case 1:
			MenuArchivo.menuArchivo();
			break;
				
		case 2:
			MenuArchivo.menuArchivoPersona();
			break;
				
		case 3:
			MenuArchivo.menuArchivoEmpleado();
			break;
				
		case 4:
			MenuArchivo.menuArchivoUsuario();
			break;
				
		case 5:
			MenuArchivo.menuArchivoProducto();
			break;
				
		case 6:
			MenuArchivo.menuArchivoVenta();
			break;
				
		case 7:
			MenuArchivo.menuArchivoMovimiento();
			break;
				
		case 8:
			MenuArchivo.menuArchivoCtaCte();
			break;
				
		case 9:
			MenuArchivo.menuArchivoCliente();
			break;
				
		case 10:
			MenuArchivo.menuArchivoProveedor();
			break;
			
		case 11:
			System.out.println("Saliendo...");
			break;
				
		default:
			break;
		}
		Menus.menuPrincipal();
	}
}
