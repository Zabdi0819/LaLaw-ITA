package com.example.law_ita;

public class abogado {

    private String nombre, telefono, email, domicilio, especialidades;

    public abogado() {
    }

    public abogado(String nombre, String telefono, String email, String domicilio, String especialidades) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.domicilio = domicilio;
        this.especialidades = especialidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(String especialidades) {
        this.especialidades = especialidades;
    }
}
