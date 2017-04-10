package com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Implementacion;

import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.IDAOCorreo;
import com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.*;
import com.vanesoft.vtrack.demonios.servicios.consultor.Fabricas.FabricaDAO;
import com.vanesoft.vtrack.demonios.servicios.consultor.utilidades.PropiedadesDemonios;
import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.IDAOParametro;
import com.vanesoft.vtrack.demonios.servicios.consultor.DAO.Contratos.IDAOPlantilla;

import java.util.Properties;

import java.util.ArrayList;
import java.util.Hashtable;
import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import java.util.Properties;
import java.util.Random;

/**
 * Created by Daniel jose on 09/04/2017.
 */
public class DAOCorreo implements IDAOCorreo{

    public void enviarCorreo(Correo correoEnviando)
    {
        Properties props = new Properties();
        props.put(PropiedadesDemonios.CONFIG_MAILSMTPPAUTH,
                PropiedadesDemonios.CONFIG_MAILSMTPAUTHVALOR);
        props.put(PropiedadesDemonios.CONFIG_MAILSMTPSTARTTLSENABLE,
                PropiedadesDemonios.CONFIG_MAILSMTPSTARTTLSENABLEVALOR);
        props.put(PropiedadesDemonios.CONFIG_MAILSMTPHOST,
                PropiedadesDemonios.CONFIG_MAILSMTPHOSTVALOR);
        props.put(PropiedadesDemonios.CONFIG_MAILSMTPPORT,
                PropiedadesDemonios.CONFIG_MAILSMTPPORTVALOR);
        props.put(PropiedadesDemonios.CONFIG_MAILSMTPMAILSENDER,
                correoEnviando.getUser());
        props.put(PropiedadesDemonios.CONFIG_MAILSMTPUSER,correoEnviando.getUser());
        Session session = Session.getDefaultInstance(props);
        try {

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(correoEnviando.getUser()));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(correoEnviando.getTo()));
            message.setSubject(correoEnviando.getAsunto());
            message.setContent(correoEnviando.getMensaje(),
                    PropiedadesDemonios.CONFIG_SETCONTENT);
            Transport t = session.getTransport(PropiedadesDemonios.CONFIG_MAILGETTRANSPORTE);
            t.connect((String)props.get(PropiedadesDemonios.CONFIG_MAILSMTPUSER),
                    correoEnviando.getUserPassword() );
            t.sendMessage(message, message.getAllRecipients());
            t.close();


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean armarCorreoPedidoEstado( usuario usuarioEnviarCorreo, Pedido pedido, String estado)
    {
        boolean exito = false;
        IDAOPlantilla daoPlantilla = FabricaDAO.obtenerDAOPlantilla();
        Plantilla plantillaEnBd = daoPlantilla.consultarPlantilla(TipoPlantilla.pedidofinalizollenado);
        IDAOParametro daoParametro = FabricaDAO.obtenerDAOParametro();
        ArrayList parametrosPlantillaEnBd = daoParametro.consultarParametrosXPlantilla(TipoPlantilla.pedidofinalizollenado);
        Hashtable<String, String> valores = new Hashtable<String, String>();
        valores.put(ParametroMensaje.nombreParametroNombreUsuario, usuarioEnviarCorreo.getNombreempresa());
        valores.put(ParametroMensaje.nombreParametroCodigoPedido, String.valueOf(pedido.getNUMERO()));
        valores.put(ParametroMensaje.nombreHoraInicioLlenado,pedido.getINICIO());
        valores.put(ParametroMensaje.nombreChofer,pedido.getCHOFER());
        valores.put(ParametroMensaje.nombreCola,pedido.getCOLA());
        valores.put(ParametroMensaje.nombreCabezote,pedido.getCABEZOTE());
        valores.put(ParametroMensaje.nombreEstadoPedido,estado);
        if (estado.equals(EstadoPedido.llenado))
        valores.put(ParametroMensaje.nombreHoraFinLlenado,pedido.getFIN());
        else valores.put(ParametroMensaje.nombreHoraFinLlenado,"N/A");
        String MensajeFinal = Armador.armarMensaje(plantillaEnBd.getTexto(), parametrosPlantillaEnBd, valores);
        Correo correoEnviando = new Correo(PropiedadesDemonios.CONFIG_CORREO_REMINENTE,
                usuarioEnviarCorreo.getUsername(), PropiedadesDemonios.CONFIG_CONTRASENA_REMINENTE, plantillaEnBd.getTitulo(),
                MensajeFinal);
        enviarCorreo(correoEnviando);

        exito = true;
        return exito;
    }

}
