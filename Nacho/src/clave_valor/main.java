/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clave_valor;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class main {
    public static void main(String[] args) {
        HashMap<String, Integer> ascii = new HashMap<String, Integer>();
        for(int i = 65; i < 91 ; ++i)
            ascii.put(String.valueOf((char)i), i);
     Scanner sc = new Scanner(System.in);
     String letra;
     while(true)
     {
         System.out.println("Introduce una letra entre A y Z");
             letra = sc.next().trim();
              System.out.println(ascii.get(letra));
     }
    }
}
