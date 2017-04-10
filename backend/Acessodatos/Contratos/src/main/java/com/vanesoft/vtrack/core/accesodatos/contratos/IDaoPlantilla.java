package com.vanesoft.vtrack.core.accesodatos.contratos;

import com.vanesoft.vtrack.core.entidades.Plantilla;

/**
 * Sistema:             Vtrack
 * Nombre:              IDaoPlantilla
 * Descripcion:         Contrato del dao dedicado a las operaciones con las plantillas
 *
 * @author montda
 * @version 1.0
 * @since 04/02/2017
 */
public interface IDaoPlantilla {
    /**
     * Descripcion: metodo que consulta una plantilla segun su nombre
     *
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */

    public Plantilla consultarPlantilla(String nombre);
}
