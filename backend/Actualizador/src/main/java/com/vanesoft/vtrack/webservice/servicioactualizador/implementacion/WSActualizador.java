package com.vanesoft.vtrack.webservice.servicioactualizador.implementacion;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.Pedido;
import com.vanesoft.vtrack.webservice.servicioactualizador.contratos.IWSActualizaor;
import com.vanesoft.vtrack.demonios.servicios.consultor.soapvtas.RespuestaPedidos;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Daniel jose on 02/04/2017.
 */
@WebService( name = "WSActualizador" )
public class WSActualizador implements IWSActualizaor{

    @WebMethod
    public List<Pedido> actualizarEstado(int codigoPedido, int codigoEstado){

        return getAllPedidos();
    }

    public static String getHoraActual() {
        Date ahora = new Date();
        SimpleDateFormat formateadorHora = new SimpleDateFormat("hh:mm:ss");
        SimpleDateFormat formateadorFecha = new SimpleDateFormat("yyyy-MM-dd");
        return formateadorHora.format(ahora) + " " + formateadorFecha.format(ahora);
    }





    public List<Pedido> getAllPedidos()
    {

        List<Pedido> pedidos = new ArrayList<Pedido>();
        Pedido pedido1 = new Pedido();
        Pedido pedido2 = new Pedido();
        Pedido pedido3 = new Pedido();
        pedido1.setCABEZOTE("ZXC-123");
        pedido1.setCOLA("123-456");
        pedido1.setCHOFER("JAIME FEDERICO");
        pedido1.setCLIENTE("dmscanniello@gmail.com");
        pedido1.setFIN("2017-03-10 10:34:09.000");
        pedido1.setINICIO("2017-03-10 10:34:09.000");
        pedido1.setSOLICITUD("2017-03-10 10:34:09.000");
        pedido1.setNUMERO("118");
        pedido1.setESTADO(BigInteger.valueOf(7));
        pedido2.setCABEZOTE("ZXC-123");
        pedido2.setCOLA("123-456");
        pedido2.setCHOFER("PEDRO LOPEZ");
        pedido2.setCLIENTE("dmscanniello@gmail.com");
        pedido2.setFIN("2017-03-10 10:34:09.000");
        pedido2.setINICIO("2017-03-10 10:34:09.000");
        pedido2.setSOLICITUD("2017-03-10 10:34:09.000");
        pedido2.setNUMERO("119");
        pedido2.setESTADO(BigInteger.valueOf(7));
        pedido3.setCABEZOTE("ZXC-123");
        pedido3.setCOLA("123-456");
        pedido3.setCHOFER("PADRINO LOPEZ");
        pedido3.setCLIENTE("dmscanniello@gmail.com");
        pedido3.setFIN("2017-03-10 10:34:09.000");
        pedido3.setINICIO("2017-03-10 10:34:09.000");
        pedido3.setSOLICITUD("2017-03-10 10:34:09.000");
        pedido3.setNUMERO("120");
        pedido3.setESTADO(BigInteger.valueOf(7));
        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);
        return pedidos;
    }

}
