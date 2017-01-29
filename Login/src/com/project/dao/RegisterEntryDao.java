package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterEntryDao {
	 public  boolean insertData(RegisterContainerDao container) {          
         boolean status = false;  
         Connection conn = null;  
         PreparedStatement pst = null,pst2=null;  
        // ResultSet rs = null;  
   
         String url = "jdbc:mysql://localhost:3306/";  
         String dbName = "form";  
         String driver = "com.mysql.jdbc.Driver";  
         String userName = "root";  
         String password = "infi@123";  
         try {  
             Class.forName(driver).newInstance();  
             conn = DriverManager.getConnection(url + dbName, userName, password);  
   
             pst = conn.prepareStatement("insert into user values(?,?,?,?,STR_TO_DATE(?,'%Y-%m-%d'),?);");  
             pst.setString(1, container.getName());  
             pst.setString(2, container.getUsername());
             pst.setString(3, container.getEmail());
             pst.setString(4, container.getPassword());
             pst.setString(5, container.getDob());
             pst.setString(6, container.getGender());
   System.out.println("query constructed successfully");
              pst.executeUpdate();
              pst2=conn.prepareStatement("insert into login values(?,?);");
              pst2.setString(1, container.getUsername());  
              pst2.setString(2, container.getPassword());
              pst2.executeUpdate();
              status=true;
   
         } catch (Exception e) {  
             System.out.println(e);
             status=false;
         } finally {  
             if (conn != null) {  
                 try {  
                     conn.close();  
                 } catch (SQLException e) {  
                     e.printStackTrace();
                     status=false;
                 }  
             }  
             if (pst != null) {  
                 try {  
                     pst.close();  
                 } catch (SQLException e) {  
                     e.printStackTrace();  
                     status=false;
                 }  
             }  
             /*if (rs != null) {  
                 try {  
                     rs.close();  
                 } catch (SQLException e) {  
                     e.printStackTrace();  
                 }  
             } */ 
         }  
         return status;  
     }  

}
