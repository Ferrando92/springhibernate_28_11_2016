package com.curso.springdaohibernateanotaciones.dominio;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Persona implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Aficion> aficiones;

    public Persona() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Mi nombre es " + getNombre();
    }

    public List<Aficion> getAficiones() {
        if (aficiones == null) {
            aficiones = new ArrayList<Aficion>();
        }
        return aficiones;
    }
}
