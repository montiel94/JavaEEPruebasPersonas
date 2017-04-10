package com.vanesoft.vtrack.core.accesodatos.contratos;

import com.vanesoft.vtrack.core.entidades.Evento;

import java.util.ArrayList;

/**
 * Sistema:             Vtrack
 * Nombre:              IDaoEvento
 * Descripcion:         Contrato del dao dedicado a las operaciones con eventos de los pedidos
 *
 * @author montda
 * @version 1.0
 * @since 04/02/2017
 */
public interface IDaoEvento {

    /**
     * Descripcion: metodo que busca los eventos de un pedido
     *
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */

    public ArrayList<Evento> bucarEventosXPedido(String codigoPedido);

}
