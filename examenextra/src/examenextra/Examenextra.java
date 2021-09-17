/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenextra;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author alumno1
 */
public class Examenextra {

   static Connection  conexion;    
    static Statement   instruccion;  
    static ResultSet   resultados; 
    static PreparedStatement pst; 
    static alumno aAlumnos[] = new alumno [5];
    static  ArrayList<alumno> alAlumnos = new ArrayList();
    
    
    
    public static void main(String[] args) {
 try {
            conexion = DriverManager.getConnection ("jdbc:mysql://localhost/alumnos","root","");
            instruccion = conexion.createStatement();
            nuevoFichero();
            nuevoArray();    
            creartabla();    
            modificarTabla();
            pasarDatosAlArrayList();
            ordenarArrayList();
           
            resultados.close(); instruccion.close(); conexion.close();
        }catch(Exception e) {
            System.out.println(e);}        
    }

    private static void nuevoFichero() {
         try{      
    
            File taller = new File("alumnos.bin");
            taller.createNewFile();

            FileOutputStream fos = new FileOutputStream(taller);
            ObjectOutputStream  oos = new ObjectOutputStream (fos); 
            
                                        
            try{            
                oos.writeObject(new AlumnoZaragoza("Ana", "Lorca", "Zaragoza", 5, 8,20));
                oos.writeObject(new alumno("Silvio", "Galgo", "Madrid", 6, 7));
                oos.writeObject(new AlumnoVigo( "Carlos", "Linares", "Vigo", 5, 9,false));
                oos.writeObject(new AlumnoZaragoza("Javier", "Gordillo", "Zaragoza", 4, 8, 55));
                oos.writeObject(new AlumnoVigo("Laura", "Campos", "Vigo", 6,8, true));
                
            }catch(IOException e){
                System.out.println(e+"error aquí");
            }                       
            oos.close();
            fos.close();
			
        }catch (IOException e){System.out.println(e);}

    }

    private static void nuevoArray() {
        try {
            File alumnos = new File("alumnos.bin");
            FileInputStream     fis=new FileInputStream     (alumnos);
            ObjectInputStream   ois=new ObjectInputStream   (fis);
            try {
                int contador =0;
                while (true) {
                   
                 alumno oAlumno= (alumno) ois.readObject();
                 aAlumnos[contador] = oAlumno;
                 System.out.println(aAlumnos[contador].toString());     
                 contador++;
                }
            } catch (Exception e) {
            }
          
            ois.close(); fis.close();
        } catch (Exception e) {
        }  
        
    }

    private static void creartabla() {
        
         try {
         
            instruccion.execute("Drop table if exists Zaragoza;");           
            instruccion.execute("create table Zaragoza (nombre varchar(200), apellido varchar(200), ciudad varchar(200), notaMatematicas int(8), notaIngles varchar(200), donativo varchar(200));"); 
            pst = conexion.prepareStatement("INSERT INTO Zaragoza (nombre,apellido,ciudad,notaMatematicas,notaIngles,donativo) VALUES (?,?,?,?,?,?)");
            
            
            try {
                File alumnos = new File("alumnos.bin");
                FileInputStream     fis=new FileInputStream     (alumnos);
                ObjectInputStream   ois=new ObjectInputStream   (fis);
                
                File auxiliar=new File("auxiliar.bin");
                FileOutputStream fos= new FileOutputStream(auxiliar);
                ObjectOutputStream oos=new ObjectOutputStream(fos);
            
            try {
                while (true) {
                 alumno oAlumno= (alumno) ois.readObject();
                 if(oAlumno.getClass()== AlumnoZaragoza.class ){
                     AlumnoZaragoza alumnoSubida = (AlumnoZaragoza) oAlumno;
                        pst.setString(1, alumnoSubida.getNombre());
                        pst.setString(2, alumnoSubida.getApellido());
                        pst.setString(3, alumnoSubida.getCiudad());
                        pst.setInt(4, alumnoSubida.getNotaMatematicas());
                        pst.setInt(5, alumnoSubida.getNotaIngles());
                        pst.setInt(6,  alumnoSubida.getDonativo());
                        pst.executeUpdate();
                 }else{
                     
                 oos.writeObject(oAlumno);
                 }
                }
            } catch (Exception e) {
            }
          
            ois.close(); fis.close();
            oos.close(); fos.close();
            alumnos.delete(); 
            auxiliar.renameTo(alumnos);
        } catch (Exception e) {
        }  

           
            
        }catch(Exception e) {System.out.println(e);}
        
    }

    private static void modificarTabla() {
        try {
          pst = conexion.prepareStatement("UPDATE Zaragoza set donativo = 100 where (nombre like 'Ana' and apellido like 'Lorca') ");
          pst.executeUpdate();
        } catch (Exception e) {
        }
    }

    private static void pasarDatosAlArrayList() {
        
                try {
                File alumnos = new File("alumnos.bin");
                FileInputStream     fis=new FileInputStream     (alumnos);
                ObjectInputStream   ois=new ObjectInputStream   (fis);
                
              
            
            try {
                while (true) {
                        alAlumnos.add((alumno)ois.readObject());
                }
               
            } catch (Exception e) {
            }
             for(int i=0;i<alAlumnos.size();i++){
                       System.out.println( alAlumnos.get(i).toString2());
                    
             }
          
            ois.close(); fis.close();
           
            alumnos.delete(); 
           
        } catch (Exception e) {
        }  
        
    }

    private static void ordenarArrayList() {
        for (int i=0;i<alAlumnos.size();i++){
            if(i!=0){
                char ini1 = alAlumnos.get(i).getNombre().substring(0,1).charAt(0);
                char ini2 = alAlumnos.get(i-1).getNombre().substring(0,1).charAt(0);
                    if(ini1<ini2){
                        alumno aux = alAlumnos.get(i);
                        alAlumnos.remove(i);
                        alAlumnos.add(i-1,aux);
                    }
              }
        }
        for(int i=0;i<alAlumnos.size();i++){
                       System.out.println( alAlumnos.get(i).toString2());
                    
             }
        
    }
    
}
