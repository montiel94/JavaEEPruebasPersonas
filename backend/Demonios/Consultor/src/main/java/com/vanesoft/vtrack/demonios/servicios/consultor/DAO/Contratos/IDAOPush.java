package com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos;

import com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.Pedido;
import com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.usuario;

/**
 * Created by Daniel jose on 11/04/2017.
 */
public interface IDAOPush {

    public void EnviarPushEstado(usuario usuarioEnviarPush, Pedido pedido, String estado);

    public Boolean confirmarEnvioPush(String codigoPedido,String estadoNotificacion);
}
