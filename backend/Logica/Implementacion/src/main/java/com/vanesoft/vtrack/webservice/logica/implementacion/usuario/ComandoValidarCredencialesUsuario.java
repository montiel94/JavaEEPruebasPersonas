package com.vanesoft.vtrack.webservice.logica.implementacion.usuario;
import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoCodigoToken;
import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoUsuario;
import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.core.entidades.CodigoToken;
import com.vanesoft.vtrack.core.entidades.EstadoUsuario;
import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.core.utilidades.propiedades.PropiedadesLogica;
import com.vanesoft.vtrack.webservice.logica.implementacion.ComandoBase;
import com.vanesoft.vtrack.core.utilidades.propiedades.CifrarDescifrar;
import com.vanesoft.vtrack.core.excepciones.LogicaException;
import com.vanesoft.vtrack.webservice.logica.implementacion.FabricaComando;

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

            if (existeUsuario(usuarioEnBd))
            {
                if (usuarioActivo(usuarioEnBd))
                {
                    String contrasenaDesencriptada = CifrarDescifrar.descifrar(usuarioEnBd.getPassword());
                    if (contrasena.equals(contrasenaDesencriptada)) {
                        daoUsuario.reiniciarIntentosLogin(usuarioEnBd);
                        return true;
                    } else {
                        ComandoAumentarNumeroIntentosLogin comandoAumentarNumeroIntentosLogin =
                                FabricaComando.obtenerComandoAumentarNumeroIntentosLogin(usuarioEnBd);
                        comandoAumentarNumeroIntentosLogin.ejecutar();
                        ComandoVerificarBloqueoUsuario comandoVerificarBloqueoUsuario =
                                FabricaComando.obtenerComandoVerificarBloqueoUsuario(usuarioEnBd);
                        comandoVerificarBloqueoUsuario.ejecutar();
                        throw new LogicaException(PropiedadesLogica.ERROR_CREDENCIALES_USUARIO_ERRADAS);
                    }
                }
            }

        }catch (LogicaException e) {
            throw new LogicaException(e.getMessage());
        }
        return false;
    }
    public boolean usuarioSinToken(usuario usuarioEnBd)
    {
        boolean exito = false;
        CodigoToken codigoEnBd = null;
        IDaoCodigoToken daoCodigoToken = FabricaDao.obtenerDaoCodigoToken();
        codigoEnBd = daoCodigoToken.ConsultaUsuarioPoseeToken(usuarioEnBd);
        if (codigoEnBd==null)
            exito = true;
        else
            throw new LogicaException(PropiedadesLogica.ERROR_USUARIO_POSEE_TOKEN);
        return exito;
    }
    public boolean usuarioActivo (usuario user)
    {
        if (user.getEstadoUsuario().equals(EstadoUsuario.activo))
            return true;
        if (user.getEstadoUsuario().equals(EstadoUsuario.bloqueado))
            throw new LogicaException(PropiedadesLogica.ERROR_USUARIO_BLOQUEADO_INTENTADO_LOGIN);
        return false;
    }

    public boolean existeUsuario(usuario user)
    {
        if (user != null)
            return true;
        else
            throw new LogicaException(PropiedadesLogica.ERROR_USUARIO_NO_ENCONTRADO_EN_VTRACK);
    }

}
