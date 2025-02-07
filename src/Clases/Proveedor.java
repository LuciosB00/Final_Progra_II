package Clases;

import Final_Programacion_II.MetodosGeneral;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Proveedor extends Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	public static ArrayList <Proveedor> listaProveedores = new ArrayList <Proveedor> ();
	
	// Atributos
	private CuentaCorriente ctacte;
	
	// Constructor
	public Proveedor (String nombre, String apellido, int dni, boolean activo, CuentaCorriente ctacte) {
		super(nombre, apellido, dni, activo);
		this.ctacte = ctacte;
	}
	
	public Proveedor (String nombre, String apellido, int dni, boolean activo, Sexo sexo, CuentaCorriente ctacte) {
		super(nombre, apellido, dni, activo, sexo);
		this.ctacte = ctacte;
	}
	
	public Proveedor (String nombre, String apellido, int dni, boolean activo, Sexo sexo, String telefono, String direccion, LocalDate fechaNacimiento, CuentaCorriente ctacte) {
		super(nombre, apellido, dni, activo, sexo, telefono, direccion, fechaNacimiento);
		this.ctacte = ctacte;
	}
	
	public Proveedor (String nombre, String apellido, int dni, boolean activo, Sexo sexo, String telefono, String direccion, LocalDate fechaNacimiento, Provincia provincia, String localidad, CuentaCorriente ctacte) {
		super(nombre, apellido, dni, activo, sexo, telefono, direccion, fechaNacimiento, provincia, localidad);
		this.ctacte = ctacte;
	}
	
	//Setters y Getters
	public CuentaCorriente getCtacte() {
		return ctacte;
	}
	public void setCtacte(CuentaCorriente ctacte) {
		this.ctacte = ctacte;
	}

	// Metodos
	public static void altaProveedor (CuentaCorriente ctacte) {
		Scanner teclado = new Scanner(System.in);
		
		String nombre, apellido, DNI = null, telefono, direccion, localidad; int dni;
		
		System.out.println("Ingrese el nombre: ");
		nombre = teclado.nextLine();
		
		System.out.println("Ingrese el apellido: ");
		apellido = teclado.nextLine();
		
		dni = MetodosGeneral.castearEntero ("Ingrese su DNI:", DNI);
		
		Sexo genero = Sexo.escogerGenero();
		
		System.out.println("Ingrese el telefono: ");
		telefono = teclado.nextLine();
		
		System.out.println("Ingrese el direccion: ");
		direccion = teclado.nextLine();
		
		LocalDate fechaNac = MetodosGeneral.crearFecha("Ingrese fecha de nacimiento:");
		
		Provincia prov = Provincia.escogerProvincia();
		
		System.out.println("Ingrese la localidad: ");
		localidad = teclado.nextLine();
		
		boolean activo = true;
		
		teclado.close();
		
		Proveedor nuevoProveedor = new Proveedor (nombre, apellido, dni, activo, genero, telefono, direccion, fechaNac, prov, localidad, ctacte);
		listaProveedores.add(nuevoProveedor);
		Persona.listaPersonas.add(nuevoProveedor);
	}
	
	public void datosProveedor(Proveedor proveedor) {
		if(proveedor != null) {
			super.datosPersona(proveedor);
			proveedor.verCtaCte(proveedor.getCtacte());
		}else {
			System.out.println("Los datos no se han encontrado.");
		}
	}
	
	public void modificarProveedor(Proveedor proveedor) {
		if(proveedor != null) {
			super.modificarPersona(proveedor);
			
			System.out.println("1 - Modificar cuenta corriente.");
			System.out.println("2 - Salir.");
			
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 && num > 2);
			
			switch(num) {
			case 1:
				
				break;
				
			case 2:
				System.out.println("Saliendo...");
				break;
				
			default:
				break;
			}
		}else {
			System.out.println("No se han encontrado los datos.");
		}
	}
	
	public static void listarProveedor() {
		if(Proveedor.listaProveedores != null) {
			for(Proveedor elemento : listaProveedores) {
				elemento.datosProveedor(elemento);
			}
		}else {
			System.out.println("Los datos no se han encontrado.");
		}
	}
	
	public static Proveedor buscarProveedor() {
		int num; String numAux=null;
		num = MetodosGeneral.castearEntero("Ingrese el DNI del proveedor a buscar: ", numAux);
		for(Proveedor elemento : listaProveedores) {
			if(num == elemento.getDni()) {
				System.out.println("El proveedor SI fue encontrada.");
				return elemento;
			}
		}
		System.out.println("El proveedor NO fue encontrado.");
		return null;
	}
	
	public void verCtaCte (CuentaCorriente ctacte) {
		if(ctacte != null) {
			ctacte.datosCtaCte(ctacte.getMovimientos());
		}else {
			System.out.println("No se encontraron los datos.");
		}
	}
}
