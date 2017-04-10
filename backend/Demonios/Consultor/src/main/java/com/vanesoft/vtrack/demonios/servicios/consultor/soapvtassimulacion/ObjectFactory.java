
package com.vanesoft.vtrack.demonios.servicios.consultor.soapvtassimulacion;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.vanesoft.vtrack.demonios.servicios.consultor.soapvtassimulacion package. 
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

    private final static QName _ActualizarEstado_QNAME = new QName("http://implementacion.servicioactualizador.webservice.vtrack.vanesoft.com/", "actualizarEstado");
    private final static QName _ActualizarEstadoResponse_QNAME = new QName("http://implementacion.servicioactualizador.webservice.vtrack.vanesoft.com/", "actualizarEstadoResponse");
    private final static QName _GetAllPedidos_QNAME = new QName("http://implementacion.servicioactualizador.webservice.vtrack.vanesoft.com/", "getAllPedidos");
    private final static QName _GetAllPedidosResponse_QNAME = new QName("http://implementacion.servicioactualizador.webservice.vtrack.vanesoft.com/", "getAllPedidosResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.vanesoft.vtrack.demonios.servicios.consultor.soapvtassimulacion
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllPedidosResponse }
     * 
     */
    public GetAllPedidosResponse createGetAllPedidosResponse() {
        return new GetAllPedidosResponse();
    }

    /**
     * Create an instance of {@link GetAllPedidos }
     * 
     */
    public GetAllPedidos createGetAllPedidos() {
        return new GetAllPedidos();
    }

    /**
     * Create an instance of {@link ActualizarEstado }
     * 
     */
    public ActualizarEstado createActualizarEstado() {
        return new ActualizarEstado();
    }

    /**
     * Create an instance of {@link ActualizarEstadoResponse }
     * 
     */
    public ActualizarEstadoResponse createActualizarEstadoResponse() {
        return new ActualizarEstadoResponse();
    }

    /**
     * Create an instance of {@link Pedido }
     * 
     */
    public Pedido createPedido() {
        return new Pedido();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarEstado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://implementacion.servicioactualizador.webservice.vtrack.vanesoft.com/", name = "actualizarEstado")
    public JAXBElement<ActualizarEstado> createActualizarEstado(ActualizarEstado value) {
        return new JAXBElement<ActualizarEstado>(_ActualizarEstado_QNAME, ActualizarEstado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarEstadoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://implementacion.servicioactualizador.webservice.vtrack.vanesoft.com/", name = "actualizarEstadoResponse")
    public JAXBElement<ActualizarEstadoResponse> createActualizarEstadoResponse(ActualizarEstadoResponse value) {
        return new JAXBElement<ActualizarEstadoResponse>(_ActualizarEstadoResponse_QNAME, ActualizarEstadoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPedidos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://implementacion.servicioactualizador.webservice.vtrack.vanesoft.com/", name = "getAllPedidos")
    public JAXBElement<GetAllPedidos> createGetAllPedidos(GetAllPedidos value) {
        return new JAXBElement<GetAllPedidos>(_GetAllPedidos_QNAME, GetAllPedidos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPedidosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://implementacion.servicioactualizador.webservice.vtrack.vanesoft.com/", name = "getAllPedidosResponse")
    public JAXBElement<GetAllPedidosResponse> createGetAllPedidosResponse(GetAllPedidosResponse value) {
        return new JAXBElement<GetAllPedidosResponse>(_GetAllPedidosResponse_QNAME, GetAllPedidosResponse.class, null, value);
    }

}
