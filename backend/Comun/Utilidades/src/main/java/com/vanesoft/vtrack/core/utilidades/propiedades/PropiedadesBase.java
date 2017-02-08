package com.vanesoft.vtrack.core.utilidades.propiedades;


import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;

/**
 * Sistema:              Vtrack
 * Nombre:               PropiedadesBase
 * Descripcion:          Propiedad base de acceso a los archivo properties
 *
 * @author montda
 * @version 1.0
 * @since 04/02/2017
 */
public class PropiedadesBase {

    /**
     * accesodatos.properties
     */
    public static final String accesodatos = "accesodatos.properties";
    public static final String logica = "logica.properties";
    public static final String servicios = "servicios.properties";

    private static HashMap<String, Properties> propiedadesList = new HashMap<>();


    public static Properties obtenerPropiedades( String nombreArchivo )
    {
        Locale.setDefault( new Locale( "es", "VE" ) );
        Properties propiedades = null;
        try
        {
            propiedades = obtenerPropiedadesRegistro( nombreArchivo );

            if ( propiedades == null )
            {
                propiedades = new Properties();
                InputStream archivo = Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream( File.separatorChar
                                + nombreArchivo );

                if(archivo == null)
                    archivo = Thread.currentThread().getContextClassLoader()
                            .getResourceAsStream( nombreArchivo );

                Reader lector = new InputStreamReader( archivo, Charset.forName( "UTF-8") );
                propiedades.load( lector );
                archivo.close();
                asignarPropiedadesRegistro( propiedades, nombreArchivo );
            }
        }
        catch ( Exception e )
        {

        }

        return propiedades;
    }


    /**
     * Nombre:                  obtenerPropiedadesRegistro Descripcion:             Metodo que obtiene las propiedades
     * del registro dado el nombre del archivo
     *
     * @param nombre nombre del archivo
     *
     * @return propiedades
     *
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */
    private static Properties obtenerPropiedadesRegistro( String nombre )
    {

        return  propiedadesList.get( nombre );

    }


    /**
     * Nombre:                  asignarPropiedadesRegistro Descripcion:             Metodo que asigna las propiedades al
     * registro en memoria
     *
     * @param properties propiedades
     * @param nombre     nombre del archivo
     *
     * @version 1.0
     * @author montda
     * @since 04/02/2017
     */
    private static void asignarPropiedadesRegistro( Properties properties, String nombre )
    {
        propiedadesList.put( nombre, properties );
    }


}
