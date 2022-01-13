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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class main {
    
    public static void main(String[] args) 
    {
        File f1 = new File("alumnos.obj");
        
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
            
            oos.close();
            fos.close();        
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        leer_fichero(f1);
        añadir_datos(f1);  
        leer_fichero(f1);
    }     

    private static void añadir_datos(File f1) 
    {
        try
        {
            FileOutputStream    fos = new FileOutputStream(f1, true);
            MiClaseOutput       moo = new MiClaseOutput(fos); //esta, como ya tiene tipo, no lo vuelve a añadir porque daría error.
            moo.writeObject(new Alumno(1, "carlos", "gutierrez"));
            moo.writeObject(new Alumno(2, "Pepe", "palotes"));
            moo.close();
            fos.close();     
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }     

    private static void leer_fichero(File f1) 
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
            }catch (ClassNotFoundException ex) {
               
            }
            ois.close();
            fis.close(); 
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }     
}
