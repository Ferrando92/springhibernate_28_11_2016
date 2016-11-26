/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans.tablepersubclass;

/**
 *
 * @author Chema
 */
public class Circulo extends Figura{
private Integer radio;

    public Circulo() {
    }

    public Circulo(Integer color, Integer radio) {
        super(color);
        this.radio = radio;
    }

    public Integer getRadio() {
        return radio;
    }

    public void setRadio(Integer radio) {
        this.radio = radio;
    }

}
