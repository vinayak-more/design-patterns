package com.project.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class LoginAnnotation {
	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	//----
	public void setUsername(String paraUsername)
	{
		username=paraUsername;
	}
	public String getUsername()
	{
		return username;
	}
	//----
	
	public void setPassword(String paraPassword)
	{
		password=paraPassword;
	}
	public String getPassword()
	{
		return password;
	}
	

}
