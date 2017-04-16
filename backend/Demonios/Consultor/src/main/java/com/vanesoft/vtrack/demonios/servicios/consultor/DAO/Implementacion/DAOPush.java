package com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Implementacion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.IDAOParametro;
import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.IDAOPlantilla;
import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.IDAOPush;
import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.IDAOUsuario;
import com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.*;
import com.vanesoft.vtrack.demonios.servicios.consultor.Fabricas.FabricaDAO;
import com.vanesoft.vtrack.demonios.servicios.consultor.utilidades.PropiedadesDemonios;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by Daniel jose on 11/04/2017.
 */
public class DAOPush extends DAO implements IDAOPush{

    public void EnviarPushEstado(usuario usuarioEnviarPush,Pedido pedido,String estado){
        String url = PropiedadesDemonios.CONFIG_URL_SERVER_PUSH;
        CloseableHttpClient client = HttpClients.createDefault();
        IDAOPlantilla idaoPlantilla = FabricaDAO.obtenerDAOPlantilla();
        IDAOParametro daoParametro = FabricaDAO.obtenerDAOParametro();

        try {
            Plantilla plantillaEnBd = idaoPlantilla.consultarPlantilla(TipoPlantilla.pedidoestadopush);
            ArrayList parametrosPlantillaEnBd = daoParametro.consultarParametrosXPlantilla(TipoPlantilla.pedidoestadopush);
            Hashtable<String, String> valores = new Hashtable<String, String>();
            valores.put(ParametroMensaje.nombreParametroNombreUsuario, usuarioEnviarPush.getNombreempresa());
            valores.put(ParametroMensaje.nombreParametroCodigoPedido, String.valueOf(pedido.getNUMERO()));
            valores.put(ParametroMensaje.nombreEstadoPedido,estado);
            String MensajeFinal = Armador.armarMensaje(plantillaEnBd.getTexto(), parametrosPlantillaEnBd, valores);
            HttpPost httpPost = new HttpPost(url);
            notification notificationContenido =
                    new notification(plantillaEnBd.getTitulo(), MensajeFinal);
            push push = new push("/topics/"+usuarioEnviarPush.username.replace("@","~"), notificationContenido);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(push);
            StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setHeader("Authorization", PropiedadesDemonios.CONFIG_KEY_FCM);
            CloseableHttpResponse response = client.execute(httpPost);
            client.close();
        }
        catch (UnsupportedEncodingException e)
        {

        }
        catch (JsonProcessingException e)
        {

        }
        catch (IOException e)
        {

        }



    }

    public Boolean confirmarEnvioPush(String codigoPedido,String estadoNotificacion){
        System.out.println("entrando al metodo confirmarEnvioCorreoInicioLlenado");
        Boolean exito= false;
        try {
            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "UPDATE VTRACK_NOTIFICACION "+
                    "SET NOTIFICACION_PUSH = "+estadoNotificacion+" "+
                    "WHERE FK_PEDIDO = "+codigoPedido+"";
            stmt.execute(query);
            connection.close();

        } catch (Exception e) {

            System.out.println("exception : " +e.getMessage());
            return false;
        }

        System.out.println("saliendo del metodo confirmarEnvioCorreoInicioLlenado");
        return true;

    }

}
