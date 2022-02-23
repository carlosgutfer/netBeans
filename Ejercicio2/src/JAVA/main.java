/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JAVA;

import POJOS.Productos;
import POJOS.Ventas;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author carlo
 */
public class main {
    public static void main(String[] args) {
        SessionFactory sf = NewHibernateUtil.sessionFactory();
        Session sesion=sf.openSession();
        Transaction t=sesion.beginTransaction();
        File f1 = new File ("C:\\Users\\carlo\\NetBeansProjects\\Ejercicio2\\ventas.dat");
        try {
            FileInputStream fis = new FileInputStream(f1);
            DataInputStream dis = new DataInputStream(fis);
            String cod_vendedor;
            int codProd, unidades;
              show_all(sesion);
            try 
            {
                while((cod_vendedor = dis.readUTF()) != null)
                {
                    codProd = dis.readInt();
                    unidades = dis.readInt();
                    Productos p = (Productos) sesion.get(Productos.class,  codProd);
                    List<Ventas> all_ventas= sesion.createQuery("FROM Ventas").list();
                    Ventas v = null;
                    for (int i = 0; i < all_ventas.size(); ++i)
                    {
                        if(all_ventas.get(i).getCodVend().equals(cod_vendedor) && all_ventas.get(i).getProductos().equals(p))
                        {
                             v = all_ventas.get(i);
                        }
                    }
                    if(v != null)
                    {
                        v.setUnidades(v.getUnidades() + unidades);
                        BigDecimal precio = p.getPrecio();
                        v.setGanancia(v.getGanancia().add(precio.multiply(BigDecimal.valueOf(unidades))));
                        sesion.update(v);
                    }else
                    {
                        BigDecimal precio = p.getPrecio();
                        v = new Ventas(all_ventas.get(all_ventas.size() - 1).getId() + 1, p, cod_vendedor, unidades, precio.multiply(BigDecimal.valueOf(unidades)));
                        sesion.save(v);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        show_all(sesion);
        
        
        System.exit(0);
    }

    private static void show_all(Session sesion) {
        Query q = sesion.createQuery("FROM Ventas");
        List<Ventas> all_ventas = q.list();
        for(int i = 0; i < all_ventas.size(); ++i)
            System.out.println(all_ventas.get(i).toString());
    }
    
}
