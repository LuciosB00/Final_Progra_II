package Archivos;

import java.util.ArrayList;

import Clases.Persona;

import java.io.*;

public class ArchivoPersona {
	
	// CREAR ARCHIVO
	public static void archivoPersona() {
		String ruta = "Carpeta General" + File.separator + "persona.dat";
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
	
	// SERIALIZAR
	public static void guardarPersonas() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("personas.dat"))) {
		oos.writeObject(Persona.listaPersonas);
		System.out.println("Personas guardadas correctamente.");
		} catch (IOException error) {
			System.out.println("Error al guardar: " + error.getMessage());
	    }
	}

	// DESERIALIZAR
	public static void cargarPersonas() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("personas.dat"))) {
			Persona.listaPersonas = (ArrayList <Persona>) ois.readObject();
			System.out.println("Personas cargadas correctamente.");
		} catch (IOException error) {
			System.out.println("Error al cargar las personas: " + error.getMessage());
		} catch (ClassNotFoundException error) {
			System.out.println("Clase no encontrada: " + error.getMessage());
		}
	}
}
