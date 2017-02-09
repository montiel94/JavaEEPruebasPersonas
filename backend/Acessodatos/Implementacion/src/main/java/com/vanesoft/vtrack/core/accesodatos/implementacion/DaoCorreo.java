package com.vanesoft.vtrack.core.accesodatos.implementacion;
import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoParametro;
import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoPlantilla;
import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoCorreo;
import com.vanesoft.vtrack.core.entidades.*;
import com.vanesoft.vtrack.core.utilidades.propiedades.Armador;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;
/**
 * Created by Daniel jose on 08/02/2017.
 */
public class DaoCorreo implements IDaoCorreo{

    public void enviarCorreo(Correo correoEnviando)
    {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.mail.sender",correoEnviando.getUser());
        props.put("mail.smtp.user",correoEnviando.getUser());
        Session session = Session.getDefaultInstance(props);
        try {

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(correoEnviando.getUser()));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(correoEnviando.getTo()));
            message.setSubject(correoEnviando.getAsunto());
            message.setContent(correoEnviando.getMensaje(),"text/html; charset=utf-8");
            Transport t = session.getTransport("smtp");
            t.connect((String)props.get("mail.smtp.user"),correoEnviando.getUserPassword() );
            t.sendMessage(message, message.getAllRecipients());
            t.close();


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void envioCorreoUsuarioXIntentosLogin (usuario usuarioEnviarCorreo)
    {
        IDaoPlantilla daoPlantilla = FabricaDao.obtenerDaoPlantilla();
        Plantilla plantillaEnBd = daoPlantilla.consultarPlantilla(TipoPlantilla.usuariobloqueadointentoslogin);
        IDaoParametro daoParametro = FabricaDao.obtenerDaoParametro();
        ArrayList parametrosPlantillaEnBd = daoParametro.consultarParametrosXPlantilla(TipoPlantilla.usuariobloqueadointentoslogin);
        Hashtable<String,String> valores = new Hashtable<String, String>();
        valores.put(ParametroMensaje.nombreParametroNombreUsuario,usuarioEnviarCorreo.getNombreempresa());
        valores.put(ParametroMensaje.NombreParametroPassword,"n0QSAsRu9VQ0cpp0ydMBMQ==");
        String MensajeFinal = Armador.armarMensaje(plantillaEnBd.getTexto(),parametrosPlantillaEnBd,valores);
        Correo correoEnviando = new Correo(usuarioEnviarCorreo.username,
                usuarioEnviarCorreo.getUsername(),"Panta1994-",plantillaEnBd.getTitulo(),
                MensajeFinal);
        enviarCorreo(correoEnviando);
    }

}
