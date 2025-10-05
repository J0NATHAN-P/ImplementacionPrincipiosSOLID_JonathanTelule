package com.kodigo.principiosSOLID.servicios;

import com.kodigo.principiosSOLID.interfaces.ProyectoRepositorio;
import com.kodigo.principiosSOLID.modelos.Proyecto;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para proyectos.
 */
public class ProyectoServicio {
    private final ProyectoRepositorio proyectoRepositorio;

    public ProyectoServicio(ProyectoRepositorio proyectoRepositorio) {
        this.proyectoRepositorio = proyectoRepositorio;
    }

    public Proyecto crearProyecto(String nombre) {
        // si repositorio tiene crear con id generado, la UI lo usará
        Proyecto p = new Proyecto("0", nombre);
        return proyectoRepositorio.guardar(p);
    }

    public Optional<Proyecto> obtenerProyecto(String id) { return proyectoRepositorio.buscarPorId(id); }
    public List<Proyecto> listarProyectos() { return proyectoRepositorio.buscarTodos(); }
    public void eliminarProyecto(String id) { proyectoRepositorio.eliminar(id); }
}
