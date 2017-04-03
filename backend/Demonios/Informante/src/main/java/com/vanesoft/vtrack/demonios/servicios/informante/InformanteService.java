package com.vanesoft.vtrack.demonios.servicios.informante;

/**
 * Created by Daniel jose on 31/03/2017.
 */
public class InformanteService {


    private static boolean stop = false;

    public static void start(String[] args) {
        System.out.println("start");
        while (!stop) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("running");
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
