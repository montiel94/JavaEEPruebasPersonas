package com.vanesoft.vtrack.webservice.logica.implementacion.interceptores;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import  com.vanesoft.vtrack.webservice.logica.implementacion.interceptores.TokenSecurity;
/**
 * Created by Daniel jose on 16/03/2017.
 */
@Interceptor
@TokenSecurity
public class TokenSecurityInterceptor {

    @AroundInvoke
    public Object checkSecurity(InvocationContext context) throws Exception {
        /* comprobar los parámetros o realizar una comprobación de seguridad genérica antes de invocar el
           método original */
        Object[] params = context.getParameters();

        /* si la validación de seguridad falla, puede generar una excepción */
        System.out.println("holaaaaaaaaaa");
        /* invocar el método proceed() para que llame al método original */
        Object ret = context.proceed();

        /* realizar cualquier trabajo posterior a llamada de método */
        return ret;
    }
}