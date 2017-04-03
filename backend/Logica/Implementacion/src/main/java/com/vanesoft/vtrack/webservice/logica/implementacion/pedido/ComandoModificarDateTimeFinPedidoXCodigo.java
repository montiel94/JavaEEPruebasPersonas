package com.vanesoft.vtrack.webservice.logica.implementacion.pedido;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoPedido;
import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.webservice.logica.implementacion.ComandoBase;

/**
 * Created by Daniel jose on 02/04/2017.
 */
public class ComandoModificarDateTimeFinPedidoXCodigo extends ComandoBase<Boolean>{

    String codigoPedido;
    IDaoPedido daoPedido = FabricaDao.obtenerDaoPedido();

    public ComandoModificarDateTimeFinPedidoXCodigo(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Boolean ejecutar(){
        Boolean exito = false;
        try{
            exito = daoPedido.modificarDateTimeFinPedidoXCodigo(codigoPedido);

        }catch (Exception e){

        }
        return true;
    }
}
