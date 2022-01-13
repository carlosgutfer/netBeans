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
public class clase1_Arrays {

    /**
     * @param args the command line arguments
     */
    public  void main(String[] args)
    {
        //array vacio
         int [] numeros1 = new int [10];
         
        //Array poblado
         int [] numeros2 = {0, 1, 2, 3, 4, 5, 6, 7 , 8, 9};
        
         //array poblado
         String numeroString = "0-1-2-3-4-5-6-7-8-9";
         String [] numeros3;
         numeros3 = numeroString.split("-");
         
         //Array poblado
         for(int i = 0; i < numeros1.length; ++i)
         {
             numeros1[i] = i;
         }
         
         // numeros2 = numero1 al reves 
         for(int i = numeros2.length; i > 0; --i)
         {
             numeros2[numeros2.length - i] = numeros1[i - 1];
         }  
                //numeros2[0] = nuermos1[9];
         /*
         int i = -1;
         while(numeros2.length > ++i)
         {

         }*/
            
         //imprimir array2
         int i = 0;
         while(numeros2.length > i)
         {
            System.out.println(numeros2[i]);
            i++;
         }
    }
    
}
