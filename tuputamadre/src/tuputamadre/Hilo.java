/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuputamadre;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author carlo
 */
public class Hilo implements  Runnable{

    private final Socket s;
    public Hilo(Socket s) {
        this.s = s;
    }

    
    @Override
    public void run() 
    {
           

            byte [] html_index = getHTML("site\\index.html");
            byte [] html_pagina2 = getHTML("site\\pagina2.html");
            byte [] css = getHTML("site\\main.css");
            byte [] icon = getHTML("site\\favicon.ico");
            // BufferedImage image = getImagesAndIcon(in);
            
            String respuesta_index = "HTTP/1.1 200 OK \r\nContent-Type: text/html \r\nContent-Length: " + html_index.length + "\n\r\n\r" ;
            String respuesta_pagina2 = "HTTP/1.1 200 OK \r\nContent-Type: text/html \r\nContent-Length: " + html_pagina2.length  + "\r\n\r\n";
            String respuesta_css = "HTTP/1.1 200 OK  \r\n Content-Type: text/css \r\n Content-Length: " + css.length + "\r\n\r\n";
            String respuesta_icon = "HTTP/1.1 200 OK  \r\n Content-Type: image/ico \r\n Content-Length: " + icon.length + "\r\n\r\n";
            
            String cabecera;
            boolean cerrado = true;
                while(cerrado)
                {
                  InputStream  in = getInput();
                   OutputStream  out = getOutPut();    
                    cabecera = "";
                    cabecera = leer_cabecera(in, cabecera);
                    if(cabecera.contains("GET / HTTP/1.1") || cabecera.contains("GET /index.html HTTP/1.1"))
                        enviar_mensaje(out, respuesta_index, html_index, cerrado);
                    else if(cabecera.contains("GET /pagina2.html HTTP/1.1"))
                        enviar_mensaje(out, respuesta_pagina2, html_pagina2, cerrado);
                    else if(cabecera.contains("GET /main.css HTTP/1.1"))
                        enviar_mensaje(out, respuesta_css, css, cerrado);
                    else if(cabecera.contains("GET /favicon.ico HTTP/1.1"))
                        enviar_mensaje(out, respuesta_icon, icon, cerrado);
                    System.out.println(cabecera);

                }
           
    }

    private OutputStream getOutPut() {
        OutputStream  out = null;
        try {
            out = s.getOutputStream();
        } catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }

    private InputStream getInput()  {
        InputStream  in = null;
        try {
            in = s.getInputStream();
        } catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return in;
    }

    private String leer_cabecera(InputStream in, String cabecera)  {
        int _byte;
        boolean encontrado = false;
        try {
            while((_byte = in.read()) != -1 && !encontrado)
            {
                    if(_byte != 13)
                        cabecera += (char)_byte;
                    else 
                        encontrado = true;
            }
        } catch (IOException ex) {
        }
        return cabecera;
    }

    private void enviar_mensaje(OutputStream out, String respuesta_index, byte[] html_index, boolean  cerrado){
        
        try 
        {
            out.write(respuesta_index.getBytes());
            out.write(html_index);
            out.write("\n\r\n\r".getBytes());
        } catch (IOException ex) {
            System.out.println("El navegador se ha cerrado");
            cerrado = false;
        }
    }

    private BufferedImage getImagesAndIcon(InputStream in) {
         BufferedImage image = null;
        try {
            byte[] imageAr = new byte[62100];
            in.read(imageAr);
            image = ImageIO.read(new ByteArrayInputStream(imageAr));
        } catch (IOException ex) {}
         return image;
    }
    
     private static byte [] getHTML(String siteindexhtml) 
    {
         byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(Paths.get(siteindexhtml));
        } catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bytes;  
    }
   
     
    
}
