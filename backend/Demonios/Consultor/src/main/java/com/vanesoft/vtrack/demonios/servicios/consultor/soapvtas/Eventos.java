
package com.vanesoft.vtrack.demonios.servicios.consultor.soapvtas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="parametrosEventos" type="{urn:scli/wsdl}parametrosEventos"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "parametrosEventos"
})
@XmlRootElement(name = "Eventos")
public class Eventos {

    @XmlElement(required = true)
    protected ParametrosEventos parametrosEventos;

    /**
     * Gets the value of the parametrosEventos property.
     * 
     * @return
     *     possible object is
     *     {@link ParametrosEventos }
     *     
     */
    public ParametrosEventos getParametrosEventos() {
        return parametrosEventos;
    }

    /**
     * Sets the value of the parametrosEventos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParametrosEventos }
     *     
     */
    public void setParametrosEventos(ParametrosEventos value) {
        this.parametrosEventos = value;
    }

}
