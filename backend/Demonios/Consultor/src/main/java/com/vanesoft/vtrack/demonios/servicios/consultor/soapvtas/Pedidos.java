
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
 *         &lt;element name="parametrosPedidos" type="{urn:scli/wsdl}parametrosPedidos"/>
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
    "parametrosPedidos"
})
@XmlRootElement(name = "Pedidos")
public class Pedidos {

    @XmlElement(required = true)
    protected ParametrosPedidos parametrosPedidos;

    /**
     * Gets the value of the parametrosPedidos property.
     * 
     * @return
     *     possible object is
     *     {@link ParametrosPedidos }
     *     
     */
    public ParametrosPedidos getParametrosPedidos() {
        return parametrosPedidos;
    }

    /**
     * Sets the value of the parametrosPedidos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParametrosPedidos }
     *     
     */
    public void setParametrosPedidos(ParametrosPedidos value) {
        this.parametrosPedidos = value;
    }

}
