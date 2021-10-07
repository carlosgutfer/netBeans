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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class ejercicio2 {
    
    
        public   void main(String[] args) 
        {
            String respuesta [];
            Scanner sc = new Scanner(System.in);
            File f1 = new File("vehiculo.bin");
            try {
                f1.createNewFile();
                FileOutputStream fos = new FileOutputStream(f1, true);
                DataOutputStream dos = new DataOutputStream(fos);
                do
                {
                    System.out.println("Introduzca una nueva matrícula, marca, modelo y desposito separados por -, o * para salir: ");
                    respuesta = (sc.nextLine()).split("-");
                    if(respuesta.length > 1)
                    {
                        dos.writeUTF(respuesta[0]);
                        dos.writeUTF(respuesta[1]);
                        dos.writeDouble(Double.parseDouble(respuesta[3]));
                        dos.writeUTF(respuesta[2]);
                    }
                }while (respuesta.length > 1);
                dos.close();
                fos.close();
                 FileInputStream fis = new FileInputStream(f1);
                 DataInputStream dis = new DataInputStream(fis);
                try
                {
                   
                    while(true)
                    {
                        System.out.println(dis.readUTF());
                        System.out.println(dis.readUTF());
                        System.out.println(dis.readDouble());
                        System.out.println(dis.readUTF());
                    }
                    
                }catch(Exception e){
                    
                }
                 dis.close();
                    fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

}
