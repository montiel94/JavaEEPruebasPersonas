package com.vanesoft.vtrack.core.accesodatos.contratos;

import com.vanesoft.vtrack.core.entidades.usuario;

/**
 * Created by Daniel jose on 09/02/2017.
 */
public interface IDaoCorreo {

    public void envioCorreoUsuarioXIntentosLogin (usuario usuarioEnviarCorreo);

    public String generarContrasenaProvisional(int longitud);

    public Boolean envioCorreoUsuarioParametrizado (usuario usuarioEnviarCorreo,String tipoPlantillaa);

}
