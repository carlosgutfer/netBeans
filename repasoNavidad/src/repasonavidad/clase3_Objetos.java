/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad;

/**
 *
 * @author carlo
 */
public class clase3_Objetos 
{
    public  void main(String[] args) 
    {
        clase3_Persona persona1 = new clase3_Persona("111", "pepe", 10,0);
        clase3_Persona persona2 = new clase3_Persona("222", "juan", 20,0);
        
        System.out.println(persona2.getNombre());
        
        persona1.setEdad(25);
        System.out.println(persona1.toString());    
    }
   
}
