/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author carlo
 */
public class manejador extends DefaultHandler
{
    ArrayList<Pais> lista = new ArrayList<>();
    Pais p;
    StringBuilder sb = new StringBuilder();

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        sb.append(chars, i, i1); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    switch(qName)
        {
            case "Continente":
                    p.setContinente(sb.toString());
                break;
            case "Pais":
                    p.setPais(sb.toString());
                break;
            case "Capital":
                p.setCapital(sb.toString());
                break;
            case "Habitantes":
                 p.setHabitantes(Integer.parseInt(sb.toString()));
                break;
        }    
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atrbts) throws SAXException {
        switch(qName)
        {
            case "Localidad":
                    p = new Pais();
                    lista.add(p);
                    p.setNumero(Integer.parseInt(atrbts.getValue("numero")));
                break;
            case "Continente":
            case "Pais":
            case "Capital":
            case "Habitantes":
                sb.delete(0, sb.length());
                break;
        }
    }

   public ArrayList<Pais> getLista() {
        return lista;
        }
    
    
}
