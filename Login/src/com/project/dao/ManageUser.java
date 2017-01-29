package com.project.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class ManageUser {
	
	public boolean addRow(User user)
	{
		Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
//		cfg.configure();

	    
	    
	    @SuppressWarnings("deprecation")
		SessionFactory factory = cfg.buildSessionFactory();
	    Session session = factory.openSession();
	    
	   Transaction tx = session.beginTransaction();
	    session.save(user);
	    System.out.println("Object saved successfully.....!!");
	    tx.commit();
	    session.close();
	    factory.close();
	    return true;

	}

}
