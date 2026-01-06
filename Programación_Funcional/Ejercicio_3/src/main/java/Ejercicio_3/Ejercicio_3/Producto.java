package Ejercicio_3.Ejercicio_3;

public class Producto {
	private String Nombre;
	private String Categoria;
	private Integer Cantidad;
	private Double Precio;
	
	public Producto(String nombre, String categoria, Integer cantidad, Double precio) {
		Nombre = nombre;
		Categoria = categoria;
		Cantidad = cantidad;
		Precio = precio;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

	public Integer getCantidad() {
		return Cantidad;
	}

	public void setCantidad(Integer cantidad) {
		Cantidad = cantidad;
	}

	public Double getPrecio() {
		return Precio;
	}

	public void setPrecio(Double precio) {
		Precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [Nombre=" + Nombre + ", Categoria=" + Categoria + ", Cantidad=" + Cantidad + ", Precio="
				+ Precio + "]";
	}
	
	
	
}
