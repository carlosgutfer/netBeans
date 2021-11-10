/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;





/**
 *
 * @author carlo
 */
public class Principal 
{
    static  ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    public static void main(String[] args) throws ParserConfigurationException, TransformerConfigurationException, TransformerException 
    {
        Element alumno,nombre, nota1, nota2, proyecto, practica;
        DocumentBuilderFactory dbf =  DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document d = db.newDocument();
        Element main = d.createElement("curso");
        d.appendChild(main);
        
        alumnos.add(new Alumno("jj", "Juan Carlos Jimenez", 5, 7, 8, 9));
        alumnos.add(new Alumno("cp", "Christian Perez", 7, 8, 7, 4));
        alumnos.add(new Alumno("sf", "Sonia Fernandez", 6, 9, 10, 10));
        for(int i = 0; i < alumnos.size(); ++i)
        {
            alumno = d.createElement("alumno");
            main.appendChild(alumno);
            alumno.setAttribute("id", alumnos.get(i).getId());
            
            nombre = d.createElement("nombre");
            Text valor = d.createTextNode(alumnos.get(i).getNombre());
            nombre.appendChild(valor);
            alumno.appendChild(nombre);
            
            nota1 = d.createElement("nota1");
            valor = d.createTextNode(String.valueOf(alumnos.get(i).getNota1()));
            nota1.appendChild(valor);
            alumno.appendChild(nota1);
   
            nota2 = d.createElement("nota2");
            valor = d.createTextNode(String.valueOf(alumnos.get(i).getNota2()));
            nota2.appendChild(valor);
            alumno.appendChild(nota2);
            
            
            
        } 
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        DOMSource dom = new DOMSource(d);
        
       StreamResult sr=new StreamResult(new File("notas.xml"));
       StreamResult sr1=new StreamResult(System.out);

       t.transform(dom, sr);
       t.transform(dom, sr1);
        /* <nombre> Juan Carlos Jimenez </nombre> 
      <nota1>5</nota1> 
      <nota2>7</nota2> 
      <proyecto>8</proyecto> 
      <practica>9</practica*/
        
        
        
        
    }
    
    
    /*    
    public static void main(String[] args) throws ParserConfigurationException, TransformerConfigurationException, TransformerException 
    {
       DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
       DocumentBuilder db=dbf.newDocumentBuilder();
       Document d= db.newDocument();
       Element root= d.createElement("Concesionario");
       d.appendChild(root);

       for(int i=1;i<=3;i++)
       {
        Element coche=d.createElement("Coche");
        root.appendChild(coche);
        Attr id=d.createAttribute("id");
        id.setValue(String.valueOf(i));
        coche.setAttributeNode(id);

        Element marca = d.createElement("Marca");
        Text valor=d.createTextNode("Renault");
        marca.appendChild(valor);
        coche.appendChild(marca);

        Element modelo = d.createElement("Modelo");
        modelo.appendChild(d.createTextNode("Scenic"));
        coche.appendChild(modelo);

        Element cc = d.createElement("cc");
        cc.appendChild(d.createTextNode("1.9"));
        coche.appendChild(cc);
       }

       TransformerFactory tf=TransformerFactory.newInstance();
       Transformer t=tf.newTransformer();
       DOMSource ds=new DOMSource(d);

       StreamResult sr=new StreamResult(new File("Coches.xml"));
       StreamResult sr1=new StreamResult(System.out);

       t.transform(ds, sr);
       t.transform(ds, sr1);
       }*/
}
