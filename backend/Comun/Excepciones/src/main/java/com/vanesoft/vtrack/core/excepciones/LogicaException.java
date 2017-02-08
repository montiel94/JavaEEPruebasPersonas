package com.vanesoft.vtrack.core.excepciones;

/**
 * Sistema:              Vtrack
 * Nombre:               LogicaException
 * Descripcion:          Excepción personalizada de la capa de logica de negocio
 *
 * @author montda
 * @version 1.0
 * @since 07/01/2017
 */
public class LogicaException extends RuntimeException{

    public LogicaException( String message )
    {
        super( message );
    }
}
