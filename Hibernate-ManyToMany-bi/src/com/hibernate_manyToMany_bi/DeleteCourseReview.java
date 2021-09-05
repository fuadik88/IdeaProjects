package com.hibernate_manyToMany_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeleteCourseReview {

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
            //List<Review> reviewList = courseList.get(0).getReviews();             //deleting review
            Course c1 = courseList.get(0);
            Review r1 = c1.getReviews().get(c1.getReviews().size()-1);
            c1.getReviews().remove(r1);
            session.delete(r1);

            Course rc1 = session.get(Course.class, 23);
            session.delete(rc1);                                                     //deleting course
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
