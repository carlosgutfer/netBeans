/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosrepasobinario;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public  void main(String[] args) {
        
        File f1 = new File("numeros.dat");
        try 
        {
            f1.createNewFile();
            FileOutputStream fos = new FileOutputStream(f1,true);
            DataOutputStream dos = new DataOutputStream(fos);
            for(int i = 0; i < 101; ++i)
                dos.writeInt(i);
            dos.close();
            fos.close();
            FileInputStream fis = new FileInputStream(f1);
            DataInputStream dis = new DataInputStream(fis);
            int i;
            try
            {
                while(true)
                    System.out.println(dis.readInt());
            }catch(Exception e){}
         } catch (IOException ex) 
        {
            Logger.getLogger(ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
