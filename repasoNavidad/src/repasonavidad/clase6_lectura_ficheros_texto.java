/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class clase6_lectura_ficheros_texto 
{
    public  void main(String[] args) 
    {
     File ficheroDeTexto = new File("prueba.txt");//Creo la varibale
     
        if(ficheroDeTexto.exists())//Si existe
            ficheroDeTexto.delete();//te lo cargas
        try 
        {
            ficheroDeTexto.createNewFile();// crea fichero
        } catch (IOException ex) {
            Logger.getLogger(clase6_lectura_ficheros_texto.class.getName()).log(Level.SEVERE, null, ex);
        }
        try 
        {
            FileWriter fw = new FileWriter(ficheroDeTexto, true);// si no está true, si en el fichero está escrito adios y tu escribes hola, borra todo el fichero y pone hola. Y si pones true, escribe adios hola
            fw.write("hola mundo" + '\n');
            fw.write("adios mundo" +'\n');
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(clase6_lectura_ficheros_texto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try 
        {
            FileReader fr = new FileReader(ficheroDeTexto);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while(linea != null)// con el while mostrados cada linea
            {
                System.out.println(linea);         /*HOla asdf
                                                    como asdfsa asdfas
                                                     estas  adfasdfasdfasdf*/
                
             
                
                linea = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(clase6_lectura_ficheros_texto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(clase6_lectura_ficheros_texto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
