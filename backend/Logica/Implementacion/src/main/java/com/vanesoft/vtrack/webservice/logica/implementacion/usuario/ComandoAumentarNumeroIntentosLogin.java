package com.vanesoft.vtrack.webservice.logica.implementacion.usuario;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoUsuario;
import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.webservice.logica.implementacion.ComandoBase;

/**
 * Sistema:             Vtrakc
 * Nombre:              ComandoAumentarNumeroIntentosLogin
 * Descripcion:         Comando encargado de aumentar un intento de login de un usuario
 *
 * @author  montda
 * @version 1.0
 * @since 06/02/2017
 */
public class ComandoAumentarNumeroIntentosLogin extends ComandoBase<Boolean> {

    //region atributos
        IDaoUsuario daoUsuario = FabricaDao.obtenerDaoUsuario();
        usuario usuarioEnBd;
    //end region

    public ComandoAumentarNumeroIntentosLogin (usuario usuarioEnBd)
    {
        this.usuarioEnBd = usuarioEnBd;
    }
    @Override
    public Boolean ejecutar()
    {
        try
        {
           return daoUsuario.aumentarNumeroIntentosLogin(usuarioEnBd);
        }
        catch (Exception e)
        {

        }
        return false;
    }
}
