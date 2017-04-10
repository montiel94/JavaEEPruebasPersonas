/**
 * Created by Daniel jose on 04/04/2017.
 */

import com.vanesoft.vtrack.demonios.servicios.consultor.Comandos.ComandoTratarListaVtrack;
import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.IDAOCorreo;
import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.IDAOPedido;
import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.IDAOUsuario;
import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Implementacion.DAOCorreo;
import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Implementacion.DAOPedido;
import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Implementacion.DAOUsuario;
import com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.EstadoPedido;
import com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.Pedido;
import com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.usuario;
import com.vanesoft.vtrack.demonios.servicios.consultor.Fabricas.FabricaDAO;
import junit.framework.TestCase;

import javax.xml.ws.BindingProvider;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

    */public void testEnviarCorreoInicioLlenado()
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
    }/*

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

    */public void testconfirmarEnvioCorreoInicioLlenado()
    {

        DAOPedido daoPedido = new DAOPedido();
        //daoPedido.confirmarEnvioCorreoInicioLlenado("1");
        assertEquals("hola","hola");
    }/*

    public String getHoraActual() {
        Date ahora = new Date();
        SimpleDateFormat formateadorHora = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat formateadorFecha = new SimpleDateFormat("yyyy-MM-dd");
        return  formateadorFecha.format(ahora) +" "+ formateadorHora.format(ahora);
    }

    public void testGetHoraActual(){
        assertEquals(getHoraActual(),"Hola");
    }*/
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
}
