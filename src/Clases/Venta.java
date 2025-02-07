package Clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import Final_Programacion_II.MetodosGeneral;

public class Venta implements Serializable{
	private static final long serialVersionUID = 1L;
	public static ArrayList <Venta> listaVentas = new ArrayList <Venta> ();
	
	// Atributos
	private int codigo;
	String detalle;
	private Cliente cliente;
	private int cantidad;
	private Vector <Producto> productos = new Vector <Producto> (10);
	private double total;
	private FormaPago pago;
	private boolean activo;
	
	// Constructor
	public Venta (int codigo, String detalle, double total, boolean activo, int cantidad, FormaPago pago, Cliente cliente, Vector <Producto> productos) {
		this.codigo = codigo;
		this.detalle = detalle;
		this.total = total;
		this.cantidad = cantidad;
		this.pago = pago;
		this.productos = productos;
		this.activo = activo;
	}
	
	// Setters y Getters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	public boolean getActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
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
	public void setPago(FormaPago pago) {
		this.pago = pago;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vector <Producto> getVectorProducto() {
		return productos;
	}
	public void setVectorProducto(Vector <Producto> productos) {
		this.productos = productos;
	}
	
	// Metodos
	public static void altaVenta (Cliente cliente, Vector <Producto> productos) {
		int codigo, cantidad=0; double total=0.0; FormaPago pago;
		String codigoAux=null,detalle=null;
		
		codigo = MetodosGeneral.castearEntero("Ingrese el codigo de la venta:", codigoAux);
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese el detalle de la venta: ");
		detalle = teclado.nextLine();
		
		for (Producto elemento : productos) {
			total += elemento.getPrecio();
			cantidad++;
		}
				
		pago = FormaPago.escogerFomaPago();
		boolean activo = true;
		
		Venta nuevaVenta = new Venta (codigo, detalle, total, activo, cantidad, pago, cliente, productos);
		listaVentas.add(nuevaVenta);
		
		teclado.close();
	}
	
	public void bajaVenta (Venta venta) {
		if (venta != null) {
			venta.setActivo(false);
		}
	}
	
	public void modificarVenta (Venta venta) {
		if (venta != null) {
			Scanner teclado = new Scanner(System.in);
			
			System.out.println("1 - Modificar codigo.");
			System.out.println("2 - Modificar detalle.");
			System.out.println("3 - Modificar cantidad.");
			System.out.println("4 - Modificar total.");
			System.out.println("5 - Modificar forma de pago.");
			System.out.println("6 - Salir.");
			
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 && num > 9);
			switch(num) {
					case 1:
						String codigoAux = null;
						int codigo = MetodosGeneral.castearEntero("Ingrese el codigo de la venta:", codigoAux);
						venta.setCodigo(codigo);
						break;
						
					case 2:
						String detalle;
						System.out.println("Ingrese el detalle de la venta: ");
						detalle = teclado.nextLine();
						venta.setDetalle(detalle);
						break;
						
					case 3:
						String cantidadAux = null;
						int cantidad = MetodosGeneral.castearEntero("Ingrese la cantidad:", cantidadAux);
						venta.setCantidad(cantidad);
						break;
						
					case 4:
						String totalAux = null;
						double total = MetodosGeneral.castearDecimal("Ingrese el total:", totalAux);
						venta.setTotal(total);
						break;
						
					case 5:
						FormaPago pago = FormaPago.escogerFomaPago();
						venta.setPago(pago);
						break;
						
					case 6:
						System.out.println("Saliendo...");
						break;
						
					default:
						break;
			}
			teclado.close();
		} else {
			System.out.println("No se encontraron los datos.");
		}
	}
	
	public static void listarVentas (){
		if(Venta.listaVentas != null) {
			for (Venta elemento : listaVentas) {
				elemento.datosVenta(elemento);
			}
		} else {
			System.out.println("No se encontraron los datos.");
		}
	}
	
	public static Venta buscarVentaCodigo () {
		int codigo; String codigoAux=null;
		codigo = MetodosGeneral.castearEntero("Ingrese el codigo del producto a buscar: ", codigoAux);
		for(Venta elemento : listaVentas) {
			if(codigo == elemento.getCodigo()) {
				System.out.println("La venta SI fue encontrado.");
				return elemento;
			}
		}
		System.out.println("La venta NO fue encontrado.");
		return null;
	}
	
	public void datosVenta (Venta venta) {
		if(venta !=null) {
			System.out.println("Datos de la venta:");
			System.out.println("Codigo: " + venta.getCodigo());
			System.out.println("Total: " + venta.getTotal());
			System.out.println("Activo: " + MetodosGeneral.verificarBooleano(venta.getActivo()));
			System.out.println("Cantidad: " + venta.getCantidad());
			System.out.println("Pago: " + venta.getPago());
			System.out.println("Cliente: " + venta.getCliente());
			
			System.out.println("Productos: ");
			for(Producto elemento : venta.getVectorProducto()) {
				System.out.println(elemento.getDetalle());
			}
			
			System.out.println("------------------------------");
		}else {
			System.out.println("No se encontraron los datos.");
		}
	}
	
	public void verDetalleProdcutos (Vector <Producto> productos) {
		if(productos != null) {
			for (Producto elemento : productos) {
				elemento.datosProducto(elemento);
			}
		}else {
			System.out.println("No se encontraron los datos.");
		}
	}
	
	public void agregarProductos (Venta venta, Vector <Producto> vectorProductos, Producto...productos) {
		if(venta != null && vectorProductos != null && productos != null) {
			int cant = vectorProductos.size(), cont = 0; double precio = 0.0;
			for (Producto elemento : productos) {
				cont++;
			}
			if (cant > 10) {
				System.out.println("El vector esta en su limite, no puede agregar más.");
			} else if (cont > (10 - cant)) {
				System.out.println("Los productos que intenta agregar superan el limite.");
			} else {
				for (Producto elemento : productos) {
					vectorProductos.add(elemento);
					precio = elemento.getPrecio();
				}
				System.out.println("Los productos han sido agregados.");
				this.setVectorProducto(vectorProductos);
				this.setCantidad(vectorProductos.size());
				System.out.println("La cantidad de productos se ha actualizado.");
				precio += this.getTotal();
				this.setTotal(precio);
				System.out.println("El total de la venta se ha actualizado.");
			}
		}else {
			System.out.println("No se encontraron los datos.");
		}
	}
}
