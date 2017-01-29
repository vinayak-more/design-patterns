package com.project.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class LoginORM {
	  private static SessionFactory factory; 
	public static boolean validate(String name, String password)
	{
		
		System.out.println("inside validate");
		Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
//		cfg.configure();

	    
	    
	  //Prep work
	    SessionFactory factory = cfg.buildSessionFactory();
	    org.hibernate.Session session = factory.openSession();
         
        org.hibernate.Query query = session.createQuery("from User where username= :username and password= :password");
        query.setString("username", name);
        query.setString("password", password);
        
        User emp = (User) query.uniqueResult();
      if(emp!=null)
		return true;
      else {
    	  return false;
      }
		
	   }
	}



	