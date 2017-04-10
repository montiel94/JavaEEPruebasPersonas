package com.vanesoft.vtrack.demonios.servicios.consultor;



import com.vanesoft.vtrack.demonios.servicios.consultor.Comandos.ComandoConvertirListaVtas;
import com.vanesoft.vtrack.demonios.servicios.consultor.Comandos.ComandoGetHoraActual;
import com.vanesoft.vtrack.demonios.servicios.consultor.Comandos.ComandoSincronizar;
import com.vanesoft.vtrack.demonios.servicios.consultor.Comandos.ComandoTratarListaVtrack;
import com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio.Pedido;
import com.vanesoft.vtrack.demonios.servicios.consultor.Fabricas.FabricaComando;
import com.vanesoft.vtrack.demonios.servicios.consultor.Fabricas.FabricaDAO;
import com.vanesoft.vtrack.demonios.servicios.consultor.soapvtassimulacion.WSActualizador;
import com.vanesoft.vtrack.demonios.servicios.consultor.soapvtassimulacion.WSActualizadorService;
import com.vanesoft.vtrack.demonios.servicios.consultor.utilidades.PropiedadesDemonios;

import java.util.List;


/**
 * Created by Daniel jose on 03/04/2017.
 */
public class ConsultorService {



    private static boolean stop = false;

    public static void start(String[] args) {
        System.out.println("start");
        while (!stop) {
            try {
                System.out.println("Empezando hilo");
                WSActualizadorService wsActualizadorService = new WSActualizadorService();
                WSActualizador wsActualizador = wsActualizadorService.getWSActualizadorPort();
                List<com.vanesoft.vtrack.demonios.servicios.consultor.soapvtassimulacion.Pedido>
                        prueba = wsActualizador.actualizarEstado(1,1);
                sincronizar();
                System.out.println("Llame WS");
                 ComandoConvertirListaVtas comandoConvertirListaPedidosVtas =
                        FabricaComando.obtenerComandoConvertirListaVtas(prueba);
                List<Pedido> listaPedidosVtrack = comandoConvertirListaPedidosVtas.ejecutar();
                tratarLista(listaPedidosVtrack);
                Thread.sleep(Integer.valueOf(PropiedadesDemonios.CONFIG_TIEMPO_LLAMADO_SOAP_VTAS));

            } catch (InterruptedException e) {
            }


        }
    }

    public static String sincronizar(){
        String ultimaSincronizacion = "";
        try
        {
            ComandoGetHoraActual comandoGetHoraActual
                    = FabricaComando.obtenerComandoGetHoraActual();
            ComandoSincronizar  comandoSincronizar =
                    FabricaComando.obtenerComandoSincronizar(comandoGetHoraActual.ejecutar());
            ultimaSincronizacion = comandoSincronizar.ejecutar();
        }catch(Exception e)
        {

        }
        return ultimaSincronizacion;
    }

    public static void tratarLista(List<Pedido> listaVtas){

        System.out.println("Saliendo de el metodo tratarLista");
        try
        {

            ComandoTratarListaVtrack comandoTratarListaVtrack =
                    FabricaComando.obtenerComandoTratarListaVtrack(listaVtas);
            comandoTratarListaVtrack.ejecutar();
        }catch (Exception e )
        {

        }
        System.out.println("saliendo de el metodo tratLista");
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
