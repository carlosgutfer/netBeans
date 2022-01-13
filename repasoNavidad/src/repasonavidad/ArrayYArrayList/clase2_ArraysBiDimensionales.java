/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad.ArrayYArrayList;

/**
 *
 * @author carlo
 */
public class clase2_ArraysBiDimensionales {
    
    public  void main(String[] args) 
    {
        int [] [] arrayMulti = new int [4][3];
        
        /*                  c
        *                f  0   0   0
        *   arrayMulti =    0   0   0
        *                   0   0   0
                            0   0   0
        */  
        for(int i = 0; i < arrayMulti.length; ++i)
        {
            for(int j = 0; j < arrayMulti[i].length; ++j)
            {
                arrayMulti[i][j] = j;
            }
        }
            
        System.out.println(arrayMulti[2][1]);
        arrayMulti[3][2] = 8;
        
        //Recorremos el bucle
        for(int i = 0; i < arrayMulti.length; ++i)
        {
            for(int j = 0; j < arrayMulti[j].length; ++j)
            {
                System.out.print(arrayMulti[i][j]);
            }
            System.out.println("");
        }
        
        arrayMulti[2][1] = 5;
        
        //Quiero que recorra el bucle hasta que encuentre el 5 y me diga en que posición  "está  salida esperada posición 3 - 2 "
        boolean encontrado = false;
        for(int i = 0; i < arrayMulti.length && !encontrado; ++i)
        {
            for(int j = 0; j < arrayMulti[j].length && !encontrado; ++j)
            {
                if(arrayMulti[i][j] == 5)
                {
                    System.out.println("Se encuentra en la posición: " + (i+1) + " - " + (j+1));
                    encontrado = true;
                }
            }
        }
        //i < arrayMulti.length && !encontrado == if(i < arrayMulti.length && !encontrado)
        
    }
    
  
}
