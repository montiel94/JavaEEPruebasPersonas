package com.vanesoft.vtrack.core.utilidades.propiedades;

import java.util.Properties;

/**
 * Sistema:               Vtrack
 * Nombre:               PropiedadesLogica
 * Descripcion:          Propiedad base de acceso a los archivo properties relaciondos con los
 * servicios rest
 *
 * @author montda
 * @version 1.0
 * @since 04/02/2017
 */
public class PropiedadesServicios extends PropiedadesBase {

    public static final String RESPUESTA_AUTENTICACION_ERRADA
            = get("respuesta.autenticacionErrada");
    public static final String RESPUESTA_USUARIO_NO_ENCONTRADO
            = get("respuesta.usuarionoencontrado");
    public static final String RESPUESTA_USUARIO_BLOQUEADO =
            get("respuesta.usuariobloquedo");
    public static final String RESPUESTA_USUARIO_BLOQUEADO_INTENTANDO_LOGIN
            = get("respuesta.usuariobloqueadointentandologin");
    public static final String RESPUESTA_USUARIO_ACTIVO_INTENTANDO_DESBLOQUEO
            = get("respuesta.usuarioactivointentantodesbloqueo");
    public static final String RESPUESTA_USUARIO_BLOQUEDA_AUTENTICACION_ERRADA
            = get("respuesta.usuariobloqueadocredencialerrada ");
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
            Properties propiedades = obtenerPropiedades( servicios );
            retorno = propiedades.getProperty( propiedad );

        }
        catch ( Exception e )
        {

        }

        return retorno;
    }

}
