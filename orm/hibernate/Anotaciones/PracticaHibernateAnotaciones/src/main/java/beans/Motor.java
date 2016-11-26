/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author Chema
 */
public class Motor implements Serializable {

    private Integer cilindrada;

    /**
     * Get the value of cilindrada
     *
     * @return the value of cilindrada
     */
    public Integer getCilindrada() {
        return cilindrada;
    }

    /**
     * Set the value of cilindrada
     *
     * @param cilindrada new value of cilindrada
     */
    public void setCilindrada(Integer cilindrada) {
        this.cilindrada = cilindrada;
    }
}
