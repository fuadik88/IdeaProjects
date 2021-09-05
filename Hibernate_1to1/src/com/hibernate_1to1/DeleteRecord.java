package com.hibernate_1to1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteRecord {

    public static void main(String[] args) throws Exception{
//        DataConnection.execute("SELECT * FROM INSTRUCTOR");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();
            Instructor del1 = session.get(Instructor.class, 2);
            System.out.println("This instructor is being deleted! :: \n" + del1);
            Thread.sleep(2000);
            session.delete(del1);
            session.getTransaction().commit();
            System.out.println("Success!");
        } finally {
            factory.close();
        }
    }
}
