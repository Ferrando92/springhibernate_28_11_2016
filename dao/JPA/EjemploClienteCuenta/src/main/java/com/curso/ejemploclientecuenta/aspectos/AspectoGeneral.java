/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemploclientecuenta.aspectos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 *
 * @author jose maria
 */
@Component
@Aspect
public class AspectoGeneral {

    @Before("execution(* com.curso.ejemploclientecuenta.servicios.EjemploServicio.*(..)))")
    void traza(JoinPoint p) {
        System.out.format("ADVICE @BEFORE.Se va a ejecutar el método:%s\n", p.getSignature().toLongString().toUpperCase());
    }

    @AfterThrowing(pointcut = "execution(* com.curso.ejemploclientecuenta.servicios.EjemploServicio.*(..)))", throwing = "e")
    void logExcepcion(JoinPoint p, Exception e) {
        System.out.format("ADVICE @AFTERTHROWING.Ha ocurrido el error:%s al ejecutar el método %s\n", e.getMessage(), p.getSignature().toLongString().toUpperCase());
    }
}
