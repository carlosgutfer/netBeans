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
public class Contenido 
{
    private String componente;
    private String numSerie;
    private int unidades;

    public Contenido() {
    }

   

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Contenido{" + "componente=" + componente + ", numSerie=" + numSerie + ", unidades=" + unidades + '}';
    }

   
   
    
    
}
