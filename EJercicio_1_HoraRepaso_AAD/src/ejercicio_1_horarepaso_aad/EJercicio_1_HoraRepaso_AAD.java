/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_1_horarepaso_aad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class EJercicio_1_HoraRepaso_AAD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        File            f1 = new File("texto.txt");
        File            f2 = new File("invertido.txt");
        f2.createNewFile();
        leerFicheroyCopiarlo(f1, f2);
        mostrarFichero(f2);
    }

    private static void mostrarFichero(File f2) throws IOException, FileNotFoundException 
    {
        FileReader fr = new FileReader(f2);
        BufferedReader br = new BufferedReader(fr);
        String mostrar;
        while((mostrar = br.readLine()) != null)
            System.out.println(mostrar);
    }

    private static void leerFicheroyCopiarlo(File f1, File f2) throws IOException 
    {
        StringBuilder    sb = new StringBuilder();
        String          frase;
        try {
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(f2);
            try {
                while((frase = br.readLine()) != null)
                {
                    sb.append(frase);
                    sb = sb.reverse();
                    sb.append("\n");
                    fw.write(sb.toString());
                    sb.delete(0, sb.length());
                }
                fw.close();
                br.close();
                fr.close();
            }catch (IOException ex)
            {
                Logger.getLogger(EJercicio_1_HoraRepaso_AAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EJercicio_1_HoraRepaso_AAD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
