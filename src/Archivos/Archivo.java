package Archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Final_Programacion_II.MetodosGeneral;

public class Archivo {
	
	// CREAR CARPETA
	public static void crearCarpeta(String ruta) {
		if(ruta != null) {
			File archivo = new File(ruta);
			if (archivo.mkdir()) {
				System.out.println("Carpeta creada con exito.");
			} else {
				System.out.println("Carpeta NO fue creada:");
				System.out.println("Revise si la carpeta ya existe.");
				System.out.println("Revise si la ruta es correcta.");
				System.out.println("Revise algún fallo en el proceso.");
			}
		}else {
			System.out.println("No se han encontrado los datos.");
		}
	}
	
	// ELIMINAR CARPETA
	public static void eliminarCarpeta(String ruta) {
		if(ruta != null) {
		    File carpeta = new File(ruta);
		    if (carpeta.exists()) {
		    	if(MetodosGeneral.escogerBooleano("¿ESTA SEGURO DE QUE DESEA ELIMINAR LA CARPETA PRINCIPAL? TODOS LOS ARCHIVOS DENTRO SERÁN ELIMINADOS:")) {
		    		eliminarRecursivo(carpeta);
		        	System.out.println("La carpeta ha sido eliminada correctamente.");
		    	}else {
		    		System.out.println("No se elimino la carpeta.");
		    	}
		    } else {
		        System.out.println("No se elimino nada porque la carpeta no existe.");
		    }
		}else {
			System.out.println("No se han encontrado los datos.");
		}
	}
	
	// ELIMINAR RECURSIVO
	private static void eliminarRecursivo(File carpeta) {
		if(carpeta != null) {
		    if (carpeta.isDirectory()) {
		        File[] Arregloarchivos = carpeta.listFiles();
		        if (Arregloarchivos != null) {
		            for (File file : Arregloarchivos) {
		                eliminarRecursivo(file);
		            }
		        }
		    }
		    carpeta.delete();
		}else {
			System.out.println("No se han encontrado los datos.");
		}
	}
	
	// CREAR ARCHIVO
	public static void crearArchivo(String ruta) {
		if(ruta != null) {
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
		}else {
			System.out.println("No se han encontrado los datos.");
		}
	}
	
	// ELIMINAR ARCHIVO
	public static void eliminarArchivo(String ruta) {
		if(ruta != null) {
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
		}else {
			System.out.println("No se han encontrado los datos.");
		}
	}
	
	public static void eliminarArchivos(String ruta) {
		if(ruta != null) {
			File carpeta = new File(ruta);
		    if (carpeta.exists() && carpeta.isDirectory()) {
		        File[] Arregloarchivos = carpeta.listFiles();
		        if (Arregloarchivos != null) {
		            for (File file : Arregloarchivos) {
		                eliminarRecursivo(file);
		            }
		        }
		        System.out.println("Todos el contenido ha sido eliminados.");
		    }
		}else {
			System.out.println("No se han encontrado los datos.");
		}
	}
	
	// ABRIR CONEXIÓN ARCHIVO MODO ESCRITURA
	public static PrintWriter abrirArchivoEscritura(String ruta) {
		if(ruta != null) {
			File archivo = new File(ruta);
			PrintWriter imprimir = null;
			try {
				if (archivo.exists()) {
					FileWriter escribirArchivo = new FileWriter(archivo,true);
					imprimir = new PrintWriter(escribirArchivo);
				} else {
					System.out.println("El archivo especificado no existe.");
				}	
			} catch (IOException error) {
				System.out.println(error.getMessage());
			}
			return imprimir;
		}else {
			System.out.println("No se han encontrado los datos.");
		}
		return null;
	}
	
	// ESCRIBIR ARCHIVO
	public static void escribirArchivo(PrintWriter imprimir, String contenido) {
		if (contenido != null && imprimir != null) {
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
	public static BufferedReader abrirArchivoLectura(String ruta) {
		if(ruta != null) {
			File archivo = new File(ruta);
			BufferedReader leyendo = null;
			try {
				if (archivo.exists()) {
					FileReader archivoLectura = new FileReader (archivo);
					leyendo = new BufferedReader(archivoLectura);
				} else {
					System.out.println("El archivo especificado no existe.");
				}	
			} catch (IOException error) {
				System.out.println(error.getMessage());
			}
			return leyendo;
		}else {
			System.out.println("No se han encontrado los datos.");
		}
		return null;
	}
	
	// LEER ARCHIVO
	public static ArrayList <String> leerArchivo (BufferedReader leyendo) {
		if(leyendo != null) {
			ArrayList <String> listaGeneral = new ArrayList <String>();
			try {
				String aux = leyendo.readLine();
				while(aux != null) {
					listaGeneral.add(aux);
					aux = leyendo.readLine();
				}
			} catch ( IOException error) {
				System.out.println(error.getMessage());
			}
			return listaGeneral;
		}else {
			System.out.println("No se han encontrado los datos.");
		}
		return null;
	}
	
	
	// CERRAR CONEXION MODO LECTURA
	public static void cerrarArchivoLectura (BufferedReader leyendo) {
		if (leyendo != null) {
	        try {
	        	leyendo.close();
			} catch (IOException error) {
				System.out.println("ERROR: " + error.getMessage());
			}
	    }else {
	    	System.out.println("No se han encontrado los datos.");
	    }
	}
	
//	//LEER
//	public static void leerArchivoClass (String ruta) {
//		if(ruta != null) {
//			File miArchivo = new File (ruta);
//			BufferedReader lectura = null;
//			try {
//				lectura = Archivo.abrirConexionLectura(ruta);
//				String contenido = lectura.readLine();
//				while (contenido != null) {
//					String [] vectorContenido = contenido.split("[$]");
//					Class elemento = new Class (constructor);
//					Class.listaClass.add(elemento);
//					contenido = lectura.readLine();
//				}
//				Archivo.cerrarConexionLecutra(lectura);
//			}catch (FileNotFoundException error) {
//				System.out.println(error.getMessage());
//			}catch ( IOException error) {
//				System.out.println(error.getMessage());
//			}
//		}else {
//			System.out.println("No se ha encontrado la ruta.");
//		}
//	}
//	
//	//ESCRIBIR
//	public static void escribirArchivoClass (String ruta, String contenido) {
//		if(ruta != null && contenido != null) {
//			File miArchivo = new File (ruta);
//			PrintWriter escritura = null;
//			try {
//				escritura = Archivo.abrirConexionEscritura(ruta);
//			}catch (IOException error) {
//				System.out.println(error.getMessage());
//			}
//			if (escritura != null) {
//				for (Class elemento: Class.listaClass) {
//					String contenido = elemento.getters;
//					Archivo.escribirArchivo(escritura, contenido);
//				}
//				Archivo.cerrarConexionEscritura(escritura);
//			}
//		}else {
//			System.out.println("La ruta o el contenido no se han encontrado.");
//		}
//	}
}