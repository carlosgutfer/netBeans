/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciopreexamen;

import java.io.Serializable;

/**
 *
 * @author carlo
 */
public class personas implements Serializable{
    private String DNI;
    private String nombre;
    private int edad;
    private int sueldo;

     public personas(String DNI, String nombre, int edad, int sueldo) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
    }
     
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

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

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

   
    
    
}
