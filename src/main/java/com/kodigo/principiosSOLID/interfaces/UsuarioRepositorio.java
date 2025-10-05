package com.kodigo.principiosSOLID.interfaces;

import com.kodigo.principiosSOLID.modelos.Usuario;
import java.util.Optional;
import java.util.List;

public interface UsuarioRepositorio {
    Usuario guardar(Usuario usuario);
    Optional<Usuario> buscarPorId(String id);
    List<Usuario> buscarTodos();
}
