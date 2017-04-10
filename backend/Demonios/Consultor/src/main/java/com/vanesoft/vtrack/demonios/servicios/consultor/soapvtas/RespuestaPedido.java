
package com.vanesoft.vtrack.demonios.servicios.consultor.soapvtas;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for respuestaPedido complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="respuestaPedido">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NUMERO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ESTADO" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="SOLICITUD" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CLIENTE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="COLA" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CABEZOTE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CHOFER" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="INICIO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FIN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "respuestaPedido", propOrder = {
    "numero",
    "estado",
    "solicitud",
    "cliente",
    "cola",
    "cabezote",
    "chofer",
    "inicio",
    "fin"
})
public class RespuestaPedido {

    @XmlElement(name = "NUMERO", required = true)
    protected String numero;
    @XmlElement(name = "ESTADO", required = true)
    protected BigInteger estado;
    @XmlElement(name = "SOLICITUD", required = true)
    protected String solicitud;
    @XmlElement(name = "CLIENTE", required = true)
    protected String cliente;
    @XmlElement(name = "COLA", required = true)
    protected String cola;
    @XmlElement(name = "CABEZOTE", required = true)
    protected String cabezote;
    @XmlElement(name = "CHOFER", required = true)
    protected String chofer;
    @XmlElement(name = "INICIO", required = true)
    protected String inicio;
    @XmlElement(name = "FIN", required = true)
    protected String fin;

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

}
