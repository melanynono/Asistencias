package com.krakedev.asistencias.sservicios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.entidades.Asistencia;
import com.krakedev.asistencias.entidades.Estudiante;
import com.krakedev.asistencias.entidades.RegistroAsistencia;

@Service
public class ServicioAsistencia {
	private ArrayList<RegistroAsistencia> registros = new ArrayList<>();
	private final ServicioEstudiantes servicioEstudiantes;

	public ServicioAsistencia(ServicioEstudiantes servicioEstudiantes) {
		this.servicioEstudiantes = servicioEstudiantes;
	}

	public RegistroAsistencia registrarAsistencia(String cedula) {

//Buscar estudiante por cedula, en servicioEstudiantes
		Estudiante estudiante = servicioEstudiantes.buscarPorCedula(cedula);

// si no existe el estudiante retorna null

		if (estudiante == null) {
			return null;
		}

//crea la asistencia, con la fecha y hora actuales
		Asistencia asistencia = new Asistencia(LocalDate.now(), LocalDateTime.now(), "P");

		
		RegistroAsistencia registro = new RegistroAsistencia(estudiante, asistencia);

		registros.add(registro);
		return registro;

	}

	public ArrayList<Asistencia> consultarAsistencia(String cedula) {
		// retorna todas las asistencias del estudiante
		
		ArrayList<Asistencia> asistencias = new ArrayList<>();
		
		for(RegistroAsistencia registro : registros) {
			
			if(registro.getAsistencia().equals(cedula)) {
				asistencias.add(registro.getAsistencia());
			}
		}
		return asistencias;
	}
}
