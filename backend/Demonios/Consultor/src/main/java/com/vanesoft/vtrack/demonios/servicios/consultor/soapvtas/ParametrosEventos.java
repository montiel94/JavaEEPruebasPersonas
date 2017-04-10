
package com.vanesoft.vtrack.demonios.servicios.consultor.soapvtas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for parametrosEventos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="parametrosEventos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PEDIDO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TIEMPO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="COLA" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CABEZOTE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CHOFER" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parametrosEventos", propOrder = {
    "pedido",
    "tiempo",
    "cola",
    "cabezote",
    "chofer"
})
public class ParametrosEventos {

    @XmlElement(name = "PEDIDO", required = true)
    protected String pedido;
    @XmlElement(name = "TIEMPO", required = true)
    protected String tiempo;
    @XmlElement(name = "COLA", required = true)
    protected String cola;
    @XmlElement(name = "CABEZOTE", required = true)
    protected String cabezote;
    @XmlElement(name = "CHOFER", required = true)
    protected String chofer;

    /**
     * Gets the value of the pedido property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPEDIDO() {
        return pedido;
    }

    /**
     * Sets the value of the pedido property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPEDIDO(String value) {
        this.pedido = value;
    }

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
     * Gets the value of the cola property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOLA() {
        return cola;
    }

    /**
     * Sets the value of the cola property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOLA(String value) {
        this.cola = value;
    }

    /**
     * Gets the value of the cabezote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCABEZOTE() {
        return cabezote;
    }

    /**
     * Sets the value of the cabezote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCABEZOTE(String value) {
        this.cabezote = value;
    }

    /**
     * Gets the value of the chofer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHOFER() {
        return chofer;
    }

    /**
     * Sets the value of the chofer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHOFER(String value) {
        this.chofer = value;
    }

}
