/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Chema
 */
public class Coche extends Vehiculo {

    private Boolean airbag;
    private Motor motor;

    /**
     * Get the value of motor
     *
     * @return the value of motor
     */
    public Motor getMotor() {
        return motor;
    }

    /**
     * Set the value of motor
     *
     * @param motor new value of motor
     */
    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    /**
     * Get the value of airbag
     *
     * @return the value of airbag
     */
    public Boolean getAirbag() {
        return airbag;
    }

    /**
     * Set the value of airbag
     *
     * @param airbag new value of airbag
     */
    public void setAirbag(Boolean airbag) {
        this.airbag = airbag;
    }
}
