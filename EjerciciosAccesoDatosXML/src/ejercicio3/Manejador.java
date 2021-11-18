/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

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

    static ArrayList<Alumno> getAlumnos() 
    {
        return alumnos;
    }
    StringBuilder sb = new StringBuilder();
    static ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    Alumno a;
    
    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        sb.append(chars, i, i1); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void endElement(String uri, String localname, String qname) throws SAXException {
            switch(qname)
            {
                case "nombre":
                        a.setNombre(sb.toString());
                    break;
                case "nota1":
                    a.setNota1(Integer.valueOf(sb.toString()));
                    break;
                case "nota2":
                        a.setNota1(Integer.valueOf(sb.toString()));
                    break;
                case "practica":
                        a.setPractica(Integer.valueOf(sb.toString()));                    
                    break;
                case "proyecto":
                        a.setProyecto(Integer.valueOf(sb.toString()));                                        
                    break;
            }
    }

    @Override
    public void startElement(String uri, String localname, String qname, Attributes atrbts) throws SAXException 
    {
       switch(qname)
            {
                case "alumno":
                                a = new Alumno(atrbts.getValue("id"));
                                alumnos.add(a);
                    break;
                case "nombre":
                case "nota1":
                case "nota2":
                case "practica":
                case "proyecto":
                    sb.delete(0, sb.length());
                    break;
            }
    }
    
    
}
