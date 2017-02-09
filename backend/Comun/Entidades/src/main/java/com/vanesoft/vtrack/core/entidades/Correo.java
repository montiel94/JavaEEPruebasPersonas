package com.vanesoft.vtrack.core.entidades;

/**
 * Sistema:             Vtrack
 * Nombre:              Correo
 * Descripcion:         Contiene la información de un correo a ser enviado
 *
 * @author montda
 * @version 1.0
 * @since 09/02/2017
 */
public class Correo {

    //reegion atributos
    String user;
    String to;
    String userPassword;
    String asunto;
    String mensaje;
    //end region

    //Constructor

    public Correo(String user, String to, String userPassword, String asunto, String mensaje) {
        this.user = user;
        this.to = to;
        this.userPassword = userPassword;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
