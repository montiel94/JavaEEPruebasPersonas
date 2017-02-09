package com.vanesoft.vtrack.core.accesodatos.contratos;

import java.util.ArrayList;

/**
 * Created by Daniel jose on 09/02/2017.
 */
public interface IDaoParametro {

    public ArrayList<String> consultarParametrosXPlantilla(String nombrePlantilla);
}
