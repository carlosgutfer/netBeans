/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paloma.daniel;

/**
 *
 * @author carlo
 */
public class Ejercicio4 {
    
    public  void main(String[] args) {
        
    int numero;
    
    do
    {
        numero = (int)(Math.random() *((20 - 0) +1));
        System.out.println("Número hayado " + numero);
        
    }while(numero % 2 != 0 && numero != 2);
    
    }
    /*(usar bucle do while)
    Número hayado 3
    Número hayado 4
    Número hayado 8
    Número hayado 5*/
}
