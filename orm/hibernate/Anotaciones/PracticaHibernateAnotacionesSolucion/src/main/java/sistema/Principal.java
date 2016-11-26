/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import beans.Coche;
import beans.Conductor;
import beans.Motor;
import org.hibernate.Session;
import util.EjecutarEnTransaccion;
import util.HibernateHook;
import util.Operacion;

/**
 *
 * @author Chema
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal p = new Principal();
        p.inicializarHibernate();
        p.nuevoCoche();
        System.out.println("Fin");
    }

    private void inicializarHibernate() {
        Runtime.getRuntime().addShutdownHook(new HibernateHook());
    }

    private void nuevoCoche() {
        Conductor conductor = new Conductor();
        conductor.setNombre("abc");
        Motor motor = new Motor();
        motor.setCilindrada(1500);
        final Coche coche = new Coche();
        coche.setAirbag(true);
        coche.setConductor(conductor);
        coche.setMotor(motor);
        coche.setMatricula("xyz");
        coche.setPrecio(16000d);
        conductor.setVehiculo(coche);
        EjecutarEnTransaccion e = new EjecutarEnTransaccion();
        e.ejecutar(new Operacion() {
            @Override
            public void ejecutar(Session s) {
                s.persist(coche);
            }
        });
    }
}
