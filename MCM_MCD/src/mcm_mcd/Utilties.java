/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcm_mcd;

/**
 *
 * @author carlo
 */
public class Utilties 
{
    public boolean ft_check_aux(int aux, int file, int [][] all_div)
    {
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
    
    
    public int ft_index_of(int[] m, int n)
    {
        for(int i = 0; i < m.length;i++)
            if(n == m[i])
                return i;
        return -1;
    }
    
}
