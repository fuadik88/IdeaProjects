package com.hibernate_manyToMany_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourse {

    public static void main(String[] args) throws Exception {
//        DataConnection.execute("SELECT * FROM INSTRUCTOR");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Instructor inst = session.get(Instructor.class, 22);
            Student st = session.get(Student.class, 17);
            Course c1 = new Course("From Scratch");
            Course c2 = new Course("WebFlux");
            Course c3 = new Course("Oracle on the way");
            c1.addStudent(st);
            c2.addStudent(st);
            c3.addStudent(st);
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
