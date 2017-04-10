package com.vanesoft.vtrack.demonios.servicios.consultor.Comandos;

import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.IDAOPedido;
import com.vanesoft.vtrack.demonios.servicios.consultor.Fabricas.FabricaDAO;

/**
 * Created by Daniel jose on 09/04/2017.
 */
public class ComandoIniciarControlNotificaciones extends ComandoBase<Boolean>{
    IDAOPedido idaoPedido = FabricaDAO.obtenerDAOPedido();
    String codigoPedido;

    public ComandoIniciarControlNotificaciones(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Boolean ejecutar(){
        Boolean exito = false;
        try{

            exito = idaoPedido.iniciarControlNotificacionesPedido(codigoPedido);
        }catch (Exception e){

        }
        return exito;
    }
}
