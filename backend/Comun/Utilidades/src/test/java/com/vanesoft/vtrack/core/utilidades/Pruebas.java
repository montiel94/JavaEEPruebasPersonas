package com.vanesoft.vtrack.core.utilidades;
import com.vanesoft.vtrack.core.entidades.ParametroMensaje;
import com.vanesoft.vtrack.core.utilidades.propiedades.Armador;
import com.vanesoft.vtrack.core.utilidades.propiedades.CifrarDescifrar;
import junit.framework.TestCase;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by Daniel jose on 07/02/2017.
 */
public class Pruebas extends TestCase {
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
    }

    public void testCifrarDescifrar()
    {
        //String prueba = CifrarDescifrar.cifrar( "aabbcc3377" );
        //assertEquals(prueba,"daAE/DzPHcTpF5JVWkoeXQ==");
        String prueba2 = CifrarDescifrar.descifrar( "daAE/DzPHcTpF5JVWkoeXQ==" );
        assertEquals("aabbcc1122",prueba2);

    }

    public void testArmarCorreoBloqueoPorLogin (){
        String mensaje = "Estimado(a) cliente: //////////\\n\\nSu usuario registrada en el Sistema Vtrack ha sido bloqueado por realizar login con una contraseña invalida.\\n\\nSe ha generado una contraseña temporal para la recuperacion de este usuario. Su contraseña provicional es la siquiente : &&&&&&&&&\\n\\nLe recordamos:\\n\\nLa contraseña temporal se genera automáticamente en el tercer intento fallido de login.\\n\\nGracias por utilizar Vtrack.\\n\\nVaneSoft.\\n\\nEsta es una cuenta de correo electrónico no monitoreada, no responda o reenvíe mensajes a esta cuenta.";
        Hashtable<String,String> valores = new Hashtable<String,String>();
        valores.put(ParametroMensaje.NombreParametroPassword,"CONTRASENAPROVISIONAL");
        valores.put(ParametroMensaje.nombreParametroNombreUsuario,"Shell");
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(ParametroMensaje.nombreUsuario);
        parametros.add(ParametroMensaje.password);
        String mensajefinal = Armador.armarMensaje(mensaje,parametros,valores);
        String mensajeReplace = "Estimado(a) cliente: Shell\\n\\nSu usuario registrada en el Sistema Vtrack ha sido bloqueado por realizar login con una contraseña invalida.\\n\\nSe ha generado una contraseña temporal para la recuperacion de este usuario. Su contraseña provicional es la siquiente : CONTRASENAPROVISIONAL\\n\\nLe recordamos:\\n\\nLa contraseña temporal se genera automáticamente en el tercer intento fallido de login.\\n\\nGracias por utilizar Vtrack.\\n\\nVaneSoft.\\n\\nEsta es una cuenta de correo electrónico no monitoreada, no responda o reenvíe mensajes a esta cuenta.";
        assertEquals(mensajefinal,mensajeReplace);
    }

}
