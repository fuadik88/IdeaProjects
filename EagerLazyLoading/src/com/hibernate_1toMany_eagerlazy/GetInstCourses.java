package com.hibernate_1toMany_eagerlazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetInstCourses {

    public static void main(String[] args) throws Exception {
        //DataConnection.execute("SELECT * FROM COURSE");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class)
                .addAnnotatedClass(Course.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Instructor inst = session.get(Instructor.class, 21);
            System.out.println(inst);
            System.out.println(inst.getInstCourses());
            session.getTransaction().commit();
            session.close();
            System.out.println("Success!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }

    private static void readCourses(List<Course> courses) {
        for(Course r : courses)
            System.out.println(r.getId() + ". " + r.getCourseTitle() + " by " + r.getInstructor().getFirstName()
                    .concat(" " + r.getInstructor().getLastName()));
    }
}
