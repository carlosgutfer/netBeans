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
public class Ejercicio3 {
    
    public  void main(String[] args) 
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/Tienda";
            String root = "root";
            String password = "";
            
            Connection cn = DriverManager.getConnection(url, root, password);
            Statement st = cn.createStatement();
            
            crear_tabla_ArtFab(st);
            poblar_tabla(st, cn);
            String query = "Select * from ArtFab";
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                System.out.println(rs.getString(1) + "/" + rs.getString(2) + "/" + rs.getInt(3) + "/" + rs.getDouble(4));
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ejercicio3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Ejercicio3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private static void poblar_tabla(Statement st, Connection cn) throws SQLException {
        String query = "Select T1.Nombre, T2.Nombre, Precio "
                + "FROM Articulos T1 "
                + "INNER JOIN Fabricantes T2 "
                + "ON T1.CLFAB = T2.CLFAB";
        
        ResultSet rs = st.executeQuery(query);
        Statement st1 = cn.createStatement();
        String nombreArticulo;
        String nombreFabricante;
        int Precio;
        double IVA;
        while(rs.next())
        {
            nombreArticulo = rs.getString(1);
            nombreFabricante =rs.getString(2);
            Precio = rs.getInt(3);
            IVA = 0;
            
            if(Precio < 200)
                IVA =Precio* 0.1;
            else if(Precio < 500)
                IVA = Precio * 0.08;
            else if(Precio < 700)
                IVA = Precio * 0.06;
            if(IVA != 0)
                st1.executeUpdate("INSERT INTO ArtFab VALUES ('"+ nombreArticulo +"', '" + nombreFabricante + "' ," + Precio + ", " + IVA + ")");
            else
                st1.executeUpdate("INSERT INTO ArtFab (NombreArticulo, NombreFabricante, Precio) VALUES ('"+ nombreArticulo +"', '" + nombreFabricante + "' ," + Precio + ")");
        }
    }

    private static void crear_tabla_ArtFab(Statement st) throws SQLException 
    {
        String query = "Drop TABLE IF EXISTS ArtFab";
        st.execute(query);
        
        query = "CREATE TABLE IF NOT EXISTS ArtFab( "
                + "NombreArticulo VARCHAR(30) NOT NULL, "
                + "NombreFabricante VARCHAR(30) NOT NULL, "
                + "Precio INT NOT NULL, "
                + "IVA DOUBLE DEFAULT NULL)";
        
        st.execute(query);
    }
    
}
