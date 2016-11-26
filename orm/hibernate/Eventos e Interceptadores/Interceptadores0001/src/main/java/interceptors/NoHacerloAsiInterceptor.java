/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interceptors;

import java.io.Serializable;
import java.util.Iterator;
import org.hibernate.CallbackException;
import org.hibernate.EntityMode;
import org.hibernate.Interceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

/**
 *
 * @author Chema
 */
public class NoHacerloAsiInterceptor implements Interceptor{

    public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) throws CallbackException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void onCollectionRecreate(Object collection, Serializable key) throws CallbackException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void onCollectionRemove(Object collection, Serializable key) throws CallbackException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void onCollectionUpdate(Object collection, Serializable key) throws CallbackException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void preFlush(Iterator entities) throws CallbackException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void postFlush(Iterator entities) throws CallbackException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Boolean isTransient(Object entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int[] findDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object instantiate(String entityName, EntityMode entityMode, Serializable id) throws CallbackException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getEntityName(Object object) throws CallbackException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object getEntity(String entityName, Serializable id) throws CallbackException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void afterTransactionBegin(Transaction tx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void beforeTransactionCompletion(Transaction tx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void afterTransactionCompletion(Transaction tx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String onPrepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
