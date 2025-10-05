package com.kodigo.principiosSOLID.ui;

import com.kodigo.principiosSOLID.modelos.*;
import com.kodigo.principiosSOLID.repositorios.*;
import com.kodigo.principiosSOLID.servicios.*;

import java.util.List;
import java.util.Scanner;

/**
 * Interfaz de consola en español.
 * Inyección manual de dependencias y uso de generador de IDs numéricos.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        GeneradorId generador = new GeneradorId();
        EnMemoriaTareaRepositorio tareaRepo = new EnMemoriaTareaRepositorio(generador);
        EnMemoriaUsuarioRepositorio usuarioRepo = new EnMemoriaUsuarioRepositorio(generador);
        EnMemoriaProyectoRepositorio proyectoRepo = new EnMemoriaProyectoRepositorio(generador);

        TareaServicio tareaServicio = new TareaServicio(tareaRepo, usuarioRepo, proyectoRepo);
        UsuarioServicio usuarioServicio = new UsuarioServicio(usuarioRepo);
        ProyectoServicio proyectoServicio = new ProyectoServicio(proyectoRepo);
        ExportadorJsonTareas exportador = new ExportadorJsonTareas();

        // Datos iniciales
        Usuario u1 = usuarioRepo.crear("Alice", "alice@example.com");
        Usuario u2 = usuarioRepo.crear("Bob", "bob@example.com");
        Proyecto p1 = proyectoRepo.crear("Proyecto Alfa");
        Proyecto p2 = proyectoRepo.crear("Proyecto Beta");

        boolean ejecutando = true;
        while (ejecutando) {
            imprimirMenu();
            String opcion = scanner.nextLine().trim();
            switch (opcion) {
                case "1": crearTarea(tareaServicio); break;
                case "2": listarTareas(tareaServicio); break;
                case "3": asignarTareaAUsuario(tareaServicio); break;
                case "4": asignarTareaAProyecto(tareaServicio); break;
                case "5": exportarTareas(tareaServicio, exportador); break;
                case "6": crearUsuario(usuarioRepo); break;
                case "7": listarUsuarios(usuarioRepo); break;
                case "8": crearProyecto(proyectoRepo); break;
                case "9": listarProyectos(proyectoRepo); break;
                case "0": ejecutando = false; break;
                default: System.out.println("Opción inválida."); break;
            }
        }
        System.out.println("Saliendo..."); 
    }

    private static void imprimirMenu() {
        System.out.println("--- Gestor de Tareas (SOLID) ---");
        System.out.println("1) Crear tarea");
        System.out.println("2) Listar tareas");
        System.out.println("3) Asignar tarea a usuario");
        System.out.println("4) Asignar tarea a proyecto");
        System.out.println("5) Exportar tareas (JSON)");
        System.out.println("6) Crear usuario");
        System.out.println("7) Listar usuarios");
        System.out.println("8) Crear proyecto");
        System.out.println("9) Listar proyectos");
        System.out.println("0) Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void crearTarea(TareaServicio servicio) {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Descripción: ");
        String desc = scanner.nextLine();
        var t = servicio.crearTarea(titulo, desc);
        System.out.println("Tarea creada con id: " + t.getId());
    }

    private static void listarTareas(TareaServicio servicio) {
        List<Tarea> tareas = servicio.listarTareas();
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas."); return;
        }
        tareas.forEach(t -> System.out.println(t));
    }

    private static void asignarTareaAUsuario(TareaServicio servicio) {
        System.out.print("ID de tarea: "); String tid = scanner.nextLine();
        System.out.print("ID de usuario: "); String uid = scanner.nextLine();
        try {
            servicio.asignarAUsuario(tid, uid);
            System.out.println("Tarea asignada al usuario."); 
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void asignarTareaAProyecto(TareaServicio servicio) {
        System.out.print("ID de tarea: "); String tid = scanner.nextLine();
        System.out.print("ID de proyecto: "); String pid = scanner.nextLine();
        try {
            servicio.asignarAProyecto(tid, pid);
            System.out.println("Tarea asignada al proyecto."); 
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void exportarTareas(TareaServicio servicio, ExportadorJsonTareas exportador) {
        String out = servicio.exportarTareas(exportador);
        System.out.println(out);
    }

    private static void crearUsuario(EnMemoriaUsuarioRepositorio repo) {
        System.out.print("Nombre: "); String nombre = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();
        var u = repo.crear(nombre, email);
        System.out.println("Usuario creado con id: " + u.getId());
    }

    private static void listarUsuarios(EnMemoriaUsuarioRepositorio repo) {
        var usuarios = repo.buscarTodos();
        if (usuarios.isEmpty()) { System.out.println("No hay usuarios."); return; }
        usuarios.forEach(u -> System.out.println(u));
    }

    private static void crearProyecto(EnMemoriaProyectoRepositorio repo) {
        System.out.print("Nombre del proyecto: "); String nombre = scanner.nextLine();
        var p = repo.crear(nombre);
        System.out.println("Proyecto creado con id: " + p.getId());
    }

    private static void listarProyectos(EnMemoriaProyectoRepositorio repo) {
        var proyectos = repo.buscarTodos();
        if (proyectos.isEmpty()) { System.out.println("No hay proyectos."); return; }
        proyectos.forEach(p -> System.out.println(p));
    }
}
