package com.vanesoft.vtrack.core.accesodatos.contratos;

import com.vanesoft.vtrack.core.entidades.Pedido;

import java.util.ArrayList;

/**
 * Sistema:             Vtrack
 * Nombre:              IDaoPedido
 * Descripcion:         Contrato del dao dedicado a las operaciones con pedidos
 *
 * @author montda
 * @version 1.0
 * @since 04/02/2017
 */
public interface IDaoPedido {
    /**
     * Descripcion: metodo que consulta los pedidos de una empresa
     *
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */
    public ArrayList<Pedido> consultarPedidosXEmpresa(String nombreEmpresa);
    /**
     * Descripcion: metodo que consulta un pedido dado su codigo
     *
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */
    public Pedido consultarPedidosXCodigo(String codigoPedido);

    /**
     * Descripcion: metodo que modifica el estado de un pedido
     *
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */

    public Boolean modificarEstadoPedidoXCodigo(String codigoPedido,String Estado);

    /**
     * Descripcion: metodo que modifica el tiempo de finalizacion de un pedido
     *
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */

    public Boolean modificarDateTimeFinPedidoXCodigo(String codigoPedido);

    /**
     * Descripcion: metodo que inserta un pedido dado el correo de un cliente
     *
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */

    public boolean insertarPedidoXCorreoCliente(Pedido pedidoAInsertar,String correo);
}
