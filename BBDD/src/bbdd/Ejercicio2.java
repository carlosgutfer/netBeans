/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class Ejercicio2 {
    
    public  void main(String[] args) {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/America";
            String root = "root";
            String pass = "";
            
            Connection con = DriverManager.getConnection(url, root, pass);
            Statement st = con.createStatement();
            
            String query = "DROP TABLE IF EXISTS PersonaPaises";
            st.execute(query);
            
            query ="CREATE TABLE PersonaPaises( "
                    + "ID int PRIMARY KEY, "
                    + "Nombre varchar(15), "
                    + "Apellido varchar(15),"
                    + "Edad tinyint, "
                    + "NombrePais varchar(15), "
                    + "Tamanio varchar(15))" ; 
            
            st.execute(query);
            
            query = "Select T1.ID, T1.Nombre, Apellido, Edad, T2.Nombre, Tamanio "
                    + "FROM Persona T1 "
                    + "INNER JOIN Pais T2 "
                    + "ON T1.Pais = T2.ID ";
            
            ResultSet rs = st.executeQuery(query);
            Statement st1 = con.createStatement();
            while(rs.next())
            {
                st1.executeUpdate("INSERT INTO PersonaPaises "
                                    + "VALUES ("+rs.getInt(1) + ", '" +rs.getString(2) + "', '" + rs.getString(3) + "', " + rs.getInt(4) + ", '" + rs.getString(5) + "', '" + rs.getString(6) +"')");
            }
            st1.close();
            mostrar_todos_los_registros_PersonaPaises(st);
            query = "UPDATE PersonaPaises  SET Edad = Edad + 1 WHERE NombrePais = 'Costa Rica'";
            st.execute(query);
            mostrar_todos_los_registros_PersonaPaises(st);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private static void mostrar_todos_los_registros_PersonaPaises(Statement st) throws SQLException 
    {
        String query;
        ResultSet rs;
        query = "Select * from PersonaPaises";
        rs = st.executeQuery(query);
        while(rs.next())
        {
            System.out.println(rs.getInt(1) + ", '" +rs.getString(2) + "', '" + rs.getString(3) + "', " + rs.getInt(4) + ", '" + rs.getString(5) + "', '" + rs.getString(6));
        }
        System.out.println("================================================");
    }
}
