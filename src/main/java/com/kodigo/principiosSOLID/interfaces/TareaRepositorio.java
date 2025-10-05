package com.kodigo.principiosSOLID.interfaces;

/**
 * Abstracción de almacenamiento de tareas.
 */
public interface TareaRepositorio extends CrearTarea, LeerTarea, ActualizarTarea {
    void eliminar(String id);
}
