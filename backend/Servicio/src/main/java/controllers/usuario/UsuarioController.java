package controllers.usuario;

import com.vanesoft.vtrack.core.entidades.CodigoToken;
import com.vanesoft.vtrack.core.entidades.EstadoUsuario;
import com.vanesoft.vtrack.core.entidades.TipoPlantilla;
import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.core.excepciones.LogicaException;
import com.vanesoft.vtrack.core.utilidades.propiedades.CifrarDescifrar;
import com.vanesoft.vtrack.core.utilidades.propiedades.PropiedadesLogica;
import com.vanesoft.vtrack.core.utilidades.propiedades.PropiedadesServicios;
import com.vanesoft.vtrack.webservice.logica.implementacion.FabricaComando;
import com.vanesoft.vtrack.webservice.logica.implementacion.interceptores.TokenSecurity;
import com.vanesoft.vtrack.webservice.logica.implementacion.seguridad.ComandoGenerarCodigoAutorizacion;
import com.vanesoft.vtrack.webservice.logica.implementacion.usuario.*;
import controllers.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
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
        nombre : doGet
        Descripcion 0: metodo consulta la informacion de empresa para el perfil de usuario
        creacion : 22/03/2017
        Parametros : correoEmpresa
        @author montda
        @version 1.
     */
    @Path("/{correoEmpresa}")
    @GET
    @TokenSecurity
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Object goGet(@HeaderParam("Authorization") String Authorization,@PathParam("correoEmpresa") String correoEmpresa)
    {
        usuario userEnBd = null;
        try
        {
            userEnBd = buscarUserXCorreo(correoEmpresa);
        }
        catch (LogicaException e)
        {
            return obtenerMensajeDeError( e );
        }
        return userEnBd;
    }
    /*
        nombre : doGet
        Descripcion : metodo consulta la informacion de empresa para el perfil de usuario
        creacion : 22/03/2017
        Parametros : correoEmpresa
        @author montda
        @version 1.0
     */
    @Path("ConfirmarPassword/{correoEmpresa}/{password}")
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Object goGetPassword(@PathParam("correoEmpresa") String correoEmpresa,@PathParam("password") String password)
    {
        usuario userEnBd = null;
        try
        {
            userEnBd = buscarUserXCorreo(correoEmpresa);
            if (password.equals(CifrarDescifrar.descifradoSeguro(userEnBd.getPassword())))
                return true;
            else
                return false;
        }
        catch (LogicaException e)
        {
            return obtenerMensajeDeError( e );
        }
    }
    /*
        nombre : autoRegistro
        Descripcion : metodo que termina el proceso de autoregistro del usuario
        creacion : 02/03/2017
        Parametros : usuario de Vtrack
        @author montda
        @version 1.0
     */
    @Path("/autoRegistro")
    @PUT
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Object autoRegistro(usuario user)
    {
        Boolean exito = false;
        try
        {
            exito = autoRegistrar(user);
        }
        catch (LogicaException e)
        {
            return obtenerMensajeDeError( e );
        }
        return exito;
    }
    /*
        Descripcion : metodo que valida el autoregistro de un usuario
        creacion : 02/03/2017
        Parametros : usuario de Vtrack
        @author montda
        @version 1.0
     */
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
    /*
        Descripcion : metodo que enviar por correo clave provisional
        cuando el usuario olvida contrasena
        creacion : 02/03/2017
        Parametros : usuario de Vtrack
        @author montda
        @version 1.0
     */
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
    /*
        Descripcion : metodo que valida si el usuario exite en vtrack y
        no se encuentre bloqueado
        creacion : 22/02/2017
        Parametros : usuario de Vtrack
        @author montda
        @version 1.0
     */
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

    public Boolean autoRegistrar(usuario user)
    {
        Boolean exito = false;
        try
        {
            user.setEstadoUsuario(EstadoUsuario.activo);
            ComandoCambiarEstadoUsuario comandoCambiarEstadoUsuario =
                    FabricaComando.obtenerComandoCambiarEstadoUsuario(user);
            exito  = comandoCambiarEstadoUsuario.ejecutar();
            if (exito)
            {
                ComandoModificarPasswordUsuario comandoModificarPasswordUsuario =
                        FabricaComando.obtenerComandoModificarPasswordUsuario(user,user.getPassword());
                exito = comandoModificarPasswordUsuario.ejecutar();
            }
        }catch (LogicaException e)
        {

        }
        return exito;
    }

    /*
        Descripcion : metodo con logica de la validacion del autoregistro
        creacion : 01/03/2017
        Parametros : usuario de Vtrack
        @author montda
        @version 1.0
     */
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
    /*
        Descripcion : metodo busca mensaje ha ser mostrado en el cliente
        creacion : 02/03/2017
        Parametros : usuario de Vtrack
        @author montda
        @version 1.0
     */
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

    public usuario buscarUserXCorreo(String correoEmpresa)
    {
        usuario usuarioBusqueda = new usuario();
        usuarioBusqueda.setUsername(correoEmpresa);
        ComandoConsultarUsuario  comandoConsultarUsuario =
                FabricaComando.obtenerComandoConsultarUsuario(usuarioBusqueda);
        return comandoConsultarUsuario.ejecutar();
    }
}
