package com.vanesoft.vtrack.core.accesodatos.contratos;
import com.vanesoft.vtrack.core.entidades.CodigoToken;
import com.vanesoft.vtrack.core.entidades.usuario;

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
    public boolean guardarCodigoToken(CodigoToken codigo, usuario user);
    /**
     * Descripcion: metodo que modifica el valor de un token dado
     *
     * @version 1.0
     * @author montda
     * @since 06/03/2017
     */
    public boolean modificarValorToken (String nuevoValor, CodigoToken token);
    /**
     * Descripcion: metodo que modifica el tipo de un token dado
     *
     * @version 1.0
     * @author montda
     * @since 06/03/2017
     */
    public boolean modificarTipoToken (CodigoToken token);
    /**
     * Descripcion: metodo que consulta un token dado su valor
     *
     * @version 1.0
     * @author montda
     * @since 06/03/2017
     */
    public CodigoToken ConsultarCodigoAuthXValor (CodigoToken codigoAuth);
    /**
     * Descripcion: metodo que consulta si un usuario posee un token registrado en ele sistema
     *
     * @version 1.0
     * @author montda
     * @since 06/03/2017
     */
    public CodigoToken ConsultaUsuarioPoseeToken(usuario usuarioEnBd);

    /**
     * Descripcion: metodo que elimina un token en el sistema
     *
     * @version 1.0
     * @author montda
     * @since 06/03/2017
     */
    public boolean eliminarToken(String codigoToken);
}
