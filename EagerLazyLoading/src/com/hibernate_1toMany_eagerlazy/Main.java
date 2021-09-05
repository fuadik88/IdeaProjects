package com.hibernate_1toMany_eagerlazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) throws Exception {
        //DataConnection.execute("SELECT * FROM COURSE");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class)
                .addAnnotatedClass(Course.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Instructor inst = new Instructor("Gwen", "Stacy", "gwen@dot.com");
            InstructorDetails instd = new InstructorDetails("youtu.be/slimGwen", "luv");
            inst.setInstDetails(instd);
            session.save(inst);
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
