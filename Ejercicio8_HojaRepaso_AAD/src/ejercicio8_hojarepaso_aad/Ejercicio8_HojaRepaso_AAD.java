/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio8_hojarepaso_aad;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class Ejercicio8_HojaRepaso_AAD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File    inventario = new File("inventario.txt");
        ArrayList<Productos> todosLosProductos = new ArrayList<Productos>();
        crearArrayProductos(inventario, todosLosProductos);
        modificarProductos(todosLosProductos);
        modificarFicheroInventario(todosLosProductos, inventario);
        
    }

    private static void modificarFicheroInventario(ArrayList<Productos> todosLosProductos, File inventario) 
    {
        String      datosProducto [];
        Productos   producto;
        File        aux;
        
        aux = new File("auxiliar.txt");
        
        
        
        datosProducto = new String [4];
        for(int i = 0; i < todosLosProductos.size(); ++i)
        {
            producto = todosLosProductos.get(i);
            datosProducto  = (producto.toString()).split(" ");
            
        }
    }

    private static void crearArrayProductos(File inventario, ArrayList todosLosProductos) throws NumberFormatException 
    {
        String []       lectura;
        Productos       producto;
        String          frase;
        FileReader      fr;
        BufferedReader  br;
 
        try {
            fr = new FileReader(inventario);
            br = new BufferedReader(fr);
            
            try {
                while ((frase = br.readLine()) != null)
                {
                    lectura = frase.split(" ");
                    producto = new Productos(Integer.parseInt(lectura[0]), lectura[1], Integer.parseInt(lectura[2]), Float.parseFloat(lectura[3]));
                    todosLosProductos.add(producto);
                }
            } catch (IOException ex) {
                
                Logger.getLogger(Ejercicio8_HojaRepaso_AAD.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio8_HojaRepaso_AAD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void modificarProductos(ArrayList todosLosProductos) {
        File            movimientos;
        String []       lectura;
        String          frase;
        FileReader      fr;
        BufferedReader  br;
        Productos       pr;
        boolean         encontrado;
        Scanner         sc = new Scanner(System.in);
        
        movimientos = new File("movimientos.txt");
        try
        {
            fr = new FileReader(movimientos);
            br = new BufferedReader(fr);
            while ((frase = br.readLine()) != null)
            {
                lectura = frase.split(" ");
                encontrado = false;
                for(int i = 0; i < todosLosProductos.size(); ++i)
                {
                    pr = (Productos) todosLosProductos.get(i);
                    if (pr.getCodigoProducto() == Integer.parseInt(lectura[0]))
                    {
                        encontrado = true;
                        if(lectura[1].equals("V"))
                            pr.setCantidad(pr.getCantidad() - Integer.parseInt(lectura[2]));
                        else 
                            pr.setCantidad(pr.getCantidad() + Integer.parseInt(lectura[2]));
                    }
                }
                if (!encontrado && lectura[1].equals("C"))
                {
                    System.out.println("Producto no dado de alta, introduzca nombre");
                    String nombre = sc.nextLine();
                    System.out.println("Introduzca el precio");
                    float precio = sc.nextFloat();
                    todosLosProductos.add(new Productos(Integer.parseInt(lectura[0]), nombre, Integer.parseInt(lectura[2]), precio));
                }else if(!encontrado)
                    System.out.println("Error de datos en el fichero movimiento, el prodcuto con el código " + Integer.parseInt(lectura[0]) + " no existe");
                
            }        
        }catch(Exception e){System.out.println(e);}
    }
    
}
