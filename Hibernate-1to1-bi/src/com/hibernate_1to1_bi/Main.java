package com.hibernate_1to1_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) throws Exception {
//        DataConnection.execute("SELECT * FROM INSTRUCTOR");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            InstructorDetails getinstd = session.get(InstructorDetails.class, 2);
            System.out.println(getinstd);
            System.out.println(getinstd.getInstructor());
            session.getTransaction().commit();
            System.out.println("Objects is successfully pushed to database");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
