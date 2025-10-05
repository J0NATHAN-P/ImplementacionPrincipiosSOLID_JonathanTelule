package com.kodigo.principiosSOLID.modelos;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Entidad Tarea.
 * SRP: Contiene sólo atributos y comportamiento mínimo de la tarea.
 */
public class Tarea {
    public enum Estado { PENDIENTE, EN_PROGRESO, COMPLETADA }
    private final String id; // ID numérico en formato string
    private String titulo;
    private String descripcion;
    private Estado estado;
    private Optional<String> idUsuarioAsignado = Optional.empty();
    private Optional<String> idProyecto = Optional.empty();
    private final LocalDateTime creadoEn;

    public Tarea(String id, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = Estado.PENDIENTE;
        this.creadoEn = LocalDateTime.now();
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }
    public Optional<String> getIdUsuarioAsignado() { return idUsuarioAsignado; }
    public void asignarUsuario(String userId) { this.idUsuarioAsignado = Optional.ofNullable(userId); }
    public Optional<String> getIdProyecto() { return idProyecto; }
    public void asignarProyecto(String proyectoId) { this.idProyecto = Optional.ofNullable(proyectoId); }
    public LocalDateTime getCreadoEn() { return creadoEn; }

    @Override
    public String toString() {
        return String.format("Tarea[id=%s, titulo=%s, estado=%s, usuario=%s, proyecto=%s]",
                id, titulo, estado, idUsuarioAsignado.orElse("ninguno"), idProyecto.orElse("ninguno"));
    }
}
