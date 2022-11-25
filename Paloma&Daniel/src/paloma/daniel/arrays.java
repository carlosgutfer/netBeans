/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paloma.daniel;

import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class arrays {
    
   static  Scanner sc = new Scanner(System.in);
   
    public static void main(String[] args) {
        
        int dinero_al_1;
        int dinero_al_2;
        int dinero_al_3;
        int dineron_al_70;
        
        int dinero_al [] = new int [300];
        
        int numeros_pares [] = new int [4];
        
        String palabras [] = new String [5];
        
        Double numero [] = new Double [3];
        
        numeros_pares [0] = 1;
        palabras [2] = "arbol";
        System.out.println("" + palabras[0]);
 
        numero [0] = 1.1;
        numero [1] = 2.2;
        numero [2] = 3.3;

        System.out.println("el número es " + numero[1]);
        numero [1] = numero[1] + numero[2];
        System.out.println("el número es " + numero[1]);
        
        /*
        int numeros_10 [] = new int [10];
        for (int i = 0; i < numeros_10.length; ++i)
        {
            numeros_10 [i] = i + 1;
            System.out.print(i + " - ");
            System.out.println(numeros_10 [i]);
        }
        */
        
    }
    
}
