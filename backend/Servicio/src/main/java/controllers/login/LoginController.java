package controllers.login;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import com.vanesoft.vtrack.core.entidades.CodigoToken;
import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.webservice.logica.implementacion.seguridad.ComandoGenerarCodigoAutorizacion;
import com.vanesoft.vtrack.webservice.logica.implementacion.FabricaComando;
import com.vanesoft.vtrack.webservice.logica.implementacion.usuario.ComandoValidarCredencialesUsuario;

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
public class LoginController {

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
        String token = "";
        if (validaCredenciales(user)) {
            token = getToken(user, request);
        }
        return token;

    }

    private String getToken(usuario user,HttpServletRequest request){
        ComandoGenerarCodigoAutorizacion comando = FabricaComando.obtenerComandoGenerarCodigoAutorizacion(request);
        CodigoToken codigo = comando.ejecutar();
        return codigo.getValor();
    }

    private Boolean validaCredenciales (usuario user){
        ComandoValidarCredencialesUsuario comando = FabricaComando.obtenerComandoValidarCredencialesUsuario(user.getPassword(),user.getUsername());
        return comando.ejecutar();
    }
}
