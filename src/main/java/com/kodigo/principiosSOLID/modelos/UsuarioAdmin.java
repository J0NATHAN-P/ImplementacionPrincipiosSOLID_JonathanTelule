package com.kodigo.principiosSOLID.modelos;

/**
 * UsuarioAdmin extiende Usuario para mostrar Liskov: puede sustituir a Usuario.
 */
public class UsuarioAdmin extends Usuario {
    public UsuarioAdmin(String id, String nombre, String email) {
        super(id, nombre, email);
    }

    // Comportamientos extra de admin podrían agregarse
}
