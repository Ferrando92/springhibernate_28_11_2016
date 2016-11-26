/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.single_table.Empleado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Chema
 */
@Entity(name = "EmpresaSingleTable")
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private List<Empleado> personal;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    public List<Empleado> getPersonal() {
        if (personal == null) {
            personal = new ArrayList<Empleado>();
        }
        return personal;
    }

    public void setPersonal(List<Empleado> personal) {
        this.personal = personal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Empresa[id=" + id + "]";
    }
}
