/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosrepasobinario;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author carlo
 */
public class ejercicio7 {
    
    public  void main (String [] args)
    {
        File sep = new File("Septemp.dat");
        File temp = new File("temperaturas.txt");
        
        try 
        {
            sep.createNewFile();
            temp.createNewFile();
            
            FileReader fr = new FileReader(temp);
            BufferedReader br = new BufferedReader(fr);
            
            FileOutputStream fos = new FileOutputStream(sep, true);
            DataOutputStream dos = new DataOutputStream(fos);
            
            String lectura []; 
            while((lectura = br.readLine().split(" ")) != null)
            {
                dos.writeInt(Integer.parseInt(lectura[0]));
                dos.writeInt(Integer.parseInt(lectura[1]));
            }
            dos.close();
            fos.close();
            br.close();
            fr.close();
        } catch (Exception e) {
        }
    }
    
}
