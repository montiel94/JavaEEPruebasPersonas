package com.vanesoft.vtrack.core.accesodatos.contratos;

/**
 * Sistema:             Vtrack
 * Nombre:              IDaoSincronizacion
 * Descripcion:         Contrato del dao dedicado a las operaciones la sincronizacion de los servicios
 *
 * @author montda
 * @version 1.0
 * @since 04/02/2017
 */
public interface IDaoSincronizacion {
    /**
     * Descripcion: metodo que modificacion el tiempo de la ultima sincronizacion
     *
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */

    public boolean modificarSincronizacion(String tiempo);

    /**
     * Descripcion: metodo que consulta el tiempo d ela ultima sincronizacion
     *
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */
    public String consultarSincronizacion();

}
