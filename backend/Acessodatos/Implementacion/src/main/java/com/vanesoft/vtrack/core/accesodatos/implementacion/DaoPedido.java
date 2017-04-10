package com.vanesoft.vtrack.core.accesodatos.implementacion;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoPedido;
import com.vanesoft.vtrack.core.entidades.CodigoToken;
import com.vanesoft.vtrack.core.entidades.Pedido;

import javax.security.auth.login.LoginException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Sistema:             Vtrack
 * Nombre:              IDaoPedido
 * Descripcion:         Contrato del dao dedicado a las operaciones con pedidos
 *
 * @author montda
 * @version 1.0
 * @since 04/02/2017
 */
public class DaoPedido extends Dao implements IDaoPedido{

    /**
     * Descripcion: metodo que consulta los pedidos de una empresa
     * @param nombreEmpresa nombre de la empresa a consultar los pedidos
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */
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
    /**
     * Descripcion: metodo que inserta un pedido dado el correo de un cliente
     * @param correo correo del cliente dueno del pedido
     * @param pedidoAInsertar  pedido a insertar en la base de datos
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */
    public boolean insertarPedidoXCorreoCliente(Pedido pedidoAInsertar,String correo){
        Boolean exito= false;
        try {
            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "INSERT INTO VTRACK_PEDIDO "+
                           "VALUES ("+pedidoAInsertar.getCodigoPedido()+","+pedidoAInsertar.getEstado()+",'"+pedidoAInsertar.getFechaCreacion()+"','"+pedidoAInsertar.getCola()+"','"+pedidoAInsertar.getCabezote()+"','"+pedidoAInsertar.getChofer()+"','"+pedidoAInsertar.getInicio()+"','"+pedidoAInsertar.getFin()+"'," +
                           "(select us.ID FROM VTRACK_USUARIO us where us.CORREO = '"+correo+"'))";
            stmt.execute(query);
            connection.close();

        } catch (Exception e) {

            return false;
        }
        return true;
    }
    /**
     * Descripcion: metodo que consulta un pedido dado su codigo
     * @param codigoPedido codigo del pedido a consultar
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */
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
