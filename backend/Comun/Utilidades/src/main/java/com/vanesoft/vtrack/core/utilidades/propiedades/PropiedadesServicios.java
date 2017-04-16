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
            = get("respuesta.usuariobloqueadocredencialerrada");
    public static final String  RESPUESTA_USUARIO_NO_POSEE_ESTADO_NUEVO
            =get("respuesta.usuarionoesnuevo");
    public static final String RESPUESTA_TOKEN_INVALIDO
            =get("respuesta.tokeninvalido");
    public static final String RESPUESTA_ERROR_GENERANDO_TOKEN
            = get("respuesta.errorgenerandotoken");
    public static final String RESPUESTA_ERROR_INESPERADO
            = get("respuesta.errorinesperado");
    public static final String RESPUESTA_ERROR_USUARIO_POSEE_TOKEN
            =get("respuesta.errorusuarioposeetoken");
    public static final String CONFIG_ESTADO_ENVIOCORREO_FINALIZADO_PEDIDO
            = get("config.estadoenviocorreofinalizadopedido");
    public static final String CONFIG_TIEMPO_LLAMADO_SOAP_VTAS
            = get("config.tiempollamadosoapvtas");
    public static final String RESPUESTA_ERROR_USUARIO_NUEVO_CLAVE_ERRADA =
            get("respuesta.errorusuarionuevoclaverrada");
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
