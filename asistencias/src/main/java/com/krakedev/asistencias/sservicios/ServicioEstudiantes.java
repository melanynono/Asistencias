package com.krakedev.asistencias.sservicios;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.entidades.Estudiante;

@Service
public class ServicioEstudiantes {
	
 private ArrayList<Estudiante> estudiantes = new ArrayList<>();

 public void agregar(Estudiante estudiante) {
	 
	 Estudiante encontrado = buscarPorCedula(estudiante.getCedula());
	
	 if(encontrado != null) {
		 estudiantes.add(estudiante);
	 } 
 }
 
 public Estudiante buscarPorCedula(String cedula) {
	 
	 for(Estudiante estudiante : estudiantes) {
		 
		 if(estudiante.getCedula().equals(cedula)) {
			 return estudiante;
		 }
	 }
	 return null;
 }
 
 public void eliminar(String cedula) {
	 
	 Estudiante encontrado = buscarPorCedula(cedula);
	 if(encontrado != null) {
		 estudiantes.remove(encontrado);
	 }

 }
 public void actualizar(String cedula, Estudiante nuevo) {
	 
	 Estudiante encontrado = buscarPorCedula(cedula);
	 
	 if(encontrado != null) {
		 encontrado.setNombre(nuevo.getNombre());
		 encontrado.setApellido(nuevo.getApellido());
	 }
	 
 }
 
 
 public ArrayList<Estudiante> listar() {
	 
return estudiantes;
 }
}

