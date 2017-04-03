package com.vanesoft.vtrack.webservice.servicioactualizador.contratos;

import javax.jws.WebMethod;


/**
 * Created by Daniel jose on 02/04/2017.
 */

public interface IWSActualizaor {
    /**
     * Nombre:                  actualizarEstado Descripcion:  metodo que actualiza
     * estado de un pedido
     * @param codigoPedido pedido a actualizar estado
     * @param codigoEstado estado en que se encuentra el pedido
     * @return int 1 en caso de exito 0 en caso de error
     *
     * @author Montda
     * @version 1.0
     */
    @WebMethod
    public void actualizarEstado(int codigoPedido, int codigoEstado);

}
