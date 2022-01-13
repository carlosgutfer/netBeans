/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class Ejercicio5 
{
    
    public static void main(String[] args) 
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/Relaciones";
            String root = "root";
            String password = "";
            
            Connection cn = DriverManager.getConnection(url, root, password);
            Statement st = cn.createStatement();
            Statement st1 = cn.createStatement();
            poblar_tabla_emparejamientos(st);
            
            ResultSet rs = st.executeQuery("SELECT * FROM EMPAREJAMIENTOS");
            
            
            while(rs.next())
            {
                double media;
                
                media = rs.getDouble(3);
                if( media >= 0.8)
                {
                    st1.executeUpdate("DELETE FROM MUJERES WHERE CODIGO = " + rs.getInt(2));
                    st1.executeUpdate("DELETE FROM HOMBRES WHERE CODIGO = " + rs.getInt(1));
                }else if(media >= 0.5 && media < 0.8)
                {
                    st1.executeUpdate("DELETE FROM EMPAREJAMIENTOS WHERE codigoH = " + rs.getInt(1) + " AND codigoM = " + rs.getInt(2));
                }else if(media < 0.5)
                {
                    st1.executeUpdate("DELETE FROM EMPAREJAMIENTOS WHERE codigoH = " + rs.getInt(1) + " AND codigoM = " + rs.getInt(2));
                    st1.executeUpdate("UPDATE "
                                        + "MUJERES SET V1 = V1 + 0.1, V2 = V2 + 0.1, V3 = V3 + 0.1, V4 = V4 + 0.1, V5 = V5 + 0.1 "
                                        + "WHERE codigo = " + rs.getInt(2));
                     st1.executeUpdate("UPDATE "
                                        + "HOMBRES SET V1 = V1 + 0.1, V2 = V2 + 0.1, V3 = V3 + 0.1, V4 = V4 + 0.1, V5 = V5 + 0.1 "
                                        + "WHERE codigo = " + rs.getInt(1));
                }    
            }    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ejercicio5.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Ejercicio5.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio5.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio5.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    private static void poblar_tabla_emparejamientos(Statement st) throws FileNotFoundException, IOException, SQLException 
    {
        File f1 = new File("datos.bin");
        FileInputStream fis = new FileInputStream(f1);
        DataInputStream dis = new DataInputStream(fis);
        ResultSet rs;
        double sumatorioDeLosMultiplos;
        double sumatorioDeLasRaices;
        int codigoMujer;
        int codigoHombre;
        try
        {
            while(true)
            {
                codigoMujer = dis.readInt();
                codigoHombre = dis.readInt();
                rs = st.executeQuery("SELECT V1, V2, V3, V4 ,V5 FROM MUJERES WHERE CODIGO = "+ codigoMujer+"");
                ArrayList<Double>  valoresM  = obetnerValores(rs);
                rs = st.executeQuery("SELECT V1, V2, V3, V4 ,V5 FROM HOMBRES WHERE CODIGO = "+ codigoHombre+"");
                ArrayList<Double> valoresH  = obetnerValores(rs);
                sumatorioDeLosMultiplos = sumatorioDeLosMultiplos(valoresH, valoresM);
                sumatorioDeLasRaices = sumatorioDeLasRaices(valoresH, valoresM);
                st.executeUpdate("INSERT INTO Emparejamientos values (" + codigoHombre + ", " + codigoMujer + ", " + (sumatorioDeLosMultiplos / sumatorioDeLasRaices) + ")");
            }
        }catch (IOException ex) {
            System.out.println("LECTURA DEL FICHERO BIANRIO FINALIZADA");
        }
        dis.close();
        fis.close();
    }

    private static ArrayList obetnerValores(ResultSet rs) throws SQLException 
    {
        ArrayList<Double> valores = new ArrayList<>();
        int i = 0;
        while(rs.next())
            while(i < 5)
                valores.add(rs.getDouble(++i));
        return  valores;
    }

    private static double sumatorioDeLosMultiplos(ArrayList<Double> valoresH, ArrayList<Double> valoresM) 
    {
        double sumatorio;
        sumatorio = 0;
        for(int i = 0; i < valoresH.size(); ++i)
            sumatorio += valoresH.get(i) * valoresM.get(i);
        
        return  sumatorio;
    }

    private static double sumatorioDeLasRaices(ArrayList<Double> valoresH, ArrayList<Double> valoresM)
    {
        double sumatorioH, sumatorioM;
        
        
        sumatorioH = 0;
        sumatorioM = 0;
        
        for(int i= 0; i < valoresH.size(); ++i)
        {
            sumatorioH += Math.pow(valoresH.get(i), 2);
            sumatorioM += Math.pow(valoresM.get(i), 2);
        }
      return Math.sqrt(sumatorioH * sumatorioM);
    } 
    
}
