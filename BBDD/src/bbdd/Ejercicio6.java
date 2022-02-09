/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class Ejercicio6 {

    static Scanner sc = new Scanner(System.in);

    public  void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/Empresa";
            String root = "root";
            String password = "";

            Connection cn = DriverManager.getConnection(url, root, password);
            PreparedStatement pst_departamento_mas_10 = cn.prepareStatement("Select max(dept_no) from departamentos");
            PreparedStatement pst_insertar_nuevo_departamento = cn.prepareStatement("INSERT INTO DEPARTAMENTOS VALUES (?, ?, ?)");
            PreparedStatement pst_eliminar_registro_departamento = cn.prepareStatement("DELETE FROM DEPARTAMENTOS WHERE DEPT_NO = ? ");
            PreparedStatement pst_actualizar_departamentos_empleado = cn.prepareStatement("UPDATE EMPLEADOS SET dept_no = 0 WHERE DEPT_NO = ?");
            PreparedStatement pst_mostrar_datos_empleados = cn.prepareStatement("SELECT * FROM EMPLEADOS WHERE EMP_NO = ?");
            PreparedStatement pst_modificar_sueldo = cn.prepareStatement("UPDATE EMPLEADOS SET SALARIO = SALARIO + ? WHERE DEPT_NO = ? ");
            PreparedStatement pst_mostrar_todo = cn.prepareStatement("SELECT * FROM EMPLEADOS T1"
                                                                    + " INNER JOIN  DEPARTAMENTOS T2"
                                                                    + " ON T1.DEPT_NO = T2.DET_NO");
            String opcion;
            do {
                System.out.println("Introduzca: \n1 para insertar un nuevo departamento. \n2 para borrar un departamento \n3 para listar todos los datos de un empleado. \n4 para modificar el sueldo a todos los empleados de un departamento \n0 para salir");
                opcion = sc.next();
                switch (opcion) 
                {
                    case "1":
                        insertar_nuevo_departamento(pst_departamento_mas_10, pst_insertar_nuevo_departamento);
                        break;
                    case "2":
                        eliminar_departamento(pst_eliminar_registro_departamento, pst_actualizar_departamentos_empleado);
                        break;
                    case "3":
                        buscar_empleado(pst_mostrar_datos_empleados);
                        break;
                    case "4":
                        modificar_sueldo(pst_modificar_sueldo);
                        break;
                    case "5":
                        ResultSet rs = pst_mostrar_todo.executeQuery();
                        while(rs.next())
                        {
                            
                        }
                    default:
                        System.out.println("La opción introducida no existe");
                }
            } while (!opcion.equals("0"));

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ejercicio6.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Ejercicio6.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void modificar_sueldo(PreparedStatement pst_modificar_sueldo) throws SQLException, NumberFormatException {
        System.out.println("Introduzca el departamento y el sueldo separados por '/' ");
        String respuesta [] = (sc.next()).split("/");
        pst_modificar_sueldo.setFloat(1, Float.valueOf(respuesta[1]));
        pst_modificar_sueldo.setInt(2, Integer.valueOf(respuesta[0]));
        int num_reg_modificado = pst_modificar_sueldo.executeUpdate();
        if(num_reg_modificado == 0)
            System.out.println("No existe ningún departamento con ese número");
    }

    private static void buscar_empleado(PreparedStatement pst_mostrar_datos_empleados) throws SQLException {
        System.out.println("Introduzca el nº del empleado que desea buscar");
        int num_emp = sc.nextInt();
        pst_mostrar_datos_empleados.setInt(1, num_emp);
        ResultSet rs = pst_mostrar_datos_empleados.executeQuery();
        if (rs.next()) {
            System.out.println("Empleado: " + rs.getInt(1) + "\tApellido: " + rs.getString(2) + "\tOficio" + rs.getString(3));
        }

    }

    private static void eliminar_departamento(PreparedStatement pst_eliminar_registro_departamento, PreparedStatement pst_actualizar_departamentos_empleado) throws SQLException {
        System.out.println("Introduzca el departamento que desea borrar ");
        int dep_num = sc.nextInt();
        pst_eliminar_registro_departamento.setInt(1, dep_num);
        pst_actualizar_departamentos_empleado.setInt(1, dep_num);
        pst_eliminar_registro_departamento.execute();
        pst_actualizar_departamentos_empleado.execute();
    }

    private static void insertar_nuevo_departamento(PreparedStatement pst_departamento_mas_10, PreparedStatement pst_insertar_nuevo_departamento) throws SQLException {
        System.out.println("Introduzca el nombre del departamento y su localidad separadas por '/' ");
        String respuesta[] = (sc.next()).split("/");
        ResultSet rs = pst_departamento_mas_10.executeQuery();
        rs.next();
        int nuevo_num_dep = (rs.getInt(1)) + 10;
        pst_insertar_nuevo_departamento.setInt(1, nuevo_num_dep);
        pst_insertar_nuevo_departamento.setString(2, respuesta[0]);
        pst_insertar_nuevo_departamento.setString(3, respuesta[1]);
        pst_insertar_nuevo_departamento.executeUpdate();
    }
}
