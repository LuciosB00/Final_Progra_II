package Clases;

import Final_Programacion_II.MetodosGeneral;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Empleado extends Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	public static ArrayList <Empleado> listaEmpleados = null;

	// Atributos
	private LocalDate fechaIngreso;
	private LocalDate fechaEgreso;
	private int legajo;
	private double salario;
	
	// Constructor
	public Empleado (String nombre, String apellido, int dni, boolean activo, LocalDate fechaIngreso, LocalDate fechaEgreso, int legajo, double salario) {
		super(nombre, apellido, dni, activo);
		this.fechaIngreso = fechaIngreso;
		this.fechaEgreso = fechaEgreso;
		this.legajo = legajo;
		this.salario = salario;
	}
	
	public Empleado (String nombre, String apellido, int dni, boolean activo, Sexo sexo, LocalDate fechaIngreso, LocalDate fechaEgreso, int legajo, double salario) {
		super(nombre, apellido, dni, activo, sexo);
		this.fechaIngreso = fechaIngreso;
		this.fechaEgreso = fechaEgreso;
		this.legajo = legajo;
		this.salario = salario;
	}
	
	public Empleado (String nombre, String apellido, int dni, boolean activo, Sexo sexo, String telefono, String direccion, LocalDate fechaNacimiento, LocalDate fechaIngreso, LocalDate fechaEgreso, int legajo, double salario) {
		super(nombre, apellido, dni, activo, sexo, telefono, direccion, fechaNacimiento);
		this.fechaIngreso = fechaIngreso;
		this.fechaEgreso = fechaEgreso;
		this.legajo = legajo;
		this.salario = salario;
	}
	
	public Empleado (String nombre, String apellido, int dni, boolean activo, Sexo sexo, String telefono, String direccion, LocalDate fechaNacimiento, Provincia provincia, String localidad, LocalDate fechaIngreso, LocalDate fechaEgreso, int legajo, double salario) {
		super(nombre, apellido, dni, activo, sexo, telefono, direccion, fechaNacimiento, provincia, localidad);
		this.fechaIngreso = fechaIngreso;
		this.fechaEgreso = fechaEgreso;
		this.legajo = legajo;
		this.salario = salario;
	}
	
	// Setters y Getters
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public LocalDate getFechaEgreso() {
		return fechaEgreso;
	}
	public void setFechaEgreso(LocalDate fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}

	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	// Metodos
	public static void altaEmpleado () {
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
		
		LocalDate fechaIngreso = LocalDate.now();
		
		LocalDate fechaEgreso = MetodosGeneral.crearFecha("Ingrese la fecha de egreso:");
		
		int legajo; double salario;
		String legajoAux=null, salarioAux=null;
		
		legajo = MetodosGeneral.castearEntero("Ingrese el legajo del empleado:", legajoAux);
		salario = MetodosGeneral.castearDecimal("Ingrese el salario del empleado:", salarioAux);
		
		Empleado nuevoEmpleado = new Empleado (nombre, apellido, dni, activo, genero, telefono, direccion, fechaNac, prov, localidad, fechaIngreso, fechaEgreso, legajo, salario);
		
		if(Empleado.listaEmpleados == null && Persona.listaPersonas == null) {
			listaEmpleados = new ArrayList <Empleado> ();
			listaPersonas = new ArrayList <Persona> ();
		}
		if(Empleado.listaEmpleados == null) {
			listaEmpleados = new ArrayList <Empleado> ();
		}
		if(Persona.listaPersonas == null) {
			listaPersonas = new ArrayList <Persona> ();
		}
		
		listaEmpleados.add(nuevoEmpleado);
		Persona.listaPersonas.add(nuevoEmpleado);
	}

	public void bajarEmpleado (Empleado empleado) {
		if (empleado != null) {
			empleado.setActivo(false);
		}
	}
	
	public void modificarEmpleado (Empleado empleado) {
		if (empleado != null) {
			
			super.modificarPersona(empleado);
			
			System.out.println("1 - Modificar fecha ingreso.");
			System.out.println("2 - Modificar fecha egreso.");
			System.out.println("3 - Modificar legajo.");
			System.out.println("4 - Modificar salario.");
			System.out.println("5 - Salir.");
			
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 || num > 5);
			
			switch(num) {
			case 1:
				LocalDate fechaIngreso = LocalDate.now();
				empleado.setFechaIngreso(fechaIngreso);
				break;
						
			case 2:
				LocalDate fechaEgreso = MetodosGeneral.crearFecha("Ingrese la fecha de egreso:");
				empleado.setFechaEgreso(fechaEgreso);
				break;
							
			case 3:
				String legajoAux = null;
				int legajo = MetodosGeneral.castearEntero("Ingrese el legajo del empleado:", legajoAux);
				empleado.setLegajo(legajo);
						break;
						
			case 4:
				String salarioAux = null;
				double salario = MetodosGeneral.castearDecimal("Ingrese el salario del empleado:", salarioAux);
				empleado.setSalario(salario);
				break;
						
			case 5:
				System.out.println("Salinedo...");
				break;
						
			default:
				break;
			}
		} else {
			System.out.println("No se encontraron los datos.");
		}
	}
	
	public static Empleado buscarEmpleadoLegajo () {
		int num; String numAux=null;
		num = MetodosGeneral.castearEntero("Ingrese el legajo del empleado a buscar: ", numAux);
		for(Empleado elemento : listaEmpleados) {
			if(num == elemento.getDni()) {
				System.out.println("El empleado SI fue encontrada.");
				return elemento;
			}
		}
		System.out.println("El empelado NO fue encontrado.");
		return null;
	}
	
	public void datosEmpleado (Empleado empleado) {
		if(empleado != null) {
			super.datosPersona(empleado);
			
			System.out.println("Datos laborales:");
			System.out.println("N° de legajo: " + empleado.getLegajo());
			System.out.println("Salario: " + empleado.getSalario());
			System.out.println("Fecha de ingreso: " + empleado.getFechaIngreso());
			System.out.println("Fecha de egreso: " + empleado.getFechaEgreso());
			System.out.println("------------------------------");
		} else {
			System.out.println("No se encontraron los datos.");
		}
	}
	
	public static void listarEmpleados (){
		if(Empleado.listaEmpleados != null) {
			for (Empleado elemento : listaEmpleados) {
				elemento.datosEmpleado(elemento);
			}
		} else {
			System.out.println("No se encontraron los datos.");
		}
	}
}
