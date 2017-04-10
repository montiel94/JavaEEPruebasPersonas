
package com.vanesoft.vtrack.demonios.servicios.consultor.soapvtas;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.vanesoft.vtrack.demonios.servicios.consultor.soapvtas package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.vanesoft.vtrack.demonios.servicios.consultor.soapvtas
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Pedidos }
     * 
     */
    public Pedidos createPedidos() {
        return new Pedidos();
    }

    /**
     * Create an instance of {@link ParametrosPedidos }
     * 
     */
    public ParametrosPedidos createParametrosPedidos() {
        return new ParametrosPedidos();
    }

    /**
     * Create an instance of {@link RespuestaPedidos }
     * 
     */
    public RespuestaPedidos createRespuestaPedidos() {
        return new RespuestaPedidos();
    }

    /**
     * Create an instance of {@link RespuestaPedido }
     * 
     */
    public RespuestaPedido createRespuestaPedido() {
        return new RespuestaPedido();
    }

    /**
     * Create an instance of {@link Eventos }
     * 
     */
    public Eventos createEventos() {
        return new Eventos();
    }

    /**
     * Create an instance of {@link ParametrosEventos }
     * 
     */
    public ParametrosEventos createParametrosEventos() {
        return new ParametrosEventos();
    }

    /**
     * Create an instance of {@link RespuestaEventos }
     * 
     */
    public RespuestaEventos createRespuestaEventos() {
        return new RespuestaEventos();
    }

    /**
     * Create an instance of {@link RespuestaEvento }
     * 
     */
    public RespuestaEvento createRespuestaEvento() {
        return new RespuestaEvento();
    }

}
