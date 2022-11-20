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

/*
    curso
    nota_media
    repetidor
    profesor

*/
public class alumno extends persona {
    
    private short curso;
    private float nota_media;
    private boolean repetidor;
    private profesor Tutor; //Cada alumno, va a tener asignado un profesor. Para referencia clases que no son su padre

    public alumno(String nombre, String apellido, int edad, String DNI, int telefono, short curso, float nota_media, boolean repetidor, profesor Tutor) 
    {
        super(nombre, apellido, edad, DNI, telefono);
        this.curso = curso;
        this.nota_media = nota_media;
        this.repetidor = repetidor;
        this.Tutor = Tutor;
    }


    public short getCurso() {
        return curso;
    }

    public void setCurso(short curso) {
        this.curso = curso;
    }

    public float getNota_media() {
        return nota_media;
    }

    public void setNota_media(float nota_media) {
        this.nota_media = nota_media;
    }

    public boolean isRepetidor() {
        return repetidor;
    }

    public void setRepetidor(boolean repetidor) {
        this.repetidor = repetidor;
    }

    public profesor getTutor() {
        return Tutor;
    }

    public void setTutor(profesor Tutor) {
        this.Tutor = Tutor;
    }

    @Override
    public String toString() {
        return super.toString()  + " " + "curso=" + curso + ", nota_media=" + nota_media + ", repetidor=" + repetidor + ", Tutor=" + Tutor.toString()+  ' ';
    }
    
    
    
    
}
