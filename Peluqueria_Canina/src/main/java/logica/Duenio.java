 package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Duenio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	private int id_duenio;
	private String nombre;
	private String celDuenio;
	
	public Duenio(){
		
	}
	
	public Duenio(String nombre, String celDuenio) {
		this.nombre = nombre;
		this.celDuenio = celDuenio;
	}

	public int getId_duenio() {
		return id_duenio;
	}

	public void setId_duenio(int id_duenio) {
		this.id_duenio = id_duenio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCelDuenio() {
		return celDuenio;
	}

	public void setCelDuenio(String celDuenio) {
		this.celDuenio = celDuenio;
	}

	@Override
	public String toString() {
		return "Duenio [id_duenio=" + id_duenio + ", nombre=" + nombre + ", celDuenio=" + celDuenio + "]";
	}

	
	
	
	

}
