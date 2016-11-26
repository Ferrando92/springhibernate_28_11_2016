/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author usuario
 */
public interface Log {

    default void log() {
        System.out.println("En " + getClass().getName());
    }
}
