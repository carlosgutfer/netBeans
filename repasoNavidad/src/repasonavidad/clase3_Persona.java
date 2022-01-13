/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad;

/**
 *
 * @author carlo
 */
public class clase3_Persona 
{
    private String  dni;
    private String  nombre;
    private int     edad;
    private double sueldo;
    
   /* public clase3_Persona(String dni, String nombre, int edad)
    {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }*/

    public clase3_Persona(String dni, String nombre, int edad, double sueldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

 
    //get devuelve el valor
    public String getDni()
    {
        return this.dni;
    }
    
    //Set modifica el valor
    public void setDni(String dni)
    {
        //Cambia el dni del objeto      *       el dni que te doy
        this.dni                        =        dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() 
    {
        return "Hola mi dni es " + this.dni + ", nombre=" + this.nombre + ", edad=" + this.edad;
    }
    
    public double sueldoAnual()
    {
            if(this.edad > 20)
                return 12 * this.sueldo;
            else 
                return 14 * this.sueldo;
    }
}
