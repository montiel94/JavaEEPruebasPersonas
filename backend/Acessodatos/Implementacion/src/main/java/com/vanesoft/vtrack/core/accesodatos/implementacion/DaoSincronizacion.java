package com.vanesoft.vtrack.core.accesodatos.implementacion;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoSincronizacion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Sistema:             Vtrack
 * Nombre:              IDaoSincronizacion
 * Descripcion:         Contrato del dao dedicado a las operaciones la sincronizacion de los servicios
 *
 * @author montda
 * @version 1.0
 * @since 04/02/2017
 */
public class DaoSincronizacion extends Dao implements IDaoSincronizacion{

    /**
     * Descripcion: metodo que modificacion el tiempo de la ultima sincronizacion
     * @param tiempo tiempo de la ultima sincronizacion
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */

    public boolean modificarSincronizacion(String tiempo) {
        try {
            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "UPDATE VTRACK_SINCRONIZACION " +
                    "SET TIEMPO = '" + tiempo + "' ";
            stmt.execute(query);
            connection.close();

        } catch (Exception e) {

        }
        return true;
    }
    /**
     * Descripcion: metodo que consulta el tiempo d ela ultima sincronizacion
     *
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */
    public String consultarSincronizacion()
    {
        String retorno = "";
        try {

            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "SELECT TIEMPO " +
                    "FROM VTRACK_SINCRONIZACION ";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                retorno = rs.getString("TIEMPO");
            }
        } catch (Exception e) {

        }
        return retorno;
    }
}
