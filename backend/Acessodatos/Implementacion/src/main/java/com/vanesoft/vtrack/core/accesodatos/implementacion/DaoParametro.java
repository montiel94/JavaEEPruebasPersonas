package com.vanesoft.vtrack.core.accesodatos.implementacion;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoParametro;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Daniel jose on 09/02/2017.
 */
public class DaoParametro extends Dao implements IDaoParametro{

    /*
         descripcion : consulta una plantilla dada su nombre
         params : @nombre nombre de la plantila
         returns objeto plantilla consulta en bd
         author montda
         since 09/02/2017
     */
    public ArrayList<String> consultarParametrosXPlantilla(String nombrePlantilla)
    {
       ArrayList<String> parametros = new ArrayList<String>();
        try {

            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query =  "SELECT VPA.VALOR "+
                            "FROM VTRACK_PLANTILLA VPL,VTRACK_PARAMETRO VPA "+
                            "WHERE VPL.NOMBRE = '"+nombrePlantilla+"' " +
                            "AND VPL.ID = VPA.FK_PLANTILLA" ;


            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                parametros.add(rs.getString("VALOR"));
            }

        }catch (Exception e){

        }

        return parametros;
    }
}
