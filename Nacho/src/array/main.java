/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array;

/**
 *
 * @author carlo
 */
public class main 
{

   static Items [] todos_los_items = 
    { 
        new Items("Lápiz", 100, 1.20),
        new Items("Boli", 56, 2.10),
        new Items("Goma", 87, 0.80),
        new Items("Posit", 103, 2.40),
        new Items("Reglas", 29, 7.56),
        new Items("Estuche", 45, 10.50),
        new Items("Sacapuntas", 91, 2.90)
    };
    public  void main(String[] args) 
    {
        
      for(Items i : todos_los_items )
          System.out.println(i.toString());
   /*   
        System.out.println("--------De mayor a menor---------");
        for(int i = 0; i < todos_los_items.length - 1; ++i)
        {
             if(todos_los_items[i].getPrecio() < todos_los_items[i + 1].getPrecio())
             {
                    Items aux =  todos_los_items[i];
                    todos_los_items[i] = todos_los_items[i + 1];
                    todos_los_items[i + 1] = aux;
                    i = -1;
             }
        }
        
        for (Items i : todos_los_items) {
            System.out.println(i.toString());
        }
        System.out.println("----------De menor a mayor ---------");
        
         for(int i = 0; i < todos_los_items.length - 1; ++i)
        {
             if(todos_los_items[i].getPrecio() > todos_los_items[i + 1].getPrecio())
             {
                    Items aux =  todos_los_items[i];
                    todos_los_items[i] = todos_los_items[i + 1];
                    todos_los_items[i + 1] = aux;
                    i = -1;
             }
        }
        
        for(Items i : todos_los_items )
          System.out.println(i.toString());
        
        */
        System.out.println("--------Más caro----------");
        
        double precio = todos_los_items[0].getPrecio();
        Items aux = todos_los_items[0];
        for(int i = 1; i < todos_los_items.length; ++i)
        {
            if(todos_los_items[i].getPrecio() > precio)
            {
                precio = todos_los_items[i].getPrecio();
                aux = todos_los_items[i];
            }
        }
        System.out.println(aux.toString());    
        
        System.out.println("--------Más barato----------");
        precio = todos_los_items[0].getPrecio();
        aux =  todos_los_items[0];
        for(int i = 1; i < todos_los_items.length; ++i)
        {
        if(todos_los_items[i].getPrecio() < precio)
            {
                precio = todos_los_items[i].getPrecio();
                aux = todos_los_items[i];
            }
        }
        System.out.println(aux.toString());
    }
   
}
