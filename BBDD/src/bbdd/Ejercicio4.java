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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class Ejercicio4 
{
    private static Scanner sc = new Scanner(System.in);
    public  void main(String[] args) {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/DatosCoches";
            String root = "root";
            String password = "";
            
            Connection cn = DriverManager.getConnection(url, root, password);
            Statement st = cn.createStatement();
            
            String mensaje;
            do
            {
                System.out.println("Escriba:\n 1. Dar alta propietario \n 2. Dar alta coche \n 3. Buscar Mostrar coches por DNI \n 4. MOdificar propietario con matrícula \n 5. Dar de baja un coche \n 6. Borrar un propietario \n 7. Salir");
                mensaje = sc.next();
                switch (mensaje)
                {
                    case "1":
                        crear_nuevo_Propietario(st);
                        break;
                    case "2":
                        introducir_nuevo_coche(st);
                        break;
                    case "3":
                        mostrar_coches_x_propietario(st);                   
                        break;
                    case "4":
                            modificar_propietario(st);
                        break;
                    case "5":
                         eliminar_coche(st);
                        break;
                    case "6":
                   
                        break;
                    case "7":
                        System.out.println("Cerrando el programa");
                        break;
                    default:
                        System.out.println("Debe elegir una opción del 1 al 7");
                }
                }while(!mensaje.equals("7"));
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ejercicio4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Ejercicio4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void eliminar_coche(Statement st) throws SQLException 
    {
        System.out.println("Introduzca la matrícula del coche que desea borrar ");
        String mensaje = sc.next();
        st.executeUpdate("DELETE FROM Coches WHERE Matricula LIKE '" + mensaje + "'");
    }

    private static void modificar_propietario(Statement st) throws SQLException 
    {
        String coche [];
        System.out.println("Introduzca matrícula y DNI nuevo del coche que desea modifciar");
        coche = (sc.next()).split("/");
        ResultSet rs = st.executeQuery("SELECT DNI FROM Propietarios WHERE DNI LIKE " + coche[1]);
        if(rs.next())
            st.executeUpdate("UPDATE Coches SET id = '" + coche[1] + "' WHERE Matricula LIKE '" + coche[0] + "'");
        else
            System.out.println("El DNI nuevo no existe en la tabla propietarios");
    }

    private static void mostrar_coches_x_propietario(Statement st) throws SQLException 
    {
        String mensaje;
        System.out.println("Introduzca el DNI del propietario que quiere saber sus coches: ");
        mensaje = sc.next();
        ResultSet rs = st.executeQuery("SELECT * FROM Coches WHERE Id = '" + mensaje + "'");
        while(rs.next())
            System.out.println("Matrícula: " + rs.getString(1) + " Marca " + rs.getString(2) + " Precio " + rs.getInt(3));
    }

    private static void introducir_nuevo_coche(Statement st) throws NumberFormatException, SQLException {
        String coche [];
        System.out.println("Introduzca matrícula, marca, precio y DNI del propietario para dar de alta al coche");
        coche = (sc.next()).split("/");
        ResultSet rs = st.executeQuery("SELECT DNI FROM Propietarios WHERE DNI LIKE " + coche[3]);       
        if(rs.next())
            st.executeUpdate("INSERT INTO Coches VALUES ('" + coche[0] + "', '" + coche[1] + "', " + Integer.valueOf(coche[2]) + ", '" + coche[3] +"') ");
        else
            System.out.println("El DNI no existe");
    }

    private static void crear_nuevo_Propietario(Statement st) throws SQLException {
        String [] propietario;
        System.out.println("Introduzca DNI, nombre y edad. Separados por un / para dar de alta al usuario");
        propietario = (sc.next()).split("/");
        st.executeUpdate("INSERT INTO Propietarios VALUES( '" + propietario[0] + "', '" + propietario[1] + "', " + propietario[2] + ")");
    }
}
