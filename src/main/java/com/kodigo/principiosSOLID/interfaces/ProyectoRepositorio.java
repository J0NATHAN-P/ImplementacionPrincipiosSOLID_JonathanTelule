package com.kodigo.principiosSOLID.interfaces;

import com.kodigo.principiosSOLID.modelos.Proyecto;
import java.util.Optional;
import java.util.List;

public interface ProyectoRepositorio {
    Proyecto guardar(Proyecto proyecto);
    Optional<Proyecto> buscarPorId(String id);
    List<Proyecto> buscarTodos();
    void eliminar(String id);
}
