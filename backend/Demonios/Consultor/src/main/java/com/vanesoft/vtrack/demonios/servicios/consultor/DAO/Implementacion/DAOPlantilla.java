package com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Implementacion;


import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.IDAOPlantilla;
import com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.Plantilla;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Sistema:             Vtrakc
 * Nombre:              DaoPlantilla
 * Descripcion:         clase que tendran el comportamiento todos los daos que la clase Plantilla
 *
 * @author  montda
 * @version 1.0
 * @since 04/02/2017
 */
public class DAOPlantilla extends DAO implements IDAOPlantilla {


    /*
         descripcion : consulta una plantilla dada su nombre
         params : @nombre nombre de la plantila
         returns objeto plantilla consulta en bd
         author montda
         since 09/02/2017
     */
    public Plantilla consultarPlantilla(String nombre)
    {
        Plantilla plantillaEnBd = null;
        try {

            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query =   "SELECT ID,NOMBRE,VALOR,TITULO "+
                            "FROM VTRACK_PLANTILLA "+
                            "WHERE NOMBRE = '"+nombre+"'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                plantillaEnBd = new Plantilla(rs.getString("VALOR"),
                        rs.getString("NOMBRE"),rs.getString("TITULO"));
            }

        }catch (Exception e){

        }

        return plantillaEnBd;
    }
}
