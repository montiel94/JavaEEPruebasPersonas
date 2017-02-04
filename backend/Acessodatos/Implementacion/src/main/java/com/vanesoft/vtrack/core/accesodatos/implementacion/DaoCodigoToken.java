package com.vanesoft.vtrack.core.accesodatos.implementacion;
import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoCodigoToken;
import com.vanesoft.vtrack.core.entidades.CodigoToken;
import com.vanesoft.vtrack.core.utilidades.propiedades.PropiedadesAccesoDatos;
/**
 * Created by Daniel jose on 04/02/2017.
 */
public class DaoCodigoToken extends Dao implements IDaoCodigoToken {

    public boolean guardarCodigoToken (CodigoToken codigo){

        crearConexion();
        return true;
    }
}
