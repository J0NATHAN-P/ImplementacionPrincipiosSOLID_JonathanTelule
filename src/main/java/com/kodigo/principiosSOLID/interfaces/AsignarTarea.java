package com.kodigo.principiosSOLID.interfaces;

public interface AsignarTarea {
    void asignarAUsuario(String tareaId, String usuarioId);
    void asignarAProyecto(String tareaId, String proyectoId);
}
