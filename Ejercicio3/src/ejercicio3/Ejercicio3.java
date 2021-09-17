/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author carlo
 */
public class Ejercicio3 {
    
    
    private File agenda,listaCompra;
   
    public static void main(String[] args)  {
        
        Ejercicio3 init = new Ejercicio3();
        try{
        init.openDiary();
        } catch(IOException e){
            
        }
        // TODO code application logic here
    }

    private void openDiary() throws IOException {
          String dirDiary = "C:/agenda";
          String dirListaCompra="C:/agenda/";
          
          dirDiary = dirDiary.replace('/',File.separatorChar);
          dirListaCompra = dirListaCompra.replace('/', File.separatorChar);
          
          agenda = new File(dirDiary);
          listaCompra = new File(dirListaCompra,"listaCompra.txt");
          
          agenda.mkdirs();
          listaCompra.createNewFile();
          
          
          listaCompra.delete();
          agenda.delete();

           
    }
    
    
}
