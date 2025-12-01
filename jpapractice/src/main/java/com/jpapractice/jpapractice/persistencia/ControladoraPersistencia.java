package com.jpapractice.jpapractice.persistencia;

import java.util.ArrayList;
import java.util.List;

import com.jpapractice.jpapractice.logica.Alumno;
import com.jpapractice.jpapractice.logica.Carrera;
import com.jpapractice.jpapractice.logica.Materia;


public class ControladoraPersistencia {
	
	AlumnoJPAController ControladoraAlumno = new AlumnoJPAController();
	CarreraJpaController ControladoraCarrera = new CarreraJpaController();
	MateriaJpaController ControladoraMateria = new MateriaJpaController();
	

	public void crearAlumno(Alumno alum) {
		ControladoraAlumno.create(alum);
		
	}

	public void eliminarAlumno(int id) {
		try {
			ControladoraAlumno.destroy(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void editarAlumno(Alumno alu) {
		try {
			ControladoraAlumno.edit(alu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Alumno traerAlumno(int id) {
		return ControladoraAlumno.findAlumno(id);
	}

	public ArrayList<Alumno> traerTodosAlumnos() {
		List<Alumno> lista = ControladoraAlumno.findAlumnoEntities();
		ArrayList<Alumno> listaAlumns = new ArrayList<Alumno> (lista);
		return listaAlumns;
	}
	
//---------------------------------Carrera---------------------------------
	public void crearCarrera(Carrera carrera) {
		ControladoraCarrera.create(carrera);
		
	}

	public void eliminarCarrera(int id) throws Exception {
		ControladoraCarrera.destroy(id);
		
	}

	public void editarCarrera(Carrera carrera) throws Exception {
		ControladoraCarrera.edit(carrera);
		
	}

	public Carrera traerCarrera(int id) {
		return ControladoraCarrera.findCarrera(id);
	}

	public ArrayList<Carrera> traerTodasLasCarreras() {
		List<Carrera> lista = ControladoraCarrera.findCarreraEntities();
		ArrayList<Carrera> listaCarreras = new ArrayList<Carrera> (lista);
		return listaCarreras;
	}	

	
//---------------------------------Materia---------------------------------	
	public void crearMateria(Materia mate) {
		ControladoraMateria.create(mate);
		
	}	

	public void eliminarMateria(int id) throws Exception {
		ControladoraMateria.destroy(id);
		
	}
	
	public void editarMateria(Materia mate) throws Exception {
		ControladoraMateria.edit(mate);
		
	}	
	
	public Materia traerMateria(int id) {
		return ControladoraMateria.findMateria(id);
	}	

	public ArrayList<Materia> traerTodasLasMaterias() {
		List<Materia> lista = ControladoraMateria.findMateriaEntities();
		ArrayList<Materia> listaMaterias = new ArrayList<Materia> (lista);
		return listaMaterias;
	}
	
	
	
}
