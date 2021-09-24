/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class JavaApplication8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Usuario usuario1;
        usuario1 = new Usuario("pepe", "1234");
        Scanner sc = new Scanner(System.in);
        String nombre, contraseña;
        int i = 0;
        
        do
        {
            System.out.println("Introduzca el nombre de usuario");
            nombre = sc.next();
            System.out.println("Introduzca la contraseña");
            contraseña = sc.next();
            
            if (nombre.equals(nombre) && contraseña.equals(contraseña))
            {
                System.out.println("Has iniciado sesión");
                i = 3; //pongo 3 ya que si es dos la segunda condicionante se cumpliría
            }else if (i == 2)
            {
                System.out.println("Error login");
            }
            i++;
        }while(i < 3);
        
        i = 0;
        while(i < 3)
        {
            System.out.println("Introduzca el nombre de usuario");
            nombre = sc.next();
            System.out.println("Introduzca la contraseña");
            contraseña = sc.next();
            if (nombre.equals(nombre) && contraseña.equals(contraseña))
            {
                System.out.println("Has iniciado sesión");
                i = 3; //pongo 3 ya que si es dos la segunda condicionante se cumpliría
            }else if (i == 2)
            {
                System.out.println("Error login");
            }
           i++;                        
        }
        
        for(int j = 0; j < 3; j++)
        {
            System.out.println("Introduzca el nombre de usuario");
            nombre = sc.next();
            System.out.println("Introduzca la contraseña");
            contraseña = sc.next(); 
              if (nombre.equals(nombre) && contraseña.equals(contraseña))
            {
                System.out.println("Has iniciado sesión");
                j = 3; //pongo 3 ya que si es dos la segunda condicionante se cumpliría
            }else if (j == 2)
            {
                System.out.println("Error login");
            }
        }
                     
    }
    
}
