package Archivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Clases.Movimiento;

public class ArchivoMovimiento {
	
	// CREAR ARCHIVO
	public static void archivoMovimiento() {
		String ruta = "Carpeta General" + File.separator + "movimiento.dat";
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
	public static void guardarMovimientos() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("movimiento.dat"))) {
			oos.writeObject(Movimiento.listaMovimientos);
			System.out.println("Personas guardadas correctamente.");
		} catch (IOException error) {
			System.out.println("Error al guardar: " + error.getMessage());
		}
	}

	// DESERIALIZAR
	public static void cargarMovimientos() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("movimiento.dat"))) {
			Movimiento.listaMovimientos = (ArrayList <Movimiento>) ois.readObject();
			System.out.println("Personas cargadas correctamente.");
		} catch (IOException error) {
			System.out.println("Error al cargar las personas: " + error.getMessage());
		} catch (ClassNotFoundException error) {
			System.out.println("Clase no encontrada: " + error.getMessage());
		}
	}
}
