package controllers.usuario;

import com.vanesoft.vtrack.core.entidades.CodigoToken;
import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.core.excepciones.LogicaException;
import com.vanesoft.vtrack.core.utilidades.propiedades.PropiedadesLogica;
import com.vanesoft.vtrack.core.utilidades.propiedades.PropiedadesServicios;
import com.vanesoft.vtrack.webservice.logica.implementacion.FabricaComando;
import com.vanesoft.vtrack.webservice.logica.implementacion.usuario.ComandoConsultarUsuarioBloqueado;
import controllers.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Sistema:             Vtrack
 * Nombre:              UsuarioController
 * Descripcion:         Servicio encargado de realizar operaciones del usuario
 *
 * @author montda
 * @version 1.0
 * @since 13/02/2017
 */

@Path("/usuario")
public class UsuarioController extends BaseController {

    /*
        * Nombre:              doPost
        * Descripcion:         metodo encargado de validar que usuario esta bloqueado
     */
    @Path("/password")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Object doPost(@Context HttpServletRequest request , usuario user)
    {
        CodigoToken token = null;
        try
        {
            if (validarBloqueoUsuario(user))
            {

            }
        }catch (LogicaException e)
        {
            return obtenerMensajeDeError( e );
        }
        return token;
    }

    public boolean validarBloqueoUsuario(usuario user)
    {
        ComandoConsultarUsuarioBloqueado comandoConsultarUsuarioBloqueado =
                FabricaComando.obtenerComandoConsultarUsuarioBloqueado(user);
        return comandoConsultarUsuarioBloqueado.ejecutar();
    }

    public Object obtenerMensajeDeError(LogicaException e ) {
        if (e.getMessage().contains(PropiedadesLogica.ERROR_USUARIO_ACTIVO_INTENTANDO_DESBLOQUEO.substring(0,
                PropiedadesLogica.ERROR_USUARIO_ACTIVO_INTENTANDO_DESBLOQUEO.length() - 3)))
        {
            getRespuesta().setMensaje(PropiedadesServicios.RESPUESTA_USUARIO_ACTIVO_INTENTANDO_DESBLOQUEO);
        }
        if (e.getMessage().contains(PropiedadesLogica.ERROR_USUARIO_INTENTANDO_DESBLOQUEO_LOGIN_FALLIDO.substring(0,
                PropiedadesLogica.ERROR_USUARIO_INTENTANDO_DESBLOQUEO_LOGIN_FALLIDO.length() - 3)))
        {
            getRespuesta().setMensaje(PropiedadesServicios.RESPUESTA_USUARIO_BLOQUEDA_AUTENTICACION_ERRADA);
        }

        return super.obtenerMensajeDeError(e);
    }
}
