package com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Implementacion;

import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.IDAOUsuario;
import com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Daniel jose on 09/04/2017.
 */
public class DAOUsuario extends DAO implements IDAOUsuario{

    public usuario buscarUsuarioXCorreoElectronico(String Correo){
        usuario UsuarioenBd = null;
        try {

            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query =   "select ID,CORREO,CONTRASEÑA,ESTADO,INTENTOSLOGIN,NOMBREEMPRESA "+
                    "FROM VTRACK_USUARIO "+
                    "WHERE CORREO = '"+Correo+"'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                UsuarioenBd = new usuario();
                UsuarioenBd.setId(Integer.parseInt(rs.getString("ID")));
                UsuarioenBd.setUsername(rs.getString("CORREO"));
                UsuarioenBd.setPassword(rs.getString("CONTRASEÑA"));
                UsuarioenBd.setEstadoUsuario(rs.getString("ESTADO"));
                UsuarioenBd.setNombreempresa(rs.getString("NOMBREEMPRESA"));
                UsuarioenBd.setIntentosLogin(Integer.parseInt(rs.getString("INTENTOSLOGIN")));

            }

        }catch (Exception e){

        }
        return UsuarioenBd;
    }

}
