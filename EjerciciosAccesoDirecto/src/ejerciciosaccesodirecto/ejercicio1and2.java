/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosaccesodirecto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class ejercicio1and2 {

    /**
     * @param args the command line arguments
     */
    public   void main(String[] args) throws IOException 
    {
        File f1 = new File ("ficheroAleatorio.bin");
        if (f1.exists())
                f1.delete();
        f1.createNewFile();
        try 
        {
            RandomAccessFile raf = new RandomAccessFile(f1, "rw");
            raf.seek(0);
            for(int i = 0; i < 10; ++i)
            {
                raf.writeInt(i);
                for(int j = 0; j < i; ++j)
                    raf.writeDouble(j + 1);
            }
            System.out.println(raf.length());
            int num = 4;
            raf.seek(0);
            try 
            {
                /*while (true) 
                {                
                    int numeroLeido = raf.readInt();
                    System.out.println(doublesCount(num) + 4 * num);
                    if (numeroLeido == num)
                    {
                        System.out.println(raf.getFilePointer());
                        System.out.println(numeroLeido);
                        for(int i = 0; i < numeroLeido; ++i)
                            System.out.println(raf.readDouble());
                
                    }
                }*/
                raf.seek(doublesCount(num) + Integer.BYTES * num);
                System.out.println(raf.readInt());
                        for(int i = 0; i < num; ++i)
                            System.out.println(raf.readDouble());
            } catch (Exception e) {}
            raf.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ejercicio1and2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ejercicio1and2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static int doublesCount(int num) 
    {
        int suma = 0; 
        for(int i = 0; i < num; ++i)
            suma +=  i * Double.BYTES;
        return suma;
    }
    
}
