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

/**
 *
 * @author carlo
 */
public class ejercicio4 {
    
    public  void main(String args []) throws IOException
    {
         File f1 = new File("datosbeca.bin"); 
         f1.createNewFile();
         int renta = 0;
         String nombreApellidos, residente;
         int ingresos, edad, suspensos;
         try
         {
         FileInputStream fis = new FileInputStream(f1);
         DataInputStream dis = new DataInputStream(fis);
              try
              {
                  String hola;
                  while(true)
                  {
                   nombreApellidos = dis.readUTF();
                   dis.readUTF();
                   edad = dis.readInt();
                   suspensos = dis.readInt();
                   residente = dis.readUTF();
                   ingresos = dis.readInt();
                   if (suspensos < 2)
                   {
                       if (ingresos <= 12000)
                       {
                           renta += 500;
                        if(suspensos == 1)
                            renta += 200;
                        else 
                            renta +=500;
                        if (edad < 23)
                            renta += 200;
                        if(residente.equals("no"))
                            renta += 1000;
                       }else
                           renta = 1500;
                       System.out.println("La cuantía de la beca es  " + renta);
                   }else
                       System.out.println("Beca denegada " + nombreApellidos);
                  }
                  
              }catch(Exception e){}
                  dis.close();
                  fis.close();
         }catch(Exception e){}
    }
    
}
