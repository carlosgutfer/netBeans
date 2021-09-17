/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tayer;



import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TAYER {

   private  Connection cnt ;
    private  ResultSet rs;
    private  PreparedStatement pst; 
    private Scanner sc = new Scanner(System.in);
    private ArrayList allId = new ArrayList();
    
    public static void main(String[] args) throws SQLException {
TAYER init = new TAYER();
      init.initCon();    
   // init.addUser();
 //   init.addCar();
    init.showAll();}

    private void initCon()  {
        try {
          this.cnt =  DriverManager.getConnection("jdbc:mysql://localhost/datoscoches","root","");  
        } catch (SQLException e) {
            System.out.println("error de con"+e);
        }
    }

    private void addUser() throws SQLException {
        do {            
        System.out.println("Introduzca el DNI, x para salir");
            String DNI = sc.next().trim();
            if (DNI.equals('x'))
                    break;
        System.out.println("Introduzca el nombre");
            String nombre = sc.next().trim();
        System.out.println("Introduzca la edad");
            int edad = sc.nextInt();
        pst = cnt.prepareStatement("INSERT INTO PROPIETARIOS (DNI,NOMBRE,EDAD) VALUES (?,?,?)");
        pst.setString(1, DNI);
        pst.setString(2, nombre);
        pst.setInt(3, edad);
        pst.executeUpdate();
        } while (true);
       
    }

    private void addCar() {
        try {
           do {            
        System.out.println("la matricula, x para salir");
            String matricula = sc.next().trim();
            if (matricula.equals('x'))
                    break;
        System.out.println("Introduzca la marca");
            String marca = sc.next().trim();
        System.out.println("Introduzca el precio");
            double precio = sc.nextDouble();
            System.out.println("Introduzca el DNI");
            String DNI = sc.next().trim();        
        pst = cnt.prepareStatement("INSERT INTO COCHES (MATRICULA,MARCA,PRECIO,DNI) VALUES (?,?,?,?)");
        pst.setString(1, matricula);
        pst.setString(2, marca);
        pst.setDouble(3, precio);
        pst.setString(4, DNI);
        pst.executeUpdate();
        } while (true);
            
        } catch (Exception e) {
        }
        
    }

    private void showAll() {
        try{
        pst= cnt.prepareStatement("Select * from propietarios");
        rs = pst.executeQuery();
        while(rs.next())
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3));
        }catch (SQLException e){
            System.out.println("tayer.TAYER.showAll()");
        }
    }
    
}
