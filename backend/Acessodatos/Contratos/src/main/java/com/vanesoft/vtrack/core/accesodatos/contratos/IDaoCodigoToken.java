package com.vanesoft.vtrack.core.accesodatos.contratos;
import com.vanesoft.vtrack.core.entidades.CodigoToken;
/**
 * Sistema:             Vtrack
 * Nombre:              IDaoCodigoToken
 * Descripcion:         Contrato del dao dedicado a las operaciones con codigos de autorizacion y tokens
 *
 * @author montda
 * @version 1.0
 * @since 04/02/2017
 */
public interface IDaoCodigoToken {
    /**
     * Descripcion: metodo que guarda en bd un codigo token
     *
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */
    public boolean guardarCodigoToken(CodigoToken codigo);
}
