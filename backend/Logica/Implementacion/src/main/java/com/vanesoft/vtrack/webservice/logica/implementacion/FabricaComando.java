package com.vanesoft.vtrack.webservice.logica.implementacion;

import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.webservice.logica.implementacion.seguridad.ComandoGenerarCodigoAutorizacion;
import com.vanesoft.vtrack.webservice.logica.implementacion.usuario.ComandoAumentarNumeroIntentosLogin;
import com.vanesoft.vtrack.webservice.logica.implementacion.usuario.ComandoValidarCredencialesUsuario;
import com.vanesoft.vtrack.webservice.logica.implementacion.usuario.ComandoVerificarBloqueoUsuario;

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
    public static ComandoGenerarCodigoAutorizacion obtenerComandoGenerarCodigoAutorizacion(HttpServletRequest request){
        return new ComandoGenerarCodigoAutorizacion(request);
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
}