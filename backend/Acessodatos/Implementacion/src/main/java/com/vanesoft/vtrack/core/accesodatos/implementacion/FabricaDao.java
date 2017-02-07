package com.vanesoft.vtrack.core.accesodatos.implementacion;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoCodigoToken;
import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoUsuario;

/**
 * Sistema:                 Vtrack
 * Siglas:                  VT
 * <p/>
 * Nombre:                  FabricaDao
 * Descripcion:             lase que simula un fabrica de objetos, en este caso
 * objetos tipo DAO (Data access object)
 *
 * @author montda
 * @version 1.0
 * @since 6/04/2017
 */
public final class FabricaDao {

    //constructores
    private FabricaDao (){

    }
    /**
     * Nombre:                  obtenerobtenerDaoCodigoToken
     * Descripcion:             genera el DAO obtenerDaoCodigoToken
     *
     * @return el dao
     * @version 1.0
     * @author montda
     * @since 06/02/17
     */
    public static IDaoCodigoToken obtenerDaoCodigoToken(){
        return new DaoCodigoToken();
    }

    /**
     * Nombre:                  obtenerobtenerDaoUsuario
     * Descripcion:             genera el DAO daoUsuario
     *
     * @return el dao
     * @version 1.0
     * @author montda
     * @since 06/02/17
     */
    public static IDaoUsuario obtenerDaoUsuario(){
        return new DaoUsuario();
    }

}
