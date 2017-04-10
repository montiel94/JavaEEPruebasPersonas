package com.vanesoft.vtrack.demonios.servicios.consultor.Comandos;

import com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.Pedido;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Daniel jose on 07/04/2017.
 */
public class ComandoConvertirListaVtas extends ComandoBase<List<Pedido>>{
    List<com.vanesoft.vtrack.demonios.servicios.consultor.soapvtassimulacion.Pedido>
            listaVtas;
    List<Pedido> listaVtrack = new ArrayList<Pedido>();
    public ComandoConvertirListaVtas(List<com.vanesoft.vtrack.demonios.servicios.consultor.soapvtassimulacion.Pedido> listaVtas) {
        this.listaVtas = listaVtas;
    }

    public List<Pedido> ejecutar (){

        Iterator<com.vanesoft.vtrack.demonios.servicios.consultor.soapvtassimulacion.Pedido>
                iteratorListaVtas = listaVtas.iterator();
        while (iteratorListaVtas.hasNext()){
            Pedido pedidoVtrack = new Pedido();
            com.vanesoft.vtrack.demonios.servicios.consultor.soapvtassimulacion.Pedido pedidoEnVtas=
                    iteratorListaVtas.next();
            pedidoVtrack.setESTADO(pedidoEnVtas.getESTADO());
            pedidoVtrack.setNUMERO(pedidoEnVtas.getNUMERO());
            pedidoVtrack.setSOLICITUD(pedidoEnVtas.getSOLICITUD());
            pedidoVtrack.setFIN(pedidoEnVtas.getFIN());
            pedidoVtrack.setINICIO(pedidoEnVtas.getINICIO());
            pedidoVtrack.setCHOFER(pedidoEnVtas.getCHOFER());
            pedidoVtrack.setCABEZOTE(pedidoEnVtas.getCABEZOTE());
            pedidoVtrack.setCOLA(pedidoEnVtas.getCOLA());
            pedidoVtrack.setCLIENTE(pedidoEnVtas.getCLIENTE());
            listaVtrack.add(pedidoVtrack);
            System.out.println("Pedido numero :" +pedidoEnVtas.getNUMERO());
        }
        return listaVtrack;
    }
}
