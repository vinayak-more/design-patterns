/**
 * @author Vinayak More
 *
 * @date 29-Jan-2017
 */
package com.project.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.jdbc.JDBCTemplate;
import com.project.mail.SendMailTLS;

public class StudentDao {

    public boolean save( Student st) {
        boolean b = true;
        Connection conn = JDBCTemplate.getConnection();
        String str =
                "insert into student (student_name, email, mobile_no, address) " + "values ('" + st.studentName
                        + "','" + st.email + "','" + st.mobileNo + "','" + st.address + "')";
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(str);
            sendSuccessMail(st);
        } catch (SQLException e) {
            e.printStackTrace();
            b = false;
        }
        return b;
    }

    private void sendSuccessMail(final Student st) {
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                SendMailTLS.sendSuccessMail(st);
            }
        }).start();
        
    }

}
