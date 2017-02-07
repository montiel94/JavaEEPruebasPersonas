package com.vanesoft.vtrack.core.entidades;

/**
 * Created by Daniel jose on 03/02/2017.
 */
public class usuario extends EntidadBase{

    public String username;
    public String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}