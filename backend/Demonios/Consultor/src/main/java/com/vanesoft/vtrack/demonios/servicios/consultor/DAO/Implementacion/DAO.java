package com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Implementacion;

import com.vanesoft.vtrack.demonios.servicios.consultor.utilidades.PropiedadesDemonios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Sistema:             Vtrakc
 * Nombre:              DAO
 * Descripcion:         clase que tendran el comportamiento todos los daos
 *
 * @author  montda
 * @version 1.0
 * @since 04/02/2017
 */
public class DAO {
    /*
        metodo para crear la conexion con la bd
     */
    protected Connection crearConexion (){
        Connection connection = null;
        try
        {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        connection = DriverManager.getConnection(PropiedadesDemonios.INFO_STRING_CONNECTION);
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("exception : " +e.getMessage());
        }
        return connection;
    }
}
