/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class Ejercicio7 
{
    public static void main(String[] args) {
        File f = new File("ficheroAccesoAletorio.bin");
        try 
        {
            f.createNewFile();
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            int entrada;   
            for(int i = 0; i < 10; ++i)
                raf.writeDouble(Math.sqrt(i));
            
            Scanner sc = new Scanner(System.in);
            do 
            {
            System.out.println("Introduzca un número entre 0 y 9");
            entrada = sc.nextInt();
            }while(entrada < 0 && entrada > 9);
            raf.seek(0);
            raf.seek(8 * entrada);
            System.out.println(raf.readDouble());
            raf.seek(0);
            raf.seek(5 * 8);
            raf.writeDouble(2.24);
            raf.seek(raf.length());
            for(int i = 10; i < 16; i++)
                raf.writeDouble(Math.sqrt(i));
            raf.seek(0);
            for(int i = 0; i < 15; ++i)
                System.out.println(raf.readDouble());
                
            
            
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio7.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
