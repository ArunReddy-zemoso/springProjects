package com.hibernate.demo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            List students = session.createQuery("from Student").list();

            displayStudents(students);
            System.out.println();

            students=session.createQuery("from Student s where s.lastName='Doe'").list();
            displayStudents(students);
            System.out.println();

            students=session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffy'").list();
            displayStudents(students);
            System.out.println();

            students=session.createQuery("from Student s where s.email LIKE '%luv2codeh.com'").list();
            displayStudents(students);
            System.out.println();



            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        for(Student student : students) {
            System.out.println(student);
        }
    }

}
