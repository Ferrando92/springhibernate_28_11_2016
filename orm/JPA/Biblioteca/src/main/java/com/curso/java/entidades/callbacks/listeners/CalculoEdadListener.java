/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.callbacks.listeners;

import java.util.Calendar;
import static java.util.Calendar.*;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

/**
 *
 * @author jose maria
 */
public class CalculoEdadListener {

    @PostLoad
    @PostPersist
    @PostUpdate
    public void calcularEdad(ClienteListener cliente) {
        Calendar fecha = new GregorianCalendar();
        fecha.setTime(cliente.getFechaNacimiento());
        Calendar hoy = new GregorianCalendar();
        hoy.setTime(new Date());
        int ajuste = 0;
        if (hoy.get(DAY_OF_YEAR) - fecha.get(DAY_OF_YEAR) < 0) {
            ajuste = -1;
        }
        cliente.setEdad(hoy.get(YEAR) - fecha.get(YEAR) + ajuste);
    }
}
