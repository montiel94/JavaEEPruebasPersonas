package com.vanesoft.vtrack.webservice.logica.implementacion.pedido;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoPedido;
import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.core.entidades.Pedido;
import com.vanesoft.vtrack.webservice.logica.implementacion.ComandoBase;

/**
 * Created by Daniel jose on 04/04/2017.
 */
public class ComandoInsertarPedidoXCorreoCliente extends ComandoBase<Boolean> {
    Pedido pedidoInsertar;
    IDaoPedido daoPedido = FabricaDao.obtenerDaoPedido();
    String correoCliente;


    public ComandoInsertarPedidoXCorreoCliente(Pedido pedidoInsertar, String correoCliente) {
        this.pedidoInsertar = pedidoInsertar;
        this.correoCliente = correoCliente;
    }

    public Boolean ejecutar(){
        Boolean exito = false;
        try{

            exito = daoPedido.insertarPedidoXCorreoCliente(pedidoInsertar,correoCliente);

        }catch (Exception e){

        }
        return exito;
    }
}
