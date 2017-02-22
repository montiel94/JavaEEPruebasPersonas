package com.vanesoft.vtrack.webservice.logica.implementacion.usuario;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoUsuario;
import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.core.excepciones.LogicaException;
import com.vanesoft.vtrack.core.utilidades.propiedades.PropiedadesLogica;
import com.vanesoft.vtrack.webservice.logica.implementacion.ComandoBase;

/**
 * Sistema:             Vtrack
 * Nombre:              ComandoConsultarUsuario
 * Descripcion:         Comando encargado de consultar usuario en vtrack, valida si el usuairo existe
 *                      en el sistema
 *
 * @author montda
 * @version 1.0
 * @since 20/02/2017
 */
public class ComandoConsultarUsuario extends ComandoBase<usuario> {

    //atributes region
    usuario usuarioEnBd = null;
    IDaoUsuario daoUsuario = FabricaDao.obtenerDaoUsuario();
    usuario usuarioBusqueda;
    //end region


    public ComandoConsultarUsuario(usuario usuarioBusqueda) {
        this.usuarioBusqueda = usuarioBusqueda;
    }

    public usuario ejecutar()
    {
        try
        {
            usuarioEnBd = daoUsuario.buscarUsuarioXCorreoElectronico(usuarioBusqueda.getUsername());
            if (usuarioEnBd == null)
                throw new LogicaException(PropiedadesLogica.ERROR_USUARIO_NO_ENCONTRADO_EN_VTRACK);
        }
        catch (LogicaException e)
        {
           throw new LogicaException(e.getMessage());
        }
        return usuarioEnBd;
    }
}
