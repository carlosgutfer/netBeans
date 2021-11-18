/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemploExamen5;

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
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author carlo
 */
public class Principal {

    private static   ArrayList<Cliente> allClientes;
    private static   ArrayList<Producto> allProductos;
    public static void main(String[] args) throws IOException, TransformerException {
        
        
        leerFicheroXML(); 
        escribirFicheroFacturas();
    }

    private static void leerFicheroXML() throws IOException {
        File f = new File("datos.xml");
        try {
            SAXParserFactory spf=SAXParserFactory.newInstance();
            SAXParser sp=spf.newSAXParser();
            Manejador m=new Manejador(); 
            sp.parse(f, m);
            allClientes = m.getAllClientes();
            allProductos = m.getAllProductos();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void escribirFicheroFacturas() throws TransformerException
    {
        try 
        {
            Element facturas, factura, nombre, descripcion, unidades, precio, total;
            Text value;
            Boolean productoEncontrado;
            File f = new File("facturas.xml");
            
            DocumentBuilderFactory dbf =  DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder(); 
            Document doc = db.newDocument();
            
            facturas = doc.createElement("Facturas");
            doc.appendChild(facturas);
            
            for(int i = 0; i < allClientes.size(); ++i)
            {
                productoEncontrado = false;
               for(int j = 0; j < allProductos.size() && !productoEncontrado; ++j)
               {
                   if(allProductos.get(j).getId().equals(allClientes.get(i).getArticulo()))
                   {
                       productoEncontrado = true;
                       if(allProductos.get(j).getStock() - allClientes.get(i).getUnidades() >= 0)
                       {
                           factura = doc.createElement("factura");
                           factura.setAttribute("NIF", allClientes.get(i).getNIF());
                           facturas.appendChild(factura);
                           
                           nombre = doc.createElement("Nombre");
                           value = doc.createTextNode(allClientes.get(i).getNombre());
                           nombre.appendChild(value);
                           factura.appendChild(nombre);
                           
                           descripcion = doc.createElement("descripcion");
                           value = doc.createTextNode(allProductos.get(j).getDescripcion());
                           descripcion.appendChild(value);
                           factura.appendChild(descripcion);
                           
                           unidades = doc.createElement("Unidades");
                           value = doc.createTextNode(String.valueOf(allClientes.get(i).getUnidades()));
                           unidades.appendChild(value);
                           factura.appendChild(unidades);
                           
                           precio = doc.createElement("Precio");
                           value = doc.createTextNode(String.valueOf(allProductos.get(j).getPrecio()));
                           precio.appendChild(value);
                           factura.appendChild(precio);
                           
                           total = doc.createElement("Total");
                           value = doc.createTextNode(String.valueOf(allClientes.get(i).getUnidades() * allProductos.get(j).getPrecio()));
                           total.appendChild(value);
                           factura.appendChild(total);
                           
                       }else
                       {
                           System.out.println("Error en el pedido del cliente " + allClientes.get(i).getNIF() + " las unidades pedidas sobrepasan el stock");
                       } 
                   }
                }
            }
            TransformerFactory tf = TransformerFactory.newInstance();  
            Transformer transformer;  
            transformer = tf.newTransformer();
            DOMSource ds= new DOMSource(doc);  
            StreamResult sr= new StreamResult(f);  
            StreamResult sr1 = new StreamResult(System.out);  
            transformer.transform(ds, sr1);
            transformer.transform(ds, sr);
             
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (TransformerConfigurationException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
