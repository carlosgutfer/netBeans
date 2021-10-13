/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosrepasoserializable.EJERCICIO1;

import java.io.Serializable;

/**
 *
 * @author carlo
 */
public class agenda  implements  Serializable{
    
    private String nombre;
    private String apellido;
    private int numeroTelefono;
    private String email;

    public agenda(String nombre, String apellido, int numeroTelefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroTelefono = numeroTelefono;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "agenda{" + "nombre=" + nombre + ", apellido=" + apellido + ", numeroTelefono=" + numeroTelefono + ", email=" + email + '}';
    }
    
    
}
