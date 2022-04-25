package com.hibernate.demo;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

//            Instructor instructor = new Instructor("chad","Darby","darby@luv2code.com");
//
//            InstructorDetail instructorDetail= new InstructorDetail(
//                    "http://www.luv2code.com/youtube",
//                    "Luv 2 code !!!"
//            );

            Instructor instructor = new Instructor("Madhu","Patel","madhu@luv2code.com");

            InstructorDetail instructorDetail= new InstructorDetail(
                    "http://www.youtube.com",
                    "Guitar"
            );

            instructor.setInstructorDetail(instructorDetail);


            // start a transaction
            session.beginTransaction();

            System.out.println(instructor);
            session.save(instructor);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }

}
