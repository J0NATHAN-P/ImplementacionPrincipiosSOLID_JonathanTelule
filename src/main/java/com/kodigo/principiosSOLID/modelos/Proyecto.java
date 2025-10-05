package com.kodigo.principiosSOLID.modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Entidad Proyecto.
 * SRP: Maneja la relación con las tareas dentro del proyecto.
 */
public class Proyecto {
    private final String id;
    private String nombre;
    private final List<String> idsTareas = new ArrayList<>();

    public Proyecto(String id, String nombre) {
        this.id = id; this.nombre = nombre;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public void agregarTarea(String tareaId) { idsTareas.add(tareaId); }
    public void quitarTarea(String tareaId) { idsTareas.remove(tareaId); }
    public List<String> getIdsTareas() { return Collections.unmodifiableList(idsTareas); }

    @Override
    public String toString() {
        return String.format("Proyecto[id=%s, nombre=%s, tareas=%d]", id, nombre, idsTareas.size());
    }
}
