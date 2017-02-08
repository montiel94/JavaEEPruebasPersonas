package com.vanesoft.vtrack.core.accesodatos.implementacion;
import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoUsuario;
import com.vanesoft.vtrack.core.enumerados.EstadoUsuario;
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
        usuario UsuarioenBd = null;
        try {

            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query =   "select ID,CORREO,CONTRASEÑA "+
                             "FROM VTRACK_USUARIO "+
                             "WHERE CORREO = '"+Correo+"'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                UsuarioenBd = new usuario();
                UsuarioenBd.setId(Integer.parseInt(rs.getString("ID")));
                UsuarioenBd.setUsername(rs.getString("CORREO"));
                UsuarioenBd.setPassword(rs.getString("CONTRASEÑA"));
            }

        }catch (Exception e){

        }
        return UsuarioenBd;
    }
    /*
        Descripcion : aumenta en bd el numero de intentos de un usuario
        @author : montda
        @since : 04/02/2017
        return : true de exito
    */
    public Boolean aumentarNumeroIntentosLogin (usuario usuarioEnBd)
    {
        try
        {
            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "UPDATE VTRACK_USUARIO " +
                           "SET INTENTOSLOGIN = (SELECT INTENTOSLOGIN + 1 FROM VTRACK_USUARIO WHERE CORREO = 'daniel.montiel@gmail.com') "+
                            "WHERE CORREO = '"+usuarioEnBd.getUsername()+"'";
            stmt.execute(query);
            connection.close();
            return true;
        }
        catch (Exception e)
        {

        }
        return false;
    }

    /*
        Descripcion : consulta el numero de intentos de login de un usuario
        @author : montda
        @since : 07/02/2017
        return : entidad usuario
    */
    public usuario ConsultarNumeroIntentosLoginUsuario (usuario usuarioEnBd)
    {
        try
        {

            Connection connection = crearConexion();
            Statement stmt = connection.createStatement();
            String query = "select ID,CORREO,CONTRASEÑA,ESTADO,INTENTOSLOGIN "+
                            "from VTRACK_USUARIO "+
                            "WHERE CORREO = '"+usuarioEnBd.getUsername()+"'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                usuarioEnBd = new usuario();
                usuarioEnBd.setId(Integer.parseInt(rs.getString("ID")));
                usuarioEnBd.setUsername(rs.getString("CORREO"));
                usuarioEnBd.setPassword(rs.getString("CONTRASEÑA"));
                usuarioEnBd.setEstadoUsuario(rs.getString("ESTADO"));
                usuarioEnBd.setIntentosLogin(Integer.parseInt(rs.getString("INTENTOSLOGIN")));
            }
        }
        catch (Exception e)
        {

        }
        return  usuarioEnBd;
    }


}
