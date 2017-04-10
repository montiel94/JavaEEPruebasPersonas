package com.vanesoft.vtrack.demonios.servicios.consultor.Comandos;

import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.IDAOPedido;
import com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.Pedido;
import com.vanesoft.vtrack.demonios.servicios.consultor.Fabricas.FabricaDAO;

/**
 * Created by Daniel jose on 08/04/2017.
 */
public class ComandoBuscarPedidoXCodigo extends ComandoBase<Pedido> {

    IDAOPedido idaoPedido = FabricaDAO.obtenerDAOPedido();
    Pedido pedidoEnBd = null;
    String codigoPedido = "";

    public ComandoBuscarPedidoXCodigo(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Pedido ejecutar(){

        try
        {
            pedidoEnBd = idaoPedido.consultarPedidosXCodigo(codigoPedido);
        }
        catch (Exception e)
        {

        }
        return pedidoEnBd;
    }
}
