package com.hibernate_orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) throws Exception{
        /*SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new Student object...");
            Student st1 = new Student("IamNEW", "Record", "fillingemptiness@.com");
            //Student st2 = new Student("svsvfsdgv", "Parker", "spydeee@gmail.com");
            //Student st3 = new Student("asddas", "Osborn", "normancorp@gmail.com");
            //Student st4 = new Student("qws wqewqe", "Osborn", "gsgs22@gmail.com");
            session.beginTransaction();
            Thread.sleep(2000);
            System.out.println("Saving the student to Hibernate memory");
            session.save(st1);
            session.getTransaction().commit();
            System.out.println("Objects are successfully pushed to database");
            System.out.println(st1.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();
            Student myStd = session.get(Student.class, st1.getId());
            System.out.println(myStd);
            session.getTransaction().commit();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            factory.close();
        }*/
        fetchRows();

    }

    public static void fetchRows() throws Exception {
        ResultSet rs = DataConnection.execute("SELECT * FROM STUDENT");
        System.out.println("---  ---  ---  ---  ---  ---  ---  ---  ---  ---  ---  ---  ---  ---  ---  ");
        while(rs.next()){
            System.out.println(rs.getString("ID") + " | " + rs.getString("FIRST_NAME")
                    + " | " + rs.getString("LAST_NAME") + " | " + rs.getString("EMAIL"));
        }
    }
}
