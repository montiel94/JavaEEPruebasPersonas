package com.vanesoft.vtrack.demonios.servicios.consultor.Comandos;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Daniel jose on 09/04/2017.
 */
public class ComandoGetHoraActual {

    public String ejecutar() {
        Date ahora = new Date();
        SimpleDateFormat formateadorHora = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat formateadorFecha = new SimpleDateFormat("yyyy-MM-dd");
        return  formateadorFecha.format(ahora) +" "+ formateadorHora.format(ahora);
    }
}
