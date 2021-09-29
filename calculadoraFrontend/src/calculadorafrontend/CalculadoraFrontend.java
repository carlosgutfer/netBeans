/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorafrontend;

import java.io.*;


/**
 *
 * @author carlo
 */
public class CalculadoraFrontend {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        File ruta = new File("C:\\Users\\carlo\\NetBeansProjects\\calculadoraBackend\\src\\calculadorabackend");
        ProcessBuilder pb = new ProcessBuilder("java", "CalculadoraBackend.Programa", "suma", "1", "1");
        pb.directory(ruta);
        
        try
        {
            Process p = pb.start();
            BufferedReader br = new BufferedReader (new InputStreamReader (p.getInputStream()));
            
            System.out.println(br.readLine());
        }catch(Exception e)
        {
            
        }
    }
    
}
