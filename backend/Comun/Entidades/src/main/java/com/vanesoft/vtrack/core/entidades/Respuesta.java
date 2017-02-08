package com.vanesoft.vtrack.core.entidades;

import java.io.Serializable;

/**
 * Sistema:             Vtrack
 * Nombre:              Respuesta
 * Descripcion:         Contiene la informacion a responder de los servicios REST
 *
 * @author montda
 * @version 1.0
 * @since 03/02/2017
 */
public class Respuesta implements Serializable{
    // mensaje a ser entregado
    private String mensaje;
    // get y set
    public Respuesta( String mensaje )
    {
        this.mensaje = mensaje;
    }

    public Respuesta( )
    {
        this.mensaje = "";
    }

    public String getMensaje( )
    {
        return mensaje;
    }

    public void setMensaje( String mensaje )
    {
        this.mensaje = mensaje;
    }

}
