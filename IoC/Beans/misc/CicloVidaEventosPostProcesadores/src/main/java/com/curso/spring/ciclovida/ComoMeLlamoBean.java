/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.ciclovida;

import org.springframework.beans.factory.BeanNameAware;

/**
 *
 * @author user
 */
public class ComoMeLlamoBean implements BeanNameAware {

    @Override
    public void setBeanName(String idBean) {
        System.out.format("El identificador de este bean es %s%n", idBean);
    }
}
