package Final_Programacion_II;

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
}
