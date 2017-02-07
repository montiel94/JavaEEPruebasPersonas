package com.vanesoft.vtrack.core.accesodatos.implementacion;
import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoUsuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Sistema:             Vtrakc
 * Nombre:              DaoCodigoUsuario
 * Descripcion:         clase que tendran el comportamiento todos los daos que la clase Usuario
 *
 * @author  montda
 * @version 1.0
 * @since 06/02/2017
 */
public class DaoUsuario extends Dao implements IDaoUsuario{
    /*
        constructores
     */
    public DaoUsuario(){

    }
    /*
        Descripcion : busca en bd usuario registrado con el correo
        @author : montda
        @since : 04/02/2017
        return : entidad usuario
    */
    public usuario buscarUsuarioXCorreoElectronico(String Correo){
        usuario UsuarioenBd = new usuario();
        try {

            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query =   "select ID,CORREO,CONTRASEÑA "+
                             "FROM VTRACK_USUARIO "+
                             "WHERE CORREO = '"+Correo+"'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                UsuarioenBd.setId(Integer.parseInt(rs.getString("ID")));
                UsuarioenBd.setUsername(rs.getString("CORREO"));
                UsuarioenBd.setPassword(rs.getString("CONTRASEÑA"));
            }

        }catch (Exception e){

        }
        return UsuarioenBd;
    }


}
