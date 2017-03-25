package com.vanesoft.vtrack.webservice.logica.implementacion.interceptores;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoCodigoToken;
import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoPedido;
import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.core.entidades.CodigoToken;
import com.vanesoft.vtrack.core.entidades.Respuesta;
import com.vanesoft.vtrack.core.excepciones.LogicaException;
import com.vanesoft.vtrack.core.utilidades.propiedades.PropiedadesLogica;
import  com.vanesoft.vtrack.webservice.logica.implementacion.interceptores.TokenSecurity;
/**
 * Created by Daniel jose on 16/03/2017.
 */
@Interceptor
@TokenSecurity
public class TokenSecurityInterceptor {

    Respuesta respuesta = new Respuesta();
    @AroundInvoke
    public Object checkSecurity(InvocationContext context) throws Exception {
        /* comprobar los parámetros o realizar una comprobación de seguridad genérica antes de invocar el
           método original */
        Object[] params = context.getParameters();
        IDaoCodigoToken daoCodigoToken =
                FabricaDao.obtenerDaoCodigoToken();
        CodigoToken tokenEnBd = null;
        CodigoToken tokenRequest = new CodigoToken();
        /* si la validación de seguridad falla, puede generar una excepción */


        Object[] parametros = context.getParameters();
        String Authorization = (String)parametros[0];


        Object ret = null;
        try
        {
            tokenRequest.setValor(Authorization);
            tokenEnBd = daoCodigoToken.ConsultarCodigoAuthXValor(tokenRequest);
            if (tokenEnBd == null)
                throw new LogicaException(PropiedadesLogica.ERROR_TOKEN_INVALIDO);
            else
            {
                 ret = context.proceed();

                /* realizar cualquier trabajo posterior a llamada de método */


            }

        }
        catch (LogicaException e)
        {
            respuesta.setMensaje(e.getMessage());
            return obtenerMensajeDeError(e);
        }
        catch (Exception e)
        {

        }
        /* invocar el método proceed() para que llame al método original */
        return ret;
    }

    public Object retornarError( Object respuesta )
    {
        return Response.status( Response.Status.BAD_REQUEST ).entity( respuesta ).type( MediaType.APPLICATION_JSON )
                .encoding( "UTF-8" ).build( );
    }

    public Respuesta getRespuesta( )
    {
        return respuesta;
    }

    public Object obtenerMensajeDeError( Exception e )
    {
        return retornarError( this.respuesta );
    }
}