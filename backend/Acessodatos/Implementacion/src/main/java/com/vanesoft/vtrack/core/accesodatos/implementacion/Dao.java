package com.vanesoft.vtrack.core.accesodatos.implementacion;
import java.sql.Connection;
import java.sql.DriverManager;

import com.vanesoft.vtrack.core.utilidades.propiedades.PropiedadesAccesoDatos;
/**
 * Sistema:             Vtrakc
 * Nombre:              DAO
 * Descripcion:         clase que tendran el comportamiento todos los daos
 *
 * @author  montda
 * @version 1.0
 * @since 04/02/2017
 */
public class Dao {
    /*
        metodo para crear la conexion con la bd
     */
    protected Connection crearConexion (){
        Connection connection = null;
        try
        {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        connection = DriverManager.getConnection(PropiedadesAccesoDatos.INFO_STRING_CONNECTION);
        }catch (Exception e)
        {

        }
        return connection;
    }
}
