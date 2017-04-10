
package com.vanesoft.vtrack.demonios.servicios.consultor.soapvtas;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for respuestaEvento complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="respuestaEvento">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TIEMPO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MENSAJE" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "respuestaEvento", propOrder = {
    "tiempo",
    "mensaje"
})
public class RespuestaEvento {

    @XmlElement(name = "TIEMPO", required = true)
    protected String tiempo;
    @XmlElement(name = "MENSAJE", required = true)
    protected BigInteger mensaje;

    /**
     * Gets the value of the tiempo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTIEMPO() {
        return tiempo;
    }

    /**
     * Sets the value of the tiempo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTIEMPO(String value) {
        this.tiempo = value;
    }

    /**
     * Gets the value of the mensaje property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMENSAJE() {
        return mensaje;
    }

    /**
     * Sets the value of the mensaje property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMENSAJE(BigInteger value) {
        this.mensaje = value;
    }

}
