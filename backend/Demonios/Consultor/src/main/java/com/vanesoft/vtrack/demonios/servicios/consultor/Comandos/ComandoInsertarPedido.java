package com.vanesoft.vtrack.demonios.servicios.consultor.Comandos;

import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.IDAOPedido;
import com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.Pedido;
import com.vanesoft.vtrack.demonios.servicios.consultor.Fabricas.FabricaDAO;

/**
 * Created by Daniel jose on 08/04/2017.
 */
public class ComandoInsertarPedido extends ComandoBase<Boolean>{

    IDAOPedido idaoPedido = FabricaDAO.obtenerDAOPedido();
    Pedido pedidoNuevo;

    public ComandoInsertarPedido(Pedido pedidoNuevo) {
        this.pedidoNuevo = pedidoNuevo;
    }

    public Boolean ejecutar(){

        System.out.println("Entrando al metodo Ejecutar de ComandooInsertarPedido");
        Boolean exito = false;
        try{
            exito = idaoPedido.insertarPedidoXCorreoCliente(pedidoNuevo);
        }catch (Exception e)
        {

        }
        System.out.println("Saliendo del metodo Ejecutar de ComandooInsertarPedido");
        return exito;
    }
}
