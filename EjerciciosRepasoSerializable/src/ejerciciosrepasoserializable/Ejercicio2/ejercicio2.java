/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosrepasoserializable.Ejercicio2;

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
public class ejercicio2 
{
    public static void main(String[] args) 
    {
        File f1 = crearFichero();
        escribirRegistro(f1);
        mostrarMedia(f1);
    }

    private static File crearFichero() 
    {
        File f1 =  new File("notas.obj");
        try 
        {   if(f1.exists())
                f1.delete();
            f1.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f1;
    }

    private static void escribirRegistro(File f1) 
    {
        try 
        {
            FileOutputStream fos = new FileOutputStream(f1);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            String registro [];
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduzca nombre de usuario y notas separado nombre notas con espacio y cada nota con una - (Ejem: carlos 7-8-7-6-9-8)");   
            registro = sc.nextLine().trim().split(" ");
            oos.writeObject(new alumno(registro[0], registro[1].split("-")));
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void mostrarMedia(File f1) 
    {
        try 
        {
            FileInputStream fis = new FileInputStream(f1);
            ObjectInputStream ois = new ObjectInputStream(fis);
            try {
                alumno registro;
                int num = 0;
                while(true)
                {
                    registro = (alumno) ois.readObject();
                    for(int i = 0; i < registro.getNotas().length; i++)
                        num += Integer.parseInt(registro.getNotas()[i]);
                    System.out.println("Nombre: " + registro.getNombre() + " Media: " + num / registro.getNotas().length);
                }
            } catch (Exception e) {
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
