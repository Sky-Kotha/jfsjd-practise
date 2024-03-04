package com.hibernatedemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // System.out.println( "Hello World!" );
        SessionFactory session = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Mobile.class)
                .buildSessionFactory();

        Session currentSession = session.getCurrentSession();

        try {
            Mobile mobile = new Mobile("Oneplus5t", "Oneplus", 24999);

            currentSession.beginTransaction();
            // mobile.setId(2);

            // currentSession.save(mobile);

            // Mobile res = currentSession.get(Mobile.class, 5);
            // res.setId(2);

            // currentSession.update(res);

            currentSession.createQuery("from Mobile").getResultList().forEach(System.out::println);

            // System.out.println(res);
            // currentSession.delete(res);
            // currentSession.createQuery("from Mobile l where
            // l.manufacturer='Oneplus'").getResultList()
            // .forEach(System.out::println);

            currentSession.createQuery("from Mobile l where l.manufacturer LIKE '%plus'").getResultList()
                    .forEach(System.out::println);

            System.out.println("Enter id to update");
            System.out.println("Enter UpdatedName");
            currentSession.createQuery("update Mobile set name=:name where id=:mid")
                    .setParameter("mid", new Scanner(System.in).nextInt())
                    .setParameter("name", new Scanner(System.in).next())
                    .executeUpdate();

            currentSession.getTransaction().commit();

        } finally {
            currentSession.close();

        }

    }
}
