/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paloma.daniel;

import java.util.Scanner;
import sun.net.www.content.audio.x_aiff;

/**
 *
 * @author carlo
 */
public class switch_if {
    
    static Scanner sc = new  Scanner(System.in);
    public  void main(String[] args) {
        
        int num;
        System.out.println("Introduce un número del 1 al 4");
        num = sc.nextInt();
        
        if(num == 1)
        {
            System.out.println("El número es 1");
        }else if(num == 2)
        {
             System.out.println("El número es 2");
        }else if(num == 3)
        {
             System.out.println("El número es 3");
        }else if(num == 4)
        {
            System.out.println("El número es 4");
        }else
        {
            System.out.println("El número es otro");
        }
        
        
        switch (num) // case  es igual '==' 
        {
            case 1:
                 System.out.println("El número es 1");
                break;
            case 2:
                 System.out.println("El número es 2");
                break;
            case 3:
                 System.out.println("El número es 3");
                break;
            case 4:
                 System.out.println("El número es 4");
                break;
            default:
                System.out.println("El número es otro");        
        }
        
        
        //& | !
        if((num == 2 ||  num == 4) && (num != 1 && num != 3))
        {
             System.out.println("El número es par");
        }else if(num == 1 || num == 3) //&& num % 3 == 0
        {
              System.out.println("El número es impar");
        }
        else 
        {
            System.out.println("El número es otro");
        }
         
        if(!false) //!false  == true
        {
            System.out.println("Correcto");
        }
        
        switch (num)
        {
            case 2: case 4:
                 System.out.println("El número es par");
                break;
            case 1: case 3:
                 System.out.println("El número es impar");
                break;
            default:
                System.out.println("El número debe ser entre 1 y 4");  
        }   
    }
    
}
