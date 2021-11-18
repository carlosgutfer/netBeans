/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author carlo
 */
public class Main {
    
    public  void main(String[] args) 
    {
        File f = new File("FichPersona.dat");
        File f2 = new File("FichPersona.xml");
        crearFichero(f, f2);
        escribirFichero(f); 
        leerYEscribirXML(f, f2);
        
    }

    private static void escribirFichero(File f) {
        try
        {
            FileOutputStream fos = new FileOutputStream(f, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new Persona(23, "Carlos"));
            oos.writeObject(new Persona(24, "Juan"));
            oos.writeObject(new Persona(24, "Raquel"));
            oos.close();
            fos.close();
        } catch (Exception e) {
        }
    }

    private static void crearFichero(File f, File f2) 
    {
        if (f.exists())
            f.delete();
        if(f2.exists())
            f2.delete();
        try 
        {
            f.createNewFile();
            f2.createNewFile();
        } catch (Exception e) {
        }
    }

    private static void leerYEscribirXML(File f, File f2) 
    {
        ArrayList<Persona> allPersonas = new ArrayList<Persona>();
        try 
        {
            FileInputStream fis= new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            try {
               
                while(true)
                {
                    Persona p;
                    p = (Persona) ois.readObject();
                    allPersonas.add(p);
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
        escribirXML(allPersonas, f2);
    }

    private static void escribirXML(ArrayList<Persona> allPersonas, File f2) 
    {
        Element alumno,nombre, edad, root;
        Text valor;
        try
        {
            DocumentBuilderFactory dbf =  DocumentBuilderFactory.newInstance();  
            DocumentBuilder db = dbf.newDocumentBuilder();  
            Document doc = db.newDocument();
            root = doc.createElement("poblacion");
            doc.appendChild(root);
            
            for(int i = 0; i < allPersonas.size(); ++i)
            {
                alumno = doc.createElement("alumno");
                
                nombre = doc.createElement("nombre");
                valor = doc.createTextNode(allPersonas.get(i).getNombre());
                nombre.appendChild(valor);
                alumno.appendChild(nombre);
                
                edad = doc.createElement("edad");
                valor = doc.createTextNode(String.valueOf(allPersonas.get(i).getEdad()));
                edad.appendChild(valor);
                alumno.appendChild(edad);
                
                root.appendChild(alumno);
            }
            TransformerFactory tf = TransformerFactory.newInstance();  
            Transformer transformer = tf.newTransformer();  
            DOMSource ds= new DOMSource(doc);  
            StreamResult sr= new StreamResult(f2);  
            transformer.transform(ds, sr);
            leerXML(f2);
        }catch(ParserConfigurationException | TransformerConfigurationException | DOMException  e){}catch(Exception e){}
    }

    private static void leerXML(File f2) 
    {
        ArrayList<Persona> pers = new ArrayList<>();
        try 
        {
         SAXParserFactory spf=SAXParserFactory.newInstance();
         SAXParser sp=spf.newSAXParser();
         Manejador m=new Manejador();
         sp.parse(f2, m);
         pers = m.getPersonas();
         pers.forEach(p ->{
             System.out.println(p.toString());
         });
        } catch (Exception e) { System.out.println(e);
        }
    }
    
}
