package com.vanesoft.vtrack.core.enumerados;

/**
 *
 * Sistema:                 Vtrack
 * Siglas:                  VT
 *
 * Nombre:                  EstadoUsuario
 * Descripcion:             Enumerado que indica los estados de un usuario
 * @version                 1.0
 * @author                  Daniel Montiel
 * @since                   07/02/2017
 *
 */
public enum EstadoUsuario {

    ACTIVO ("Usuario activo en Vtrack"),
    BLOQUEADO("Usuario bloqueado por fallar 3 intentos de login");

    EstadoUsuario( String texto ) {
        this.text = texto;
    }

    private final String text;

    @Override
    public String toString()
    {
        return text;
    }
}
