package com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos;

import com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.Pedido;

import java.util.Hashtable;

/**
 * Created by Daniel jose on 07/04/2017.
 */
public interface IDAOPedido {

    public boolean iniciarControlNotificacionesPedido(String codigoPedido);

    Pedido consultarPedidosXCodigo(String codigoPedido);

    public boolean insertarPedidoXCorreoCliente(Pedido pedidoAInsertar);

    public Boolean confirmarEnvioCorreo(String codigoPedido,String estadoNotificacion);

    public void updateEstadoPedido(String estadoPedido,int codigoPedido);

    public void updateSolicitudPedido(String solicitud,int codigoPedido);

    public void updateColaPedido(String cola,int codigoPedido);

    public void updateCabezotePedido(String cabezote,int codigoPedido);

    public void updateChoferPedido(String chofer,int codigoPedido);

    public void updateInicioPedido(String inicio,int codigoPedido);

    public Hashtable<String,String> consultarEstadoNotificacionesPedidos(String codigoPedido);
}
