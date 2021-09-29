/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio8_hojarepaso_aad;

/**
 *
 * @author carlo
 */
public class Productos {
    
    private int codigoProducto;
    private String nombre;
    private int cantidad;
    private float precio;

    public Productos(int codigoProducto, String nombre, int cantidad, float precio) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Productos{" + "codigoProducto=" + codigoProducto + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }
    

}
