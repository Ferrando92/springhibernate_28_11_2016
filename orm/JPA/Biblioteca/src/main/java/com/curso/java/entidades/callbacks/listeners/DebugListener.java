/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.callbacks.listeners;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

/**
 *
 * @author jose maria
 */
public class DebugListener {

    @PrePersist
    void prePersist(Object object) {
        System.out.println("prePersist");
    }

    @PostPersist
    void postPersist(Object object) {
        System.out.println("postPersist");
    }

    @PreUpdate
    void preUpdate(Object object) {
        System.out.println("preUpdate");
    }

    @PostUpdate
    void postUpdate(Object object) {
        System.out.println("postUpdate");
    }

    @PreRemove
    void preRemove(Object object) {
        System.out.println("preRemove");
    }

    @PostRemove
    void postRemove(Object object) {
        System.out.println("postRemove");
    }

    @PostLoad
    void postLoad(Object object) {
        System.out.println("postLoad");
    }
}
