/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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
public class Main 
{
    public  void main(String[] args) 
    {
        File f = new File("empresa.bin");
        File f2 = new File("Empresa.xml");
        inicializarFicheros(f, f2);
        inicializarBinario(f);
        
        try 
        {
            Element root, departamento, nombre, localidad;
            Text valor;
            FileInputStream fis = new FileInputStream(f);
            DataInputStream dis = new DataInputStream(fis);
            
            DocumentBuilderFactory dbf =  DocumentBuilderFactory.newInstance();  
            DocumentBuilder db = dbf.newDocumentBuilder();  
            Document doc = db.newDocument();
            
            root = doc.createElement("empresa");
            doc.appendChild(root);
            try {
                while(true)
                {
     

                    departamento = doc.createElement("departamento");
                departamento.setAttribute("numeroDepartamento", String.valueOf(dis.readInt()));
                root.appendChild(departamento);
                
                nombre = doc.createElement("nombre");
                valor = doc.createTextNode(dis.readUTF());
                nombre.appendChild(valor);
                departamento.appendChild(nombre);
                
                
                localidad = doc.createElement("localidad");
                valor = doc.createTextNode(dis.readUTF());
                localidad.appendChild(valor);
                departamento.appendChild(localidad);
                
                }
            } catch (Exception e) { System.err.println(e);
            }  
            dis.close();
            fis.close();
            
            TransformerFactory tf = TransformerFactory.newInstance();  
            Transformer transformer = tf.newTransformer();  
            DOMSource ds= new DOMSource(doc);  
            StreamResult sr= new StreamResult(f2);  
            StreamResult sr1 = new StreamResult(System.out);  
            transformer.transform(ds, sr1);
            transformer.transform(ds, sr);
        } catch (Exception e) {
        }

    }

    private static void inicializarBinario(File f) 
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(f);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(1);
            dos.writeUTF("Ventas");
            dos.writeUTF("Madrid");
            
            dos.writeInt(2);
            dos.writeUTF("RRHH");
            dos.writeUTF("Madrid");
            
            dos.writeInt(3);
            dos.writeUTF("Logística");
            dos.writeUTF("Alcalá");
            
            fos.close();
            dos.close();
        }catch(Exception e){}
    }

    private static void inicializarFicheros(File f, File f2) {
        try {
            if (f.exists())
                f.delete();
            if(f2.exists())
                f2.delete();
            f.createNewFile();
        } catch (Exception e) {
        }
    }
    
}
