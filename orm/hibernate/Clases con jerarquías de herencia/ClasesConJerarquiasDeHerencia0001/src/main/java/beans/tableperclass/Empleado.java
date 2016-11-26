/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.tableperclass;

/**
 *
 * @author Chema
 */
public class Empleado extends Usuario {

    private Double sueldo = 0.0d;

    public Empleado() {
    }

    public Empleado(String nombre, String clave, Double sueldo) {
        super(nombre, clave);
        this.sueldo = sueldo;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return super.toString() + ".Sueldo " + getSueldo();
    }
}
