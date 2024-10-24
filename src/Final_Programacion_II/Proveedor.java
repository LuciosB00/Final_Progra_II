package Final_Programacion_II;

import java.time.LocalDate;
import java.util.ArrayList;

public class Proveedor extends Persona{
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
	
	// Metodos
	public void verCtaCte () {
		
	}
}
