package com.kodigo.principiosSOLID.repositorios;

import com.kodigo.principiosSOLID.interfaces.TareaRepositorio;
import com.kodigo.principiosSOLID.modelos.Tarea;

import java.util.*;

/**
 * Implementación en memoria del repositorio de tareas.
 */
public class EnMemoriaTareaRepositorio implements TareaRepositorio {
    private final Map<String, Tarea> almacenamiento = new LinkedHashMap<>();
    private final GeneradorId generador;

    public EnMemoriaTareaRepositorio(GeneradorId generador) {
        this.generador = generador;
    }

    @Override
    public Tarea crear(String titulo, String descripcion) {
        String id = generador.siguiente();
        Tarea t = new Tarea(id, titulo, descripcion);
        almacenamiento.put(id, t);
        return t;
    }

    @Override
    public Optional<Tarea> obtenerPorId(String id) {
        return Optional.ofNullable(almacenamiento.get(id));
    }

    @Override
    public List<Tarea> obtenerTodas() {
        return new ArrayList<>(almacenamiento.values());
    }

    @Override
    public void actualizar(Tarea tarea) {
        almacenamiento.put(tarea.getId(), tarea);
    }

    @Override
    public void eliminar(String id) {
        almacenamiento.remove(id);
    }
}
