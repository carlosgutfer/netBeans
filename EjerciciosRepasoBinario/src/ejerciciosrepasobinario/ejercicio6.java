/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosrepasobinario;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author carlo
 */
public class ejercicio6 {
    
    public static void main(String args []) throws IOException
    {
        
        String nombre, apellidos, email, residencia, nacionalidad, profesion;
        int edad, telefono;
        File ficheros[] = {new File("datos.bin"), new File("menores.bin"), new File("adultos.bin"), new File("ancianos.bin")};
        crearFicheros(ficheros);
       
        FileInputStream fis[] =  new FileInputStream [4];
        iniciarFileInput(fis, ficheros);
        DataInputStream dis [] = new DataInputStream[4];
        iniciarDataInput(dis, fis);
        
        FileOutputStream fos [] = new FileOutputStream[3];
        iniciarFileOutput(fos, ficheros);
        DataOutputStream Dos [] = new DataOutputStream[3];
        iniciarDataOutput(Dos, fos);
        try 
        {
            while(true)
            {
               nombre = dis[0].readUTF();
               apellidos = dis[0].readUTF();
               edad = dis[0].readInt();
               telefono = dis[0].readInt();
               email = dis[0].readUTF();
               residencia = dis[0].readUTF();
               nacionalidad = dis[0].readUTF();
               profesion = dis[0].readUTF();
               if(edad < 18)
               {
                    Dos[0].writeUTF(nombre);
                    Dos[0].writeUTF(apellidos);
                    Dos[0].writeInt(edad);
                    Dos[0].writeInt(telefono);
                    Dos[0].writeUTF(email);
                    Dos[0].writeUTF(residencia);
                    Dos[0].writeUTF(nacionalidad);
                    Dos[0].writeUTF(profesion);
               }else if(edad > 65)
               {
                    Dos[1].writeUTF(nombre);
                    Dos[1].writeUTF(apellidos);
                    Dos[1].writeInt(edad);
                    Dos[1].writeInt(telefono);
                    Dos[1].writeUTF(email);
                    Dos[1].writeUTF(residencia);
                    Dos[1].writeUTF(nacionalidad);
                    Dos[1].writeUTF(profesion);
               }else
               {
                    Dos[2].writeUTF(nombre);
                    Dos[2].writeUTF(apellidos);
                    Dos[2].writeInt(edad);
                    Dos[2].writeInt(telefono);
                    Dos[2].writeUTF(email);
                    Dos[2].writeUTF(residencia);
                    Dos[2].writeUTF(nacionalidad);
                    Dos[2].writeUTF(profesion);
               }

            }
        } catch (Exception e) {}
        cerrarFosDos(Dos, fos);
        for(int i = 1; i < dis.length; i++)
        {    
        try {
                while(true)
                {
                    System.out.println(dis[i].readUTF()+ " "+dis[i].readUTF()+" "+dis[i].readInt()+ " " + dis[i].readInt() + " "+ dis[i].readUTF()+ " "+ dis[i].readUTF()+ " "+ dis[i].readUTF()+ " " + dis[i].readUTF());
                }
            } catch (Exception e) {
                System.out.println("-------------------------------------");
            }  
        }
        cerrarDisFis(dis, fis);
    }

    private static void cerrarDisFis(DataInputStream[] dis, FileInputStream[] fis) throws IOException {
        for(int i = 0; i < dis.length; ++i)
            dis[i].close();
        for(int i = 0; i < fis.length; ++i)
            fis[i].close();
    }

    private static void cerrarFosDos(DataOutputStream[] Dos, FileOutputStream[] fos) throws IOException {
        for(int i = 0; i < Dos.length; ++i)
            Dos[i].close();
        for(int i = 0; i < fos.length; ++i)
            fos[i].close();
    }

    private static void iniciarDataOutput(DataOutputStream[] dos, FileOutputStream[] fos) {
        for(int i = 0; i < dos.length; ++i)
            dos[i] = new DataOutputStream(fos[i]);
    }

    private static void iniciarFileOutput(FileOutputStream[] fos, File[] ficheros) throws FileNotFoundException {
        for(int i= 0; i < fos.length; ++i)
            fos[i] = new FileOutputStream(ficheros[i + 1]);
    }

    private static void iniciarDataInput(DataInputStream[] dis, FileInputStream[] fis) {
        for(int k = 0; k < dis.length; ++k)
            dis[k] = new DataInputStream(fis[k]);
    }

    private static void iniciarFileInput(FileInputStream[] fis, File[] ficheros) throws FileNotFoundException {
        for(int j = 0; j < fis.length; ++j)
            fis[j] = new FileInputStream(ficheros[j]);
    }

    private static void crearFicheros(File[] ficheros) throws IOException {
        for(int i = 1; i < ficheros.length; ++i)
        {
            if(ficheros[i].exists())
                ficheros[i].delete();
            ficheros[i].createNewFile();
        }
    }
    
}
