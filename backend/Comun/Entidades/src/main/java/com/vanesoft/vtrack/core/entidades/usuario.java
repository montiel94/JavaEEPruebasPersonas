package com.vanesoft.vtrack.core.entidades;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Created by Daniel jose on 03/02/2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class usuario extends EntidadBase{

    public String username;
    public String password;
    public int intentosLogin;
    public String estadoUsuario;
    public String nombreempresa;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIntentosLogin() {
        return intentosLogin;
    }

    public void setIntentosLogin(int intentosLogin) {
        this.intentosLogin = intentosLogin;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getNombreempresa() {
        return nombreempresa;
    }

    public void setNombreempresa(String nombreempresa) {
        this.nombreempresa = nombreempresa;
    }
}