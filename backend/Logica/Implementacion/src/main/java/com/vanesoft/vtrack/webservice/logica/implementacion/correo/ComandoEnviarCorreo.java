package com.vanesoft.vtrack.webservice.logica.implementacion.correo;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoCorreo;
import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.webservice.logica.implementacion.ComandoBase;

/**
 * Created by Daniel jose on 08/02/2017.
 */
public class ComandoEnviarCorreo extends ComandoBase<Boolean> {

    IDaoCorreo daoCorreo = FabricaDao.obtenerDaoCorreo();
    usuario usuarioEnviandoCorreo = null;
    public ComandoEnviarCorreo(usuario usuarioEnviandoCorreo) {
        this.usuarioEnviandoCorreo = usuarioEnviandoCorreo;
    }

    public Boolean ejecutar(){

        daoCorreo.envioCorreoUsuarioXIntentosLogin(usuarioEnviandoCorreo);
        return true;
    }
}
