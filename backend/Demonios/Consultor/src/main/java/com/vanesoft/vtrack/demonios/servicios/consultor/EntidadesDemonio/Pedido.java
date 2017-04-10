package com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio;


import java.math.BigInteger;

/**
 * Created by Daniel jose on 05/04/2017.
 */
public class Pedido {

    protected String numero;

    protected BigInteger estado;

    protected String solicitud;

    protected String cliente;

    protected String cola;

    protected String cabezote;

    protected String chofer;

    protected String inicio;

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
