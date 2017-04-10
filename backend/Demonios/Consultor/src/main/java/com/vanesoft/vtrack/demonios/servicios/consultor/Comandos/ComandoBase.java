package com.vanesoft.vtrack.demonios.servicios.consultor.Comandos;

/**
 * Created by Daniel jose on 06/02/2017.
 */
public abstract class ComandoBase<T> {

    /**
     * Nombre:                  ejecutar
     * Descripcion:             Metodo encargado de ejecutar el comando
     *
     * @return T - el resultado de la ejecucion
     * @version 1.0
     * @author montda
     * @since 06/2/17
     */
    public abstract T ejecutar();
}
