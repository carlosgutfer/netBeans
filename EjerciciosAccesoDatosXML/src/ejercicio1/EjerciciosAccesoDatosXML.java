/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author carlo
 */
public class EjerciciosAccesoDatosXML {

    /**
     * @param args the command line arguments
     */
    public  void main(String[] args) {
        File f = new File("Paises.xml");
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser sp = spf.newSAXParser();
            manejador m = new manejador();
            sp.parse(f, m);
            ArrayList<Pais> list = m.getLista();
            list.forEach(c -> {
                System.out.println(c.toString());
            });
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(EjerciciosAccesoDatosXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(EjerciciosAccesoDatosXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EjerciciosAccesoDatosXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
