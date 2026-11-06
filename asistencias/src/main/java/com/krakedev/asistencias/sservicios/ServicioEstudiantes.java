package com.krakedev.asistencias.sservicios;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.entidades.Estudiante;

@Service
public class ServicioEstudiantes {

    private ArrayList<Estudiante> estudiantes = new ArrayList<>();

    public Estudiante agregar(Estudiante estudiante) {

        Estudiante encontrado = buscarPorCedula(estudiante.getCedula());

        if (encontrado == null) {
            estudiantes.add(estudiante);
            return estudiante;
        }

        return null;
    }

    public Estudiante buscarPorCedula(String cedula) {

        for (Estudiante estudiante : estudiantes) {

            if (estudiante.getCedula().equals(cedula)) {
                return estudiante;
            }
        }

        return null;
    }

    public boolean eliminar(String cedula) {

        Estudiante encontrado = buscarPorCedula(cedula);

        if (encontrado != null) {
            estudiantes.remove(encontrado);
            return true;
        }

        return false;
    }

    public Estudiante actualizar(String cedula, Estudiante nuevo) {

        Estudiante encontrado = buscarPorCedula(cedula);

        if (encontrado != null) {

            encontrado.setNombre(nuevo.getNombre());
            encontrado.setApellido(nuevo.getApellido());

            return encontrado;
        }

        return null;
    }

    public ArrayList<Estudiante> listar() {

        return estudiantes;
    }
}