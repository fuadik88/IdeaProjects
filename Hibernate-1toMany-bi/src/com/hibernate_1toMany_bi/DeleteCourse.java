package com.hibernate_1toMany_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeleteCourse {

    public static void main(String[] args) throws Exception {
        //DataConnection.execute("DELETE FROM COURSE");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class)
                .addAnnotatedClass(Course.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Course course = session.get(Course.class, 13);
            System.out.println("Deleting course: " + course);
            Thread.sleep(2000);
            session.delete(course);
            session.getTransaction().commit();
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
