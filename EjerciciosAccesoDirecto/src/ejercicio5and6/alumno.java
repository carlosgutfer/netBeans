/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5and6;

import java.io.Serializable;

/**
 *
 * @author carlo
 */
public class alumno implements Serializable
{
    
    private int     nClase;
    private String  nombre;
    private int     nota;

    public alumno(int nClase, String nombre, int nota) {
        this.nClase = nClase;
        this.nombre = nombre;
        this.nota = nota;
    }

    public int getnClase() {
        return nClase;
    }

    public void setnClase(int nClase) {
        this.nClase = nClase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    
}
