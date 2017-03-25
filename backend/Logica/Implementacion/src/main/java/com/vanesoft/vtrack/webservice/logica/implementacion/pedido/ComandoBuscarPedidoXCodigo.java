package com.vanesoft.vtrack.webservice.logica.implementacion.pedido;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoPedido;
import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.core.entidades.Pedido;
import com.vanesoft.vtrack.core.excepciones.LogicaException;
import com.vanesoft.vtrack.webservice.logica.implementacion.ComandoBase;

/**
 * Created by Daniel jose on 21/03/2017.
 */
public class ComandoBuscarPedidoXCodigo extends ComandoBase<Pedido>
{
    String codigoPedido;
    IDaoPedido daoPedido = FabricaDao.obtenerDaoPedido();
    Pedido pedidoEnBd;

    public ComandoBuscarPedidoXCodigo(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Pedido ejecutar()
    {
        try
        {
            pedidoEnBd = daoPedido.consultarPedidosXCodigo(codigoPedido);

        }
        catch (Exception e)
        {
           throw  new LogicaException(e.getMessage());
        }
        return pedidoEnBd;
    }
}
