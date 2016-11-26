/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.logging.Level;
import java.util.logging.Logger;
import listeners.ManejadorSaveOrUpdate;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

/**
 *
 * @author jose maria
 */
public class Integrador implements Integrator{
private ManejadorSaveOrUpdate msou = new ManejadorSaveOrUpdate();
    @Override
    public void integrate(Configuration c, SessionFactoryImplementor sfi, SessionFactoryServiceRegistry sfsr) {
        final EventListenerRegistry eventListenerRegistry = sfsr.getService( EventListenerRegistry.class );

        // EventListenerRegistry define 3 formas de registro:
        //     1) Sobreescribir cualquier otro listenes registrado 
        eventListenerRegistry.setListeners( EventType.SAVE_UPDATE, msou );
        //     2) Añadir al principio de la lista
//        eventListenerRegistry.prependListeners( EventType.SAVE_UPDATE, msou );
        //     3) Añadir al final de la lista
//        eventListenerRegistry.appendListeners( EventType.SAVE_UPDATE, msou );
    }
    private static final Logger LOG = Logger.getLogger(Integrador.class.getName());

    @Override
    public void integrate(MetadataImplementor mi, SessionFactoryImplementor sfi, SessionFactoryServiceRegistry sfsr) {
        LOG.log(Level.WARNING, "Versión del método integreate no usada");
    }

    @Override
    public void disintegrate(SessionFactoryImplementor sfi, SessionFactoryServiceRegistry sfsr) {
        LOG.log(Level.WARNING, "Versión del método disintegrate no usada");
    }
    
}
