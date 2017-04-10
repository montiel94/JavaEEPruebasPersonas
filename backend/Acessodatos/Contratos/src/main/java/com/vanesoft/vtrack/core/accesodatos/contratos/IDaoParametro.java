package com.vanesoft.vtrack.core.accesodatos.contratos;

import java.util.ArrayList;

/**
 * Sistema:             Vtrack
 * Nombre:              IDaoParametro
 * Descripcion:         Contrato del dao dedicado a los parametros de un correo
 *
 * @author montda
 * @version 1.0
 * @since 04/02/2017
 */
public interface IDaoParametro {

    /**
     * Descripcion: metodo que consulta los parametros de una plantilla
     *
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */

    public ArrayList<String> consultarParametrosXPlantilla(String nombrePlantilla);
}
