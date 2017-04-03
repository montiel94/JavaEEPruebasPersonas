package com.vanesoft.vtrack.demonios.servicios.consultor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Daniel jose on 03/04/2017.
 */
public class ConsultorService {

    public static String getHoraActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
        return formateador.format(ahora);
    }

    private static boolean stop = false;

    public static void start(String[] args) {
        System.out.println("start");
        while (!stop) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(getHoraActual() + " : llamando a VTAS");
        }
    }

    public static void stop(String[] args) {
        System.out.println("stop");
        stop = true;
    }

    public static void main(String[] args) {
        if ("start".equals(args[0])) {
            start(args);
        } else if ("stop".equals(args[0])) {
            stop(args);
        }
    }
}
