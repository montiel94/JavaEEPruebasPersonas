package com.vanesoft.vtrack.core.accesodatos.implementacion;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoPedido;
import com.vanesoft.vtrack.core.entidades.CodigoToken;
import com.vanesoft.vtrack.core.entidades.Pedido;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Daniel jose on 13/03/2017.
 */
public class DaoPedido extends Dao implements IDaoPedido{

    public ArrayList<Pedido> consultarPedidosXEmpresa(String nombreEmpresa)
    {
        ArrayList<Pedido> pedidosArray = new ArrayList<Pedido>();
        try {

            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "SELECT PED.ID,PED.ESTADO,convert(varchar,PED.SOLICITUD, 103) AS SOLICITUD,PED.COLA,PED.CABEZOTE,PED.CHOFER,PED.INICIO,PED.FIN "+
                            "FROM VTRACK_PEDIDO PED, VTRACK_USUARIO USU "+
                            "WHERE USU.CORREO = '"+nombreEmpresa+"' AND " +
                            "USU.ID = PED.FK_USUARIO";

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Pedido pedidoEnBd = new Pedido();
                pedidoEnBd.setCodigoPedido(Integer.valueOf(rs.getString("ID")));
                pedidoEnBd.setEstado(Integer.valueOf(rs.getString("ESTADO")));
                pedidoEnBd.setFechaCreacion(rs.getString("SOLICITUD"));
                pedidoEnBd.setCola(rs.getString("COLA"));
                pedidoEnBd.setCabezote(rs.getString("CABEZOTE"));
                pedidoEnBd.setChofer(rs.getString("CHOFER"));
                pedidoEnBd.setInicio(rs.getString("INICIO"));
                pedidoEnBd.setFin(rs.getString("FIN"));
                pedidosArray.add(pedidoEnBd);
            }

        }catch (Exception e){

        }

        return pedidosArray;
    }

    public Pedido consultarPedidosXCodigo(String codigoPedido)
    {
        Pedido pedidoEnBd = new Pedido();
        try {

            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "SELECT PED.ID,PED.ESTADO,convert(varchar,PED.SOLICITUD, 103) AS SOLICITUD,PED.COLA,PED.CABEZOTE,PED.CHOFER,PED.INICIO,PED.FIN "+
                           "FROM VTRACK_PEDIDO PED "+
                            "WHERE PED.ID = "+codigoPedido+"";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                pedidoEnBd = new Pedido();
                pedidoEnBd.setCodigoPedido(Integer.valueOf(rs.getString("ID")));
                pedidoEnBd.setEstado(Integer.valueOf(rs.getString("ESTADO")));
                pedidoEnBd.setFechaCreacion(rs.getString("SOLICITUD"));
                pedidoEnBd.setCola(rs.getString("COLA"));
                pedidoEnBd.setCabezote(rs.getString("CABEZOTE"));
                pedidoEnBd.setChofer(rs.getString("CHOFER"));
                pedidoEnBd.setInicio(rs.getString("INICIO"));
                pedidoEnBd.setFin(rs.getString("FIN"));
            }

        }catch (Exception e){

        }

        return pedidoEnBd;
    }

    /*
        nombre : modificarEstadoPedidoXCodigo
        params : @Params codigoPedido : codigo del pedido a modificar
        @Params Estado estado del pedido actual
        Descripcion : metodo que modfica el estado del pedido
     */
    public Boolean modificarEstadoPedidoXCodigo(String codigoPedido,String Estado) {
        try {
            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "UPDATE VTRACK_PEDIDO "+
                           "SET ESTADO =  "+Estado+" "+
                           "WHERE ID= "+codigoPedido+" ";
            stmt.execute(query);
            connection.close();

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /*
        nombre : modificarDateTimeFinPedidoXCodigo
        params : @Params codigoPedido : codigo del pedido a modificar
        Descripcion : pone en bd el datetime en la tabla pedidos cuando este pedido finalizo
     */
    public Boolean modificarDateTimeFinPedidoXCodigo(String codigoPedido) {
        try {
            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "UPDATE VTRACK_PEDIDO " +
                            "SET FIN = SYSDATETIME()" +
                            "WHERE ID = "+codigoPedido+"";
            stmt.execute(query);
            connection.close();

        } catch (Exception e) {
            return false;
        }
        return true;
    }


}
