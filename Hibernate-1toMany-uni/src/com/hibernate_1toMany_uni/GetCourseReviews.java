package com.hibernate_1toMany_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetCourseReviews {

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
            Instructor inst = session.get(Instructor.class, 22);
            List<Course> courseList = inst.getInstCourses();
            System.out.println(courseList.get(0).getReviews());
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
