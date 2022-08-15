package com.proyectointegrador.juanbircher.Security.Controller;

public class Mensaje {
    private String mensaje;

    //constructores

    public Mensaje() {
    }

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    //getters y setter

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
