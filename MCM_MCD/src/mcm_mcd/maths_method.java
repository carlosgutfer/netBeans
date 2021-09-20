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
public class maths_method {
 
   public int ft_count_min(int [][] all_div, int n)
    {
        int x = 1, cont;
        for(int i = 0; i < all_div.length; i++)
        {   
            cont = 0;
            for(int j = 0; j < all_div[i].length; j++)
               if (n == all_div[i][j])
                   cont++;
            if (cont < x)
                x = cont;
        }
       return x;
    }
   
    public int ft_count_max(int [][] all_div, int n)
    {
        int x = 1, cont;
        for(int i = 0; i < all_div.length; i++)
        {   
            cont = 0;
            for(int j = 0; j < all_div[i].length; j++)
               if (n == all_div[i][j])
                   cont++;
            if (cont > x)
                x = cont;
        }
       return x;
    }
    
    private int ft_sqrt(int nb)
    {
            int	a;

            a = -1;
            if (nb < 101)
                    while (++a < 12)
                            if (a * a > nb)
                                    return (a - 1);
            if (nb > 100)
                    while (++a < 10)
                            if (((2 * ft_sqrt(nb / 100) * 10 + a) * a > nb
                                            - 100 * ft_sqrt(nb / 100) * ft_sqrt(nb / 100)))
                                    return (ft_sqrt(nb / 100) * 10 + (a - 1));
            return (ft_sqrt(nb / 100) * 10 + (a - 1));
    }

    private int ft_is_prime(int nb)
    {
            int	i;
            int	j;

            j = 1;
            i = ft_sqrt(nb) + 1;
            while (++j < i)
                    if (nb % j == 0)
                            return (0);
            return (1);
    }

    public int ft_find_next_prime(int nb)
    {
            if (nb < 2)
                    return (2);
            if (ft_is_prime(nb) == 1)
                    return (nb);
            else
                    return (ft_find_next_prime(nb + 1));
    }

}
