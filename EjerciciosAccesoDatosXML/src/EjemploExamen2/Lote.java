/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemploExamen2;

/**
 *
 * @author carlo
 */
public class Lote 
{
    private int id;
    private int numCajas;
    private Contenido contenido;
    private int peso;
    private String manipulacion;

    public Lote(int id) 
    {
        this.id = id;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumCajas() {
        return numCajas;
    }

    public void setNumCajas(int numCajas) {
        this.numCajas = numCajas;
    }

    public Contenido getContenido() {
        return contenido;
    }

    public void setContenido(Contenido contenido) {
        this.contenido = contenido;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getManipulacion() {
        return manipulacion;
    }

    public void setManipulacion(String manipulacion) {
        this.manipulacion = manipulacion;
    }

    @Override
    public String toString() {
        return "Lote{" + "id=" + id + ", numCajas=" + numCajas + ", contenido=" + contenido + ", peso=" + peso + ", manipulacion=" + manipulacion + '}';
    }

   
    
   
}
