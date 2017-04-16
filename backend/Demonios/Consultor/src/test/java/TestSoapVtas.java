/**
 * Created by Daniel jose on 04/04/2017.
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vanesoft.vtrack.demonios.servicios.consultor.Comandos.ComandoTratarListaVtrack;
import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.*;
import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Implementacion.DAOCorreo;
import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Implementacion.DAOPedido;
import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Implementacion.DAOUsuario;
import com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.*;
import com.vanesoft.vtrack.demonios.servicios.consultor.Fabricas.FabricaDAO;
import com.vanesoft.vtrack.demonios.servicios.consultor.utilidades.PropiedadesDemonios;
import junit.framework.TestCase;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.xml.ws.BindingProvider;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestSoapVtas extends TestCase{

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
    }

    /*public void testPruebaVtas()
    {
        ScliWsdl wsActualizadorService = new ScliWsdl();
        ParametrosPedidos parametrosPedidos = new ParametrosPedidos();
        parametrosPedidos.setTIEMPO("2017-04-05 10:00:00");
        ScliWsdlPortType wsActualizador = wsActualizadorService.getScliWsdlPort();
        List<RespuestaPedido> prueba = wsActualizador.pedidos(parametrosPedidos);
        //tratarListaPedido(convertirListaPedidosVtas(prueba));
        assertEquals("vtrack","vtrack");
    }


    public void testEnviarCorreo()
    {
        WSActualizadorService wsActualizadorService = new WSActualizadorService();
        WSActualizador wsActualizador = wsActualizadorService.getWSActualizadorPort();
        List<Pedido> prueba = wsActualizador.actualizarEstado(1,1);
        tratarListaPedido(convertirListaPedidosVtas(prueba));
        assertEquals("vtrack","vtrack");
    }

    public List<com.vanesoft.vtrack.core.entidades.Pedido> convertirListaPedidosVtas
            (List<Pedido> pedidosVtas)
    {
        Iterator<Pedido> pedidosVtasIterator = pedidosVtas.iterator();
        List<com.vanesoft.vtrack.core.entidades.Pedido> pedidosVtrack =
                new ArrayList<com.vanesoft.vtrack.core.entidades.Pedido >();
        while(pedidosVtasIterator.hasNext()){
            Pedido pedidoVtas = pedidosVtasIterator.next();
            com.vanesoft.vtrack.core.entidades.Pedido pedidoATratarVtrack =
                    new com.vanesoft.vtrack.core.entidades.Pedido();
            pedidoATratarVtrack.setCodigoPedido(pedidoVtas.getCodigoPedido());
            pedidoATratarVtrack.setFechaCreacion(pedidoVtas.getFechaCreacion());
            pedidoATratarVtrack.setFin(pedidoVtas.getFin());
            pedidoATratarVtrack.setInicio(pedidoVtas.getInicio());
            pedidoATratarVtrack.setChofer(pedidoVtas.getChofer());
            pedidoATratarVtrack.setCabezote(pedidoVtas.getCabezote());
            pedidoATratarVtrack.setCola(pedidoVtas.getCola());
            pedidoATratarVtrack.setEstado(Integer.valueOf(pedidoVtas.getEstado()));
            pedidosVtrack.add(pedidoATratarVtrack);
        }
        return pedidosVtrack;
    }

    public void tratarListaPedido(List<com.vanesoft.vtrack.core.entidades.Pedido> pedidos)
    {
        Iterator<com.vanesoft.vtrack.core.entidades.Pedido> pedidoIterator = pedidos.iterator();
        while(pedidoIterator.hasNext())
        {
            com.vanesoft.vtrack.core.entidades.Pedido pedidoVtas = pedidoIterator.next();
            System.out.println(pedidoVtas.getCodigoPedido());
            com.vanesoft.vtrack.core.entidades.Pedido pedidoEnBd =
                    buscarPedidoEnVtrack(pedidoVtas.getCodigoPedido());
            if(pedidoEnBd!=null)
            {
                System.out.println("Pedido existe en bd");
            }
            else
            {
                System.out.println("Pedido no existe en bd");
                insertarPedido(pedidoVtas,"dmscanniello@gmail.com");
                enviarCorreoInicioLlenado(pedidoVtas,"dmscanniello@gmail.com");
                System.out.println("insertemandecorreo");
            }

        }
        actualizarSincronizacion(getHoraActual());
    }

    public com.vanesoft.vtrack.core.entidades.Pedido buscarPedidoEnVtrack(int codigoPedido)
    {
        ComandoBuscarPedidoXCodigo comandoBuscarPedidoXCodigo =
                FabricaComando.obtenerComandoBuscarPedidoXCodigo(String.valueOf(codigoPedido));
               return comandoBuscarPedidoXCodigo.ejecutar();
    }

    public void insertarPedido(com.vanesoft.vtrack.core.entidades.Pedido pedidoInsertar
            ,String correoCliente)
    {
        ComandoInsertarPedidoXCorreoCliente comandoInsertarPedidoXCorreoCliente =
                FabricaComando.obtenerComandoInsertarPedidoXCorreoCliente(pedidoInsertar
                        ,correoCliente);
        comandoInsertarPedidoXCorreoCliente.ejecutar();
    }

    public void testEnviarCorreoInicioLlenado()
    {
        try
        {
            IDAOUsuario daoUsuario = FabricaDAO.obtenerDAOUsuario();
            IDAOCorreo daoCorreo = FabricaDAO.obtenerDAOCorreo();
            IDAOPedido idaoPedido = FabricaDAO.obtenerDAOPedido();
            Pedido pedidoEnviar = idaoPedido.consultarPedidosXCodigo("1");
            usuario usuarioEnBd = daoUsuario.buscarUsuarioXCorreoElectronico("dmscanniello@gmail.com");
            daoCorreo.armarCorreoPedidoEstado(usuarioEnBd,pedidoEnviar, "pruebita");
        }catch (Exception e){

        }
    }*/ /*

    public void actualizarSincronizacion(String tiempo)
    {
        ComandoModificarSincronizacion comandoModificarSincronizacion =
                FabricaComando.obtenerComandoModificarSincronizacion(tiempo);
        comandoModificarSincronizacion.ejecutar();
    }

    public static String getHoraActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
        return formateador.format(ahora);
    }




    public void testInsertarPedido()
    {
        Pedido pedido1 = new Pedido();
        pedido1.setCABEZOTE("QWE-123");
        pedido1.setCOLA("123-QWE");
        pedido1.setCHOFER("DANIEL MONTIEL");
        pedido1.setCLIENTE("dmscanniello@gmail.com");
        pedido1.setFIN("2017-03-10 10:34:09.000");
        pedido1.setINICIO("2017-03-10 10:34:09.000");
        pedido1.setSOLICITUD("2017-03-10 10:34:09.000");
        pedido1.setNUMERO("118");
        pedido1.setESTADO(BigInteger.valueOf(0));
        IDAOPedido idaoPedido = FabricaDAO.obtenerDAOPedido();
        idaoPedido.insertarPedidoXCorreoCliente(pedido1);
    }

    public void testEnviCorreoFinalizoPedido()
    {
        DAOCorreo daoCorreo = new DAOCorreo();
        DAOUsuario daoUsuario = new DAOUsuario();
        DAOPedido daoPedido = new DAOPedido();
        usuario user = daoUsuario.buscarUsuarioXCorreoElectronico("dmscanniello@gmail.com");
        Pedido ped = daoPedido.consultarPedidosXCodigo("1");
        daoCorreo.armarCorreoPedidoEstado(user,ped, EstadoPedido.llenado);
        assertEquals("hola","hola");
    }

    public void testconfirmarEnvioCorreoInicioLlenado()
    {

        DAOPedido daoPedido = new DAOPedido();
        //daoPedido.confirmarEnvioCorreoInicioLlenado("1");
        assertEquals("hola","hola");
    }*/ /*

    public String getHoraActual() {
        Date ahora = new Date();
        SimpleDateFormat formateadorHora = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat formateadorFecha = new SimpleDateFormat("yyyy-MM-dd");
        return  formateadorFecha.format(ahora) +" "+ formateadorHora.format(ahora);
    }

    public void testGetHoraActual(){
        assertEquals(getHoraActual(),"Hola");
    }
    public void testUpdateEstado(){
        IDAOPedido idaoPedido = FabricaDAO.obtenerDAOPedido();
        idaoPedido.updateEstadoPedido("2",118);
        assertEquals("hola","hola");
    }

    public void testConsultarnotitifacionpedido(){
        IDAOPedido idaoPedido = FabricaDAO.obtenerDAOPedido();
        idaoPedido.consultarEstadoNotificacionesPedidos("118");
        assertEquals("hola","hola");
    }

    public void testEnviarPushEstado(usuario usuarioEnviarPush,Pedido pedido,String estado){
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

    public void testPush()
    {
        IDAOPedido idaoPedido = FabricaDAO.obtenerDAOPedido();
        IDAOUsuario idaoUsuario = FabricaDAO.obtenerDAOUsuario();
        Pedido pedido = idaoPedido.consultarPedidosXCodigo("118");
        usuario usuario = idaoUsuario.buscarUsuarioXCorreoElectronico("dmscanniello@gmail.com");
        testEnviarPushEstado(usuario,pedido,"iniciado");
    }

    public void testEnviarPush(){
        String url = "https://fcm.googleapis.com/fcm/send";

        CloseableHttpClient client = HttpClients.createDefault();
        try {
            HttpPost httpPost = new HttpPost(url);
            notification notificationContenido =
                    new notification("prueba en java", "prueba en java");
            push push = new push("/topics/montiel94", notificationContenido);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(push);
            StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setHeader("Authorization", "key=AIzaSyAAjMPhNWNu_ZtUNc4pQwKAKRU_459AH80");
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



    }*/

    public void testAjuro(){
        assertEquals("prueba","prueba");
    }
}
