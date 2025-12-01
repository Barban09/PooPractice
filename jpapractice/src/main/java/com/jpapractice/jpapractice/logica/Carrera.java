package com.jpapractice.jpapractice.logica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Carrera {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Basic
	private String nombre;

	@OneToMany(mappedBy="carre")
	private List<Materia> listaMaterias = new ArrayList<>();
	
	public Carrera() {}
	
	public Carrera(String nombre, List<Materia> listaMaterias) {
		this.nombre = nombre;
		this.listaMaterias = listaMaterias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Materia> getListaMaterias() {
		return listaMaterias;
	}

	public void setListaMaterias(List<Materia> listaMaterias) {
		this.listaMaterias = listaMaterias;
	}
	
	
	
	
	
	
	
}
