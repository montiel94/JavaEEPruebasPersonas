package com.vanesoft.vtrack.core.accesodatos.contratos;

/**
 * Created by Daniel jose on 04/04/2017.
 */
public interface IDaoSincronizacion {

    public boolean modificarSincronizacion(String tiempo);

    public String consultarSincronizacion();

}
