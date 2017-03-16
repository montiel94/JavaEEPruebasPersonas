package controllers.pedido;

import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.core.excepciones.LogicaException;
import com.vanesoft.vtrack.webservice.logica.implementacion.FabricaComando;
import com.vanesoft.vtrack.webservice.logica.implementacion.pedido.ComandoBuscarPedidosXEmpresa;
import controllers.BaseController;
import com.vanesoft.vtrack.core.entidades.Pedido;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Daniel jose on 12/03/2017.
 */
@Path("/pedidos")
public class PedidoController extends BaseController {


    Boolean modoDebud = false;
    @Path("/all/{correoEmpresa}")
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Object doGet(@PathParam("correoEmpresa") String correoEmpresa)
    {
        if (modoDebud)
        {
        ArrayList<Pedido> pedidosArray = new ArrayList<Pedido>();
        Pedido pedido1 = new Pedido(12213,0,"12/02/2017");
        Pedido pedido2 = new Pedido(12214,2,"12/02/2017");
        Pedido pedido3 = new Pedido(12215,2,"13/02/2017");
        Pedido pedido4 = new Pedido(12216,4,"13/02/2017");
        Pedido pedido5 = new Pedido(12217,4,"14/02/2017");
        Pedido pedido6 = new Pedido(12218,4,"15/02/2017");
        Pedido pedido7 = new Pedido(12219,7,"15/02/2017");
        pedidosArray.add(pedido1);
        pedidosArray.add(pedido2);
        pedidosArray.add(pedido3);
        pedidosArray.add(pedido4);
        pedidosArray.add(pedido5);
        pedidosArray.add(pedido6);
        pedidosArray.add(pedido7);
        JsonArrayBuilder builder = Json.createArrayBuilder();
        GenericEntity<ArrayList<Pedido>> list = new GenericEntity<ArrayList<Pedido>>(pedidosArray) {};
        return Response.ok(list).build();
        }
        else
        {
            ArrayList<Pedido> pedidosArray = new ArrayList<Pedido>();
            ComandoBuscarPedidosXEmpresa comandoBuscarPedidosXEmpresa =
                    FabricaComando.obtenerComandoBuscarPedidosXEmpresa(correoEmpresa);
            pedidosArray = comandoBuscarPedidosXEmpresa.ejecutar();
            GenericEntity<ArrayList<Pedido>> list = new GenericEntity<ArrayList<Pedido>>(pedidosArray) {};
            return Response.ok(list).build();
        }
    }
}
