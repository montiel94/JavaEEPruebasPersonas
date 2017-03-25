package com.vanesoft.vtrack.core.entidades;

import java.beans.Visibility;
import java.util.ArrayList;

/**
 * Created by Daniel jose on 12/03/2017.
 */

public class Pedido {
    int codigoPedido;
    int estado;
    String fechaCreacion;
    String cola;
    String cabezote;
    String chofer;
    String inicio;
    String fin;
    ArrayList<Evento> eventos;

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    public Pedido(int codigoPedido, int estado, String fechaCreacion) {
        this.codigoPedido = codigoPedido;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    public Pedido() {
    }

    public Pedido(int codigoPedido, int estado, String fechaCreacion, String cola, String cabezote, String chofer, String inicio, String fin,ArrayList<Evento> eventos) {
        this.codigoPedido = codigoPedido;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.cola = cola;
        this.cabezote = cabezote;
        this.chofer = chofer;
        this.inicio = inicio;
        this.fin = fin;
        this.eventos = eventos;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public int getEstado() {
        return estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public String getCola() {
        return cola;
    }

    public String getCabezote() {
        return cabezote;
    }

    public String getChofer() {
        return chofer;
    }

    public String getInicio() {
        return inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setCola(String cola) {
        this.cola = cola;
    }

    public void setCabezote(String cabezote) {
        this.cabezote = cabezote;
    }

    public void setChofer(String chofer) {
        this.chofer = chofer;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }
}
