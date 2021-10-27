/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5and6;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class ejercicio5and6 
{
    public static void main(String[] args) 
    {
        File f1 = new File("alumnos.obj");
        if(f1.exists())
            f1.delete();
        try 
        {
            f1.createNewFile();
            FileOutputStream fos = new FileOutputStream(f1);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new alumno(1, "carlos", 10));
            oos.writeObject(new alumno(2, "Juan", 10));
            oos.writeObject(new alumno(3, "Pepe", 10));
            oos.writeObject(new alumno(4, "Raul", 10));
            oos.writeObject(new alumno(5, "Ivan", 10));
            oos.writeObject(new alumno(6, "Lucia", 10));
            oos.writeObject(new alumno(7, "Ainara", 10));
            oos.writeObject(new alumno(8, "Ruben", 10));
            oos.writeObject(new alumno(9, "Mari Carmen", 10));
            oos.writeObject(new alumno(10, "Albert", 10));
            oos.close();
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(ejercicio5and6.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
