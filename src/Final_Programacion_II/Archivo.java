package Final_Programacion_II;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Archivo {
	
	// CREAR CARPETA
	public static void crearCarpeta(String ruta) {
		File archivo = new File(ruta);
		if (archivo.mkdir()) {
			System.out.println("Carpeta creada con exito.");
		} else {
			System.out.println("Carpeta NO fue creada.");
			System.out.println("Revise la ruta enviada.");
			System.out.println("Revise que la carpeta no exista.");
			System.out.println("Revise sus permisos.");
		}
	}
	
	// CREAR ARCHIVO TXT
	public static void crearArchivo(String ruta) {
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
	
	// ABRIR CONEXIÓN ARCHIVO MODO ESCRITURA
	public static PrintWriter abrirArchivoEscritura(String ruta) throws IOException {
		File archivo = new File(ruta);
		if (archivo.exists()) {
			FileWriter escribirArchivo = new FileWriter(archivo,true);
			PrintWriter imprimir = new PrintWriter(escribirArchivo);
			return imprimir;
		} else {
			throw new IOException("El archivo especificado no existe.");
		}	
	}
	
	// ESCRIBIR ARCHIVO
	public static void escribirArchivo(PrintWriter imprimir, String contenido) {
		if (contenido != null) {
			imprimir.println(contenido);
		}
	}
	
	// CERRAR CONEXIÓN MODO ESCRITURA
	public static void cerrarArchivoEscritura(PrintWriter imprimir) {
		if (imprimir != null) {
			imprimir.close();
		}
	}
	
	// ABRIR CONEXIÓN ARCHIVO MODO LECTURA
	public static BufferedReader abrirArchivoLectura(String ruta) throws IOException {
		File archivo = new File(ruta);
		if (archivo.exists()) {
			FileReader archivoLectura = new FileReader (archivo);
			BufferedReader leyendo = new BufferedReader(archivoLectura);
			return leyendo;
		} else {
			throw new IOException("El archivo especificado no existe.");
		}	
	}
	
	// LEER ARCHIVO
	public static ArrayList <String> leerArchivo (BufferedReader leyendo) throws IOException {
		ArrayList <String> listaGeneral = new ArrayList <String>();
		String aux = leyendo.readLine();
		while(aux != null) {
			listaGeneral.add(aux);
			aux = leyendo.readLine();
		}
		return listaGeneral;
	}
	
	
	// METODO PARA CERRAR CONEXION CON UN ARCHIVO MODO LECTURA
	public static void cerrarArchivoLectura (BufferedReader leyendo) throws IOException {
		if(leyendo != null) {
			leyendo.close();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	//METODO PARA ABRIR CONEXION PARA LECTURA
//	public static BufferedReader abrirConexionLectura(String ruta) throws FileNotFoundException {
//	    File miArchivo = new File(ruta);
//	    if (miArchivo.exists()) {
//	        return new BufferedReader(new FileReader(miArchivo));
//	    } else {
//	        throw new FileNotFoundException("El archivo especificado no existe.");
//	    }
//	}
//	
//	public static ArrayList<String> leerArchivo (BufferedReader lectura) {
//		ArrayList<String> listaRetorno = new ArrayList<String>();
//		try {
//			String contenido = lectura.readLine();
//			while (contenido != null) {
//				listaRetorno.add(contenido);
//				contenido = lectura.readLine();
//			}
//		} catch ( IOException error) {
//			System.out.println(error.getMessage());
//		}
//		return listaRetorno;
//	}
//	
//	
//	//METODO PARA CERRAR LA CONEXION DE LECTURA
//	public static void cerrarConexionLecutra(BufferedReader escritura) {
//	    if (escritura != null) {
//	        try {
//				escritura.close();
//			} catch (IOException error) {
//				System.out.println("ERROR: " + error.getMessage());
//			}
//	    }
//	}
//	
}
