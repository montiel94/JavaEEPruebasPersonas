package com.vanesoft.vtrack.webservice.servicioactualizador.implementacion;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.vanesoft.vtrack.core.entidades.EstadoServicio;
import com.vanesoft.vtrack.core.entidades.Pedido;
import com.vanesoft.vtrack.core.entidades.usuario;
import com.vanesoft.vtrack.core.excepciones.LogicaException;
import com.vanesoft.vtrack.core.utilidades.propiedades.PropiedadesServicios;
import com.vanesoft.vtrack.webservice.logica.implementacion.FabricaComando;
import com.vanesoft.vtrack.webservice.logica.implementacion.pedido.ComandoBuscarPedidoXCodigo;
import com.vanesoft.vtrack.webservice.logica.implementacion.pedido.ComandoBuscarUsuarioXcodigoPedido;
import com.vanesoft.vtrack.webservice.logica.implementacion.pedido.ComandoModificarDateTimeFinPedidoXCodigo;
import com.vanesoft.vtrack.webservice.logica.implementacion.pedido.ComandoModificarEstadoPedidoXCodigo;
import com.vanesoft.vtrack.webservice.logica.implementacion.usuario.ComandoEnviarCorreoParametrizado;
import com.vanesoft.vtrack.webservice.servicioactualizador.contratos.IWSActualizaor;



/**
 * Created by Daniel jose on 02/04/2017.
 */
@WebService( name = "WSActualizador" )
public class WSActualizador implements IWSActualizaor{

    @WebMethod
    public void actualizarEstado(int codigoPedido, int codigoEstado){
        ejecutarActualizarEstado(codigoPedido,codigoEstado);
        if (codigoEstado == 7)
        {
            modificarTiempoFinPedido(codigoPedido);
            if (PropiedadesServicios.CONFIG_ESTADO_ENVIOCORREO_FINALIZADO_PEDIDO.equals(EstadoServicio.activo))
            {
                usuario usuarioAEnviarCorreo = buscarUsuarioDuenoPedido(codigoPedido);
                Pedido pedidoAEnviarCorreo = buscarPedido(codigoPedido);
                enviarCorreoPedidoFinalizado(usuarioAEnviarCorreo,pedidoAEnviarCorreo);
            }
        }

    }

    public Pedido buscarPedido(int codigoPedido){
        try {
            ComandoBuscarPedidoXCodigo comandoBuscarPedidoXCodigo =
                    FabricaComando.obtenerComandoBuscarPedidoXCodigo(String.valueOf(codigoPedido));
            return comandoBuscarPedidoXCodigo.ejecutar();
        }
        catch (Exception e){
            throw new LogicaException(e.getMessage());
        }
    }

    public usuario buscarUsuarioDuenoPedido(int codigoPedido){
        try {
            ComandoBuscarUsuarioXcodigoPedido comandoBuscarUsuarioXcodigoPedido =
                    FabricaComando.obtenerComandoBuscarUsuarioXcodigoPedido(String.valueOf(codigoPedido));
            return comandoBuscarUsuarioXcodigoPedido.ejecutar();
        }
        catch (Exception e){
            throw new LogicaException(e.getMessage());
        }
    }

    public void modificarTiempoFinPedido(int codigoPedido)
    {
        try {
            ComandoModificarDateTimeFinPedidoXCodigo comandoModificarDateTimeFinPedidoXCodigo =
                    FabricaComando.obtenerComandoComandoModificarDateTimeFinPedidoXCodigo(String.valueOf(codigoPedido));
            comandoModificarDateTimeFinPedidoXCodigo.ejecutar();
        }
        catch (Exception e){
            throw new LogicaException(e.getMessage());
        }
    }

    public void enviarCorreoPedidoFinalizado(usuario usuarioAEnviarCorreo,Pedido pedidoFinalizado)
    {
        try{

            //ComandoEnviarCorreoParametrizado = FabricaComando.obtenerComandoEnviarCorreoParametrizado
            //        ()

        }catch (Exception e){
            throw new LogicaException(e.getMessage());
        }
    }

    public void ejecutarActualizarEstado(int codigoPedido,int codigoEstado)
    {
        try {
            ComandoModificarEstadoPedidoXCodigo comandoModificarEstadoPedidoXCodigo =
                    FabricaComando.obtenerComandoModificarEstadoPedidoXCodigo(String.valueOf(codigoPedido),
                            String.valueOf(codigoEstado));
            comandoModificarEstadoPedidoXCodigo.ejecutar();
        }
        catch (Exception e){
            throw new LogicaException(e.getMessage());
        }
    }
}
