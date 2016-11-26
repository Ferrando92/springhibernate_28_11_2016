/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans.tablepersubclass;

import java.io.Serializable;

/**
 *
 * @author Chema
 */
public class Figura implements Serializable {
private Long id;
private Integer color;

    public Figura() {
    }

    public Figura(Integer color) {
        this.color = color;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Figura other = (Figura) obj;
        if (this.color != other.color && (this.color == null || !this.color.equals(other.color))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.color != null ? this.color.hashCode() : 0);
        return hash;
    }
}
