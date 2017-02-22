package com.vanesoft.vtrack.core.accesodatos.implementacion;
import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoParametro;
import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoPlantilla;
import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoCorreo;
import com.vanesoft.vtrack.core.accesodatos.contratos.IDaoUsuario;
import com.vanesoft.vtrack.core.entidades.*;
import com.vanesoft.vtrack.core.utilidades.propiedades.Armador;
import com.vanesoft.vtrack.core.utilidades.propiedades.CifrarDescifrar;
import com.vanesoft.vtrack.core.utilidades.propiedades.PropiedadesAccesoDatos;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Random;
/**
 * Created by Daniel jose on 08/02/2017.
 */
public class DaoCorreo implements IDaoCorreo{

    public void enviarCorreo(Correo correoEnviando)
    {
        Properties props = new Properties();
        props.put(PropiedadesAccesoDatos.CONFIG_MAILSMTPPAUTH,
                PropiedadesAccesoDatos.CONFIG_MAILSMTPAUTHVALOR);
        props.put(PropiedadesAccesoDatos.CONFIG_MAILSMTPSTARTTLSENABLE,
                PropiedadesAccesoDatos.CONFIG_MAILSMTPSTARTTLSENABLEVALOR);
        props.put(PropiedadesAccesoDatos.CONFIG_MAILSMTPHOST,
                PropiedadesAccesoDatos.CONFIG_MAILSMTPHOSTVALOR);
        props.put(PropiedadesAccesoDatos.CONFIG_MAILSMTPPORT,
                PropiedadesAccesoDatos.CONFIG_MAILSMTPPORTVALOR);
        props.put(PropiedadesAccesoDatos.CONFIG_MAILSMTPMAILSENDER,
                correoEnviando.getUser());
        props.put(PropiedadesAccesoDatos.CONFIG_MAILSMTPUSER,correoEnviando.getUser());
        Session session = Session.getDefaultInstance(props);
        try {

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(correoEnviando.getUser()));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(correoEnviando.getTo()));
            message.setSubject(correoEnviando.getAsunto());
            message.setContent(correoEnviando.getMensaje(),
                    PropiedadesAccesoDatos.CONFIG_SETCONTENT);
            Transport t = session.getTransport(PropiedadesAccesoDatos.CONFIG_MAILGETTRANSPORTE);
            t.connect((String)props.get(PropiedadesAccesoDatos.CONFIG_MAILSMTPUSER),
                    correoEnviando.getUserPassword() );
            t.sendMessage(message, message.getAllRecipients());
            t.close();


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void envioCorreoUsuarioXIntentosLogin (usuario usuarioEnviarCorreo)
    {
        try {
            String nuevaContrasena = "";
            String nuevaContrasenaEncriptada = "";
            IDaoUsuario daoUsuario = FabricaDao.obtenerDaoUsuario();
            IDaoPlantilla daoPlantilla = FabricaDao.obtenerDaoPlantilla();
            Plantilla plantillaEnBd = daoPlantilla.consultarPlantilla(TipoPlantilla.usuariobloqueadointentoslogin);
            IDaoParametro daoParametro = FabricaDao.obtenerDaoParametro();
            nuevaContrasena = generarContrasenaProvisional(Integer.valueOf(PropiedadesAccesoDatos.CONFIG_TAMANO_CONTRASENA));
            nuevaContrasenaEncriptada = CifrarDescifrar.cifrar(nuevaContrasena);
            ArrayList parametrosPlantillaEnBd = daoParametro.consultarParametrosXPlantilla(TipoPlantilla.usuariobloqueadointentoslogin);
            Hashtable<String, String> valores = new Hashtable<String, String>();
            valores.put(ParametroMensaje.nombreParametroNombreUsuario, usuarioEnviarCorreo.getNombreempresa());
            valores.put(ParametroMensaje.NombreParametroPassword, nuevaContrasena);
            String MensajeFinal = Armador.armarMensaje(plantillaEnBd.getTexto(), parametrosPlantillaEnBd, valores);
            Correo correoEnviando = new Correo(PropiedadesAccesoDatos.CONFIG_CORREO_REMINENTE,
                    usuarioEnviarCorreo.getUsername(), PropiedadesAccesoDatos.CONFIG_CONTRASENA_REMINENTE, plantillaEnBd.getTitulo(),
                    MensajeFinal);
            enviarCorreo(correoEnviando);
            daoUsuario.modificarContrasenaUsuario(usuarioEnviarCorreo, nuevaContrasenaEncriptada);
        }catch (Exception e)
        {

        }
    }

    private boolean armarCorreoUsuarioOlvidoContrasena(usuario usuarioEnviarCorreo)
    {
        boolean exito = false;
        IDaoUsuario  daoUsuario = FabricaDao.obtenerDaoUsuario();
        IDaoPlantilla daoPlantilla = FabricaDao.obtenerDaoPlantilla();
        Plantilla plantillaEnBd = daoPlantilla.consultarPlantilla(TipoPlantilla.usuarioolvidocontrasena);
        IDaoParametro daoParametro = FabricaDao.obtenerDaoParametro();
        String nuevaContrasena = generarContrasenaProvisional(Integer.valueOf(PropiedadesAccesoDatos.CONFIG_TAMANO_CONTRASENA));
        String nuevaContrasenaEncriptada = CifrarDescifrar.cifrar(nuevaContrasena);
        ArrayList parametrosPlantillaEnBd = daoParametro.consultarParametrosXPlantilla(TipoPlantilla.usuarioolvidocontrasena);
        Hashtable<String, String> valores = new Hashtable<String, String>();
        valores.put(ParametroMensaje.nombreParametroNombreUsuario, usuarioEnviarCorreo.getNombreempresa());
        valores.put(ParametroMensaje.NombreParametroPassword, nuevaContrasena);
        String MensajeFinal = Armador.armarMensaje(plantillaEnBd.getTexto(), parametrosPlantillaEnBd, valores);
        Correo correoEnviando = new Correo(PropiedadesAccesoDatos.CONFIG_CORREO_REMINENTE,
                usuarioEnviarCorreo.getUsername(), PropiedadesAccesoDatos.CONFIG_CONTRASENA_REMINENTE, plantillaEnBd.getTitulo(),
                MensajeFinal);
        enviarCorreo(correoEnviando);
        daoUsuario.modificarContrasenaUsuario(usuarioEnviarCorreo, nuevaContrasenaEncriptada);

        exito = true;
        return exito;
    }

    public Boolean envioCorreoUsuarioParametrizado (usuario usuarioEnviarCorreo,String tipoPlantillaa)
    {
        Boolean exito = false;
        Correo correoAEnviar = null;
        try
        {
            if (tipoPlantillaa.equals(TipoPlantilla.usuarioolvidocontrasena))
                 armarCorreoUsuarioOlvidoContrasena(usuarioEnviarCorreo);
            exito = true;

        }catch (Exception e)
        {

        }
        return exito;
    }
    public String generarContrasenaProvisional(int longitud)
    {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while ( i < longitud){
            char c = (char)r.nextInt(255);
            if ( (c >= '0' && c <='9') || (c >='A' && c <='Z') ){
                cadenaAleatoria += c;
                i ++;
            }
        }
        return cadenaAleatoria;
    }

}
