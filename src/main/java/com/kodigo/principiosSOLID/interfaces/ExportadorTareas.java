package com.kodigo.principiosSOLID.interfaces;

import com.kodigo.principiosSOLID.modelos.Tarea;
import java.util.List;

public interface ExportadorTareas {
    String exportar(List<Tarea> tareas);
}
