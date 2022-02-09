/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JAVA;

import POJO.Alumnos;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author carlo
 */
public class TeoriaHibernate 
{
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getsessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        show_all_alumnos(s);
           
        
        //INSERT
        Alumnos al = (Alumnos) s.get(Alumnos.class, "3000965");
        if(al == null)
        {
            al = new Alumnos("3000965", "Gutierrez_carlos", "Leganes", "99999999");
            s.save(al);
        }
        
        show_all_alumnos(s);
        s.close();
        System.exit(0);
    }

    private static void show_all_alumnos(Session s) {
        Query q = s.createQuery("FROM Alumnos");
        List<Alumnos> todos_los_alumnos = q.list();
        //Select
        for (int i = 0; i < todos_los_alumnos.size(); ++i)
            System.out.println(todos_los_alumnos.get(i).toString());
    }
}
