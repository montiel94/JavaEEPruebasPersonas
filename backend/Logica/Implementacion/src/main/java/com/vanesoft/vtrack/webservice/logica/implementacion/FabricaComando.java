package com.vanesoft.vtrack.webservice.logica.implementacion;

import com.vanesoft.vtrack.core.entidades.CodigoToken;
import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.webservice.logica.implementacion.correo.ComandoEnviarCorreo;
import com.vanesoft.vtrack.webservice.logica.implementacion.evento.ComandoConsultarEventosXPedido;
import com.vanesoft.vtrack.webservice.logica.implementacion.pedido.ComandoBuscarPedidoXCodigo;
import com.vanesoft.vtrack.webservice.logica.implementacion.pedido.ComandoBuscarPedidosXEmpresa;
import com.vanesoft.vtrack.webservice.logica.implementacion.seguridad.ComandoEliminarToken;
import com.vanesoft.vtrack.webservice.logica.implementacion.seguridad.ComandoGenerarCodigoAutorizacion;
import com.vanesoft.vtrack.webservice.logica.implementacion.seguridad.ComandoGenerarToken;
import com.vanesoft.vtrack.webservice.logica.implementacion.usuario.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Sistema:                 Vtrack
 * Siglas:                  VT
 * <p/>
 * Nombre:                  FabricaComando
 * Descripcion:             lase que simula un fabrica de objetos, en este caso
 * objetos comandos(encargados de realizar la logica de negocio)
 *
 * @author montda
 * @version 1.0
 * @since 6/04/2017
 */
public final class FabricaComando {

    //constructores
    private FabricaComando (){

    }


    /**
     * Nombre:                  obtenerComandoGenerarCodigoAutorizacion
     * Descripcion:             genera el comando obtenerComandoGenerarCodigoAutorizacion
     *
     * @return el comando
     * @version 1.0
     * @author montda
     * @since 06/02/17
     */
    public static ComandoGenerarCodigoAutorizacion obtenerComandoGenerarCodigoAutorizacion(HttpServletRequest request
            ,usuario user){
        return new ComandoGenerarCodigoAutorizacion(request,user);
    }

    /**
     * Nombre:                  obtenerComandoValidarCredencialesUsuario
     * Descripcion:             genera el comando obtenerComandoValidarCredencialesUsuario
     *
     * @return el comando
     * @version 1.0
     * @author montda
     * @since 06/02/17
     */
    public static ComandoValidarCredencialesUsuario obtenerComandoValidarCredencialesUsuario(String contrasena,String correo){
        return new ComandoValidarCredencialesUsuario(contrasena,correo);
    }

    /**
     * Nombre:                  obtenerComandoAumentarNumeroIntentosLogin
     * Descripcion:             genera el comando obtenerComandoAumentarNumeroIntentosLogin
     *
     * @return el comando
     * @version 1.0
     * @author montda
     * @since 06/02/17
     */
    public static ComandoAumentarNumeroIntentosLogin obtenerComandoAumentarNumeroIntentosLogin(usuario usuarioEnBd){
        return new ComandoAumentarNumeroIntentosLogin(usuarioEnBd);
    }

    /**
     * Nombre:                  obtenerComandoVerificarBloqueoUsuario
     * Descripcion:             genera el comando ComandoVerificarBloqueoUsuario
     *
     * @return el comando
     * @version 1.0
     * @author montda
     * @since 06/02/17
     */
    public static ComandoVerificarBloqueoUsuario obtenerComandoVerificarBloqueoUsuario(usuario usuarioEnBd){
        return new ComandoVerificarBloqueoUsuario (usuarioEnBd);
    }

    /**
     * Nombre:                  ComandoCambiarEstadoUsuario
     * Descripcion:             genera el comando ComandoCambiarEstadoUsuario
     *
     * @return el comando
     * @version 1.0
     * @author montda
     * @since 06/02/17
     */
    public static ComandoCambiarEstadoUsuario obtenerComandoCambiarEstadoUsuario(usuario usuarioEnBd){
        return new ComandoCambiarEstadoUsuario (usuarioEnBd);
    }

    /**
     * Nombre:                  obtenerComandoEnviarCorreo
     * Descripcion:             genera el comando ComandoEnviarCorreo
     *
     * @return el comando
     * @version 1.0
     * @author montda
     * @since 06/02/17
     */
    public static ComandoEnviarCorreo obtenerComandoEnviarCorreo(usuario usuarioEnBd){
        return new ComandoEnviarCorreo (usuarioEnBd);
    }

    /**
     * Nombre:                  obtenerComandoConsultarUsuarioBloqueado
     * Descripcion:             genera el comando ComandoConsultarUsuarioBloqueado
     *
     * @return el comando
     * @version 1.0
     * @author montda
     * @since 13/02/17
     */
    public static ComandoConsultarUsuarioBloqueado obtenerComandoConsultarUsuarioBloqueado(usuario usuarioEnBd){
        return new ComandoConsultarUsuarioBloqueado (usuarioEnBd);
    }

    /**
     * Nombre:                  obtenerComandoConsultarUsuarioBloqueado
     * Descripcion:             genera el comando ComandoConsultarUsuarioBloqueado
     *
     * @return el comando
     * @version 1.0
     * @author montda
     * @since 13/02/17
     */
    public static ComandoModificarPasswordUsuario obtenerComandoModificarPasswordUsuario(usuario usuarioEnBd,
                                                                                         String passwordNueva){
        return new ComandoModificarPasswordUsuario (usuarioEnBd,passwordNueva);
    }
    /**
     * Nombre:                  obtenerComandoConsultarUsuario
     * Descripcion:             genera el comando ComandoConsultarUsuario
     *
     * @return el comando
     * @version 1.0
     * @author montda
     * @since 13/02/17
     */
    public static ComandoConsultarUsuario obtenerComandoConsultarUsuario(usuario usuarioEnBd){
        return new ComandoConsultarUsuario (usuarioEnBd);
    }

    /**
     * Nombre:                  obtenerComandoConsultarUsuario
     * Descripcion:             genera el comando ComandoConsultarUsuario
     *
     * @return el comando
     * @version 1.0
     * @author montda
     * @since 13/02/17
     */
    public static ComandoEnviarCorreoParametrizado obtenerComandoEnviarCorreoParametrizado(usuario usuarioEnBd,String tipoPlantilla){
        return new ComandoEnviarCorreoParametrizado (tipoPlantilla,usuarioEnBd);
    }

    /**
     * Nombre:                  obtenerComandoConsultarUsuario
     * Descripcion:             genera el comando ComandoConsultarUsuario
     *
     * @return el comando
     * @version 1.0
     * @author montda
     * @since 13/02/17
     */
    public static ComandoGenerarToken obtenerComandoGenerarToken(CodigoToken codigoAuthorizacion){
        return new ComandoGenerarToken(codigoAuthorizacion);
    }

    /**
     * Nombre:                  obtenerComandoConsultarUsuario
     * Descripcion:             genera el comando ComandoConsultarUsuario
     *
     * @return el comando
     * @version 1.0
     * @author montda
     * @since 13/02/17
     */
    public static ComandoEliminarToken obtenerComandoEliminarToken(String codigoToken){
        return new ComandoEliminarToken(codigoToken);
    }

    /**
     * Nombre:                  obtenerComandoBuscarPedidosXEmpresa
     * Descripcion:             genera el comando ComandoBuscarPedidosXEmpresa
     *
     * @return el comando
     * @version 1.0
     * @author montda
     * @since 15/03/17
     */
    public static ComandoBuscarPedidosXEmpresa  obtenerComandoBuscarPedidosXEmpresa (String correoEmpresa){
        return new ComandoBuscarPedidosXEmpresa(correoEmpresa);
    }

    /**
     * Nombre:                  obtenerComandoBuscarPedidosXEmpresa
     * Descripcion:             genera el comando ComandoBuscarPedidosXEmpresa
     *
     * @return el comando
     * @version 1.0
     * @author montda
     * @since 21/03/17
     */
    public static ComandoConsultarEventosXPedido obtenerComandoConsultarEventosXPedido (String codigoPedido){
        return new ComandoConsultarEventosXPedido(codigoPedido);
    }

    /**
     * Nombre:                  obtenerComandoBuscarPedidoXCodigo
     * Descripcion:             genera el comando ComandoBuscarPedidoXCodigo
     *
     * @return el comando
     * @version 1.0
     * @author montda
     * @since 21/03/17
     */
    public static ComandoBuscarPedidoXCodigo obtenerComandoBuscarPedidoXCodigo (String codigoPedido){
        return new ComandoBuscarPedidoXCodigo(codigoPedido);
    }

}