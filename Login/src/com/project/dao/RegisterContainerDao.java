package com.project.dao;

public class RegisterContainerDao {
	boolean status=false;
	
	public boolean isValidName(String name)
	{
		System.out.println("inside isValidName");
		if(name.matches("[a-zA-Z]+( +[a-zA-Z]+)*")) status=true;
		else status=false;
		System.out.println("status="+status);
		return status;
		
	}
	private String name;
	private String username;
	private String email;
	private String password;
	private String dob;
	private String gender;
	///------
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
	public void setDob(String paraDob)
	{
		dob=paraDob;
		System.out.println(dob);
	}
	public String getDob()
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
