/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class clase7_ficheros_binarios 
{
    public  void main(String[] args) 
    {
     
        File f1 = new File("nominas.dat");  
        File f2 = new File("nominas.txt");
        try 
        {
            if(f1.exists())
                f1.delete();
            f1.createNewFile();
            f2.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(clase7_ficheros_binarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try 
        {
            FileReader fr = new FileReader(f2);
            BufferedReader br = new BufferedReader(fr);
            
            FileOutputStream fos = new FileOutputStream(f1);
            DataOutputStream dos = new DataOutputStream(fos);
            
            
            String linea = br.readLine();
            while(linea != null)
            {
                String[] datos = linea.split("/");
                dos.writeInt(Integer.valueOf(datos[0]));
                dos.writeUTF(datos[1]);
                dos.writeDouble(Double.valueOf(datos[2]));
                linea = br.readLine();
            }
            
            dos.close();
            fos.close();
            
            br.close();
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(clase7_ficheros_binarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //escribir_fichero_binario(f1); 
        leer_fichero_binario(f1); 
        
        
        
    }

    private static void leer_fichero_binario(File f1) 
    {
        try
        {
            FileInputStream fis = new FileInputStream(f1);
            DataInputStream dis = new DataInputStream(fis);
            
            int id;
            String nombre;
            double sueldo;
           
            try {
                while(true)
                {
                    id = dis.readInt();
                    nombre = dis.readUTF();
                    sueldo = dis.readDouble();
                    System.out.println(id + "/" + nombre + "/" + sueldo);
                }
            } catch (IOException ex) 
            {
                System.out.println("FINAL DE FICHERO ");
            }

            dis.close();
            fis.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(clase7_ficheros_binarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(clase7_ficheros_binarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void escribir_fichero_binario(File f1) 
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(f1);
            DataOutputStream dos = new DataOutputStream(fos);
       
            //Id de tipo entero, nombre de tipo string , sueldo tipo double
            dos.writeInt(1);
            dos.writeUTF("Juan");
            dos.writeDouble(2000);
            
            dos.writeInt(2);
            dos.writeUTF("Carlos");
            dos.writeDouble(2000);
            
            dos.writeInt(3);
            dos.writeUTF("Luis");
            dos.writeDouble(2000);
            
            dos.writeInt(4);
            dos.writeUTF("Ramon");
            dos.writeDouble(2000);
            
            dos.writeInt(5);
            dos.writeUTF("Manuel");
            dos.writeDouble(2000);
            
            dos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(clase7_ficheros_binarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(clase7_ficheros_binarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
