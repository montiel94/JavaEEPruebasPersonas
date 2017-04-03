package com.vanesoft.vtrack.core.utilidades.propiedades;

import java.util.Properties;

/**
 * Sistema:               Vtrack
 * Nombre:               PropiedadesLogica
 * Descripcion:          Propiedad base de acceso a los archivo properties relaciondos con la capa
 * logica de negocio
 *
 * @author montda
 * @version 1.0
 * @since 04/02/2017
 */
public class PropiedadesLogica extends PropiedadesBase {

    public static final String ERROR_CREDENCIALES_USUARIO_ERRADAS
            = get("error.credencialeserradas");
    public static final String ERROR_USUARIO_NO_ENCONTRADO_EN_VTRACK
            = get("error.usuarionoencontrado");
    public static final String ERROR_USUARIO_HA_SIDO_BLOQUEADO
            = get("error.usuariohasidobloqueado");
    public static final String ERROR_USUARIO_BLOQUEADO_INTENTADO_LOGIN
            = get("error.usuariobloqueado");
    public static final String ERROR_USUARIO_INTENTANDO_DESBLOQUEO_LOGIN_FALLIDO
            = get("error.usuariointentadodesbloqueologinerrado");
    public static final String ERROR_USUARIO_ACTIVO_INTENTANDO_DESBLOQUEO
            = get("error.usuarioactivointentandodesbloqueo");
    public static final String ERROR_USUARIO_NO_ES_NUEVO =
            get("error.usuarionoesnuevo");
    public static final String ERROR_TOKEN_INVALIDO =
            get("error.tokeninvalido");
    public static final String ERROR_GENERANDO_TOKEN
            = get("error.generandotoken");
    public static final String ERROR_INESPERADO
            = get("error.errorinesperado");
    public static final String ERROR_USUARIO_POSEE_TOKEN
            = get("error.usuarioposeecodigoauth");


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
            Properties propiedades = obtenerPropiedades( logica );
            retorno = propiedades.getProperty( propiedad );

        }
        catch ( Exception e )
        {

        }

        return retorno;
    }
}

