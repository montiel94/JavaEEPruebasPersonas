package com.vanesoft.vtrack.webservice.logica.implementacion.pedido;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoPedido;
import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.webservice.logica.implementacion.ComandoBase;

/**
 * Created by Daniel jose on 02/04/2017.
 */
public class ComandoModificarEstadoPedidoXCodigo extends ComandoBase<Boolean> {

    String codigoPedido;
    String estadoPedido;
    IDaoPedido daoPedido = FabricaDao.obtenerDaoPedido();

    public ComandoModificarEstadoPedidoXCodigo(String codigoPedido, String estadoPedido) {
        this.codigoPedido = codigoPedido;
        this.estadoPedido = estadoPedido;
    }

    public Boolean ejecutar(){
        Boolean exito = false;
        try{
            exito = daoPedido.modificarEstadoPedidoXCodigo(codigoPedido,estadoPedido);

        }catch (Exception e){

        }
        return true;
    }
}
