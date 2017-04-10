package com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Implementacion;


import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.IDAOSincronizacion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Daniel jose on 04/04/2017.
 */
public class DAOSincronizacion extends DAO implements IDAOSincronizacion {

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
