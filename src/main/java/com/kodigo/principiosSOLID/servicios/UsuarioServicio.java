package com.kodigo.principiosSOLID.servicios;

import com.kodigo.principiosSOLID.interfaces.UsuarioRepositorio;
import com.kodigo.principiosSOLID.modelos.Usuario;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para usuarios.
 */
public class UsuarioServicio {
    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public Usuario crearUsuarioConId(String id, String nombre, String email) {
        Usuario u = new Usuario(id, nombre, email);
        return usuarioRepositorio.guardar(u);
    }

    public Usuario crearUsuario(String nombre, String email) {
        // algunos repositorios ofrecen método crear con ID generado (si es EnMemoriaUsuarioRepositorio)
        // pero dejamos esta abstracción simple: el repositorio se encarga del id en la UI.
        Usuario u = new Usuario(idGenerico(), nombre, email);
        return usuarioRepositorio.guardar(u);
    }

    private String idGenerico() {
        // método auxiliar si hace falta generar id desde servicio (no usado en UI).
        return String.valueOf(System.currentTimeMillis());
    }

    public Optional<Usuario> obtenerUsuario(String id) { return usuarioRepositorio.buscarPorId(id); }
    public List<Usuario> listarUsuarios() { return usuarioRepositorio.buscarTodos(); }
}
