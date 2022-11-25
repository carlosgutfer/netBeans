package POJO;
// Generated 02-feb-2022 12:00:14 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Asignaturas generated by hbm2java
 */
public class Asignaturas  implements java.io.Serializable {


     private byte cod;
     private String nombre;
     private Set<Notas> notases = new HashSet<Notas>(0);

    public Asignaturas() {
    }

	
    public Asignaturas(byte cod) {
        this.cod = cod;
    }
    public Asignaturas(byte cod, String nombre, Set<Notas> notases) {
       this.cod = cod;
       this.nombre = nombre;
       this.notases = notases;
    }
   
    public byte getCod() {
        return this.cod;
    }
    
    public void setCod(byte cod) {
        this.cod = cod;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set<Notas> getNotases() {
        return this.notases;
    }
    
    public void setNotases(Set<Notas> notases) {
        this.notases = notases;
    }




}

