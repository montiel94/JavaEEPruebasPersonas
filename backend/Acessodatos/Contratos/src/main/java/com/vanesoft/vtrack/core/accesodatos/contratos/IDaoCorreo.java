package com.vanesoft.vtrack.core.accesodatos.contratos;

import com.vanesoft.vtrack.core.entidades.Pedido;
import com.vanesoft.vtrack.core.entidades.usuario;

/**
 * Sistema:             Vtrack
 * Nombre:              IDaoCorreo
 * Descripcion:         Contrato del dao dedicado a las operaciones con correos de notifiacion
 *
 * @author montda
 * @version 1.0
 * @since 04/02/2017
 */
public interface IDaoCorreo {

    /**
     * Descripcion: metodo que envia por correo advertencia de cuenta bloqueada
     *
     * @params usuario : usuario a enviar correo
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */
    public void envioCorreoUsuarioXIntentosLogin (usuario usuarioEnviarCorreo);
    /**
     * Descripcion: metodo que generar password nueva
     *
     * @params usuario : usuario a enviar correo
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */
    public String generarContrasenaProvisional(int longitud);

    /**
     * Descripcion: metodo que envia correo parametrizadamente
     * @params usuario : usuario a enviar correo
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */

    public Boolean envioCorreoUsuarioParametrizado (usuario usuarioEnviarCorreo,String tipoPlantillaa);

    /**
     * Descripcion: arma el contenido de un correo aparartir del usuario destinatario, el pedido y el estado del pedido
     *
     * @params usuario : usuario a enviar correo
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */

    public boolean armarCorreoPedidoEstado(usuario usuarioEnviarCorreo, Pedido pedido, String estado);
}
