package Final_Programacion_II;

import java.util.ArrayList;
import java.util.Vector;

public class Venta {
	public static ArrayList <Venta> listaVentas = new ArrayList <Venta> ();
	
	// Atributos
	private int codigo;
	private Cliente cliente;
	private int cantidad;
	private Vector <Producto> productos = new Vector <Producto> (10);
	private double total;
	private FormaPago pago;
	
	// Constructor
	public Venta (int codigo, double total, int cantidad, FormaPago pago, Cliente cliente, Vector <Producto> productos) {
		this.codigo = codigo;
		this.total = total;
		this.cantidad = cantidad;
		this.pago = pago;
	}
	
	// Setters y Getters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

	public FormaPago getPago() {
		return pago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Vector <Producto> getVectorProducto() {
		return productos;
	}
	
	// Metodos
	public void agregarVenta (Cliente cliente, Vector <Producto> productos) {
		int codigo, cantidad; double total; FormaPago pago;
		String codigoAux=null, cantidadAux=null, totalAux=null;
		
		codigo = MetodosGeneral.castearEntero("Ingrese el codigo de la venta:", codigoAux);
		cantidad = MetodosGeneral.castearEntero("Ingrese la cantidad:", cantidadAux);
		total = MetodosGeneral.castearDecimal("Ingrese el total:", totalAux);
		pago = MetodosGeneral.escogerFomaPago();
		
		Venta nuevaVenta = new Venta (codigo, total, cantidad, pago, cliente, productos);
		listaVentas.add(nuevaVenta);
	}
	
	public Venta altaVenta () {
		return null;
	}
	
	public void bajaVenta () {
		
	}
	
	public void modificarVenta () {
		
	}
	
	public ArrayList <Venta> listarVenta (){
		return null;
	}
	
	public Venta buscarVenta () {
		return null;
	}
	
	public void verDetalleVenta (Venta venta) {
		
	}
}
