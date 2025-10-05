package com.kodigo.principiosSOLID.modelos;

/**
 * Entidad Usuario.
 * SRP: Contiene datos del usuario.
 */
public class Usuario {
    private final String id;
    private String nombre;
    private String email;

    public Usuario(String id, String nombre, String email) {
        this.id = id; this.nombre = nombre; this.email = email;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return String.format("Usuario[id=%s, nombre=%s, email=%s]", id, nombre, email);
    }
}
