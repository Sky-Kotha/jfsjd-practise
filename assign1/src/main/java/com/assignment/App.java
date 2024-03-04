package com.assignment;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.xml.XmlBeanFactory;//*;ans.factory.xml.XmlBeanFactory;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // System.out.println( "Hello World!" );
        // SessionFactory session = new Configuration()
        // .configure("hibernate.cfg.xml")
        // .addAnnotatedClass(Users.class)
        // // .addAnnotatedClass(null)
        // .buildSessionFactory();

        // Session currentSession = session.getCurrentSession();
        // try {
        // currentSession.beginTransaction();
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter Username and password");
        // // String username = sc.nextLine();
        // Users user = currentSession.createQuery('from Users where
        // username=:username')
        // .setPara;

        // String userInput = sc.nextLine();
        // if (userInput.equals(user.getPassword())) {
        // System.out.println("login successfully");
        // } else {
        // System.out.println("username and password dismatched");
        // }

        // // currentSession.createQuery("from
        // // Users").getResultList().forEach(System.out::println);
        // } finally {
        // currentSession.close();
        // }

        Resource r = new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(r);

        UsersDao dao = factory.getBean("d", UsersDao.class);

        Users e = new Users();
        e.setId(114);
        e.setName("varun");
        e.setIncome(50000);

        dao.saveEmployee(e);

    }
}
