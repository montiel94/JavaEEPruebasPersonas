package com.vanesoft.vtrack.core.utilidades.propiedades;

import java.util.Properties;

/**
 * Sistema:               Vtrack
 * Nombre:               PropiedadesAccesoDatos
 * Descripcion:          Propiedad base de acceso a los archivo properties relaciondos conDAO
 *
 * @author montda
 * @version 1.0
 * @since 04/02/2017
 */
public class PropiedadesAccesoDatos extends PropiedadesBase{

    public static final String INFO_STRING_CONNECTION  = get( "config.stringconnectionbd" );
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
    public static final String CONFIG_TAMANO_CONTRASENA = get("config.tamanocontrasena");
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
            Properties propiedades = obtenerPropiedades( accesodatos );
            retorno = propiedades.getProperty( propiedad );

        }
        catch ( Exception e )
        {

        }

        return retorno;
    }
}
