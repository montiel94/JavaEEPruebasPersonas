package com.vanesoft.vtrack.core.accesodatos.implementacion;
import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoCodigoToken;
import com.vanesoft.vtrack.core.entidades.CodigoToken;
import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.core.utilidades.propiedades.PropiedadesAccesoDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Sistema:             Vtrakc
 * Nombre:              DaoCodigoToken
 * Descripcion:         clase que tendran el comportamiento todos los daos que la clase CodigoToken
 *
 * @author  montda
 * @version 1.0
 * @since 04/02/2017
 */
public class DaoCodigoToken extends Dao implements IDaoCodigoToken {


    /*
    * Constructores
    * */
    public DaoCodigoToken() {

    }

    /*
        nombre : modificarValorToken
        params : nuevoValor : nuevoValor de el token
                 token : token a ser modificado
        Descripcion : metodo que modfica nivel de base de datos un token
     */
    public boolean modificarTipoToken(CodigoToken token) {
        try {
            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "UPDATE VTRACK_TOKEN " +
                    "SET TIPO = '" + token.getTipo() + "' " +
                    "WHERE VALOR = '" + token.getValor() + "' ";
            stmt.execute(query);
            connection.close();

        } catch (Exception e) {

        }
        return true;
    }

    /**
     * Descripcion: metodo que modificar el valor de un token
     * @params usuario : usuario a enviar correo
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */
    public boolean modificarValorToken(String nuevoValor, CodigoToken token) {
        try {
            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "UPDATE VTRACK_TOKEN " +
                    "SET VALOR = '" + nuevoValor + "' " +
                    "WHERE VALOR = '" + token.getValor() + "' ";
            stmt.execute(query);
            connection.close();

        } catch (Exception e) {

        }
        return true;
    }

    /*
        Descripcion : guarda en bd un token creado
        @author : montda
        @since : 04/02/2017
    */
    public boolean guardarCodigoToken(CodigoToken codigo, usuario user) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(PropiedadesAccesoDatos.INFO_STRING_CONNECTION);
            String query = "INSERT INTO VTRACK_TOKEN(ID,VALOR,FK_USUARIO,TIPO) VALUES " +
                    "(NEXT VALUE FOR VTRACK_SEQUENCE_TOKEN,'" + codigo.getValor() + "', " +
                    "(SELECT ID FROM VTRACK_USUARIO WHERE CORREO = '" + user.getUsername() + "'),'" + codigo.getTipo() + "');";
            Statement stmt = connection.createStatement();
            stmt.execute(query);
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /*
        Descripcion : consulta el token buscandolo por su valor
        @author : montda
        @since : 07/02/2017
        return : entidad codigoToken
    */
    public CodigoToken ConsultarCodigoAuthXValor(CodigoToken codigoAuth) {
        CodigoToken codigoEnBd = null;
        try {

            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "SELECT VALOR,TIPO " +
                    "FROM VTRACK_TOKEN " +
                    "WHERE VALOR = '" + codigoAuth.getValor() + "'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                codigoEnBd = new CodigoToken();
                codigoEnBd.setTipo(rs.getString("TIPO"));
                codigoEnBd.setValor(rs.getString("VALOR"));
            }
        } catch (Exception e) {

        }
        return codigoEnBd;
    }

    /*
         Nombre : ConsultaUsuarioPoseeToken
        Descripcion : consulta si dado un usuario posee un token en el sistema
        @author : montda
        @since : 07/02/2017
        return : entidad codigoToken
    */
    public CodigoToken ConsultaUsuarioPoseeToken(usuario usuarioEnBd) {
        CodigoToken codigoEnBd = null;
        try {

            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "SELECT VALOR,TIPO " +
                    "FROM VTRACK_TOKEN TK,VTRACK_USUARIO USU WHERE USU.ID = TK.FK_USUARIO AND " +
                    "USU.CORREO = '" + usuarioEnBd.getUsername() + "'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                codigoEnBd = new CodigoToken();
                codigoEnBd.setTipo(rs.getString("TIPO"));
                codigoEnBd.setValor(rs.getString("VALOR"));
            }
        } catch (Exception e) {

        }
        return codigoEnBd;
    }

    /*
         Nombre : eliminarToken
        Descripcion : elimna un token en el sistema
        @author : montda
        @since : 07/02/2017
        return : true en caso de exito
    */
    public boolean eliminarToken(String codigoToken) {
        try {
            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "DELETE FROM VTRACK_TOKEN " +
                    "WHERE VALOR = '" + codigoToken + "' ";
            stmt.execute(query);
            connection.close();

        } catch (Exception e) {

        }
        return true;
    }
}