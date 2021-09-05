package com.hibernate_orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.ResultSet;
import java.util.List;

public class UpdateRecords {
    public static void main(String[] args) throws Exception {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Student st = session.get(Student.class, 3);
            st.setFirstName("UPDATED3Times");                   //One way of updating records
            st.setEmail("boredofbeingupdated@fckoff.com");
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Student st set email='booyaaaa@hibernate.org' where " +
                    "st.firstName='fuad'").executeUpdate();     //Another way of updating records
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            List<Student> fetched = session.createQuery("from Student s order by s.id").getResultList();
            session.getTransaction().commit();
            getRecords(fetched);
        } finally {
            factory.close();
        }
//        fetchRows();

    }

    private static void getRecords(List<Student> fetched) {
        for(Student r : fetched){
            System.out.println(r);
        }
    }

    public static void fetchRows() throws Exception {
        ResultSet rs = DataConnection.execute("SELECT * FROM STUDENT");
        System.out.println("---  ---  ---  ---  ---  ---  ---  ---  ---  ---  ---  ---  ---  ---  ---  ");
        while (rs.next()) {
            System.out.println(rs.getString("ID") + " | " + rs.getString("FIRST_NAME")
                    + " | " + rs.getString("LAST_NAME") + " | " + rs.getString("EMAIL"));
        }
    }
}
