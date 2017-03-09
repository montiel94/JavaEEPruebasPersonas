package controllers;

import com.vanesoft.vtrack.core.entidades.Respuesta;
import com.vanesoft.vtrack.core.excepciones.LogicaException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Description : controlador base de los servicios rest para
 * reutilzar codigo
 * Created by Daniel jose on 07/02/2017.
 */
public class BaseController {

    private Respuesta respuesta = new Respuesta( );

    public Respuesta getRespuesta( )
    {
        return respuesta;
    }

    /**
     * Descripcion: Transforma el mensaje de error en un mensaje lejible para el usuario final
     *
     * @version 1.0
     * @author montda
     * @since 07/01/2016
     */
    public Object obtenerMensajeDeError( Exception e )
    {
        return retornarError( this.respuesta );
    }

    /**
     * Descripcion: Transforma la respuesta de error recibida de la capa logica en un JSON para ser retornado
     *
     * @param respuesta Objeto serializado con el contenido de la respuesta
     *
     * @version 1.0
     * @author montda
     * @since 07/01/2017
     */
    public Object retornarError( Object respuesta )
    {
        return Response.status( Response.Status.BAD_REQUEST ).entity( respuesta ).type( MediaType.APPLICATION_JSON )
                .encoding( "UTF-8" ).build( );
    }
}
