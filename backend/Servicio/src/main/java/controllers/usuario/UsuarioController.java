package controllers.usuario;

import com.vanesoft.vtrack.core.entidades.CodigoToken;
import com.vanesoft.vtrack.core.entidades.EstadoUsuario;
import com.vanesoft.vtrack.core.entidades.TipoPlantilla;
import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.core.excepciones.LogicaException;
import com.vanesoft.vtrack.core.utilidades.propiedades.PropiedadesLogica;
import com.vanesoft.vtrack.core.utilidades.propiedades.PropiedadesServicios;
import com.vanesoft.vtrack.webservice.logica.implementacion.FabricaComando;
import com.vanesoft.vtrack.webservice.logica.implementacion.seguridad.ComandoGenerarCodigoAutorizacion;
import com.vanesoft.vtrack.webservice.logica.implementacion.usuario.*;
import controllers.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
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

    @Path("/autoRegistro")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Object autoRegistroValidar(usuario user)
    {
        Boolean exito = false;
        try
        {
            exito = validarAutoRegistro(user);
        }
        catch (LogicaException e)
        {
            return obtenerMensajeDeError( e );
        }
        return exito;
    }

    @Path("/olvidastecontrasena")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Object olvidasteContrasena( usuario user)
    {
        boolean exito = false;
        try
        {
            if (validarUsuarioOlvidoContrasena(user))
            {
                enviarCorreoContrasenaProvisional(user);
            }
        }catch (LogicaException e)
        {
            return obtenerMensajeDeError( e );
        }
        return exito;
    }

    @Path("/password")
    @PUT
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Object doPUT(@Context HttpServletRequest request , usuario user)
    {
        boolean exito = false;
        try {
            exito = modificarPasswordUsuario(user);
            if (exito)
            {
                user.setEstadoUsuario(EstadoUsuario.activo);
                modificarEstadoUsuario(user);
            }
        }catch (LogicaException e)
        {
            return obtenerMensajeDeError( e );
        }
        return exito;
    }

    private boolean validarUsuarioOlvidoContrasena(usuario user)
    {
        boolean exito = false;
        usuario usuarioEnBd = null;
        try
        {
            ComandoConsultarUsuario comandoConsultarUsuario =
                    FabricaComando.obtenerComandoConsultarUsuario(user);
            usuarioEnBd = comandoConsultarUsuario.ejecutar();
            if (usuarioEnBd.getEstadoUsuario().equals(EstadoUsuario.activo))
                exito = true;
            if (usuarioEnBd.getEstadoUsuario().equals(EstadoUsuario.bloqueado))
                throw  new LogicaException(PropiedadesLogica.ERROR_USUARIO_BLOQUEADO_INTENTADO_LOGIN);
        }
        catch (LogicaException e)
        {
            throw new LogicaException(e.getMessage());
        }
        return exito;
    }
    /*
        Nombre modificarEstadoUsuario
        descripcion : modifica el estaod de un usuario
        parametro : objeto usuario

     */
    private boolean modificarEstadoUsuario(usuario user)
    {
        ComandoCambiarEstadoUsuario comandoCambiarEstadoUsuario =
                FabricaComando.obtenerComandoCambiarEstadoUsuario(user);
        return comandoCambiarEstadoUsuario.ejecutar();
    }

    private boolean modificarPasswordUsuario(usuario user)
    {
        ComandoModificarPasswordUsuario comandoModificarPasswordUsuario =
                FabricaComando.obtenerComandoModificarPasswordUsuario(user,user.getPassword());
        return comandoModificarPasswordUsuario.ejecutar();

    }

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
        usuario usuarioEnBd = null;


        try
        {
            usuarioEnBd = validarBloqueoUsuario(user);
            if (usuarioEnBd!=null)
            {
                return usuarioEnBd;
            }
        }catch (LogicaException e)
        {
            return obtenerMensajeDeError( e );
        }
        return usuarioEnBd;
    }
    /*
        Descripcion : metodo que envia correo a un usuario
                      de olvidaste tu contrasena??

         Parametros : usuarioEnBd usuario a enviale correo
         Return : boolean de exito del metodo
     */
    private boolean enviarCorreoContrasenaProvisional(usuario usuarioEnBd)
    {
        boolean exito = false;
        ComandoConsultarUsuario comandoConsultarUsuario
                = FabricaComando.obtenerComandoConsultarUsuario(usuarioEnBd);
        usuarioEnBd = comandoConsultarUsuario.ejecutar();
        ComandoEnviarCorreoParametrizado comandoEnviarCorreoParametrizado
                = FabricaComando.obtenerComandoEnviarCorreoParametrizado(usuarioEnBd, TipoPlantilla.usuarioolvidocontrasena);
        comandoEnviarCorreoParametrizado.ejecutar();
        return exito;
    }

    public Boolean validarAutoRegistro(usuario user)
    {
        Boolean exito = false;
        usuario usuarioEnBd = null;
        try
        {
            ComandoConsultarUsuario comandoConsultarUsuario =
                    FabricaComando.obtenerComandoConsultarUsuario(user);
            usuarioEnBd = comandoConsultarUsuario.ejecutar();
            if (!usuarioEnBd.getEstadoUsuario().equals(EstadoUsuario.nuevo))
                throw new LogicaException(PropiedadesLogica.ERROR_USUARIO_NO_ES_NUEVO);
            exito = true;
        }
        catch (LogicaException e)
        {
            throw new LogicaException(e.getMessage());
        }
        return exito;
    }
    /*
        Descripcion valida que el usuario en bd este bloqueado
        parametros user : usuario a ser buscado en bd
        return     usuario consultado
     */
    public usuario validarBloqueoUsuario(usuario user)
    {
        usuario usuarioEnbd = null;
        try
        {
        ComandoConsultarUsuarioBloqueado comandoConsultarUsuarioBloqueado =
                FabricaComando.obtenerComandoConsultarUsuarioBloqueado(user);
        usuarioEnbd = comandoConsultarUsuarioBloqueado.ejecutar();
        }catch (LogicaException e)
        {
            throw new LogicaException(e.getMessage());
        }
        return usuarioEnbd;
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
        if (e.getMessage().contains(PropiedadesLogica.ERROR_USUARIO_NO_ENCONTRADO_EN_VTRACK.substring(0,
                PropiedadesLogica.ERROR_USUARIO_NO_ENCONTRADO_EN_VTRACK.length() - 3)))
        {
            getRespuesta().setMensaje(PropiedadesServicios.RESPUESTA_USUARIO_NO_ENCONTRADO);
        }
        if (e.getMessage().contains(PropiedadesLogica.ERROR_USUARIO_BLOQUEADO_INTENTADO_LOGIN.substring(0,
                PropiedadesLogica.ERROR_USUARIO_BLOQUEADO_INTENTADO_LOGIN.length() - 3)))
        {
            getRespuesta().setMensaje(PropiedadesServicios.RESPUESTA_USUARIO_BLOQUEADO_INTENTANDO_LOGIN);
        }
        if (e.getMessage().contains(PropiedadesLogica.ERROR_USUARIO_NO_ES_NUEVO.substring(0,
                PropiedadesLogica.ERROR_USUARIO_NO_ES_NUEVO.length() - 3)))
        {
            getRespuesta().setMensaje(PropiedadesServicios.RESPUESTA_USUARIO_NO_POSEE_ESTADO_NUEVO);
        }

        return super.obtenerMensajeDeError(e);
    }
}
