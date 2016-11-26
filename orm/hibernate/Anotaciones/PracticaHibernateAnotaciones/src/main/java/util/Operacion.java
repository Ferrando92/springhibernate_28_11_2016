/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.hibernate.Session;

/**
 *
 * @author Chema
 */
public interface Operacion {

    void ejecutar(Session s);
}
