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

public class ejercicios_T1 {
    
    static Scanner sc = new Scanner(System.in);
    public  void main(String[] args) {
       /* // TODO code application logic here
        //Ejercicio 1
        double precio, total;
        int articulos;
        System.out.println("Introduzca el precio del producto");
        precio = sc.nextDouble();
        System.out.println("Introduzca el número de artículos");
        articulos = sc.nextInt();
        total = ((precio * articulos) * 0.8);
        System.out.println("El precio total con el descuento es: " + total);*/

        //Ejercico 2 v1 
        int num_inicial_bucle, num_final_bucle;
        System.out.println("Introduzca el valor inicial del bucle");
        num_inicial_bucle = sc.nextInt();
        System.out.println("Introduzca el valor final del bucle");
        num_final_bucle = sc.nextInt();
        for(int i = num_inicial_bucle  ; i <= num_final_bucle ; ++i)//El enunciado no deja claro si se incluye o no el último valor.
        {
            if(i % 5 == 0)
            {
                System.out.println("El valor " + i + " es divisible entre 5.");
            }
        }
 
        //Ejercicio 2 v2
        int num_inicial, num_final, longitud_array;
        System.out.println("Introduzca el valor inicial del array");
        num_inicial = sc.nextInt();
        System.out.println("Introduzca el valor final del array");
        num_final = sc.nextInt();
        longitud_array = num_final - num_inicial;
        int numeros_totales [] = new int [longitud_array + 1];
        for(int i = 0; i < numeros_totales.length;++i) 
        {
            numeros_totales[i] = num_inicial;
            num_inicial++;
        }
        for(int j = 0; j < numeros_totales.length; ++j)
        {
            System.out.println(numeros_totales[j]);
        }

        //Ejercicio v3
        int n_factorial, total;
        // float = big_total;
        System.out.println("Introduzca el número que desea calcular su factorial");
        n_factorial = sc.nextInt();
        //big_total = n_factorial;
        total = n_factorial;
        for(int i = 1; i < n_factorial; i++)
        {
          //total = total * (n_factorial - i);
            total *= (n_factorial - i);
          //big_total *= (n_factorial - i);
        }
        System.out.println("Factorial de " + n_factorial + " es: " + total);
        
        System.out.println("Introduzca el número que desea calcular su factorial");
        n_factorial = sc.nextInt();
        int m = 0;
        total = n_factorial;
        do
        {
            int  inicial = n_factorial - m;
            total =  total * inicial;
            m++;
        }while((n_factorial - m) != 1);
         System.out.println("Factorial de " + n_factorial + " es: " + total);
          //System.out.println("Factorial de " + n_factorial + " es: " + big_total);*/
    }

	// ejemplos bucles
 /*for(int i = 0 ; i >= 5 ; i += 1)
        {
            
        }
        
        double dinero = 0;
        do 
        {            
            dinero = Math.random();
        } while (dinero == 0);
        
        while(dinero == 0)
        {
            
        }*/

}

