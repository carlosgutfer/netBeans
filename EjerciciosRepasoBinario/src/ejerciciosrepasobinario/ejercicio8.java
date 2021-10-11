/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosrepasobinario;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 *
 * @author carlo
 */
public class ejercicio8 {
    public  void main(String [] args)
    {
        File sept = new File("Septemp.dat");
        try 
        {
            sept.createNewFile();
            FileInputStream fis = new FileInputStream(sept);
            DataInputStream dis = new DataInputStream(fis);
            int max = 0, min = 0, media = 0, maxHora = 0, minHora = 0, horaActual, tempActual;
            try 
            {
                maxHora = dis.readInt();
                minHora = maxHora;
                max = dis.readInt();
                min = max;
                media += max;
                while(true)
                {
                    horaActual = dis.readInt();
                    tempActual = dis.readInt();
                    if (tempActual > max)
                    {
                        max = tempActual;
                        maxHora = horaActual;
                    }else if(tempActual < min)
                    {
                        min = tempActual;
                        minHora = horaActual;
                    }
                    media += tempActual;
                }
            } catch (Exception e) {}
            System.out.println("Max: " + maxHora + " " + max + " Min: " + minHora + " " + min + " Media: " + (media / 24));
        } catch (Exception e) {
        }
    }
    
}
