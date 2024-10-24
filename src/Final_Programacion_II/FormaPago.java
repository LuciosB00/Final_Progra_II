package Final_Programacion_II;

public enum FormaPago {
	
	EFECTIVO("Efectivo."),
	TARJETA_DEBITO("Tarjeta de debito."),
	TARJETA_CREDITO("Tarjeta de credito."),
	TRANSFERENCIA("Transferencia."),
	CUENTA_CORRIENTE("Cuenta corriente.");
	
	private final String detallePago;
	
	FormaPago (String detallePago) {
		this.detallePago = detallePago;
	}
	
	public String obetenerFormaPago () {
		return this.detallePago;
	}
}
