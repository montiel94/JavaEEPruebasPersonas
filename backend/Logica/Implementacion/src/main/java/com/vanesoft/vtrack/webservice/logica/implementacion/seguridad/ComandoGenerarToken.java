package com.vanesoft.vtrack.webservice.logica.implementacion.seguridad;
import com.vanesoft.vtrack.core.entidades.CodigoToken;
import com.vanesoft.vtrack.webservice.logica.contratos.IComando;
import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuer;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Sistema:             Vtrack
 * Nombre:              ComandoGenerarToken
 * Descripcion:         Implementación del proceso para generar token con OAuth2
 *
 * @author Montda
 * @version 1.0
 * @since 03/02/2017
 */
public class ComandoGenerarToken extends ComandoSeguridad{

    //region atributos
    private CodigoToken codigo;
    // endregion


    /*
        Descripcion : metodo que ejecuta el comando o funcion encapsulada
        @author : montda
        @since : 03/02/2017
     */
    @Override
    public CodigoToken ejecutar() {

        try
        {
            OAuthResponse respuesta = null;
            OAuthIssuer oauthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());
            respuesta = OAuthASResponse.tokenResponse(HttpServletResponse.SC_OK).setAccessToken(
                    oauthIssuerImpl.accessToken()).buildJSONMessage();
        }
        catch (OAuthSystemException e)
        {

        }catch (Exception e)
        {

        }

        return  codigo;
    }
}
