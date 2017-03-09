package controllers.login;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import com.vanesoft.vtrack.core.entidades.CodigoToken;
import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.core.utilidades.propiedades.PropiedadesLogica;
import com.vanesoft.vtrack.core.utilidades.propiedades.PropiedadesServicios;
import com.vanesoft.vtrack.webservice.logica.implementacion.seguridad.ComandoGenerarCodigoAutorizacion;
import com.vanesoft.vtrack.webservice.logica.implementacion.seguridad.ComandoGenerarToken;
import com.vanesoft.vtrack.webservice.logica.implementacion.FabricaComando;
import com.vanesoft.vtrack.webservice.logica.implementacion.usuario.ComandoValidarCredencialesUsuario;
import com.vanesoft.vtrack.core.excepciones.LogicaException;
import controllers.BaseController;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;


/**
 * Sistema:             Vtrack
 * Nombre:              LoginControler
 * Descripcion:         Servicio encargado de realizar las validaciones de seguridad el sistema con token
 *
 * @author montda
 * @version 1.0
 * @since 03/02/2017
 */
@Path("/auth")
public class LoginController extends BaseController{

    //region atributos

    //end redgion atributos
    /*
        * Nombre:              doPost
        * Descripcion:         metodo encargado de validar credenciales de usuario
        *                      y la generacion de token
     */
    @Path("/token")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Object doPost(@Context HttpServletRequest request , usuario user){
        // variable que contiene token a generar;
        CodigoToken token = null;
        try {
            if (validaCredenciales(user)) {
                token = getCodigoAuth(user, request);
            }
        }
        catch (LogicaException e)
        {
            return obtenerMensajeDeError( e );
        }
        return token;

    }

    /*
       * Nombre:              doPost
       * Descripcion:         metodo encargado de validar credenciales de usuario
       *                      y la generacion de token
    */
    @Path("/token")
    @PUT
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Object doPut(@Context HttpServletRequest request, CodigoToken codigoAuthorization){
        // variable que contiene token a generar;
        CodigoToken token = null;
        try
        {
            token = getToken(codigoAuthorization);
        }
        catch (LogicaException e)
        {
            return obtenerMensajeDeError( e );
        }catch (Exception e)
        {
            return obtenerMensajeDeError( e );
        }
        return token;

    }
    private CodigoToken getCodigoAuth(usuario user,HttpServletRequest request){
        ComandoGenerarCodigoAutorizacion comando = FabricaComando.obtenerComandoGenerarCodigoAutorizacion(request,user);
        CodigoToken codigo = comando.ejecutar();
        return codigo;
    }

    private CodigoToken getToken(CodigoToken token){
        ComandoGenerarToken comandoGenerarCodigoAutorizacion =
                FabricaComando.obtenerComandoGenerarToken(token);
        return comandoGenerarCodigoAutorizacion.ejecutar();
    }

    private Boolean validaCredenciales (usuario user){
        ComandoValidarCredencialesUsuario comando = FabricaComando.obtenerComandoValidarCredencialesUsuario(user.getPassword(),user.getUsername());
        return comando.ejecutar();
    }



    public Object obtenerMensajeDeError(Exception e ) {
        if (e.getMessage().contains(PropiedadesLogica.ERROR_CREDENCIALES_USUARIO_ERRADAS.substring(0,
                PropiedadesLogica.ERROR_CREDENCIALES_USUARIO_ERRADAS.length() - 3)))
        {
            getRespuesta().setMensaje(PropiedadesServicios.RESPUESTA_AUTENTICACION_ERRADA);
        }
        if (e.getMessage().contains(PropiedadesLogica.ERROR_USUARIO_NO_ENCONTRADO_EN_VTRACK.substring(0,
                PropiedadesLogica.ERROR_USUARIO_NO_ENCONTRADO_EN_VTRACK.length() - 3)))
        {
            getRespuesta().setMensaje(PropiedadesServicios.RESPUESTA_USUARIO_NO_ENCONTRADO);
        }

        if (e.getMessage().contains(PropiedadesLogica.ERROR_USUARIO_HA_SIDO_BLOQUEADO.substring(0,
                PropiedadesLogica.ERROR_USUARIO_HA_SIDO_BLOQUEADO.length() - 3)))
        {
            getRespuesta().setMensaje(PropiedadesServicios.RESPUESTA_USUARIO_BLOQUEADO);
        }

        if (e.getMessage().contains(PropiedadesLogica.ERROR_USUARIO_BLOQUEADO_INTENTADO_LOGIN.substring(0,
                PropiedadesLogica.ERROR_USUARIO_BLOQUEADO_INTENTADO_LOGIN.length() - 3)))
        {
            getRespuesta().setMensaje(PropiedadesServicios.RESPUESTA_USUARIO_BLOQUEADO_INTENTANDO_LOGIN);
        }
        if (e.getMessage().contains(PropiedadesLogica.ERROR_TOKEN_INVALIDO.substring(0,
                PropiedadesLogica.ERROR_TOKEN_INVALIDO.length() - 3)))
        {
            getRespuesta().setMensaje(PropiedadesServicios.RESPUESTA_TOKEN_INVALIDO);
        }
        if (e.getMessage().contains(PropiedadesLogica.ERROR_GENERANDO_TOKEN.substring(0,
                PropiedadesLogica.ERROR_GENERANDO_TOKEN.length() - 3)))
        {
            getRespuesta().setMensaje(PropiedadesServicios.RESPUESTA_ERROR_GENERANDO_TOKEN);
        }
        if (e.getMessage().contains(PropiedadesLogica.ERROR_INESPERADO.substring(0,
                PropiedadesLogica.ERROR_INESPERADO.length() - 3)))
        {
            getRespuesta().setMensaje(PropiedadesServicios.RESPUESTA_ERROR_GENERANDO_TOKEN);
        }
        if (e.getMessage().contains(PropiedadesLogica.ERROR_INESPERADO.substring(0,
                PropiedadesLogica.ERROR_INESPERADO.length() - 3))) {
            getRespuesta().setMensaje(PropiedadesServicios.RESPUESTA_ERROR_INESPERADO);
        }
        if (e.getMessage().contains(PropiedadesLogica.ERROR_USUARIO_POSEE_TOKEN.substring(0,
                PropiedadesLogica.ERROR_USUARIO_POSEE_TOKEN.length() - 3))) {
            getRespuesta().setMensaje(PropiedadesServicios.RESPUESTA_ERROR_USUARIO_POSEE_TOKEN);
        }
        return super.obtenerMensajeDeError(e);
    }
}
