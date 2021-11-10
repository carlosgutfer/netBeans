/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5and6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class ejercicio5and6 
{
    public static void main(String[] args) throws IOException 
    {
        File f1 = new File("alumnos.obj");
        File f2 = new File("auxiliar.dat");
        if (f2.exists())
            f2.delete();
        f2.createNewFile();
        alumno al;
        iniciarFicheroSerializable(f1);

        RandomAccessFile raf = new RandomAccessFile(f2, "rw");
        try {
            FileInputStream fis = new FileInputStream(f1);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            try 
            {
                while(true)
                {
                    al = (alumno) ois.readObject();
                    System.out.println(al.toString());
                    raf.writeInt(al.getnClase());
                    if(al.getNombre().length() < 15)
                       while (al.getNombre().length() < 15)
                                al.setNombre(al.getNombre() + ".");
                    raf.writeUTF(al.getNombre());
                    raf.writeInt(al.getNota());
                }
                
            } catch (Exception e) {
                System.out.println("hola" + e);
            }
                ois.close();
                fis.close();
            int entrada = 6;//si pido por teclado la entrada es entrada - 1
            int nota = 8;
            String nombre = "Ala............";
            raf.seek(entrada *(Integer.BYTES + Integer.BYTES + 17));
            raf.writeInt(entrada + 1);
            raf.writeUTF(nombre);
            raf.writeInt(nota);
            raf.seek(0);
            File aux = new File("auxiliar.obj");
            FileOutputStream fos = new FileOutputStream(aux);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            try 
            {
                while(true)
                {
                   oos.writeObject(new alumno(raf.readInt(),  raf.readUTF(), raf.readInt()));
                }   
            } catch (Exception e) {
                                System.out.println("adios" + e);
            }

           oos.close();
           fos.close();
           raf.close();
           aux.renameTo(f1);
           f1.delete();
           leerficheroObjeto(aux);
              
        } catch (Exception e) {
        }
        
        
    }

    private static void leerficheroObjeto(File aux) throws FileNotFoundException, IOException {
        FileInputStream fis;
        ObjectInputStream ois;
        alumno al;
        fis = new FileInputStream(aux);
        ois = new ObjectInputStream(fis);
        try
        {
            while(true)
            {
                al = (alumno) ois.readObject();
                System.out.println(al.toString());
            }
            
        } catch (Exception e) {
        }
        ois.close();
        fis.close();
    }

    private static void iniciarFicheroSerializable(File f1) {
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
            oos.close();
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(ejercicio5and6.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
