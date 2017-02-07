package com.vanesoft.vtrack.webservice.logica.implementacion.usuario;
import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoUsuario;
import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.webservice.logica.implementacion.ComandoBase;

/**
 * Sistema:             Vtrakc
 * Nombre:              ComandoValidarCredencialesUsuario
 * Descripcion:         Comando encargado de validar las credenciales de un usuario
 *
 * @author  montda
 * @version 1.0
 * @since 06/02/2017
 */
public class ComandoValidarCredencialesUsuario extends ComandoBase<Boolean> {

    //atributos region
    IDaoUsuario daoUsuario = FabricaDao.obtenerDaoUsuario();
    String correo = null;
    String contrasena = null;
    // end region


    //contructor
    public ComandoValidarCredencialesUsuario (String contrasena,String correo){
        this.contrasena = contrasena;
        this.correo = correo;
    };
    @Override
    public Boolean ejecutar(){
        usuario usuarioEnBd = null;
        try {

            usuarioEnBd = daoUsuario.buscarUsuarioXCorreoElectronico(correo);
            if (usuarioEnBd!=null){
                if (contrasena.equals(usuarioEnBd.getPassword())){
                    return true;
                }
            }

        }catch (Exception e) {

        }
        return false;
    }

}
