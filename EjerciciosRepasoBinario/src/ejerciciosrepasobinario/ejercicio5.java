package ejerciciosrepasobinario;


import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlo
 */
public class ejercicio5 {
    
    public  void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        File f1 = new File("datos.bin");
        String [] entrada;
        try 
        {
            f1.createNewFile();
            FileOutputStream fos = new FileOutputStream(f1);
            DataOutputStream Dos = new DataOutputStream(fos);
            do
            {
                System.out.println("Introduzca nombre, apellidos, edad, num. telefono, email, ciudad residencia, nacional y profesión; separadas por ',' o escriba * para salir ");
                entrada = (sc.nextLine()).split(",");
                if (entrada.length ==8 )
                {
                    Dos.writeUTF(entrada[0]);
                    Dos.writeUTF(entrada[1]);
                    Dos.writeInt(Integer.parseInt(entrada[2]));
                    Dos.writeInt(Integer.parseInt(entrada[3]));
                    Dos.writeUTF(entrada[4]);
                    Dos.writeUTF(entrada[5]);
                    Dos.writeUTF(entrada[6]);
                    Dos.writeUTF(entrada[7]);
                }
            }while(entrada.length == 8);
            Dos.close();
            fos.close();
        } catch (IOException ex) 
        {
            Logger.getLogger(ejercicio5.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
