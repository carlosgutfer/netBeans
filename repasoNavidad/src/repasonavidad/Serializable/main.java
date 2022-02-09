/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad.Serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class main {
    
   Scanner sc = new Scanner(System.in);
   static File f1 = new File("alumnos.obj");

    public  void main(String[] args) 
    {
  
        if(f1.exists())
            f1.delete();
        try 
        {
            f1.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try 
        {
            FileOutputStream    fos = new FileOutputStream(f1);
            ObjectOutputStream  oos = new ObjectOutputStream(fos); //esto es como que añade al fichero que es del tipo alumno
            oos.writeObject(new Alumno(1, "carlos", "gutierrez"));
            oos.close();
            fos.close();        
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        añadir_datos();  
        
        leer_fichero();
        modificar_fichero_serializable(); 
        leer_fichero();

    }     

    private static void modificar_fichero_serializable() {
        try
        {
            File auxiliar =  new File ("hola.obj");
            
            FileInputStream fis = new FileInputStream(f1);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            FileOutputStream fos = new FileOutputStream(auxiliar);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            try 
            {
                Alumno alumno;
                while(true)
                {
                    alumno = (Alumno) ois.readObject();
                    if(alumno.getId()!= 2)
                        oos.writeObject(alumno);
                }
            } catch (Exception e) {
            }
            
            ois.close();
            fis.close();
            
            oos.close();
            fos.close();
            
            f1.delete();
            auxiliar.renameTo(f1);
        } catch (IOException ex) {
        }
    }     

    private static void añadir_datos() 
    {
        try
        {
            FileOutputStream    fos = new FileOutputStream(f1, true);
            MiClaseOutput       moo = new MiClaseOutput(fos); //esta, como ya tiene tipo, no lo vuelve a añadir porque daría error.
           
            moo.writeObject(new Alumno(2, "Pepe", "palotes"));
            moo.writeObject(new Alumno(3, "Juan", "JUNA"));
            moo.close();
            fos.close();     
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }     

    private static void leer_fichero() 
    {
        try
        {
            FileInputStream     fis = new FileInputStream(f1);
            ObjectInputStream   ois = new ObjectInputStream(fis);
            Alumno alumno;
            try 
            {
                while(true)
                {
                    alumno = (Alumno) ois.readObject();
                    System.out.println(alumno.toString());
                }
                
            }catch (Exception ex) {

            }
             ois.close();
            fis.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {

        }
    }     
}
