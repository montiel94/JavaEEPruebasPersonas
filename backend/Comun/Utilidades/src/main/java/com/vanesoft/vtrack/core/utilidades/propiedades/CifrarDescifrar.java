package com.vanesoft.vtrack.core.utilidades.propiedades;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64;
/**
 * Created by Daniel jose on 07/02/2017.
 */
public class CifrarDescifrar {

    /**
     * llave del algoritmo
     */
    private static String key = "92AE31A79FEEB2A3";


    /**
     * Vector de inicializacion
     */
    private static String iv = "0123456789ABCDEF";

    //</editor-fold>

    // Definición del tipo de algoritmo a utilizar (AES, DES, RSA)
    private final static String alg = "AES";


    // Definición del modo de cifrado a utilizar
    private final static String cI = "AES/CBC/PKCS5Padding";


    /**
     * Nombre:                  cifrar
     * Descripcion:             Metodo que se encarga de encriptar
     * @version                 1.0
     * @author                  montda
     * @since                   07/02/17
     *
     * @param dato dato desencriptado
     * @return dato encriptado
     */
    public static String cifrar(String dato)
    {
        String retorno;
        try
        {
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(dato.getBytes());
            retorno = new String(encodeBase64(encrypted));
        }
        catch (Exception e)
        {
            //Retorna en limpio ya que no se puede encriptar
            retorno = "";
        }
        return retorno;
    }

    /**
     * Nombre:                  descifrar
     * Descripcion:             Metodo que desencripta
     * @version                 1.0
     * @author                  montda
     * @since                   07/03/17
     *
     */
    public static String descifrar(String dato)
    {
        String retorno;
        try
        {
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            byte[] enc = decodeBase64(dato);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] decrypted = cipher.doFinal(enc);
            retorno = new String(decrypted);
        }
        catch (Exception e)
        {
            //Retorna en limpio ya que no se puede encriptar
            retorno = "";

        }
        return retorno;
    }

    /**
     * Nombre:                  cifradoSeguro
     * Descripcion:             Metodo que primero verifica que los datos ya no se encuentren cifrados
     * @version                 1.0
     * @author                  montda
     * @since                   07/01/17
     *
     * @return data cifrada
     */
    public static String cifradoSeguro(String clave)
    {
        String retorno = descifrar(clave);
        if (retorno.equals(""))
            retorno = cifrar(clave);
        else
            retorno = clave;

        return retorno;
    }


    /**
     * Nombre:                  descifradoSeguro
     * Descripcion:             Metodo que primero verifica que los datos ya no se encuentren cifrados
     * @version                 1.0
     * @author                  montda
     * @since                   07/03/17
     *
     * @return data descifrada
     */
    public static String descifradoSeguro(String clave)
    {
        String retorno = descifrar(clave);
        if (retorno.equals(""))
            retorno = clave;

        return retorno;
    }




}
