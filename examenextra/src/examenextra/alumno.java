/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenextra;

import java.io.Serializable;

/**
 *
 * @author alumno1
 */
public class alumno implements Serializable{
     String nombre;
     String apellido;
     String ciudad;
     int notaMatematicas;
     int notaIngles;

    public alumno(String nombre, String apellido, String ciudad, int notaMatematicas, int notaIngles) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.notaMatematicas = notaMatematicas;
        this.notaIngles = notaIngles;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getNotaMatematicas() {
        return notaMatematicas;
    }

    public void setNotaMatematicas(int notaMatematicas) {
        this.notaMatematicas = notaMatematicas;
    }

    public int getNotaIngles() {
        return notaIngles;
    }

    public void setNotaIngles(int notaIngles) {
        this.notaIngles = notaIngles;
    }
     
     public double calcularMedia(){ 
        return (getNotaIngles()+getNotaMatematicas())/2;
     }

    @Override
    public String toString() {
        String dev ;
        if(!getCiudad().equals("Zaragoza")&&!getCiudad().equals("Vigo"))
            dev="alumno{" + "nombre=" + nombre + ", apellido=" + apellido +"nota media "+ calcularMedia()+"}";
        else
            dev = "alumno{" + "nombre=" + nombre + ", apellido=" + apellido +"}";
        return dev;
    }
    
     
    public String toString2() {
        String dev ;
        if(!getCiudad().equals("Zaragoza")&&!getCiudad().equals("Vigo"))
            dev="alumno{" + "nombre=" + nombre + ", apellido=" + apellido +"nota media ["+ calcularMedia()+"]}";
        else
            dev = "alumno{" + "nombre=" + nombre + ", apellido=" + apellido +"}";
        return dev;
    }
     
}
