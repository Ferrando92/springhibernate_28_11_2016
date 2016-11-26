/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.beans;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrador
 */
@Component
public class GestorOxm implements Serializable {

    private static final String ARCHIVO = "personas.xml";
    @Autowired
    private Marshaller marshaller;
    @Autowired
    private Unmarshaller unmarshaller;

    public void guardarPersona(Persona persona) {
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(ARCHIVO);
            marshaller.marshal(persona, new StreamResult(os));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestorOxm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | XmlMappingException ex) {
            Logger.getLogger(GestorOxm.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException ex) {
                    Logger.getLogger(GestorOxm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public Persona cargarPersona() {
        Persona persona = null;
        FileInputStream is = null;
        try {
            is = new FileInputStream(ARCHIVO);
            persona = (Persona) unmarshaller.unmarshal(new StreamSource(is));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestorOxm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | XmlMappingException ex) {
            Logger.getLogger(GestorOxm.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                    Logger.getLogger(GestorOxm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return persona;
    }
}
