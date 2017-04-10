package com.vanesoft.vtrack.demonios.servicios.consultor.Comandos;

import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.IDAOSincronizacion;
import com.vanesoft.vtrack.demonios.servicios.consultor.Fabricas.FabricaDAO;

/**
 * Created by Daniel jose on 09/04/2017.
 */
public class ComandoSincronizar extends ComandoBase<String> {

    IDAOSincronizacion idaoSincronizacion = FabricaDAO.obtenerDAOSincronizacion();
    String tiempoAInsertar;
    String tiempoAConsultar;

    public ComandoSincronizar(String tiempoAInsertar) {
        this.tiempoAInsertar = tiempoAInsertar;
    }

    public String ejecutar(){
        try{
            tiempoAConsultar = idaoSincronizacion.consultarSincronizacion();
            idaoSincronizacion.modificarSincronizacion(tiempoAInsertar);
        }catch (Exception e)
        {

        }
        return tiempoAConsultar;
    }
}
