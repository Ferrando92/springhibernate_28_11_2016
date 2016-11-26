/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Chema
 */
@Entity
public abstract class Vehiculo implements Serializable {

    private String matricula;
    private Double precio;
    @OneToOne(mappedBy = "vehiculo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Conductor conductor;
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the value of conductor
     *
     * @return the value of conductor
     */
    public Conductor getConductor() {
        return conductor;
    }

    /**
     * Set the value of conductor
     *
     * @param conductor new value of conductor
     */
    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    /**
     * Get the value of precio
     *
     * @return the value of precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * Set the value of precio
     *
     * @param precio new value of precio
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Get the value of matricula
     *
     * @return the value of matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Set the value of matricula
     *
     * @param matricula new value of matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
