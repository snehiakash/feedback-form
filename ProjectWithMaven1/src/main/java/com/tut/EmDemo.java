package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
	    cfg.configure ("hibernate.cfg.xml");
	    SessionFactory factory=cfg.buildSessionFactory();
	    
	    Student student1=new Student();
	   student1.setId(1456);
	   student1.setName("Akash Kumar");
	   student1.setCity("Patna");
	   
	   Certificate certificate=new Certificate();
	  certificate.setCourse("Android");
	  certificate.setDuration("2 Months"); 
	   student1.setCerti(certificate);
	 
	   
	   Student student2=new Student();
	   student2.setId(1856);
	   student2.setName("Srishty Kumari");
	   student2.setCity("Delhi");
	   
	   Certificate certificate1=new Certificate();
		  certificate1.setCourse("Hibernate");
		  certificate1.setDuration("2 Months"); 
		   student2.setCerti(certificate1);
	    Session s=factory.openSession();
	    Transaction tx= s.beginTransaction();
	    //Objects save:
	    s.save(student1);
	    s.save(student2);
	    
	    tx.commit();
	    s.close();
	    factory.close();
	}
	
}
