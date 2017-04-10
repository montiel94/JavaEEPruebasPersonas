package com.vanesoft.vtrack.demonios.servicios.consultor.Comandos;

import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.IDAOCorreo;
import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.IDAOPedido;
import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.IDAOUsuario;
import com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.EstadoNotificacion;
import com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.EstadoPedido;
import com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.Pedido;
import com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.usuario;
import com.vanesoft.vtrack.demonios.servicios.consultor.Fabricas.FabricaComando;
import com.vanesoft.vtrack.demonios.servicios.consultor.Fabricas.FabricaDAO;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Daniel jose on 07/04/2017.
 */
public class ComandoTratarListaVtrack extends ComandoBase<Boolean>{
    List<Pedido> listaPedidosVtrack;
    IDAOPedido idaoPedido = FabricaDAO.obtenerDAOPedido();
    Pedido pedidoEnBd = null;
    Pedido pedidoEnlista = null;


    public ComandoTratarListaVtrack(List<Pedido> listaPedidosVtrack) {
        this.listaPedidosVtrack = listaPedidosVtrack;
    }

    public Boolean ejecutar()
    {
        System.out.println("Entrando al metodo ejecutar de comandoTratarLista");
        Boolean exito = false;
        Iterator<Pedido> iteratorPedido = listaPedidosVtrack.iterator();
        while (iteratorPedido.hasNext())
        {
            pedidoEnBd = null;
            pedidoEnlista = iteratorPedido.next();
            pedidoEnBd = buscarPedido(pedidoEnlista.getNUMERO());
            if (pedidoEnBd==null)
            {
                System.out.println("Pedido no existe en Bd");
                tratarPedidoNoExistenteEnVtrack(pedidoEnlista);
                enviarCorreoInicioLlenado(pedidoEnlista);
            }else
            {
                System.out.println("pedido existe en bd");
                actualizarPedido(pedidoEnlista);
                if (pedidoEnlista.getESTADO().intValue() == 7)
                {
                    verificarEnvioCorreoPedidoTerminado(pedidoEnlista);
                }

            }
        }
        System.out.println("Saliendo del metodo ejecutar de comandoTratLista");
        return exito;

    }

    public void verificarEnvioCorreoPedidoTerminado(Pedido pedido)
    {
        System.out.println("Entrando al metodo verificarEnvioCorreoPedidoTerminado(");
        try {
            ComandoConsultarEstadoNotificacionPedido comandoConsultarEstadoNotificacionPedido =
                    FabricaComando.obtenerComandoConsultarEstadoNotificacionPedido(pedido.getNUMERO());
            Hashtable<String, String> estados = comandoConsultarEstadoNotificacionPedido.ejecutar();
            if (estados.get(EstadoNotificacion.nombreNotificacionCorreo).equals(EstadoNotificacion.enviadoCorreoPedidoInicioLLenado)) {
                System.out.println("Debo enviar correo");
                enviarCorreoTerminoLlenado(pedido);
            }
        }
        catch (Exception e){

        }

    }

    public void actualizarPedido(Pedido pedidoEnlista){

        try{
            ComandoModificarPedido comandoModificarPedido =
                    FabricaComando.obtenerComandoModificarPedido(pedidoEnlista);
            comandoModificarPedido.ejecutar();
        }catch (Exception e){

        }
    }

    public void tratarPedidoNoExistenteEnVtrack(Pedido pedido)
    {
        System.out.println("entrando al metodo tratarPedidoNoExistenteEnVtrack");
        ComandoInsertarPedido comandoInsertarPedido =
                FabricaComando.obtenerComandoInsertarPedido(pedido);
        comandoInsertarPedido.ejecutar();
        ComandoIniciarControlNotificaciones comandoIniciarControlNotificaciones =
                FabricaComando.obtenerComandoIniciarControlNotificaciones(pedido.getNUMERO());
        comandoIniciarControlNotificaciones.ejecutar();
        System.out.println("saliendo del metodo tratarPedidoNoExistenteEnVtrack");
    }

    public void enviarCorreoTerminoLlenado(Pedido pedidoTerminado){
        try{
            IDAOUsuario idaoUsuario = FabricaDAO.obtenerDAOUsuario();
            IDAOCorreo idaoCorreo = FabricaDAO.obtenerDAOCorreo();
            IDAOPedido idaopedido = FabricaDAO.obtenerDAOPedido();
            usuario usuarioDuenoPedido =
                    idaoUsuario.buscarUsuarioXCorreoElectronico(pedidoTerminado.getCLIENTE());
            idaoCorreo.armarCorreoPedidoEstado(usuarioDuenoPedido,pedidoTerminado,EstadoPedido.llenado);
            idaopedido.confirmarEnvioCorreo(pedidoTerminado.getNUMERO(),EstadoNotificacion.enviadoCorreoPedidoTerminoLLenado);
        }
        catch (Exception e)
        {

        }
    }

    public void enviarCorreoInicioLlenado(Pedido pedidonuevo){
        try {
            IDAOUsuario idaoUsuario = FabricaDAO.obtenerDAOUsuario();
            IDAOCorreo idaoCorreo = FabricaDAO.obtenerDAOCorreo();
            IDAOPedido idaoPedido = FabricaDAO.obtenerDAOPedido();
            usuario usuarioDuenoPedido =
                    idaoUsuario.buscarUsuarioXCorreoElectronico(pedidonuevo.getCLIENTE());
            idaoCorreo.armarCorreoPedidoEstado(usuarioDuenoPedido, pedidonuevo, EstadoPedido.enCola);
            idaoPedido.confirmarEnvioCorreo(pedidonuevo.getNUMERO(), EstadoNotificacion.enviadoCorreoPedidoInicioLLenado);

        }catch (Exception e)
        {

        }
    }

    public Pedido buscarPedido(String codigoPedido)
    {
        Pedido pedidoEnBd = null;
        try
        {
            ComandoBuscarPedidoXCodigo comandoBuscarPedidoXCodigo =
                    FabricaComando.obtenerComandoBuscarPedidoXCodigo(codigoPedido);

            return comandoBuscarPedidoXCodigo.ejecutar();
        }catch (Exception e)
        {

        }
        return pedidoEnBd;
    }
}
