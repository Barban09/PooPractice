package ProgramacionFuncional;

public class Ventas {
	private String Marca;
	private String Modelo;
	private int Precio;
	
	public Ventas(String marca, String modelo, int precio) {
		Marca = marca;
		Modelo = modelo;
		Precio = precio;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public int getPrecio() {
		return Precio;
	}

	public void setPrecio(int precio) {
		Precio = precio;
	}

	@Override
	public String toString() {
		return "Ventas [Marca=" + Marca + ", Modelo=" + Modelo + ", Precio=" + Precio + "]";
	}
	
	
	
	
	
}
