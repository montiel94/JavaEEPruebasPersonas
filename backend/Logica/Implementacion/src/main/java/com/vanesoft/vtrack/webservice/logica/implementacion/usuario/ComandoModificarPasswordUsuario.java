package com.vanesoft.vtrack.webservice.logica.implementacion.usuario;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoUsuario;
import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.core.utilidades.propiedades.CifrarDescifrar;
import com.vanesoft.vtrack.webservice.logica.implementacion.ComandoBase;

/**
 * Sistema:             Vtrakc
 * Nombre:              ComandoModificarPasswordUsuario
 * Descripcion:         Comando encargado de modificar el password de un usuario
 *
 * @author  montda
 * @version 1.0
 * @since 14/02/2017
 */
public class ComandoModificarPasswordUsuario extends ComandoBase<Boolean> {

    //region atributos
        usuario usuarioBusqueda = null;
        String passwordNueva = null;
        IDaoUsuario daoUsuario = FabricaDao.obtenerDaoUsuario();
    //end region

    //Constructor
    public ComandoModificarPasswordUsuario (usuario usuarioBusqueda,String passwordNueva)
    {
        this.usuarioBusqueda = usuarioBusqueda;
        this.passwordNueva = passwordNueva;
    }

    public Boolean ejecutar ()
    {
        try {
            daoUsuario.modificarContrasenaUsuario(usuarioBusqueda,
                    CifrarDescifrar.cifrar(passwordNueva));
            return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }
}
