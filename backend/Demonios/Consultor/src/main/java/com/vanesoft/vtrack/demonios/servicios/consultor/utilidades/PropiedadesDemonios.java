package com.vanesoft.vtrack.demonios.servicios.consultor.utilidades;

import java.util.Properties;

/**
 * Created by Daniel jose on 04/04/2017.
 */
public class PropiedadesDemonios extends PropiedadesBase {
    public static final String CONFIG_TIEMPO_LLAMADO_SOAP_VTAS
            = get("config.tiempollamadosoapvtas");

    public static final String INFO_STRING_CONNECTION
            = get("config.stringconnection");
    public static final String CONFIG_CORREO_REMINENTE = get("config.correoreminente");
    public static final String CONFIG_CONTRASENA_REMINENTE = get("config.contrasenareminente");
    public static final String CONFIG_MAILSMTPPAUTH = get("config.mailsmtpauth");
    public static final String CONFIG_MAILSMTPAUTHVALOR = get("config.mailsmtpauthvalor");
    public static final String CONFIG_MAILSMTPSTARTTLSENABLE = get("config.mailsmtpstarttlsenable");
    public static final String CONFIG_MAILSMTPSTARTTLSENABLEVALOR = get("config.mailsmtpstarttlsenablevalor");
    public static final String CONFIG_MAILSMTPHOST = get("config.mailsmtphost");
    public static final String CONFIG_MAILSMTPHOSTVALOR = get("config.mailsmtphostvalor");
    public static final String CONFIG_MAILSMTPPORT = get("config.mailsmtpport");
    public static final String CONFIG_MAILSMTPPORTVALOR = get("config.mailsmtpportvalor");
    public static final String CONFIG_MAILSMTPMAILSENDER = get("config.mailsmtpmailsender");
    public static final String CONFIG_MAILSMTPUSER = get("config.mailsmtpuser");
    public static final String CONFIG_SETCONTENT = get("config.setcontent");
    public static final String CONFIG_MAILGETTRANSPORTE = get("config.mailgettransporte");
    public static final String CONFIG_URL_SERVER_PUSH = get("config.urlserverpush");
    public static final String CONFIG_KEY_FCM = get("config.keyfcm");
    /**
     * Nombre:                  get
     * Descripcion:             Metodo que obtiene el valor de una propiedad
     *
     * @param propiedad atributos de la propiedad
     *
     * @return valor de la propiedad
     *
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */
    public static String get( String propiedad )
    {
        String retorno = "";

        try
        {
            Properties propiedades = obtenerPropiedades( demonios );
            retorno = propiedades.getProperty( propiedad );

        }
        catch ( Exception e )
        {

        }

        return retorno;
    }
}
