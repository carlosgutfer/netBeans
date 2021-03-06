package POJO;
// Generated 02-feb-2022 12:00:14 by Hibernate Tools 4.3.1



/**
 * Notas generated by hbm2java
 */
public class Notas  implements java.io.Serializable {


     private NotasId id;
     private Alumnos alumnos;
     private Asignaturas asignaturas;
     private Integer nota1;
     private Integer nota2;
     private Integer nota3;

    public Notas() {
    }

	
    public Notas(NotasId id, Alumnos alumnos, Asignaturas asignaturas) {
        this.id = id;
        this.alumnos = alumnos;
        this.asignaturas = asignaturas;
    }
    public Notas(NotasId id, Alumnos alumnos, Asignaturas asignaturas, Integer nota1, Integer nota2, Integer nota3) {
       this.id = id;
       this.alumnos = alumnos;
       this.asignaturas = asignaturas;
       this.nota1 = nota1;
       this.nota2 = nota2;
       this.nota3 = nota3;
    }
   
    public NotasId getId() {
        return this.id;
    }
    
    public void setId(NotasId id) {
        this.id = id;
    }
    public Alumnos getAlumnos() {
        return this.alumnos;
    }
    
    public void setAlumnos(Alumnos alumnos) {
        this.alumnos = alumnos;
    }
    public Asignaturas getAsignaturas() {
        return this.asignaturas;
    }
    
    public void setAsignaturas(Asignaturas asignaturas) {
        this.asignaturas = asignaturas;
    }
    public Integer getNota1() {
        return this.nota1;
    }
    
    public void setNota1(Integer nota1) {
        this.nota1 = nota1;
    }
    public Integer getNota2() {
        return this.nota2;
    }
    
    public void setNota2(Integer nota2) {
        this.nota2 = nota2;
    }
    public Integer getNota3() {
        return this.nota3;
    }
    
    public void setNota3(Integer nota3) {
        this.nota3 = nota3;
    }


}


