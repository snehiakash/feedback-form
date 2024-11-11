package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

public class StateDemo {
public static void main(String[] args) {
	//Practical of Hibernate Object States
	//Transient
	//Persistence
	//Detached
	//Removed
	System.out.println("Example :");
	SessionFactory f= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	//Creating Student Object
	Student student= new Student();
	student.setId(1414);
	student.setName("Peter");
	student.setCity("ABC");
	student.setCerti(new Certificate("Java Hibernate Courses","2 Months"));
	//Student:Transient
	
	Session s=f.openSession();
	Transaction tx=s.beginTransaction();
	s.save(student);
	//Student: Persistence-session,database
	
	tx.commit();
	s.close();
	f.close();
}
}
