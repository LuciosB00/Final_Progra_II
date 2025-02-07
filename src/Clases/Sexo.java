package Clases;

import Final_Programacion_II.MetodosGeneral;

public enum Sexo {
	
	MASCULINO("Masculino."),
	FEMENINO("Femenino."),
	OTRO("Otro.");
	
	private final String detalleSexo;
	
	Sexo (String detalleSexo) {
		this.detalleSexo = detalleSexo;
	}
	
	public String obtenerSexo () {
		return this.detalleSexo;
	}
	
	public static Sexo escogerGenero () {
		int seleccion = 0; String seleccionAux = null;
		
		do {
			System.out.println("Generos disponibles:");
			for(Sexo genero: Sexo.values()) {
				System.out.println(genero.ordinal() + 1 + "." + genero.obtenerSexo());
			}
			seleccion = MetodosGeneral.castearEntero("Seleccione algún genero: ", seleccionAux);
		}while(seleccion < 1 || seleccion > 3);
		
		return Sexo.values()[seleccion - 1];
	}
}
