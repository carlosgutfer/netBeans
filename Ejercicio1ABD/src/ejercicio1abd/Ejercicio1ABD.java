/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1abd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class Ejercicio1ABD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File newFile = new File("parrafo.txt");
        newFile.createNewFile();
        escribirArchivoTexto(newFile);
        leerArchivoTexto(newFile);
        
    }

    private static void leerArchivoTexto(File newFile) throws IOException {
        int letraAscii = 1;
        int contador [] = new int [26];
        for(int i = 0; i < contador.length; i++)
        {
            contador[i] = 0;
        }
     
        FileReader fr = new FileReader(newFile);
        while(letraAscii != -1)
        {
            letraAscii = fr.read();
            if (letraAscii - 97 > -1 && letraAscii - 97 < 27)
            contador[letraAscii - 97]++;
        }
        fr.close();
        
        escribirArchivoLetras(contador);

    }

    private static void escribirArchivoLetras(int[] contador) throws IOException {
        File archivoLetras = new File("letras.txt");
        archivoLetras.createNewFile();
        FileWriter fw = new FileWriter(archivoLetras);
        for(int i = 0; i < contador.length; i++)
        {
            if(contador[i] > 0)
                fw.write((char)(i + 97) + ":"+contador[i]);
        }
        fw.close();
    }

    private static void escribirArchivoTexto(File newFile) throws IOException {
        String entrada = "";
        FileWriter fw = new FileWriter(newFile, true);
        Scanner sc = new Scanner(System.in);
        while (!entrada.equals("*"))
        {
            System.out.println("Introduzca su frase o * para salir: ");
            entrada = sc.next().trim();
            if (!entrada.equals("*"))
            {
                fw.write(entrada);
                fw.write('\n');
            }
        }
        fw.close();
    }
    
}
