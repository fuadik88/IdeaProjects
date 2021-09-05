package com.hibernate_1to1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) throws Exception{
//        DataConnection.execute("SELECT * FROM INSTRUCTOR");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            Instructor inst1 = new Instructor("Richard", "Parker", "rip555@gmail.com");
            InstructorDetails instd1 = new InstructorDetails("youtube.com/highrichard43", "tap");
            session.beginTransaction();
            inst1.setInstDetails(instd1);
            session.save(inst1);
            System.out.println("Instructor object saved");
            session.getTransaction().commit();
            System.out.println("Objects is successfully pushed to database");
        } finally {
            factory.close();
        }
    }
}
