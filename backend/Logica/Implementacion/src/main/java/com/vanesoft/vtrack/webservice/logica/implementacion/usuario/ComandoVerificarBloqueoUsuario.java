package com.vanesoft.vtrack.webservice.logica.implementacion.usuario;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoUsuario;
import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.core.entidades.EstadoUsuario;
import com.vanesoft.vtrack.core.excepciones.LogicaException;
import com.vanesoft.vtrack.core.utilidades.propiedades.PropiedadesLogica;
import com.vanesoft.vtrack.webservice.logica.implementacion.ComandoBase;
import com.vanesoft.vtrack.webservice.logica.implementacion.FabricaComando;
import com.vanesoft.vtrack.webservice.logica.implementacion.correo.ComandoEnviarCorreo;

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
        try {
            usuarioEnBd = daoUsuario.ConsultarNumeroIntentosLoginUsuario(usuarioEnBd);
            if (usuarioEnBd.getIntentosLogin() >= 3) {
                //bloquearusuario
                usuarioEnBd.setEstadoUsuario(EstadoUsuario.bloqueado);
                usuarioEnBd.setIntentosLogin(0);
                ComandoCambiarEstadoUsuario comandoCambiarEstadoUsuario =
                        FabricaComando.obtenerComandoCambiarEstadoUsuario(usuarioEnBd);
                comandoCambiarEstadoUsuario.ejecutar();
                ComandoEnviarCorreo comandoEnviarCorreo =
                        FabricaComando.obtenerComandoEnviarCorreo(usuarioEnBd);
                comandoEnviarCorreo.ejecutar();
                throw new LogicaException(PropiedadesLogica.ERROR_USUARIO_HA_SIDO_BLOQUEADO);
            }
        }
        catch (LogicaException e)
        {
            throw new LogicaException(e.getMessage());
        }
        catch (Exception e)
        {

        }
        return usuarioEnBd.getIntentosLogin();
    }
}
