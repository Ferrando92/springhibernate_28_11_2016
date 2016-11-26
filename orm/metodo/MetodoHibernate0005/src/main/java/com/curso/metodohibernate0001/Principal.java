/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.metodohibernate0001;

import com.curso.utilidades.HibernateUtil;
import org.hibernate.SessionFactory;

/**
 *
 * @author Administrador
 */
public class Principal {

    private final SessionFactory sf = HibernateUtil.getSessionFactory();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal p = new Principal();
        p.sf.close();
        System.exit(0);
    }

}
