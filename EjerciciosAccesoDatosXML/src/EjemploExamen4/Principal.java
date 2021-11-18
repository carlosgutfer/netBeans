/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemploExamen4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class Principal 
{
    public  void main(String[] args) 
    {
        File f1 = new File("seguros.bin");
        File f2 = new File("auxiliar.bin");
        
        String DNI, Matricula;
        int Edad;
        double Seguro;
        int valorSeguro = 1000;
        
        try {
            FileInputStream fis = new FileInputStream(f1);
            DataInputStream dis = new DataInputStream(fis);
            
            FileOutputStream fos = new FileOutputStream(f2);
            DataOutputStream dos = new DataOutputStream(fos);
            
            try 
            {
                while(true)
                {
                    DNI = dis.readUTF();
                    Edad = dis.readInt();
                    Matricula = dis.readUTF();
                    Seguro = dis.readDouble();
                    System.out.println(DNI + " " + " " + Edad + " " + Matricula + " " + Seguro);
                    if(Seguro > 1000)
                    {
                        System.out.println("Usuario borrado");
                    }
                    else
                    {
                        if(Seguro == 0)
                        {
                            if(Edad < 40)
                                Seguro = valorSeguro * 0.2;
                            else
                                Seguro = valorSeguro * 0.1;
                        }
                        else if (Seguro < 500)
                            Seguro += Seguro * 0.05;
                       
                        dos.writeUTF(DNI);
                        dos.writeInt(Edad);
                        dos.writeUTF(Matricula);
                        dos.writeDouble(Seguro);
                    }
                }
             } catch (Exception e) {
            }
            
            dos.close();
            fos.close();

            dis.close();
            fis.close();
            f1.delete();
            f2.renameTo(f1);
            
            fis = new FileInputStream(f1);
            dis = new DataInputStream(fis);
            System.out.println("=================================================================");
            try {
                while(true)
                {
                    DNI = dis.readUTF();
                    Edad = dis.readInt();
                    Matricula = dis.readUTF();
                    Seguro = dis.readDouble();
                    System.out.println(DNI + " " + " " + Edad + " " + Matricula + " " + Seguro);
                }
            } catch (Exception e) {
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
