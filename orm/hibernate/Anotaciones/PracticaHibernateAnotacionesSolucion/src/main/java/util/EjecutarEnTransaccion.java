/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Chema
 */
public class EjecutarEnTransaccion {

    public void ejecutar(Operacion op) {
        Session s = null;
        try {
            s = HibernateUtil.getSessionFactory().getCurrentSession();
            s.getTransaction().begin();
            op.ejecutar(s);
            s.getTransaction().commit();
        } catch (HibernateException e) {
            if (s != null) {
                s.getTransaction().rollback();
            }
            System.out.println("Ha ocurrido un error " + e);
        }
    }
}
