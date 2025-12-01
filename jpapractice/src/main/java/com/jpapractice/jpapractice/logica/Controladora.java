package com.jpapractice.jpapractice.logica;

import java.util.ArrayList;
import java.util.List;

import com.jpapractice.jpapractice.persistencia.ControladoraPersistencia;

public class Controladora {

	ControladoraPersistencia Control = new ControladoraPersistencia();
	
	public void crearAlumno(Alumno alum) {
		Control.crearAlumno(alum);
	}
	
	public void EliminarAlunmno(int id) throws Exception {
		Control.eliminarAlumno(id);
	}
	
	public void editarAlumno(Alumno alu) throws Exception {
		Control.editarAlumno(alu);
	}
	
	public Alumno traerAlumno(int id) {
		return Control.traerAlumno(id);
	}
	
	public ArrayList<Alumno> trearTodosLosAlumnos(){
		return Control.traerTodosAlumnos();
	}
	
	
//----------------------------------------------Metodos Carrera----------------------------------------------
	
	public void crearCarrera(Carrera carrera) {
		Control.crearCarrera(carrera);
	}	
	
	public void eliminarCarrera(int id) throws Exception {
		Control.eliminarCarrera(id);
	}
	
	public void editarCarrera(Carrera carrera) throws Exception {
		Control.editarCarrera(carrera);
	}
	
	public Carrera traerCarrera(int id) {
		return Control.traerCarrera(id);
	}
	
	public ArrayList<Carrera> trearTodasLasCarrera(){
		return Control.traerTodasLasCarreras();
	}

	//----------------------------------------------Metodos Materia----------------------------------------------
	public void crearMateria(Materia mate) {
		Control.crearMateria(mate);
	}		
	
	public void eliminarMateria(int id) throws Exception {
		Control.eliminarMateria(id);
	}
	
	public void editarMateria(Materia mate) throws Exception {
		Control.editarMateria(mate);
	}	
	
	public Materia traerMateria(int id) {
		return Control.traerMateria(id);
	}	

	public ArrayList<Materia> trearTodasLasMaterias(){
		return Control.traerTodasLasMaterias();
	}
	
	
}
