package com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Implementacion;

import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.IDAOPedido;
import com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.EstadoNotificacion;
import com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.Pedido;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;

/**
 * Created by Daniel jose on 07/04/2017.
 */
public class DAOPedido extends DAO implements IDAOPedido {

    public Pedido consultarPedidosXCodigo(String codigoPedido)
    {
        Pedido pedidoEnBd = null;
        try {

            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "SELECT PED.ID,PED.ESTADO,convert(varchar,PED.SOLICITUD, 103) AS SOLICITUD,PED.COLA,PED.CABEZOTE,PED.CHOFER,PED.INICIO,PED.FIN "+
                    "FROM VTRACK_PEDIDO PED "+
                    "WHERE PED.ID = "+codigoPedido+"";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                pedidoEnBd = new Pedido();
                pedidoEnBd.setNUMERO((rs.getString("ID")));
                pedidoEnBd.setESTADO(BigInteger.valueOf(Long.valueOf(rs.getString("ESTADO"))));
                pedidoEnBd.setSOLICITUD(rs.getString("SOLICITUD"));
                pedidoEnBd.setCOLA(rs.getString("COLA"));
                pedidoEnBd.setCABEZOTE(rs.getString("CABEZOTE"));
                pedidoEnBd.setCHOFER(rs.getString("CHOFER"));
                pedidoEnBd.setINICIO(rs.getString("INICIO"));
                pedidoEnBd.setFIN(rs.getString("FIN"));
            }

        }catch (Exception e){

        }

        return pedidoEnBd;
    }

    public boolean iniciarControlNotificacionesPedido(String codigoPedido){
        Boolean exito= false;
        try {
            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "INSERT INTO VTRACK_NOTIFICACION "+
                    "VALUES (0,0,"+codigoPedido+")";
            stmt.execute(query);
            connection.close();

        } catch (Exception e) {

            System.out.println("exception : " +e.getMessage());
            return false;
        }
        return true;
    }

    public boolean insertarPedidoXCorreoCliente(Pedido pedidoAInsertar){
        System.out.println("entrando al metodo insertarPedidoXCorreoCliente");
        Boolean exito= false;
        try {
            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "INSERT INTO VTRACK_PEDIDO(ID,ESTADO,SOLICITUD,COLA,CABEZOTE,CHOFER,INICIO,FK_USUARIO) "+
                    "VALUES ("+pedidoAInsertar.getNUMERO()+","+String.valueOf(pedidoAInsertar.getESTADO())+",'"+pedidoAInsertar.getSOLICITUD()+"','"+pedidoAInsertar.getCOLA()+"','"+pedidoAInsertar.getCABEZOTE()+"','"+pedidoAInsertar.getCHOFER()+"','"+pedidoAInsertar.getINICIO()+"'," +
                    "(select us.ID FROM VTRACK_USUARIO us where us.CORREO = '"+pedidoAInsertar.getCLIENTE()+"'))";
            stmt.execute(query);
            connection.close();

        } catch (Exception e) {

            System.out.println("exception : " +e.getMessage());
            return false;
        }

        System.out.println("saliendo del metodo insertarPedidoXCorreoCliente");
        return true;
    }

    public Boolean confirmarEnvioCorreo(String codigoPedido,String estadoNotificacion){
        System.out.println("entrando al metodo confirmarEnvioCorreoInicioLlenado");
        Boolean exito= false;
        try {
            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "UPDATE VTRACK_NOTIFICACION "+
                            "SET NOTIFICACION_CORREO = "+estadoNotificacion+" "+
                            "WHERE FK_PEDIDO = "+codigoPedido+"";
            stmt.execute(query);
            connection.close();

        } catch (Exception e) {

            System.out.println("exception : " +e.getMessage());
            return false;
        }

        System.out.println("saliendo del metodo confirmarEnvioCorreoInicioLlenado");
        return true;

    }

    public void updateEstadoPedido(String estadoPedido,int codigoPedido){

        try {
            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "UPDATE VTRACK_PEDIDO " +
                    "SET ESTADO = " + estadoPedido + " " +
                    "WHERE ID = "+String.valueOf(codigoPedido)+"";
            stmt.execute(query);
            connection.close();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (Exception e) {

        }

    }

    public void updateSolicitudPedido(String solicitud,int codigoPedido){

        try {
            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "UPDATE VTRACK_PEDIDO " +
                    "SET SOLICITUD = '" + solicitud + "' " +
                    "WHERE ID = "+String.valueOf(codigoPedido)+"";
            stmt.execute(query);
            connection.close();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (Exception e) {

        }

    }

    public void updateColaPedido(String cola,int codigoPedido){

        try {
            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "UPDATE VTRACK_PEDIDO " +
                    "SET COLA = '" + cola + "' " +
                    "WHERE ID = "+String.valueOf(codigoPedido)+"";
            stmt.execute(query);
            connection.close();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (Exception e) {

        }

    }

    public void updateCabezotePedido(String cabezote,int codigoPedido){

        try {
            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "UPDATE VTRACK_PEDIDO " +
                    "SET CABEZOTE = '" + cabezote + "' " +
                    "WHERE ID = "+String.valueOf(codigoPedido)+"";
            stmt.execute(query);
            connection.close();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (Exception e) {

        }

    }

    public void updateChoferPedido(String chofer,int codigoPedido){

        try {
            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "UPDATE VTRACK_PEDIDO " +
                    "SET CHOFER = '" + chofer + "' " +
                    "WHERE ID = "+String.valueOf(codigoPedido)+"";
            stmt.execute(query);
            connection.close();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (Exception e) {

        }

    }

    public Hashtable<String,String> consultarEstadoNotificacionesPedidos(String codigoPedido)
    {
        Hashtable<String, String> valores = new Hashtable<String, String>();
        try {

            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "SELECT NOTIFICACION_CORREO,NOTIFICACION_PUSH "+
                    "FROM VTRACK_NOTIFICACION "+
                    "WHERE FK_PEDIDO = "+codigoPedido+"";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                valores.put(EstadoNotificacion.nombreNotificacionCorreo,
                        rs.getString("NOTIFICACION_CORREO"));

                valores.put(EstadoNotificacion.nombreNotificacionPush,
                        rs.getString("NOTIFICACION_PUSH"));

            }

        }catch (Exception e){

        }
        return valores;
    }

    public void updateInicioPedido(String inicio,int codigoPedido){

        try {
            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "UPDATE VTRACK_PEDIDO " +
                    "SET INICIO = '" + inicio + "' " +
                    "WHERE ID = "+String.valueOf(codigoPedido)+"";
            stmt.execute(query);
            connection.close();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (Exception e) {

        }

    }

}
