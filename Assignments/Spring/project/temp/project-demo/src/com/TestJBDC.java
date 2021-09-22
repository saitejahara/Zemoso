package com;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJBDC {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/racing-demo-db?useSSL=false";
        String user="admin";
        String passWord="password";

        try{
            System.out.println("Connecting to mysql "+jdbcURL);

            Connection connection = DriverManager.getConnection(jdbcURL,user,passWord);

            System.out.println("Connection established");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
