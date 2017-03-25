package com.vanesoft.vtrack.webservice.logica.implementacion.evento;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoEvento;
import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.core.entidades.Evento;
import com.vanesoft.vtrack.core.excepciones.LogicaException;
import com.vanesoft.vtrack.webservice.logica.implementacion.ComandoBase;

import java.util.ArrayList;

/**
 * Created by Daniel jose on 21/03/2017.
 */
public class ComandoConsultarEventosXPedido extends ComandoBase<ArrayList<Evento>>{

    String codigoPedido;
    IDaoEvento daoEvento = FabricaDao.obtenerDaoEvento();
    ArrayList<Evento> eventosEnBd = new ArrayList<Evento>();

    public ComandoConsultarEventosXPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public ArrayList<Evento> ejecutar()
    {
        try
        {
            eventosEnBd = daoEvento.bucarEventosXPedido(codigoPedido);
        }
        catch (Exception e)
        {
            throw new LogicaException(e.getMessage());
        }
        return eventosEnBd;
    }
}
