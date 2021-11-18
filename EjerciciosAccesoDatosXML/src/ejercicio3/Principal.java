/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;





/**
 *
 * @author carlo
 */
public class Principal 
{
    static  ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    static  double mediaCurso = 0;
    static  Element alumno,nombre, nota1, nota2, proyecto, practica, media;
    static  Document d, doc ;


    public  void main(String[] args) throws ParserConfigurationException, TransformerConfigurationException, TransformerException, IOException 
    {
        crearXMLNotas();
        alumnos.clear();
        leerXMLNotas();
        crearXMLMedia();  
    }

    private static void crearXMLMedia() throws TransformerConfigurationException, ParserConfigurationException, TransformerFactoryConfigurationError, DOMException, TransformerException {
        DocumentBuilderFactory dbf1 =  DocumentBuilderFactory.newInstance();
        DocumentBuilder db1 = dbf1.newDocumentBuilder();
        doc = db1.newDocument();
        Element root = doc.createElement("Notas");
        root.setAttribute("MediaCurso", String.valueOf(mediaCurso));
        doc.appendChild(root);
        
        alumnos.forEach(al ->{
            alumno = doc.createElement("alumno");
            
            nombre = doc.createElement("nombre");
            Text valor = doc.createTextNode(al.getNombre());
            nombre.appendChild(valor);
            
            media = doc.createElement("media");
            valor = doc.createTextNode(String.valueOf(al.getNotaMedia()));
            media.appendChild(valor);
            
            alumno.appendChild(nombre);
            alumno.appendChild(media);
            
            root.appendChild(alumno);
        });
        
        TransformerFactory tf1 = TransformerFactory.newInstance();
        Transformer t1 = tf1.newTransformer();
        DOMSource dom1 = new DOMSource(doc);
        StreamResult sr2= new StreamResult(new File("notasMedias.xml"));
        StreamResult sr3 = new StreamResult(System.out);
        t1.transform(dom1, sr2);
        t1.transform(dom1, sr3);
        /* <nombre> Juan Carlos Jimenez </nombre>
        <nota1>5</nota1>
        <nota2>7</nota2>
        <proyecto>8</proyecto>
        <practica>9</practica*/
    }

    private static void leerXMLNotas() throws ParserConfigurationException, IOException {
        File f = new File("notas.xml");
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try
        {
            SAXParser sp = spf.newSAXParser();
            Manejador m = new Manejador();
            sp.parse(f, m);
            alumnos = Manejador.getAlumnos();
            alumnos.forEach(al -> {
                double nota = (double)((al.getNota1() + al.getNota2() + al.getPractica() + al.getProyecto()) / 4);
                al.setNotaMedia(nota);
                System.out.println(nota);
                mediaCurso += nota;
            });
            System.out.println("");
        } catch (SAXException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        mediaCurso = mediaCurso / 3;
        System.out.println(mediaCurso);
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

    private static void crearXMLNotas() throws TransformerConfigurationException, DOMException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
        DocumentBuilderFactory dbf =  DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        d = db.newDocument();
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
            
            proyecto = d.createElement("proyecto");
            valor = d.createTextNode(String.valueOf(alumnos.get(i).getProyecto()));
            proyecto.appendChild(valor);
            main.appendChild(proyecto);
            
            practica = d.createElement("practica");
            valor = d.createTextNode(String.valueOf(alumnos.get(i).getPractica()));
            practica.appendChild(valor);
            main.appendChild(practica);
        }
        
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        DOMSource dom = new DOMSource(d);
        
        StreamResult sr = new StreamResult(new File("notas.xml"));
        StreamResult sr1 = new StreamResult(System.out);
        
        t.transform(dom, sr);
        t.transform(dom, sr1);
    }
}
