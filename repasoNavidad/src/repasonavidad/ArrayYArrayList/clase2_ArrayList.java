/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad.ArrayYArrayList;

import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class clase2_ArrayList {
    
    public  void main(String[] args) 
    {
        ArrayList <Integer>  numeros = new ArrayList <>();
        numeros.add(15);
        numeros.add(0, 24);
        numeros.add(1, 87);
        System.out.println(numeros.size());     
        for(int i = 0; i < numeros.size(); ++i)
        {
            System.out.println(numeros.get(i));
        }
        
        numeros.add(3);
        numeros.add(4);
        numeros.add(7);
        
        boolean valido = false;
        for(int i = 0; i < numeros.size() && !valido; ++i)
        {
            System.out.print(numeros.get(i));
            if(numeros.get(i) == 4)
            {
                valido = true;
            }
        }
        imprimirBucle(numeros);
    }
    
    private static void imprimirBucle(ArrayList lista)
    {
        for(int i = 0; i < lista.size(); ++i)
            System.out.println(lista.get(i));
    }
    
}
