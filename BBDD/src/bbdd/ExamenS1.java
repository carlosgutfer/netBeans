/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
public class ExamenS1 {
    public  void main(String[] args) throws SQLException, IOException {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/Comercio";
            String root = "root";
            String pass = "";
            Connection cn = DriverManager.getConnection(url, root, pass);
            PreparedStatement pst_buscar_vendedor = cn.prepareStatement("SELECT T1.*, T2.PRECIO FROM VENTAS T1 INNER JOIN PRODUCTOS T2 ON T1.CODPROD = T2.CODPROD WHERE CODVEND = ? AND  T2.CODPROD = ?");
            PreparedStatement pst_modificar_vendedor = cn.prepareStatement("UPDATE VENTAS SET VENDIDO = VENDIDO + ?, GANANCIA = GANAnCIA + ? WHERE CodVend = ? ");
            PreparedStatement pst_consultar_precio = cn.prepareStatement("SELECT Precio FROM Productos WHERE CODPROD = ?");
            PreparedStatement pst_dar_de_alta = cn.prepareStatement("INSERT INTO VENTAS VALUES (?, ?, ?, ?)");
            PreparedStatement pst_mostar_todo = cn.prepareStatement("SELECT * FROM VENTAS");
            FileInputStream fis = new FileInputStream(new File("ventas.dat"));
            DataInputStream dis = new  DataInputStream(fis);
            
            try 
            { 
                String codVend;
                int codProd, unidades;
                ResultSet rs, rs1;
                while(true)
                {
                 codVend = dis.readUTF();
                 codProd = dis.readInt();
                 unidades = dis.readInt();
                    
                 pst_buscar_vendedor.setString(1, codVend);
                 pst_buscar_vendedor.setInt(2, codProd);
                 rs = pst_buscar_vendedor.executeQuery();
                 if(rs.next())
                 {
                     pst_modificar_vendedor.setInt(1, unidades);
                     pst_modificar_vendedor.setDouble(2, unidades * rs.getDouble(5));
                     pst_modificar_vendedor.setString(3, codVend);
                     pst_modificar_vendedor.executeUpdate();
                 }    
                 else
                 {
                     pst_consultar_precio.setInt(1, codProd);
                     rs1  = pst_consultar_precio.executeQuery();
                     rs1.next();
                     pst_dar_de_alta.setString(1, codVend);
                     pst_dar_de_alta.setInt(2, codProd);
                     pst_dar_de_alta.setInt(3, unidades);
                     pst_dar_de_alta.setDouble(4, (unidades * rs1.getInt(1)));
                     pst_dar_de_alta.executeUpdate();
                 }
                }
            } catch (IOException e) {
            }
            dis.close();
            fis.close();
            ResultSet rs = pst_mostar_todo.executeQuery();
            while(rs.next())
                System.out.println(rs.getString(1) + "-" + rs.getInt(2) + "-" + rs.getInt(3) + "-" + rs.getDouble(4));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExamenS1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExamenS1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
