package com.vanesoft.vtrack.core.utilidades;
import com.vanesoft.vtrack.core.utilidades.propiedades.CifrarDescifrar;
import junit.framework.TestCase;

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
        String prueba = CifrarDescifrar.cifrar( "aabbcc1122" );
        assertEquals(prueba,"daAE/DzPHcTpF5JVWkoeXQ==");
        String prueba2 = CifrarDescifrar.descifrar( "daAE/DzPHcTpF5JVWkoeXQ==" );
        assertEquals("aabbcc1122",prueba2);

    }

}
