package com.vanesoft.vtrack.demonios.servicios.consultor.Comandos;

import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.IDAOPedido;
import com.vanesoft.vtrack.demonios.servicios.consultor.Fabricas.FabricaDAO;

import java.util.Hashtable;

/**
 * Created by Daniel jose on 10/04/2017.
 */
public class ComandoConsultarEstadoNotificacionPedido extends ComandoBase<Hashtable<String,String>> {

    IDAOPedido idaoPedido = FabricaDAO.obtenerDAOPedido();
    String codigoPedido;

    public ComandoConsultarEstadoNotificacionPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Hashtable<String,String> ejecutar(){
        Hashtable<String,String> estados = null;
        try{
            estados = idaoPedido.consultarEstadoNotificacionesPedidos(codigoPedido);
        }catch (Exception e){

        }

        return estados;
    }
}
