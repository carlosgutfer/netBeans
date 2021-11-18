/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemploExamen2;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
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
public class Main {
    
    static   ArrayList<Lote> allLotes = new ArrayList<Lote>();
    public  void main(String[] args) 
    {
        getLotes(); 
        
        Element resumen, articulo, cajas, cantidad, total, peso;
        Text value;
        try 
        {
            DocumentBuilderFactory dbf =  DocumentBuilderFactory.newInstance();  
            DocumentBuilder db = dbf.newDocumentBuilder();  
            Document doc = db.newDocument();
            
            resumen = doc.createElement("Resumen");
            doc.appendChild(resumen);
            int totalPeso;
            
            for(int i = 0; i < allLotes.size(); ++i)
            {
                articulo = doc.createElement("articulo");
                articulo.setAttribute("nombre", allLotes.get(i).getContenido().getComponente());
                resumen.appendChild(articulo);
                
                cajas = doc.createElement("cajas");
                value = doc.createTextNode(String.valueOf(allLotes.get(i).getNumCajas()));
                cajas.appendChild(value);
                articulo.appendChild(cajas);
                
                cantidad = doc.createElement("cantidad");
                value = doc.createTextNode(String.valueOf(allLotes.get(i).getContenido().getUnidades()));
                cantidad.appendChild(value);
                articulo.appendChild(cantidad);
                
                totalPeso = allLotes.get(i).getNumCajas() * allLotes.get(i).getContenido().getUnidades();
                total = doc.createElement("total");
                value = doc.createTextNode(String.valueOf(totalPeso));
                total.appendChild(value);
                articulo.appendChild(total);
                
                peso = doc.createElement("peso");
                value = doc.createTextNode(String.valueOf(allLotes.get(i).getPeso()));
                peso.appendChild(value);
                articulo.appendChild(peso);
            }
            
            TransformerFactory tf = TransformerFactory.newInstance();  
            Transformer transformer = tf.newTransformer();  
            DOMSource ds= new DOMSource(doc);  
            StreamResult sr= new StreamResult(new File("Resumen.xml"));  
            StreamResult sr1 = new StreamResult(System.out);  
            transformer.transform(ds, sr1);
            transformer.transform(ds, sr);
        } catch (Exception e) 
        {
        }
        
        
    }

    private static void getLotes() 
    {
        try
        {
            SAXParserFactory spf=SAXParserFactory.newInstance();
            SAXParser sp=spf.newSAXParser();
            Manejador m=new Manejador();
            sp.parse(new File("Almacen.xml"), m);
            allLotes =  m.getLotes();
        } catch (Exception e) 
        {
            System.out.println("EjemploExamen2.Main.main()" + e);
        }
    }
}
