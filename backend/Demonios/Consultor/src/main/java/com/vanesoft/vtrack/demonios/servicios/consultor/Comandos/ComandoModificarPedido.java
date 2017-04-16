package com.vanesoft.vtrack.demonios.servicios.consultor.Comandos;

import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.IDAOPedido;
import com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.Pedido;
import com.vanesoft.vtrack.demonios.servicios.consultor.Fabricas.FabricaDAO;

/**
 * Created by Daniel jose on 09/04/2017.
 */
public class ComandoModificarPedido extends ComandoBase<Boolean>{
    IDAOPedido idaoPedido = FabricaDAO.obtenerDAOPedido();
    Pedido pedidoModificando;

    public ComandoModificarPedido(Pedido pedidoModificando) {
        this.pedidoModificando = pedidoModificando;
    }

    public Boolean ejecutar(){
        try{
            idaoPedido.updateEstadoPedido(String.valueOf(pedidoModificando.getESTADO()),
                    Integer.valueOf(pedidoModificando.getNUMERO()));

            idaoPedido.updateSolicitudPedido(pedidoModificando.getSOLICITUD(),
                    Integer.valueOf(pedidoModificando.getNUMERO()));

            idaoPedido.updateColaPedido(pedidoModificando.getCOLA(),
                    Integer.valueOf(pedidoModificando.getNUMERO()));

            idaoPedido.updateCabezotePedido(pedidoModificando.getCABEZOTE(),
                    Integer.valueOf(pedidoModificando.getNUMERO()));

            idaoPedido.updateChoferPedido(pedidoModificando.getCHOFER(),
                    Integer.valueOf(pedidoModificando.getNUMERO()));

            idaoPedido.updateInicioPedido(pedidoModificando.getINICIO(),
                    Integer.valueOf(pedidoModificando.getNUMERO()));


        }catch (Exception e)
        {

        }
        return true;
    }
}
