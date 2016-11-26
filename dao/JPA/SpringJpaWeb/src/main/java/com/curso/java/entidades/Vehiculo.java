/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author jose maria
 */
@Component
@Scope("prototype")
@Entity
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String marca;
    private String matricula;
    private String modelo;
    @Value("false")
    private Boolean estado;
    private Double precio;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String matricula, String modelo, Boolean estado, Double precio) {
        this.marca = marca;
        this.matricula = matricula;
        this.modelo = modelo;
        this.estado = estado;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return String.format("Vehículo:%d. Marca:%s.", id, marca);
    }
}
