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
	public static void altaPersona () {
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
		
		System.out.println("Ingrese el localidad: ");
		localidad = teclado.nextLine();
		
		boolean activo = true;
		
		teclado.close();
		
		Persona nuevaPersona = new Persona(nombre, apellido, dni, activo, genero, telefono, direccion, fechaNac, prov, localidad);
		listaPersonas.add(nuevaPersona);
	}
	
	public static Persona buscarPersonaDni () {
		int num; String numAux=null;
		num = MetodosGeneral.castearEntero("Ingrese el DNI de la persona a buscar: ", numAux);
		for(Persona elemento : listaPersonas) {
			if(num == elemento.getDni()) {
				System.out.println("La persona SI fue encontrada.");
				return elemento;
			}
		}
		System.out.println("La persona NO fue encontrado.");
		return null;
	}

	public void datosPersona (Persona persona) {
		if (persona != null) {
			System.out.println("Datos personales:");
			System.out.println("Nombre: " + persona.getNombre());
			System.out.println("Apellido: " + persona.getApellido());
			System.out.println("DNI: " + persona.getDni());
			System.out.println("Genero: " + persona.sexo.obtenerSexo());
			System.out.println("Activo: " + MetodosGeneral.verificarBooleano(persona.getActivo()));
			System.out.println("Telefono: " + persona.getTelefono());
			System.out.println("Direccion: " + persona.getDireccion());
			System.out.println("Fecha de nacimiento: " + persona.getFachaNacimiento());
			System.out.println("Provincia: " + persona.provincia.obtenerProvincia());
			System.out.println("Localidad: " + persona.getLocalidad());
			System.out.println("------------------------------");
		} else {
			System.out.println("No se encontraron los datos.");
		}
	}
	
	public static void listarPersonas (){
		if (Persona.listaPersonas != null) {
			for (Persona elemento : listaPersonas) {
				elemento.datosPersona(elemento);
			}
		} else {
			System.out.println("No se encontraron los datos.");
		}
	}
	
	public void modificarPersona (Persona persona) {
		if (persona != null) {
			Scanner teclado = new Scanner(System.in);
			
			System.out.println("1 - Modificar nombre.");
			System.out.println("2 - Modificar apellido.");
			System.out.println("3 - Modificar DNI.");
			System.out.println("4 - Modificar genero.");
			System.out.println("5 - Modificar telefono.");
			System.out.println("6 - Modificar direccion.");
			System.out.println("7 - Modificar fecha de nacimiento.");
			System.out.println("8 - Modificar provincia.");
			System.out.println("9 - Modificar localidad.");
			System.out.println("10 - Salir.");
			
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 && num > 10);
			
			switch(num) {
					case 1:
						System.out.println("Ingrese el nombre: ");
						String nombre = teclado.nextLine();
						persona.setNombre(nombre);
						break;
						
					case 2:
						System.out.println("Ingrese el apellido: ");
						String apellido = teclado.nextLine();
						persona.setApellido(apellido);
						break;
						
					case 3:
						String DNI = null;
						int dni = MetodosGeneral.castearEntero ("Ingrese su DNI:", DNI);
						persona.setDni(dni);
						break;
						
					case 4:
						Sexo genero = Sexo.escogerGenero();
						persona.setSexo(genero);
						break;
						
					case 5:
						System.out.println("Ingrese el telefono: ");
						String telefono = teclado.nextLine();
						persona.setTelefono(telefono);
						break;
						
					case 6:
						System.out.println("Ingrese el direccion: ");
						String direccion = teclado.nextLine();
						persona.setDireccion(direccion);
						break;
						
					case 7:
						LocalDate fechaNac = MetodosGeneral.crearFecha("Ingrese fecha de nacimiento:");
						persona.setFachaNacimiento(fechaNac);
						break;
						
					case 8:
						Provincia prov = Provincia.escogerProvincia();
						persona.setProvincia(prov);
						break;
						
					case 9:
						System.out.println("Ingrese el localidad: ");
						String localidad = teclado.nextLine();
						persona.setLocalidad(localidad);
						break;
						
					case 10:
						System.out.println("Saliendo...");
						break;
						
					default:
						break;
			}
			teclado.close();
		} else {
			System.out.println("No se encontraron los datos.");
		}
	}
	
	public void bajaPersona (Persona persona) {
		if (persona != null) {
			persona.setActivo(false);
		}
	}
	
	public static void castearPersona(String...contenido) {
		
	}
}
