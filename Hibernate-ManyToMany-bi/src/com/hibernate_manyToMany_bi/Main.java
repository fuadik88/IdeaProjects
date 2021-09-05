package com.hibernate_manyToMany_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.awt.*;

public class Main {

    public static void main(String[] args) throws Exception {
        //DataConnection.execute("SELECT * FROM COURSE");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Course c1 = new Course("How to smash it");
            session.save(c1);
            Student st1 = new Student("Norman", "Osborn", "veryNorman@oscorp.com");
            Student st2 = new Student("Vomit", "Tryan", "vomit.rayan@oscorp.com");
            c1.addStudent(st1);
            c1.addStudent(st2);
            session.save(st1);
            session.save(st2);
            session.getTransaction().commit();
            System.out.println("Success!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
