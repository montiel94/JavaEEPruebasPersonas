package com.vanesoft.vtrack.core.entidades;

/**
 * Sistema:             Vtrack
 * Nombre:              CodigoToken
 * Descripcion:         Contiene la información de los codigos de autorización y tokens generados para la interacción
 *
 * @author montda
 * @version 1.0
 * @since 03/02/2017
 */
public class CodigoToken extends EntidadBase{
    //region atributos
        private String valor;
        private String tipo;
        private String codigoDispositivo;
    //end region atributos

    /*
        Constructores de la entidad
     */
    public CodigoToken () {
        this.valor = "";
        this.tipo = "";
        this.codigoDispositivo = "";
    }

    public CodigoToken(String valor,String tipo,String codigoDispositivo){
        this.valor = valor;
        this.tipo = tipo;
        this.codigoDispositivo = codigoDispositivo;
    }

    public CodigoToken(String valor,String tipo){
        this.valor = valor;
        this.tipo = tipo;
    }
    /*
        gets de la entidad
     */
    public String getValor (){
        return valor;
    }

    public String getTipo() {
        return tipo;
    }
    public String getCodigoDispositivo (){
        return codigoDispositivo;
    }
    /*
       set de l
     */
    public void setValor(String valor){
        this.valor = valor;
    }

    public void setTipo (String tipo){
        this.tipo = tipo;
    }

    public void setCodigoDispositivo (String codigoDispositivo){
        this.codigoDispositivo = codigoDispositivo;
    }
}
