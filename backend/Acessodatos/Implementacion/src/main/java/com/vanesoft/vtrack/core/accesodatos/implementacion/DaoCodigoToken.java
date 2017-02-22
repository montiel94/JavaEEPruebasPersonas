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
    public DaoCodigoToken (){

    }
    /*
        Descripcion : guarda en bd un token creado
        @author : montda
        @since : 04/02/2017
    */
    public boolean guardarCodigoToken (CodigoToken codigo, usuario user){

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(PropiedadesAccesoDatos.INFO_STRING_CONNECTION);
            String query =  "INSERT INTO VTRACK_TOKEN(ID,VALOR,FK_USUARIO) VALUES " +
                            "(NEXT VALUE FOR VTRACK_SEQUENCE_TOKEN,'"+codigo.getValor()+"', " +
                            "(SELECT ID FROM VTRACK_USUARIO WHERE CORREO = '"+user.getUsername()+"'));";
            Statement stmt = connection.createStatement();
            stmt.execute(query);
            connection.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
