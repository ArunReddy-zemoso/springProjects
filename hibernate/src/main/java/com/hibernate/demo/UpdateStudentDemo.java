package com.hibernate.demo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            int studentId=1;

            session = factory.getCurrentSession();

            session.beginTransaction();

            System.out.println("\nGetting Student with id: "+studentId);
            Student student = session.get(Student.class,studentId);

            System.out.println("Updating student");
            student.setFirstName("Scooby");

            session.getTransaction().commit();

            session=factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("updating email for all");

            session.createQuery("update Student s set s.email='foo@gamil.com'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }

}
