/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

/**
 *
 * @author carlo
 */
public class vehiculos {
    String matricula;
    int dni;
    int coste;
    int revision;
    int potencia;
    int ejesTraccion;
    boolean aireAcondicionado;
    String marca;
    String modelo;

    public vehiculos(String matricula, int dni, int coste, int revision, int potencia, int ejesTraccion, boolean aireAcondicionado, String marca, String modelo) {
        this.matricula = matricula;
        this.dni = dni;
        this.coste = coste;
        this.revision = revision;
        this.potencia = potencia;
        this.ejesTraccion = ejesTraccion;
        this.aireAcondicionado = aireAcondicionado;
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        String tipo;
        if(ejesTraccion==2)
            tipo = "M";
        else
            tipo = "C";
        
        return "Tipo "+ tipo + " matricula=" + matricula + ", dni=" + dni + ", coste=" + coste + ", revision=" + revision + ", potencia=" + potencia + ", aireAcondicionado=" + aireAcondicionado + ", marca=" + marca + ", modelo=" + modelo ;
    }
    
    
}
