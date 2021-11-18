/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

import java.io.Serializable;

/**
 *
 * @author carlo
 */
public class Persona implements Serializable
{
    private int edad;
    private String nombre;

       Persona(){
    }
    Persona(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }
  

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" + "edad=" + edad + ", nombre=" + nombre + '}';
    }
    
    
}
