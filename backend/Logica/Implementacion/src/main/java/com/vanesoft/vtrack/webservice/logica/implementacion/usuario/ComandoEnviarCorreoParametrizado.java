package com.vanesoft.vtrack.webservice.logica.implementacion.usuario;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoCorreo;
import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.webservice.logica.implementacion.ComandoBase;
import sun.org.mozilla.javascript.internal.EcmaError;

/**
 * Created by Daniel jose on 22/02/2017
 * Comando que envia correo segun el parametro pasado.
 */
public class ComandoEnviarCorreoParametrizado extends ComandoBase<Boolean>
{
    //region atributes
    String tipoCorreo = null;
    IDaoCorreo daoCorreo = FabricaDao.obtenerDaoCorreo();
    usuario usuarioEnBd = null;
    //end region


    public ComandoEnviarCorreoParametrizado(String tipoCorreo, usuario usuarioEnBd) {
        this.tipoCorreo = tipoCorreo;
        this.usuarioEnBd = usuarioEnBd;
    }

    public Boolean ejecutar()
    {
        Boolean exito = false;
        try
        {
            exito = daoCorreo.envioCorreoUsuarioParametrizado(usuarioEnBd, tipoCorreo);
        }
        catch (Exception e)
        {

        }
        return exito;
    }
}
