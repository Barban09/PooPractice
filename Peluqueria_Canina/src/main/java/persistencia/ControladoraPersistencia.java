package persistencia;

import java.util.List;

import logica.Duenio;
import logica.Mascota;

public class ControladoraPersistencia {

	MascotaJPAController ControladoraMascota = new MascotaJPAController();
	DuenioJPAController ControladoraDuenio = new DuenioJPAController();
	
//--------------------------------------- Metodos Mascota ---------------------------------------
	public void crearMascota (Mascota mascota) {
		ControladoraMascota.create(mascota);
	}
	
	public void eliminarMascota (int id) {
		try {
			ControladoraMascota.destroy(id);
		} catch (Exception e) {
			System.out.println("No fue posible eliminar a la mascota con id: " + id);
		}
	}
	
	public void editarMascota(Mascota mascota) {
		try {
			ControladoraMascota.edit(mascota);
		} catch (Exception e) {

			System.out.println("No fue posible editar a la mascota con id: " + mascota.toString());
		}
	}
	
	public Mascota traerMascota(int id) {
		return ControladoraMascota.findMascota(id);
	}
	
	public List<Mascota> traerTodasLasMascotas(){
		return ControladoraMascota.findMascotaEntities();
	}
	

	//--------------------------------------- Metodos Duenio ---------------------------------------	
	public void crearDuenio (Duenio dueno) {
		ControladoraDuenio.create(dueno);
	}	
	
	public void eliminarDuenio (int id) {
		try {
			ControladoraDuenio.destroy(id);
		} catch (Exception e) {
			System.out.println("No fue posible eliminar al duenio con id: " + id);
		}
	}
	
	public void editarDuenio(Duenio dueno) {
		try {
			ControladoraDuenio.edit(dueno);
		} catch (Exception e) {
			System.out.println("No fue posible editar el dueño: " + dueno.toString());
		}
	}
	
	public Duenio traerDuenio(int id) {
		return ControladoraDuenio.findDuenio(id);
	}
	
	public List<Duenio> traerTodasLosDuenios(){
		return ControladoraDuenio.findDuenioEntities();
	}
	
	//--------------------------------------- Metodos Duenio ---------------------------------------
	public void guardar(Duenio dueno, Mascota masco) {
		
		crearDuenio(dueno);
		crearMascota(masco);
		
	}

	public void editar(Duenio duenioaEDit, Mascota mascoAEdit) {
		editarDuenio(duenioaEDit);
		editarMascota(mascoAEdit);
		
	}		
	
	
	
}
