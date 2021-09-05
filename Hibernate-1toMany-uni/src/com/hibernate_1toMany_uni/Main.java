package com.hibernate_1toMany_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) throws Exception {
        //DataConnection.execute("SELECT * FROM COURSE");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            //Instructor inst = session.get(Instructor.class, 22);
            Course c1 = session.get(Course.class, 23);
            c1.addReview(new Review("very gut gut"));
            c1.addReview(new Review("I'm amazed"));
            //inst.add(c1);
            System.out.println("Saving course: " + c1);
            System.out.println(c1.getReviews());
            Thread.sleep(2000);
            session.save(c1);
            session.getTransaction().commit();
            System.out.println("Object is successfully pushed to database");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
