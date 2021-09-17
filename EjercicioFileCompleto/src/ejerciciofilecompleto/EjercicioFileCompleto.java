/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciofilecompleto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import jdk.jfr.events.FileWriteEvent;

/**
 *
 * @author carlo
 */
public class EjercicioFileCompleto {

private File f1a,d1, fau;
private Scanner sc = new Scanner(System.in);
private int opction ;
private String entrada;
    public static void main(String[] args) throws IOException{
            EjercicioFileCompleto init = new EjercicioFileCompleto();
            init.menu();
    }

    private void menu() {
          
        do{             
            System.out.println("********* Menu************");
            System.out.println("1. Crear un nuevo directorio");
            System.out.println("2. Crear un nuevo fichero");
            System.out.println("3. Añadir un dato al fichero");
            System.out.println("4. Modificar un fichero");
            System.out.println("5. Eliminar un campo de un fichero");
            System.out.println("6. Consultar un fichero");
            System.out.println("7. Elminiar un fichero");
            System.err.println("0. Salir del programa");
            opction = sc.nextInt();
            
            switch (opction){
                case 1: System.out.println("Introduzca el nombre o nombres de los directorios que desea crear separados por un '/' ");
                           entrada=sc.next();
                           newdir(entrada.replace('/', File.separatorChar)); break;
                case 2: System.out.println("Introduzca el nombre del fichero que desea crear usa '/' para su ruta");
                           entrada=sc.next();
                           newFile(entrada.replace('/', File.separatorChar));break;
                case 3: System.out.println("Introduce el nombre del archivo donde quieres añadir datos");
                           entrada=sc.next();
                            addEnd(entrada.replace('/', File.separatorChar));
                    break;
                case 4: break;
                case 5: break;
                case 6: break;
                case 7: break;
                case 0: break;
            }
            
        }while( opction != 0);
                     
             
    }

    private void newdir(String dir)    {
        try {
            d1 = new File(dir);
            d1.mkdirs(); 
            System.out.println("Se ha creado el directorio");
            dir = null;
         }catch (Exception exception){
            System.out.println("No se ha podido crear el directorio");
        }
        
                   
    }

    private void newFile(String file) {
        try {
              f1a = new File(file);
              f1a.createNewFile();
              System.out.println("Se ha creado el fichero");
              f1a=null;
        } catch (Exception e) {
            System.out.println("El fichero no se ha podido crear");
        }
      
    }

    private void addEnd(String file) {
        try {
            f1a = new File(file);
            if (f1a.exists()){
            FileWriter fw = new FileWriter(f1a,true);
            System.out.println("texto añadir: ");
            sc = new Scanner(System.in);
            String dato = sc.nextLine();
            fw.append(dato+'\n');
            fw.close();
            f1a = null;
            System.out.println("Se ha añadido la información al fichero");
            }else {
                System.out.println("No existe el fichero");
            }
        } catch (Exception e) {
            System.out.println("No se ha podido añadir nada al registro");
        }
    }
    
}
