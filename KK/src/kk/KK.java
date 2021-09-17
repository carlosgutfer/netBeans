/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author carlo
 */
public class KK {

    static  Connection poConexion ;
    static  Statement poInstruccion;
    static  ResultSet poTalba;
    
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
           poConexion =  DriverManager.getConnection("jdbc:mysql://localhost/jv01","root","");
           poInstruccion = poConexion.createStatement();
           main1();
        } catch (Exception e) {
        }
    }

    private static void main1() {
            try {
                 poTabla = poInstruccion.executeQuery("Select * from personas");
        } catch (Exception e) {
        }

    }
    
}
