package com.project.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="user")
public class User 
{
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="username")
	private String username;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="dob")
	private java.util.Date dob;
	
	@Column(name="gender")
	private String gender;
	
	public void setName(String paraName)
		{
			name=paraName;
		}
	public String getName()
		{
			return name;
		}
		///-----
	public void setUsername(String paraUsername)
		{
			username=paraUsername;
		}
	public String getUsername()
		{
			return username;
		}
		////---------
	public void setEmail(String paraEmail)
		{
			email=paraEmail;
		}
	public String getEmail()
		{
			return email;
		}
		////-----
		
	public void setPassword(String paraPassword)
		{
			password=paraPassword;
		}
	public String getPassword()
		{
			return password;
		}
		///------
	public void setDob(Date paraDob)
		{
			dob=paraDob;
			System.out.println(dob);
		}
	public Date getDob()
		{
			return dob;
		}
		///-------
	public void setGender(String paraGender)
		{
			gender=paraGender;
		}
	public String getGender()
		{
			return gender;
		}
		///---------
	
	
	
	
	
}
