package com.vanesoft.vtrack.webservice.logica.implementacion.pedido;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoPedido;
import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.core.entidades.Pedido;
import com.vanesoft.vtrack.core.excepciones.LogicaException;
import com.vanesoft.vtrack.webservice.logica.implementacion.ComandoBase;

import java.util.ArrayList;

/**
 * Created by Daniel jose on 15/03/2017.
 */
public class ComandoBuscarPedidosXEmpresa extends ComandoBase<ArrayList<Pedido>> {

    String correoEmpresa;
    IDaoPedido daoPedido = FabricaDao.obtenerDaoPedido();

    public ComandoBuscarPedidosXEmpresa(String correoEmpresa) {
        this.correoEmpresa = correoEmpresa;
    }

    public ArrayList<Pedido> ejecutar()
    {
        ArrayList<Pedido> retorno = new ArrayList<Pedido>();
        try
        {
            retorno = daoPedido.consultarPedidosXEmpresa(correoEmpresa);
        }catch (Exception e)
        {
            throw new LogicaException(e.getMessage());
        }
        return retorno;
    }
}
