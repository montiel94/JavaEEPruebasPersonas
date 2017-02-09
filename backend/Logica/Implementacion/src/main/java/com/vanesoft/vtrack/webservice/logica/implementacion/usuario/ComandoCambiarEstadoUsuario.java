package com.vanesoft.vtrack.webservice.logica.implementacion.usuario;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoUsuario;
import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.webservice.logica.implementacion.ComandoBase;

/**
 * Created by Daniel jose on 08/02/2017.
 */
public class ComandoCambiarEstadoUsuario extends ComandoBase<Boolean> {

    //region atributos
    IDaoUsuario daoUsuario = FabricaDao.obtenerDaoUsuario();
    usuario usuarioEnBd;
    //end region

    public ComandoCambiarEstadoUsuario (usuario usuarioModificando)
    {
        this.usuarioEnBd = usuarioModificando;
    }

    public Boolean ejecutar ()
    {
        try {
            daoUsuario.CambiarEstadoUsuario(usuarioEnBd);
            return daoUsuario.reiniciarIntentosLogin(usuarioEnBd);
        }
        catch (Exception e)
        {

        }
        return false;
    }

}
