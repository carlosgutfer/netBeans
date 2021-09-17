/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacro;

import java.io.Serializable;

/**
 *
 * @author carlo
 */
public class alumno implements Serializable{
    
    private String nombre;
    private int  edad;
    private int faltas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public alumno(String nombre, int edad, int faltas) {
        this.nombre = nombre;
        this.edad = edad;
        this.faltas = faltas;
    }

    @Override
    public String toString() {
        return "alumno{" + "nombre=" + nombre + ", edad=" + edad + ", faltas=" + faltas + '}';
    }
    
    
    
    
}
