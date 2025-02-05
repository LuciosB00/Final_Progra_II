package Final_Programacion_II;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	public static ArrayList <Usuario> listaUsuarios = new ArrayList <Usuario> ();

	// Atributos
	private String usuario;
	private String clave;
	private Persona propetario;
	private boolean activo;
	
	// Constructores
	public Usuario (String usuario, String clave, Persona propetario, boolean activo) {
		this.usuario = usuario;
		this.clave = clave;
		this.propetario = propetario;
		this.activo = activo;
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
	public void setPropetario(Persona propetario) {
		this.propetario = propetario;
	}
	
	public boolean getActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	// Metodos
	public static void altaUsuario (Persona propietario) {
		if(propietario != null) {
			Scanner teclado = new Scanner (System.in);
			String usuario, clave;
			
			System.out.println("Ingrese su usuario:");
			usuario = teclado.nextLine();
			
			System.out.println("Ingrese su clave:");
			clave = teclado.nextLine();
			
			boolean activo = true;
			
			teclado.close();
			
			Usuario nuevoUsuario = new Usuario (usuario, clave, propietario, activo);
			listaUsuarios.add(nuevoUsuario);
		}else {
			System.out.println("No se encontraron los datos.");
		}
	}

	public void bajaUsuario (Usuario usuario) {
		if(usuario != null) {
			usuario.setActivo(false);
		}else {
			System.out.println("No se encontraron los datos.");
		}
	}
	
	public void modificarUsuario (Usuario usuario) {
		if(usuario != null) {
			Scanner teclado = new Scanner(System.in);
			
			System.out.println("1 - Modificar nombre de usuario.");
			System.out.println("2 - Salir.");
			
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 && num > 2);
			
			switch(num) {
			case 1:
				System.out.println("Ingrese su usuario:");
				String usuarioAux = teclado.nextLine();
				usuario.setUsuario(usuarioAux);
				break;
			}
			teclado.close();
		}else {
			System.out.println("No se encontraron los datos.");
		}
	}
	
	public static Usuario buscarUsuario () {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese el nombre de usuario a buscar:");
		String usser = teclado.nextLine();
		
		for(Usuario elemento : listaUsuarios) {
			if(usser.equals(elemento.getUsuario())) {
				System.out.println("El usuario SI se ha encontrado.");
				teclado.close();
				return elemento;
			}
		}
		
		teclado.close();
		System.out.println("El usuario NO se ha encontrado.");
		return null;
	}
	
	public void datosUsuario(Usuario usuario) {
		if(usuario != null) {
			System.out.println("Datos del usuario:");
			System.out.println("Usuario: " + usuario.getUsuario());
			System.out.println("Clave: " + usuario.getClave());
			System.out.println("Propietario: " + usuario.getPropetario());
			System.out.println("Activo: " + MetodosGeneral.verificarBooleano(usuario.getActivo()));
			System.out.println("------------------------------");
		}else {
			System.out.println("No se encontraron los datos.");
		}
	}
	
	public static void listarUsuario (ArrayList <Usuario> listaUsuarios){
		if(listaUsuarios != null) {
			for(Usuario elemento : listaUsuarios) {
				elemento.datosUsuario(elemento);
			}
		}else {
			System.out.println("No se encontraron los datos.");
		}
	}
}
