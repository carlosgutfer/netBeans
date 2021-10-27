/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosaccesodirecto;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class ejercicio3and4 
{
    public  void main(String[] args) {
        File f1 = new File("enteros.dat");
        if (f1.exists())
            f1.delete();
        try 
        {
            RandomAccessFile raf = new RandomAccessFile(f1, "rw");
            f1.createNewFile();
            int num;
            do
            {
                num = (int)(Math.random()*40);
                raf.writeInt(num);
            }while(num != 0);
            num = (int)((Math.random() * raf.length() / 4));
            raf.seek(num * 4);
            System.out.println("cargo el registro " + num * 4);
            System.out.println("Muestro el valor " + raf.readInt());
            raf.seek(num * 4);
            raf.writeInt((int)(Math.random()*40));
            System.out.println("cargo el registro " + num * 4);
            raf.seek(num * 4);
            System.out.println("Muestro el valor " + raf.readInt());
        } catch (IOException ex) {
            Logger.getLogger(ejercicio3and4.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
