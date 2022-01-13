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
public class clase5_empleado extends clase3_Persona{
    
    private int numero_telefono;
   

    public clase5_empleado(int numero_telefono, String dni, String nombre, int edad, double  sueldo) 
    {
        super(dni, nombre,edad, sueldo);// == clase3_Persona(String dni, String nombre, int edad) 
        this.numero_telefono = numero_telefono;
      
    }

    public int getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(int numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    @Override
    public String toString() {
                //llamamos al método toString del padre
        return super.toString() + "clase5_empleado{" + "numero_telefono=" + numero_telefono + ", sueldo=";
    }
    
    @Override
    public double sueldoAnual()
    {
        return  super.sueldoAnual() + 2000;
    }
}
