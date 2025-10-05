package com.kodigo.principiosSOLID.servicios;

import com.kodigo.principiosSOLID.interfaces.*;
import com.kodigo.principiosSOLID.modelos.Tarea;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para operaciones sobre tareas.
 * DIP: depende de TareaRepositorio y UsuarioRepositorio y ProyectoRepositorio (abstracciones).
 */
public class TareaServicio implements AsignarTarea {
    private final TareaRepositorio tareaRepositorio;
    private final UsuarioRepositorio usuarioRepositorio;
    private final ProyectoRepositorio proyectoRepositorio;

    public TareaServicio(TareaRepositorio tareaRepositorio,
                         UsuarioRepositorio usuarioRepositorio,
                         ProyectoRepositorio proyectoRepositorio) {
        this.tareaRepositorio = tareaRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
        this.proyectoRepositorio = proyectoRepositorio;
    }

    public Tarea crearTarea(String titulo, String descripcion) {
        return tareaRepositorio.crear(titulo, descripcion);
    }

    public Optional<Tarea> obtenerTarea(String id) {
        return tareaRepositorio.obtenerPorId(id);
    }

    public List<Tarea> listarTareas() {
        return tareaRepositorio.obtenerTodas();
    }

    public void actualizarTarea(Tarea tarea) {
        tareaRepositorio.actualizar(tarea);
    }

    public void eliminarTarea(String id) {
        tareaRepositorio.eliminar(id);
    }

    @Override
    public void asignarAUsuario(String tareaId, String usuarioId) {
        Optional<Tarea> t = tareaRepositorio.obtenerPorId(tareaId);
        if (t.isPresent()) {
            if (usuarioRepositorio.buscarPorId(usuarioId).isPresent()) {
                t.get().asignarUsuario(usuarioId);
                tareaRepositorio.actualizar(t.get());
            } else {
                throw new IllegalArgumentException("Usuario no encontrado: " + usuarioId);
            }
        } else {
            throw new IllegalArgumentException("Tarea no encontrada: " + tareaId);
        }
    }

    @Override
    public void asignarAProyecto(String tareaId, String proyectoId) {
        Optional<Tarea> t = tareaRepositorio.obtenerPorId(tareaId);
        if (t.isPresent()) {
            if (proyectoRepositorio.buscarPorId(proyectoId).isPresent()) {
                t.get().asignarProyecto(proyectoId);
                tareaRepositorio.actualizar(t.get());
                // además actualizar la relación en el proyecto
                proyectoRepositorio.buscarPorId(proyectoId).ifPresent(p -> p.agregarTarea(tareaId));
                proyectoRepositorio.guardar(proyectoRepositorio.buscarPorId(proyectoId).get());
            } else {
                throw new IllegalArgumentException("Proyecto no encontrado: " + proyectoId);
            }
        } else {
            throw new IllegalArgumentException("Tarea no encontrada: " + tareaId);
        }
    }

    public String exportarTareas(ExportadorTareas exportador) {
        return exportador.exportar(tareaRepositorio.obtenerTodas());
    }
}
