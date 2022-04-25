package com.hibernate.demo;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            int id=1;
            Instructor instructor=session.get(Instructor.class,id);

            System.out.println("luv2code: Instructor"+instructor.toString());

            //session.close();

            System.out.println("luv2code: Courses"+instructor.getCourses());

            // commit transaction
            session.getTransaction().commit();

            System.out.println("luv2code: "+"Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }

}
