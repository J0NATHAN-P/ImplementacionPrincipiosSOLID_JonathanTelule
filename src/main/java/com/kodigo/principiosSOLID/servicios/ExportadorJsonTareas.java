package com.kodigo.principiosSOLID.servicios;

import com.kodigo.principiosSOLID.interfaces.ExportadorTareas;
import com.kodigo.principiosSOLID.modelos.Tarea;

import java.util.List;

/**
 * Exportador JSON simple.
 * Open/Closed: se pueden agregar otros exportadores sin cambiar servicios.
 */
public class ExportadorJsonTareas implements ExportadorTareas {
    @Override
    public String exportar(List<Tarea> tareas) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (Tarea t : tareas) {
            sb.append(String.format("  {\\\"id\\\":\\\"%s\\\", \\\"titulo\\\":\\\"%s\\\", \\\"estado\\\":\\\"%s\\\"},\n",
                    t.getId(), t.getTitulo(), t.getEstado()));
        }
        sb.append("\n]"); 
        return sb.toString();
    }
}
