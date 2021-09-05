package com.hibernate_1to1_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstd {

    public static void main(String[] args) throws Exception {
//        DataConnection.execute("SELECT * FROM INSTRUCTOR");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            InstructorDetails getinstd = session.get(InstructorDetails.class, 3);
            getinstd.getInstructor().setInstDetails(null);
            System.out.println("Deleting: " + getinstd);
            Thread.sleep(2000);
            session.delete(getinstd);
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
