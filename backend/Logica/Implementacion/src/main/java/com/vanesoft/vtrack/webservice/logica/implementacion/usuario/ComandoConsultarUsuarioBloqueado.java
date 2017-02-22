package com.vanesoft.vtrack.webservice.logica.implementacion.usuario;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoUsuario;
import com.vanesoft.vtrack.core.accesodatos.implementacion.DaoUsuario;
import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.core.entidades.EstadoUsuario;
import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.core.excepciones.LogicaException;
import com.vanesoft.vtrack.core.utilidades.propiedades.CifrarDescifrar;
import com.vanesoft.vtrack.core.utilidades.propiedades.PropiedadesLogica;
import com.vanesoft.vtrack.webservice.logica.implementacion.ComandoBase;

/**
 * Sistema:             Vtrack
 * Nombre:              ComandoConsultarUsuarioBloqueado
 * Descripcion:         Comando encargado de validar que usuario esta bloqueado y
 *                       validar sus credenciales
 *
 * @author montda
 * @version 1.0
 * @since 13/02/2017
 */
public class ComandoConsultarUsuarioBloqueado extends ComandoBase<usuario>{
    //atributos region
        usuario usuarioEnBd = null;
        usuario usuarioBusqueda = null;
        IDaoUsuario daoUsuario = FabricaDao.obtenerDaoUsuario();
    // end region


    //CONSTRUCTOR
    public ComandoConsultarUsuarioBloqueado (usuario usuario)
    {
        this.usuarioBusqueda = usuario;
    }
    /*
        * Nombre:              ejecutar
        * Descripcion:         metodo encargado de llamar el dao en bd
     */
    public usuario ejecutar() {
        try {
            usuarioEnBd = daoUsuario.buscarUsuarioXCorreoElectronico(usuarioBusqueda.getUsername());
            if (usuarioEnBd != null) {
                if (usuarioEnBd.getEstadoUsuario().equals(EstadoUsuario.bloqueado)) {
                    if (CifrarDescifrar.descifrar(usuarioEnBd.getPassword()).equals(usuarioBusqueda.getPassword())) {
                        return usuarioEnBd;
                    } else {
                        throw new LogicaException(PropiedadesLogica.ERROR_USUARIO_INTENTANDO_DESBLOQUEO_LOGIN_FALLIDO);
                    }
                } else {
                    throw new LogicaException(PropiedadesLogica.ERROR_USUARIO_ACTIVO_INTENTANDO_DESBLOQUEO);
                }
            }
            else
            {
                throw  new
                        LogicaException(PropiedadesLogica.ERROR_USUARIO_NO_ENCONTRADO_EN_VTRACK);
            }
        }catch(LogicaException e)
        {
            throw new LogicaException(e.getMessage());
        }
    }
}
