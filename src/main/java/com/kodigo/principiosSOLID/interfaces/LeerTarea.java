package com.kodigo.principiosSOLID.interfaces;

import com.kodigo.principiosSOLID.modelos.Tarea;
import java.util.List;
import java.util.Optional;

public interface LeerTarea {
    Optional<Tarea> obtenerPorId(String id);
    List<Tarea> obtenerTodas();
}
