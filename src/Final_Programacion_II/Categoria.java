package Final_Programacion_II;

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
}
