package com.hibernate.demo;

import com.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            Course course=new Course("Pacmann - How To Score One Million Points");


            System.out.println("saving course...");
            session.save(course);
            System.out.println("Saved course: "+course);

            Student student1 = new Student("john","Deo","john@luv2code.com");
            Student student2 = new Student("Marry","Public","Mary@luv2code.com");

            course.addStudent(student1);
            course.addStudent(student2);

            session.save(course);

            System.out.println("Saving students");
            session.save(student1);
            session.save(student2);
            System.out.println(student1);
            System.out.println(student2);

            System.out.println(course.getStudents());

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }

}
