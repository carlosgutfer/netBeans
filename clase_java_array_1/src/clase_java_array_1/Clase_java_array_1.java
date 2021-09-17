/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase_java_array_1;

/**
 *
 * @author carlo
 */
public class Clase_java_array_1 {

    private int n [];
    private int m [][];
    private int l [][];
    
    public static void main(String[] args) 
    {
     Clase_java_array_1 init = new Clase_java_array_1();
     init.init_array();
     init.poblate_array();
     init.show_array();
     
    }
    
    private void init_array() 
    {
        /* A la hora de crear un array, cuando lo defines guardas el número 
        total de registros que quieres que tenga. Ejem n[2] porque quiero que 
        tenga 2 registros
        y a la hora de leerlo empiezo desde el número 0.
        Calendario 
        ArrayBidimensional asimitrico que muestre los días
         1 2 3 4 ... 31
         1 2 3 4 ... 28
        */
        n = new int [2];
        m = new int [5][5];
        l = new int [2][];
    }

    private void poblate_array() 
    {
        for(int i = 0; i < n.length; i++)
        {
            n[i] = i;
            
            l[i] = new int [i];//Estoy inicializando el arrayBidimensional 
        }

            l[1][0] = 1;
            System.out.print(l[1][0]);
        
        for(int i = 0; i < m.length; i++)
            for(int j = 0; j < m[i].length; j++)
                m[i][j] = j;
            
    }

    private void show_array() {
        for(int i = 0; i < n.length; i++)
            System.out.println(n[i]);
        
         for(int i = 0; i < m.length; i++)
            for(int j = 0; j < m[i].length; j++)
                System.out.println(m[i][j]);
    }
    
}
