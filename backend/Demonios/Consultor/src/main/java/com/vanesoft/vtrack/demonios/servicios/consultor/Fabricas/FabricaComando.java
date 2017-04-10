package com.vanesoft.vtrack.demonios.servicios.consultor.Fabricas;

import com.vanesoft.vtrack.demonios.servicios.consultor.Comandos.*;
import com.vanesoft.vtrack.demonios.servicios.consultor.soapvtassimulacion.Pedido;


import java.util.List;

/**
 * Created by Daniel jose on 07/04/2017.
 */
public final class  FabricaComando {

    public static ComandoConvertirListaVtas obtenerComandoConvertirListaVtas
            (List<Pedido> listaVtas) {

        return new ComandoConvertirListaVtas(listaVtas);
    }

    public static ComandoBuscarPedidoXCodigo obtenerComandoBuscarPedidoXCodigo
            (String codigoPedido) {

        return new ComandoBuscarPedidoXCodigo(codigoPedido);
    }

    public static ComandoTratarListaVtrack obtenerComandoTratarListaVtrack
            (List<com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.Pedido> listaVtrack) {

        return new ComandoTratarListaVtrack(listaVtrack);
    }

    public static ComandoInsertarPedido obtenerComandoInsertarPedido
            (com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.Pedido pedido) {

        return new ComandoInsertarPedido(pedido);
    }

    public static ComandoSincronizar obtenerComandoSincronizar
            (String tiempoAInsertar) {

        return new ComandoSincronizar(tiempoAInsertar);
    }

    public static ComandoGetHoraActual obtenerComandoGetHoraActual(){
        return new ComandoGetHoraActual();
    }

    public static ComandoModificarPedido obtenerComandoModificarPedido
            (com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.Pedido pedido)
    {
        return new ComandoModificarPedido(pedido);
    }

    public static ComandoIniciarControlNotificaciones obtenerComandoIniciarControlNotificaciones
            (String codigoPedido)
    {
        return new ComandoIniciarControlNotificaciones(codigoPedido);
    }

    public static ComandoConsultarEstadoNotificacionPedido obtenerComandoConsultarEstadoNotificacionPedido(String codigoPedido)
    {
        return new ComandoConsultarEstadoNotificacionPedido(codigoPedido);
    }


}
