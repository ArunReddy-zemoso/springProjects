package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false&serverTimezone=UTC";
        String user="hbstudent";
        String password="Arun@1234";

        try {
            System.out.println("connecting to database");

            Connection conn = DriverManager.getConnection(jdbcUrl,user,password);
            System.out.println("connection successful");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
