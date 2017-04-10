
package com.vanesoft.vtrack.demonios.servicios.consultor.soapvtassimulacion;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pedido complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pedido">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CABEZOTE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHOFER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CLIENTE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COLA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ESTADO" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="FIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INICIO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NUMERO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SOLICITUD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pedido", propOrder = {
    "cabezote",
    "chofer",
    "cliente",
    "cola",
    "estado",
    "fin",
    "inicio",
    "numero",
    "solicitud"
})
public class Pedido {

    @XmlElement(name = "CABEZOTE")
    protected String cabezote;
    @XmlElement(name = "CHOFER")
    protected String chofer;
    @XmlElement(name = "CLIENTE")
    protected String cliente;
    @XmlElement(name = "COLA")
    protected String cola;
    @XmlElement(name = "ESTADO")
    protected BigInteger estado;
    @XmlElement(name = "FIN")
    protected String fin;
    @XmlElement(name = "INICIO")
    protected String inicio;
    @XmlElement(name = "NUMERO")
    protected String numero;
    @XmlElement(name = "SOLICITUD")
    protected String solicitud;

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

    /**
     * Gets the value of the cliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCLIENTE() {
        return cliente;
    }

    /**
     * Sets the value of the cliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCLIENTE(String value) {
        this.cliente = value;
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
     * Gets the value of the estado property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getESTADO() {
        return estado;
    }

    /**
     * Sets the value of the estado property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setESTADO(BigInteger value) {
        this.estado = value;
    }

    /**
     * Gets the value of the fin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIN() {
        return fin;
    }

    /**
     * Sets the value of the fin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIN(String value) {
        this.fin = value;
    }

    /**
     * Gets the value of the inicio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINICIO() {
        return inicio;
    }

    /**
     * Sets the value of the inicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINICIO(String value) {
        this.inicio = value;
    }

    /**
     * Gets the value of the numero property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNUMERO() {
        return numero;
    }

    /**
     * Sets the value of the numero property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNUMERO(String value) {
        this.numero = value;
    }

    /**
     * Gets the value of the solicitud property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSOLICITUD() {
        return solicitud;
    }

    /**
     * Sets the value of the solicitud property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSOLICITUD(String value) {
        this.solicitud = value;
    }

}
