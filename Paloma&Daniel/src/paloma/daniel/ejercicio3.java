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
public class ejercicio3 {
    
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int dias, semanas;
        
        System.out.println("¿Cuántos días tiene el mes?");
        dias = sc.nextInt();
        semanas = 0;
        for(int i = 7; i <= 31; i = i + 7)
        {
            semanas++;
        }
        dias = dias - (semanas * 7);
        System.out.println("El mes tiene " + semanas );
        System.out.println("El mes tiene " + dias);
        
    }
}
