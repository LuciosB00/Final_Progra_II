package Final_Programacion_II;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Producto {
	public static ArrayList <Producto> listaProductos = new ArrayList <Producto> ();
	
	//Atributos
	private int codigo;
	private String detalle;
	private String talle;
	private double precio;
	private String marca;
	private String material;
	private Categoria categoria;
	private int stock;
	private boolean activo;
	
	// Constructor
	public Producto (String detalle, int codigo, boolean activo, String talle, double precio, int stock, String material, Categoria categoria) {
		this.detalle = detalle;
		this.codigo = codigo;
		this.talle = talle;
		this.precio = precio;
		this.stock = stock;
		this.material = material;
		this.categoria = categoria;
		this.activo = activo;
	}
	
	public Producto (String detalle, int codigo, boolean activo, String talle, double precio, String marca, int stock, String material, Categoria categoria) {
		this.detalle = detalle;
		this.codigo = codigo;
		this.talle = talle;
		this.precio = precio;
		this.marca = marca;
		this.stock = stock;
		this.material = material;
		this.categoria = categoria;
		this.activo = activo;
	}
	
	// Stters y Getters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public boolean getActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getTalle() {
		return talle;
	}
	public void setTalle(String talle) {
		this.talle = talle;
	}

	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}

	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	// Metodos
	public static void altaProducto () {
		Scanner teclado = new Scanner (System.in);
		String detalle,marca,material,talle; int codigo,stock; double precio; Categoria categoria;
		String codigoAux=null, stockAux=null, precioAux=null;
		
		codigo = MetodosGeneral.castearEntero("Ingrese el codigo del producto:", codigoAux);
		
		System.out.println("Ingrese el detalle del producto:");
		detalle = teclado.nextLine();
		
		System.out.println("Ingrese el talle del producto:");
		talle = teclado.nextLine();
		
		precio = MetodosGeneral.castearDecimal("Ingrese el precio del producto:", precioAux);
		
		System.out.println("Ingrese la marca del producto:");
		marca = teclado.nextLine();
		
		System.out.println("Ingrese el material del producto:");
		material = teclado.nextLine();
		
		categoria = Categoria.escogerCategoria();
		
		stock = MetodosGeneral.castearEntero("Ingrese el stock del prodcuto:", stockAux);
		
		boolean activo = true;
		
		teclado.close();
		
		Producto nuevoProducto = new Producto (detalle, codigo, activo, talle, precio, marca, stock, material, categoria);
		listaProductos.add(nuevoProducto);
	}
	
	public void bajaProducto (Producto producto) {
		if (producto != null) {
			producto.setActivo(false);
		} else {
			System.out.println("No se encontraron los datos.");
		}
	}
	
	public void modificarProducto (Producto producto) {
		if (producto != null) {
			Scanner teclado = new Scanner(System.in);
			
			System.out.println("1 - Modificar codigo.");
			System.out.println("2 - Modificar detalle.");
			System.out.println("3 - Modificar talle.");
			System.out.println("4 - Modificar precio.");
			System.out.println("5 - Modificar marca.");
			System.out.println("6 - Modificar material.");
			System.out.println("7 - Modificar categoria.");
			System.out.println("8 - Modificar stock disponible.");
			System.out.println("9 - Salir.");
			
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 && num > 9);
			
			switch(num) {
					case 1:
						String codigoAux = null;
						int codigo = MetodosGeneral.castearEntero("Ingrese el codigo del producto:", codigoAux);
						producto.setCodigo(codigo);
						break;
					
					case 2:
						System.out.println("Ingrese el detalle del producto:");
						String detalle = teclado.nextLine();
						producto.setDetalle(detalle);
						break;
						
					case 3:
						System.out.println("Ingrese el talle del producto:");
						String talle = teclado.nextLine();
						producto.setTalle(talle);
						break;
						
					case 4:
						String precioAux = null;
						double precio = MetodosGeneral.castearDecimal("Ingrese el precio del producto:", precioAux);
						producto.setPrecio(precio);
						break;
						
					case 5:
						System.out.println("Ingrese la marca del producto:");
						String marca = teclado.nextLine();
						producto.setMarca(marca);
						break;
						
					case 6:
						System.out.println("Ingrese el material del producto:");
						String material = teclado.nextLine();
						producto.setMaterial(material);
						break;
						
					case 7:
						categoria = Categoria.escogerCategoria();
						producto.setCategoria(categoria);
						break;
						
					case 8:
						String stockAux = null;
						int stock = MetodosGeneral.castearEntero("Ingrese el stock del prodcuto:", stockAux);
						producto.setStock(stock);
						break;
						
					case 9:
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
	
	public static void listarProductos (){
		if (Producto.listaProductos != null) {
			for (Producto elemento : listaProductos){
				elemento.datosProducto(elemento);
			}
		} else {
			System.out.println("No se encontraron los datos.");
		}
	}
	
	public static Producto buscarProductoCodigo () {
		int codigo; String codigoAux=null;
		codigo = MetodosGeneral.castearEntero("Ingrese el codigo del producto a buscar: ", codigoAux);
		for(Producto elemento : listaProductos) {
			if(codigo == elemento.getCodigo()) {
				System.out.println("El producto SI fue encontrado.");
				return elemento;
			}
		}
		System.out.println("El producto NO fue encontrado.");
		return null;
	}
	
	public void datosProducto (Producto producto) {
		if (producto != null) {
			System.out.println("Datos del producto:");
			System.out.println("Codigo: " + producto.getCodigo());
			System.out.println("Detalle: " + producto.getDetalle());
			System.out.println("Categoria: " + producto.getCategoria());
			System.out.println("Precio: " + producto.getPrecio());
			System.out.println("Marca: " + producto.getMarca());
			System.out.println("Talle: " + producto.getTalle());
			System.out.println("Material: " + producto.getMaterial());
			System.out.println("Stcok: " + producto.getStock());
			System.out.println("Activo: " + MetodosGeneral.verificarBooleano(producto.getActivo()));
			System.out.println("------------------------------");
		} else {
			System.out.println("No se encontraron los datos.");
		}
	}
	
	public static Vector <Producto> enviarVectorProductos (Producto...productos) {
		if (productos != null) {
			Vector <Producto> vectorProductos = new Vector <Producto> (10);
			for (int i=0; i<10; i++) {
				vectorProductos.add(productos[i]);
			}
			return vectorProductos;
		} else {
			System.out.println("No se encontraron los datos.");
		}
		return null;
	}
}
