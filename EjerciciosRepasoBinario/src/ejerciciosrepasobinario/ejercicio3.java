/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosrepasobinario;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class ejercicio3 {
    
        public  static void main(String[] args) 
        {
            Scanner sc = new Scanner(System.in);
            String [] entrada;
            File f1 = new File("datosbeca.bin");
            if (f1.exists())
                f1.delete();
        try {
            f1.createNewFile();
            FileOutputStream fos = new FileOutputStream(f1, true);
            DataOutputStream dos = new DataOutputStream(fos);
            
            do
            {
                System.out.println("Introduzca nombre apellido, sexo(H - M), edad(20 - 60), numero suspensos(0 - 4), emancipado (SI - NO) e ingresos separados por /, o * para salir");
                entrada = (sc.nextLine()).split("/");
                if(entrada.length == 6)
                {
                    dos.writeUTF(entrada[0]);
                    dos.writeUTF(entrada[1]);
                    dos.writeInt(Integer.parseInt(entrada[2]));
                    dos.writeInt(Integer.parseInt(entrada[3]));
                    dos.writeUTF(entrada[4]);
                    dos.writeInt(Integer.parseInt(entrada[5]));
                }             
            }while(entrada.length == 6);
            
            fos.close();
            dos.close();
        } catch (IOException ex) {
            Logger.getLogger(ejercicio3.class.getName()).log(Level.SEVERE, null, ex);
        }

            
            
        }

}
