/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializable;

import java.io.Serializable;

/**
 *
 * @author carlo
 */

public class persona implements Serializable{
    
    private String nombre;
    private  String edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public persona(String nombre, String edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "persona{" + "nombre=" + nombre + ", edad=" + edad + '}';
    }
    
    
}
