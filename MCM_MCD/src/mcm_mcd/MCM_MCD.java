/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcm_mcd;

import java.util.ArrayList;
import java.util.Scanner;


public class MCM_MCD {

     private final Scanner sc = new Scanner(System.in);
     private ArrayList<Integer> all_num = new ArrayList();
     private int all_div [][];
     private final maths_method mts = new maths_method();
     private int max_div;
 
    public static void main(String[] args) 
    {
        MCM_MCD init = new MCM_MCD();
        init.ft_getNum();
        init.ft_add_div();
        init.ft_get_mcm_mcd();
    }

    private void    ft_getNum() 
    {
    System.out.println("Escribe un número para guardarlo en el array ó menor que cero para salir");
    int num = sc.nextInt();
    while (num > 0)
    {
        all_num.add(num);
        System.out.println("Escribe un número para guardarlo en el array ó menor que cero para salir");
        num = sc.nextInt();
        if (num <= 0)
            break;
    }
    
}

    private void    ft_add_div() 
    {
        int aux, aux_1, cont;
        
        all_div = new int [all_num.size()][];
        for(int i = 0; i < all_div.length; i++)
        {
            aux = all_num.get(i);
            aux_1 = 0;
            cont = 2;
            while(aux != 1)
            {
                 if (aux % cont == 0)
                {
                   aux = aux / cont;
                   aux_1++;
                }
                else
                {
                    cont++;
                }
            }
            all_div[i] = new int [aux_1];
            ft_poblate_arrays(aux, i, cont);
        }
    }

    private void    ft_poblate_arrays(int aux, int i, int cont)
    {
        int j;
        
        j = 0;
        max_div = 1;
        aux = all_num.get(i);
        cont = 2;
        while (j < all_div[i].length && aux != 1)
        {
            if (aux % cont == 0)
            {
                aux = aux / cont;
                all_div[i][j] = cont;
                j++;
                if(max_div < cont)
                    max_div = cont;
            }
            else
                cont++;
        }
    }

    private void    ft_get_mcm_mcd() //dividir en dos funciones
    {
        double mcd = 1, mcm = 1;
        int  x = 1, i = 0;
        
        for(int j = 0; j < all_div[0].length; j++)
            {
             int aux = all_div[0][j];
                if (ft_check_aux(aux,1))
                    mcd = mcd * Math.pow(aux, mts.ft_count_min(all_div, aux));      
            }
        System.out.println(mcd);
        while(i < all_div.length)
        {  
            x = mts.ft_find_next_prime(x);
           if(ft_index_of(all_div[i], x) == -1)
           {
               i++;
               if(i == all_div.length && x < max_div)
                   i = 0;
               continue;
           }
            mcm = mcm * Math.pow(x, mts.ft_count_max(all_div, x));
            x++;
            i = 0;
        } 
        System.out.println(mcm);                        
    }

    private boolean ft_check_aux(int aux, int file)
    {
       int  count = 0;
       boolean valido = true;
       for(int i = file; i < all_div.length; i++)
            for(int j = 0; j < all_div[i].length; j++)
            {
               if (aux == all_div[i][j])
                   break;
               else if( j == all_div[i].length - 1)
                   valido = false;
            } 
        
    return valido;
    }
    
    
    private int ft_index_of(int[] m, int n)
    {
        for(int i = 0; i < m.length;i++)
            if(n == m[i])
                return i;
        return -1;
    }
    
}