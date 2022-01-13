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
 * @author Pablo
 */
public class lectura {
    //lista de objetos (Empleados)
     
    public  void main(String[] args) {
         
        File nominas = new File("nominas.txt");
        
       /* try {
            FileWriter fw = new FileWriter (nominas);
            fw.write("1/Pepe/3000");
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(lectura.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        ArrayList<String[]> Empleados = new ArrayList<>();
        try {
            FileReader fr = new FileReader(nominas);
            BufferedReader br = new BufferedReader(fr); 
            
            String linea = br.readLine();

            while (linea != null) 
            {     
                String[] datos = linea.split("/");
                
                //nuevoEmpleado(id, nombre, sueldo);
                Empleados.add(datos);
                
                linea = br.readLine(); // "contador" del puntero == linea
            }
            
            br.close();
            fr.close();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(lectura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(lectura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
            try {
             
                FileWriter fw = new FileWriter(nominas);
               
                for (int i = 0 ; i< Empleados.size(); ++i){
                   
                   String id = String.valueOf(Empleados.get(i)[0]);
                   String nombre = Empleados.get(i)[1];
                   String sueldo = String.valueOf(Empleados.get(i)[2]);
                   
                   if(i!=3){
                       if(i==2){
                           sueldo= String.valueOf(Empleados.get(i)[2] + 1000);
                       }
                    String linea= id+"/"+nombre+"/"+sueldo + '\n';
                    fw.write(linea);
                   }  
                }
                 
                fw.close();
                
            } catch (IOException ex) {
                Logger.getLogger(lectura.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        try {
            FileReader fr= new FileReader(nominas);
            BufferedReader br = new BufferedReader(fr);
            
            String linea = br.readLine();
            
            while (linea != null){
                System.out.println(linea);
                linea = br.readLine();
            }
            
            fr.close();
            br.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(lectura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(lectura.class.getName()).log(Level.SEVERE, null, ex);
        }
           
      
    }/*
    //metodo para generar un nuevo empleado
    private static void nuevoEmpleado(int id, String nombre, int sueldo){
        empleados empleado1 = new empleados(id, nombre, sueldo);
        Empleados.add(0,empleado1);
    }*/
}
