package com.jpapractice.jpapractice;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.jpapractice.jpapractice.logica.Alumno;
import com.jpapractice.jpapractice.logica.Carrera;
import com.jpapractice.jpapractice.logica.Controladora;
import com.jpapractice.jpapractice.logica.Materia;
import com.jpapractice.jpapractice.persistencia.AlumnoJPAController;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App{
    public static void main( String[] args ){
    	
    	Controladora Crtl = new Controladora();
    	
    	
    	
    	
    	/*Materia mate1 = new Materia("Diseño 1","Semestreal");
    	Materia mate2 = new Materia("Diseño 2","Cuatrimestral");
    	Crtl.crearMateria(mate1);
    	Crtl.crearMateria(mate2);*/
    	
    	Carrera IngElect = Crtl.traerCarrera(9702);
    	Materia Mat1 = Crtl.traerMateria(1754);
    	
    	List<Materia> MatesIngElect = new ArrayList<Materia>();	
    	Mat1.setCarre(IngElect);
    	
    	try {
			Crtl.editarMateria(Mat1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo actualizar materia");
		}
    	
    	
    	
	    try {	
	    	H2Admin.connect();  	
	    } catch (SQLException e) {
	    	System.out.println(e.getMessage());
	    }
	    
	    //Alumno al3 = new Alumno("Hola","Ser",new Date(),carre1);
	    //Crtl.crearAlumno(al3);
	    
	     
    }
    
}
