package com.vanesoft.vtrack.core.accesodatos.contratos;

import com.vanesoft.vtrack.core.entidades.Pedido;

import java.util.ArrayList;

/**
 * Created by Daniel jose on 13/03/2017.
 */
public interface IDaoPedido {

    public ArrayList<Pedido> consultarPedidosXEmpresa(String nombreEmpresa);

    public Pedido consultarPedidosXCodigo(String codigoPedido);

    public Boolean modificarEstadoPedidoXCodigo(String codigoPedido,String Estado);

    public Boolean modificarDateTimeFinPedidoXCodigo(String codigoPedido);

}
