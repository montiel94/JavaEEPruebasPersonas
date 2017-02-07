package com.vanesoft.vtrack.webservice.logica.implementacion.seguridad;

import com.vanesoft.vtrack.core.entidades.CodigoToken;
import com.vanesoft.vtrack.webservice.logica.contratos.IComando;
import com.vanesoft.vtrack.webservice.logica.implementacion.ComandoBase;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.message.OAuthResponse;


/**
 * Sistema:             Vtrack
 * Nombre:              ComandoSeguridad
 * Descripcion:         Clase abstracta implementada por los comandos involucrados en el proceso de interaccion con
 * OAuth2
 *
 * @author Montda
 * @version 1.0
 * @since 03/02/2017
 */
public abstract  class ComandoSeguridad<CodigoToken> extends ComandoBase<CodigoToken>{

    /*
        Descripcion : Metodo para obtener el codigo de autorizacion o token dado un
        OauthResponse
        @author montda
        @since 03/02/2017
     */
    protected String getCodigoToken (OAuthResponse respuesta)
    {
        String codigoToken;

        codigoToken = respuesta.getBody( ).split(":" )[ 1 ];

        codigoToken = ( codigoToken.contains( "\"" ) ) ? codigoToken.replace( "\"", "" ) : codigoToken;
        codigoToken = ( codigoToken.contains( "}" ) ) ? codigoToken.replace( "}", "" ) : codigoToken;

        return codigoToken;
    }
}
