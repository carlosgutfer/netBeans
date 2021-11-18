

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemploExamen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class main 
{

 
    static Scanner  sc = new Scanner(System.in);
    static File     f;
    static File     AuxliarFile  ;

    static ArrayList<Paises> allPaises = new ArrayList<Paises>();
    static  boolean  primerRegistro;
    public  void main(String[] args) 
    {
        primerRegistro = true;
        inicializarFichero(f);
        menu();
    }

    private static void inicializarFichero(File f) 
    {
        f  = new File ("paises.obj");
        AuxliarFile = new File("FicheroAuxiliar.obj");
        if (f.exists())
            f.delete();
        if (AuxliarFile.exists())
            AuxliarFile.delete();
        try {
            f.createNewFile();
            AuxliarFile.delete();

        } catch (Exception e) {}
    }
    
       private static void menu() 
       {
           
           String eleccion;
           
           eleccion = "0";
          while(!eleccion.equals("5"))
           {
            System.out.println("Elija una opción:\n1.Añadir países al fichero\n2.Actualizar información del fichero.\n3.Consultarun registro.\n4.Mostrar todos los registros.\n5.Para salir");
            eleccion = sc.next();
            eleccionMenu(eleccion);
           }
       }

    private static void eleccionMenu(String eleccion) {
        switch (eleccion)
        {
            case "1":
                    if (!primerRegistro)
                        añadirPaises();
                    else
                        añadirPrimero();
                break;
            case "2":
                  System.out.println("Escriba el id del país que desea modificar");
                  actualizarInformacion(sc.nextInt());
                break;
            case "3":
                    System.out.println("Escriba el id del país que deseas mostrar");
                    mostrarInformacion(sc.nextInt());
                break;
            case "4":
                  mostrarInformacion(-1);
                break;
            case "5":
                break;
             default:
                 System.out.println("Debe elegir una opción del 1 al 5");
        }
    }

    private static void añadirPaises() 
    {
        f =  new File("paises.obj");
        try 
        {
            FileOutputStream fos = new FileOutputStream(f, true);
            StreamObject so = new StreamObject(fos); 
            añadirPais(so);
            so.close();
            fos.close();
        } catch (Exception e) {
        }
        
    }

    private static void añadirPais(StreamObject so) throws IOException 
    {
        int id;
        String nombre;
        String capital;
        String idioma;
        System.out.println("Elija:\n1.Para añdir un pais\n2.Para volver al menu");
        String eleccion = sc.next();
        while(!eleccion.equals("2"))
        {
            if(eleccion.equals("1"))
            {
                System.out.println("Id del país: ");
                id = sc.nextInt();
                System.out.println("Nombre del país: ");
                nombre = sc.next();
                System.out.println("Capital del país: ");
                capital = sc.next();
                System.err.println("idioma: ");
                idioma = sc.next();
                Paises p = new Paises(id, nombre, capital, idioma);
                so.writeObject(p);
            }
            System.out.println("Elija:\n1.Para añdir un pais\n2.Para volver al menu");
            eleccion = sc.next();
        }
    }

    private static void mostrarInformacion(int id) 
    {
        Paises p;
        try 
        {
            FileInputStream fis = new FileInputStream(new File ("paises.obj"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            try 
            {
                while (true) 
                {                    
                    p = (Paises) ois.readObject();
                    if(id == -1)
                        System.out.println(p.toString());
                    else if(p.getId() == id)
                        System.out.println(p.toString());
                }
            } catch (Exception e) {
            }
            ois.close();
            fis.close();
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    private static void añadirPrimero() 
    {
        f =  new File("paises.obj");
        try 
        {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream so = new ObjectOutputStream(fos); 
            añadirPais(so);
            so.close();
            fos.close();
        } catch (Exception e) {
        }
         primerRegistro = false;
    }

    private static void añadirPais(ObjectOutputStream so) throws IOException {
int id;
        String nombre;
        String capital;
        String idioma;
        System.out.println("Elija:\n1.Para añdir un pais\n2.Para volver al menu");
        String eleccion = sc.next();
        while(!eleccion.equals("2"))
        {
            if(eleccion.equals("1"))
            {
                System.out.println("Id del país: ");
                id = sc.nextInt();
                System.out.println("Nombre del país: ");
                nombre = sc.next();
                System.out.println("Capital del país: ");
                capital = sc.next();
                System.err.println("idioma: ");
                idioma = sc.next();
                Paises p = new Paises(id, nombre, capital, idioma);
                so.writeObject(p);
            }
            System.out.println("Elija:\n1.Para añdir un pais\n2.Para volver al menu");
            eleccion = sc.next();
        }    }

    private static void actualizarInformacion(int id) 
    {
        Paises p;
        AuxliarFile = new File("FicheroAuxiliar.obj");
        f =  new File("paises.obj");
        try 
        {
            FileOutputStream fos = new FileOutputStream(AuxliarFile, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            try 
            {
                while (true) 
                {                    
                    p = (Paises) ois.readObject();
                    if(p.getId() == id)
                    {
                        System.out.println("Introduzca nuevo nombre pais");
                        p.setNombre(sc.next());
                        System.out.println("Introduzca nueva capital");
                        p.setCapital(sc.next());
                        System.out.println("Introduzca nuevo idioma");
                        p.setIdioma(sc.next());
                    }
                    System.out.println(p.toString());
                    oos.writeObject(p);
                }
            } catch (Exception e) {
            }
            ois.close();
            fis.close();
            oos.close();
            fos.close();
            f.delete();
            AuxliarFile.renameTo(f);
        } catch (Exception e) {
            System.out.println("" + e);
        }

    }

 
}
