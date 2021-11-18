/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemploExamen5;

import com.sun.security.ntlm.Client;
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
    private ArrayList<Cliente> allClientes = new ArrayList<Cliente>();
    private Cliente c;
    private ArrayList<Producto> allProductos = new ArrayList<Producto>();
    private Producto p;
    private StringBuilder sb = new StringBuilder();

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        sb.append(chars, i, i1); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void endElement(String string, String string1, String qName) throws SAXException {
        switch(qName)
        {
            case "nombre":
                    c.setNombre(sb.toString());
                break;
            case "NIF":
                c.setNIF(sb.toString());
                break;
            case "fecha":
                c.setFecha(sb.toString());
                break;
            case "articulo":
                c.setArticulo(sb.toString());
                break;
            case "unidades":
                c.setUnidades(Integer.valueOf(sb.toString()));
                break;
            case "descripcion":
                p.setDescripcion(sb.toString());
                break;
            case "precio":
                p.setPrecio(Integer.valueOf(sb.toString()));
                break;
            case "stock":
                p.setStock(Integer.valueOf(sb.toString()));
                break;
        }
    }

    @Override
    public void startElement(String string, String string1, String qName, Attributes atrbts) throws SAXException {
        switch(qName)
        {
            case "cliente":
                                c = new Cliente(Integer.valueOf(atrbts.getValue("id")));
                                allClientes.add(c);
                         break;
            case "producto":
                            p = new Producto(atrbts.getValue("id"));
                            allProductos.add(p);
                break;
            case "nombre":
            case "NIF":
            case "fecha":
            case "articulo":
            case "unidades":
            case "descripcion":
            case "precio":
            case "stock":
                sb.delete(0, sb.length());
                break;
        }
    }

    public ArrayList<Cliente> getAllClientes() {
        return allClientes;
    }

    public ArrayList<Producto> getAllProductos() {
        return allProductos;
    }
    
    
    
}
