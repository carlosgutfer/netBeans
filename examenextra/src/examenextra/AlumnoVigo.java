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
public class AlumnoVigo extends alumno implements Serializable{
    boolean navegar;

    public AlumnoVigo( String nombre, String apellido, String ciudad, int notaMatematicas, int notaIngles, boolean navegar) {
        super(nombre, apellido, ciudad, notaMatematicas, notaIngles);
        this.navegar = navegar;
    }

    public boolean isNavegar() {
        return navegar;
    }

    public void setNavegar(boolean navegar) {
        this.navegar = navegar;
    }

    @Override
    public double calcularMedia() {
        double media;
        if(isNavegar())
             media = (super.calcularMedia()*0.1)+super.calcularMedia();
        else
            media = super.calcularMedia();
        return media; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString() +" notaMedia: "+calcularMedia(); //To change body of generated methods, choose Tools | Templates.
    }
    
     @Override
        public String toString2(){
            return super.toString2()+ " notaMedia: "+calcularMedia(); 

        }
    
    
}
