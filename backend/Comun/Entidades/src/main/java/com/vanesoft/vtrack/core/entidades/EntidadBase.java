package com.vanesoft.vtrack.core.entidades;

import java.io.Serializable;

/**
 * Created by Daniel jose on 03/02/2017.
 */
public class EntidadBase implements Serializable{
    //region atributos
    protected int id;
    //end region atributos
    /*
     * Nombre:                  getId
     * Descripcion:             getter del id
     *
     * @return el id de la entidad
     *
     * @version 1.0
     * @author montda
     * @since 03/02/2017
     */
    public long getId(){
        return this.id;
    }

    /**
     * Nombre:                  setId
     * Descripcion:             setter del id
     *
     * @param valor id de la entidad
     *
     * @version 1.0
     * @author montda
     * @since 03/02/2017
     */
    public void setId( int valor )
    {
        this.id = valor;
    }

}
