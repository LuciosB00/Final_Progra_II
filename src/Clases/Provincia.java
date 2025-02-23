package Clases;

import Final_Programacion_II.MetodosGeneral;

public enum Provincia {
	
	SANTA_FE("Santa Fe."),
	BUENOS_AIRES("Buenos Aires."),
	SANTIAGO_DEL_ESTERO("Santiago del Estero."),
	CORDOBA("Córdoba."),
	MISIONES("Misiones."),
	FORMOSA("Formosa."),
	JUJUY("Jujuy."),
	SALTA("Salta."),
	CATAMARCA("Catamarca."),
	LA_RIOJA("La Rioja."),
	SAN_LUIS("San Luis."),
	SAN_JUAN("San Juan."),
	MENDOZA("Mendoza."),
	RIO_NEGRO("Río Negro."),
	CHUBUT("Chubut."),
	SANTA_CRUZ("Santa Cruz."),
	TIERRA_DEL_FUEGO("Tierra del fuego."),
	CORRIENTES("Corrients."),
	ENTRE_RIOS("Entre Rios."),
	TUCUMAN("Tucumán."),
	LA_PAMPA("La Pampa."),
	NEUQUEN("Neuquén."),
	CHACO("Chaco.");
	
	private final String detalleProv;
	
	Provincia (String detalleProv) {
		this.detalleProv = detalleProv;
	}
	
	public String obtenerProvincia () {
		return this.detalleProv;
	}
	
	public static Provincia escogerProvincia () {
		int seleccion; String seleccionAux = null;
		
		do {
			System.out.println("Provincias disponibles:");
			for(Provincia prov: Provincia.values()) {
				System.out.println(prov.ordinal() + 1 + "." + prov.obtenerProvincia());
			}
			seleccion = MetodosGeneral.castearEntero("Seleccione alguna provincia: ", seleccionAux);
		}while(seleccion < 1 || seleccion > 23);
		
		return Provincia.values()[seleccion - 1];
	}
}
