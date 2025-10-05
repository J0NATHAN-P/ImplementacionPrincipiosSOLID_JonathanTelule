package com.kodigo.principiosSOLID.repositorios;

import com.kodigo.principiosSOLID.interfaces.UsuarioRepositorio;
import com.kodigo.principiosSOLID.modelos.Usuario;

import java.util.*;

/**
 * Implementación en memoria del repositorio de usuarios.
 */
public class EnMemoriaUsuarioRepositorio implements UsuarioRepositorio {
    private final Map<String, Usuario> almacenamiento = new LinkedHashMap<>();
    private final GeneradorId generador;

    public EnMemoriaUsuarioRepositorio(GeneradorId generador) {
        this.generador = generador;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        almacenamiento.put(usuario.getId(), usuario);
        return usuario;
    }

    @Override
    public Optional<Usuario> buscarPorId(String id) {
        return Optional.ofNullable(almacenamiento.get(id));
    }

    @Override
    public List<Usuario> buscarTodos() {
        return new ArrayList<>(almacenamiento.values());
    }

    // Método auxiliar para crear usuario con ID generado
    public Usuario crear(String nombre, String email) {
        String id = generador.siguiente();
        Usuario u = new Usuario(id, nombre, email);
        almacenamiento.put(id, u);
        return u;
    }
}
