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
public class AlumnoZaragoza extends alumno implements Serializable{
    int donativo;

    public AlumnoZaragoza( String nombre, String apellido, String ciudad, int notaMatematicas, int notaIngles,int donativo) {
        super(nombre, apellido, ciudad, notaMatematicas, notaIngles);
        this.donativo = donativo;
    }

    public int getDonativo() {
        return donativo;
    }

    public void setDonativo(int donativo) {
        this.donativo = donativo;
    }

    @Override
    public double calcularMedia() {
        return super.calcularMedia(); 
    }

    @Override
    public String toString() {
        return super.toString()+ " notaMedia: "+calcularMedia(); 
    }
    
    @Override
        public String toString2(){
            return super.toString2()+ " notaMedia: "+calcularMedia(); 

        }
    
}
