package com.vanesoft.vtrack.webservice.logica.implementacion.seguridad;

import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.core.entidades.CodigoToken;
import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuer;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import  com.vanesoft.vtrack.core.accesodatos.contratos.IDaoCodigoToken;
import com.vanesoft.vtrack.core.accesodatos.implementacion.DaoCodigoToken;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Sistema:             Vtrakc
 * Nombre:              ComandoGenerarCodigoAutorizacion
 * Descripcion:         Comando encargado de generar codigo de autorozacion
 *
 * @author  montda
 * @version 1.0
 * @since 03/02/2017
 */

public class ComandoGenerarCodigoAutorizacion extends ComandoSeguridad<CodigoToken>{

    //region atributos
    private CodigoToken codigoAutorizacion;
    private HttpServletRequest request;
    private IDaoCodigoToken daoCodigoToken = FabricaDao.obtenerDaoCodigoToken();
    //end region

    //contructor del comando
    public ComandoGenerarCodigoAutorizacion(HttpServletRequest request)
    {
        this.request = request;
        codigoAutorizacion = new CodigoToken();
    }
      /*
        Descripcion metodo que ejecuta comando
        return codigo de autorizacion
     */
     @Override
    public CodigoToken ejecutar()
     {
         try
         {
             OAuthIssuer oauthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());
             OAuthResponse respuesta = OAuthASResponse.authorizationResponse( request,
                     HttpServletResponse.SC_OK )
                     .setCode( oauthIssuerImpl.authorizationCode( ) )
                     .buildJSONMessage( );
             String codigo = getCodigoToken(respuesta);
             registrarCodigoAutorizacion(codigo);
             daoCodigoToken.guardarCodigoToken(codigoAutorizacion);

         }
         catch (OAuthSystemException e)
         {

         }

         return codigoAutorizacion;
     }
    /**
     * Descripcion: Método para registrar en el sistema el código de autorización
     *
     * @version 1.0
     * @author Montda
     * @since 03/02/2017
     */
     private void registrarCodigoAutorizacion (String codigo)
     {
         codigoAutorizacion.setValor(codigo);
         codigoAutorizacion.setTipo("TIPOTOKEN");
     }
}
