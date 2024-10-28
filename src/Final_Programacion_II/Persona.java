package Final_Programacion_II;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Persona {
	public static ArrayList <Persona> listaPersonas = new ArrayList <Persona> ();

	// Atributos
	private int dni;
	private boolean activo;
	private String nombre;
	private String apellido;
	private String telefono;
	private String direccion;
	private Provincia provincia;
	private String localidad;
	private LocalDate fachaNacimiento;
	private Sexo sexo;
	
	// Constructor
	public Persona (String nombre, String apellido, int dni, boolean activo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.activo = activo;
	}
	
	public Persona (String nombre, String apellido, int dni, boolean activo, Sexo sexo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.activo = activo;
		this.sexo = sexo;
	}
	
	public Persona (String nombre, String apellido, int dni, boolean activo, Sexo sexo, String telefono, String direccion, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.activo = activo;
		this.sexo = sexo;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fachaNacimiento = fechaNacimiento;
	}
	
	public Persona (String nombre, String apellido, int dni, boolean activo, Sexo sexo, String telefono, String direccion, LocalDate fechaNacimiento, Provincia provincia, String localidad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.activo = activo;
		this.sexo = sexo;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fachaNacimiento = fechaNacimiento;
		this.provincia = provincia;
		this.localidad = localidad;
	}
	
	// Setters y Getters
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}

	public boolean getActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public LocalDate getFachaNacimiento() {
		return fachaNacimiento;
	}
	public void setFachaNacimiento(LocalDate fachaNacimiento) {
		this.fachaNacimiento = fachaNacimiento;
	}

	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	// Metodos
	public static void agregarPersona () {
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
		
		Persona nuevaPersona = new Persona(nombre, apellido, dni, activo, genero, telefono, direccion, fechaNac, prov, localidad);
		listaPersonas.add(nuevaPersona);
	}
	
	public Persona buscarPersona (int numero) {
		System.out.println("Buscar persona por su DNI:");
		for(Persona elemento: listaPersonas) {
			if(numero == elemento.getDni()) {
				System.out.println("Se encontro con exito a la persona: " + elemento.getNombre());
				return elemento;
			}
		}
		System.out.println("No se pudo encontrar el DNI de la perona.");
		return null;
	}

	public void datosPersona (Persona persona) {
		System.out.println("Datos de la persona:");
		System.out.println("Nombre: " + persona.getNombre());
		System.out.println("Apellido: " + persona.getApellido());
		System.out.println("DNI: " + persona.getDni());
		System.out.println("Genero: " + persona.getSexo());
		System.out.println("Telefono: " + persona.getTelefono());
		System.out.println("Direccion: " + persona.getDireccion());
		System.out.println("Fecha de nacimiento: " + persona.getFachaNacimiento());
		System.out.println("Provincia: " + persona.getProvincia());
		System.out.println("Localidad: " + persona.getLocalidad());
	}
	
	public ArrayList <Persona> listarPersonas (){
		return null;
	}
	
	public Persona altaPersona () {
		return null;
	}
	
	public void modificarPersona (Persona persona) {
		// MODIFICAR ALGÚN DATO DE ALGUNA PERSONA
	}
	
	public void bajaPersona (Persona persona) {
		
	}
}
