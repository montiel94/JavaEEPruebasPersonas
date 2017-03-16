package com.vanesoft.vtrack.webservice.logica.implementacion.seguridad;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoCodigoToken;
import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.core.excepciones.LogicaException;

/**
 * Sistema:             Vtrack
 * Nombre:              ComandoEliminarToken
 * Descripcion:         Implementación del proceso para eliminar token con OAuth2
 *
 * @author Montda
 * @version 1.0
 * @since 03/02/2017
 */
public class ComandoEliminarToken extends ComandoSeguridad{

    //region atributes
    IDaoCodigoToken daoCodigoToken =
            FabricaDao.obtenerDaoCodigoToken();
    String codigoToken;
    // end region


    public ComandoEliminarToken(String codigoToken) {
        this.codigoToken = codigoToken;
    }

    /*
        Descripcion : metodo que ejecuta el comando o funcion encapsulada
        @author : montda
        @since : 03/02/2017
     */
    public Boolean ejecutar()
    {
        Boolean exito = false;
        try
        {
            exito = daoCodigoToken.eliminarToken(codigoToken);
            return exito;
        }
        catch (LogicaException e)
        {

        }
        return exito;
    }
}
