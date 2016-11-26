/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans.tableperconcreteclass;

/**
 *
 * @author Chema
 */
public class Moto extends Vehiculo{
private Boolean airbag;

    public Moto() {
    }

    public Moto(String matricula, Boolean airbag) {
        super(matricula);
        this.airbag = airbag;
    }

    public Boolean getAirbag() {
        return airbag;
    }

    public void setAirbag(Boolean airbag) {
        this.airbag = airbag;
    }

}
