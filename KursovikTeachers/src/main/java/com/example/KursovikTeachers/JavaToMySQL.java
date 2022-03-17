package com.example.KursovikTeachers;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
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
public class JavaToMySQL {

    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/sakila";
    private static final String user = "root";
    private static final String password = "root";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String args[]) {
        String query = "select id, name, subject, EGE2019, EGE2020, EGE2021 from teachers";

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            float EGE2019 = 0;
            float EGE2020 = 0;
            float EGE2021 = 0;
            int id = 0;
            String name = null;
            String subject = null;
            while (rs.next()) {
                id = rs.getInt(1);
                name = rs.getString(2);
                subject = rs.getString(3);
                EGE2019 = rs.getFloat(4);
                EGE2020 = rs.getFloat(5);
                EGE2021 = rs.getFloat(6);
                System.out.printf("id: %d, name: %s, subject: %s %n, EGE2019: %s %n, EGE2020: %s %n, EGE2021: %s %n", id, name, subject, EGE2019, EGE2020, EGE2021, "\n");
            }
            System.out.printf(String.valueOf(EGE2019) + '\n');
            System.out.printf(String.valueOf(EGE2020) + '\n');
            System.out.printf(String.valueOf(EGE2021) + '\n');
            File file2 = new File("D:\\intellij idea\\Projects\\Teacher russian language1.xls");
            // Read XSL file
            FileInputStream inputStream2 = new FileInputStream(file2);

            // Get the workbook instance for XLS file
            HSSFWorkbook workbook2 = new HSSFWorkbook(inputStream2);

            // Get first sheet from the workbook
            HSSFSheet sheet2 = workbook2.getSheetAt(0);
            HSSFCell cell1 = sheet2.getRow(1).getCell(0);
            HSSFCell cell2 = sheet2.getRow(1).getCell(1);
            HSSFCell cell3 = sheet2.getRow(1).getCell(2);
            HSSFCell cell4 = sheet2.getRow(1).getCell(3);
            HSSFCell cell5 = sheet2.getRow(1).getCell(4);
            HSSFCell cell6 = sheet2.getRow(1).getCell(5);
            cell1.setCellValue(cell1.getColumnIndex() + id);
            cell2.setCellValue(cell2.getStringCellValue() + name);
            cell3.setCellValue(cell3.getStringCellValue() + subject);
            cell4.setCellValue(cell4.getNumericCellValue() + EGE2019);
            cell5.setCellValue(cell5.getNumericCellValue() + EGE2020);
            cell6.setCellValue(cell6.getNumericCellValue() + EGE2021);

            inputStream2.close();

            // Write File
            FileOutputStream out2 = new FileOutputStream(file2);
            workbook2.write(out2);
            out2.close();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }

}