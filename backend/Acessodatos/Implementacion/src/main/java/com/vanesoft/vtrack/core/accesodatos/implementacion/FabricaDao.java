package com.vanesoft.vtrack.core.accesodatos.implementacion;

import com.vanesoft.vtrack.core.accesodatos.contratos.*;

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

    /**
     * Nombre:                  obtenerDaoPlantilla
     * Descripcion:             genera el DAO plantilla
     *
     * @return el dao
     * @version 1.0
     * @author montda
     * @since 06/02/17
     */
    public static IDaoPlantilla obtenerDaoPlantilla(){ return new DaoPlantilla();}

    /**
     * Nombre:                  obtenerDaoParametro
     * Descripcion:             genera el DAOParametro
     *
     * @return el dao
     * @version 1.0
     * @author montda
     * @since 06/02/17
     */
    public static IDaoParametro obtenerDaoParametro(){ return new DaoParametro();}

    /**
     * Nombre:                  obtenerDaoCorreo
     * Descripcion:             genera el DAOCorreo
     *
     * @return el dao
     * @version 1.0
     * @author montda
     * @since 06/02/17
     */
    public static IDaoCorreo obtenerDaoCorreo(){ return new DaoCorreo();}


}
