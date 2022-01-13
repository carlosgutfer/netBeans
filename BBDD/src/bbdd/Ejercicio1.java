/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

/**
 *
 * @author carlo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio1 {

  
    public  void main(String[] args) {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/instituto";
            String user = "root";
            String password = "";
            
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            
            st.execute("DROP TABLE NOTASFINALES");
            String query ="CREATE TABLE NOTASFINALES("
                    +"Mat VARCHAR(10) NOT NULL,"
                    +"Cod TINYINT (2) NOT NULL,"
                    +"NotaMedia INT (2) NOT NULL,"
                    +"PRIMARY KEY (Mat, Cod),"
                    +"FOREIGN KEY (Mat) REFERENCES ALUMNOS (Mat),"
                    +"FOREIGN KEY (COD) REFERENCES  ASIGNATURAS (COD))";
            st.execute(query);
            String matricula;
            int codigo;
            query = "Select * from Notas";
            ResultSet rs = st.executeQuery(query);
            Statement st1 = con.createStatement();
            Double notaMedia;
            while(rs.next())
            {
             matricula = rs.getString(1);
             codigo = rs.getInt(2);
             notaMedia =  (double)  rs.getInt(3) + rs.getInt(4) + rs.getInt(5) / 3;
             st1.executeUpdate("Insert into NOTASFINALES VALUES ('" + matricula + "'," + codigo + "," + notaMedia +")");        
            }
            st1.close();
            query = " Select T2.APEL_NOM, T3.NOMBRE, nota1, nota2, nota3, T4.NOTAMEDIA "
                    + "FROM NOTAS T1 "
                        + "INNER JOIN "
                            + "ALUMNOS T2 "
                            + "ON T1.MAT = T2.MAT "
                        + "INNER JOIN "
                            + "ASIGNATURAS T3 "
                            + "ON T1.COD = T3.COD "
                        + "INNER JOIN "
                            + "NOTASFINALES T4 "
                            + "ON T1.COD = T4.COD AND T1.MAT = T4.MAT";
                    
            rs = st.executeQuery(query);
            System.out.println("Nombre Alumno                Nombre Asignatura           Nota 1     Nota 2   Nota 3      NotaMedia");
            while(rs.next())
            {
                System.out.println(rs.getString(1)+"     "+rs.getString(2)+"            "+rs.getInt(3)+"        "+ rs.getInt(4) + "         " +rs.getInt(5)+ "          "+rs.getDouble(6));
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
