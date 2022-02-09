/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class ejercicio1 {
    
    public static void main(String[] args) throws SQLException 
    {
        try 
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            String url = "jdbc:mysql://localhost/Tienda";
            String root = "root";
            String pass = "";
            conn = DriverManager.getConnection(url, root, pass);
            
            mostrar_tabla_fabricantes(conn);
            añadir_fabricante(conn);      
            mostrar_tabla_fabricantes(conn);
            PreparedStatement pst = conn.prepareStatement("DELETE FROM FABRICANTES WHERE NOMBRE = ?");
            pst.setString(1, "acer");
            pst.executeUpdate();
            mostrar_tabla_fabricantes(conn);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void añadir_fabricante(Connection conn) throws SQLException {
        PreparedStatement  pst = conn.prepareStatement("INSERT INTO FABRICANTES VALUES (?, ?)");
        pst.setInt(1, 6);
        pst.setString(2, "acer");
        pst.executeUpdate();
    }

    private static void mostrar_tabla_fabricantes(Connection conn) throws SQLException 
    {
        PreparedStatement pst = conn.prepareStatement("SELECT * FROM FABRICANTES");
        ResultSet rs = pst.executeQuery();// ejecuta y guarda en una especie de arrayList
        while(rs.next())
        {
            System.out.println("ID " + rs.getInt(1) + " nombre " + rs.getString(2));
        }
    }
}
