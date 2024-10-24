package Final_Programacion_II;

import java.util.ArrayList;
import java.util.Scanner;

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
	
	// Constructor
	public Producto (String detalle, int codigo, String talle, double precio, int stock, String material, Categoria categoria) {
		this.detalle = detalle;
		this.codigo = codigo;
		this.talle = talle;
		this.precio = precio;
		this.stock = stock;
		this.material = material;
		this.categoria = categoria;
	}
	
	public Producto (String detalle, int codigo, String talle, double precio, String marca, int stock, String material, Categoria categoria) {
		this.detalle = detalle;
		this.codigo = codigo;
		this.talle = talle;
		this.precio = precio;
		this.marca = marca;
		this.stock = stock;
		this.material = material;
		this.categoria = categoria;
	}
	
	// Stters y Getters
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

	// Metodos
	public static void agregarProducto () {
		Scanner teclado = new Scanner (System.in);
		String detalle,marca,material,talle; int codigo,stock; double precio; Categoria categoria;
		String codigoAux=null, stockAux=null, precioAux=null;
		
		codigo = MetodosGeneral.castearEntero("Ingrese el codigo del producto:", codigoAux);
		System.out.println("Ingrese el detalle del producto:");
		detalle = teclado.nextLine();
		System.out.println("Ingrese el talle del producto:");
		talle = teclado.nextLine();
		precio = MetodosGeneral.castearDecimal("Ingrese el precio del prodcuto:", precioAux);
		System.out.println("Ingrese la marca del producto:");
		marca = teclado.nextLine();
		System.out.println("Ingrese el material del producto:");
		material = teclado.nextLine();
		categoria = MetodosGeneral.escogerCategoria();
		stock = MetodosGeneral.castearEntero("Ingrese el stock del prodcuto:", stockAux);
		
		Producto nuevoProducto = new Producto (detalle, codigo, talle, precio, marca, stock, material, categoria);
		listaProductos.add(nuevoProducto);
	}
	
	public Producto altaPrducto () {
		return null;
	}
	
	public void bajaProducto () {
		
	}
	
	public void modificarProducto () {
		// MODIFICAR ALGÚN DATO DE ALGÚN PRODUCTO
	}
	
	public ArrayList <Producto> listarProducto (){
		return null;
	}
	
	public Producto busquedaProducto () {
		// BUSCAR POR CODIGO
		// BUSCAR POR CATEGORIA
		// BUSCAR POR MARCA
		// BUSCAR POR TALLE
		return null;
	}
	
	public void verDetalleProducto (Producto producto) {
		System.out.println("Detalles del producto:");
		System.out.println("Codigo: " + producto.getCodigo());
		System.out.println("Detalle: " + producto.getDetalle());
		System.out.println("Categoria: " + producto.getCategoria());
		System.out.println("Precio: " + producto.getPrecio());
		System.out.println("Marca: " + producto.getMarca());
		System.out.println("Talle: " + producto.getTalle());
		System.out.println("Material: " + producto.getMaterial());
		System.out.println("Stcok: " + producto.getStock());
	}
}
