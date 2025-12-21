package logica;

import java.util.List;

import persistencia.ControladoraPersistencia;

public class Controladora {
	
	ControladoraPersistencia ControladoraPers = new ControladoraPersistencia();
	
	
//--------------------------------------- Metodos Mascota ---------------------------------------	
	public void crearMascota (Mascota mascota) {
		ControladoraPers.crearMascota(mascota);
	}
	
	public void eliminarMascota(int id) {
		ControladoraPers.eliminarMascota(id);
	}
	
	public Mascota traerMascota(int id) {
		return ControladoraPers.traerMascota(id);
	}
	
	public List<Mascota> traerTodasLasMascotas(){
		return ControladoraPers.traerTodasLasMascotas();
	}
	
//--------------------------------------- Metodos Duenio ---------------------------------------	
	public void crearDuenio (Duenio dueno) {
		ControladoraPers.crearDuenio(dueno);
	}		
	
	public void eliminarDuenio (int id) {
		ControladoraPers.eliminarDuenio(id);
	}
	
	public void editarDuenio(Duenio dueno) {
		ControladoraPers.editarDuenio(dueno);
	}
	
	public Duenio traerDuenio(int id) {
		return ControladoraPers.traerDuenio(id);
	}
	
	public List<Duenio> traerTodasLosDuenios(){
		return ControladoraPers.traerTodasLosDuenios();
	}
	
//--------------------------------------- Metodos Duenio ---------------------------------------	
	public void guardar(String NombeMasco, String Raza, String Color, String NombDuenio, String CelDuenio, String Observaciones, String alergico, String AtenEsp) {
		
		Duenio dueno = new Duenio();
		dueno.setNombre(NombDuenio);
		dueno.setCelDuenio(CelDuenio);
		System.out.println(dueno.toString());
		Mascota masco = new Mascota(NombeMasco, Raza, Color, alergico, AtenEsp, Observaciones, dueno);
		System.out.println(masco.toString());
		ControladoraPers.guardar(dueno, masco);
		
		
	}

	public void EditarMascota(Mascota mascoAEdit, String nombreMasco, String raza, String color, String alergico,
			String atencion_especial, String observaciones, String celDuenio, String nombDuenio) {
		mascoAEdit.setNombre(nombreMasco);
		mascoAEdit.setRaza(raza);
		mascoAEdit.setColor(color);
		mascoAEdit.setAlergico(alergico);
		mascoAEdit.setAtencion_especial(atencion_especial);
		mascoAEdit.setObservaciones(observaciones);
		
		Duenio duenioaEDit = mascoAEdit.getDuenio();
		duenioaEDit.setNombre(nombDuenio);
		duenioaEDit.setCelDuenio(celDuenio);
		ControladoraPers.editar(duenioaEDit, mascoAEdit);
		
		
		
		
	}
	
}
