
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nacho;

/**
 *
 * @author carlo
 */

/**
 *  sueldo
 *  asignatura
 *  numero_alumnos
 * 
 */
public class profesor extends persona{
    
    private double sueldo;
    private String asignatura;
    private int numero_alumnos;
    
    
    public profesor(String nombre, String apellido, int edad, String DNI, int telefono, double sueldo, String asignatura, int numero_alumnos) 
    {
        super(nombre, apellido, edad, DNI, telefono);
        this.asignatura = asignatura;
        this.sueldo = sueldo;
        this.numero_alumnos = numero_alumnos;
        
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public int getNumero_alumnos() {
        return numero_alumnos;
    }

    public void setNumero_alumnos(int numero_alumnos) {
        this.numero_alumnos = numero_alumnos;
    }

    @Override
    public String toString() {
        return  super.toString() + " " + "sueldo " + sueldo + ", asignatura=" + asignatura + ", numero_alumnos=" + numero_alumnos ;
    }
    
}
