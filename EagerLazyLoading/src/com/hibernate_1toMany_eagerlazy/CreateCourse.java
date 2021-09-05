package com.hibernate_1toMany_eagerlazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourse {

    public static void main(String[] args) throws Exception {
//        DataConnection.execute("SELECT * FROM INSTRUCTOR");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class)
                .addAnnotatedClass(Course.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Instructor inst = session.get(Instructor.class, 21);
            Course c1 = new Course("Spring MVC");
            Course c2 = new Course("Node.js");
            Course c3 = new Course(".NET Core WEB");
            inst.add(c1);
            inst.add(c2);
            inst.add(c3);
            session.save(c1);
            session.save(c2);
            session.save(c3);
            session.getTransaction().commit();
            System.out.println("Course is created successfully");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
