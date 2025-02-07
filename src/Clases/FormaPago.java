package Clases;

import Final_Programacion_II.MetodosGeneral;

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
	
	public static FormaPago escogerFomaPago () {
		int seleccion; String seleccionAux = null;
		
		do {
			System.out.println("Formas de pago disponibles:");
			for(FormaPago forma: FormaPago.values()) {
				System.out.println(forma.ordinal() + 1 + "." + forma.obetenerFormaPago());
			}
			seleccion = MetodosGeneral.castearEntero("Seleccione alguna forma de pago: ", seleccionAux);
		}while(seleccion < 1 || seleccion > 5);
		
		return FormaPago.values()[seleccion - 1];
	}
}
