/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author carlo
 */
public class Manejador extends DefaultHandler
{
       StringBuilder sb = new StringBuilder("");
       Persona p;
       ArrayList<Persona> allpersonas = new ArrayList<Persona>();
    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        sb.append(chars, i, i1); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void endElement(String string, String string1, String header) throws SAXException 
    {
        switch(header)
        {
            case "nombre":
                    p.setNombre(sb.toString());
                break;
            case "edad":
                    p.setEdad(Integer.valueOf(sb.toString()));
                break;
        }
    }

    @Override
    public void startElement(String string, String string1, String header, Attributes atrbts) throws SAXException 
    {
        switch(header)
        {
            case "alumno":
                        p = new Persona();
                        allpersonas.add(p);
                break;
            case "nombre":
            case "edad":
                sb.delete(0, sb.length());
                
                
                break;
        }
    }

    public ArrayList<Persona> getPersonas() {
        return allpersonas;
    }
        
}
