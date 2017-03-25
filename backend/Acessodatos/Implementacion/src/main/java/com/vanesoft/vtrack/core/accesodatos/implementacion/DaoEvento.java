package com.vanesoft.vtrack.core.accesodatos.implementacion;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoEvento;
import com.vanesoft.vtrack.core.entidades.Evento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Daniel jose on 21/03/2017.
 */
public class DaoEvento extends Dao implements IDaoEvento {

    public ArrayList<Evento> bucarEventosXPedido(String codigoPedido)
    {
        ArrayList<Evento> eventosPedidoEnBd = new ArrayList<Evento>();
        try {

            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "SELECT ID,TIEMPO,MENSAJE "+
                            "FROM VTRACK_EVENTO "+
                            "WHERE FK_PEDIDO = "+codigoPedido+"";

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Evento eventoEnBd = new Evento(rs.getString("TIEMPO"),
                        rs.getString("MENSAJE"),
                        Integer.valueOf(rs.getString("ID")));
                eventosPedidoEnBd.add(eventoEnBd);
            }

        }catch (Exception e){

        }
        return eventosPedidoEnBd;
    }
}
