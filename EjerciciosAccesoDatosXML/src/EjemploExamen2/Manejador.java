/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemploExamen2;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author carlo
 */
public class Manejador  extends DefaultHandler
{
    
    private ArrayList<Lote> allLotes = new ArrayList<Lote>();
    private  Lote l;
    private Contenido c;
    private StringBuffer sb = new StringBuffer();

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        sb.append(chars, i, i1);    
        }

    @Override
    public void endElement(String string, String s1, String nombreEtiqueta) throws SAXException 
    {
        switch(nombreEtiqueta)
        {
            case "numcajas":
                l.setNumCajas(Integer.parseInt(sb.toString()));
                break;
            case "componente":
                   c.setComponente(sb.toString());
                break;
            case "numserie":
                    c.setNumSerie(sb.toString());
                break;
            case "unidades":
                c.setUnidades(Integer.valueOf(sb.toString()));
                break;
            case "peso":
                l.setPeso(Integer.valueOf(sb.toString()));
                break;
            case "manipulacion":
                l.setManipulacion(sb.toString());
                break;
        }
    }

    @Override
    public void startElement(String string, String string1, String nombreEtiqueta, Attributes atrbts) throws SAXException {
        switch(nombreEtiqueta)
        {
            case "lote":
                    l = new Lote(Integer.parseInt(atrbts.getValue("id")));
                    allLotes.add(l);
             break;
             case "contenido":
                    c = new Contenido();
                    l.setContenido(c);
             break;
             case "numcajas":
             case "componente":
             case "numserie":
             case "unidades":
             case "peso":
             case "manipulacion":
                 sb.delete(0, sb.length());
                 break;
        }
    }

    public  ArrayList<Lote> getLotes() 
    {
       return allLotes; 
    }
    
    
    
}
