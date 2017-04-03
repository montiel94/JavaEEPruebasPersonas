package com.vanesoft.vtrack.webservice.logica.implementacion.pedido;

import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoUsuario;
import com.vanesoft.vtrack.core.accesodatos.implementacion.DaoUsuario;
import com.vanesoft.vtrack.core.accesodatos.implementacion.FabricaDao;
import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.core.excepciones.LogicaException;
import com.vanesoft.vtrack.webservice.logica.implementacion.ComandoBase;

/**
 * Created by Daniel jose on 02/04/2017.
 */
public class ComandoBuscarUsuarioXcodigoPedido extends ComandoBase<usuario>{

    String codigoPedido;
    IDaoUsuario daoUsuario = FabricaDao.obtenerDaoUsuario();

    public ComandoBuscarUsuarioXcodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public usuario ejecutar(){
        usuario retorno = new usuario();
        try{
            retorno =  daoUsuario.buscarUsuarioXCodigoPedido(codigoPedido);

        }catch (Exception e){
            throw new LogicaException(e.getMessage());
        }
        return retorno;
    }
}
