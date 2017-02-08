package com.vanesoft.vtrack.webservice.logica.implementacion.usuario;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoUsuario;
import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.webservice.logica.implementacion.ComandoBase;

/**
 * Sistema:             Vtrakc
 * Nombre:              ComandoVerficarBloqueoUsuario
 * Descripcion:         Comando encargado de verificar el numero de intentos de llogin de un usuario
 *                      si es lleva 3 intentos bloqueara al usuario
 *
 * @author  montda
 * @version 1.0
 * @since 07/02/2017
 */
public class ComandoVerificarBloqueoUsuario extends ComandoBase<Integer>
{
    //region atributos
    IDaoUsuario daoUsuario = FabricaDao.obtenerDaoUsuario();
    usuario usuarioEnBd;
    //end region

    //constructor
    public ComandoVerificarBloqueoUsuario (usuario usuarioEnBd){this.usuarioEnBd=usuarioEnBd;}

    public Integer ejecutar()
    {
        usuarioEnBd = daoUsuario.ConsultarNumeroIntentosLoginUsuario(usuarioEnBd);
        return usuarioEnBd.getIntentosLogin();
    }
}
