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
