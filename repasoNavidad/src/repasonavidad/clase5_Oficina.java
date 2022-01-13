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
public class clase5_Oficina {
    
    private static ArrayList <Object> oficina = new ArrayList<>();
    static clase5_empleado  empleado;
    static clase5_jefe jefe;
    public  void main(String[] args) 
    {
                        // en vez de guardar clase empleado > guarda clase objeto
        oficina.add(new clase5_empleado(1, "a", "a", 18, 2000));
        oficina.add(new clase5_empleado(2, "b", "b", 21, 2000));
        oficina.add(new clase5_empleado(3, "c", "c", 22, 2000));
        oficina.add(new clase5_jefe("a", "d", "d", 40, 3000));
        
        for(int i = 0; i < oficina.size(); ++i)
        {
            String nombreDeLaClase = oficina.get(i).getClass().getName();
            if(nombreDeLaClase.equals("repasonavidad.clase5_empleado"))
            {                     
                empleado = (clase5_empleado) oficina.get(i);
                System.out.println(empleado.sueldoAnual());
            }else
            {
                jefe = (clase5_jefe) oficina.get(i);
                System.out.println(jefe.sueldoAnual());
            } 
        }
        
        jefe = (clase5_jefe) oficina.get(3);
        System.out.println(jefe.getEmail());
        
        
        empleado = (clase5_empleado) oficina.get(1);
        System.out.println(empleado.getNumero_telefono());
        
        empleado = (clase5_empleado) oficina.get(2);
        System.out.println(empleado.getSueldo());
        
        
        jefe = (clase5_jefe) oficina.get(3);
        System.out.println(jefe.getDni());
        /*
        
                tipo = clase5_empleado 
                constructor = (1, "a", "a", 18, 2000)
                
                add (LO HACE EL ARRAYlIST DE FORMA AUTOMÁTICA)
                tipo = objeto  (borra la clase anterior y  escribe calse objeto)
                constructor = (1, "a", "a", 18, 2000)
        
                clase5_empleado (LO HACEMOS NOSOTROS MANUALMENTE CON EL CASTEO)
                tipo = clase5_empleado (borra la clase anterior y nosotros añadimos con el casteo la nueva clase)
                constructor = (1, "a", "a", 18, 2000)
        
        
        */
        
        
        
        
        
        
        
        /*ArrayLIst oficina
                Persona 1
                Persona 2
                Persona 3
                Persona 4 
                    Entramos en el bucle
                         Te devuelvo la 1ª persona 
                         ¿Nosostros preguntamos es empleado?
                                convertimos la persona en empleado
                                 oficina.get(0) ==  1ª persona  (clase5_empleado)== empleado;
                                        1ª persona es un empleado
                            
        */
    }
    
}
