/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nacho;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class main {

    /**
     * @param args the command line arguments
     */
    
    private static  Scanner entrada; 
    private static  profesor p1;
    private static  alumno a1;
    private static ArrayList <profesor> all_profesores = new ArrayList();
    private static ArrayList <alumno> all_alumno = new ArrayList();

    
    public  void main(String[] args)
    {
        
        entrada = new Scanner(System.in);
        System.out.println("nombre");
            String nombre = entrada.next();
        System.out.println("apellido");
            String apellido = entrada.next();
        System.out.println("edad");
            int edad = entrada.nextInt();
        System.out.println("DNI");
            String DNI = entrada.next();
        System.out.println("Teléfono");
            int telefono = entrada.nextInt(); // hasta aquí los atributos del padre
        
        System.out.println("sueldo");
        double sueldo = entrada.nextDouble(); 
        System.out.println("asignatura");
        String asignatura = entrada.next(); 
        System.out.println("Numero alumnos");
        int n_alumnos = entrada.nextInt(); //Hasta aquí atributos propios
        
        p1 = new profesor(nombre, apellido, edad, DNI, telefono, sueldo, asignatura, n_alumnos); //molde del objeto relleno */

        System.out.println("nombre");
            nombre = entrada.next();
        System.out.println("apellido");
            apellido = entrada.next();
        System.out.println("edad");
            edad = entrada.nextInt();
        System.out.println("DNI");
            DNI = entrada.next();
        System.out.println("Teléfono");
            telefono = entrada.nextInt(); // hasta aquí los atributos del padre
        
        System.out.println("curso");
            short curso = entrada.nextShort();
        System.out.println("nota media");
            float nota_media = entrada.nextFloat();
        String mensaje = null;
        System.out.println("repetidor Y/N");
            mensaje = entrada.next();
        boolean repetidor;
            if (mensaje == "Y")
               repetidor = true;
            else if(mensaje == "N")
                repetidor = false;
        
        a1 = new alumno(nombre, apellido, edad, DNI, telefono, curso, nota_media, false, p1);
        
        System.out.println(a1.toString());//Este método evita que tengas que repetir a1.getNombre() + " " + ai.get... + n_veces
        
         
    }
    
}
