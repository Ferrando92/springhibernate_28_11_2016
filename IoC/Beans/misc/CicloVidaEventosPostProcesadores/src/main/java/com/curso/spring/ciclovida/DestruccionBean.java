/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.ciclovida;

import org.springframework.beans.factory.DisposableBean;

/**
 *
 * @author user
 */
public class DestruccionBean implements DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("Destrucción de este bean");
    }
}
