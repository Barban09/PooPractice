package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Mascota {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int num_cliente;
	
	
	private String nombre;
	private String raza;
	private String color;
	private String alergico;
	private String atencion_especial;
	private String observaciones;
	
	@OneToOne
	private Duenio duenio;

	public Mascota() {
		System.out.println("Llamo al constructor vacio");
	}
	
	
	public Mascota(String nombre, String raza, String color, String alergico, String atencion_especial,
			String observaciones, Duenio duenio) {
		this.nombre = nombre;
		this.raza = raza;
		this.color = color;
		this.alergico = alergico;
		this.atencion_especial = atencion_especial;
		this.observaciones = observaciones;
		this.duenio = duenio;
	}


	public int getNum_cliente() {
		return num_cliente;
	}


	public void setNum_cliente(int num_cliente) {
		this.num_cliente = num_cliente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getRaza() {
		return raza;
	}


	public void setRaza(String raza) {
		this.raza = raza;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getAlergico() {
		return alergico;
	}


	public void setAlergico(String alergico) {
		this.alergico = alergico;
	}


	public String getAtencion_especial() {
		return atencion_especial;
	}


	public void setAtencion_especial(String atencion_especial) {
		this.atencion_especial = atencion_especial;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public Duenio getDuenio() {
		return duenio;
	}


	public void setDuenio(Duenio duenio) {
		this.duenio = duenio;
	}


	@Override
	public String toString() {
		return "Mascota [num_cliente=" + num_cliente + ", nombre=" + nombre + ", raza=" + raza + ", color=" + color
				+ ", alergico=" + alergico + ", atencion_especial=" + atencion_especial + ", observaciones="
				+ observaciones + ", duenio=" + duenio + "]";
	}
	
	
	
	
	
}
