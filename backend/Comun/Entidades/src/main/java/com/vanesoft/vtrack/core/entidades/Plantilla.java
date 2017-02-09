package com.vanesoft.vtrack.core.entidades;

/**
 * Sistema:             Vtrack
 * Nombre:              Plantilla
 * Descripcion:         plantilla de texto a ser enviado
 *
 * @author montda
 * @version 1.0
 * @since 09/02/2017
 */
public class Plantilla {

    public String texto;
    public String nombre;
    public String titulo;

    public Plantilla(String texto, String nombre, String titulo) {
        this.texto = texto;
        this.nombre = nombre;
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
