package com.kodigo.principiosSOLID.repositorios;

import com.kodigo.principiosSOLID.interfaces.ProyectoRepositorio;
import com.kodigo.principiosSOLID.modelos.Proyecto;

import java.util.*;

/**
 * Implementación en memoria del repositorio de proyectos.
 */
public class EnMemoriaProyectoRepositorio implements ProyectoRepositorio {
    private final Map<String, Proyecto> almacenamiento = new LinkedHashMap<>();
    private final GeneradorId generador;

    public EnMemoriaProyectoRepositorio(GeneradorId generador) {
        this.generador = generador;
    }

    @Override
    public Proyecto guardar(Proyecto proyecto) {
        almacenamiento.put(proyecto.getId(), proyecto);
        return proyecto;
    }

    @Override
    public Optional<Proyecto> buscarPorId(String id) {
        return Optional.ofNullable(almacenamiento.get(id));
    }

    @Override
    public List<Proyecto> buscarTodos() {
        return new ArrayList<>(almacenamiento.values());
    }

    @Override
    public void eliminar(String id) {
        almacenamiento.remove(id);
    }

    // Auxiliar para crear con ID generado
    public Proyecto crear(String nombre) {
        String id = generador.siguiente();
        Proyecto p = new Proyecto(id, nombre);
        almacenamiento.put(id, p);
        return p;
    }
}
