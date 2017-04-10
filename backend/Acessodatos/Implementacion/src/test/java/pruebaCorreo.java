/**
 * Created by Daniel jose on 08/02/2017.
 */
import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoEvento;
import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoUsuario;
import com.vanesoft.vtrack.core.accesodatos.implementacion.DaoCorreo;
import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoPedido;
import com.vanesoft.vtrack.core.accesodatos.implementacion.DaoPedido;
import com.vanesoft.vtrack.core.accesodatos.implementacion.DaoUsuario;
import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.core.entidades.*;
import com.vanesoft.vtrack.core.utilidades.propiedades.CifrarDescifrar;
import junit.framework.TestCase;

import java.util.ArrayList;

public class pruebaCorreo extends TestCase{
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
    }

    public void testEnviarCorreo()
    {
        String mensaje = "Estimado(a) cliente: Shell <BR> <BR> Su usuario registrada en el Sistema Vtrack ha sido bloqueado por realizar login con una contraseña invalida.\\n\\nSe ha generado una contraseña temporal para la recuperacion de este usuario. Su contraseña provicional es la siquiente : n0QSAsRu9VQ0cpp0ydMBMQ==\\n\\nLe recordamos:\\n\\nLa contraseña temporal se genera automáticamente en el tercer intento fallido de login.\\n\\nGracias por utilizar Vtrack.\\n\\nVaneSoft.\\n\\nEsta es una cuenta de correo electrónico no monitoreada, no responda o reenvíe mensajes a esta cuenta.";
        DaoCorreo daoCorreo = new DaoCorreo();
        Correo correoEnviado = new Correo("dmscanniello@gmail.com",
                "dmscanniello@gmail.com",
                "Panta1994-",
                "PRUEBA ASUNTO",
                mensaje);
        daoCorreo.enviarCorreo(correoEnviado);
    }

    public void testGenerarContrasena()
    {
        String contrasena = "hola";
        DaoCorreo daoCorreo = new DaoCorreo();
        assertEquals(contrasena,daoCorreo.generarContrasenaProvisional(8));
    }

    public void testEnviCorreoFinalizoPedido()
    {
        DaoCorreo daoCorreo = new DaoCorreo();
        DaoUsuario daoUsuario = new DaoUsuario();
        DaoPedido daoPedido = new DaoPedido();
        usuario user = daoUsuario.buscarUsuarioXCorreoElectronico("dmscanniello@gmail.com");
        Pedido ped = daoPedido.consultarPedidosXCodigo("1");
        daoCorreo.armarCorreoPedidoEstado(user,ped, EstadoPedido.llenado);
        assertEquals("hola","hola");
    }

    public void testConsultarPedidosXUsuario(){
        IDaoPedido daoPedido = FabricaDao.obtenerDaoPedido();
        ArrayList<Pedido> pedidosEnBd =
                daoPedido.consultarPedidosXEmpresa("dmscanniello@gmail.com");
        assertEquals("hola","chao");
    }

    public void testConsultarEventosXPedido(){
        IDaoEvento daoEvento = FabricaDao.obtenerDaoEvento();
        ArrayList<Evento> eventos =
                daoEvento.bucarEventosXPedido("1");
        assertEquals("hola","chao");
    }

    public void testConsultarPedidoXCodigo(){
        IDaoPedido daoPedido = FabricaDao.obtenerDaoPedido();
        Pedido pedidoEnBd = daoPedido.consultarPedidosXCodigo("1000");
        assertEquals("hola","chao");
    }

    public void testModificarEstadoPedidoXCodgio(){
        IDaoPedido daoPedido = FabricaDao.obtenerDaoPedido();
        daoPedido.modificarEstadoPedidoXCodigo("1","1");
        assertEquals("hola","chao");
    }

    public void testBuscarUsuarioXcodigoPedido(){
        IDaoUsuario daoUsuario = FabricaDao.obtenerDaoUsuario();
        usuario usuarioEnBd = daoUsuario.buscarUsuarioXCodigoPedido("1");
        assertEquals("hola","hola");
    }

    public void testInsertarPedido(){
        IDaoPedido daoPedido = FabricaDao.obtenerDaoPedido();
        Pedido pedidoInsertar = new Pedido(102,
                1,
                "17-03-2017",
                "QWE-123",
                "POI-098",
                "Daniel Jose Montiel Scanniello",
                "10:00:00 AM",
                "4:00:00 PM");
        daoPedido.insertarPedidoXCorreoCliente(pedidoInsertar,"dmscanniello@gmail.com");

    }
}
