/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemploExamen;

import java.io.Serializable;

/**
 *
 * @author carlo
 */
public class Paises implements Serializable
{
    private int id;
    private String nombre;
    private String capital;
    private String idioma;

    public Paises(int id, String nombre, String capital, String idioma) {
        this.id = id;
        this.nombre = nombre;
        this.capital = capital;
        this.idioma = idioma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Paises{" + "id=" + id + ", nombre=" + nombre + ", capital=" + capital + ", idioma=" + idioma + '}';
    }
    
    
    
}
