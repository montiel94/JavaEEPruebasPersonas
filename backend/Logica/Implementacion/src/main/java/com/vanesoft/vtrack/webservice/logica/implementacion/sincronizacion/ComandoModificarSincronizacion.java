package com.vanesoft.vtrack.webservice.logica.implementacion.sincronizacion;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoSincronizacion;
import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.webservice.logica.implementacion.ComandoBase;

/**
 * Created by Daniel jose on 04/04/2017.
 */
public class ComandoModificarSincronizacion extends ComandoBase<Boolean> {

    IDaoSincronizacion daoSincronizacion = FabricaDao.obtenerDaoSincronizacion();
    String Tiempo;

    public ComandoModificarSincronizacion(String tiempo) {
        Tiempo = tiempo;
    }

    public Boolean ejecutar(){
        Boolean exito = false;
        try{
            exito = daoSincronizacion.modificarSincronizacion(Tiempo);

        }catch (Exception e){

        }
        return exito;
    }
}
