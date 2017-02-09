package com.vanesoft.vtrack.core.accesodatos.contratos;
import com.vanesoft.vtrack.core.entidades.usuario;

/**
 * Sistema:             Vtrack
 * Nombre:              IDaoUsuario
 * Descripcion:         Contrato del dao dedicado a las operaciones con usuario
 *
 * @author montda
 * @version 1.0
 * @since 04/02/2017
 */
public interface IDaoUsuario {

    /**
     * Descripcion: metodo que busca usuario en base de datos registrado con
     * un correo
     *
     * @version 1.0
     * @author montda
     * @since 06/02/2017
     */
    public usuario buscarUsuarioXCorreoElectronico(String Correo);
    /**
     * Descripcion: metodo que aumenta un intento de login a un usuario
     * un correo
     *
     * @version 1.0
     * @author montda
     * @since 06/02/2017
     */
    public Boolean aumentarNumeroIntentosLogin (usuario usuarioEnBd);
    /**
     * Descripcion: metodo que consulta numero de intentos de login de un usuario
     * un correo
     *
     * @version 1.0
     * @author montda
     * @since 06/02/2017
     */
    public usuario ConsultarNumeroIntentosLoginUsuario (usuario usuarioEnBd);
    /**
     * Descripcion: metodo que modifica el estado de un usuario
     *
     * @version 1.0
     * @author montda
     * @since 06/02/2017
     */
    public boolean CambiarEstadoUsuario(usuario usuarioModificando);
    /**
     * Descripcion: metodo que reinicia el conteo de intentos de login fallidos
     *
     * @version 1.0
     * @author montda
     * @since 06/02/2017
     */
    public boolean reiniciarIntentosLogin(usuario usuarioModificando);
}
