/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans.tableperconcreteclass;

import java.io.Serializable;

/**
 *
 * @author Chema
 */
public class Vehiculo implements Serializable{
private Long id;
private String matricula;

    public Vehiculo() {
    }

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        if ((this.matricula == null) ? (other.matricula != null) : !this.matricula.equals(other.matricula)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.matricula != null ? this.matricula.hashCode() : 0);
        return hash;
    }

}
