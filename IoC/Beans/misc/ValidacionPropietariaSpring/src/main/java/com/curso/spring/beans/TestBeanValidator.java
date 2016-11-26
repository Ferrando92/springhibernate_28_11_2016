/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.beans;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Alejandra
 */
public class TestBeanValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return TestBean.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TestBean test = (TestBean) target;
        if (test.getNombre().length() < 5) {
            errors.rejectValue("nombre", "corto", "El nombre debe tener más de cinco caracteres");
        }
    }
}
