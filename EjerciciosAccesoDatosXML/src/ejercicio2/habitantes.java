/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

/**
 *
 * @author carlo
 */
public class habitantes {
    private int hombre;
    private int mujeres;

    public habitantes() {
    }

    public int getHombre() {
        return hombre;
    }

    public void setHombre(int hombre) {
        this.hombre = hombre;
    }

    public int getMujeres() {
        return mujeres;
    }

    public void setMujeres(int mujeres) {
        this.mujeres = mujeres;
    }

    @Override
    public String toString() {
        return  "hombre=" + hombre + ", mujeres=" + mujeres;
    }
    
    
}
