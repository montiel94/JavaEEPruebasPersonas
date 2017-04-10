package com.vanesoft.vtrack.core.accesodatos.implementacion;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoEvento;
import com.vanesoft.vtrack.core.entidades.Evento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Sistema:             Vtrack
 * Nombre:              DaoEvento
 * Descripcion:         dao dedicado a las operaciones con eventos de los pedidos
 *
 * @author montda
 * @version 1.0
 * @since 04/02/2017
 */
public class DaoEvento extends Dao implements IDaoEvento {

    /**
     * Descripcion: metodo que busca los eventos de un pedido
     *
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */

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
