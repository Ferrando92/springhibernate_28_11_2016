/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Chema
 */
public class HibernateHook extends Thread {

    @Override
    public void run() {
        HibernateUtil.getSessionFactoryUno().close();
        System.out.println("Factoría de sesiones uno cerrada");
        HibernateUtil.getSessionFactoryUno().close();
        System.out.println("Factoría de sesiones dos cerrada");
    }
}
