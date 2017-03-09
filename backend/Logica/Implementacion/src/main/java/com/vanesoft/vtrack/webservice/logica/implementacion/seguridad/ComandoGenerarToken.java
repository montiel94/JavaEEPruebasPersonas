package com.vanesoft.vtrack.webservice.logica.implementacion.seguridad;
import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoCodigoToken;
import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.core.entidades.CodigoToken;
import com.vanesoft.vtrack.core.excepciones.LogicaException;
import com.vanesoft.vtrack.core.utilidades.propiedades.PropiedadesLogica;
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
    private CodigoToken codigoAuthorizacion;
    private IDaoCodigoToken daoCodigoToken = FabricaDao.obtenerDaoCodigoToken();
    // endregion


    /*
        Descripcion : metodo que ejecuta el comando o funcion encapsulada
        @author : montda
        @since : 03/02/2017
     */

    public ComandoGenerarToken(CodigoToken codigoAuthorizacion) {
        this.codigoAuthorizacion = codigoAuthorizacion;
    }

    @Override
    public CodigoToken ejecutar() {

        try
        {
            if (validarCodigoAuth(codigoAuthorizacion))
            {
                OAuthResponse respuesta = null;
                OAuthIssuer oauthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());
                respuesta = OAuthASResponse.tokenResponse(HttpServletResponse.SC_OK).setAccessToken(
                        oauthIssuerImpl.accessToken()).buildJSONMessage();
                String token = getCodigoToken(respuesta);
                registrarToken(token);

                return codigoAuthorizacion;
            }
            else
            {
                throw new LogicaException(PropiedadesLogica.ERROR_TOKEN_INVALIDO);
            }
        }
        catch (OAuthSystemException e)
        {
            throw new LogicaException(PropiedadesLogica.ERROR_GENERANDO_TOKEN);
        }catch (LogicaException e)
        {
            throw new LogicaException(e.getMessage());
        }catch (Exception e)
        {
            throw new LogicaException(PropiedadesLogica.ERROR_INESPERADO);
        }


    }

    public Boolean validarCodigoAuth(CodigoToken auth)
    {
        if (codigoAuthorizacion.getValor()==null && codigoAuthorizacion.getValor().equals(""))
            return false;
        CodigoToken codigoEnBd = daoCodigoToken.ConsultarCodigoAuthXValor(auth);
        if (codigoEnBd == null)
            return false;
        if (!codigoEnBd.getValor().equals(auth.getValor()))
            return false;
        else
            return true;
    }
    private void registrarToken(String token)
    {
        daoCodigoToken.modificarValorToken(token,codigoAuthorizacion);
        codigoAuthorizacion.setValor(token);
        codigoAuthorizacion.setTipo("TOKEN");
        daoCodigoToken.modificarTipoToken(codigoAuthorizacion);
    }
}
