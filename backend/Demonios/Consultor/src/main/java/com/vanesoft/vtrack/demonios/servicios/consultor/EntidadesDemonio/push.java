package com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio;

/**
 * Created by Daniel jose on 11/04/2017.
 */
public class push {
    String to;
    notification notification;

    public push(String to, com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.notification notification) {
        this.to = to;
        this.notification = notification;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.notification getNotification() {
        return notification;
    }

    public void setNotification(com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.notification notification) {
        this.notification = notification;
    }
}
