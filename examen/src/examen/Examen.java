/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author carlo
 */
public class Examen {

    static Connection  conexion;    
    static Statement   instruccion;  
    static ResultSet   resultados; 
    static  ArrayList<vehiculos> avehiculos = new ArrayList();
    static ArrayList<vehiculos> avehiculosaux = new ArrayList();
    
    
    public static void main(String[] args) {
        try {
            conexion = DriverManager.getConnection ("jdbc:mysql://localhost/examen","root","");
            instruccion = conexion.createStatement();
            creartabla();    
            crearfichero();
            cargardatos();
            mostrarDatos();
            incrementar1();
            incrementar2();
            resultados.close(); instruccion.close(); conexion.close();
        }catch(Exception e) {
            System.out.println(e);}
    }
    
     static void creartabla(){        
        try {
         
            instruccion.execute("Drop table if exists taller;");           
            instruccion.execute("create table taller (matricula varchar(7), DniPropietario int(9), coste int(8), revision int(8), marca varchar(20), modelo varchar(20));"); 

            instruccion.executeUpdate("insert into taller values ('11111L',11111111,10,5,'mercedes','seriea' );");
            instruccion.executeUpdate("insert into taller values ('22222g',22222222,20,50,'bmw','todoT'); ");
            instruccion.executeUpdate("insert into taller values ('33333F',33333333,30,500,'porche','ciaman'); ");

           
            
        }catch(Exception e) {System.out.println(e);}
    }
  
      static void crearfichero() {		
        try{            
            File taller = new File("taller.dat");
            FileOutputStream fos = new FileOutputStream(taller, true);
            DataOutputStream dos = new DataOutputStream(fos); 
                                        
            try{            
                    dos.writeUTF("11111L");
                    dos.writeInt(11111111);
                    dos.writeInt(5);
                    dos.writeInt(10);
                    dos.writeInt(200);
                    dos.writeInt(2);
                    dos.writeBoolean(true);
                    
                    dos.writeUTF("22222g");
                    dos.writeInt(22222222);
                    dos.writeInt(50);
                    dos.writeInt(20);                    
                    dos.writeInt(250);
                    dos.writeInt(4);
                    dos.writeBoolean(true);
                    
                    dos.writeUTF("33333F");
                    dos.writeInt(33333333);
                    dos.writeInt(500);
                    dos.writeInt(30);
                    dos.writeInt(300);
                    dos.writeInt(4);
                    dos.writeBoolean(false);

            }catch(IOException e){
                System.out.println(e);
            }                       
            dos.close();
            fos.close();
			
        }catch (IOException e){System.out.println(e);}
	}	
     
     static void cargardatos() {	
        try{
            File taller = new File("taller.dat");
            FileInputStream fis = new FileInputStream(taller);
            DataInputStream dis = new DataInputStream(fis);
            
            
            
            try{
                while(true){
                    String matricula = dis.readUTF();
                    int dni = dis.readInt();
                    int coste = dis.readInt();
                    int revision = dis.readInt();
                    int potencia = dis.readInt();
                    int ejes = dis.readInt();
                    boolean aire = dis.readBoolean();
                   
                resultados= instruccion.executeQuery("SELECT marca,modelo FROM taller where ( matricula = '" +matricula+"' );");
                while(resultados.next()) {
                    String marca= resultados.getString("marca");
                    String modelo= resultados.getString("modelo");
                    vehiculos ovehiculos = new vehiculos(matricula, dni, coste, revision, potencia, ejes, aire, marca, modelo);
                    avehiculos.add(ovehiculos);        
                }  
                
                }
            }catch(IOException  e){
                System.out.println(e);
            }catch (SQLException e){
                System.out.println(e);

            }
            fis.close();
            dis.close();
        }catch (IOException e){System.out.println(e);}
	}

     static void mostrarDatos() {
        for (int i =0; i<avehiculos.size();i++){
            if (i%2==0)
                System.out.println(""+avehiculos.get(i));
            else 
              avehiculosaux.add(avehiculos.get(i));
           
     
        }
        
        for (int i=0; i<avehiculosaux.size();i++){
            System.out.println(""+avehiculosaux.get(i));
        }
        
       avehiculos.clear(); avehiculosaux.clear();
        
    }

     static void incrementar1() {
         try {
            instruccion.executeUpdate("UPDATE TALLER SET revision = REVISION + 1 ;");    

         } catch (Exception e) {
             System.out.println(e);
         }

     }

    static void incrementar2() {		
        try{
            File taller = new File("taller.dat");
            FileInputStream fis = new FileInputStream(taller);
            DataInputStream dis = new DataInputStream(fis);  
            
            File talleraux = new File("talleraux.dat");
            FileOutputStream fos = new FileOutputStream(talleraux,true);
            DataOutputStream dos = new DataOutputStream(fos);            
            
            try{
               
                while(true){
                    String matricula = dis.readUTF();
                    int dni = dis.readInt();
                    int coste = dis.readInt();
                    int revision = dis.readInt();
                    int potencia = dis.readInt();
                    int ejes = dis.readInt();
                    boolean aire = dis.readBoolean();
                    
                    dos.writeUTF(matricula);
                    dos.writeInt(dni);
                    dos.writeInt(coste);
                    dos.writeInt(revision+1);
                    dos.writeInt(potencia);
                    dos.writeInt(ejes);
                    dos.writeBoolean(aire);
      				
                }
            }catch(EOFException e){
                System.out.println(e);
            }
            dos.close();
            fos.close();
            dis.close();
            fis.close();
			
            taller.delete();
            talleraux.renameTo(taller); 

			
        }catch (IOException e){System.out.println(e);}
	}

     

}
