package com.vanesoft.vtrack.core.accesodatos.contratos;

import com.vanesoft.vtrack.core.entidades.Evento;

import java.util.ArrayList;

/**
 * Created by Daniel jose on 21/03/2017.
 */
public interface IDaoEvento {

    public ArrayList<Evento> bucarEventosXPedido(String codigoPedido);

}
