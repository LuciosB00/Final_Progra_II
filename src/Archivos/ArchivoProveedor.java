package Archivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Clases.Proveedor;

public class ArchivoProveedor {
	
	// CREAR ARCHIVO
	public static void archivoProveedor() {
		String ruta = "Carpeta General" + File.separator + "proveedor.dat";
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
	public static void guardarProveedores() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("proveedor.dat"))) {
			oos.writeObject(Proveedor.listaProveedores);
			System.out.println("Archivo guardado correctamente.");
		} catch (IOException error) {
			System.out.println("Error al guardar: " + error.getMessage());
		}
	}

	// DESERIALIZAR
	public static void cargarProveedores() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("proveedor.dat"))) {
			Proveedor.listaProveedores = (ArrayList <Proveedor>) ois.readObject();
			System.out.println("Archivo cargado correctamente.");
		} catch (IOException error) {
			System.out.println("Error al cargar: " + error.getMessage());
		} catch (ClassNotFoundException error) {
			System.out.println("Clase no encontrada: " + error.getMessage());
		}
	}
}
