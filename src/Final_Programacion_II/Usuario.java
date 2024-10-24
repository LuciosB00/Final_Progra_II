package Final_Programacion_II;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	public static ArrayList <Usuario> listaUsuarios = new ArrayList <Usuario> ();

	// Atributos
	private String usuario;
	private String clave;
	private Persona propetario;
	
	// Constructores
	public Usuario (String usuario, String clave, Persona propetario) {
		this.usuario = usuario;
		this.clave = clave;
		this.propetario = propetario;
	}
	
	// Setter y Getters
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}

	public Persona getPropetario() {
		return propetario;
	}
	
	// Metodos
	public void agregarUsuario (Persona propetario) {
		Scanner teclado = new Scanner (System.in);
		String usuario, clave;
		
		System.out.println("Ingrese su usuario:");
		usuario = teclado.nextLine();
		System.out.println("Ingrese su clave:");
		clave = teclado.nextLine();
		
		Usuario nuevoUsuario = new Usuario (usuario, clave, propetario);
		listaUsuarios.add(nuevoUsuario);
	}
	
	public Usuario altaUsuario () {
		return null;
	}

	public void bajaUsuario () {
		
	}
	
	public void modificarUsuario () {
		
	}
	
	public Usuario buscarUsuario () {
		return null;
	}
	
	public ArrayList <Usuario> listarUsuario (){
		return null;
	}
}
