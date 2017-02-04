package controllers.login;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import com.vanesoft.vtrack.core.entidades.CodigoToken;
import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.webservice.logica.implementacion.seguridad.ComandoGenerarCodigoAutorizacion;
import com.vanesoft.vtrack.webservice.logica.implementacion.seguridad.ComandoSeguridad;

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
        token = getToken(user,request);
        return token;

    }

    private String getToken(usuario user,HttpServletRequest request){

        ComandoGenerarCodigoAutorizacion comando = new ComandoGenerarCodigoAutorizacion(request);
        CodigoToken codigo = comando.ejecutar();
        return codigo.getValor();
    }
}
