package com.vanesoft.vtrack.webservice.logica.implementacion.sincronizacion;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoSincronizacion;
import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.webservice.logica.implementacion.ComandoBase;

/**
 * Created by Daniel jose on 04/04/2017.
 */
public class ComandoConsultarSincronizacion extends ComandoBase<String> {

    IDaoSincronizacion daoSincronizacion = FabricaDao.obtenerDaoSincronizacion();

    public ComandoConsultarSincronizacion() {
    }

    public String ejecutar(){
        String retorno = "";
        try{

            retorno = daoSincronizacion.consultarSincronizacion();

        }catch (Exception e){

        }
        return retorno;
    }
}
