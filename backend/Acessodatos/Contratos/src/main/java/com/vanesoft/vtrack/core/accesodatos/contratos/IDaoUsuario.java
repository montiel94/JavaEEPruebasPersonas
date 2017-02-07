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
}
