
import java.awt.SystemColor;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlo
 */
public class Ejercicio1 {
    private File f1;
    private Scanner sc = new Scanner(System.in);
    private  FileOutputStream fis;
    private   DataOutputStream dis;
    public static void main(String[] args)  {
        Ejercicio1 init = new Ejercicio1();
        init.menu();
    }

    private void menu() {
        initFile();
        askNumber();
        
    }

    private void initFile() {
        f1 = new File ("numeros.dat");
        if ( !f1.exists())
            try {
            f1.createNewFile();
            } catch (Exception e) {
            }
    }

    private void wrtieInit()  {
        try{
        fis = new FileOutputStream(f1,true);
        dis = new DataOutputStream(fis);
        }catch (IOException e){
            
        }
    }

    private void askNumber()  {
        wrtieInit();
        int numA;
        
        do{
            System.out.println("Introduzca la cantidad de números aleatorios entre 0 y 100 que desea guardar");
            numA=sc.nextInt();
        } while( numA<1 || numA >100);
        for(int i =0; i<numA; i++){
            try{
               dis.writeInt((int) (Math.random()*101));
            }catch(IOException e){
                
            }
                   
        }
    }
    
}
