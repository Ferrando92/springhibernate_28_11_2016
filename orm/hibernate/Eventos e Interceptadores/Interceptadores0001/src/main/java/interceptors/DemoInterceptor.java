/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptors;

import anotaciones.Auditable;
import java.io.Serializable;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

/**
 *
 * @author Chema
 */
public class DemoInterceptor extends EmptyInterceptor {

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("Se va a crear un objeto persistente instancia de " + entity.getClass().getSimpleName());
        System.out.println("Con clave " + id);
        System.out.println("Con estado ");
        for (Object obj : state) {
            System.out.println("\t" + obj);
        }
        System.out.println("Con propiedades llamadas");
        for (Object obj : propertyNames) {
            System.out.println("\t" + obj);
        }
        System.out.println("Con tipos llamados");
        for(Object obj : types){
            System.out.println("\t" + obj);
        }
        Auditable auditable = entity.getClass().getAnnotation(Auditable.class);
        if (auditable != null) {
            if (auditable.avisarAlAdministrador()) {
                System.out.println("Esta operación se le comunicará al administrador por correo electrónico");
            }
        }
        return false;
    }
}
