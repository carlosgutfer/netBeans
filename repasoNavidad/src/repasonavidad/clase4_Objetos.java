/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad;

import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class clase4_Objetos 
{
    // Creamos arrayList     
    private static ArrayList <clase3_Persona>  oficina = new ArrayList<>(); // La oficina esta vacía 
    
    public  void main(String[] args) 
    {
        annadirPersona("Pepe", "111", 10);
        annadirPersona("Juan", "222", 20);
        System.out.println(verDni());
        oficina.get(1).setEdad(11);
       // Los DNI de la BBDD son: 111,222,333
        System.out.println(oficina.get(1).toString());
    }
    
    private static void annadirPersona(String nombre, String dni, int edad)
    {
         clase3_Persona persona = new clase3_Persona(dni, nombre, edad,0);//Creamos la  persona
         oficina.add(persona);//añadimos la persona
        //oficina.add(new clase3_Persona(dni, nombre, edad)); 
    }
    
    private static String verDni()
    {
        String salida = "Los DNI de la BDD son: ";
        for(int i = 0; i < oficina.size(); ++i)
        {
            if(i == oficina.size() - 1)
            {
                //salida = salida + oficina.get(i).getDDni()
                salida += oficina.get(i).getDni() + ".";
            }else
            {
                salida += oficina.get(i).getDni() + ",";
            }
        }
       return salida;
    }
    
    
            
}
