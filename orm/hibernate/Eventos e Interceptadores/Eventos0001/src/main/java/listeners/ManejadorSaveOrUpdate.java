/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package listeners;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.event.spi.SaveOrUpdateEventListener;



/**
 *
 * @author Chema
 */
public class ManejadorSaveOrUpdate implements SaveOrUpdateEventListener{

    @Override
    public void onSaveOrUpdate(SaveOrUpdateEvent event) throws HibernateException {
        System.out.format("onSaveOrUpdate invocado sobre un objeto instancia de %s%n",event.getEntityName());
    }
}
