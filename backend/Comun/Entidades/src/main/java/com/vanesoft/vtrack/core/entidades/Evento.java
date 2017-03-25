package com.vanesoft.vtrack.core.entidades;

/**
 * Created by Daniel jose on 17/03/2017.
 */
public class Evento {

    String tiempo;
    String mensaje;
    int id;

    public Evento(String tiempo, String mensaje, int id) {
        this.tiempo = tiempo;
        this.mensaje = mensaje;
        this.id = id;
    }

    public String getTiempo() {
        return tiempo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getId() {
        return id;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setId(int id) {
        this.id = id;
    }
}
