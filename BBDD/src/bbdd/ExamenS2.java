/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

import java.io.BufferedReader;
import java.io.File;
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
public class ExamenS2 
{
    public static void main(String[] args) throws SQLException, IOException {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/Juego";
            String root = "root";
            String pass = "";
            Connection cn = DriverManager.getConnection(url, root, pass);
            PreparedStatement pst_getArma = cn.prepareStatement("Select dano FROM ARMA WHERE codAr = ?");
            PreparedStatement pst_getEscudo = cn.prepareStatement("SELECT  defensa FROM ESCUDO WHERE codEs = ?");
            PreparedStatement pst_actualizar_vida = cn.prepareStatement("UPDATE PERSONAJE SET VIDA = VIDA - ? WHERE id = ?");
            PreparedStatement pst_borrar_personajes = cn.prepareStatement("DELETE FROM PERSONAJE WHERE vida  < 10");
            FileReader fr = new FileReader(new File("jugadas.txt"));
            BufferedReader br = new BufferedReader(fr);
            String line;
            String [] datos;
            ResultSet rs1, rs2, rs3;
            int arma, escudo;
            while((line = br.readLine()) != " ")
            {
                if (line == "")
                System.out.println("line");
                datos = line.split(",");
                pst_getArma.setInt(1,Integer.valueOf(datos[1]));
                rs1 = pst_getArma.executeQuery();
                pst_getEscudo.setInt(1, Integer.valueOf(datos[3]));
                rs2 = pst_getEscudo.executeQuery();
                if(rs1.next() && rs2.next())
                {
                    arma = rs1.getInt(1); 
                    escudo = rs2.getInt(1);
                    if(arma > escudo)
                    {
                        pst_actualizar_vida.setInt(1, arma - escudo);
                        pst_actualizar_vida.setInt(2, Integer.valueOf(datos[2]));
                    }else
                    { 
                        pst_actualizar_vida.setInt(1, escudo - arma);
                        pst_actualizar_vida.setInt(2, Integer.valueOf(datos[0]));
                    }
                     int columnas = pst_actualizar_vida.executeUpdate();
                     if(columnas == 0)
                         System.out.println("No existe uno de los jugadores");
                    
                }else{System.out.println("No existe el arma o el escudo");}
                    pst_borrar_personajes.executeUpdate();
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExamenS2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExamenS2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
