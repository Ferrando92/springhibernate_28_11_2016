/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.controladores;

import com.curso.java.dao.Dao;
import com.curso.java.entidades.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jose maria
 */
@Controller
@RequestMapping("/alta.html")
public class ControladorAlta {

    @Autowired
    private Dao dao;

    @Autowired
    private Vehiculo vehiculo;

    @ModelAttribute("vehiculo")
    public Vehiculo daIgual() {
        return new Vehiculo();
    }

    @RequestMapping(method = RequestMethod.GET)
    public void verFormularioAlta() {
    }

    @RequestMapping(method = RequestMethod.POST)
    public String procesarFormularioAlta(@ModelAttribute("vehiculo") Vehiculo v, Model modelo) {
        dao.guardar(v);
        modelo.addAttribute("vehiculo", v);
        modelo.addAttribute("cantidad", dao.todos().size());
        return "ver";
    }
}
