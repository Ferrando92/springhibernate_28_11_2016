package com.curso.spring.wiringreemplazos;

import com.curso.spring.beans.Departamento;
import com.curso.spring.beans.Empleado;
import com.curso.spring.beans.Persona;
import com.curso.spring.beans.auto.Jefe;
import com.curso.spring.beans.metodo.GestorComandos;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

    private ApplicationContext ctx;

    public static void main(String[] args) {
        App principal = new App();
        principal.init();
        principal.cargarContextoPersona();
        principal.cargarContextoPersonaSingleton();
        principal.cargarContextoPersonaPrototipo();
        principal.cargarContextoInyectar();
        principal.cargarContextoAuto();
        principal.cargarContextoInyectarMetodo();
    }

    private void init() {
        ctx = new ClassPathXmlApplicationContext("beansContext.xml", "autoContext.xml", "metodoContext.xml");
    }

    private void cargarContextoPersona() {
        System.out.println("Contexto con factoría cargado");
        Persona defecto = ctx.getBean("personaDefecto", Persona.class);
        System.out.println(defecto);
        Persona factoria = ctx.getBean("personaFactoria", Persona.class);
        System.out.println(factoria);
    }

    private void cargarContextoPersonaSingleton() {
        System.out.println("Contexto usando singletons cargado");
        Persona defecto1 = ctx.getBean("personaDefecto", Persona.class);
        System.out.printf("%s,%s\n", defecto1, defecto1.hashCode());
        Persona defecto2 = ctx.getBean("personaDefecto", Persona.class);
        System.out.printf("%s,%s\n", defecto2, defecto2.hashCode());
    }

    private void cargarContextoPersonaPrototipo() {
        System.out.println("Contexto usando prototipos cargado");
        Persona defecto1 = ctx.getBean("personaPrototipo", Persona.class);
        System.out.printf("%s,%s\n", defecto1, defecto1.hashCode());
        Persona defecto2 = ctx.getBean("personaPrototipo", Persona.class);
        System.out.printf("%s,%s\n", defecto2, defecto2.hashCode());
    }

    private void cargarContextoInyectar() {
        System.out.println("Contexto usando inyección cargado");
        Empleado defecto1 = ctx.getBean("empleadoUno", Empleado.class);
        System.out.println(defecto1);
        Empleado defecto2 = ctx.getBean("empleadoDos", Empleado.class);
        System.out.println(defecto2);
        Departamento departamento = ctx.getBean("departamento", Departamento.class);
        System.out.println(departamento);
    }

    private void cargarContextoAuto() {
        System.out.println("Contexto usando auto enlace cargado");
        Jefe jefe1 = ctx.getBean("jefeUno", Jefe.class);
        System.out.println(jefe1);
    }

    private void cargarContextoInyectarMetodo() {
        System.out.println("Contexto usando inyección de métodos cargado");
        GestorComandos gestorComandos = ctx.getBean("gestorComandos", GestorComandos.class);
        gestorComandos.ejecutar("Esta orden");
        gestorComandos.otroMetodo();
        GestorComandos gestorComandos1 = ctx.getBean("gestorComandos1", GestorComandos.class);
        gestorComandos1.ejecutar("Aquella orden");
        gestorComandos1.otroMetodo();
    }
}
