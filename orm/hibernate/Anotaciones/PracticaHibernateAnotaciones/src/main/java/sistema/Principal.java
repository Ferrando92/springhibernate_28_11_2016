/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import util.HibernateHook;

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
    }

    private void inicializarHibernate() {
        Runtime.getRuntime().addShutdownHook(new HibernateHook());
    }
}
