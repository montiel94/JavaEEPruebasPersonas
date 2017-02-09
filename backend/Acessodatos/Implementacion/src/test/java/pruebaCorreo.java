/**
 * Created by Daniel jose on 08/02/2017.
 */
import com.vanesoft.vtrack.core.accesodatos.implementacion.DaoCorreo;
import com.vanesoft.vtrack.core.entidades.Correo;
import com.vanesoft.vtrack.core.utilidades.propiedades.CifrarDescifrar;
import junit.framework.TestCase;
public class pruebaCorreo extends TestCase{
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
    }

    public void testEnviarCorreo()
    {
        String mensaje = "Estimado(a) cliente: Shell <BR> <BR> Su usuario registrada en el Sistema Vtrack ha sido bloqueado por realizar login con una contraseña invalida.\\n\\nSe ha generado una contraseña temporal para la recuperacion de este usuario. Su contraseña provicional es la siquiente : n0QSAsRu9VQ0cpp0ydMBMQ==\\n\\nLe recordamos:\\n\\nLa contraseña temporal se genera automáticamente en el tercer intento fallido de login.\\n\\nGracias por utilizar Vtrack.\\n\\nVaneSoft.\\n\\nEsta es una cuenta de correo electrónico no monitoreada, no responda o reenvíe mensajes a esta cuenta.";
        DaoCorreo daoCorreo = new DaoCorreo();
        Correo correoEnviado = new Correo("dmscanniello@gmail.com",
                "dmscanniello@gmail.com",
                "Panta1994-",
                "PRUEBA ASUNTO",
                mensaje);
        daoCorreo.enviarCorreo(correoEnviado);
    }
}
