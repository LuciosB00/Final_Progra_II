package Clases;

import Final_Programacion_II.MetodosGeneral;

public enum Categoria {

	INDUMENTARIA("Indumentaria."),
	CALZADO("Calzado."),
	ACCESORIO("Accesorio.");
	
	private final String detalleCategoria;
	
	Categoria (String detalleCategoria) {
		this.detalleCategoria = detalleCategoria;
	}
	
	public String obtenerCategoria () {
		return this.detalleCategoria;
	}
	
	public static Categoria escogerCategoria () {
		int seleccion; String seleccionAux = null;
		
		do {
			System.out.println("Provincias disponibles:");
			for(Categoria cate: Categoria.values()) {
				System.out.println(cate.ordinal() + 1 + "." + cate.obtenerCategoria());
			}
			seleccion = MetodosGeneral.castearEntero("Seleccione alguna categoria: ", seleccionAux);
		}while(seleccion < 1 || seleccion > 3);
		
		return Categoria.values()[seleccion - 1];
	}
}
