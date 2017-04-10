package com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/*
    Sistema : Vtrack
    Class : Armador
    Descriocion : Clase encargada de armar mensajes
    author : montda
    fecha : 09/02/2017
 */
public class Armador {
    /*
           Descripcion : arma el mensaje
           parametros : mensaje parametrizado mensajes con parametros
           parametros : parametros a ser reemplazados
           valores : valores a insertar en el mensaje
           author : montda
           fecha 09/02/2017

     */
    public static String armarMensaje(String mensajeParametrisado, ArrayList<String> parametros, Hashtable<String,String> valores)
    {
        //para recorrer arraylist de parametros
        Iterator<String> iteratorParametros = parametros.iterator();
        while (iteratorParametros.hasNext())
        {
            String parametro = iteratorParametros.next();
            if (parametro.equals(ParametroMensaje.nombreUsuario))
            {
                mensajeParametrisado = mensajeParametrisado.replace(parametro,
                        valores.get(ParametroMensaje.nombreParametroNombreUsuario));
            }
            if (parametro.equals(ParametroMensaje.password))
            {
                mensajeParametrisado = mensajeParametrisado.replace(parametro,
                        valores.get(ParametroMensaje.NombreParametroPassword));
            }
            if (parametro.equals(ParametroMensaje.codigopedido))
            {
                mensajeParametrisado = mensajeParametrisado.replace(parametro,
                        valores.get(ParametroMensaje.nombreParametroCodigoPedido));
            }
            if (parametro.equals(ParametroMensaje.horaInicioLlenado))
            {
                mensajeParametrisado = mensajeParametrisado.replace(parametro,
                        valores.get(ParametroMensaje.nombreHoraInicioLlenado));
            }
            if (parametro.equals(ParametroMensaje.horaFinLlenado))
            {
                mensajeParametrisado = mensajeParametrisado.replace(parametro,
                        valores.get(ParametroMensaje.nombreHoraFinLlenado));
            }
            if (parametro.equals(ParametroMensaje.chofer))
            {
                mensajeParametrisado = mensajeParametrisado.replace(parametro,
                        valores.get(ParametroMensaje.nombreChofer));
            }
            if (parametro.equals(ParametroMensaje.cabezote))
            {
                mensajeParametrisado = mensajeParametrisado.replace(parametro,
                        valores.get(ParametroMensaje.nombreCabezote));
            }
            if (parametro.equals(ParametroMensaje.cola))
            {
                mensajeParametrisado = mensajeParametrisado.replace(parametro,
                        valores.get(ParametroMensaje.nombreCola));
            }
            if (parametro.equals(ParametroMensaje.estadoPedido))
            {
                mensajeParametrisado = mensajeParametrisado.replace(parametro,
                        valores.get(ParametroMensaje.nombreEstadoPedido));
            }
        }
        return mensajeParametrisado;
    }


}
