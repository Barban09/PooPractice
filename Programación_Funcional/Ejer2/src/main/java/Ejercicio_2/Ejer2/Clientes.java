package Ejercicio_2.Ejer2;

public class Clientes {
	private Integer nro_cliente;
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	
	public Clientes(Integer nro_cliente, String nombre, String apellido, String direccion, String telefono) {
		this.nro_cliente = nro_cliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	public Integer getNro_cliente() {
		return nro_cliente;
	}
	public void setNro_cliente(Integer nro_cliente) {
		this.nro_cliente = nro_cliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		return "Clientes [nro_cliente=" + nro_cliente + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion="
				+ direccion + ", telefono=" + telefono + "]";
	}
	
	
	
	
	
	
}
