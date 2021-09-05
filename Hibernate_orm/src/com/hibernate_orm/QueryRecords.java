package com.hibernate_orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.ResultSet;
import java.util.List;

public class QueryRecords {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            List<Student> stdList = session.createQuery("from Student s where s.id in(1,2,5,7)" +
                    " order by s.id").getResultList(); //'s' is alias
            readList(stdList);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
//        fetchRows();

    }

    private static void readList(List<Student> stdList) {
        for(Student r : stdList){
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
