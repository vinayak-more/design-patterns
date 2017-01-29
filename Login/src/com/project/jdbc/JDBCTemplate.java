/**
 * @author Vinayak More
 *
 * @date 29-Jan-2017
 */
package com.project.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTemplate {
    static Connection conn = null;

    static String url = "jdbc:mysql://localhost:3306/";
    static String dbName = "form";
    static String driver = "com.mysql.jdbc.Driver";
    static String userName = "root";
    static String password = "infi@123";


    public static Connection getConnection() {
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(conn==null){
            throw new RuntimeException("Databace Connection Failed");
        }
        return conn;
    }
}
