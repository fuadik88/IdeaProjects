package com.hibernate_orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeleteRecords {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Student st = session.get(Student.class, 8);       //One way of deleting
            session.delete(st);
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("delete from Student where id=10").executeUpdate();
            session.getTransaction().commit();                          //Another way of deleting

            session = factory.getCurrentSession();
            session.beginTransaction();
            List<Student> list = session.createQuery("from Student order by id").getResultList();
            for(Student r : list)
                System.out.println(r);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
