/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosrepasoserializable.EJERCICIO1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class Ejercicio1 {
    
    private static Scanner sc = new Scanner(System.in);
    public  void main(String args [])
    {
        File f1 = iniciarFichero();
        menu(f1);
    }

    private static void menu(File f1) 
    {
        String  eleccion;  
        boolean valido = true;
        do
        {
            System.out.println("Elija la opción que desea: 1. Anadir registro 2. Buscar persona 3. Modificar telefono o e_mail 4. Eliminar un registro");
            eleccion = sc.nextLine();
            switch(eleccion)
            {
                case "1":
                    if (valido)
                    {
                        primerUsuario(f1);
                        valido = false;
                    }else
                        añadirUsuario(f1);
                    break;
                case "2":
                    buscarRegistro(f1); 
                    break;
                case "3":
                    modificarElminarRegistro(f1, true);
                    break;
                case "4":
                    modificarElminarRegistro(f1, false);
                    break;
            } 
        }while(!eleccion.equals("*"));
    }

    private static void buscarRegistro(File f1) 
    {
     

        try {
            FileInputStream fis = new FileInputStream(f1);
            ObjectInputStream ois = new ObjectInputStream(fis);
            agenda registro;
            System.out.println("Introduzca le nombre y apellido de la persona que quiere buscar separados por un espacio");
            String entrada [] = sc.nextLine().split(" ");
            try 
            {
                while(true)
                {
                    registro = (agenda) ois.readObject();
                    if (registro instanceof agenda)
                        if ( registro.getNombre().equals(entrada[0]) && registro.getApellido().equals(entrada[1]))
                            System.out.println("Num. " + registro.getNumeroTelefono() + " Email: " + registro.getEmail());
                }
            } catch (Exception e) {}
            ois.close();
            fis.close();
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void primerUsuario(File f1) 
    {
     try {
            FileOutputStream fos = new FileOutputStream(f1);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            String entradaDatos [];
            do
            {
                System.out.println("Introduzca nombre, apellido, num. telefono y email separados por un espacio ");
                entradaDatos = (sc.nextLine()).split(" ");
                if (entradaDatos.length == 4)
                   oos.writeObject(new agenda(entradaDatos[0], entradaDatos[1], Integer.valueOf(entradaDatos[2]), entradaDatos[3]));              
            }while(entradaDatos.length != 4);            
            oos.close();
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    private static File iniciarFichero() 
    {
        
        File f1 = new File("agenda.obj");
       if (f1.exists())
            f1.delete();
        try {
            f1.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f1;
    }

    private static void añadirUsuario(File f1) 
    {
        try 
        {
                FileOutputStream fos = new FileOutputStream(f1,true);
                ClaseOutput co = new ClaseOutput(fos);
                String entradaDatos [];
                do
                {
                    System.out.println("Introduzca nombre, apellido, num. telefono y email separados por un espacio ");
                    entradaDatos = (sc.nextLine()).split(" ");
                    if (entradaDatos.length == 4)
                       co.writeObject(new agenda(entradaDatos[0], entradaDatos[1], Integer.valueOf(entradaDatos[2]), entradaDatos[3]));              
                }while(entradaDatos.length != 4);
                co.close();
                fos.close();
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    private static void modificarElminarRegistro(File f1, boolean modificar) 
    {
        try 
        {
            File auxiliar = new File("objetoAuxilair.obj");
            FileOutputStream fos = new FileOutputStream(auxiliar, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
      
            FileInputStream fis = new FileInputStream(f1);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            if (modificar)
                modificarRegistro(ois, oos);
            else
                eliminarRegistro(ois, oos); 
            ois.close();
            fis.close();           
            oos.close();
            fos.close();
            f1.delete();
            auxiliar.renameTo(f1);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void modificarRegistro(ObjectInputStream ois, ObjectOutputStream oos) 
    {
        agenda registro;
        String[] entradaDatos;
        System.out.println("Introduzca le nombre y apellido de la persona que quiere modificar separados por un espacio");
        String entrada [] = sc.nextLine().trim().split(" ");
        try
        {
            while(true)
            {
                registro = (agenda) ois.readObject();
                if (registro instanceof agenda)
                    if ( registro.getNombre().equals(entrada[0]) && registro.getApellido().equals(entrada[1]))
                    {
                        do
                        {
                            System.out.println("Introduzca el nuevo num. telefono y email separados por un espacio ");
                            entradaDatos = (sc.nextLine()).trim().split(" ");
                            if (entradaDatos.length == 2)
                                oos.writeObject(new agenda(registro.getNombre(), registro.getApellido(), Integer.valueOf(entradaDatos[0]), entradaDatos[1]));
                        }while(entradaDatos.length != 2);
                    }else
                        oos.writeObject(registro);
            }
        } catch (Exception e) {}
    }

    private static void eliminarRegistro(ObjectInputStream ois, ObjectOutputStream oos) 
    {
        try 
        {
            File borrados = new File("registrosEliminados.txt");
            borrados.createNewFile();
            FileWriter fw = new FileWriter(borrados, true);
            agenda registro;
            String[] entradaDatos;
            System.out.println("Introduzca le nombre y apellido de la persona que quiere eliminar separados por un espacio");
            String entrada [] = sc.nextLine().trim().split(" ");
            try
            {
                while(true)
                {
                    registro = (agenda) ois.readObject();
                    if (registro instanceof agenda)
                        if (!registro.getNombre().equals(entrada[0]) && !registro.getApellido().equals(entrada[1]))
                            oos.writeObject(registro);
                    else
                        fw.write(registro.toString());
                }
            } catch (Exception e) {}
            fw.close();
        }catch (IOException e){}
        
    }
        
}
