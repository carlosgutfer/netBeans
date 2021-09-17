/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacro;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;

/**
 *
 * @author carlo
 */
public class Simulacro {

    private  File f1,f2;
    private Connection cnt;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public static void main(String[] args) {
          Simulacro sm = new Simulacro();
          sm.initAll();
          sm.addBi();
          sm.addObj();
          sm.getBBDD();
    }

    private void initAll()  {
        try {
             f1 = new File("alumno.dat");
             f2 = new File("alumno.obj");
             if (!f1.exists())
                 f1.createNewFile();
             else if (!f2.exists())
                f2.createNewFile();
            cnt = DriverManager.getConnection("jdbc:mysql://localhost/simulacro", "root", "");
            System.out.println("correcto");

        } catch (SQLException  e) {
            System.out.println("err");
        }catch(IOException e){
            
        }
    }

    private void addBi() {
        try {
            FileOutputStream fos = new FileOutputStream(f1);
            DataOutputStream dat = new DataOutputStream(fos);
            dat.writeUTF("carlos");
            dat.writeInt(20);
            dat.writeInt(5);
            dat.writeUTF("Juan");
             dat.writeInt(20);
            dat.writeInt(1);
            dat.close(); fos.close();
            showAll(1);
        } catch (IOException e) {
        }
    }

    private void addObj() {
        try {
            FileOutputStream fos = new FileOutputStream(f2);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(new alumno("Luis", 21, 0));
            oos.writeObject(new alumno("Maria", 22, 0));
            oos.close();fos.close();
            showAll(2);
        } catch (IOException e) {
        }
 
    }

    private void showAll(int i) {
        
        if (i == 1 ){
            
            try {
                FileInputStream fis = new FileInputStream(f1);
                DataInputStream dos = new DataInputStream(fis);
                
                try {
                     while(true){
                    pobBBDD(dos.readUTF(),dos.readInt(),dos.readInt());
                    }
                } catch (Exception e) {
                }
               
                dos.close();
                fis.close();
                
                
            } catch (Exception e) {
            }
        }
        if (i==2) {
            try {
                FileInputStream fis = new FileInputStream(f2);
                ObjectInputStream oos = new ObjectInputStream(fis);
                
                try {
                     while (true) {        
                         alumno alu = (alumno) oos.readObject();
                         pobBBDD(alu.getNombre(),alu.getEdad(),alu.getFaltas());
                     }
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(""+e);
                }
               
               
            } catch (Exception e) {
            }
            
        }
        
        
    }

    private void pobBBDD(String nombre, int edad, int faltas ) {
        try{
            pst = cnt.prepareStatement("Insert into alumno values(?,?,?) ");
            pst.setString(1, nombre);
            pst.setInt(2, edad);
            pst.setInt(3, faltas);
            pst.execute();
            pst.close();
        }catch(SQLException e){
            
        }
        

    }

    private void getBBDD() {
        try {
            pst = cnt.prepareStatement("Select * from alumno");
            rs = pst.executeQuery();
            
            while (rs.next()){
                System.out.println(""+rs.getString(1)+" "+rs.getInt(2)+" "+rs.getInt(3));
            }
            
        } catch (SQLException e) {
            System.out.println(""+e);
        }

    }
    
    

  
    
}
