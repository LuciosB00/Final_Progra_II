package Final_Programacion_II;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Empleado extends Persona{
	public static ArrayList <Empleado> listaEmpleados = new ArrayList <Empleado> ();

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
	public static void agregarEmpleado () {
		Scanner teclado = new Scanner(System.in);
		
		String nombre, apellido, DNI = null, telefono, direccion, localidad; int dni;
		
		System.out.println("Ingrese el nombre: ");
		nombre = teclado.nextLine();
		System.out.println("Ingrese el apellido: ");
		apellido = teclado.nextLine();
		System.out.println("Ingrese el dni: ");
		dni = MetodosGeneral.castearEntero ("Ingrese su DNI:", DNI);
		Sexo genero = MetodosGeneral.escogerGenero();
		
		System.out.println("Ingrese el telefono: ");
		telefono = teclado.nextLine();
		System.out.println("Ingrese el direccion: ");
		direccion = teclado.nextLine();
		LocalDate fechaNac = MetodosGeneral.crearFecha("Ingrese fecha de nacimiento:");
		
		Provincia prov = MetodosGeneral.escogerProvincia();
		System.out.println("Ingrese el localidad: ");
		localidad = teclado.nextLine();
		
		boolean activo = MetodosGeneral.escogerBooleano("¿Está activo?:");
		
		LocalDate fechaIngreso = MetodosGeneral.crearFecha("Ingrese la fecha de ingreso:"); 
		LocalDate fechaEgreso = MetodosGeneral.crearFecha("Ingrese la fecha de egreso:");
		
		int legajo; double salario;
		String legajoAux=null, salarioAux=null;
		
		legajo = MetodosGeneral.castearEntero("Ingrese el legajo del empleado:", legajoAux);
		salario = MetodosGeneral.castearDecimal("Ingrese el salario del empleado:", salarioAux);
		
		Empleado nuevoEmpleado = new Empleado (nombre, apellido, dni, activo, genero, telefono, direccion, fechaNac, prov, localidad, fechaIngreso, fechaEgreso, legajo, salario);
		listaEmpleados.add(nuevoEmpleado);
		Persona.listaPersonas.add(nuevoEmpleado);
	}
	
	public Empleado altaEmpleado () {
		return null;
	}

	public void bajarEmpleado () {
		
	}
	
	public void modificarEmpleado () {
		// MODIFICAR ALGÚN DATO DE ALGÚN EMPLEADO
	}
	
	public Empleado buscarEmpleado (int numero) {
		System.out.println("Buscar empleado por legajo:");
		for(Empleado elemento: listaEmpleados) {
			if(numero == elemento.getLegajo()) {
				System.out.println("El empleado ha sido encontrado: " + elemento.getNombre());
				return elemento;
			}
		}
		System.out.println("El legajo del empleado no ha sido contrado.");
		return null;
	}
	
	public ArrayList <Empleado> listarEmpleado (){
		return null;
	}
}
