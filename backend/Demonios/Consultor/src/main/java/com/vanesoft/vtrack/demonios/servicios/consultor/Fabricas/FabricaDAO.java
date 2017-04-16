package com.vanesoft.vtrack.demonios.servicios.consultor.Fabricas;

import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.*;
import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Implementacion.*;

/**
 * Created by Daniel jose on 07/04/2017.
 */
public final class FabricaDAO {

    public static IDAOPedido obtenerDAOPedido(){
        return new DAOPedido();
    }

    public static IDAOPlantilla obtenerDAOPlantilla(){
        return new DAOPlantilla();
    }

    public static IDAOParametro obtenerDAOParametro(){
        return new DAOParametro();
    }

    public static IDAOUsuario obtenerDAOUsuario(){
        return new DAOUsuario();
    }

    public static IDAOCorreo obtenerDAOCorreo(){
        return new DAOCorreo();
    }

    public static IDAOSincronizacion obtenerDAOSincronizacion(){
        return new DAOSincronizacion();
    }

    public static IDAOPush obtenerDAOPush(){
        return new DAOPush();
    }
}
