package com.hibernate_manyToMany_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetInstCourses {

    public static void main(String[] args) throws Exception {
        //DataConnection.execute("SELECT * FROM COURSE");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Course.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Instructor inst = session.get(Instructor.class, 22);
            Student st = session.get(Student.class, 17);
            System.out.println(st);
            List<Course> courseList = st.getCourses(); //getting courses of specific Student
            Course delc = courseList.get(courseList.size()-1); //assigning the course to be deleted
            inst.getInstCourses().remove(delc);              //removing Instructor association of the course
            st.getCourses().remove(delc);                  //removing Student association of the course
            session.delete(delc);                         //finally removing course from database
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
