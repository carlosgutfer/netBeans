/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

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
public class Ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/Colegio";
            String root = "root";
            String password = "";
            
            Connection  cn  = DriverManager.getConnection(url, root, password);
            Statement   st  = cn.createStatement();
            Statement   st1 = cn.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT * FROM CAMBIOS");
            int matricula, nota;
            String cambio;
            while(rs.next())
            {
               matricula = rs.getInt(3);
               nota = rs.getInt(4);
               cambio = rs.getString(2);
               ResultSet rs1 = st1.executeQuery("SELECT * FROM ALUMNOS WHERE ID = " + matricula);
               if(rs1.next())
               {
                   if(cambio.equals("BJ"))
                       st1.executeUpdate("DELETE FROM ALUMNOS WHERE ID = " + matricula);
                   else 
                       st1.executeUpdate("UPDATE ALUMNOS SET NOTA = NOTA + " + nota);
                   System.out.println("La operación se ha realizado correctamente ");
               }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ejercicio5.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Ejercicio5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
