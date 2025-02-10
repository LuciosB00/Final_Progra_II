package Archivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Clases.Usuario;

public class ArchivoUsuario {
	
	// CREAR ARCHIVO
	public static void crearArchivoUsuario() {
		String ruta = "Carpeta General" + File.separator + "usuario.dat";
		File archivo = new File(ruta);
		if (archivo.exists()==false){
			try {
				if (archivo.createNewFile()) {
					System.out.println("El archivo se creó con exito");
				}
			} catch (IOException error) {
				System.out.println("ERROR: " + error.getMessage());
			}
		} else {
			System.out.println("El archivo que intenta crear ya existe.");
		}
	}
	
	// ELIMINAR ARCHIVO
	public static void eliminarArchivoUsuario() {
		String ruta = "Carpeta General" + File.separator + "usuario.dat";
		File miArchivo = new File (ruta);
		if (miArchivo.exists()){
			if (miArchivo.delete()) {
				System.out.println("Se ha eliminado correctamente el archivo.");
			} else {
				System.out.println("No se ha podido eliminar el archivo.");
			}
		} else {
			System.out.println("No se elimino nada porque no existe.");
		}
	}
	
	// SERIALIZAR
	public static void guardarUsuarios() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Carpeta General" + File.separator + "usuario.dat"))) {
		oos.writeObject(Usuario.listaUsuarios);
		System.out.println("Archivo usuario guardado correctamente.");
		} catch (IOException error) {
			System.out.println("Error al guardar: " + error.getMessage());
		}
	}

	// DESERIALIZAR
	public static void cargarUsuarios() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Carpeta General" + File.separator + "usuario.dat"))) {
			Usuario.listaUsuarios = (ArrayList <Usuario>) ois.readObject();
			System.out.println("Archivo usuario cargado correctamente.");
		} catch (IOException error) {
			System.out.println("Error al cargar: " + error.getMessage());
		} catch (ClassNotFoundException error) {
			System.out.println("Clase no encontrada: " + error.getMessage());
		}
	}
}
