package com.example.KursovikTeachers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Simple Java program to connect to MySQL database running on localhost and
 * running SELECT and INSERT query to retrieve and add data.
 * @author Javin Paul
 */
public class JavaToMySQLpast {

    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/sakila";
    private static final String user = "root";
    private static final String password = "root";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String args[]) {

        String query = "INSERT INTO sakila.teachers (id, name, subject, EGE2019, EGE2020, EGE2021) \n" +
                " VALUES (1, 'Alshina A.A.', 'Russian language', 59.66, 63.48, 64.6);";

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            stmt.executeUpdate(query);

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String subject = rs.getString(3);
                float EGE2019 = rs.getFloat(4);
                float EGE2020 = rs.getFloat(5);
                float EGE2021 = rs.getFloat(6);
                System.out.printf("id: %d, name: %s, subject: %s %n, EGE2019: %s %n, EGE2020: %s %n, EGE2021: %s %n", id, name, subject, EGE2019, EGE2020, EGE2021);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }

}