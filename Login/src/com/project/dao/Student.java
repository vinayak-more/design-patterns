/**
 * @author Vinayak More
 *
 * @date 29-Jan-2017
 */
package com.project.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id")
    int id;
    @Column(name = "student_name")
    String studentName;
    @Column(name = "email")
    String email;
    @Column(name = "mobile_no")
    String mobileNo;
    @Column(name = "address")
    String address;

    /**
     * @param studentName
     * @param email
     * @param mobileNo
     * @param address
     */
    public Student(String studentName, String email, String mobileNo, String address) {
        super();
        this.studentName = studentName;
        this.email = email;
        this.mobileNo = mobileNo;
        this.address = address;
    }
    

    public Student() {
        super();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}
